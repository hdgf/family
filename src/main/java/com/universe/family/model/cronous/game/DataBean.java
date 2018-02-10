package com.universe.family.model.cronous.game;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="CharacterData")
public class DataBean {
    @Id
    @Column(name="Character_Key")
    int ckey;
    @Column(name="Name")
    String name;
    @Column(name="Level")
    int level;
    @Column(name="AdminLevel")
    int adminlevel;
    @Column(name="Pos")
    int pos;
    @Column(name="Kind")
    int kind;
    @Column(name="LastZone")
    int lastzone;
    @Column(name="Str")
    int str;
    @Column(name="Dex")
    int dex;
    @Column(name="Con")
    int con;
    @Column(name="Int")
    int inte;
    @Column(name="Vir")
    int vir;
    @Column(name="HP")
    int hp;
    @Column(name="MP")
    int mp;
    @Column(name="State_Point")
    int statepoint;
    @Column(name="Skill_Point")
    int skillpoint;
    @Column(name="Exp")
    float exp;
    @Column(name="Gold")
    int gold;
    @Column(name="Gold_InStash")
    long goldinstash;
    @Column(name="SP")
    int sp;
    @Column(name="ApExp_Type1")
    float apexptype1;
    @Column(name="ApExp_Type2")
    float apexptype2;
    @Column(name="PkMode")
    int pkmode;
    @Column(name="PkTime")
    int pktime;
    @Column(name="Virtue")
    int virtue;
    @Column(name="CreateTime")
    Date createtime;
    @Column(name="UpdateTime")
    Date updatetime;
    @Column(name="Sex")
    int sex;

    public int getCkey() {
        return ckey;
    }

    public void setCkey(int ckey) {
        this.ckey = ckey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAdminlevel() {
        return adminlevel;
    }

    public void setAdminlevel(int adminlevel) {
        this.adminlevel = adminlevel;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public int getLastzone() {
        return lastzone;
    }

    public void setLastzone(int lastzone) {
        this.lastzone = lastzone;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getCon() {
        return con;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public int getInte() {
        return inte;
    }

    public void setInte(int inte) {
        this.inte = inte;
    }

    public int getVir() {
        return vir;
    }

    public void setVir(int vir) {
        this.vir = vir;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getStatepoint() {
        return statepoint;
    }

    public void setStatepoint(int statepoint) {
        this.statepoint = statepoint;
    }

    public int getSkillpoint() {
        return skillpoint;
    }

    public void setSkillpoint(int skillpoint) {
        this.skillpoint = skillpoint;
    }

    public float getExp() {
        return exp;
    }

    public void setExp(float exp) {
        this.exp = exp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public long getGoldinstash() {
        return goldinstash;
    }

    public void setGoldinstash(long goldinstash) {
        this.goldinstash = goldinstash;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public float getApexptype1() {
        return apexptype1;
    }

    public void setApexptype1(float apexptype1) {
        this.apexptype1 = apexptype1;
    }

    public float getApexptype2() {
        return apexptype2;
    }

    public void setApexptype2(float apexptype2) {
        this.apexptype2 = apexptype2;
    }

    public int getPkmode() {
        return pkmode;
    }

    public void setPkmode(int pkmode) {
        this.pkmode = pkmode;
    }

    public int getPktime() {
        return pktime;
    }

    public void setPktime(int pktime) {
        this.pktime = pktime;
    }

    public int getVirtue() {
        return virtue;
    }

    public void setVirtue(int virtue) {
        this.virtue = virtue;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
