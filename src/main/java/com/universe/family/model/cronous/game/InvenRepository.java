package com.universe.family.model.cronous.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvenRepository extends JpaRepository<InventoryBean,Long> {
    List<InventoryBean> findByChkeyOrderByInventorypos(int characterkey);

    @Query("select w from InventoryBean w where w.chkey=?1 and (w.inventorypos>=53 and w.inventorypos<=57)")
    List<InventoryBean> findByChkey(int characterkey);
}