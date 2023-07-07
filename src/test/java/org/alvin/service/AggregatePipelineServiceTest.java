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
class AggregatePipelineServiceTest {

    @Autowired
    private AggregatePipelineService aggregatePipelineService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void aggregateGroupMatch() {
        Object object =  aggregatePipelineService.aggregateGroupMatch();
        System.out.println(object);
    }

    @Test
    void aggregateGroupSort() {
    }

    @Test
    void aggregateGroupLimit() {
    }

    @Test
    void aggregateGroupSkip() {
    }

    @Test
    void aggregateGroupProject() {
    }

    @Test
    void aggregateProjectUnwind() {
    }
}