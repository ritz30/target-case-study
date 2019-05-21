package org.casestudy.target.model;


public class ProductDetails {


    private String productId;

    private String productName;

    private CurrentPrice currentPrice;


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public CurrentPrice getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(CurrentPrice currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", currentPrice=" + currentPrice +
                '}';
    }



}
