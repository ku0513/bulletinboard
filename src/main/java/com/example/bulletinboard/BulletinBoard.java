package com.example.bulletinboard;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name="bulletinboard")
public class BulletinBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private Date createDate;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String createUser;
}
