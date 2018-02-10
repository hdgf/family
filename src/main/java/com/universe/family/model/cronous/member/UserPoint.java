package com.universe.family.model.cronous.member;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="F_ID")
    private int id;

    @Column(name="F_UserName")
    private String userName;

    @Column(name="F_KLSPoint")
    private int point;

    private int JF;
    private int MaiDa;
    private int MaiXiao;
    private int MaiDan;
    private int MaiShuang;
    private int BaoZi;
    private int SumBuy;
    private Date BuyTime;

    public UserPoint(){

    }

    public UserPoint(String userName, int point, int JF, int maiDa, int maiXiao, int maiDan, int maiShuang, int baoZi, int sumBuy, Date buyTime) {
        this.userName = userName;
        this.point = point;
        this.JF = JF;
        MaiDa = maiDa;
        MaiXiao = maiXiao;
        MaiDan = maiDan;
        MaiShuang = maiShuang;
        BaoZi = baoZi;
        SumBuy = sumBuy;
        BuyTime = buyTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getJF() {
        return JF;
    }

    public void setJF(int JF) {
        this.JF = JF;
    }

    public int getMaiDa() {
        return MaiDa;
    }

    public void setMaiDa(int maiDa) {
        MaiDa = maiDa;
    }

    public int getMaiXiao() {
        return MaiXiao;
    }

    public void setMaiXiao(int maiXiao) {
        MaiXiao = maiXiao;
    }

    public int getMaiDan() {
        return MaiDan;
    }

    public void setMaiDan(int maiDan) {
        MaiDan = maiDan;
    }

    public int getMaiShuang() {
        return MaiShuang;
    }

    public void setMaiShuang(int maiShuang) {
        MaiShuang = maiShuang;
    }

    public int getBaoZi() {
        return BaoZi;
    }

    public void setBaoZi(int baoZi) {
        BaoZi = baoZi;
    }

    public int getSumBuy() {
        return SumBuy;
    }

    public void setSumBuy(int sumBuy) {
        SumBuy = sumBuy;
    }

    public Date getBuyTime() {
        return BuyTime;
    }

    public void setBuyTime(Date buyTime) {
        BuyTime = buyTime;
    }
}
