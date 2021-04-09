package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Janela extends JFrame {


    public Janela(){

        setVisible(true);
        setTitle("Teste de janela");
        setSize(1000, 400);
        setBackground(Color.BLUE);

        JPanel panel = new JPanel();
        panel.setSize(400,400);

        JButton botao1 = new JButton();

        botao1.setBackground(Color.BLACK);
        botao1.setText("Ok");
        botao1.setSize(100,100);
        botao1.addActionListener(new AcaoBotao());
        botao1.addMouseMotionListener(new MouseBotao());

        JTextField caixaTexto = new JTextField("", 20);

        panel.add(botao1);
        panel.add(caixaTexto);

        add(panel);

        pack();

    }

    public class AcaoBotao implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            Thread thread = new Thread(new EstimuladorVacina());
            thread.start();
        }
    }

    public class MouseBotao implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseMoved(MouseEvent mouseEvent) {
            System.out.println("Passou o mouse");
        }
    }

}
