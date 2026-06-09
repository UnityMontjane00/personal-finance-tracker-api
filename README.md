# Personal Finance Tracker API

## Overview

Personal Finance Tracker API is a Spring Boot REST application that helps users manage financial transactions, track income and expenses, and monitor their account balance.

The application follows a layered architecture using Controller, Service, Repository, and Entity components, with data persisted in PostgreSQL using Spring Data JPA.

---

## Features

### Transaction Management

* Create a transaction
* View all transactions
* View a transaction by ID
* Update a transaction
* Delete a transaction

### Financial Analytics

* Calculate total income
* Calculate total expenses
* Calculate current balance

### Transaction Filtering

* Filter transactions by category

---

## Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven
* Postman
* Git & GitHub

---

## Project Structure

src/main/java

├── controller

│   └── TransactionController

├── service

│   └── TransactionService

├── repository

│   └── TransactionRepository

├── entity

│   └── Transaction

└── FinanceTrackerApplication

---

## API Endpoints

| Method | Endpoint                          | Description           |
| ------ | --------------------------------- | --------------------- |
| POST   | /transactions                     | Create transaction    |
| GET    | /transactions                     | Get all transactions  |
| GET    | /transactions/{id}                | Get transaction by ID |
| PUT    | /transactions/{id}                | Update transaction    |
| DELETE | /transactions/{id}                | Delete transaction    |
| GET    | /transactions/income              | Get total income      |
| GET    | /transactions/expenses            | Get total expenses    |
| GET    | /transactions/balance             | Get current balance   |
| GET    | /transactions/category/{category} | Filter by category    |

---

## Sample Transaction

```json
{
  "description": "Salary",
  "amount": 15000,
  "category": "Income",
  "type": "INCOME",
  "transactionDate": "2025-06-09"
}
```

---

## How to Run

1. Clone the repository

```bash
git clone https://github.com/UnityMontjane00/personal-finance-tracker-api.git
```

2. Create a PostgreSQL database

```sql
CREATE DATABASE finance_db;
```

3. Configure database settings in application.properties

4. Run the Spring Boot application

5. Test endpoints using Postman

---

## Key Concepts Demonstrated

* REST API Development
* Spring Boot
* Layered Architecture
* CRUD Operations
* Spring Data JPA
* PostgreSQL Integration
* Java Streams
* Business Logic Implementation
* Git Version Control

---

## Author

Unity Montjane
Software developer and data Analyst

Aspiring Software Developer and Data Analyst
