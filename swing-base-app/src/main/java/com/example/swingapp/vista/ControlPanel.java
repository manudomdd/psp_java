package com.example.swingapp.vista;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    private static final long serialVersionUID = 1L;
	public JButton btnRun, btnClear, btnExit;

    public ControlPanel() {
        // grid con 3 filas (una por botón)
        setLayout(new GridLayout(3, 1, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        btnRun   = new JButton("▶ Ejecutar");
        btnClear = new JButton("🧹 Limpiar");
        btnExit  = new JButton("🚪 Salir");

        add(btnRun);
        add(btnClear);
        add(btnExit);
    }
}