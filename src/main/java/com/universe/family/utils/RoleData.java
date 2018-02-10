package com.universe.family.utils;

import com.universe.family.model.cronous.game.CharacterBottom;
import com.universe.family.model.cronous.game.CharacterPack;
import com.universe.family.model.cronous.game.DataBean;
import com.universe.family.model.cronous.game.InventoryBean;

import java.io.Serializable;
import java.util.List;

public class RoleData implements Serializable {
    private CharacterPack characterPack;
    private CharacterBottom characterBottom;
    private DataBean dataBean;
    private List<InventoryBean> inventoryBeans;

    public RoleData(CharacterPack characterPack) {
        this.characterPack = characterPack;
    }

    public CharacterPack getCharacterPack() {
        return characterPack;
    }

    public void setCharacterPack(CharacterPack characterPack) {
        this.characterPack = characterPack;
    }

    public CharacterBottom getCharacterBottom() {
        return characterBottom;
    }

    public void setCharacterBottom(CharacterBottom characterBottom) {
        this.characterBottom = characterBottom;
    }

    public DataBean getDataBean() {
        return dataBean;
    }

    public void setDataBean(DataBean dataBean) {
        this.dataBean = dataBean;
    }

    public List<InventoryBean> getInventoryBeans() {
        return inventoryBeans;
    }

    public void setInventoryBeans(List<InventoryBean> inventoryBeans) {
        this.inventoryBeans = inventoryBeans;
    }
}
