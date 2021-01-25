package com.example.newpizzaapp.controller;

import com.example.newpizzaapp.model.CartItem;
import com.example.newpizzaapp.model.FoodOrderDetail;
import com.example.newpizzaapp.model.Order;
import com.example.newpizzaapp.model.User;
import com.example.newpizzaapp.services.FoodOrderDetailService;
import com.example.newpizzaapp.services.OrderService;
import com.example.newpizzaapp.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ConfirmOrderController {

    Logger log = LoggerFactory.getLogger(ConfirmOrderController.class);


    private final OrderController orderController;
    private final FoodOrderDetailService foodOrderDetailService;
    private final OrderService orderService;
    private final UserService userService;

    public ConfirmOrderController(OrderController orderController, OrderService orderService, FoodOrderDetailService foodOrderDetailService, UserService userService) {
        this.orderController = orderController;
        this.orderService = orderService;
        this.foodOrderDetailService = foodOrderDetailService;
        this.userService = userService;
    }

    @GetMapping("/confirmorder")
    public String getConfirmView(Model model) {
        model.addAttribute("cart", orderController.getShoppingCart());

        return "confirmorder";
    }

    @PostMapping("/checkout")
    public String makeOrder(Authentication authentication) {
        List<CartItem> cart = orderController.getShoppingCart();
        List<FoodOrderDetail> cartItems = new ArrayList<>();
        Order finalOrder = new Order();

        cart.forEach(e -> cartItems.add(new FoodOrderDetail(e.getFood(), e.getQuantity())));
        cartItems.forEach(e -> {
            FoodOrderDetail tmpFOD = foodOrderDetailService.saveCartPositionGetObj(e);
            finalOrder.getItemsOrdered().add(tmpFOD);
        });

        if (authentication != null) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            User user = userService.getUserByLogin(userDetails.getUsername());
            finalOrder.setUser(user);

        }
        else {
            finalOrder.setUser(null);
        }
        orderService.saveOrder(finalOrder);

        log.info("Utworzono zamowienie " + finalOrder.toString());


        orderController.getShoppingCart().clear();

        return "redirect:/confirmorder";
    }

}
