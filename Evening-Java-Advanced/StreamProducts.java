/* Create a Product class having properties like name,category, price .Create a ProductFactory class which gives you the List of products when you pass the number of Products.
   Now use stream Api -
	1) To get the list of products whose price range is between x and y.(You can assume x and y yourself)
	2) To get the total categories in the product list.
	3) To get the maximum and minimum priced product in each category
 * */

import java.util.*;
import java.util.stream.Collectors;

public class StreamProducts {
  	
	public static Integer getMaxPrice(List<Product> products) {
        OptionalInt maxPrice = products.stream().mapToInt(Product::getPrice).max();
        if (maxPrice.isPresent()) {
            return maxPrice.getAsInt();
        } else {
            return null;
        }
    }
	
  	public static Integer getMinPrice(List<Product> products) {
        OptionalInt minPrice = products.stream().mapToInt(Product::getPrice).min();
        if (minPrice.isPresent()) {
            return minPrice.getAsInt();
        } else {
            return null;
        }
    }
  	public static List<Product> getGroup(List<Product> products){
    	Map<Integer, List<Product>> collectorMapOfLists = products.stream().collect(Collectors.groupingBy(Product::getCategory));
      return collectorMapOfLists.get(2);
    }
  
  	public static List<Product> getRangePrice(List<Product> products) {
      Map<Boolean, List<Product>> mapPartioned = products.stream().collect(Collectors.partitioningBy(Product -> (Product.getPrice() > 15  && Product.getPrice() <=50 )  ));
		return mapPartioned.get(true);
    }
  
	public static Long GetTotalCategory(List<Product> products){
  		 Long noCats = products.stream().mapToInt(Product::getCategory).distinct().count(); 
      	return noCats;
    }
  
    public static void main(String[] args) {
        ProductFactory productFactory=new ProductFactory();
        List<Product> products = productFactory.getListOfProducts(20);
     /* 	  System.out.println("Product Name | Category | Price");
        for(Product prod : products){
        	  System.out.println(prod.getName() +" "+prod.getCategory()+" "+prod.getPrice());
       }
     */  
       System.out.println("Max Price "+ getMaxPrice(products));
       System.out.println("Total No. of Categories "+GetTotalCategory(products));
     	
      List<Product> filteredProd = getRangePrice(products);
       	  System.out.println("Product Name | Category | Price");
        for(Product prod : filteredProd){
        	  System.out.println(prod.getName() +" "+prod.getCategory()+" "+prod.getPrice());
       }
      System.out.println("--------------------------");
       List<Product> groupProd = getRangePrice(products);
       	  System.out.println("Product Name | Category | Price");
        for(Product prod : groupProd){
        	  System.out.println(prod.getName() +" "+prod.getCategory()+" "+prod.getPrice());
       }
    }
}
