import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Phone samsungPhone = (Phone) Factory.createProduct(Factory.productType.SamsungPhone, "Galaxy_XL", 2500.00, "Silver", 300);
        Phone applePhone = (Phone) Factory.createProduct(Factory.productType.ApplePhone, "IPhone_X10", 4000.00, "Black", 250);
        Laptop importedLaptop = (Laptop) Factory.createProduct(Factory.productType.ImportedLaptop, "DELL", 5000.00, "White", 150);
        Laptop normalLaptop = (Laptop) Factory.createProduct(Factory.productType.Laptop, "Lenovo", 3700.00, "Gray", 130);
        Camera camera = (Camera) Factory.createProduct(Factory.productType.Camera, "Canon", 2800.00, "Black", 100);
        Printer printerCartridge = (Printer) Factory.createProduct(Factory.productType.PrinterWithCartridge, "HP", 1200.00, "Black", 100);
        Printer printerLaser = (Printer) Factory.createProduct(Factory.productType.PrinterWithoutCartridge, "EPSON", 2400.00, "Black", 120);

        Shop.getProduct(samsungPhone, 50);
        Shop.getProduct(applePhone, 50);
        Shop.getProduct(importedLaptop, 20);
        Shop.getProduct(normalLaptop, 20);
        Shop.getProduct(camera, 30);
        Shop.getProduct(printerCartridge, 40);
        Shop.getProduct(printerLaser, 25);
        // ShopBS.showInventory();
        // Initial stock
        ShoppingCart myCart = ShoppingCart.getInstance();
        // Shop.showInventory();
        // Final stock
        Shop.remainStock();
    }
}