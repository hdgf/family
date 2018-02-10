package com.universe.family.model.cronous.game;

import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;
import java.util.Date;

@Entity
@Qualifier(value="gameDataSource")
@Table(name = "PersonalAccount")
public class PersonalAccount {
    @Column(name = "UserId")
    String userid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Personal_Key")
    int personkey;

    @Column(name = "MLGPoint")
    int mpoint;

    public PersonalAccount(String userid, int mpoint, int spoint, int stashgold, Date createtime) {
        this.userid = userid;
        this.mpoint = mpoint;
        this.spoint = spoint;
        this.stashgold = stashgold;
        this.createtime = createtime;
    }

    @Column(name = "ShopPoint")
    int spoint;

    @Column(name = "StashGold")
    int stashgold;

    @Column(name = "CreateTime")
    Date createtime;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getPersonkey() {
        return personkey;
    }

    public void setPersonkey(int personkey) {
        this.personkey = personkey;
    }

    public int getMpoint() {
        return mpoint;
    }

    public void setMpoint(int mpoint) {
        this.mpoint = mpoint;
    }

    public int getSpoint() {
        return spoint;
    }

    public void setSpoint(int spoint) {
        this.spoint = spoint;
    }

    public int getStashgold() {
        return stashgold;
    }

    public void setStashgold(int stashgold) {
        this.stashgold = stashgold;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public PersonalAccount(){

    }


/*
    @Override
    public String toString() {
        String result = String.format(
                "PersonalKey[key=%d, name='%s']%n",
                PersonalKey, UserId);
        if (characterPacks != null) {
            for(CharacterPack role : characterPacks) {
                result += String.format(
                        "Role[id=%d, name='%s']%n",
                        role.getCkey(), role.getCharactername());
            }
        }

        return result;
    }
*/
}
