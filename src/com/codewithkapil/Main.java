package com.codewithkapil;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Main {
    /*
     * @see arraylist for storing the contacts
     *
     *
     *
     * */
    private static ArrayList<Contact> contacts;
    private static Scanner sc;
    private static int id = 0;


    public static void main(String[] args) {

        contacts = new ArrayList<>();
        System.out.println("Welcome to World of Programming ");

        showInitialOptions();


    }

    private static void showInitialOptions() {
        System.out.println("Please Select one " +
                "\n\t1. Manage Contacts  " +
                "\n\t2. Message " +
                "\n\t3. Quit");


        sc = new Scanner(System.in);
        System.out.print("Enter Here >>  ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                manageContacts();
                break;


            case 2:
                manageMessages();
                break;

            default:
                break;
        }


    }

    private static void manageMessages() {
        System.out.println("Please select one " +
                "\n\t1. Show All messages" +
                "\n\t2. Send a New Message" +
                "\n\t3. Go Back");


        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                showAllMessages();
                break;

            case 2:
                sendNewMessage();
                break;

            default:
                showInitialOptions();
                break;


        }

    }

    private static void sendNewMessage() {
        System.out.println("Who are you going to send message?");
        String name = sc.next();

        if (name.equals("")) {
            System.out.println("Please Enter the name of the contact");
            sendNewMessage();
        } else {
            boolean doesExist = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name)) {
                    doesExist = true;

                }
            }
            if (doesExist) {
                System.out.println("What are you going to you say?");
                String text = sc.nextLine();

                if (text.equals("")) {
                    System.out.println("Please enter some message");
                    sendNewMessage();


                } else {
                    id++;

                    Message newMessage = new Message(text, name, id);
                    for (Contact c : contacts) {
                        if (c.getName().equals(name)) {
                            ArrayList<Message> newMessages = c.getMessage();
                            newMessages.add(newMessage);
                            c.setMessage(newMessages);


                        }
                    }


                }


            } else {
                System.out.println("There is no such contact");
            }


        }
        showInitialOptions();


    }


    private static void showAllMessages() {
        ArrayList<Message> allMessages = new ArrayList<>();
        for (Contact c : contacts) {
            allMessages.addAll(c.getMessage());

        }
        if (allMessages.size() > 0) {
            for (Message m : allMessages) {
                m.getDetails();
                System.out.println("**********************");
            }
        } else {
            System.out.println("You do not have any message");
        }

        showInitialOptions();
    }


    private static void manageContacts() {
        System.out.println("Please select one " +
                "\n\t1. Show All Contacts" +
                "\n\t2. Add a new Contact" +
                "\n\t3. Search for a Contact" +
                "\n\t4. Delete a Contact" +
                "\n\t5  Go Back");


        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                showAllContacts();
                break;

            case 2:
                addNewContact();
                break;

            case 3:
                searchForContact();
                break;

            case 4:
                deleteContact();
                break;

            default:
                showInitialOptions();
                break;
        }
    }

    private static void showAllContacts() {
        if(contacts.size()>0){
            for (Contact c : contacts) {
                c.getDetails();
                System.out.println("****************");



            }
            showInitialOptions();


        }
        else{
            System.out.println("You do not have any contact");
        }

        showInitialOptions();

    }

    private static void searchForContact() {
        System.out.println("Please enter contact's name : ");
        String names = sc.next();

        if (names.equals("")) {
            System.out.println("Please enter the name");
            searchForContact();

        } else {
            boolean doesExistIn = false;
            for (Contact c : contacts) {
                if (c.getName().equals(names)) {
                    doesExistIn = true;
                    c.getDetails();

                }
            }
            if (!doesExistIn) {
                System.out.println("There is no such contact in your phone");
            }
        }
        showInitialOptions();


    }

// TODO fix this exception is occurring
    private static void deleteContact() {
        System.out.println("Please enter contact's name : ");
        String name = sc.next();

        if (name.equals("")) {
            System.out.println("Please enter the name");
            deleteContact();
        } else {
            try{
                boolean doesExist = false;
                for (Contact c : contacts) {
                    if (c.getName().equals(name)) {
                        doesExist = true;
                        contacts.remove(c);


                    }
                }
                if (!doesExist) {
                    System.out.println("There is no such contact ");
                }


            }
            catch (Exception e){
                System.out.println(e);
            }


        }
        showInitialOptions();

    }

    private static void addNewContact() {
        System.out.print("Adding a new contact...." +
                "\nPlease enter the contact's name : ");

        String name = sc.next();

        System.out.print("Enter the contact's number : ");
        String number = sc.next();

        System.out.print("Please Enter contact's email : ");
        String email = sc.next();

        if (name.equals("") || number.equals("") || email.equals("")) {
            System.out.println("Please Enter all of the information ");
            addNewContact();

        } else {
            boolean doesExist = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name)) {
                    doesExist = true;




                }



            }
            if (doesExist) {
                System.out.println("We have a contact named  " + name + " saved on this device ");
                addNewContact();
            } else {
                Contact contact = new Contact(name, number, email);
                contacts.add(contact);
                System.out.println(name + " added successfully");

            }

        }
        showInitialOptions();



    }

}






