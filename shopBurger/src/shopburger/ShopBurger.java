/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopburger;

import java.util.LinkedList;
import java.util.Scanner;



 interface Burger {
    void Patty();
    void Sauce();
    void Cheese();
    Burgertype getBurger();
}

 class Burgertype {
    
    private final LinkedList<String> parts;
    
    public Burgertype(){
        parts = new LinkedList<>();
    }
    
    public void Add(String part){
        parts.addLast(part);
    }
    
    public void show(){
        System.out.println("\nBurger served as below: ");
        for (String part : parts) {
            System.out.println(part);
        }
    }
}

class Waiter {
    Burger myBurger;
    
    public void make(Burger burger){
        myBurger = burger;
        myBurger.Patty();
        myBurger.Sauce();
        myBurger.Cheese();
    }    
}

class ChickenBurger implements Burger {
    
    private final Burgertype burger = new Burgertype();
    @Override
    public void Patty() {
        burger.Add("This is the patty for chickenburger");
    }

    @Override
    public void Sauce() {
        burger.Add("Sauce for chickenburger");
    }

    @Override
    public void Cheese() {
        burger.Add("Cheese for chickenburger");
    }
    @Override
    public Burgertype getBurger(){
        return burger;
    }
}

class BeefBurger implements Burger {
    
    private final Burgertype burger = new Burgertype();
    @Override
    public void Patty() {
        burger.Add("This is the patty for beefburger");
    }

    @Override
    public void Sauce() {
        burger.Add("Sauce added for beefburger");
    }

    @Override
    public void Cheese() {
        burger.Add("Cheese added for beefburger");
    }
    @Override
    public Burgertype getBurger(){
        return burger;
    }
}




public class ShopBurger {

  
    public static void main(String[] args) {
       Waiter waiter = new Waiter();
        Scanner s = new Scanner(System.in);

        String input = null;

        System.out.println("Select an option. Type B for Beefburger , C for Chickenburger.");

        if(s.hasNextLine()){
            input = s.nextLine();
        }

        if(input.equals("B")){
            Burger myburger = new BeefBurger();
            waiter.make(myburger);
            Burgertype p1 = myburger.getBurger();
            p1.show();
        } else if(input.equals("C")){
            Burger myburger = new ChickenBurger();
            waiter.make(myburger);
            Burgertype p1 = myburger.getBurger();
            p1.show();
        } 
    }
    
}
