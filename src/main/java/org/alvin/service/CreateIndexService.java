package org.alvin.service;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class CreateIndexService {
    /**
     * 设置集合名称
     */
    private static final String COLLECTION_NAME = "users";

    @Resource
    private MongoTemplate mongoTemplate;

    public Object createAscendingIndex() {
        String field = "name";
        return mongoTemplate.getCollection(COLLECTION_NAME).createIndex(Indexes.ascending(field));
    }

    public Object createDescendingIndex(){
        String field = "name";
        return mongoTemplate.getCollection(COLLECTION_NAME).createIndex(Indexes.descending(field));
    }

    public Object createCompositeIndex(){
        String field1 = "name";
        String field2 = "age";
        return mongoTemplate.getCollection(COLLECTION_NAME).createIndex(Indexes.compoundIndex(Indexes.ascending(field1), Indexes.descending(field2)));
    }

    public Object createTextIndex(){
        String field = "name";
        return mongoTemplate.getCollection(COLLECTION_NAME).createIndex(Indexes.text(field));
    }

    public Object createUniqueIndex(){
        String indexName = "name";
        IndexOptions options = new IndexOptions();

        options.unique(true);

        return mongoTemplate.getCollection(COLLECTION_NAME).createIndex(Indexes.ascending(indexName), options);
    }

    public Object createPartialIndex(){
        String field = "name";
        IndexOptions options = new IndexOptions();
        options.partialFilterExpression(Filters.exists(field, true));

        return mongoTemplate.getCollection(COLLECTION_NAME).createIndex(Indexes.ascending(field), options);
    }
}
