package com.company.services;

import com.company.entity.Contact;

import java.util.Arrays;

public class PhoneBook {
   private Contact [] contacts = new Contact[100];


   public boolean addContact (Contact contact) {
       for (int i = 0; i < contacts.length; i++) {
           if (contacts[i] == null){
               contacts[i] = contact;
               return true;
           }
       }
       return false;
   }

   public Contact [] getArrayContact() {
       return Arrays.copyOf(contacts,contacts.length);
   }


   public boolean deleteContakt (long id){
       for (int i = 0; i < contacts.length; i++) {
           if (contacts[i] != null){
               if (contacts[i].getId() == id){
                   contacts[i] = null;
                   return true;
               }
           }
       }
       return false;
   }

   public void deleteOllContact () {
       contacts = new Contact[contacts.length];
       System.out.println("Список контактов очищен");
   }

   public void searchContact (String name){
       for (int i = 0; i < contacts.length; i++) {
           if (contacts[i] != null){
               if (contacts[i].getName().equals(name)){
                   System.out.println(contacts[i]);
               }
           }
       }

   }
}
