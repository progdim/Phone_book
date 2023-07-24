package com.company.exeption;

public class PhoneExeption extends Exception{

    private String message = "не является номером телефона";

    @Override
    public String toString() {
        return message;
    }
}
