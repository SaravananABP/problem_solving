package SuperStore.Inventory;

import SuperStore.Profile.ProfileDetails;

public class ProductDetails {
    private String name;
    private String details;
    private String brand;
    private int price;
    private int available;
    private String type;
    private Long product_id= 1001L;
    public static Long nexInt=0L;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public ProductDetails(){

    }
    public ProductDetails(String name,String details,String brand,String type,int price,int available){
        this.name=name;
        this.details=details;
        this.brand=brand;
        this.price=price;
        this.available=available;
        this.type=type;
//        Long product_id1=product_id+1L;
//        setProduct_id(getProduct_id()+1L);
//        product_id++;
        nexInt++;
        this.product_id= nexInt+product_id;

    }

    @Override
    public String toString() {
        return "ProductDetails : {" +
                "product_id="+product_id+
                "name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", available=" + available +
                ", type='" + type + '\'' +
                '}';
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }
}
