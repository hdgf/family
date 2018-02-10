package com.universe.family.model.cronous.game;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="InventoryData")
public class InventoryBean {
    @Column(name="Character_Key")
    int chkey;
    @Column(name="Inventorypos")
    int inventorypos;
    @Column(name="Amount")
    int amount;
    @Column(name="Bitemid")
    int bitemid;
    @Column(name="UpgradePoint")
    int upgradepoint;
    @Column(name="Color")
    int color;
    @Column(name="Grade")
    int gade;
    @Column(name="Durability")
    int durability;

    @Column(name="Serialt")
    long serialt;

    @Id
    @Column(name="Serialc")
    long serialc;

    @Column(name="limitation")
    int limitation;
    @Column(name="Damage_values0")
    int damage_values0;
    @Column(name="Damage_values1")
    int damage_values1;
    @Column(name="Damage_values2")
    int damage_values2;
    @Column(name="Damage_values3")
    int damage_values3;
    @Column(name="Damage_values4")
    int damage_values4;
    @Column(name="Damage_values5")
    int damage_values5;
    @Column(name="Damage_values6")
    int damage_values6;
    @Column(name="Damage_values7")
    int damage_values7;
    @Column(name="OptionId0")
    int optionId0;
    @Column(name="OptionId1")
    int optionId1;
    @Column(name="OptionId2")
    int optionId2;
    @Column(name="OptionId3")
    int optionId3;
    @Column(name="OptionId4")
    int optionId4;
    @Column(name="OptionId5")
    int optionId5;
    @Column(name="OptionId6")
    int optionId6;
    @Column(name="OptionId7")
    int optionId7;

    public int getChkey() {
        return chkey;
    }

    public void setChkey(int chkey) {
        this.chkey = chkey;
    }

    public int getInventorypos() {
        return inventorypos;
    }

    public void setInventorypos(int inventorypos) {
        this.inventorypos = inventorypos;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getBitemid() {
        return bitemid;
    }

    public void setBitemid(int bitemid) {
        this.bitemid = bitemid;
    }

    public int getUpgradepoint() {
        return upgradepoint;
    }

    public void setUpgradepoint(int upgradepoint) {
        this.upgradepoint = upgradepoint;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getGade() {
        return gade;
    }

    public void setGade(int gade) {
        this.gade = gade;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public long getSerialt() {
        return serialt;
    }

    public void setSerialt(long serialt) {
        this.serialt = serialt;
    }

    public long getSerialc() {
        return serialc;
    }

    public void setSerialc(long serialc) {
        this.serialc = serialc;
    }

    public int getLimitation() {
        return limitation;
    }

    public void setLimitation(int limitation) {
        this.limitation = limitation;
    }

    public int getDamage_values0() {
        return damage_values0;
    }

    public void setDamage_values0(int damage_values0) {
        this.damage_values0 = damage_values0;
    }

    public int getDamage_values1() {
        return damage_values1;
    }

    public void setDamage_values1(int damage_values1) {
        this.damage_values1 = damage_values1;
    }

    public int getDamage_values2() {
        return damage_values2;
    }

    public void setDamage_values2(int damage_values2) {
        this.damage_values2 = damage_values2;
    }

    public int getDamage_values3() {
        return damage_values3;
    }

    public void setDamage_values3(int damage_values3) {
        this.damage_values3 = damage_values3;
    }

    public int getDamage_values4() {
        return damage_values4;
    }

    public void setDamage_values4(int damage_values4) {
        this.damage_values4 = damage_values4;
    }

    public int getDamage_values5() {
        return damage_values5;
    }

    public void setDamage_values5(int damage_values5) {
        this.damage_values5 = damage_values5;
    }

    public int getDamage_values6() {
        return damage_values6;
    }

    public void setDamage_values6(int damage_values6) {
        this.damage_values6 = damage_values6;
    }

    public int getDamage_values7() {
        return damage_values7;
    }

    public void setDamage_values7(int damage_values7) {
        this.damage_values7 = damage_values7;
    }

    public int getOptionId0() {
        return optionId0;
    }

    public void setOptionId0(int optionId0) {
        this.optionId0 = optionId0;
    }

    public int getOptionId1() {
        return optionId1;
    }

    public void setOptionId1(int optionId1) {
        this.optionId1 = optionId1;
    }

    public int getOptionId2() {
        return optionId2;
    }

    public void setOptionId2(int optionId2) {
        this.optionId2 = optionId2;
    }

    public int getOptionId3() {
        return optionId3;
    }

    public void setOptionId3(int optionId3) {
        this.optionId3 = optionId3;
    }

    public int getOptionId4() {
        return optionId4;
    }

    public void setOptionId4(int optionId4) {
        this.optionId4 = optionId4;
    }

    public int getOptionId5() {
        return optionId5;
    }

    public void setOptionId5(int optionId5) {
        this.optionId5 = optionId5;
    }

    public int getOptionId6() {
        return optionId6;
    }

    public void setOptionId6(int optionId6) {
        this.optionId6 = optionId6;
    }

    public int getOptionId7() {
        return optionId7;
    }

    public void setOptionId7(int optionId7) {
        this.optionId7 = optionId7;
    }
}
