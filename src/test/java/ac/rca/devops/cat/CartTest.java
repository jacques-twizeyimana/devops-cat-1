package ac.rca.devops.cat;
import ac.rca.devops.cat.dao.ICartRepository;
import ac.rca.devops.cat.dao.IProductRepository;
import ac.rca.devops.cat.dao.IUserRepository;
import ac.rca.devops.cat.model.Cart;
import ac.rca.devops.cat.model.Product;
import ac.rca.devops.cat.model.User;
import ac.rca.devops.cat.service.CartService;
import ac.rca.devops.cat.service.ProductService;
import ac.rca.devops.cat.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CartTest {

    @Mock
    private ICartRepository cartRepositoryMock;
    @Mock
    private IProductRepository itemRepositoryMock;
    @Mock
    private IUserRepository userRepositoryMock;


    @InjectMocks
    private CartService cartService;


    @Test
    public void createCart_withNoItems() {
        Cart cart = new Cart();
        when(cartRepositoryMock.save(ArgumentMatchers.any(Cart.class)))
                .thenReturn(cart);

        assertEquals(0,cartService.createCart(cart).getTotalItems());
    }

    @Test
    public void createCartSuccess() {
        Cart cart1 = new Cart();
        ProductService productService = new ProductService();
        UserService userService = new UserService();

        Product product = productService.createProduct(new Product("Mango",2300,""));
        User user = userService.createUser(new User("Jacques","Sandberg",new Date("29/10/2000"),"M","sandberg29@gmail.com","1#234"));

        Set<Cart> carts = new HashSet<>();

        carts.add(new Cart(8000, 4,user,product));

        when(itemRepositoryMock.findById(1)).thenReturn(Optional.of(new Product("Mango",2300,"")));
        when(itemRepositoryMock.findById(2)).thenReturn(Optional.of(new Product("Apple",300,"")));

        when(cartRepositoryMock.save(ArgumentMatchers.any(Cart.class)))
                .thenReturn(carts);
    }

    @Test
    public void removeItems_success() {
        Cart cart1 = new Cart();
        ProductService productService = new ProductService();
        UserService userService = new UserService();

        Product product = productService.createProduct(new Product("Mango",2300,""));
        User user = userService.createUser(new User("Jacques","Sandberg",new Date("29/10/2000"),"M","sandberg29@gmail.com","1#234"));

        Set<Cart> carts = new HashSet<>();
        carts.add(new Cart(8000, 4,user,product));


        when(cartRepositoryMock.findById(1))
                .thenReturn(Optional.of(carts));
    }


}