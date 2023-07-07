package org.alvin.service;

import lombok.extern.slf4j.Slf4j;
import org.alvin.pojo.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class QueryService {
    private static final String COLLECTION_NAME = "users";

    @Resource
    private MongoTemplate mongoTemplate;

    public Object findAll(){
        List<User> documentList = mongoTemplate.findAll(User.class, COLLECTION_NAME);
        for (User user : documentList) {
            log.info("查询到的用户信息为：{}", user);
        }
        return documentList;
    }

    public Object findById(String id){
        User user = mongoTemplate.findById(id, User.class, COLLECTION_NAME);
        log.info("查询到的用户信息为：{}", user);
        return user;
    }

    public Object findOne(){
        int age = 20;
        Criteria criteria = Criteria.where("age").is(age);
        Query query = new Query(criteria);
        User user = mongoTemplate.findOne(query, User.class, COLLECTION_NAME);
        log.info("查询到的用户信息为：{}", user);
        return user;
    }

    public Object findByCondition(){
        String sex = "男";
        Criteria criteria = Criteria.where("sex").is(sex);
        Query query = new Query(criteria);
        List<User> documentList = mongoTemplate.find(query, User.class, COLLECTION_NAME);
        for (User user : documentList) {
            log.info("查询到的用户信息为：{}", user);
        }
        return documentList;
    }

    public Object findByConditionAndSort(){
        String sex = "男";
        String sort = "age";

        Criteria criteria = Criteria.where("sex").is(sex);
        Query query = new Query(criteria).with(Sort.by(sort));
        List<User> documentList = mongoTemplate.find(query, User.class, COLLECTION_NAME);
        for (User user : documentList) {
            log.info("查询到的用户信息为：{}", user);
        }
        return documentList;
    }

    public Object findByConditionAndSortLimit(){
        String sex = "男";
        String sort = "age";
        int limit = 2;

        Criteria criteria = Criteria.where("sex").is(sex);
        Query query = new Query(criteria).with(Sort.by(sort)).limit(limit);

        List<User> documentList = mongoTemplate.find(query, User.class, COLLECTION_NAME);
        for (User user : documentList) {
            log.info("查询到的用户信息为：{}", user);
        }
        return documentList;
    }

    public Object findByConditionAndSortSkip(){
        String sex = "男";
        String sort = "age";
        int skip = 1;
        Criteria criteria = Criteria.where("sex").is(sex);
        Query query = new Query(criteria).with(Sort.by(sort)).skip(skip);
        List<User> documentList = mongoTemplate.find(query, User.class, COLLECTION_NAME);
        for (User user : documentList) {
            log.info("查询到的用户信息为：{}", user);
        }
        return documentList;
    }

    public Object findByExistsField(){
        String field = "sex";
        Criteria criteria = Criteria.where(field).exists(true);
        Query query = new Query(criteria);
        List<User> documentList = mongoTemplate.find(query, User.class, COLLECTION_NAME);
        for (User user : documentList) {
            log.info("查询到的用户信息为：{}", user);
        }
        return documentList;
    }

    public Object findByAndCondition(){
        String sex = "男";
        Integer age = 20;
        Criteria criteriaSex = Criteria.where("sex").is(sex);
        Criteria criteriaAge = Criteria.where("age").is(age);
        Criteria criteria = new Criteria().andOperator(criteriaSex, criteriaAge);
        Query query = new Query(criteria);

        List<User> documentList = mongoTemplate.find(query, User.class, COLLECTION_NAME);
        for (User user : documentList) {
            log.info("查询到的用户信息为：{}", user);
        }
        return documentList;
    }
}
