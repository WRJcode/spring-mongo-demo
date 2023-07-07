package org.alvin.service;

import lombok.extern.slf4j.Slf4j;
import org.alvin.pojo.Status;
import org.alvin.pojo.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Slf4j
public class SaveService {

    private static final String COLLECTION_NAME = "users";

    @Resource
    private MongoTemplate mongoTemplate;

    public Object save(){
        User user = new User();
        user.setAge(22)
                .setSex("男")
                .setRemake("无")
                .setSalary(2800)
                .setName("杨过")
                .setBirthday(new Date())
                .setStatus(new Status().setHeight(169).setWeight(150));
        User newUser = mongoTemplate.save(user, COLLECTION_NAME);
        log.info("存储的用户信息为：{}", newUser);
        return newUser;
    }
}
