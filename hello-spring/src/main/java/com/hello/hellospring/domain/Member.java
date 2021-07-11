package com.hello.hellospring.domain;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
public class Member {

    @Id // pk 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // db에 값을 넣으면 db가 id를 자동으로 생성해준다는 것을 '아이덴티티'라고 부른다!
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}