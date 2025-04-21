# 🏋️ Gym Membership Management System

A Java-based desktop application developed for Alexandria University's Programming II course (Fall 2024/2025). The system manages gym memberships, trainers, classes, and class registrations. It features both a command-line backend (Lab 4) and a GUI interface (Lab 5) built using NetBeans.

---

## 📦 Project Structure

This project is divided into **three packages**:

### 1. `backend`
Contains core logic and data models:
- `AdminRole`, `TrainerRole`
- `Trainer`, `TrainerDatabase`
- `Member`, `MemberDatabase`
- `Class`, `ClassDatabase`
- `MemberClassRegistration`, `MemberClassRegistrationDatabase`

### 2. `frontend`
Contains GUI components built with NetBeans:
- Admin windows (Login, Role Panel, Add/View/Remove Trainer)
- Trainer windows (Login, Role Panel, Add/View Member, Add/View Class, Register/Cancel/View Registrations)

### 3. `constants`
Contains two interfaces:
- `FileNames.java`: File paths for persistence
- `LoginCredentials.java`: Hardcoded credentials for Admin and Trainer

---

## 📋 System Features

### 👤 Admin Role
- Add/View/Remove Trainers
- Save data and logout

### 🧑‍🏫 Trainer Role
- Add/View Members
- Add/View Classes
- Register/Cancel/View Class Registrations
- Save data and logout

### 💾 Data Files
Stored as text files and accessed via the `backend`:
- `Trainers.txt`
- `Members.txt`
- `Class.txt`
- `Registration.txt`

---

## 🔐 Login Credentials

Stored in `LoginCredentials.java`:

```java
ADMIN_USERNAME = "admin"
ADMIN_PASSWORD = "12345"

TRAINER_USERNAME = "trainer"
TRAINER_PASSWORD = "56789"
```

---

## ✅ Validations Implemented

- Unique Trainer ID and Member ID
- Required fields must be filled
- Class registration limited by available seats
- Secure login credentials for admin and trainer

---

## 🛠 Technologies Used

- Java
- Java Swing (NetBeans GUI Builder)
- File I/O for persistence
- Object-Oriented Programming (OOP)

---

