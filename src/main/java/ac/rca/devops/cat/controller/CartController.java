package ac.rca.devops.cat.controller;

import ac.rca.devops.cat.model.Cart;
import ac.rca.devops.cat.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping("/get-all")
    public List<Cart> getAll(){
        return cartService.getAllCarts();
    }
    @GetMapping("/get-by-id")
    public Cart getCartById(@RequestParam Long id) throws Throwable {
        return cartService.getCartById(id);
    }

    @PostMapping("/add-Cart")
    public Cart addCart(@RequestBody Cart cart){
        return cartService.createCart(cart);
    }

    @PutMapping("/update-cart")
    public Cart UpdateCart(@RequestBody Cart cart) throws Throwable {
        return cartService.updateCart(cart.getId(),cart);
    }

    @DeleteMapping("/delete-cart")
    public Cart DeleteCart(@RequestParam Long id) throws Throwable {
        return cartService.deleteCart(id);
    }
}
