package ac.rca.devops.cat.controller;

import ac.rca.devops.cat.model.Product;
import ac.rca.devops.cat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/get-all")
    public List<Product> getAll(){
        return productService.getAllProducts();
    }
    @GetMapping("/get-by-id")
    public Product getProductById(@RequestParam Long id) throws Throwable {
        return productService.getProductById(id);
    }

    @PostMapping("/add-Product")
    public Product addProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping("/update-product")
    public Product UpdateProduct(@RequestBody Product product) throws Throwable {
        return productService.updateProduct(product.getId(),product);
    }

    @DeleteMapping("/delete-product")
    public Product DeleteProduct(@RequestParam Long id) throws Throwable {
        return productService.deleteProduct(id);
    }
}