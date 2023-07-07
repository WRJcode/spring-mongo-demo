package org.alvin.service;

import lombok.extern.slf4j.Slf4j;
import org.alvin.pojo.Status;
import org.alvin.pojo.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class InsertService {

    private static final String COLLECTION_NAME = "users";

    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 插入【一条】文档数据，如果文档信息已经【存在就抛出异常】
     *
     * @return 插入的文档信息
     */
    public Object insert(){
        User user = new User();
        user.setName("李云龙")
                .setAge(20)
                .setSex("男")
                .setRemake("无")
                .setSalary(12000)
                .setBirthday(new Date(2000-11-19))
                .setStatus(new Status().setWeight(150).setHeight(180));
        User newUser = mongoTemplate.insert(user, COLLECTION_NAME);
        log.info("存储的用户信息为：{}", newUser);
        return newUser;
    }

    public Object insertMany(){
        User user1 = new User();
        user1.setName("王五")
                .setAge(18)
                .setSex("男")
                .setRemake("无")
                .setSalary(15000)
                .setBirthday(new Date(2005-6-23))
                .setStatus(new Status().setWeight(176).setHeight(125));

        User user2 = new User();
        user2.setName("龙四")
                .setAge(19)
                .setSex("女")
                .setRemake("无")
                .setSalary(15000)
                .setBirthday(new Date(2004-6-23))
                .setStatus(new Status().setWeight(168).setHeight(98));

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        Collection<User> newUsers = mongoTemplate.insert(users, COLLECTION_NAME);
        for (User user : newUsers) {
            log.info("存储的用户信息为：{}", user);
        }
        return newUsers;
    }

}
