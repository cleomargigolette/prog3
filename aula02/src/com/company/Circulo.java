package com.company;

import java.awt.geom.*;

/**
 * Classe que representa um círculo, que pode ser manipulado e desenhado em uma área.
 * 
 * @author Cassia Nino
 * @version 2013.08.16
 * 
 * Baseada na classe original de Michael Kolling and David J. Barnes
 */

public class Circulo{

    private int diametro;
    private int posicaoX;
    private int posicaoY;
    private String cor;
    private boolean isVisivel;
    
    /**
     * Cria um novo círculo na posição default, com a cor default.
     */
    public Circulo(){
        diametro = 68;
        posicaoX = 230;
        posicaoY = 90;
        cor = "blue";
    }

    /**
     * Torna o círculo visível. Se já está visível, não há mudança.
     */
    public void tornarVisivel(){
        isVisivel = true;
        desenhar();
    }
    
    /**
     * Torna o círculo invisível. Se já está invisível, não há mudança.
     */
    public void tornarInvisivel(){
        apagar();
        isVisivel = false;
    }
    
    /**
     * Movimenta o círculo alguns pixels para a direita.
     */
    public void moverParaDireita(){
        moverHorizontal(20);
    }

    /**
     * Movimenta o círculo alguns pixels para a esquerda.
     */
    public void moverParaEsquerda(){
        moverHorizontal(-20);
    }

    /**
     * Movimenta o círculo alguns pixels para cima.
     */
    public void moverParaCima(){
        moverVertical(-20);
    }

    /**
     * Movimenta o círculo alguns pixels para baixo.
     */
    public void moverParaBaixo(){
        moverVertical(20);
    }

    /**
     * Movimenta o círculo na horizontal, pela distância indicada em pixels.
     */
    public void moverHorizontal(int distance){
        apagar();
        posicaoX += distance;
        desenhar();
    }

    /**
     * Movimenta o círculo na vertical, pela distância indicada em pixels.
     */
    public void moverVertical(int distance){
        apagar();
        posicaoY += distance;
        desenhar();
    }

    /**
     * Movimenta lentamente o círculo na horizontal, pela distância indicada em pixels.
     */
    public void slowMoveHorizontal(int distance){
        int delta;

        if(distance < 0){
            delta = -1;
            distance = -distance;
            
        } else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            posicaoX += delta;
            desenhar();
        }
    }

    /**
     * Movimenta lentamente o círculo na vertical, pela distância indicada em pixels.
     */
    public void slowMoveVertical(int distance){
        int delta;

        if(distance < 0){
            delta = -1;
            distance = -distance;
            
        } else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            posicaoY += delta;
            desenhar();
        }
    }

    /**
     * Altera o tamanho do círculo (em pixels). O tamanho deve ser maior que zero.
     */
    public void alterarTamanho(int newdiametro){
        apagar();
        diametro = newdiametro;
        desenhar();
    }

    /**
     * Altera a cor do círculo. Os valores válidos são "red", "yellow",
     * "blue", "green", "magenta" e "black".
     */
    public void alterarCor(String cor){
        this.cor = cor;
        desenhar();
    }

    /**
     * Desenha o círculo na tela, de acordo com os seus atributos
     */
    private void desenhar(){
        if(isVisivel) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, cor, new Ellipse2D.Double(posicaoX, posicaoY, 
                                                          diametro, diametro));
            canvas.wait(10);
        }
    }

    /**
     * Apaga o desenho do círculo na tela.
     */
    private void apagar(){
        if(isVisivel) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}