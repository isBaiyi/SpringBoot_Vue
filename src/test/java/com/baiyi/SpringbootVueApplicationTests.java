package com.baiyi;

import com.baiyi.dao.UserDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootVueApplicationTests {

    @Autowired
    private UserDAO userDAO;
    @Test
    void contextLoads() {
        userDAO.findAll().forEach(user -> System.out.println("user = " + user));
    }

}
