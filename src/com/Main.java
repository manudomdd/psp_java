package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main (String[] args) {
		lecturaBufferedReader(); 
	}
	
	public static void lecturaScanner() {
		String nombre = scanner.nextLine(); 
		System.out.println("Hola " + nombre); 
	}
	
	public static void lecturaBufferedReader() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
			
			while (true) {
				System.out.print("cuantapal6sh>"); 
				String ruta = br.readLine(); 
				
				if (ruta == null || ruta.isBlank() || ruta.isEmpty() || ruta.equals("exit")) break; 
				
				File file = new File(ruta); 
				
				if (!file.isFile()) {
					System.err.println("No es un archivo.");
					continue; 
				}
				
				ProcessBuilder pb = new ProcessBuilder("wc"); 
				pb.redirectInput(file);
				pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
				pb.redirectError(ProcessBuilder.Redirect.INHERIT); 
				
				Process p = pb.start(); 
				
				int code = p.waitFor(); 
				
				if (code != 0) System.err.print("Error en la ejecucion.");
								
				System.out.println("eco: " + ruta); 
			}
			
		} catch (Exception ex) {
			System.err.print(ex.getMessage()); 
		}	
	}
}
