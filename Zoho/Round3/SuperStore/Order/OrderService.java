package SuperStore.Order;

import SuperStore.InputOutput;
import SuperStore.Inventory.ProductDetails;
import SuperStore.Inventory.ProductService;
import SuperStore.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderService {
    static HashMap<Long, List<OrderDetails>> orderInventor=new HashMap<>();
//     HashMap<Integer, ProductDetails>allProduct=ProductService.availProducts;
    public  void getAvailableProduct(){
        for (int i = 1; i < ProductService.availProducts.size()+1; i++) {
            ProductDetails productDetails=ProductService.availProducts.get(i);
            if(productDetails.getAvailable()!=0){
                System.out.println(ProductService.availProducts.get(i).toString());
            }
        }
    }
    public static void addToCart(Long userId){
        Long product_id=InputOutput.longInput("product_id");
        int count=InputOutput.intInput("count");
        boolean flag=true;
        for (int i = 1; i <ProductService.availProducts.size()+1; i++) {
            ProductDetails productDetails=ProductService.availProducts.get(i);
            if(productDetails.getProduct_id().equals(product_id)){
                flag=false;
                if(productDetails.getAvailable()>=count){
                    OrderDetails orderDetails=new OrderDetails(productDetails.getName(), productDetails.getType(), productDetails.getPrice(), count,productDetails.getProduct_id());
                    if(orderInventor.get(userId)==null){
                        List<OrderDetails> orderDetails1=new ArrayList<>();
                        orderDetails1.add(orderDetails);
                        orderInventor.put(userId,orderDetails1);
                    }else{
                        List<OrderDetails> orderDetails1=orderInventor.get(userId);
                        orderDetails1.add(orderDetails);
                        orderInventor.put(userId,orderDetails1);
                    }
//                    productDetails.setAvailable(productDetails.getAvailable()-count);
                    InputOutput.status("Successfully added into cart");
                }else{
                    InputOutput.status("failed available count : "+productDetails.getAvailable());
                }
            }
        }
        if(flag){
            System.out.println("product incorrect...");
        }
    }
    public static void display(String val){
        System.out.print(val+" ".repeat(15-val.length()));
    }
    public void makePayment(Long userId){
        int totalAmount=0;
        if(orderInventor.get(userId).isEmpty()){
            System.out.println("No payment pending!!!");
        }else{
            InputOutput.title("Bill to pay");
            System.out.println("Product Name   "+"Price          "+"items          "+"total");

            for (OrderDetails i:orderInventor.get(userId)){
                display(i.getProductName());
                display(String.valueOf(i.getPrice()));
                display(String.valueOf(i.getCount()));
                System.out.print(i.getPrice()*i.getCount());
                totalAmount=i.getPrice()*i.getCount();
                System.out.println();
            }
            System.out.println();
            System.out.println("           Amount to paid  :"+totalAmount);
            int pay=InputOutput.intInput("payable amount");
            if(pay==totalAmount){
                for (OrderDetails i:orderInventor.get(userId)){
                    for(int j=1;j<ProductService.availProducts.size();j++){
                        ProductDetails productDetails=ProductService.availProducts.get(j);
                        if (i.getProduct_id().equals(productDetails.getProduct_id())){
                            productDetails.setAvailable(productDetails.getAvailable()-i.getCount());
                            ProductService.availProducts.put(j,productDetails);
                        }
                    }
                }
                InputOutput.status("Payment success!!!");
                orderInventor.put(userId,null);
            }else{
                InputOutput.strInput("Try again!!!");
            }

        }

//        return;totalAmount;
    }

    public ProductDetails getParticularProduct(Long product_id){
        for (int i = 1; i < ProductService.availProducts.size()+1; i++) {
            ProductDetails productDetails=ProductService.availProducts.get(i);
            if(!productDetails.getProduct_id().equals(product_id)){
                return productDetails;
            }
        }
        return null;
    }
    public static void getALlOrderService(){

        boolean flag=true;

        while (flag) {
            InputOutput.option("Available Products..Add to cart..Make payment..break");
            int choice=InputOutput.intInput("choice");
            OrderService orderService=new OrderService();
            switch (choice) {
                case 1:
                    orderService.getAvailableProduct();
                    break;
                case 2:
                    addToCart(Main.userId);
                    break;
                case 3:
                    orderService.makePayment(Main.userId);
                    break;
                case 4:
                    flag=false;
                    break;
                default:
                    InputOutput.status("Invalid choice chosen");
            }
            InputOutput.endLine();
        }
    }

}
