package com.company;

public class EstimuladorVacina implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            System.out.println("se");
        }

        System.out.println("vacine-se");
    }
}
