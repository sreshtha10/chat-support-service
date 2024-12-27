package com.sreshtha.chat_support.controller;

import com.sreshtha.chat_support.model.User;
import com.sreshtha.chat_support.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/health")
    public String health() {
        return "User Service is up and running";
    }

    @GetMapping("/agent-score")
    public double getAgentScore(@RequestParam String agentId) {
        return userService.getUserScore(agentId);
    }

    @GetMapping("/customer-score")
    public double getCustomerScore(@RequestParam String customerId) {
        return userService.getUserScore(customerId);
    }

    @GetMapping("/agent-scores")
    public List<User> getAgentScores() {
        return userService.getAgentScores();
    }

    @GetMapping("/customer-scores")
    public List<User> getCustomerScores() {
        return userService.getCustomerScores();
    }

    @GetMapping("/best-agent")
    public User getBestAgent() {
        return userService.getBestAgent();
    }

    @GetMapping("/worst-agent")
    public User getWorstAgent() {
        return userService.getWorstAgent();
    }

    @GetMapping("/agents-by-score")
    public List<User> getAgentsByScore(@RequestParam String order, @RequestParam int limit) {
        return userService.getAgentsByScore(order, limit);
    }

    @GetMapping("/customers-by-score")
    public List<User> getCustomersByScore(@RequestParam String order, @RequestParam int limit) {
        return userService.getCustomerByScore(order, limit);
    }


}
