package com.sreshtha.chat_support.repository;

import com.sreshtha.chat_support.model.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends MongoRepository<Chat,String> {

}