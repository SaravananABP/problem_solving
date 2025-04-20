package SuperStore.Inventory;

import SuperStore.InputOutput;

import java.io.*;
import java.lang.runtime.ObjectMethods;

public class LoadInventory {
    public static void loadInventory(String filePath) {
//        filePath="../files/"+filePath;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader((new File(".").getAbsolutePath())+"\\Zoho\\Round3\\SuperStore\\files\\"+filePath));
            String line;
            StringBuilder jsonVal = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                jsonVal.append(line.trim());
            }
            String file = jsonVal.toString();
            file = file.substring(1, file.length() - 1);
            String[] product = file.split("\\},\\s*\\{");
            System.out.println(product.length);
            for (int i = 0; i < product.length; i++) {
                String productContent = product[i];
                ProductDetails productDetails = new ProductDetails();
                productContent = productContent.replaceAll("\\{", "");
                productContent = productContent.replace("}", "");
                productContent = productContent.replace("\"", "");
                String[] fields = productContent.split(",");
                for (String s : fields) {
                    String[] keyVal = s.split(":", 2);
                    String key = keyVal[0].trim();
                    String val = keyVal[1].trim();
                    switch (key) {
                        case "name":
                            productDetails.setName(val);
                            break;
                        case "details":
                            productDetails.setDetails(val);
                            break;
                        case "brand":
                            productDetails.setBrand(val);
                            break;
                        case "price":
                            productDetails.setPrice(Integer.parseInt(val));
                            break;
                        case "available":
                            productDetails.setAvailable(Integer.parseInt(val));
                            break;
                        case "type":
                            productDetails.setType(val);
                            break;
                    }

                }
                ProductDetails.nexInt++;
                productDetails.setProduct_id(productDetails.getProduct_id()+ProductDetails.nexInt);
                ProductService.availProducts.put(ProductService.availProducts.size()+1,productDetails);

            }
            InputOutput.status("loaded successfully !!!");

        } catch (IOError | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
