package ac.rca.devops.cat.service;

import ac.rca.devops.cat.model.User;
import ac.rca.devops.cat.dao.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    IUsersRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User createUser(User user){
        return (User) userRepository.save(user);
    }

    public User deleteUser(Long id) throws Throwable {
        userRepository.findById(id)
                .orElseThrow( ()->new RuntimeException("User not found with id"+ id));
        userRepository.deleteById(id);
        return null;
    }

    public User updateUser(Long id, User User) throws Throwable {
        userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found with id"+ id));

        User.setId(id);

        return (ac.rca.devops.cat.model.User) userRepository.save(User);

    }

    public User getUserById(Long id) throws Throwable {
        return (User) userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User with id "+id+ " not found!"));
    }
}

