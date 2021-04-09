package com.company;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        LocalDate date = LocalDate.parse("2021-03-25");

        System.out.println(date);

        String nome = "Cleomar";

        System.out.println(nome.replace('a','@'));
    }
}
