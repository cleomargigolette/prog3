package com.company;

import java.time.temporal.ChronoUnit;

public class Calculador {

    public static double calcularBonificacao(Contrato contrato){

        double totalBonificacao = 0;
        Long diferencaEmAnos = ChronoUnit.YEARS.between(contrato.getDataInicio(), contrato.getDataFim());
        double salarioBruto = contrato.getQuantidadeHorasSemanais()  * contrato.getValorHora();

        if(diferencaEmAnos < 5){

            totalBonificacao = salarioBruto * 8.2 / 100;

        }else{

            if (diferencaEmAnos > 10){

                totalBonificacao = salarioBruto < 35000 ? salarioBruto * 22.21 / 100 : salarioBruto * 19 / 100;

            }else {

                if(salarioBruto < 2000){

                    totalBonificacao = salarioBruto * 16.87 / 100;

                }else{

                    totalBonificacao = salarioBruto > 3500 ? salarioBruto * 11 / 100 : salarioBruto * 13.4 / 100;
                }

            }
        }

        return totalBonificacao;
    }
}
