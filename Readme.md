# 🍔 Online Food Ordering System (Console Based)

## 📖 Project Overview

The **Online Food Ordering System** is a Java console-based application that allows customers to register, browse food items, place orders, manage their cart, generate bills, and view order history.

The project is being developed in a **feature-by-feature** approach using clean architecture and Object-Oriented Programming (OOP) principles.

Initially, the application stores data using Java Collections (`ArrayList`). Later, the same project will be integrated with **MySQL using JDBC** without changing the application flow.

---

# 🚀 Technologies Used

* Java 17+
* Java Collections (ArrayList)
* OOP Concepts
* Exception Handling
* MySQL 
* JDBC
* IntelliJ IDEA
* Git & GitHub

---

# 📁 Project Structure

```text
OnlineFoodOrderingSystem
│
├── model
       Customer.java
│      FoodItem.java
       OrderItem.java 
       Order.java
├── controller
│   CustomerController.java
    FoodController.java
    OrderController.java
    OrderHistoryController.java
    
├── service
│     ├── serviceconsole
            CustomerService.java
│           FoodService.java
            OrderService.java
            OrderHistoryService.java            
│     └── servicedb
│           CustomerServiceDB.java
            FoodServiceDB.java
            OrderServiceDB.java
├── repository
│     ├── repositoryconsole
            CustomerRepository.java
│      │    FoodRepository.java
            OrderRepository.java
            OrderHistoryRepository.java
│     └── repositorydb
│           CustomerRepository.java
            FoodRepositoryDB.java
            OrderRepositoryDB.java
├── util
       Validation.java
       DBConnection.java
│
└── main
    Main.java
```

---

# 🏗 Architecture

```text
Main
   │
   ▼
   Controller
   │
   ▼
   Service
   │
   ▼
   Repository
   │
   ▼
ArrayList
```

```text
ArrayList
     │
     ▼
MySQL Database (JDBC)
```

---

# ✅ Features

## Customer Management

* Customer Registration
* Login using Email and Password
* View Customer Profile
* Duplicate Email Check
* Name Validation
* Email Validation
* Mobile Number Validation
* Password Validation
* Clean Layered Architecture

## Food Items Management

* Display All Food Items
* Search Food By Name
* Filter Food By Category

## Order Management

* Add Food To Cart
* Update Quantity
* Remove Item
* View Cart

## Billing

* Calculate Total Amount
* Apply GST
* Generate Bill
* Order Summary

## Order History

* View Order History
* Search Order By ID
---

### Food Menu

Completed Components
* FoodItem Model
* Food Repository
* Food Service
* Food Controller


## 🗄 Database

Database Name

food_ordering_system

Tables

* customers
* food_items
* orders
* order_items


## 💾 Database (JDBC)

* Customer Registration
* Customer Login
* Save Orders
* Save Order Items
* View Previous Orders
* Search Orders

---

# 🗄 Database Tables

## customers

| Column      | Type    |
| ----------- | ------- |
| customer_id | INT     |
| name        | VARCHAR |
| email       | VARCHAR |
| mobile      | VARCHAR |
| password    | VARCHAR |

---

## food_items

| Column    | Type    |
| --------- | ------- |
| food_id   | INT     |
| food_name | VARCHAR |
| category  | VARCHAR |
| price     | DOUBLE  |
| available | BOOLEAN |

---

## orders

| Column       | Type   |
| ------------ | ------ |
| order_id     | INT    |
| customer_id  | INT    |
| order_date   | DATE   |
| total_amount | DOUBLE |

---

## order_items

| Column        | Type   |
| ------------- | ------ |
| order_item_id | INT    |
| order_id      | INT    |
| food_id       | INT    |
| quantity      | INT    |
| subtotal      | DOUBLE |

---


## 🔌 JDBC Connection

* MySQL Connector Added
* Database Connection Utility Created
* Connection Successfully Tested

## 🔄 JDBC Progress

### Customer Module

* JDBC Connection ✅
* Customer Registration (Database) ✅
* PreparedStatement Used ✅

### Customer JDBC Module

* Customer Registration ✅
* Customer Login ✅

### Food JDBC Module

* Display All Food Items ✅
* Search Food By Name ✅
* Filter Food By Category ✅


# 🎯 OOP Concepts Used

* Class & Object
* Encapsulation
* Constructor
* Method Overloading (If Required)
* Collections
* Layered Architecture

---

# ▶ Current Menu

```text
=====================================
 ONLINE FOOD ORDERING SYSTEM
=====================================

0. Exit
1. Register Customer
2. Login
3. View Profile
4. Display All FoodItems
5. Search Food By Name
6. Filter Food By Category
7. Add Food Item To Cart
8. Update Item Quantity
9. Remove Item From Cart
10. View Cart
11. Calculate Total Amount
12. Apply GST (5%)
13. Generate Final Bill
 14. Display Order Summary
 15. View Previous Orders
 16. Search Order By Order ID

```

---

# ⚙ How to Run

### Clone Repository

```bash
git clone <YOUR_GITHUB_REPOSITORY_LINK>
```

### Open Project

Open the project using **IntelliJ IDEA**.

### Configure Database

* Install MySQL
* Create Database
* Execute **FoodOrderingSystem.sql**

### Update Database Credentials

Edit `DBConnection.java`

```java
URL
USERNAME
PASSWORD
```

### Run Project

Execute:

```text
main.java
```

---

# 🧪 Sample Workflow

```text
Register Customer

↓

Login

↓

Display Food Menu

↓

Add Food To Cart

↓

View Cart

↓

Generate Final Bill

↓

Order Saved In MySQL

↓

View Previous Orders
```

---

# 📸 Screenshots

Add screenshots of:

* Home Menu
* Customer Registration
* Customer Login
* Food Menu
* Cart
* Final Bill
* Order Summary
* Previous Orders
* MySQL Customers Table
* MySQL Orders Table
* MySQL Order Items Table

---

# 🚀 Future Enhancements

* Admin Panel
* Discount Coupons
* Payment Gateway
* Print Bill to PDF
* File Logging
* GUI Version
* Web Application
* Mobile Application

---

# 📚 Learning Outcomes

This project helped in understanding:

* Java Programming
* Object-Oriented Programming
* Layered Architecture
* Collections Framework
* Exception Handling
* JDBC
* MySQL
* Git & GitHub
* Clean Code Practices

---

# 📌 Development Strategy

This project is developed incrementally.

Each module follows the process below:

1. Design
2. Coding
3. Compilation
4. Testing
5. Commit
6. README Update
7. Next Module

This ensures that every feature is fully tested before moving to the next feature.

---

# 📦 Deliverables

* Java Source Code
* MySQL SQL Script
* README.md
* GitHub Repository
* Screenshots

# 👨‍💻 Author

**Nikhil Lilhare**

Java Full Stack Developer

GitHub Repository:

**https://github.com/Nikhillilhare/Online-Food-Management-System-Console**

---

# ⭐ Version

**Version : 1.0**

# 📊 Project Progress

| Module              | Status |
|---------------------|--------|
| Customer Management | ✅ Completed |
| Food Menu           | ✅ Completed |
| Order Management    | ✅ Completed |
| Billing             | ✅ Completed |
| Order History       | ✅ Completed  |
| JDBC Integration    | ✅ Completed |













# 👨‍💻 Author

**Nikhil Lilhare**

Java Full Stack Developer

GitHub Repository:

**https://github.com/Nikhillilhare/Online-Food-Management-System-Console**

---

# ⭐ Version

**Version : 1.0**

**Status : Completed ✅**
