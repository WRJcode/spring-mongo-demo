package org.alvin.service;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RemoveCollectionService {

    @Resource
    private MongoTemplate  mongoTemplate;

    public Object dropCollection(){
        String collectionName = "users3";
        mongoTemplate.getCollection(collectionName).drop();
        return mongoTemplate.collectionExists(collectionName)? "删除集合失败" : "删除集合成功";
    }
}
