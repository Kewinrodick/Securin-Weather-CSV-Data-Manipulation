# 🌦 Weather Data Processing API

A Spring Boot application that processes a large weather dataset (100,000+ records), stores it in a MySQL database, and provides REST APIs with filtering, sorting, and pagination.

---

## 🚀 Features

### 1️⃣ CSV Upload
- Upload large weather dataset via REST API
- Parses custom date format: `yyyyMMdd-HH:mm`
- Handles missing values (`-9999`, empty fields)
- Stores cleaned data into MySQL

### 2️⃣ Weather Retrieval API
Supports:

- Filter by **year**
- Filter by **month**
- Filter by **specific date**
- Sorting (ascending / descending)
- Pagination

Works efficiently for large datasets (100k+ records).

---

## 🛠 Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven

---

## 📂 Project Structure
