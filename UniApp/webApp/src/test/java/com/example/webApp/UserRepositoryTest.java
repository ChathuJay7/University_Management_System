
package com.example.webApp;


import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    //@Autowired private UserRepository repo;

    /*
    @Test
    public void testAddNew() {
        User user = new User();
        user.setEmail("steve@gmail.com");
        user.setPassword("steve123");
        user.setFirstName("Steve");
        user.setLastName("Smith");

        User savedUser = repo.save(user);

        //Assertions.assertThat(savedUser).isNotNull();
        //Assertions.assertThat(savedUser.getId()).isGreaterThan(0);

    }



    @Test
    public void testListAll() {
        Iterable<User> users = repo.findAll();
        //Assertions.assertThat(users).hasSizeGreaterThan(0);

        for(User user: users) {
            System.out.println(user);
        }
    }

     */
}
