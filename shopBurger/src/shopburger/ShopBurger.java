/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopburger;

import java.util.LinkedList;
import java.util.Scanner;



 interface Burger {
    void addPatty();
    void addSauce();
    void addCheese();
    madeBurger getBurger();
}

 class madeBurger {
    
    private final LinkedList<String> parts;
    
    public madeBurger(){
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
        myBurger.addPatty();
        myBurger.addSauce();
        myBurger.addCheese();
    }    
}

class Chicken implements Burger {
    
    private final madeBurger burger = new madeBurger();
    @Override
    public void addPatty() {
        burger.Add("This is the patty for chickenburger");
    }

    @Override
    public void addSauce() {
        burger.Add("Sauce for chickenburger");
    }

    @Override
    public void addCheese() {
        burger.Add("Cheese for chickenburger");
    }
    @Override
    public madeBurger getBurger(){
        return burger;
    }
}

class Beef implements Burger {
    
    private final madeBurger burger = new madeBurger();
    @Override
    public void addPatty() {
        burger.Add("This is the patty for beefburger");
    }

    @Override
    public void addSauce() {
        burger.Add("Sauce added for beefburger");
    }

    @Override
    public void addCheese() {
        burger.Add("Cheese added for beefburger");
    }
    @Override
    public madeBurger getBurger(){
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
            Burger myburger = new Beef();
            waiter.make(myburger);
            madeBurger p1 = myburger.getBurger();
            p1.show();
        } else if(input.equals("C")){
            Burger myburger = new Chicken();
            waiter.make(myburger);
            madeBurger p1 = myburger.getBurger();
            p1.show();
        } 
    }
    
}
