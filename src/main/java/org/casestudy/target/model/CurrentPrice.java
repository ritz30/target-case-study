package org.casestudy.target.model;


public class CurrentPrice {

    private String currencyCode;

    private String productValue;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getProductValue() {
        return productValue;
    }

    public void setProductValue(String productValue) {
        this.productValue = productValue;
    }

    @Override
    public String toString() {
        return "CurrentPrice{" +
                "currencyCode='" + currencyCode + '\'' +
                ", productValue='" + productValue + '\'' +
                '}';
    }
}
