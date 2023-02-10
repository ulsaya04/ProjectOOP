import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Scanner in= new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        mainMenu();

    }
    //главное меню
    public static void mainMenu() throws SQLException {
        System.out.println("""
                    1) Log in
                    2) Registration
                    3) Exit
                    """);
        int menu = in.nextInt();
        switch (menu){
            case 1 -> Login.Login();
            case 2 -> Registration.reg();
            case 3 -> Login.exit();
        }
    }
    public static void forTheSeller() throws SQLException {
        System.out.println("""
                    1) Add a gadget
                    2) Delete a gadget
                    3) List of gadgets
                    4) Search by category
                    5) List of categories
                    6) Log out of your account
                    7) My account
                    """);
        int menu = in.nextInt();
        switch (menu){
            case 1 -> Seller.addGadget();
            case 2 -> Seller.deleteGadget();
            case 3 -> Gadget.infoAllGadget();
            case 4 -> Seller.findByCategory();
            case 5 -> Gadget.infoCategories2();
            case 6 -> Login.logOut();
            case 7 -> Login.myAccount();
        }
    }
    //меню для клиента
    public static void forTheCustomer() throws SQLException {
        System.out.println("""
                 1) Buy a gadget
                 2) Return a gadget
                 3) List of gadgets
                 4) Search by category
                 5) List of categories
                 6) Log out of your account
                 7) My account
                 """);
        int menu = in.nextInt();
        switch (menu){
            case 1 -> Customer.buy();
            case 2 -> Customer.cancel();
            case 3 -> Gadget.infoAllGadget();
            case 4 -> Gadget.SearchByCategory();
            case 5 -> Gadget.infoCategories2();
            case 6 -> Login.logOut();
            case 7 -> Login.myAccount();
        }
    }
}