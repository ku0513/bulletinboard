package com.example.bulletinboard;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name="user")
public class User {
    @Id
    @Column
    private String username;
    @Column
    private String encodedPassword;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEncodedPassword() {
        return encodedPassword;
    }
    public void setEncodedPassword(String encodedPassword) {
        this.encodedPassword = encodedPassword;
    }
}
