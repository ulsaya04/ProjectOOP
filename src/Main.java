import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;
public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
      mainMenu();

    }

    public static void mainMenu() throws  SQLException{
        System.out.println(" 1) Log in ");
        System.out.println(" 2) Registration");
        System.out.println(" 3) Exit ");
        int menu =in.nextInt();
        switch (menu){
            case 1 -> Login.login();
            case 2 -> Registration.reg();
            case  3 -> Login.exit();
        }

    }
    public static void forTheSeller() throws SQLException {
        System.out.println("1) Add a gadget ");
        System.out.println("2) Delete a gadget");
        System.out.println("3) List of gadget");
        System.out.println("4) Search by category");
        System.out.println("5) List of categories");
        System.out.println("6) Log out of your account");
        System.out.println("7) My account");
        int menu = in.nextInt();
        switch (menu){
            case 1 -> Seller.addGadget();
            case 2 -> Seller.deleteGadget();
            case 3 -> Gadget.infoAllGadget();
            case 4 -> Seller.searchByCategory();
            case 5 -> Gadget.infoCategories2();
            case 6 -> Login.logOut();
            case 7 -> Login.myAccount();
        }
    }
    public static void forTheBuyer() throws SQLException {
        System.out.println("1) Buy a gadget");
        System.out.println("2) Return gadget");
        System.out.println("3) List of gadgets");
        System.out.println("4) Search by category");
        System.out.println("5) List of categories");
        System.out.println("6) Log out of your account");
        System.out.println("7) My account");
        int menu = in.nextInt();
        switch (menu){
            case 1 -> Seller.addGadget();
            case 2 -> Seller.deleteGadget();
            case 3 -> Gadget.infoAllGadget();
            case 4 -> Seller.searchByCategory();
            case 5 -> Gadget.infoCategories2();
            case 6 -> Login.logOut();
            case 7 -> Login.myAccount();
        }


}