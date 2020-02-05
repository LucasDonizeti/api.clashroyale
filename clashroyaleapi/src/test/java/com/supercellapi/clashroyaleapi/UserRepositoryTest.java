package com.supercellapi.clashroyaleapi;

import com.supercellapi.clashroyaleapi.models.User;
import com.supercellapi.clashroyaleapi.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * author LucasDonizeti
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void TesteSaveUser(){
        User user = new User("Usuario1","U1","123",false,(long)0);
        user = userRepository.save(user);
        Assertions.assertThat(user.getName()).isEqualTo("Usuario1");
        Assertions.assertThat(user.getUsername()).isEqualTo("U1");
        Assertions.assertThat(user.getPassword()).isEqualTo("123");
        Assertions.assertThat(user.getAdmin()).isEqualTo(false);
        Assertions.assertThat(user.getId()).isNotNull();
        Assertions.assertThat(user.getId()!=0);
    }
    @Test
    public void TesteDeleteUserById(){
        User user = new User("Usuario1","U1","123",false,(long)0);
        user = userRepository.save(user);
        userRepository.deleteById(user.getId());
        Assertions.assertThat(userRepository.findByUsername("Usuario1")).isNull();
    }
    @Test
    public void TestUpdateUser(){
        User user = new User("Usuario1","U1","123",false,(long)0);
        user = userRepository.save(user);
        user.setName("aaa");
        user.setUsername("eee");
        user.setPassword("111");
        User user1 = userRepository.save(user);
        Assertions.assertThat(user).isEqualTo(user1);
    }


}
