package ac.rca.devops.cat.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Product {
    @Id
    private long id;
    private String name;
    private long price;
    private String imageUrl;

    @OneToMany(mappedBy="product")
    private Set<Cart> carts;

    public Product() {
    }

    public Product(String name, long price, String imageUrl) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Product product = (Product) object;
        return getId() == product.getId() && getPrice() == product.getPrice() && java.util.Objects.equals(getName(), product.getName()) && java.util.Objects.equals(getImageUrl(), product.getImageUrl());
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), getId(), getName());
    }
}
