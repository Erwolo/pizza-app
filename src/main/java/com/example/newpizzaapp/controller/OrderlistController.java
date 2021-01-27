package com.example.newpizzaapp.controller;

import com.example.newpizzaapp.model.FoodOrderDetail;
import com.example.newpizzaapp.model.MyAuthenticationUtil;
import com.example.newpizzaapp.services.FoodOrderDetailService;
import com.example.newpizzaapp.services.OrderService;
import com.example.newpizzaapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderlistController {

    private final OrderService orderService;
    private final FoodOrderDetailService foodOrderDetailService;
    private final UserService userService;

    public OrderlistController(OrderService orderService, FoodOrderDetailService foodOrderDetailService, UserService userService) {
        this.orderService = orderService;
        this.foodOrderDetailService = foodOrderDetailService;
        this.userService = userService;
    }


    @GetMapping("/orderlist")
    public String getOrderlistView(Model model, Authentication authentication) {
        MyAuthenticationUtil.addToModelAuthDetails(model, authentication);

        model.addAttribute("orders", orderService.getAllOrders());


        return "orderlist";
    }


}
