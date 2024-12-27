package com.sreshtha.chat_support.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sreshtha.chat_support.constants.ApplicationConstants;
import com.sreshtha.chat_support.model.*;
import com.sreshtha.chat_support.repository.ChatRepository;
import com.sreshtha.chat_support.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@Service
public class ChatSupportService {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoresService scoresService;

    private final Gson gson = new Gson();



    /**
     * Calculates the sentiment score for a given chat and saves it.
     *
     * @param chat The chat object containing messages.
     * @return The calculated sentiment score.
     */
    public double calculateAndSaveScore(Chat chat) {
        String chatId = chat.getId();
        List<Message> messages = chat.getMessages();

        RestTemplate restTemplate = new RestTemplate();
        String flaskUrl = ApplicationConstants.PREDICTOR_BASE_URL + "/predict";

        try {

            JsonArray messagesArray = new JsonArray();
            for (Message message : messages) {
                JsonObject messageJson = new JsonObject();
                messageJson.addProperty("content", message.getContent());
                messagesArray.add(messageJson);
            }

            JsonObject requestBody = new JsonObject();
            requestBody.add("messages", messagesArray);

            // Prepare HTTP request
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(gson.toJson(requestBody), headers);

            // Send the request and get the response
            ResponseEntity<String> response = restTemplate.postForEntity(flaskUrl, entity, String.class);
            Gson gson = new Gson();

            // Parse the JSON response
            SentimentResponse sentimentResponse = gson.fromJson(response.getBody(), SentimentResponse.class);
            // Extract the average sentiment value
            double averageSentiment = sentimentResponse.getAverageSentiment();
            Score score = new Score(chatId, averageSentiment);
            scoresService.saveScore(score);
            return averageSentiment;

        } catch (Exception e) {
            System.out.println("Failed to calculate or save score: " + e.getMessage());
            return (double) 0;
        }
    }


    /**
     * Saves a chat and calculates its sentiment score. Updates the scores of the agent and customer involved in the chat.
     *
     * @param chat The chat object to be saved.
     * @return A message indicating the result of the save operation.
     */
    public String saveChat(Chat chat) {
        try {
            chatRepository.save(chat);
            double score = calculateAndSaveScore(chat);
            // Save or update agent
            Optional<User> existingAgent = userRepository.findById(chat.getAgentId());
            if (existingAgent.isPresent()) {
                User agent = existingAgent.get();
                agent.setScore((agent.getScore() + score) / 2);
                userRepository.save(agent);
            } else {
                User agent = new User(chat.getAgentId(), chat.getAgentName(), Role.AGENT, score);
                userRepository.save(agent);
            }

            Optional<User> existingCustomer = userRepository.findById(chat.getCustomerId());
            if (existingCustomer.isPresent()) {
                User customer = existingCustomer.get();
                customer.setScore((customer.getScore() + score) / 2);
                userRepository.save(customer);
            } else {
                User customer = new User(chat.getCustomerId(), chat.getCustomerName(), Role.CUSTOMER, score);
                userRepository.save(customer);
            }
            return "Chat saved successfully with score: " + score;

        } catch (Exception e) {
            return "Failed to save chat: " + e.getMessage();
        }
    }
}