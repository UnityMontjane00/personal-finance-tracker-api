# Personal Finance Tracker API

A full-stack Personal Finance Tracker application built using Java Spring Boot, PostgreSQL, HTML, CSS, and JavaScript.

## Features

* Add income and expense transactions
* View transaction history
* Delete transactions
* Real-time balance calculation
* Dashboard summary cards
* Income and expense badges
* PostgreSQL database integration
* RESTful API architecture
* Responsive web interface

## Technologies Used

### Backend

* Java 17
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven

### Frontend

* HTML5
* CSS3
* JavaScript (ES6)

## Screenshots

### Dashboard

![Dashboard](images/dashboard.png)

### Transactions

![Transactions](images/transactions.png)

### Add Transaction

![Add Transaction](images/add-transaction.png)

## API Endpoints

| Method | Endpoint           | Description                |
| ------ | ------------------ | -------------------------- |
| GET    | /transactions      | Retrieve all transactions  |
| GET    | /transactions/{id} | Retrieve transaction by ID |
| POST   | /transactions      | Create a transaction       |
| DELETE | /transactions/{id} | Delete transaction         |

## Project Structure

src/main/java

* controller
* service
* repository
* exception
* entity

src/main/resources

* static

    * css
    * js
    * index.html

## Future Enhancements

* Update/Edit transactions
* Category filtering
* Monthly reports
* Spending analytics
* Charts and visualizations
* User authentication



