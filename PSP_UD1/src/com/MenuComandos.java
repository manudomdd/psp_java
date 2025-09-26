package com;

import java.util.Scanner;

public class MenuComandos {
	
	public static Scanner scanner = new Scanner(System.in); 
	
	public static void main (String[] args) throws Exception {		
		
		int option; 
		
		do {
			System.out.println("Seleccione una opcion: "); 
			System.out.println("1. uname -a"); 
			System.out.println("2. hostnamectl"); 
			System.out.println("3. lscpu"); 
			System.out.println("4. timedatectl status"); 
			System.out.println("5. Salir"); 
			option = scanner.nextInt(); 
			switch (option) {
			case 1: iniciarComando("uname -a"); 
			case 2: iniciarComando("hostnamectl"); 
			case 3: iniciarComando("lscpu"); 
			case 4: iniciarComando("timedatectl status"); 
			case 5: System.out.println("Programa finalizado."); 
			default: System.out.println("Seleccione una opcion valida."); 
			}
		} while (option != 5); 
	}
	
	public static void iniciarComando(String comando) {
		try {
			ProcessBuilder pb = new ProcessBuilder(Utils.sh(comando)); 
			pb.inheritIO(); 
			Process p = pb.start(); 
				
			int rc = p.waitFor(); 
				
			if (rc == 0) {
					System.out.println("El comando es correcto."); 
			} else {
					throw new Exception ("El comando no es correcto."); 
			}
				
			System.out.println("RC= " + rc); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
