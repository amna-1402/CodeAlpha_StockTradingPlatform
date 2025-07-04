import java.util.ArrayList;
import java.util.Scanner;
class StockTradingPlatform {
public class Stock{
    String stockName;
    double stockPrice;
    int stockQuantity;
    public Stock(String stockName, double stockPrice, int stockQuantity) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        this.stockQuantity = stockQuantity;
    }
     public void display() {
        System.out.println(stockName+ " - " + stockPrice + " - $" + stockQuantity);
    }
 }
    public static void main(String[] args) {
        ArrayList<Stock> stocks = new ArrayList<>();
        stocks.add(new StockTradingPlatform().new Stock("Apple", 150.00, 100));
        stocks.add(new StockTradingPlatform().new Stock("Google", 2800.00, 50));
        stocks.add(new StockTradingPlatform().new Stock("Amazon", 3400.00, 30));
        Scanner input=new Scanner(System.in);
        System.out.println("Welcome to the Stock Trading Platform!");
        System.out.println("Enter your name:");
        String name =input.nextLine();
        double startingBalance = 10000.00f; 
        System.out.println("Hello, " + name );
        System.out.printf("Your Starting balance is: $%.2f\n", startingBalance);
        while(true){
        System.out.println("------Menu------");
        System.out.println("1. View Stocks");
        System.out.println("2. Buy Stock");
        System.out.println("3. Sell Stock");
        System.out.println("4. View Portfolio");
        System.out.println("5. Exit");
        int choice= input.nextInt();
        if (choice == 1){
            AvailableStocks availableStocks = new StockTradingPlatform().new AvailableStocks();
            availableStocks.displayStocks(stocks);
        }
        else if(choice == 2){
            System.out.println("Enter the stock name you want to buy:");
            String stockName = input.next();
            System.out.println("Enter the quantity you want to buy:");
            int quantity = input.nextInt();
            for (Stock stock : stocks){
                if (stock.stockName.equalsIgnoreCase(stockName)){
                    if(quantity <= stock.stockQuantity) {
                        stock.stockQuantity -= quantity;
                        System.out.println("You bought " + quantity + " shares of " + stockName);
                        System.out.println("Remaining stock quantity: " + stock.stockQuantity);
                        startingBalance = startingBalance - (stock.stockPrice * quantity);
                        System.out.printf("Your remaining balance is: $%.2f\n", startingBalance);

                    } else {
                        System.out.println("Insufficient stock quantity available.");
                    }
                }
            }
        }
        else if(choice ==3){
            System.out.println("Enter the stock name you want to sell:");
            String stockName = input.next();
            System.out.println("Enter the quantity you want to sell:");
            int quantity = input.nextInt();
            for (Stock stock : stocks){
                if (stock.stockName.equalsIgnoreCase(stockName)){
                    stock.stockQuantity += quantity;
                    System.out.println("You sold " + quantity + " shares of " + stockName);
                    System.out.println("New stock quantity: " + stock.stockQuantity);
                    startingBalance = startingBalance + (stock.stockPrice * quantity);
                    System.out.printf("Your remaining balance is: $%.2f\n", startingBalance);
                }
            }
        }
     else if (choice == 4) {
    System.out.println("---------Your Portfolio------");
    System.out.println("Hello! " + name);
    System.out.println("Your Balance is: $" + startingBalance);
    System.out.println("-----Your Stocks:-------");

    boolean ownsStock = false;

    for (Stock stock : stocks) {
        int owned = 100 - stock.stockQuantity; 
        if (owned > 0) {
            ownsStock = true;
            System.out.println(stock.stockName + " - " + owned + " shares");
        }
    }

    if (!ownsStock) {
        System.out.println("You do not own any stocks yet.");
    }
}

        else if(choice == 5){
            System.out.println("Thank you for using the Stock Trading Platform!");
            break;
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }
}
public class AvailableStocks {
    public void displayStocks(ArrayList<Stock> stocks) {
        System.out.println("-----Available Stocks:-------");
        for (Stock s : stocks) 
            s.display();
        
    }
}}