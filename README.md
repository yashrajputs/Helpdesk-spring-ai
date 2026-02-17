# Helpdesk-spring-ai

An AI-powered Help Desk Backend application built with Spring Boot and Spring AI. This application provides an intelligent helpdesk assistant that can create, track, and manage support tickets while interacting with users in a natural, conversational manner.

## 🚀 Features

- **AI-Powered Assistant**: "Sam" - A polite and professional helpdesk assistant that interacts with users
- **Ticket Management**: Create, update, and track support tickets
- **Smart Ticket Handling**: Checks for existing tickets before creating duplicates
- **Email Notifications**: Automatically notifies support team when new tickets are created
- **Conversation Memory**: Maintains context across conversations using conversation IDs
- **Streaming Responses**: Supports both regular and streaming AI responses
- **Multi-category Support**: Handles technical, account, hardware, and software issues

## 🛠️ Technology Stack

- **Framework**: Spring Boot 4.0.2
- **AI Framework**: Spring AI 2.0.0-M2
- **Database**: MySQL
- **AI Model**: OpenAI GPT via Groq API (openai/gpt-oss-20b)
- **Build Tool**: Maven
- **Java Version**: 24
- **Additional**: Lombok for reducing boilerplate code

## 📁 Project Structure

```
helpdesk/
├── src/main/
│   ├── java/com/substirng/helpdesk/
│   │   ├── HelpDeskBackendApplication.java    # Main application entry point
│   │   ├── Controller/
│   │   │   └── AiController.java               # REST API controller
│   │   ├── Service/
│   │   │   ├── AIService.java                  # AI service with ChatClient
│   │   │   └── TicketService.java              # Ticket CRUD operations
│   │   ├── entity/
│   │   │   ├── Ticket.java                     # Ticket entity
│   │   │   ├── Priority.java                   # Priority enum (LOW, MEDIUM, HIGH, URGENT)
│   │   │   └── Status.java                     # Status enum (OPEN, CLOSED, RESOLVED)
│   │   ├── repository/
│   │   │   └── TicketRepository.java           # JPA repository for tickets
│   │   ├── tools/
│   │   │   ├── TicketDatabaseTool.java         # AI tool for database operations
│   │   │   └── EmailTool.java                  # AI tool for email notifications
│   │   └── config/
│   │       └── AiConfig.java                   # AI configuration
│   └── resources/
│       ├── application.yml                      # Application configuration
│       └── helpdesk-system.st                  # AI system prompt
└── pom.xml                                      # Maven dependencies
```

## 📋 Prerequisites

- Java 24 or higher
- Maven 3.6+
- MySQL 8.0+
- Groq API Key (set as environment variable `GROQ_API_KEY`)

## ⚙️ Configuration

The application is configured via `src/main/resources/application.yml`:

```
yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/helpdesk
    username: root
    password: your_password
  ai:
    openai:
      base-url: https://api.groq.com/openai
      api-key: ${GROQ_API_KEY}
      chat:
        options:
          model: openai/gpt-oss-20b

server:
  port: 8081
```

## 🔌 API Endpoints

### Base URL
```
http://localhost:8081/api/v1/helpdesk
```

### Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/helpdesk` | Get AI response (synchronous) |
| POST | `/helpdesk/stream` | Get AI response (streaming) |

### Request Headers
- `ConversationId`: Unique identifier for maintaining conversation context

### Request Body
- Plain text string containing the user's query

### Example Request

```
bash
curl -X POST http://localhost:8081/api/v1/helpdesk \
  -H "Content-Type: text/plain" \
  -H "ConversationId: user123" \
  -d "I need help with my email not syncing"
```

## 🤖 AI Assistant Capabilities

The AI Assistant "Sam" can:

1. **Greet Users**: Always welcomes users with a friendly greeting
2. **Understand Issues**: Identifies issue categories (technical, account, hardware, software)
3. **Check Existing Tickets**: Prevents duplicate tickets by checking for existing ones
4. **Create Tickets**: Generates tickets with:
   - Summary (auto-generated)
   - Description (auto-generated)
   - Priority (LOW, MEDIUM, HIGH, URGENT)
   - Category
   - Status (OPEN, CLOSED, RESOLVED)
   - Email (collected from user)
5. **Update Tickets**: Adds new information to existing tickets
6. **Provide Solutions**: Offers troubleshooting steps or escalation guidance
7. **Send Emails**: Notifies support team when new tickets are created

## 🏃‍♂️ Running the Application

1. **Clone the repository**
2. **Set up MySQL database**: Create a database named `helpdesk`
3. **Configure API key**: Set the `GROQ_API_KEY` environment variable
4. **Build and run**:
   
```
bash
   ./mvnw spring-boot:run
   
```
5. **Access the API**: The server runs on `http://localhost:8081`

## 📝 Ticket Fields

| Field | Type | Description |
|-------|------|-------------|
| id | Long | Auto-generated ticket ID |
| summary | String | Brief description of the issue |
| description | String | Detailed explanation |
| email | String | User's email address |
| priority | Enum | LOW, MEDIUM, HIGH, URGENT |
| status | Enum | OPEN, CLOSED, RESOLVED |
| category | String | Issue category |
| createdAt | DateTime | Creation timestamp |
| updatedAt | DateTime | Last update timestamp |

## 🔧 Available Tools for AI

The AI assistant has access to the following tools:

1. **createTicketTool**: Creates new tickets in the database
2. **getTicketByEmail**: Retrieves tickets by user email
3. **updateTicket**: Updates existing tickets
4. **getCurrentTime**: Gets current system time
5. **sendEmailToSupportTeam**: Sends email notifications to support team

## 📄 License

This project is for educational and demonstration purposes.
