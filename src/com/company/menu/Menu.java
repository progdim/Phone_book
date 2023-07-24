package com.company.menu;

import com.company.entity.Contact;
import com.company.exeption.CreateContactExeption;
import com.company.exeption.PhoneExeption;
import com.company.services.PhoneBook;

import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private PhoneBook phoneBook = new PhoneBook();

    public void start() throws CreateContactExeption {
        while (true) {
            System.out.println("0 exit");
            System.out.println("1 add contact");
            System.out.println("2 delete contact");
            System.out.println("3 delete all contact");
            System.out.println("4 edit contact");
            System.out.println("5 list contact");
            System.out.println("6 search contact to name");
            System.out.println("7 search contact to number");

            String ansvear = scanner.nextLine();
            switch (ansvear) {
                case "0" -> {
                    System.exit(0);
                }
                case "1" -> {
                    Contact contact = createContact();
                    if (contact != null){
                        addContact(contact);
                    }else {
                        System.out.println("контакт не создан");
                    }

                }
                case "2" -> {
                    deleteContact();
                }
                case "3" -> {
                    phoneBook.deleteOllContact();
                }
                case "4" -> {
                }
                case "5" -> {
                    printContact();
                }
                case "6" -> {
                }
                case "7" -> {
                }
                default -> System.out.println("нет такого пункта меню");

            }


        }

    }

    private Contact createContact () throws CreateContactExeption { //проверить если имя или фамилия пустые строки вывести ексепшен который нужно содать ()так же создать  его в пакете ексепшен)
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        if (name.isEmpty()){
            throw new CreateContactExeption("Введена пустая строка");
        }

        System.out.println("Введите фамилию");
        String surname = scanner.nextLine();
        if (surname.isEmpty()){
            throw new CreateContactExeption("Введена пустая строка");
        }

        System.out.println("Введите телефон");//проверять если в стоке есмть буквы или любый сиволы кроме + и цифр вывестиеспешен кторы так же создать

             String phone = scanner.nextLine();
            char [] chars =  phone.toCharArray();
        for (char c : chars) {
            if ( !(c == '+' || Character.isDigit(c))){ //проверяет является ли символ числом
                try {
                    throw new PhoneExeption();
                } catch (PhoneExeption e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }

        return new Contact(name,surname,phone);
    }

    private void deleteContact (){ // дописать проверку что ввели именно число если не число обработать ексепшен
        printContact();
        System.out.println("Введите id");
        long id = scanner.nextLong();
        if (phoneBook.deleteContakt(id)) {
            System.out.println("Контакт id "+ id +" удален");
        }else {
            System.out.println("Контакт не удален");
        }
    }



    private  void  addContact (Contact contact){
        if (phoneBook.addContact(contact)) {
            System.out.println("контакт добавлен");
        }else {
            System.out.println("не добавлен");
        }
    }

    private void printContact () {
        for (Contact contact : phoneBook.getArrayContact()) {
            if (contact != null){
                contact.info();
            }
        }
    }

}

