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
* MySQL (Upcoming)
* JDBC (Upcoming)

---

# 📁 Project Structure

```text
OnlineFoodOrderingSystem
│
├── model
│
├── controller
│
├── service
│     ├── console
│     └── db
│
├── repository
│     ├── console
│     └── db
│
├── util
│
└── main
```

---

# 🏗 Architecture

```text
Main
   │
   ▼
AppController
   │
   ▼
CustomerController
   │
   ▼
CustomerService
   │
   ▼
CustomerRepository
   │
   ▼
ArrayList
```

Later

```text
ArrayList
     │
     ▼
MySQL Database (JDBC)
```

---

# ✅ Features Completed

## Customer Management

* Customer Registration
* Duplicate Email Check
* Name Validation
* Email Validation
* Mobile Number Validation
* Password Validation
* Clean Layered Architecture

---

# ⏳ Features In Progress

* Customer Login
* View Customer Profile

---

# 📌 Planned Features

## Food Menu

* Display All Food Items
* Search Food By Name
* Filter Food By Category

### Order Management

* Add Food To Cart
* Update Quantity
* Remove Item
* View Cart

### Billing

* Calculate Total Amount
* Apply GST
* Generate Bill
* Order Summary

### Order History

* View Order History
* Search Order By ID

### Database Integration

* MySQL
* JDBC

### Bonus Features

* Admin Panel
* Discount Coupon
* Print Bill to Text File
* Sort Menu By Price
* Top Selling Food Items

---

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


```

---

# ⚙ How to Run

1. Clone or download the project.
2. Open the project in IntelliJ IDEA.
3. Set Java SDK 17 or above.
4. Run `Main.java`.

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

# 👨‍💻 Author

**Nikhil Lilhare**o

## Ignore file
.gitignore
pom.xml