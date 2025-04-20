package SuperStore.Order;

public class OrderDetails {
    private static Long orderId=100L;
    private String productName;
    private String productType;
    private Long product_id;
    private int price;
    private int count;

    public OrderDetails(){

    }
    public OrderDetails(String productName, String productType, int price,int count,Long product_id) {
        this.productName = productName;
        this.productType = productType;
        this.price = price;
        this.count=count;
        this.product_id=product_id;
        orderId+=1L;
    }

    public static Long getOrderId() {
        return orderId;
    }

//    public static void setOrderId(Long orderId) {
//        OrderDetails.orderId = orderId;
//    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderId='"+orderId+'\''+
                "productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }
}
