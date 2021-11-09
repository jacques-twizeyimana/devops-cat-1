package ac.rca.devops.cat;

import ac.rca.devops.cat.dao.IUserRepository;
import ac.rca.devops.cat.model.User;
import ac.rca.devops.cat.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class UserTest {
    @Autowired
    private UserService service;

    @MockBean
    private IUserRepository repository;

    @Test
    public void getUsersTest() {
        when(repository.findAll()).thenReturn(Stream
                .of(new User("Jacques","Twizeyimana",new Date("29/10/2000"),"M","sandberg@gmail.com","1234"),
                        new User("Jacques","Twizeyimana",new Date("29/10/2000"),"M","sandberg2@gmail.com","1234")).collect(Collectors.toList()));
        assertEquals(2, service.getAllUsers().size());
    }

    @Test
    public void saveUserTest() {
        User user = new User("Jacques","Twizeyimana",new Date("29/10/2000"),"M","sandberg@gmail.com","1234");
        when(repository.save(user)).thenReturn(user);
        assertEquals(user, service.createUser(user));
    }

    @Test
    public void deleteUserTest() throws Throwable {
        service.deleteUser(1L);
        verify(repository, times(1)).delete(1L);
    }
}
