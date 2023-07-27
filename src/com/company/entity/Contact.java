package com.company.entity;

public class Contact {
    private static  Long generateId = 1L;
    private Long id;
    private String name;
    private String surname;
    private String number;

    public Contact( String name, String surname, String number) {
        this.id = generateId++;
        this.name = name;
        this.surname = surname;
        this.number = number;
    }

    public Contact(Long id, String name, String surname, String number) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public void info (){
        System.out.println("id:"+id +" name:"+ name + " surname" + surname + " " + " number" + number );
    }

    @Override
    public String toString() {
        return "id:"+id +" name:"+ name + " surname" + surname + " " + " number" + number;
    }
}
