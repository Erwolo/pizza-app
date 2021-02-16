package com.example.newpizzaapp.controller;


import com.example.newpizzaapp.model.*;
import com.example.newpizzaapp.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Controller
public class CartController {

    Logger log = LoggerFactory.getLogger(CartController.class);

    private final FoodService foodService;
    private final OrderController orderController;
    private final FoodOrderDetailService foodOrderDetailService;
    private final OrderService orderService;
    private final UserService userService;
    private final UserAddressService userAddressService;

    public CartController
            (
                    OrderController orderController,
                    OrderService orderService,
                    FoodOrderDetailService foodOrderDetailService,
                    UserService userService,
                    FoodService foodService,
                    UserAddressService userAddressService
            ) {
        this.orderController = orderController;
        this.orderService = orderService;
        this.foodOrderDetailService = foodOrderDetailService;
        this.userService = userService;
        this.foodService = foodService;
        this.userAddressService = userAddressService;
    }

    @GetMapping("/confirmorder")
    public String getConfirmView(Model model, Authentication authentication) {
        MyAuthenticationUtil.addToModelAuthDetails(model, authentication);
        model.addAttribute("cart", orderController.getShoppingCart());
        model.addAttribute("cartTotal", orderController.getCartTotal());
        model.addAttribute("isAddressesEmpty", false);
        if (authentication != null) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            List<UserAddress> userAddresses = userAddressService.getUserAdresses(userDetails.getUsername());
            if (userAddresses.isEmpty()) {
                model.addAttribute("isAddressesEmpty", true);
            }
            else {
                model.addAttribute("userAddresses",userAddresses);
            }
        }
        else {
            model.addAttribute("isAddressesEmpty", true);
        }


        return "cart";
    }

    @PostMapping("/change-in-cart-quantity")
    public String changeFoodQuantity(@RequestParam("id") Long id, @RequestParam("newQuantity") Integer newQuantity) {
        Food tmpFood = foodService.getFoodById(id);
        orderController.setInCartItemQuant(tmpFood, newQuantity);
        return "redirect:/confirmorder";
    }

    @PostMapping("/remove-from-cart")
    public String removeItemFromCart(@RequestParam("id") Long id) {
        orderController.removeItemFromCart(foodService.getFoodById(id));
        return "redirect:/confirmorder";
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


        finalOrder.setOrderTotal(orderController.getCartTotal());
        finalOrder.setOrderDate(new Timestamp(System.currentTimeMillis()));
        orderService.saveOrder(finalOrder);

        log.info("Utworzono zamowienie " + finalOrder.toString());
        orderController.getShoppingCart().clear();

        return "redirect:/";
    }


}
