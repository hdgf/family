package com.universe.family.model.cronous.game;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CharacterBottom")
public class CharacterBottom {
    @Id
    @Column(name="Character_Key")
    int cKey;

    @Column(name="Quest")
    String quest;
    @Column(name="AccountId")
    String accountId;
    @Column(name="GuildName")
    String guildName;
    @Column(name="KilledTimes")
    int killedtimes;
    @Column(name="Score")
    int score;
    @Column(name="Polymorphleft")
    int polymorphleft;
    @Column(name="UnionCode")
    long unioncode;
    @Column(name="PolymorphstartTime")
    long polymorphstarttime;
    @Column(name="AvatarSerialTime")
    long avatarserialtime;
    @Column(name="AvatarSerialCount")
    long avatarserialcount;
    @Column(name="PetSerialTime")
    long petserialtime;
    @Column(name="PetSerialCount")
    long petserialcount;
    @Column(name="IsMasterCharacter")
    int ismastercharacter;
    @Column(name="CompletedMasterQuest")
    int completedmasterQuest;
    @Column(name="CompletedHerosQuest")
    int completedherosquest;
    @Column(name="TurnMasterLevel")
    int turnmasterlevel;

    public int getcKey() {
        return cKey;
    }

    public void setcKey(int cKey) {
        this.cKey = cKey;
    }

    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getGuildName() {
        return guildName;
    }

    public void setGuildName(String guildName) {
        this.guildName = guildName;
    }

    public int getKilledtimes() {
        return killedtimes;
    }

    public void setKilledtimes(int killedtimes) {
        this.killedtimes = killedtimes;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPolymorphleft() {
        return polymorphleft;
    }

    public void setPolymorphleft(int polymorphleft) {
        this.polymorphleft = polymorphleft;
    }

    public long getUnioncode() {
        return unioncode;
    }

    public void setUnioncode(long unioncode) {
        this.unioncode = unioncode;
    }

    public long getPolymorphstarttime() {
        return polymorphstarttime;
    }

    public void setPolymorphstarttime(long polymorphstarttime) {
        this.polymorphstarttime = polymorphstarttime;
    }

    public long getAvatarserialtime() {
        return avatarserialtime;
    }

    public void setAvatarserialtime(long avatarserialtime) {
        this.avatarserialtime = avatarserialtime;
    }

    public long getAvatarserialcount() {
        return avatarserialcount;
    }

    public void setAvatarserialcount(long avatarserialcount) {
        this.avatarserialcount = avatarserialcount;
    }

    public long getPetserialtime() {
        return petserialtime;
    }

    public void setPetserialtime(long petserialtime) {
        this.petserialtime = petserialtime;
    }

    public long getPetserialcount() {
        return petserialcount;
    }

    public void setPetserialcount(long petserialcount) {
        this.petserialcount = petserialcount;
    }

    public int getIsmastercharacter() {
        return ismastercharacter;
    }

    public void setIsmastercharacter(int ismastercharacter) {
        this.ismastercharacter = ismastercharacter;
    }

    public int getCompletedmasterQuest() {
        return completedmasterQuest;
    }

    public void setCompletedmasterQuest(int completedmasterQuest) {
        this.completedmasterQuest = completedmasterQuest;
    }

    public int getCompletedherosquest() {
        return completedherosquest;
    }

    public void setCompletedherosquest(int completedherosquest) {
        this.completedherosquest = completedherosquest;
    }

    public int getTurnmasterlevel() {
        return turnmasterlevel;
    }

    public void setTurnmasterlevel(int turnmasterlevel) {
        this.turnmasterlevel = turnmasterlevel;
    }
}
