package com;

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Ej1_Basico {
	
	 public static void main(String[] args) throws Exception {
	       
	        ProcessBuilder pb = new ProcessBuilder(Utils.sh(String.join(" ", args)));
	        pb.inheritIO(); 
	        Process p = pb.start();
	        
	        //InputStream flujoEntrada = p.getInputStream(); 
	        //InputStreamReader lector = new InputStreamReader(flujoEntrada); 
	        //BufferedReader reader = new BufferedReader(lector); 
	        //String line
	        //while ((line = reader.readLine()) != null) {
	        //	System.out.println(line); 
	        //}
	        
	        /*
	         * try (BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream())))
	         * String line;
	            while ((line = reader.readLine()) != null) {
	                System.out.println(line);
	            }
	         	}
	         */
	            
	        
	   
	        
	        int rc = p.waitFor();
	        
	        if (rc == 0) {
	        	System.out.println("El codigo es correcto."); 
	        } else {
	        	throw new Exception ("Codigo no valido."); 
	        }
	        
	        System.out.println("RC=" + rc);
	    }
}
