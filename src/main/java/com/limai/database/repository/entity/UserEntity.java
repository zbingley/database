package com.limai.database.repository.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangbin
 * @Date: 2018/11/2 15:40
 * @Desc:
 */
@Data
@Document(collection = "user")
public class UserEntity {
    @Id
    private ObjectId userId;
    private String name;
    private String mobile;
    private String openid;
    private List<LinkmanEntity> linkmans=new ArrayList<>();

}
