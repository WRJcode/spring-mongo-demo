package org.alvin.service;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ViewService {

    @Resource
    private MongoTemplate mongoTemplate;

    public Object createView(){
        String viewName = "usersView";
        String collectionName = "users";
        List<Bson> pipeline = new ArrayList<>();
        pipeline.add(Document.parse("{\"$match\":{\"sex\":\"男\"}}"));
        mongoTemplate.getDb().createView(viewName, collectionName, pipeline);
        return mongoTemplate.collectionExists(viewName) ? "创建视图成功" : "创建视图失败";
    }

    public Object dropView(){
        String viewName = "usersView";
        if (mongoTemplate.collectionExists(viewName)){
            mongoTemplate.getDb().getCollection(viewName).drop();
            return "删除视图成功";
        }
        return mongoTemplate.collectionExists(viewName) ? "删除视图失败" : "删除视图成功";
    }
}
