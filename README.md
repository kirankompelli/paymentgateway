# 💸 Fintech Payment Gateway System

A secure and modular Spring Boot-based Fintech Payment Gateway system, inspired by M2P, enabling users to register, link accounts or cards, perform transactions, and view history.

---

## 🚀 Features

- ✅ User registration and login with JWT authentication
- 🔐 Password encryption using BCrypt
- 🔗 Link accounts or cards
- 💳 Perform transactions (upcoming)
- 🧾 View transaction history (upcoming)
- 🔄 OTP verification (planned)
- ⚙️ Rate-limiting, circuit breakers (planned)

---

## 🧰 Tech Stack

| Layer            | Tech Used                         |
|------------------|-----------------------------------|
| Language         | Java 17                           |
| Framework        | Spring Boot 3.1.4                 |
| Security         | Spring Security, JWT              |
| Database         | MySQL                             |
| ORM              | Spring Data JPA, Hibernate        |
| Build Tool       | Maven                             |
| Logging          | SLF4J / Logback                   |
| Version Control  | Git, GitHub                       |
| Optional Tools   | Redis, Kafka, Resilience4j        |

---

## 📁 Project Modules

| Module     | Description                            |
|------------|----------------------------------------|
| `auth`     | User registration, login, JWT security |
| `accounts` | Link and manage bank/card accounts     |
| `transactions` | Perform and record transactions    |
| `otp`      | Send and verify OTP (via Redis, optional) |
| `logs`     | Centralized logs (planned)             |
| `limits`   | Set transaction limits per user        |

---

## 🛠️ Setup & Run Locally

### 🔧 Prerequisites

- Java 17+
- Maven
- MySQL (running locally)
- Git

### 🚀 Running the App

```bash
# Clone the repo
git clone https://github.com/your-username/fintech-payment-gateway.git
cd fintech-payment-gateway

# Run the app
./mvnw spring-boot:run
