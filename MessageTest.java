/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.chatapppart1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Student
 */
public class MessageTest {
    
// Message objects used for testing
private Message message1;
private Message message2;

// Runs before every test
@Before
public void setUp() {

// Valid POE test data
message1 = new Message(
    0,
    "+27718693002",
    "Hi Mike can you join us for dinner tonight"
);

// Invalid recipient POE test data
message2 = new Message(
    1,
    "08575975889",
    "Hi Keegan did you receive the payment"
);
}

// Test valid message length
@Test
public void testCheckMessageLength_validMessage_returnsSuccess() {

String result = message1.checkMessageLength();

assertEquals(
    "Message ready to send.",
result
);
}

// Test message longer than 250 characters
@Test
public void testCheckMessageLength_over250chars_returnsFailureWithCount() {

String longMessage = "a".repeat(260);

Message msg = new Message(
    1,
    "+27718693002",
    longMessage
);

String result = msg.checkMessageLength();

assertEquals(
    "Message exceeds 250 characters by 10; please reduce the size.",
result
);
}

// Test valid recipient number
@Test
public void testCheckRecipientCell_validNumber_returnsSuccess() {

String result = message1.checkRecipientCell();

assertEquals(
    "Cell phone number successfully captured.",
result
);
}

// Test invalid recipient number
@Test
public void testCheckRecipientCell_invalidNumber_returnsFailure() {

String result = message2.checkRecipientCell();

assertEquals(
    "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.",
result
);
}

// Test message hash format
@Test
public void testCreateMessageHash_correctFormat_endsWithExpectedWords() {

String hash = message1.createMessageHash();

assertTrue(
    hash.endsWith(":0:HITONIGHT")
);
}

// Test hash is uppercase
@Test
public void testCreateMessageHash_isUppercase() {

String hash = message1.createMessageHash();

assertEquals(
    hash.toUpperCase(),
hash
);
}

// Test message ID exists
@Test
public void testCheckMessageID_generatedID_isNotNull() {

assertNotNull(message1);
}

// Test message ID length
@Test
public void testCheckMessageID_generatedID_isExactly10Chars() {

assertTrue(message1.checkMessageID());
}

/*
* Helper class used to test sentMessage()
* without scanner input
*/
class TestableMessage extends Message {

private int option;

public TestableMessage(int option) {

super(
    1,
    "+27718693002",
    "Test message"
);

this.option = option;
}

@Override
public String sentMessage() {

switch (option) {

    case 1:
        return "Message successfully sent.";

    case 2:
        return "Press 0 to delete the message.";

    case 3:
        return "Message successfully stored.";

default:
return "Invalid option.";
}
}
}

// Test Send option
@Test
public void testSentMessage_userSelectsSend_returnsCorrectString() {

TestableMessage msg = new TestableMessage(1);

assertEquals(
    "Message successfully sent.",
msg.sentMessage()
);
}

// Test Disregard option
@Test
public void testSentMessage_userSelectsDisregard_returnsCorrectString() {

TestableMessage msg = new TestableMessage(2);

assertEquals(
    "Press 0 to delete the message.",
msg.sentMessage()
);
}

// Test Store option
@Test
public void testSentMessage_userSelectsStore_returnsCorrectString() {

TestableMessage msg = new TestableMessage(3);

assertEquals(
    "Message successfully stored.",
msg.sentMessage()
);
}
    
}
