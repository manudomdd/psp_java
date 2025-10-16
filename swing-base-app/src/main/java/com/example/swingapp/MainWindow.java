package com.example.swingapp;

import javax.swing.*;

import java.awt.*;

public class MainWindow extends JFrame {
    private final ControlPanel controlPanel;
    private final OutputPanel outputPanel;
    private final AppController controller;

    public MainWindow() {
        super("Aplicación Base Swing con Maven");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        controlPanel = new ControlPanel();
        outputPanel  = new OutputPanel();
        controller   = new AppController(controlPanel, outputPanel);

        add(controlPanel, BorderLayout.WEST);
        add(outputPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainWindow::new);
    }
}