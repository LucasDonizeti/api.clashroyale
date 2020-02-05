package com.supercellapi.clashroyaleapi;

import com.supercellapi.clashroyaleapi.models.Conta;
import com.supercellapi.clashroyaleapi.models.User;
import com.supercellapi.clashroyaleapi.repository.ContaRepository;
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
public class ContaRepositoryTest {
    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private UserRepository userRepository;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void ContaSaveTest() {
        User user = new User("Usuario1", "U1", "123", false, (long) 0);
        user = userRepository.save(user);
        Conta conta = new Conta("Y8UY2R", user, (long) 0);
        conta = contaRepository.save(conta);
        Assertions.assertThat(conta.getTag()).isEqualTo("Y8UY2R");
        Assertions.assertThat(conta.getId()).isNotNull();
    }

    @Test
    public void ContaDeleteTest() {
        User user = new User("Usuario1", "U1", "123", false, (long) 0);
        user = userRepository.save(user);
        Conta conta = new Conta("Y8UY2R", user, (long) 0);
        conta = contaRepository.save(conta);
        contaRepository.delete(conta);
        Assertions.assertThat(contaRepository.findById(conta.getId())).isEmpty();
    }

    @Test
    public void ContaUpdateTest() {
        User user = new User("Usuario1", "U1", "123", false, (long) 0);
        user = userRepository.save(user);
        Conta conta = new Conta("Y8UY2R", user, (long) 0);
        conta = contaRepository.save(conta);
        conta.setTag("AAA");
        Conta conta1 = contaRepository.save(conta);
        Assertions.assertThat(conta1).isEqualTo(conta);
    }


}
