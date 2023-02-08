public class Printer extends Product {
    private boolean cartridge;
    public void setCartridge(boolean cartridge) { this.cartridge = cartridge; }
    public Printer(String name, double price, String color, int stockNum) {
        super(name, price, color, stockNum);
        // System.out.println("PRINTER!!!");
    }
}
