package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> contacts = new ArrayList<>();

    public void storeContact(String name, int number){
        if (findContact(number) < 0 && findContact(name) < 0) {
            Contact contact = new Contact(name, number);
            contacts.add(contact);
        }else {
            System.out.println("You already have this number");
        }
    }

    public void modifyContact(String oldName, String newName, int newNumber){
        int position = findContact(oldName);
        if (position > -1){
            contacts.set(position,new Contact(newName, newNumber));
            System.out.println("Contact was modified.");
        }
        else System.out.println("You don't have contact like this");
    }

    public void printContacts(){
        System.out.println("You have "+contacts.size()+" contacts in your phone.");
        for (int i = 0; i < contacts.size(); i++){
            System.out.println((i+1) + ". " + contacts.get(i).getName() + "\t"+contacts.get(i).getPhoneNum());
        }
    }

    public void removeContact(String name){
        int position = findContact(name);
        if (position > -1){
            contacts.remove(position);
            System.out.println("Contact was removed.");
        }
        else {
            System.out.println("You don't have this contact in your phone.");
        }
    }

    public void removeContact(int number){
        int position = findContact(number);
        if (position > -1){
            contacts.remove(position);
            System.out.println("Contact was removed.");
        }
        else {
            System.out.println("You don't have this contact in your phone.");
        }
    }

    public void searchForContact(String name){
        int position = findContact(name);
        if (position > -1){
            System.out.println("Contact "+name+" was found: "+ contacts.get(position).getPhoneNum());
        }
        else {
            System.out.println("You don't have this contact in your phone.");
        }
    }

    public void searchForContact(int number){
        int position = findContact(number);
        if (position > -1){
            System.out.println("Contact with number "+number+" was found: "+ contacts.get(position).getName());
        }
        else {
            System.out.println("You don't have this contact in your phone.");
        }
    }

    private int findContact(String name){
        for (int i = 0; i < contacts.size(); i++){
            if (contacts.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    private int findContact(int number){
        for (int i = 0; i < contacts.size(); i++){
            if (contacts.get(i).getPhoneNum() == number){
                return i;
            }
        }
        return -1;
    }
}
