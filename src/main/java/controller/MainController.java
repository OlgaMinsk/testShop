package controller;

import Model.Product;
import Model.ProductsStatus;
import Service.ProductService;
import Service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class MainController {
    private ProductService productService;

    @Autowired
    public MainController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public Map<String, String> getAllProducts(@PathVariable int id) {
        Map<String, String> productMap = new HashMap<String, String>();
        try {
          Product product= productService.getProductById(id);
            productMap.put("name", product.getName());
            Integer price = product.getPrice();
            productMap.put("price", price.toString());
            int x =(int)(3*Math.random());
            ProductsStatus productsStatus= ProductsStatus.values()[x];
            product.setProductsStatus(productsStatus);
            productMap.put("productsStatus", product.getProductsStatus().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  productMap;
    }

    @PostMapping("/product")
    public void createProduct(@RequestBody Map<String, String> product){
        if(product.isEmpty()||product.get("name").isEmpty()||product.get("price").isEmpty()){
            String  name = product.get("name");
            Integer price = Integer.parseInt(product.get("price"));
            try {
                productService.createProduct(name, price);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
