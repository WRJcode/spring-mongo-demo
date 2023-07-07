package org.alvin.service;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class QueryCollectionService {

    @Resource
    private MongoTemplate mongoTemplate;

    public Object getCollectionNames(){
        return mongoTemplate.getCollectionNames();
    }

    public boolean collectionExists(){
        String collectionName = "users";
        return mongoTemplate.collectionExists(collectionName);
    }
}
