package com.sreshtha.chat_support.service;

import com.sreshtha.chat_support.model.Role;
import com.sreshtha.chat_support.model.User;
import com.sreshtha.chat_support.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Retrieves the score of a user by their ID.
     *
     * @param userId The ID of the user.
     * @return The score of the user, or -1 if not found.
     */
    public double getUserScore(String userId) {
        if(userRepository.findById(userId).isPresent()) {
            return userRepository.findById(userId).get().getScore();
        }
        else{
            return -1;
        }
    }

    /**
     * Retrieves a list of users with the role of AGENT.
     *
     * @return A list of users with the role of AGENT.
     */
    public List<User> getAgentScores() {
        return userRepository.findAll().stream()
                .filter(user -> user.getRole().equals(Role.AGENT))
                .collect(Collectors.toList());
    }


    /**
     * Retrieves a list of users with the role of CUSTOMER.
     *
     * @return A list of users with the role of CUSTOMER.
     */
    public List<User> getCustomerScores(){
        return userRepository.findAll().stream()
                .filter(user -> user.getRole().equals(Role.CUSTOMER))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves the user with the highest score among agents.
     *
     * @return The user with the highest score among agents, or null if not found.
     */
    public User getBestAgent() {
        return userRepository.findAll().stream()
                .filter(user -> user.getRole().equals(Role.AGENT))
                .max((u1, u2) -> Double.compare(u1.getScore(), u2.getScore()))
                .orElse(null);
    }


    /**
     * Retrieves the user with the lowest score among agents.
     *
     * @return The user with the lowest score among agents, or null if not found.
     */
    public User getWorstAgent() {
        return userRepository.findAll().stream()
                .filter(user -> user.getRole().equals(Role.AGENT))
                .min((u1, u2) -> Double.compare(u1.getScore(), u2.getScore()))
                .orElse(null);
    }


    /**
     * Retrieves a list of agents sorted by their scores in the specified order.
     *
     * @param order The order to sort the scores (asc or desc).
     * @param limit The maximum number of agents to return.
     * @return A list of agents sorted by their scores.
     */
    public List<User> getAgentsByScore(String order, int limit) {
        return userRepository.findAll().stream()
                .filter(user -> user.getRole().equals(Role.AGENT))
                .sorted((u1, u2) -> order.equals("asc") ? Double.compare(u1.getScore(), u2.getScore()) : Double.compare(u2.getScore(), u1.getScore()))
                .limit(limit)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a list of customers sorted by their scores in the specified order.
     *
     * @param order The order to sort the scores (asc or desc).
     * @param limit The maximum number of customers to return.
     * @return A list of customers sorted by their scores.
     */
    public List<User> getCustomerByScore(String order, int limit){
        return userRepository.findAll().stream()
                .filter(user -> user.getRole().equals(Role.CUSTOMER))
                .sorted((u1, u2) -> order.equals("asc") ? Double.compare(u1.getScore(), u2.getScore()) : Double.compare(u2.getScore(), u1.getScore()))
                .limit(limit)
                .collect(Collectors.toList());
    }

}
