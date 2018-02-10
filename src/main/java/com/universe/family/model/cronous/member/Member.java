package com.universe.family.model.cronous.member;

import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;
import java.util.Date;

@Entity
@Qualifier(value="primaryDataSource")
@Table(name = "DB_Member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="No")
    int no;

    @Column(name = "Id")
    String userid;

    @Column(name = "Passwd")
    String passwd;

    @Column(name = "Email")
    String email;
/*
    @Column(name = "RegIp")
    String RegIp;
*/
    @Column(name = "Tuijian")
    String tuijian;

    @Column(name = "regdate")
    Date regdate;

    @Column(name = "vip")
    int vip;

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    public Member(String ID, String passwd, String email, String regIp, String tuijian, Date regdate) {
        this.userid = ID;
        this.passwd = passwd;
        this.email = email;
  //    RegIp = regIp;
        this.tuijian = tuijian;
        this.regdate = regdate;
    }

    public Member() {

    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTuijian() {
        return tuijian;
    }

    public void setTuijian(String tuijian) {
        this.tuijian = tuijian;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }
}
