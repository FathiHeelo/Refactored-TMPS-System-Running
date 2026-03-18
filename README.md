# TaskMaster Processing System (TMPS) – Refactored Version

## 📌 Overview
This project is a complete refactoring of the TaskMaster Processing System (TMPS), a job processing application for handling tasks like email sending, data processing, and report generation.

Starting from a flawed codebase, I analyzed design issues (SOLID violations, tight coupling, code duplication) and rebuilt the system into a clean, modular, and scalable architecture using design patterns.

---

## 🧠 Design Patterns Applied

### 🔹 Connection Pool
- Thread-safe pool for managing database connections
- Limits connections and reuses them efficiently
- Prevents resource exhaustion

### 🔹 Prototype Pattern
- Clone-based job template creation instead of rebuilding objects
- Supports reusable templates for different job types

### 🔹 Strategy Pattern
- Replaces complex conditionals with flexible execution strategies
- Each job type has its own execution logic

### 🔹 Proxy Pattern
- Controls and monitors job execution
- Handles logging, permissions, timing, and connection management

---

## 🚀 Key Improvements
- Improved scalability through connection pooling
- Easier extensibility for adding new job types
- Cleaner architecture with strong SOLID principles
- Better performance by reducing object creation
- More reliable execution with logging and monitoring

---

## 🛠️ Technologies Used
- Java 17+
- Concurrency (BlockingQueue, synchronization)
- Object-Oriented Design & Design Patterns

---

## ▶️ How to Run
1. Open the project in IntelliJ or Eclipse  
2. Run the `Main` class  
3. Check logs for execution flow and system behavior  

---

## 📚 What I Learned
- Applying design patterns to solve real architectural problems  
- Identifying and fixing code smells in large systems  
- Building scalable and maintainable Java applications  
- Writing cleaner, more structured code  

---

## 👨‍💻 Author
Refactored by: **Fathi Heelo** 🚀  

---
