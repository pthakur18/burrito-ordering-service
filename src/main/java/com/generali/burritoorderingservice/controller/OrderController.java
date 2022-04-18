package com.generali.burritoorderingservice.controller;

import com.generali.burritoorderingservice.security.JwtRequest;
import com.generali.burritoorderingservice.security.JwtResponse;
import com.generali.burritoorderingservice.model.Order;
import com.generali.burritoorderingservice.service.OrderService;
import com.generali.burritoorderingservice.service.impl.UserService;
import com.generali.burritoorderingservice.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest Controller for ordering system
 */
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    /**
     * Get order
     * @param id
     * @return
     */
    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable long id){
        return ResponseEntity.ok().body(orderService.getOrder(id));
    }

    /**
     * Save order
     * @param order
     * @return
     */
    @PostMapping("/orders")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {

        Order savedOrder = orderService.saveOrder(order);
        return ResponseEntity.ok().body(orderService.saveOrder(savedOrder));
    }

    /**
     * Save order
     * @return
     */
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {

        return ResponseEntity.ok().body(orderService.getAllOrders());
    }

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );

        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails
                = userService.loadUserByUsername(jwtRequest.getUsername());

        final String token =
                jwtUtility.generateToken(userDetails);

        return  new JwtResponse(token);
    }
}
