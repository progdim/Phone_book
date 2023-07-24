package com.company.main;

import com.company.exeption.CreateContactExeption;
import com.company.menu.Menu;

public class Main {

    public static void main(String[] args) throws CreateContactExeption {

        Menu menu = new Menu();
        menu.start();
    }
}
