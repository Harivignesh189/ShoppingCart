package com.handson.microservices.shoppingcart.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ProductDaoService {
   private static List<Product> products = new ArrayList<Product>();
   private static int productCount = 3;

   static {
      products.add(new Product(1, "Mobile-Samsung", 7800.0D));
      products.add(new Product(2, "Mobile-Nokia", 5800.0D));
      products.add(new Product(3, "Headset-Sony", 1800.0D));
   }

   public List<Product> findAll() {
      return products;
   }

   public Product save(Product product) {
      if (product.getproductNo() == null) {
         product.setproductNo(++productCount);
      }

      products.add(product);
      return product;
   }

   public Product findOne(int productNo) {
      Iterator<Product> iterator = products.iterator();

      while(iterator.hasNext()) {
         Product product = (Product)iterator.next();
         if (product.getproductNo() == productNo) {
            return product;
         }
      }

      return null;
   }

   public Product removeByProductNo(int productNo) {
      Iterator<Product> iterator = products.iterator();

      while(iterator.hasNext()) {
         Product product = (Product)iterator.next();
         if (product.getproductNo() == productNo) {
            iterator.remove();
            return product;
         }
      }

      return null;
   }
}