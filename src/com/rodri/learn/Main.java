package com.rodri.learn;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        Calculator calculator = new Calculator();

        jFrame.add(calculator);

        jFrame.setSize(500,500);
        jFrame.setVisible(true);

    }
}
