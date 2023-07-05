## SpringBoot集成MongoDB

### 1. pom.xml中引入依赖

```xml
<!-- mongodb -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-mongodb</artifactId>
    <version>2.1.6.RELEASE</version>
</dependency>
```

### 2. application.yml中配置mongodb

```yaml
spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/test
```

### 3. 编写实体类

```java
@Data
@Document(collection = "user")
public class User {
    @Id
    private String id;
    private String name;
    private Integer age;
}
```

### 4. 编写Repository

```java
public interface UserRepository extends MongoRepository<User, String> {
}
```

### 5. 编写测试类

```java
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave() {
        User user = new User();
        user.setName("张三");
        user.setAge(20);
        userRepository.save(user);
    }

    @Test
    public void testFindAll() {
        List<User> userList = userRepository.findAll();
        System.out.println(userList);
    }

    @Test
    public void testFindById() {
        Optional<User> optional = userRepository.findById("5d3b0b3b1c9d440000e1b0b1");
        System.out.println(optional.get());
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId("5d3b0b3b1c9d440000e1b0b1");
        user.setName("李四");
        user.setAge(30);
        userRepository.save(user);
    }

    @Test
    public void testDelete() {
        userRepository.deleteById("5d3b0b3b1c9d440000e1b0b1");
    }
}
```

### 6. 测试结果

```java

```

### 7. mongoDB应用场景

- 日志系统
- 内容管理系统
- 产品目录
- 产品数据管理
- 电子商务
- 信息提取
- 数据仓库
- 缓存
- 位置服务
- 用户行为分析
- 个性化内容
- 服务器监控
- 传感器数据
- 机器数据
- 人工智能
- 机器学习

### 8. mongoDB介绍

- MongoDB是一个基于分布式文件存储的数据库，由C++语言编写，旨在为WEB应用提供可扩展的高性能数据存储解决方案。
- MongoDB是一个介于关系数据库和非关系数据库之间的产品，是非关系数据库当中功能最丰富，最像关系数据库的。
- MongoDB支持的数据结构非常松散，是类似json的bson格式，因此可以存储比较复杂的数据类型。
- MongoDB最大的特点是它支持的查询语言非常强大，其语法有点类似于面向对象的查询语言，几乎可以实现类似关系数据库单表查询的绝大部分功能，而且还支持对数据建立索引。
- MongoDB的性能非常高，特别是在查询一较多的情况下，查询语句可以使用索引，以避免全表扫描。
- MongoDB的安装和使用非常方便，它的操作语言非常简单，类似于面向对象的查询语言，几乎可以实现类似关系数据库单表查询的绝大部分功能。
- MongoDB的支持非常好，不管是在Windows还是Linux平台下，还是Java、PHP、Python等编程语言下，都有非常完善的MongoDB支持。
- MongoDB的缺点是不支持事务处理，这个在一开始设计时就没有考虑进去，所以对于一些要求使用事务处理的项目可能不太合适。
- MongoDB的应用场景非常多，特别是对数据高性能高可用性的要求越来越多的今天，MongoDB可以说是一个非常好的选择。

### 9. mongoDB的安装

- 下载地址：https://www.mongodb.com/download-center/community
- 安装目录：D:\mongodb
- 数据目录：D:\mongodb\data
- 日志目录：D:\mongodb\log
- 配置文件：D:\mongodb\mongod.cfg
- 启动命令：mongod --config D:\mongodb\mongod.cfg
- 客户端命令：mongo
- 停止命令：use admin db.shutdownServer()
- 参考文档：https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/

### 10. mongoDB的基本概念

- 数据库：数据库是一个仓库，可以容纳多个集合。
- 集合：集合是一组MongoDB文档，类似于关系型数据库中的表格。
- 文档：文档是一组键值(key-value)对(即BSON)。MongoDB文档类似于JSON对象。字段值可以包含其他文档、数组及文档数组。
- 字段：文档的键值对中的键称为字段。
- 主键：每个文档都有一个特殊的键"_id"，这个键的值用来唯一标识文档。
- BSON：BSON是一种类json的一种二进制形式的存储格式，简称Binary JSON。BSON和JSON相比，BSON有一些扩展的数据类型，比如日期类型和二进制数据类型等。
- ObjectId：ObjectId是一个12字节的BSON类型数据，有以下格式：
  - 前4个字节表示时间戳
  - 接下来的3个字节是机器标识码
  - 紧接的两个字节由进程id组成（PID）
  - 最后三个字节是随机数
  - ObjectId是MongoDB集群中每个文档的唯一标识，很类似于关系型数据库中的主键，可以保证集合中每个文档的唯一性。
  - ObjectId是MongoDB自动生成的，当插入文档时，如果没有指定_id字段，则MongoDB会自动为每个文档添加一个唯一的ObjectId，所以集合中每个文档都有一个唯一的_id字段。
  - ObjectId是根据时间戳生成的，所以ObjectId查询效率很高，但是它是有序的，所以在一些场景下会暴露一些隐私，比如注册时间等。
  - ObjectId的优点是生成效率高，且有序，但是缺点是暴露了一些隐私，所以在一些场景下需要隐藏这些信息，比如注册时间等。
  - ObjectId的第一个字节代表了MongoDB文档的结构，第一个字节的前4位是版�

### 11. mongoDB的基本命令

