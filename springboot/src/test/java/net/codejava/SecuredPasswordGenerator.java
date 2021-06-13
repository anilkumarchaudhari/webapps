package net.codejava;
 
import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 
public class SecuredPasswordGenerator {
 
    public static void main(String[] args) {
       // BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //String rawPassword = "admin";
       // String encodedPassword = encoder.encode(rawPassword);
        Scanner sc= new Scanner(System.in); 
        int n=sc.nextInt();
       // System.out.println(encodedPassword);
//    	for(int i=1;i<=n;i++) {
//    		int alpha=65;
//    		for(int j=1;j<=i;j++ ) {
//    			System.out.print((char)alpha+" ");
//    			alpha++;
//    		}
//    		System.out.println();
//    	}
        for(int i=1;i<=n;i++) {
        	//loop to print space
        	for(int j=n;j>i;j--) {
        		System.out.print(" ");
        	}
        	//loop to print alphabet
        	int alpha=65;
        	for(int k=1;k<=i;k++) {
        		System.out.print((char)alpha+" ");
    			alpha++;
        		
        	}
        	//for next line
        	System.out.println();
        }
    }
 
}