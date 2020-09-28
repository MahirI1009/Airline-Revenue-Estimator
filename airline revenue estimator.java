import java.util.Scanner;

public class AirlineRevenueEstimator {

    public static void main(String[] args) throws Exception {
       
        String Inventory = "Inventory.txt"; //data file location
        java.io.File myfile = new java.io.File(Inventory); 
        Scanner in = new Scanner(myfile); //creates scanner
        
        System.out.println("Item\tUnit\tQuantity\tUnit\tSelling\tTotal"); //header
        System.out.println("Number\tWeight\t\t\tCost\tPrice\tWeight"); //header
        
        int cnt = 0, cnt10 = 0, cnt20 = 0; //to count number of items processed
        int data = in.nextInt(); //checks first number of file to see how much data it will process
        int itemNum, weight, quan, total, sumwt = 0; //declares int values
        double cost, sell, sumsell = 0; //declares floating point values
        
        for (int a = 1; a <= data; a++) { //will assign a value to a variable until all the data is processed
            itemNum = in.nextInt(); //number of items
            cnt++; //counts number of items processed
            weight = in.nextInt(); //unit weight
            sumwt += weight; //sum of unit weight of all items
            quan = in.nextInt(); //quantity
            cost = in.nextDouble(); //unit cost
            sell = sellingPrice(cost); //calls method that will compute selling price and return
            sumsell += sell; //sum of selling price
            total = totalWeight(weight,quan); //calls method that will compute total weight and return
            System.out.printf("%d\t%d\t%d\t\t%.2f\t%.2f\t%d%n", itemNum,weight,quan,cost,sell,total);
            //prints all items and processed data
                if (cost <= 10.00) //checks to see if less than or equal to 10.00 
                    cnt10++;
                else cnt20++; //if more than 10.00 then will count if selling price is at 10% or 2-%
        }
        double avgsell = 1.0 * sumsell/cnt, avgwt = 1.0 * sumwt/cnt; //average sellig price
        System.out.println("\nThe total number of items processed is: " + cnt);
        System.out.printf("The average unit weight is: %.2f%n", avgwt); 
        System.out.printf("The average selling price of the items is: %.2f%n", avgsell);
        System.out.println("The number of items whose selling price was computed at the 10% level is: " + cnt10);
        System.out.println("The number of items whose selling price was computed at the 10% level is: " + cnt20);
    }
    
    public static double sellingPrice (double a) {
    
        if (a <= 10.00)
            a = a * 1.10; //if less than or equal to 10.00 then increased by 10%
        else a = a * 1.20; //if more than 10.00 than increased by 20%
        
        return a; //returns selling price
}
    
    public static int totalWeight (int a, int b) {
        int c = a * b; //takes the weight and quanity and multiplies them
        return c; //returns product of weight and quantity of item number
    }  
}
