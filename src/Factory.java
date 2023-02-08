public class Factory {
    public enum productType {
        SamsungPhone,
        ApplePhone,
        Laptop,
        ImportedLaptop,
        PrinterWithCartridge,
        PrinterWithoutCartridge,
        Camera,
    }
    public static Product createProduct(productType t, String name, double price, String color, int stockNum) {
        switch (t) {
            case SamsungPhone:
                Phone p1 = new Phone(name, price, color, stockNum);
                p1.setBrand("Samsung");
                return p1;
            case ApplePhone:
                Phone p2 = new Phone(name, price, color, stockNum);
                p2.setBrand("Apple");
                return p2;
            case ImportedLaptop:
                Laptop l1 = new Laptop(name, price, color, stockNum);
                l1.setTax(0.25);
                return l1;
            case Laptop:
                Laptop l2 = new Laptop(name, price, color, stockNum);
                l2.setTax(0.0);
                return l2;
            case PrinterWithCartridge:
                Printer pt1 = new Printer(name, price, color, stockNum);
                pt1.setCartridge(true);
                return pt1;
            case PrinterWithoutCartridge:
                Printer pt2 = new Printer(name, price, color, stockNum);
                pt2.setCartridge(false);
                return pt2;
            case Camera:
                Camera c1 = new Camera(name, price, color, stockNum);
                return c1;
        }
        return null;
    }
}