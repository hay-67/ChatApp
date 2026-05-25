/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapppart1;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class MainApp {
     public static void main(String[] args) {

// Scanner reads user input
Scanner input = new Scanner(System.in);

// Access login object methods
Login login = new Login();

// --- REGISTRATION SECTION ---
System.out.println(" === USER REGISTRATION === ");

// Get User Details
System.out.print("Enter a username: ");
String username = input.nextLine();

System.out.print("Enter a password: ");
String password = input.nextLine();

System.out.print("Enter your South African phone number (+27 ... ): ");
String phone = input.nextLine();

// Register User and Store Response
String response = login.registerUser(username, password, phone);

// Display registration result
System.out.println(response);

// --- LOGIN SECTION --
System.out.println("\n === USER LOGIN === ");

// Get Login Details
System.out.print("Enter your username: ");
String loginUsername = input.nextLine();

System.out.print("Enter your password: ");
String loginPassword = input.nextLine();

// Check if login details are correct
boolean loggedIn = login.loginUser(loginUsername, loginPassword);

// Display Login message
String loginMessage = login.returnLoginStatus(loggedIn);
System.out.println(loginMessage);




// =============================
// PART 2 STARTS HERE
// =============================

if (loggedIn) {

// Scanner obeject used for user input
System.out.println("Welcome to ChatApp.");

boolean running = true;

while (running) {

// MENU
System.out.println("===== MAIN MENU =====");
System.out.println("1) Send Messages");
System.out.println("2) Show recently sent messages");
System.out.println("3) Quit");

System.out.print("Choose an option: ");

int choice = input.nextInt();
input.nextLine();

switch (choice) {

case 1:

// Asks how many messages user wants to send
System.out.print("How many messages would you like to send? ");

int numMessages = input.nextInt();
input.nextLine();

// FOR LOOP
for (int i = 0; i < numMessages; i++) {

int messageNumber = i + 1;

System.out.println("--- Message " + messageNumber + " ---");

// Recipient cellphone number
System.out.print("Enter recipient number: ");
String recipient = input.nextLine();

// Message
System.out.print("Enter your message: ");
String messageText = input.nextLine();

// Create Message object
Message msg = new Message(messageNumber, recipient, messageText);

// Validates recipient callphone number
System.out.println(msg.checkRecipientCell());

// Validate message length
System.out.println(msg.checkMessageLength());

// Checks if message is valid before continuing
if (msg.checkRecipientCell().equals("Cell phone number successfully captured.")
&& msg.checkMessageLength().equals("Message ready to send.")) {

// Send / Store / Delete
String result = msg.sentMessage();

System.out.println(result);

// Displays message details
System.out.println("MESSAGE DETAILS");
System.out.println(msg.printMessages());
  }
}

break;

case 2:

System.out.println("Coming Soon.");

break;

case 3:

running = false;

System.out.println("Exiting ChatApp...");

break;

default:

System.out.println("Invalid option. Please choose 1, 2, or 3.");
  }
}

} else {

System.out.println("Login failed. Exiting application.");
  }


}
    
}
