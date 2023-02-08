import java.io.IOException;
import java.util.Scanner;

public class ShoppingCart {
    private static double totalCost = 0;
    private static int itemNum = 0;
    private static Product[] cart = new Product[7];
    private static int[] amount = new int[7];
    private static ShoppingCart instance = new ShoppingCart();
    public static ShoppingCart getInstance() { return instance; }
    private ShoppingCart() {
        boolean end = true;
        while (end) {
            System.out.println("List of items:\n" +
                    "1. Camera\n" +
                    "   1.1 CANON\n" +
                    "2. Laptop\n" +
                    "   2.1. DELL\n" +
                    "   2.2. Lenovo\n" +
                    "3. Phone\n" +
                    "   3.1. Samsung\n" +
                    "   3.2. Apple\n" +
                    "4. Printer\n" +
                    "   4.1 HP - cartridge\n" +
                    "   4.2. EPSON - laser\n" +
                    "Enter the name of the item you want\n" +
                    "To return the item enter 'Return'\n" +
                    "Then enter the name of the item\n" +
                    "To see the cart enter 'Show'\n" +
                    "To finish shopping enter 'Finish'.");
            Scanner input = new Scanner(System.in);
            String str = input.nextLine();
            if (str.equals("Finish")) { end = false;
                try {
                    Shop.giveReceipt(cart, amount);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (str.equals("Show")) { showCart(); showCost();
            } else if (str.equals("Return")) {
                Scanner input2 = new Scanner(System.in);
                String item = input2.nextLine();
                if (item.equals("Samsung")) {
                    if(amount[0]>0) {
                        Shop.returnProduct(Factory.productType.SamsungPhone);
                        amount[0]--;
                        if(amount[0]==0) { cart[0] = null; }
                    }else { System.out.println("You do not have this item!!!"); }
                }else if (item.equals("Apple")) {
                    if(amount[1]>0) {
                        Shop.returnProduct(Factory.productType.ApplePhone);
                        amount[1]--;
                        if(amount[1]==0) { cart[1] = null; }
                    }else { System.out.println("You do not have this item!!!"); }
                }else if (item.equals("DELL")) {
                    if(amount[2]>0) {
                        Shop.returnProduct(Factory.productType.ImportedLaptop);
                        amount[2]--;
                        if(amount[2]==0) { cart[2] = null; }
                    }else { System.out.println("You do not have this item!!!"); }
                }else if (item.equals("Lenovo")) {
                    if(amount[3]>0) {
                        Shop.returnProduct(Factory.productType.Laptop);
                        amount[3]--;
                        if(amount[3]==0) { cart[3] = null; }
                    }else { System.out.println("You do not have this item!!!"); }
                }else if (item.equals("CANON")) {
                    if(amount[4]>0) {
                        Shop.returnProduct(Factory.productType.Camera);
                        amount[4]--;
                        if(amount[4]==0) { cart[4] = null; }
                    }else { System.out.println("You do not have this item!!!"); }
                }else if (item.equals("HP")) {
                    if(amount[5]>0) {
                        Shop.returnProduct(Factory.productType.PrinterWithCartridge);
                        amount[5]--;
                        if(amount[5]==0) { cart[5] = null; }
                    }else { System.out.println("You do not have this item!!!"); }
                }else if (item.equals("EPSON")) {
                    if(amount[6]>0) {
                        Shop.returnProduct(Factory.productType.PrinterWithoutCartridge);
                        amount[6]--;
                        if(amount[6]==0) { cart[6] = null; }
                    }else { System.out.println("You do not have this item!!!"); }
                }
            } else if (str.equals("Samsung")) {
                if(cart[0]==null) {
                    cart[0] = Shop.sendProduct(Factory.productType.SamsungPhone);
                    amount[0] = 1;
                    itemNum++;
                } else {
                    if(amount[0]<=cart[0].getStockNum()) {
                        cart[0] = Shop.sendProduct(Factory.productType.SamsungPhone);
                        amount[0]++; itemNum++;
                    }else { System.out.println("Stock is finished!!!"); }
                }
            } else if (str.equals("Apple")) {
                if(cart[1]==null) {
                    cart[1] = Shop.sendProduct(Factory.productType.ApplePhone);
                    amount[1] = 1;
                    itemNum++;
                } else {
                    if(amount[1]<=cart[1].getStockNum()) {
                        cart[1] = Shop.sendProduct(Factory.productType.ApplePhone);
                        amount[1]++; itemNum++;
                    }else { System.out.println("Stock is finished!!!"); }
                }
            } else if (str.equals("DELL")) {
                if(cart[2]==null) {
                    cart[2] = Shop.sendProduct(Factory.productType.ImportedLaptop);
                    amount[2] = 1;
                    itemNum++;
                } else {
                    if(amount[2]<=cart[2].getStockNum()) {
                        cart[2] = Shop.sendProduct(Factory.productType.ImportedLaptop);
                        amount[2]++; itemNum++;
                    }else { System.out.println("Stock is finished!!!"); }
                }
            } else if (str.equals("Lenovo")) {
                if(cart[3]==null) {
                    cart[3] = Shop.sendProduct(Factory.productType.Laptop);
                    amount[3] = 1;
                    itemNum++;
                } else {
                    if(amount[3]<=cart[3].getStockNum()) {
                        cart[3] = Shop.sendProduct(Factory.productType.Laptop);
                        amount[3]++; itemNum++;
                    }else { System.out.println("Stock is finished!!!"); }
                }
            } else if (str.equals("CANON")) {
                if(cart[4]==null) {
                    cart[4] = Shop.sendProduct(Factory.productType.Camera);
                    amount[4] = 1;
                    itemNum++;
                } else {
                    if(amount[4]<=cart[4].getStockNum()) {
                        cart[4] = Shop.sendProduct(Factory.productType.Camera);
                        amount[4]++; itemNum++;
                    }else { System.out.println("Stock is finished!!!"); }
                }
            } else if (str.equals("HP")) {
                if(cart[5]==null) {
                    cart[5] = Shop.sendProduct(Factory.productType.PrinterWithCartridge);
                    amount[5] = 1;
                    itemNum++;
                } else {
                    if(amount[5]<=cart[5].getStockNum()) {
                        cart[5] = Shop.sendProduct(Factory.productType.PrinterWithCartridge);
                        amount[5]++; itemNum++;
                    }else { System.out.println("Stock is finished!!!"); }
                }
            } else if (str.equals("EPSON")) {
                if(cart[6]==null) {
                    cart[6] = Shop.sendProduct(Factory.productType.PrinterWithoutCartridge);
                    amount[6] = 1;
                    itemNum++;
                } else {
                    if(amount[6]<=cart[6].getStockNum()) {
                        cart[6] = Shop.sendProduct(Factory.productType.PrinterWithoutCartridge);
                        amount[6]++;itemNum++;
                    }else { System.out.println("Stock is finished!!!"); }
                }
            }
        }
    }
    public static void showCart() {
        if(itemNum==0) { System.out.println("Cart is empty!!!");
        }else {
            System.out.println("Your items :");
            for (int k = 0; k < 7; k++) { if(cart[k]!=null) { System.out.println(cart[k].getName()+"("+amount[k]+")"); } }
            System.out.println("Total items : "+itemNum);
        }
    }
    public static void showCost() {
        totalCost = 0;
        for (int k = 0; k < 7; k++) { if(cart[k]!=null) { totalCost += cart[k].getPrice() * amount[k]; } }
        System.out.println("Total cost : "+totalCost+"$\n"+"Total cost with taxes : "+totalCost*1.18+"\n"+
                "Tax rate is %18 for every product.\n" +
                "For imported products there is extra %25 tax rate.");
    }
    public static double getCost() {
        totalCost = 0;
        for (int k = 0; k < 7; k++) { if(cart[k]!=null) { totalCost += cart[k].getPrice() * amount[k]; } }
        return totalCost;
    }
}