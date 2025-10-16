package com.example.swingapp;

import javax.swing.*;

import java.awt.event.ActionEvent;

public class AppController {
    private final ControlPanel controlPanel;
    private final OutputPanel outputPanel;

    public AppController(ControlPanel c, OutputPanel o) {
        this.controlPanel = c;
        this.outputPanel  = o;

        // Acciones de botones
        controlPanel.btnRun.addActionListener(this::onRun);
        controlPanel.btnClear.addActionListener(this::onClear);
        controlPanel.btnExit.addActionListener(e -> System.exit(0));
    }

    private void onRun(ActionEvent e) {
        outputPanel.append("Ejecutando comando...");
        try {
            ProcessBuilder pb = new ProcessBuilder("ping", "-c", "3", "8.8.8.8");
            pb.redirectErrorStream(true);
            Process process = pb.start();

            new Thread(() -> {
                try (var reader = new java.io.BufferedReader(
                        new java.io.InputStreamReader(process.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        outputPanel.append(line);
                    }
                } catch (Exception ex) {
                    outputPanel.append("Error: " + ex.getMessage());
                }
            }).start();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error ejecutando proceso:\n" + ex.getMessage());
        }
    }

    private void onClear(ActionEvent e) {
        outputPanel.clear();
    }
}