package com.handson.microservices.shoppingcart.product;

public class Product {
   private Integer productNo;
   private String productName;
   private double productPrice;

   protected Product() {
   }

   public Integer getproductNo() {
      return this.productNo;
   }

   public void setproductNo(Integer productNo) {
      this.productNo = productNo;
   }

   public String getProductName() {
      return this.productName;
   }

   public void setProductName(String productName) {
      this.productName = productName;
   }

   public double getProductPrice() {
      return this.productPrice;
   }

   public void setProductPrice(float productPrice) {
      this.productPrice = (double)productPrice;
   }

   public String toString() {
      return "Product [productNo=" + this.productNo + ", productName=" + this.productName + ", productPrice=" + this.productPrice + "]";
   }

   public Product(Integer productNo, String productName, double productPrice) {
      this.productNo = productNo;
      this.productName = productName;
      this.productPrice = productPrice;
   }
}