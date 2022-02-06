import java.util.Scanner;
public class CoffeeMachine {
    static int waterAmount = 400;
    static int milkAmount = 540;
    static int coffeeAmount = 120;
    static int cupsAmount = 9;
    static int money = 550;
    static String action;
    static boolean end = false;
    static int[][] recipes = {{250, 0, 16, 4}, {350, 75, 20, 7}, {200, 100, 12, 6}};
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while(!end){
            takeAction();
        }

        enum colors {
            RED, BLUE, GREEN, YELLOW
        }
    }

    public static void remaining(){
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water", waterAmount);
        System.out.printf("\n%d ml of milk", milkAmount);
        System.out.printf("\n%d g of coffee beans", coffeeAmount);
        System.out.printf("\n%d disposable cups", cupsAmount);
        System.out.printf("\n$%d of money\n", money);
    }

    public static void takeAction() {
        System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
        action = scanner.next().toLowerCase();
        switch (action) {
            case "buy" -> buy();
            case "fill" -> fill();
            case "take" -> take();
            case "remaining" -> remaining();
            case "exit" -> end = true;
        }
    }

    public static void buy(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
            try {
                int coffeeType = scanner.nextInt();
                if (cupsAmount <= 0 || waterAmount <= recipes[coffeeType - 1][0] ||
                milkAmount <= recipes[coffeeType - 1][1] || coffeeAmount <= recipes[coffeeType - 1][2]) {
                    System.out.println("Sorry, not enough ingredients");
                    takeAction();
                } else {
                    waterAmount -= recipes[coffeeType - 1][0];
                    milkAmount -= recipes[coffeeType - 1][1];
                    coffeeAmount -= recipes[coffeeType - 1][2];
                    cupsAmount--;
                    money += recipes[coffeeType - 1][3];
                    System.out.println("I have enough resources, making you a coffee!");
                }
            } catch (Exception e) {
                takeAction();
            }
        }

    public static void fill(){
        System.out.println("Write how many ml of water you want to add: ");
        waterAmount += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milkAmount += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        coffeeAmount += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        cupsAmount += scanner.nextInt();
    }

    public static void take(){
        System.out.printf("\nI gave you $%d", money);
        money -= money;
    }
}