package org.alvin.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class CreateIndexServiceTest {

    @Autowired
    private CreateIndexService createIndexService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createAscendingIndex() {
          Object object =  createIndexService.createAscendingIndex();
          System.out.println(object);
    }

    @Test
    void createDescendingIndex() {
    }

    @Test
    void createCompositeIndex() {
    }

    @Test
    void createTextIndex() {
    }

    @Test
    void createUniqueIndex() {
    }

    @Test
    void createPartialIndex() {
    }
}