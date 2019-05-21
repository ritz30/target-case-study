package org.casestudy.target.controller;

import org.casestudy.target.model.ProductDetails;
import org.casestudy.target.util.ResponseDataHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController
public class ProductController {

    @Autowired
    ResponseDataHelper responseDataHelper;

    private static final String FILE_PATH=".//src//main//resources//ResponseData";

    @RequestMapping("/")
    public String sayHello(){
        return new String("Hi There");
    }


    @RequestMapping
    (value="/products/{id}" ,  method = RequestMethod.GET
    ,produces = "application/json")
    public ProductDetails getProductDetailsById(
            @PathVariable(value="id") String id){

     ProductDetails productDetails=new ProductDetails();

     try{

         HashMap<String, ProductDetails> productDetailsHashMap=
                 responseDataHelper.convertResponseDataIntoPOJO();
         if(productDetailsHashMap.containsKey(id))
             productDetails = productDetailsHashMap.get(id);
         else
             System.out.println("The id is not present");

     }catch(Exception e){
         e.printStackTrace();
     }

     return productDetails;
    }
}
