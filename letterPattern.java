/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.util.Scanner;

public class letterPattern {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i,j,k,count=65;
        System.out.println("Enter No. of Rows: ");
        int n = sc.nextInt();
        
        for(i=1;i<=n;i++){
            for(k=0;k<n-i;k++){
                System.out.print(" ");
            }
            for(j=1;j<=i;j++){
                if(count==91){
                    count=65;
                }
                char c = (char)count++;
                System.out.print(c);
            }
            System.out.println("");
        }
        
    }
}
