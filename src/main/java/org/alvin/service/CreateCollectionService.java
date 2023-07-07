package org.alvin.service;

import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.validation.Validator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CreateCollectionService {

    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 创建集合
     *
     * @return Object
     */
    public Object createCollection() {
        String collectionName = "users1";
        mongoTemplate.createCollection(collectionName);
        return mongoTemplate.collectionExists(collectionName);
    }

    /**
     * 创建【固定大小集合】
     *
     * 创建集合并设置 `capped=true` 创建 `固定大小集合`，可以配置参数 `size` 限制文档大小，可以配置参数 `max` 限制集合文档数量。
     *
     * @return 创建集合的结果
     */
    public Object createCollectionFixedSize(){
        String collectionName = "users2";
        long size = 1024L;
        long max = 5L;
        CollectionOptions collectionOptions = CollectionOptions
                .empty()
                .capped()
                .size(size)
                .maxDocuments(max);
        mongoTemplate.createCollection(collectionName, collectionOptions);
        return mongoTemplate.collectionExists(collectionName)? "创建视图成功" : "创建视图失败";

    }

    public Object createCollectionValidation(){
        String collectionName = "users3";
        CriteriaDefinition criteria = Criteria.where("age").gt(20);
        CollectionOptions collectionOptions = CollectionOptions
                .empty()
                .validator(Validator.criteria(criteria))
                .strictValidation()
                .failOnValidationError();
        mongoTemplate.createCollection(collectionName, collectionOptions);
        return mongoTemplate.collectionExists(collectionName)? "创建视图成功" : "创建视图失败";
    }

}
