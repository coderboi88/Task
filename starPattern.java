/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.util.Scanner;

/**
 *
 * @author hp
 */
public class starPattern {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i,j,k;
        System.out.println("Enter No. of Rows: ");
        int n = sc.nextInt();
        
        for(i=1;i<=n;i++){
            for(k=0;k<n-i;k++){
                System.out.print(" ");
            }
            
            for(j=0;j<i;j++){
                System.out.print("* ");
             
            }
            System.out.print("\n");
        }
        
    }
    
}
