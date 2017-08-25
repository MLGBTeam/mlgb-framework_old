package cn.mlgbteam.authorization.api.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //自增时使用@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "MYSQL")
    private String id;

    private String name;

    private Integer age;

}
