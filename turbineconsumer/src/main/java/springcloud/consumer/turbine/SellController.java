package springcloud.consumer.turbine;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SellController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public String productDetail(@PathVariable int id){
        String product = productService.queryProductById(id);
        return product;
    }


    @GetMapping("/products")
    public List<String> productsDetail(){
       return productService.queryAllProducts();
    }

}
