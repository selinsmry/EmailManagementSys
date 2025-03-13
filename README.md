# Email Management System
## Project Overview: 
The Email Management System is a Java-based application designed to efficiently manage and organize emails across various folders, such as Inbox, Archive, and Sent. It provides a simple and intuitive interface to handle email storage, retrieval, and movement between different folders. The system simulates the fundamental operations of an email server, allowing users to interact with email data and manage email flow in an organized way.

## Key Features:
- __Email Representation:__ Each email is represented as an object, containing attributes like sender, recipient, subject, body, and timestamp.
- __Folder Management:__ Emails can be categorized into different folders like Inbox, Sent, and Archive. Users can easily move emails between folders.
- __Adding New Emails:__ Users can create and add new emails to their Sent folder by providing relevant details (sender, recipient, subject, body).
- __Searching Emails:__ Users can search for emails based on keywords in the subject or body, enabling quick retrieval.
- __Email Removal:__ Users can remove emails from any folder as needed.
- __Persistence:__ The email data is stored in memory while the program runs and is cleared once the application ends (for simplicity, no database or external storage is used).
  
## Technology Stack:
- __Language:__ Java
- __Libraries:__ Standard Java libraries for handling basic input/output, data structures, and collections.
- __Approach:__ Object-Oriented Programming (OOP) concepts, where classes like Email, ListOfEmails, and Application are used to model the email data and folder management system.
  
## Project Structure:
- __Email Class:__ Holds the email data (sender, recipient, subject, body).
- __ListOfEmails Class:__ Manages a list of emails and operations on them (adding, removing, searching).
- __Application Class:__ Acts as the main entry point for managing email functionality, running the system, and interacting with users.
  
## Learning Objectives:
- Understanding and applying **Object-Oriented Programming (OOP)** concepts like classes and objects.
- Managing collections and data structures in Java, particularly using arrays or lists.
- Implementing a simple file management system to categorize and organize data into different groups or folders.
- Gaining hands-on experience with email systems and basic server-side concepts.
  
## Potential Improvements:
- Adding functionality to store emails in a persistent database.
- Adding user authentication and a graphical user interface (GUI) to make the system more interactive.
- Implementing advanced search functionality, including filtering by date, sender, or other criteria.

## License:
This project is licensed under the MIT License - see the LICENSE file for details.
