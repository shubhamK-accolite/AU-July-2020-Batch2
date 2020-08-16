
import java.util.*;
public class ProductFactory {
	
	public List<Product> getListOfProducts(int numOfProducts) {
        List<Product> prod = new ArrayList<>();
        for (int i = 1; i <= numOfProducts; i++) {
            prod.add(createProduct(i));
        }
        return prod;
    }

    private Product createProduct(int i) {
        Product prod = new Product();
        prod.setName("AmazingProd" + i);
        prod.setPrice((int) (Math.random() * (i*10)+1));
        prod.setCategory((int) (Math.random() * 10));
      
        return prod;

    }

}
