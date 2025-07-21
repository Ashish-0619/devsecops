package com.example;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, Java Security World!");

        // Example of simple code that might be flagged by SAST (e.g., hardcoded password, though this is benign)
        String password = "mysecretpassword"; // SAST tools might flag hardcoded secrets
        System.out.println("Password: " + password);

        // Using a vulnerable dependency for SCA testing
        Bag<String> bag = new HashBag<>();
        bag.add("item1", 2);
        bag.add("item2");
        System.out.println("Bag contents: " + bag);
    }

    // A method with a potential SAST issue (e.g., SQL injection vulnerability if not careful)
    public static String getUserData(String userId) {
        // In a real app, this would be a database query.
        // If 'userId' is not properly sanitized, it could lead to SQL injection.
        // SAST tools look for patterns like this.
        String query = "SELECT * FROM users WHERE id = '" + userId + "'";
        System.out.println("Simulating database query: " + query);
        return "Data for user " + userId;
    }
}