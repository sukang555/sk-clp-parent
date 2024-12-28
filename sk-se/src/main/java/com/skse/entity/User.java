package com.skse.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.StringJoiner;

/**
 * Created by sukang on 2018/8/3.
 */
@Setter
@Getter
@ToString
public class User {

    private String name;

    private Integer sex;

    private LocalDateTime birth;

    public User(String name, Integer sex, LocalDateTime birth) {
        this.name = name;
        this.sex = sex;
        this.birth = birth;
    }

    public User(String name, Integer sex) {
        this.name = name;
        this.sex = sex;
    }

}
