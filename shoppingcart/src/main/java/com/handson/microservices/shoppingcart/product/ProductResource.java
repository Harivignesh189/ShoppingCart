package com.handson.microservices.shoppingcart.product;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ProductResource {
   @Autowired
   private ProductDaoService service;

   @GetMapping({"/products"})
   public List<Product> retrieveAllProducts() {
      return this.service.findAll();
   }

   @GetMapping({"/products/{productNo}"})
   public Product retrieveProduct(@PathVariable int productNo) {
      Product products = this.service.findOne(productNo);
      if (products == null) {
         throw new UserNotFoundException("Product No -" + productNo);
      } else {
         return products;
      }
   }

   @DeleteMapping({"/products/{productNo}"})
   public Product removeProduct(@PathVariable int productNo) {
      Product products = this.service.removeByProductNo(productNo);
      if (products == null) {
         throw new UserNotFoundException("Product No -" + productNo);
      } else {
         return products;
      }
   }

   @PostMapping({"/products"})
   public ResponseEntity<Object> addProduct(@RequestBody Product product) {
      Product addedProduct = this.service.save(product);
      URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{productNo}").buildAndExpand(new Object[]{addedProduct.getproductNo()}).toUri();
      return ResponseEntity.created(location).build();
   }
}