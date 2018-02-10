package com.universe.family.model.cronous.season2;

import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Qualifier(value="season2DataSource")
@Table(name="CharacterPack")
public class CharacterPack {
    @Column(name="Personal_Key")
    int personid;

    @Id
    @Column(name="Character_Key")
    int ckey;

    @Column(name="Admin_Level")
    int adminlevel;

    @Column(name="IP")
    int ip;

    @Column(name="Create_Time")
    int createtime;

    @Column(name="Login_Time")
    int logintime;

    @Column(name="Out_Time")
    int outtime;

    @Column(name="Character_Name")
    String charactername;

    @Column(name="Character_Level")
    int characterlevel;

    @Column(name="Character_Class")
    int characterclass;

    @Column(name="Character_Master")
    int charactermaster;

    @Column(name="CreateTime")
    Date cTime;

    @Column(name="UpdateTime")
    Date utime;

    @Column(name="Character_Sex")
    int charactersex;

    @Column(name="Weapon")
    int weapon;

    @Column(name="Shield")
    int shield;

    @Column(name="Armor")
    int armor;

    @Column(name="Helmet")
    int helmet;

    @Column(name="Glove")
    int glove;

    @Column(name="Boot")
    int boot;

    public CharacterPack() {

    }

    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }

    public int getCkey() {
        return ckey;
    }

    public void setCkey(int ckey) {
        this.ckey = ckey;
    }

    public int getAdminlevel() {
        return adminlevel;
    }

    public void setAdminlevel(int adminlevel) {
        this.adminlevel = adminlevel;
    }

    public int getIp() {
        return ip;
    }

    public void setIp(int ip) {
        this.ip = ip;
    }

    public int getCreatetime() {
        return createtime;
    }

    public void setCreatetime(int createtime) {
        this.createtime = createtime;
    }

    public int getLogintime() {
        return logintime;
    }

    public void setLogintime(int logintime) {
        this.logintime = logintime;
    }

    public int getOuttime() {
        return outtime;
    }

    public void setOuttime(int outtime) {
        this.outtime = outtime;
    }

    public String getCharactername() {
        return charactername;
    }

    public void setCharactername(String charactername) {
        this.charactername = charactername;
    }

    public int getCharacterlevel() {
        return characterlevel;
    }

    public void setCharacterlevel(int characterlevel) {
        this.characterlevel = characterlevel;
    }

    public int getCharacterclass() {
        return characterclass;
    }

    public void setCharacterclass(int characterclass) {
        this.characterclass = characterclass;
    }

    public int getCharactermaster() {
        return charactermaster;
    }

    public void setCharactermaster(int charactermaster) {
        this.charactermaster = charactermaster;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public int getCharactersex() {
        return charactersex;
    }

    public void setCharactersex(int charactersex) {
        this.charactersex = charactersex;
    }

    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getHelmet() {
        return helmet;
    }

    public void setHelmet(int helmet) {
        this.helmet = helmet;
    }

    public int getGlove() {
        return glove;
    }

    public void setGlove(int glove) {
        this.glove = glove;
    }

    public int getBoot() {
        return boot;
    }

    public void setBoot(int boot) {
        this.boot = boot;
    }
}
