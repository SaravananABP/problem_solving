package SuperStore;

import SuperStore.Inventory.LoadInventory;
import SuperStore.Inventory.ProductDetails;
import SuperStore.Inventory.ProductService;
import SuperStore.Order.OrderDetails;
import SuperStore.Order.OrderService;
import SuperStore.Profile.ProfileDetails;
import SuperStore.Profile.ProfileService;

import java.io.File;
import java.util.Objects;
import java.util.TreeMap;

/*
1. Super Store
Description:
Build an online shopping interface where buyers and sellers can engage in efficient transactions across a wide range of products.

Modules:
Profile Service
Inventory Service
Order Service
Payment Service
Requirements:
Allow buyers and sellers to register and log in.
Allow sellers to manage their inventory of products.
Operations: addItem(), updateItem()
Allow buyers to add items to the cart, place orders, and make payments.
Operations: listInventory(), buyItem(), addToCart(), makePayment()
Validate orders against inventory.
Password validation and encryption.
 */
public class Main {
    public static Long userId;

    public static void main(String[] args) {
/*        hard coded value for admin
       username= 11
       password=11
 */
        ProfileDetails profileDetails = new ProfileDetails("11", "11", "admin");
        ProfileService.userInfo.put(0, profileDetails);
        LoadInventory.loadInventory("ProductInventory.txt");
        InputOutput.title("Login portal");
        String userName = InputOutput.strInput("User name");
        String password = InputOutput.strInput("Password");
        boolean valid = ProfileService.validateUser(userName, password);
        String role = "";
        if (valid) {
            userId = ProfileService.getUserData(userName, password).getUserId();
            role = ProfileService.getUserData(userName, password).getRole();

            boolean flag = true;
            while (flag) {
                if (role.equals("buyer")) {
                    OrderService.getALlOrderService();
                }
                if (role.equals("seller")) {
                    ProductService.getAllProductService();
                }
                if (role.equals("admin")) {
                    InputOutput.title("Welcome to admin page");
                    InputOutput.option("Create New profile..seller Option..buyer option..exit");
                    int choice = InputOutput.intInput("choice");
                    switch (choice) {
                        case 1:
                            ProfileService.getAllProfileDetails();
                            break;
                        case 2:
                            ProductService.getAllProductService();
                            break;
                        case 3:
                            OrderService.getALlOrderService();
                            break;
                        case 4:
                            flag = false;
                            break;
                        default:
                            InputOutput.status("Invalid choice chosen");

                    }
                    InputOutput.endLine();
                }
            }
        }else{
            InputOutput.status("Invalid User!!!");
        }
    }
}
