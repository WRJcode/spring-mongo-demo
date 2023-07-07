package org.alvin.service;

import com.mongodb.client.result.UpdateResult;
import lombok.extern.slf4j.Slf4j;
import org.alvin.pojo.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class UpdateService {

    private static final String COLLECTION_NAME = "users";

    @Resource
    private MongoTemplate mongoTemplate;

    public Object update(){

        Criteria criteria = Criteria.where("name").is("李云龙");
        // Update update = new Update().set("age", 21);

        Query query = new Query(criteria);
        Update update = new Update().set("age", 21);
        UpdateResult result = mongoTemplate.upsert(query, update, COLLECTION_NAME);

        String resultInfo = "匹配到" + result.getMatchedCount() + "条数据,对第一条数据进行了更改";
        log.info("更新结果：{}", resultInfo);
        return resultInfo;
    }

    /**
     * 更新集合中【匹配】查询到的【文档数据集合】中的【第一条数据】
     *
     * @return 执行更新的结果
     */
    public Object updateFirst() {
        // 创建条件对象
        Criteria criteria = Criteria.where("name").is("zhangsan");
        // 创建查询对象，然后将条件对象添加到其中，并设置排序
        Query query = new Query(criteria).with(Sort.by("age").ascending());
        // 创建更新对象,并设置更新的内容
        Update update = new Update().set("age", 30).set("name", "zhangsansan");
        // 执行更新
        UpdateResult result = mongoTemplate.updateFirst(query, update, User.class, COLLECTION_NAME);
        // 输出结果信息
        String resultInfo = "共匹配到" + result.getMatchedCount() + "条数据,修改了" + result.getModifiedCount() + "条数据";
        log.info("更新结果：{}", resultInfo);
        return resultInfo;
    }

    /**
     * 更新【匹配查询】到的【文档数据集合】中的【所有数据】
     *
     * @return 执行更新的结果
     */
    public Object updateMany() {
        // 创建条件对象
        Criteria criteria = Criteria.where("age").gt(28);
        // 创建查询对象，然后将条件对象添加到其中
        Query query = new Query(criteria);
        // 设置更新字段和更新的内容
        Update update = new Update().set("age", 29).set("salary", "1999");
        // 执行更新
        UpdateResult result = mongoTemplate.updateMulti(query, update, User.class, COLLECTION_NAME);
        // 输出结果信息
        String resultInfo = "总共匹配到" + result.getMatchedCount() + "条数据,修改了" + result.getModifiedCount() + "条数据";
        log.info("更新结果：{}", resultInfo);
        return resultInfo;
    }
}
