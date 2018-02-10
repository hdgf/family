package com.universe.family.model.cronous.shop;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GameConut {
    @Id
    private long ItemConut;

    public GameConut() {}

    public GameConut(long itemConut) {
        ItemConut = itemConut;
    }

    public long getItemConut() {
        return ItemConut;
    }

    public void setItemConut(long itemConut) {
        ItemConut = itemConut;
    }
}
