package SuperStore.Inventory;


import SuperStore.InputOutput;

import java.util.HashMap;

public class ProductService {
    public static HashMap<Integer, ProductDetails> availProducts = new HashMap<>();

    public static void loadProducts() {
        String name = InputOutput.strInput("name");
        String details = InputOutput.strInput("deatails");
        String brand = InputOutput.strInput("brand");
        int price = InputOutput.intInput("price");
        int available = InputOutput.intInput("availble");
        String type = InputOutput.strInput("type");
        ProductDetails proDetails = new ProductDetails(name, details, brand, type, price, available);
        availProducts.put(availProducts.size() + 1, proDetails);
        InputOutput.status("loaded successfully !!!");
        InputOutput.endLine();
    }

    public static void getAllProducts() {
        for (int i = 1; i < availProducts.size() + 1; i++) {
            System.out.println(availProducts.get(i).toString());
        }
    }

    public static void updateProduct() {
        Long productId = InputOutput.longInput("Product_Id");
        int valueChange = InputOutput.intInput("no.Of values to update");
        for (int i = 1; i < availProducts.size() + 1; i++) {
            ProductDetails productDetails = availProducts.get(i);
            if (productDetails.getProduct_id().equals(productId)) {
                InputOutput.endLine();
                while (valueChange > 0) {
                    System.out.println("Update the value by choice the choice");
                    InputOutput.option("Name..Details..Brand..Price..Available..Type");
                    int choice = InputOutput.intInput("choice");
                    switch (choice) {
                        case 1:
                            String name = InputOutput.strInput("name");
                            productDetails.setName(name);
                            break;
                        case 2:
                            String details = InputOutput.strInput("deatails");
                            productDetails.setDetails(details);
                            break;
                        case 3:
                            String brand = InputOutput.strInput("brand");
                            productDetails.setBrand(brand);
                            break;
                        case 4:
                            int price = InputOutput.intInput("price");
                            productDetails.setPrice(price);
                            break;
                        case 5:
                            int available = InputOutput.intInput("availble");
                            productDetails.setAvailable(available);
                            break;
                        case 6:
                            String type = InputOutput.strInput("type");
                            productDetails.setType(type);
                            break;
                    }
                    availProducts.put(i, productDetails);
                    InputOutput.status("Updated successfully !!!");
                    valueChange -= 1;
                }
            }
        }
    }

    public static void getAllProductService() {


        boolean flag = true;
        while (flag) {

            InputOutput.option("Add new Product..update product..Get all product..Exit");
            int choice = InputOutput.intInput("choice");
            switch (choice) {
                case 1:
                    loadProducts();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    getAllProducts();
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
}
