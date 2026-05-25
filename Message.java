/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapppart1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import org.json.JSONObject;
/**
 *
 * @author Student
 */
public class Message {
   private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;
    private String sendStatus;

    // Constructor method
    public Message(int messageNumber, String recipient, String messageText) {

        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;

        generateMessageID();

        this.messageHash = createMessageHash();
    }

    // Generates random 10-digit message ID
    private void generateMessageID() {

        Random random = new Random();

        String id = "";

        for (int i = 0; i < 10; i++) {

            id += random.nextInt(10);
        }

        this.messageID = id;
    }

    // Checks validity of message ID length
    public boolean checkMessageID() {

        return messageID.length() <= 10;
    }

    // Checks if recipient cell number is correct
    public String checkRecipientCell() {

        // Regex checks that number starts with +27 and contains 9 digits
        if (recipient.matches("^\\+27\\d{9}$")) {

            return "Cell phone number successfully captured.";

        } else {

            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    // Checks message length
    public String checkMessageLength() {

        if (messageText.length() <= 250) {

            return "Message ready to send.";

        } else {

            int over = messageText.length() - 250;

            return "Message exceeds 250 characters by " + over + "; please reduce the size.";
        }
    }

    // Creates message hash using ID, message number, message text
    public String createMessageHash() {

        String idPart = messageID.substring(0, 2);

        String[] words = messageText.split(" ");

        String firstWord = words[0];

        String lastWord = words[words.length - 1];

        String hash = idPart + ":" + messageNumber + ":" + firstWord + lastWord;

        return hash.toUpperCase();
    }

    // Gives user options to send, store, or delete
    public String sentMessage() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What would you like to do with this message?");
        System.out.println("1) Send Message");
        System.out.println("2) Disregard Message");
        System.out.println("3) Store Message to send later");

        int option = scanner.nextInt();

        switch (option) {

            case 1:

                sendStatus = "Sent";
                return "Message successfully sent.";

            case 2:

                sendStatus = "Disregarded";
                return "Press 0 to delete the message.";

            case 3:

                sendStatus = "Stored";

                storeMessage();

                return "Message successfully stored.";

            default:

                return "Invalid option.";
        }
    }


    // Stores message details in JSON file
    public void storeMessage() {

        JSONObject obj = new JSONObject();

        obj.put("messageID", messageID);
        obj.put("recipient", recipient);
        obj.put("message", messageText);
        obj.put("messageHash", messageHash);

        try (FileWriter file = new FileWriter("messages.json", true)) {

            file.write(obj.toString());

            file.write(System.lineSeparator());

        } catch (IOException e) {

            System.out.println("Error writing to JSON file.");
        }
    }

    // Displays all message details
    public String printMessages() {

        return "Message ID: " + messageID
                + "\nMessage Hash: " + messageHash
                + "\nRecipient: " + recipient
                + "\nMessage: " + messageText;
    }

    // Returns total number of messages
    public int returnTotalMessages() {

        return messageNumber;
    }    
}
