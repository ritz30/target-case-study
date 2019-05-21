package org.casestudy.target.util;

import org.casestudy.target.model.CurrentPrice;
import org.casestudy.target.model.ProductDetails;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

@Component
public class ResponseDataHelper {

    private static final String FILE_PATH = ".//src//main//resources//ResponseData";

    public HashMap<String,ProductDetails> convertResponseDataIntoPOJO(){
        HashMap<String, ProductDetails> productDetailsHashMap=new HashMap<>();

        try {
            final byte[] encodedResponse = Files.readAllBytes(Paths.get(FILE_PATH));
            JSONObject js= new JSONObject(new String(encodedResponse, ProductConstant.CHARSET_UTF8));
            for(int i=0;i<5;i++){
                ProductDetails productDetails=new ProductDetails();
                CurrentPrice currentPrice=new CurrentPrice();
                productDetails.setProductName(js.getJSONArray(ProductConstant.PRODUCTS)
                        .getJSONObject(i).getString(ProductConstant.NAME));
                productDetails.setProductId(js.getJSONArray(ProductConstant.PRODUCTS).
                        getJSONObject(i).getString(ProductConstant.ID));
                currentPrice.setCurrencyCode
                        (js.getJSONArray(ProductConstant.PRODUCTS).getJSONObject(i).getJSONObject
                                (ProductConstant.CURRENT_PRICE).getString(ProductConstant.CURRENCY_CODE));
                currentPrice.setProductValue
                        (js.getJSONArray(ProductConstant.PRODUCTS).getJSONObject(i).getJSONObject
                                (ProductConstant.CURRENT_PRICE).getString(ProductConstant.VALUE));
                productDetails.setCurrentPrice(currentPrice);

                productDetailsHashMap.put(js.getJSONArray(ProductConstant.PRODUCTS)
                        .getJSONObject(i).getString(ProductConstant.ID),productDetails);

            }
        }catch (Exception e){
            //implement exception handling
            e.printStackTrace();
        }

        return productDetailsHashMap;
    }
}
