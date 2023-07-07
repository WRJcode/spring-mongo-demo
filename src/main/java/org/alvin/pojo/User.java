package org.alvin.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@ToString
@Accessors(chain = true)
@Document(collection = "user")
public class User {
    @Id
    private String id;
    private String name;
    private Integer age;
    private String sex;
    private Integer salary;
    private String remake;
    private Status status;
    @JsonFormat( pattern ="yyyy-MM-dd", timezone ="GMT+8")
    private Date birthday;
}

