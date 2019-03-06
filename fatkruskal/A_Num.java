/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.fatkruskal;


import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class A_Num {
    public A_Num(){};
   static Scanner scan;
    public int fact(int n){
          int f = 1;
     for (int i = 2; i <= n; i++) 
      
        f *= i; 

    return f; 
} 
    
    float u_cal(float u, int n) 
{ 

    float temp = u; 

    for (int i = 1; i < n; i++) 

        temp = temp * (u - i)/

                                 fact(i); ; 

    return temp; 
} 

  
    public static void main(String[] args) {
        
 scan = new Scanner(System.in);
  Scanner sc = new Scanner(System.in);
        
        System.out.println("Entrer La Valeur de n");
        int n = sc.nextInt();
        
         float[] x = new float[n];
         for (int i = 0; i < n; i++) {
             System.out.println("Entrer La Valeur de x["+i+"]");
               x[i] = scan.nextInt();
         } 

           float[][] y = new float[n][n];
           for (int i = 0; i < n; i++) {
	   System.out.println("Entrer La Valeur de y["+i+"]");
           y[i][0] = scan.nextInt();

        // TODO code application logic here
    }
           
           
           
            for (int i = 1; i < n; i++) { 

        for (int j = 0; j < n - i; j++) 

            y[j][i] = y[j + 1][i - 1] - y[j][i - 1]; 

    } 

  System.out.println(x[0]);
  for (int i = 0; i < n ; i++) 
   System.out.println(y[0][i]);        
    
  
  
  
  System.out.println("enter the value of x pour calculer le polynome Pn");
    float value = sc.nextInt();
    A_Num poly=new A_Num();
    
    
     float sum = y[0][0]; 
      float resultat;
       float u = (value - x[0]) / (x[1] - x[0]);

    for (int i = 1; i < n; i++) { 
        sum = sum +(poly.u_cal(u, i) * y[0][i]) ;
        
   } 
     resultat=y[0][0]+sum ;
    
      System.out.println("le polynome Pn"+value+"est :"+resultat);

}
}