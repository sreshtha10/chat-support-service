package com.sreshtha.chat_support.repository;

import com.sreshtha.chat_support.model.Score;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ScoresRepository extends MongoRepository<Score,String> {
    Optional<Score> findByChatId(String chatId);
}
