# PROG5121 Programming 1A - ChatApp Part 2

## Student Information
- Name: Hailey Bruintjies
- Student Number: ST10524381
- Module: Programming 1A

---

## Project Overview
This progect is part 2 of the ChatApp assignment (continuation of - and includes - part 1).

The application allows users to:
- Register an account
- Login with their details
- Send messages
- Validate recipient's phone number
- Validate message length
- Generate message hashes
- Store messages in the JSON format
- Run unit tests using JUnit

---

## Features

### User Registration
The user can register for an account using a:
- Username
- Password
- Phone number

### User Login
Registered users can login using their usernames and passwords.

### Messaging
The messaging system allows users to:
- Send messages
- Store messages
- Disregard messages

### Unit Testing
JUnit tests were used for:
- Message length validation
- Recipent number validation
- Message ID validation
- Message hash generation
- Send message options


## Classes Used

### MainApp Class
Handles:
- User Registration
- User Login
- Menu Options
- Message Creation

---

### Login Class
- Username Validation
- Password Validation
- Celphone no. Validation
- User Registration
- User Login Verification

---

### Message Class
- Generates message IDs
- Checks message length
- Generates message hashes
- Sends, stores, disregards messages
- Validates recipient phone number

---

### Login Test Class
Contains JUnit tests for:
- Username Validation
- Password Complexity
- Cellphone no. Validation
- Login Functionality

---

### Message Test Class
Contains JUnit Tests for:
- Message Length Validation
- Recipent Cellphone no. Validation
- Message Hash Generation
- Message ID Validation
- Message Sending Options
