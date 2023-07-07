package org.alvin.service;

import com.mongodb.client.result.DeleteResult;
import lombok.extern.slf4j.Slf4j;
import org.alvin.pojo.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class RemoveService {

    private static final String COLLECTION_NAME = "users";

    @Resource
    private MongoTemplate mongoTemplate;

    public Object remove(){
        int age = 20;
        String sex = "男";

        Criteria criteria = Criteria.where("age").is(age).and("sex").is(sex);
        Query query = new Query(criteria);
        DeleteResult result = mongoTemplate.remove(query, COLLECTION_NAME);

        String resultInfo = "成功删除" + result.getDeletedCount() + "条文档信息";
        log.info("删除结果：{}", resultInfo);
        return resultInfo;
    }

    public Object findAndRemove(){
        String name = "张三";
        Criteria criteria = Criteria.where("name").is(name);
        Query query = new Query(criteria);

        User result = mongoTemplate.findAndRemove(query, User.class, COLLECTION_NAME);
        String resultInfo = "成功删除文档信息，文档内容为：" + result;

        log.info(resultInfo);
        return resultInfo;
    }

    public Object findAllAndRemove(){
        int age = 22;

        Criteria criteria = Criteria.where("age").is(age);
        Query query = new Query(criteria);
        List<User> resultList  = mongoTemplate.findAllAndRemove(query, User.class, COLLECTION_NAME);

        String resultInfo = "成功删除文档信息，文档内容为：" + resultList;
        log.info(resultInfo);
        return resultList;
    }
}
