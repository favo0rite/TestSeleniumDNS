package appline.utilsdata;

import java.util.ArrayList;
import java.util.List;

public class AbstractBasket {
    private static List<Product> productList = new ArrayList<>();

    public static void addToProductList(Product product) {
        productList.add(product);
    }

    public static Product getProductToProductList(int i) {
        return productList.get(i);

    }


    public static int getSumAbstractBasket() {
        int sum = 0;
        for(int i = 0; i < productList.size(); i++){
            sum += productList.get(i).getPrice();
        }
        return sum;
    }
}
