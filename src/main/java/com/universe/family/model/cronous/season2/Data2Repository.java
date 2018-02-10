package com.universe.family.model.cronous.season2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Data2Repository extends JpaRepository<DataBean,Integer> {
    List<DataBean> findAll();
    DataBean findByCkey(int ckey);
}