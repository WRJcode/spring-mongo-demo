package org.alvin.repository;

import org.alvin.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave() {
        User user = new User();
        user.setName("张三");
        user.setAge(20);
        userRepository.save(user);
    }

    @Test
    public void testFindAll() {
        List<User> userList = userRepository.findAll();
        System.out.println(userList);
    }

    @Test
    public void testFindById() {
        Optional<User> optional = userRepository.findById("64a53c9484fc721960a25996");
        System.out.println(optional.get());
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId("64a53c9484fc721960a25996");
        user.setName("李四");
        user.setAge(30);
        userRepository.save(user);
    }

    @Test
    public void testDelete() {
        userRepository.deleteById("64a53c9484fc721960a25996");
    }

}