package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    //A field that initialized a LinkedHashMap to preserve the order of entries based on their insertion sequence
    private  Map<String, List<String>> phonebook =new LinkedHashMap<>();

    //Constructor accepts Map and List as an arguement and intializes phonebook with the provided map. allows intializing exisitng map of name and numbers
    public PhoneBook(Map<String, List<String>> map) {


      this.phonebook = map;
    }
    //intialized phonebook field with a new instance of LinkedHashMap. ensures the phonebook starts empty when you create a new PhoneBook object using new PhoneBook();
    public PhoneBook() {


        this.phonebook = new LinkedHashMap<>();
    }
    //Adds a single name in the phonebook. if name doesnt exist in phonebook it creates a new entry with an empty list and then adds phone number to list
    public void add(String name, String phoneNumber) {
    if (!phonebook.containsKey(name)){
        phonebook.put(name,new ArrayList<>());
    }
    phonebook.get(name).add(phoneNumber);
    }
    //behaves similar to add method but allows multiple numbers to a name
    public void addAll(String name, String... phoneNumbers) {
        if (!phonebook.containsKey(name)){
            phonebook.put(name,new ArrayList<>());
        }
        Collections.addAll(phonebook.get(name),phoneNumbers);
    }
    //removes the entry associated with the given name from the phonebook
    public void remove(String name) {

        phonebook.remove(name);
    }
    //checks if the phonebook contains an entry for the given name
    public Boolean hasEntry(String name) {


        return  phonebook.containsKey(name);
    }
    //retrieves list of phone numbers associated with the given name from phone book
    public List<String> lookup(String name) {


        return phonebook.getOrDefault(name, new ArrayList<>());
    }
    //searches for phoneNumber across all entries in phonebook and return the corressponding name
    public String reverseLookup(String phoneNumber)  {

    for  (Map.Entry<String, List<String>> entry : phonebook.entrySet()){
        if (entry.getValue().contains(phoneNumber)){
            return entry.getKey();
        }
    }
        return null;
    }
    //returns a list of all names(keys) present in the phone book
    public List<String> getAllContactNames() {


        return new ArrayList<>(phonebook.keySet());
    }
    //returns the entire phonebook as a mapString, listString allowing external access to the internal map
    public Map<String, List<String>> getMap() {


        return phonebook;
    }
}
