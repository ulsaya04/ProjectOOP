import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Shop {
    private static final Product[] inventory = new Product[7];
    private static int i = -1;
    public Shop() {

    }
    public static void getProduct(Product product, int amount) {
        ++i;
        inventory[i] = product;
        inventory[i].setStockNum(amount);
    }
    public static Product sendProduct(Factory.productType type) {
        switch (type) {
            case SamsungPhone:
                inventory[0].setStockNum(inventory[0].getStockNum() - 1);
                return inventory[0];
            case ApplePhone:
                inventory[1].setStockNum(inventory[1].getStockNum() - 1);
                return inventory[1];
            case ImportedLaptop:
                inventory[2].setStockNum(inventory[2].getStockNum() - 1);
                return inventory[2];
            case Laptop:
                inventory[3].setStockNum(inventory[3].getStockNum() - 1);
                return inventory[3];
            case Camera:
                inventory[4].setStockNum(inventory[4].getStockNum() - 1);
                return inventory[4];
            case PrinterWithCartridge:
                inventory[5].setStockNum(inventory[5].getStockNum() - 1);
                return inventory[5];
            case PrinterWithoutCartridge:
                inventory[6].setStockNum(inventory[6].getStockNum() - 1);
                return inventory[6];
        }
        return null;
    }
    public static void returnProduct(Factory.productType type) {
        switch (type) {
            case SamsungPhone:
                System.out.println(inventory[0].getStockNum());
                inventory[0].setStockNum(inventory[0].getStockNum() + 1);
                break;
            case ApplePhone:
                inventory[1].setStockNum(inventory[1].getStockNum() + 1);
                break;
            case ImportedLaptop:
                inventory[2].setStockNum(inventory[2].getStockNum() + 1);
                break;
            case Laptop:
                inventory[3].setStockNum(inventory[3].getStockNum() + 1);
                break;
            case Camera:
                inventory[4].setStockNum(inventory[4].getStockNum() + 1);
                break;
            case PrinterWithCartridge:
                inventory[5].setStockNum(inventory[5].getStockNum() + 1);
                break;
            case PrinterWithoutCartridge:
                inventory[6].setStockNum(inventory[6].getStockNum() + 1);
                break;
        }
    }
    public static void showInventory() {
        if(i==-1) {
            System.out.println("Inventory is empty!!!");
        }else{
            System.out.println("Inventory has : ");
            for(int k=0; k<i+1; k++) {
                System.out.println("Name : " + inventory[k].getName() + " (" + inventory[k].getStockNum() + ")");
            }
        }
    }
    public static void remainStock() throws IOException {
        BufferedWriter output = null;
        try {
            File file = new File("StockOnHand.txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write("Inventory has : \n");
            for(int k=0; k<i+1; k++) {
                output.write(inventory[k].getName() + " (" + inventory[k].getStockNum() + ")\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null)
                output.close();
        }
    }
    public static void giveReceipt(Product[] cart, int[] amount) throws IOException {
        BufferedWriter output = null;
        try {
            File file = new File("Receipt.txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write("Your items: \n");
            for(int k=0; k<7; k++) {
                if(cart[k]!=null) {
                    output.write(cart[k].getName()+" ["+amount[k]+"] x " + Double.toString(cart[k].getPrice()) + "$\n");
                }
            }
            output.write("Total cost(without tax) is: " + ShoppingCart.getCost() + " $\n");
            output.write("Total cost(with tax) is: " + Double.toString(ShoppingCart.getCost()*1.18) + " $\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null)
                output.close();
        }
    }
}
