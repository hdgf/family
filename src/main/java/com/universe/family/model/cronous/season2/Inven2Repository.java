package com.universe.family.model.cronous.season2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Inven2Repository extends JpaRepository<InventoryBean,Long> {
    List<InventoryBean> findByChkeyOrderByInventorypos(int characterkey);
}