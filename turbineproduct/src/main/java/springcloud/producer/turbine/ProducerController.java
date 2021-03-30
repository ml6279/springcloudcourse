package springcloud.producer.turbine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProducerController {
    @Autowired
    private ProductService productService;

    @GetMapping("products")
    public List<String> productList(){
        return productService.queryAllProducts();
    }

    @GetMapping("product/{id}")
    public String productDetail(@PathVariable int id){
        return productService.queryProductById(id);
    }

    @PostMapping("product")
    public void save(@RequestBody String product){
        productService.saveProduct(product);
    }


}
