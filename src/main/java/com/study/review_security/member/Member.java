package com.study.review_security.member;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Member {
    @Id
    private String id;
    private String password;
    private String name;
    private String email;
    private int projectId;
    private String role;
}
