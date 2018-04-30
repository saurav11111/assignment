/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop;

import static java.lang.System.exit;
import java.util.Scanner;

interface Coffee {
    void Milk();
    void Caffeine();
    void Sugar();
}

class CoffeeFactory {
    private static CoffeeFactory coffeeFactory;

    private CoffeeFactory(){}

    public static CoffeeFactory getCoffeeFactory(){
        if(coffeeFactory == null){
            coffeeFactory = new CoffeeFactory();
        }
        return coffeeFactory;
    }

    public static Coffee makeCoffee(String choice){
        switch (choice) {
            case "A":
                return new CoffeeA();
            case "B":
                return new CoffeeB();
            case "C":
                return new CoffeeC();
            default:
                return null;
        }
    }
}
class CoffeeA implements Coffee {
    @Override
    public void Milk() {
        System.out.println("Milk added to CoffeeA");
    }

    @Override
    public void Caffeine() {
        System.out.println("Caffeine added to CoffeeA");
    }

    @Override
    public void Sugar() {
        System.out.println("Sugar added to CoffeeA");
    }
}

class CoffeeB implements Coffee {
    @Override
    public void Milk() {
        System.out.println("Milk added to CoffeeB");
    }

    @Override
    public void Caffeine() {
        System.out.println("Caffeine added to CoffeeB");
    }

    @Override
    public void Sugar() {
        System.out.println("Sugar cannot be added to CoffeeB");
    }
}
class CoffeeC implements Coffee{
    @Override
    public void Milk() {
        System.out.println("Milk added to CoffeeC");
    }

    @Override
    public void Caffeine() {
        System.out.println("Caffeine added to CoffeeC");
    }

    @Override
    public void Sugar() {
        System.out.println("Sugar added to CoffeeC");
    }
}

public class CoffeeShop {

    
    public static void main(String[] args) {
       
         CoffeeFactory coffeeFactory = CoffeeFactory.getCoffeeFactory();
        Coffee coffee = null;

        Scanner s = new Scanner(System.in);

        String input = null;

        System.out.println(" Type A for Coffee A , B for Coffee B and C for Coffee C.");

        if(s.hasNextLine()){
            input = s.nextLine();
        }

        switch (input) {
            case "A":
                coffee = coffeeFactory.makeCoffee("A");
                break;
            case "B":
                coffee = coffeeFactory.makeCoffee("B");
                break;
            case "C":
                coffee = coffeeFactory.makeCoffee("C");
                break;
            default:
                System.out.println("Nothing has been chosen");
                exit(1);
                break;
        }

        coffee.Caffeine();
        coffee.Milk();
        coffee.Sugar();
    }
    
}
