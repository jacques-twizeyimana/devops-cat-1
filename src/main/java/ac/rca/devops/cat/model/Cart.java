package ac.rca.devops.cat.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Cart {
    @Id
    private long id;

    private double totalPrice;
    private int totalItems;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "product_id")
    private Product product;

    public Cart() {
    }

    public Cart(double totalPrice, int totalItems, User user, Product product) {
        this.totalPrice = totalPrice;
        this.totalItems = totalItems;
        this.user = user;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return getId() == cart.getId() && getUser().equals(cart.getUser()) && getProduct().equals(cart.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getProduct());
    }
}
