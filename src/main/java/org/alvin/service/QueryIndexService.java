package org.alvin.service;


import com.mongodb.client.ListIndexesIterable;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class QueryIndexService {

    private static final String COLLECTION_NAME = "users";

    @Resource
    private MongoTemplate mongoTemplate;

    public Object getIndexAll(){
        ListIndexesIterable<Document> indexList = mongoTemplate.getCollection(COLLECTION_NAME).listIndexes();
        // 创建字符串集合
        List<Document> list = new ArrayList<>();
        // 获取集合中全部索引信息
        for (Document document : indexList) {
            log.info("索引列表：{}",document);
            list.add(document);
        }
        return list;
    }
}
