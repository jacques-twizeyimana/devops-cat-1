package ac.rca.devops.cat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class User {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private Date dob;
    private String gender;

    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany(mappedBy="user")
    private Set<Cart> cartItems;

    public User() {
    }

    public User(String firstName, String lastName, Date dob, String gender, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId().equals(user.getId()) && Objects.equals(getGender(), user.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getGender());
    }
}
