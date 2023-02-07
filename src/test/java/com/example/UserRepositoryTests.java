package com.example;

import com.example.model.User;
import com.example.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired private UserRepository repo ;

    @Test
    public void testAddNew(){
        User user = new User();
        user.setEmail("Scaloneta@gmail.com");
        user.setPassword("Java");
        user.setFirstName("Developers");
        user.setLastName("Team");

        User savedUser= repo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void TestListAll(){
        Iterable<User>  users =repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (User user :users){
            System.out.println(user);
        }
    }
    @Test
    public void testUpdate(){
        Integer userId=3;
        Optional<User> optionalUser=repo.findById(userId);
        User user = optionalUser.get();
        user.setPassword("yukkito");
        repo.save(user); //change in the db

        User updateUser= repo.findById(userId).get();
        Assertions.assertThat(updateUser.getPassword()).isEqualTo("yukkito");
    }

    @Test
    public void testGet(){
        Integer userId=6;
        Optional<User> optionalUser=repo.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }

    @Test
    public void testDelete(){
        Integer userId=2;
        repo.deleteById(userId);
        Optional<User> optionalUser=repo.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();

    }


}
