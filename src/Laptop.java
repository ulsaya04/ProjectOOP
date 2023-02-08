
public class Laptop extends Product {
    private double tax;
    public Laptop(String name, double price, String color, int stockNum) {
        super(name, price, color, stockNum);
        // System.out.println("LAPTOP!!!");
    }
    @Override
    public void showFeatures() {
        System.out.println("Name of product: "+getName()+"\n"+
                "Price: " + getPrice()+"\n"+
                "Color: "+getColor());
    }
    public void setTax(double t) { tax = t; }
    @Override
    public double getPrice() { return price * (1.0+tax); }
}

