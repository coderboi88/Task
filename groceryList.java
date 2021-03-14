/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;


class GroceryItem{
    public String name;
    public String quantity;
    public int price;

    public GroceryItem(String name, String quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    
    public String getName(){
        return name;
    }
    
    public String getQuantity(){
        return quantity;
    }
    
    public void setQuantity(String q){
       String[] a = quantity.split(" ");
       String[] b = q.split(" ");
       
       int ac = Integer.parseInt(a[0]);
       int bc = Integer.parseInt(b[0]);
       
       quantity = Integer.toString(bc+ac) + a[1];
    }
    
    
    public int getPrice(){
        return price;
    }
    
    public void setPrice(int p){
        price = p+price;
    }
}
/**
 *
 * @author hp
 */
public class groceryList {
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter Your Budget");
        float amount=0;
        boolean loop=true;
        try{
            amount = s.nextFloat();
        }
        catch(Exception e){
            System.out.println("Please Enter Valid Amount");
        }
        
        List<GroceryItem> items = new ArrayList<>();
        
        while(loop){
            System.out.println("1. Add an Item");
            System.out.println("2. Exit");
            
            int e=0;
            try{
                e = s.nextInt();
                s.nextLine();
            }catch(Exception err){
                System.out.println("Please Select From Given option by typing the proper number");
            }
             
            if(e==2){
                loop=false;
                display(items,(int)amount);
            }
            
            else{
                System.out.println("Enter Product : ");
                String name  = s.nextLine();
                System.out.println("Enter Quantity : ");
                String quantity = s.nextLine();
                //String[] at = quant.split(" ");
                //int quantity = Integer.parseInt(at[0]);
                System.out.println("Enter Price : ");
                int price = s.nextInt();
                
                
                if(amount-price>=0){
                    List<GroceryItem> gi = items.stream().filter(a->Objects.equals(a.name,name )).collect(Collectors.toList());
        
                    if(gi.size()>0){
                        items.get(0).setPrice(price);
                        items.get(0).setQuantity(quantity);
                    }
                    else{
                        items.add(new GroceryItem(name, quantity, price));
                    }
                    amount = amount-price;
                    System.out.println("Amount Left : "+amount);
                }
                else{
                    System.out.println("Can't buy the product ###(because budget left is "+amount+")");
                }
            }
            
        }
        
    }
    
    
    public static void display(List<GroceryItem> list,int totalAmount){
        
        List<GroceryItem> gi = list.stream().filter(a->Objects.equals(a.price, totalAmount)).collect(Collectors.toList());
        
        if(gi.size()>0){
            System.out.println("You Can Buy "+gi.get(0).getName());
        }
       
        System.out.println("Name"+"\t"+"Quan."+"\t"+"Price");
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getName()+"\t"+list.get(i).getQuantity()+"\t"+list.get(i).getPrice());
        }
    }
}

 