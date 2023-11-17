package com.example.api.repository;

import com.example.api.TestStructure;
import com.example.api.model.UserH2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTest
        implements TestStructure {

    @Autowired
    private UserH2Repository userRepository;

    private UserH2 user;
    private int size;

    @BeforeEach
    public void setUp() {
        user = UserH2.builder()
                .firstName("Test")
                .lastName("Elek")
                .age((byte) 18)
                .study(true)
                .build();
        size = userRepository.findAll().size();
    }

    @Override
    @Test
    public void create_Test() throws Exception {
        UserH2 saveUser = userRepository.save(user);
        assertThat(saveUser).isNotNull();
        assertThat(saveUser.getId()).isGreaterThan(0);
        assertThat(userRepository.findAll().size()).isGreaterThan(size);
        assertEquals(saveUser, user);
    }

    @Override
    @Test
    public void get_Test() throws Exception {
        for (int i = 1; i <= 3; i++) {
            user.setFirstName(user.getFirstName() + i);
            userRepository.save(user);
        }
        List<UserH2> userList = userRepository.findAll();
        assertThat(userList).isNotNull();
        assertThat(userList.size()).isGreaterThan(size);
    }

    @Override
    @Test
    public void put_Test() throws Exception {
        UserH2 saveUser = userRepository.save(user);
        saveUser.setFirstName("hot-dog");
        saveUser.setStudy(false);
        UserH2 updateFood = userRepository.save(saveUser);
        assertThat(updateFood).isNotNull();
        assertEquals(updateFood, user);
    }

    @Override
    @Test
    public void delete_Test() throws Exception {
        userRepository.save(user);
        userRepository.deleteById(user.getId());
        Optional<UserH2> foodOptional = userRepository.findById(user.getId());
        assertThat(foodOptional).isNotNull();
    }
}