package com.company;

public class TesteCirculo{

    public static void main(String args[]){

        Circulo circulo1 = new Circulo();

        circulo1.tornarVisivel();
        circulo1.alterarCor("red");
        circulo1.moverHorizontal(30);
        circulo1.moverHorizontal(-50);
        circulo1.alterarTamanho(20);
        circulo1.moverParaBaixo();

        Circulo circulo2 = new Circulo();

        circulo2.tornarVisivel();
        circulo2.alterarCor("green");
        circulo2.slowMoveHorizontal(-230);
        circulo2.slowMoveVertical(140);

        Canvas canvas = Canvas.getCanvas();
        canvas.erase(circulo1);
        canvas.erase(circulo2);

        Circulo circulo10 = new Circulo();
        circulo10.tornarVisivel();
        circulo10.alterarCor("green");
        circulo10.slowMoveVertical(120);
        circulo10.slowMoveHorizontal(180);

        Circulo circulo11 = new Circulo();
        circulo11.tornarVisivel();
        circulo11.alterarCor("red");
        circulo11.slowMoveVertical(-70);
        circulo11.slowMoveHorizontal(180);

        Circulo circulo12 = new Circulo();
        circulo12.tornarVisivel();
        circulo12.slowMoveVertical(-70);
        circulo12.slowMoveHorizontal(-210);

        Circulo circulo13 = new Circulo();
        circulo13.tornarVisivel();
        circulo13.alterarCor("yellow");
        circulo13.slowMoveVertical(120);
        circulo13.slowMoveHorizontal(-210);
    }

}
