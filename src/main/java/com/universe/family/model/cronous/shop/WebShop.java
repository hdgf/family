package com.universe.family.model.cronous.shop;

import javax.persistence.*;
import java.util.Date;

@Entity
public class WebShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name="ItemName")
    private String name;

    @Column(name="ItemType")
    private String type;

    private int NeedMaoDou;
    private int NeedCroPoint;
    private int NeedGloryPoint;
    private int NeedVip;
    private int LastConut;
    private String ItemPic;
    private String ItemText;
    @Column(name="ItemTime")
    private Date time;
    @Column(name="IsTop")
    private int istop;
    @Column(name="Yn")
    private int yn;
    private String Amount;

    @Column(name="Bitemid")
    private String bitemid;

    private String UpgradePoint;
    private String Color;
    private String Grade;
    private String Durability;
    private String Serialt;
    private String Serialc;
    private String limitation;
    private String Damage_values0;
    private String Damage_values1;
    private String Damage_values2;
    private String Damage_values3;
    private String Damage_values4;
    private String Damage_values5;
    private String Damage_values6;
    private String Damage_values7;
    private String OptionId0;
    private String OptionId1;
    private String OptionId2;
    private String OptionId3;
    private String OptionId4;
    private String OptionId5;
    private String OptionId6;
    private String OptionId7;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String itemName) {
        name = itemName;
    }

    public int getIstop() {
        return istop;
    }

    public void setIstop(int istop) {
        this.istop = istop;
    }

    public int getYn() {
        return yn;
    }

    public void setYn(int yn) {
        this.yn = yn;
    }

    public int getNeedMaoDou() {
        return NeedMaoDou;
    }

    public void setNeedMaoDou(int needMaoDou) {
        NeedMaoDou = needMaoDou;
    }

    public int getNeedCroPoint() {
        return NeedCroPoint;
    }

    public void setNeedCroPoint(int needCroPoint) {
        NeedCroPoint = needCroPoint;
    }

    public int getNeedGloryPoint() {
        return NeedGloryPoint;
    }

    public void setNeedGloryPoint(int needGloryPoint) {
        NeedGloryPoint = needGloryPoint;
    }

    public int getNeedVip() {
        return NeedVip;
    }

    public void setNeedVip(int needVip) {
        NeedVip = needVip;
    }

    public int getLastConut() {
        return LastConut;
    }

    public void setLastConut(int lastConut) {
        LastConut = lastConut;
    }

    public String getItemPic() {
        return ItemPic;
    }

    public void setItemPic(String itemPic) {
        ItemPic = itemPic;
    }

    public String getItemText() {
        return ItemText;
    }

    public void setItemText(String itemText) {
        ItemText = itemText;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date itemTime) {
        time = itemTime;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getBitemid() {
        return bitemid;
    }

    public void setBitemid(String bitemid) {
        bitemid = bitemid;
    }

    public String getUpgradePoint() {
        return UpgradePoint;
    }

    public void setUpgradePoint(String upgradePoint) {
        UpgradePoint = upgradePoint;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getDurability() {
        return Durability;
    }

    public void setDurability(String durability) {
        Durability = durability;
    }

    public String getSerialt() {
        return Serialt;
    }

    public void setSerialt(String serialt) {
        Serialt = serialt;
    }

    public String getSerialc() {
        return Serialc;
    }

    public void setSerialc(String serialc) {
        Serialc = serialc;
    }

    public String getLimitation() {
        return limitation;
    }

    public void setLimitation(String limitation) {
        this.limitation = limitation;
    }

    public String getDamage_values0() {
        return Damage_values0;
    }

    public void setDamage_values0(String damage_values0) {
        Damage_values0 = damage_values0;
    }

    public String getDamage_values1() {
        return Damage_values1;
    }

    public void setDamage_values1(String damage_values1) {
        Damage_values1 = damage_values1;
    }

    public String getDamage_values2() {
        return Damage_values2;
    }

    public void setDamage_values2(String damage_values2) {
        Damage_values2 = damage_values2;
    }

    public String getDamage_values3() {
        return Damage_values3;
    }

    public void setDamage_values3(String damage_values3) {
        Damage_values3 = damage_values3;
    }

    public String getDamage_values4() {
        return Damage_values4;
    }

    public void setDamage_values4(String damage_values4) {
        Damage_values4 = damage_values4;
    }

    public String getDamage_values5() {
        return Damage_values5;
    }

    public void setDamage_values5(String damage_values5) {
        Damage_values5 = damage_values5;
    }

    public String getDamage_values6() {
        return Damage_values6;
    }

    public void setDamage_values6(String damage_values6) {
        Damage_values6 = damage_values6;
    }

    public String getDamage_values7() {
        return Damage_values7;
    }

    public void setDamage_values7(String damage_values7) {
        Damage_values7 = damage_values7;
    }

    public String getOptionId0() {
        return OptionId0;
    }

    public void setOptionId0(String optionId0) {
        OptionId0 = optionId0;
    }

    public String getOptionId1() {
        return OptionId1;
    }

    public void setOptionId1(String optionId1) {
        OptionId1 = optionId1;
    }

    public String getOptionId2() {
        return OptionId2;
    }

    public void setOptionId2(String optionId2) {
        OptionId2 = optionId2;
    }

    public String getOptionId3() {
        return OptionId3;
    }

    public void setOptionId3(String optionId3) {
        OptionId3 = optionId3;
    }

    public String getOptionId4() {
        return OptionId4;
    }

    public void setOptionId4(String optionId4) {
        OptionId4 = optionId4;
    }

    public String getOptionId5() {
        return OptionId5;
    }

    public void setOptionId5(String optionId5) {
        OptionId5 = optionId5;
    }

    public String getOptionId6() {
        return OptionId6;
    }

    public void setOptionId6(String optionId6) {
        OptionId6 = optionId6;
    }

    public String getOptionId7() {
        return OptionId7;
    }

    public void setOptionId7(String optionId7) {
        OptionId7 = optionId7;
    }
}
