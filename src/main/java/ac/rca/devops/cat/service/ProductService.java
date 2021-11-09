package ac.rca.devops.cat.service;

import ac.rca.devops.cat.model.Product;
import ac.rca.devops.cat.dao.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    IProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product createProduct(Product product){
        return (Product) productRepository.save(product);
    }

    public Product deleteProduct(Long id) throws Throwable {
        productRepository.findById(id)
                .orElseThrow( ()->new RuntimeException("Product not found with id"+ id));
        productRepository.deleteById(id);
        return null;
    }

    public Product updateProduct(Long id, Product Product) throws Throwable {
        productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found with id"+ id));

        Product.setId(id);

        return (ac.rca.devops.cat.model.Product) productRepository.save(Product);

    }

    public Product getProductById(Long id) throws Throwable {
        return (Product) productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product with id "+id+ " not found!"));
    }
}

