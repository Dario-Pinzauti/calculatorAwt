package com.rodri.learn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.*;

public class Calculator extends JPanel implements ActionListener {
    private String firstNumber = "";
    private String secondNumber = "";
    private String operator = null;
    private String result = "";
    private JTextField jTextField ;

    public Calculator() {
        initCalculator();
    }

    private void initCalculator() {
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton buttonPlus = new JButton("+");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton buttonMinus = new JButton("-");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton buttonFor = new JButton("*");
        JButton buttonEquals = new JButton("=");
        JButton buttonPoint = new JButton(".");
        JButton buttonDivided = new JButton("/");
        JButton buttonCancel = new JButton("c");

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        buttonPlus.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        buttonMinus.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        buttonFor.addActionListener(this);
        buttonEquals.addActionListener(this);
        buttonPoint.addActionListener(this);
        buttonDivided.addActionListener(this);
        buttonCancel.addActionListener(this);

        jTextField = new JTextField(20);
        jTextField.setEditable(false);
        JPanel jPanel = new JPanel(new GridLayout(1, 0));
        jPanel.add(jTextField);

        add(jPanel);

        JPanel jPanel1 = new JPanel(new GridLayout(4, 4, 10, 10));


        jPanel1.add(button1);
        jPanel1.add(button2);
        jPanel1.add(button3);
        jPanel1.add(buttonPlus);
        jPanel1.add(button4);
        jPanel1.add(button5);
        jPanel1.add(button6);
        jPanel1.add(buttonMinus);
        jPanel1.add(button7);
        jPanel1.add(button8);
        jPanel1.add(button9);
        jPanel1.add(buttonFor);
        jPanel1.add(buttonEquals);
        jPanel1.add(buttonDivided);
        jPanel1.add(buttonPoint);
        jPanel1.add(buttonCancel);
        add(jPanel1);
        setLayout(new GridLayout(2,1));

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        String actionCommand = e.getActionCommand();
        char c = actionCommand.toCharArray()[0];
        //trovo se è un numero
        if(c>='0' && c <= '9' || c=='.'){
            //se operator è null sono sul primo numero
            if(Objects.isNull(operator)){
                firstNumber += c;
                jTextField.setText(firstNumber);
            }else{
                secondNumber+= c;
                jTextField.setText(secondNumber);
            }
                jTextField.repaint();
        }
        if(c == '+'|| c== '-'|| c=='/'||c=='*'){
            operator = c+"";
        }

        if(c == 'c'){
         firstNumber = "";
         secondNumber = "";
         result="";
         jTextField.setText("");
         jTextField.repaint();
         operator= null;

        }
        if(c == '='){
            double first = Double.parseDouble(firstNumber);
            double second = Double.parseDouble(secondNumber);

            switch (operator) {
                case "+" -> result = String.valueOf(first + second);
                case "-" -> result = String.valueOf(first - second);
                case "*" -> result = String.valueOf(first * second);
                case "/" -> result = String.valueOf(first / second);
            }
            firstNumber = "";
            secondNumber= "";
            jTextField.setText(result);
            jTextField.repaint();
            operator= null;
            result = "";

        }

    }
}
