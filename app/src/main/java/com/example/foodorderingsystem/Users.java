package com.example.foodorderingsystem;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Users {
    @PrimaryKey(autoGenerate = true)
    private int id;

    public String username;
    public String pw;
    public String email;

    public void setId(int id) {this.id = id;}
    public int getId() {return id;}
    public void setUsername(String username) {this.username = username;}
    public String getUsername() {return username;}
    public void setPw(String pw) {this.pw = pw;}
    public String getPw() {return pw;}
    public void setEmail(String email) {this.email = email;}
    public String getEmail() {return email;}

}
