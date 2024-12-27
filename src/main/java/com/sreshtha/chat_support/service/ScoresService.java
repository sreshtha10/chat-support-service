package com.sreshtha.chat_support.service;

import com.sreshtha.chat_support.model.Score;
import com.sreshtha.chat_support.repository.ScoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoresService {

    @Autowired
    private ScoresRepository scoresRepository;


    /**
     * Saves the given score to the repository.
     *
     * @param score The score object to be saved.
     */
    public void saveScore(Score score) {
        scoresRepository.save(score);
    }


    /**
     * Retrieves the score for a given chat ID.
     *
     * @param chatId The ID of the chat.
     * @return The score of the chat, or -1 if not found.
     */
    public double getChatScore(String chatId) {
        if(scoresRepository.findByChatId(chatId).isPresent()) {
            return scoresRepository.findByChatId(chatId).get().getScore();
        }
        else{
            return -1;
        }
    }
}