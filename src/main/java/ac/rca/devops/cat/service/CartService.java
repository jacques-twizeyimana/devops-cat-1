package ac.rca.devops.cat.service;

import ac.rca.devops.cat.model.Cart;
import ac.rca.devops.cat.dao.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    ICartRepository cartRepository;

    public List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }
    public Cart createCart(Cart cart){
        return (Cart) cartRepository.save(cart);
    }

    public Cart deleteCart(Long id) throws Throwable {
        cartRepository.findById(id)
                .orElseThrow( ()->new RuntimeException("Cart not found with id"+ id));
        cartRepository.deleteById(id);
        return null;
    }

    public Cart updateCart(Long id, Cart Cart) throws Throwable {
        cartRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Cart not found with id"+ id));

        Cart.setId(id);

        return (ac.rca.devops.cat.model.Cart) cartRepository.save(Cart);

    }

    public Cart getCartById(Long id) throws Throwable {
        return (Cart) cartRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Cart with id "+id+ " not found!"));
    }
}

