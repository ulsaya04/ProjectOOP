public class Phone extends Product {
    private String brand;
    public Phone(String name, double price, String color, int stockNum) {
        super(name, price, color, stockNum);
        // System.out.println("PHONE!!!");
    }
    void setBrand(String br) {
        brand = br;
    }
}