- show dbs：显示所有数据库。
- use db_name：切换到指定的数据库，如果没有则创建。
- db：显示当前数据库对象或集合。
- show collections：显示当前数据库中的所有集合。
- db.collection_name.find()：查询集合中的所有文档。
- db.collection_name.findOne()：查询集合中的第一个文档。
- db.collection_name.insert(document)：向集合中插入一个文档。
- db.collection_name.update(query, update, options)：更新集合中的文档。
- db.collection_name.remove(query)：删除集合中的文档。
- db.collection_name.drop()：删除集合。
- db.dropDatabase()：删除数据库。
- db.collection_name.count()：统计集合中文档的数量。
- db.collection_name.find().limit(number)：查询集合中的文档并限制数量。
- db.collection_name.find().skip(number)：查询集合中的文档并跳过指定数量。
- db.collection_name.find().sort({key:1})：查询集合中的文档并排序。
- db.collection_name.find({key:{$gt:value}})：查询集合中的文档并筛选。
- db.collection_name.find({key:{$regex:value}})：查询集合中的文档并模糊匹配。
- db.collection_name.find({key:{$in:[value1, value2]}})：查询集合中的文档并匹配多个值。
- db.collection_name.find({key:{$exists:true}})：查询集合中的文档并筛选存在的字段。
- db.collection_name.find({key:{$type:type}})：查询集合中的文档并筛选指定类型的字段。
- db.collection_name.find({key:{$all:[value1, value2]}})：查询集合中的文档并匹配多个值。
- db.collection_name.find({key:{$size:size}})：查询集合中的文档并筛选指定长度的字段。
- db.collection_name.find({key:{$elemMatch:{key:value}}})：查询集合中的文档并筛选指定条件的字段。
- db.collection_name.find({key:{$not:{key:value}}})：查询集合中的文档并筛选不符合条件的字段。
- db.collection_name.find({key:{$ne:value}})：查询集合中的文档并筛选不等于指定值的字段。

### 12. mongoDB的数据类型

- String：字符串，最常用，必须是有效的UTF-8。
- Integer：整型数值，用于存储数值，根据值的大小，可分为32位整型和64位整型。
- Boolean：布尔值，用于存储布尔值（true/ false）。
- Double：双精度浮点值，用于存储浮点值。
- Min/ Max keys：将一个值与BSON（二进制的JSON）元素的最低值和最高值相对比。
- Array：用于将数组或列表或多个值存储为一个键。
- Timestamp：时间戳，记录文档修改或添加的具体时间。
- Object：用于内嵌文档。
- Null：用于创建空值。
- Symbol：符号，该数据类型基本上等同于字符串类型，但不同的是，它一般用于采用特殊符号类型的语言。
- Date：日期时间，用UNIX时间格式来存储当前日期或时间。你可以指定自己的日期时间：创建Date对象，传入年月日信息。
- Object ID：对象ID，用于创建文档的ID。
- Binary data：二进制数据，用于存储二进制数据。
- Code：代码类型，用于在文档中存储JavaScript代码。
- Regular expression：正则表达式类型，用于存储正则表达式。
- DBRef：数据库引用类型，用于实现集合之间的关联。
- JavaScript：JavaScript代码，用于将JavaScript代码存储到文档中。

### 13. mongoDB的索引

- 索引是对数据库表中一列或多列的值进行排序的一种结构，使用索引可快速访问数据库表中的特定信息。

### 14. mongoDB的聚合

- 聚合是一种数据处理机制，它将一条数据集合（如一个数组）映射成另外一种数据集合（如一个值或一个新的数组）。
- 聚合主要用于处理数据（诸如统计平均值或求和）并返回计算后的结果。
- 聚合可以根据条件来过滤数据，并返回计算后的结果。
- 聚合可以通过多个步骤来处理数据。
- 聚合可以使用内置的聚合管道来处理数据。
- 聚合可以使用聚合表达式来处理数据。
- 聚合可以使用聚合操作符来处理数据。
- 聚合可以使用聚合管道操作符来处理数据。

### 15. mongoDB的备份与恢复

- mongodump：备份数据库。
- mongorestore：恢复数据库。
- mongodump -h dbhost -d dbname -o dbdirectory：备份数据库到指定目录。
- mongorestore -h dbhost -d dbname path：从指定目录恢复数据库。
- mongodump -h
- dbhost -d dbname -c collection -o dbdirectory：备份集合到指定目录。
- mongorestore -h dbhost -d dbname -c collection path：从指定目录恢复集合。
- mongodump -h dbhost -d dbname -c collection -q query -o dbdirectory：备份集合中的指定数据到指定目录。
- mongorestore -h dbhost -d dbname -c collection --drop path：从指定目录恢复集合并覆盖原有数据。
- mongodump -h dbhost -d dbname -c collection -q query -o dbdirectory：备份集合中的指定数据到指定目录。
- mongorestore -h dbhost -d dbname -c collection --drop path：从指定目录恢复集合并覆盖原有数据。
- mongodump -h dbhost -d dbname -c collection -q query -o dbdirectory：备份集合中的指定数据到指定目录。
- mongorestore -h dbhost -d dbname -c collection --drop path：从指定目录恢复集合并覆盖原有数据。
- mongodump -h dbhost -d dbname -c collection -q query -o dbdirectory：备份集合中的指定数据到指定目录。

### 16. spring-boot-starter-data-mongodb功能





