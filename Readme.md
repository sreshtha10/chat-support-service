# Chat Support Service

This project is a Chat Support Service built using Java and Spring Boot. It provides various functionalities to manage and analyze chat interactions between agents and customers. The main features include:

## Features

1. **User Management**:
    - Retrieve user scores by their ID.
    - Retrieve lists of agents and customers with their scores.
    - Retrieve the best and worst performing agents based on their scores.
    - Retrieve agents and customers sorted by their scores.

2. **Chat Management**:
    - Save chat interactions and calculate sentiment scores for the chats.
    - Update the scores of agents and customers based on chat sentiment analysis.

3. **Sentiment Analysis**:
    - Calculate sentiment scores for chat messages using an external sentiment analysis service.

## Endpoints

### User Endpoints
- **GET /api/v1/user/health**: Check if the User Service is running.
- **GET /api/v1/user/agent-score**: Get the score of a specific agent.
- **GET /api/v1/user/customer-score**: Get the score of a specific customer.
- **GET /api/v1/user/agent-scores**: Get scores of all agents.
- **GET /api/v1/user/customer-scores**: Get scores of all customers.
- **GET /api/v1/user/best-agent**: Get the agent with the highest score.
- **GET /api/v1/user/worst-agent**: Get the agent with the lowest score.
- **GET /api/v1/user/agents-by-score**: Get agents sorted by their scores.

### Chat Endpoints
- **POST /api/v1/chat/save**: Save a chat and calculate its sentiment score.

## Technologies Used
- Java
- Spring Boot
- Maven
- MongoDB

## Setup and Running
1. Clone the repository.
2. Navigate to the project directory.
3. Run `mvn clean install` to build the project.
4. Run `mvn spring-boot:run` to start the application.

## Configuration
- Configure the MongoDB connection and external sentiment analysis service URL in the `application.properties` file.

## Sentiment Analysis Integration
This service uses a pre-trained BERT model for sentiment analysis via a Flask API provided by the [Chat Support Sentiment Analysis](https://github.com/sreshtha10/chat-support-sentiment-analysis) project. Ensure that the Flask service is running and accessible to this application for sentiment analysis functionality.

## License
This project is licensed under the MIT License.
