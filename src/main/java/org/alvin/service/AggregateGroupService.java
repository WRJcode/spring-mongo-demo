package org.alvin.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
@Slf4j
public class AggregateGroupService {

    private static final String COLLECTION_NAME = "users";

    @Resource
    private MongoTemplate mongoTemplate;

    public Object aggregationGroupCount() {
        // 使用管道操作符 $group 进行分组，然后统计各个组的文档数量
        AggregationOperation group = Aggregation.group("age").count().as("numCount");
        // 将操作加入到聚合对象中
        Aggregation aggregation = Aggregation.newAggregation(group);
        // 执行聚合查询
        AggregationResults<Map> results = mongoTemplate.aggregate(aggregation, COLLECTION_NAME, Map.class);
        for (Map result : results.getMappedResults()) {
            log.info("{}", result);
        }
        return results.getMappedResults();
    }

    public Object aggregationGroupMax(){
        AggregationOperation group = Aggregation.group("age").max("salary").as("salaryMax");

        Aggregation aggregation = Aggregation.newAggregation(group);

        AggregationResults<Map> results = mongoTemplate.aggregate(aggregation, COLLECTION_NAME, Map.class);
        for (Map result : results.getMappedResults()) {
            log.info("{}", result);
        }
        return results.getMappedResults();
    }

    public Object aggregationGroupMin(){
        AggregationOperation group = Aggregation.group("age").min("salary").as("salaryMin");

        Aggregation aggregation = Aggregation.newAggregation(group);

        AggregationResults<Map> results = mongoTemplate.aggregate(aggregation, COLLECTION_NAME, Map.class);
        for (Map result : results.getMappedResults()) {
            log.info("{}", result);
        }
        return results.getMappedResults();
    }

    public Object aggregationGroupSum(){
        AggregationOperation group = Aggregation.group("age").sum("salary").as("salarySum");

        Aggregation aggregation = Aggregation.newAggregation(group);

        AggregationResults<Map> results = mongoTemplate.aggregate(aggregation, COLLECTION_NAME, Map.class);
        for (Map result : results.getMappedResults()) {
            log.info("{}", result);
        }
        return results.getMappedResults();
    }

    public Object aggregationGroupAvg(){
        AggregationOperation group = Aggregation.group("age").avg("salary").as("salaryAvg");

        Aggregation aggregation = Aggregation.newAggregation(group);

        AggregationResults<Map> results = mongoTemplate.aggregate(aggregation, COLLECTION_NAME, Map.class);
        for (Map result : results.getMappedResults()) {
            log.info("{}", result);
        }
        return results.getMappedResults();
    }

    public Object aggregationGroupFirst(){
        AggregationOperation group = Aggregation.group("age").first("salary").as("salaryFirst");

        Aggregation aggregation = Aggregation.newAggregation(group);

        AggregationResults<Map> results = mongoTemplate.aggregate(aggregation, COLLECTION_NAME, Map.class);
        for (Map result : results.getMappedResults()) {
            log.info("{}", result);
        }
        return results.getMappedResults();
    }

    public Object aggregationGroupLast(){
        AggregationOperation group = Aggregation.group("age").last("salary").as("salaryLast");

        Aggregation aggregation = Aggregation.newAggregation(group);

        AggregationResults<Map> results = mongoTemplate.aggregate(aggregation, COLLECTION_NAME, Map.class);
        for (Map result : results.getMappedResults()) {
            log.info("{}", result);
        }
        return results.getMappedResults();
    }

    public Object aggregationGroupPush(){
        AggregationOperation group = Aggregation.group("age").push("salary").as("salaryPush");

        Aggregation aggregation = Aggregation.newAggregation(group);

        AggregationResults<Map> results = mongoTemplate.aggregate(aggregation, COLLECTION_NAME, Map.class);
        for (Map result : results.getMappedResults()) {
            log.info("{}", result);
        }
        return results.getMappedResults();
    }

    public Object aggregationGroupAddToSet(){
        AggregationOperation group = Aggregation.group("age").addToSet("salary").as("salaryAddToSet");

        Aggregation aggregation = Aggregation.newAggregation(group);

        AggregationResults<Map> results = mongoTemplate.aggregate(aggregation, COLLECTION_NAME, Map.class);
        for (Map result : results.getMappedResults()) {
            log.info("{}", result);
        }
        return results.getMappedResults();
    }


}
