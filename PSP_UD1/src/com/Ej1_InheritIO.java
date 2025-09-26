package com;

public class Ej1_InheritIO {
	
	public static void main(String[] args) throws Exception {
	       
        ProcessBuilder pb = new ProcessBuilder(Utils.sh(String.join(" ", args)));
        pb.inheritIO(); 
        Process p = pb.start();
        
        
        int rc = p.waitFor(); 
        
        if (rc == 0) {
        	System.out.println("El comando es correcto."); 
        } else {
        	throw new Exception ("El comando no es correcto."); 
        }
        
        System.out.println("RC= " + rc);
	}
}
