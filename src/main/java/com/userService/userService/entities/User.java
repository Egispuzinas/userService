package com.userService.userService.entities;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "t_user", schema = "public")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name = "f_id")
    private Long id;

    @Column(name = "f_name")
    private String name;
    //gali buti null
    @Column(name = "f_create_date")
    @CreatedDate
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private LocalDateTime date;

    @Column(name = "f_modified_date")
    @LastModifiedDate
    private LocalDateTime date_modified;

    @Column(name = "f_phone")
    private int phone;

    @Column(name = "f_otp")
    private String otp;

    //Default konstruktorius
    public User(){}

    public String getName() {
        return name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public LocalDateTime getDate_modified() {
        return date_modified;
    }

    public User(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public int getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setDate_modified(LocalDateTime date_modified) {
        this.date_modified = date_modified;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public User(Long id, String name, LocalDateTime date, LocalDateTime date_modified, int phone, String otp) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.date_modified = date_modified;
        this.phone = phone;
        this.otp = otp;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", date_modified=" + date_modified +
                ", phone=" + phone +
                '}';
    }
}
