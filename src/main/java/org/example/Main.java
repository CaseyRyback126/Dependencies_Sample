package org.example;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("John", "Doe", 30);

        String json = person.toJson();
        System.out.println("Serialized JSON: " + json);
    }
}