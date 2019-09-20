import java.util.Scanner;
class CoffeeMaker {
    static String waterShortage = "Sorry, not enough water!";
    static String milkShortage = "Sorry, not enough milk!";
    static String coffeeShortage = "Sorry, not enough coffee beans!";
    static String cupsShortage = "Sorry, not enough disposable cups!";
    static String enough = "I have enough resources, making you a coffee!";
    int curWater;
    int curMilk ;
    int curCoffee;
    int money;
    int cups;
    CoffeeMaker() {
        curWater = 400;
        curMilk = 540;
        curCoffee = 120;
        money = 550;
        cups = 9;
    }
    void status() {
        System.out.println("The coffee machine has:");
        System.out.println(curWater+" of water");
        System.out.println(curMilk+" of milk");
        System.out.println(curCoffee+" of coffee beans");
        System.out.println(cups+" of disposable cups");
        System.out.println("$"+money+" of money");
        System.out.println();
    }
    String checkEspresso() {
        if (curWater<250) {
            return(waterShortage);
        }
        if (curCoffee <16) {
            return(coffeeShortage);
        }
        if (cups < 1) {
            return(cupsShortage);
        }
        curWater -= 250;
        curCoffee -= 16;
        money +=4;
        cups--;
        return enough;
    }
    String checkLatte() {
        if (curWater<350) {
            return(waterShortage);
        }
        if (curMilk <75) {
            return(milkShortage);
        }
        if (curCoffee <20) {
            return(coffeeShortage);
        }
        if (cups < 1) {
            return(cupsShortage);
        }
        curWater -= 350;
        curMilk -=75;
        curCoffee -= 20;
        money +=7;
        cups--;
        return enough;
    }
    String checkCappucino() {
        if (curWater<200) {
            return(waterShortage);
        }
        if (curMilk <100) {
            return(milkShortage);
        }
        if (curCoffee <12) {
            return(coffeeShortage);
        }
        if (cups < 1) {
            return(cupsShortage);
        }
        curWater -= 200;
        curMilk -= 100;
        curCoffee -= 12;
        money +=6;
        cups--;
        return enough;
    }
    void buying() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String n = scanner.nextLine();
        switch (n) {
            case "1":
                System.out.println(checkEspresso());
                break;
            case "2":
                System.out.println(checkLatte());
                break;
            case "3":
                System.out.println(checkCappucino());
                break;
            case "back":
            default:
                //error
        }
    }
    void filling() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write how many ml of water do you want to add: ");
        curWater += scanner.nextInt();
        System.out.print("Write how many ml of milk do you want to add: ");
        curMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        curCoffee += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:  ");
        cups += scanner.nextInt();
    }
    void taking() {
        System.out.println("I gave you $"+money);
        money = 0;
    }
    boolean work(String mode) {
        switch (mode) {
            case "remaining":
                status();
                return true;
            case "buy":
                buying();
                return true;
            case "fill":
                filling();
                return true;
            case "take":
                taking();
                return true;
            case "exit":
            default:
                return false;
        }
    }

}
public class HelloWorld {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean cont = true;
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        while (cont) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            System.out.println();
            String s = scanner.nextLine();
            cont = coffeeMaker.work(s);
        }
    }
}
