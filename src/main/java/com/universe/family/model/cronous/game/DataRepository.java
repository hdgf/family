package com.universe.family.model.cronous.game;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataRepository extends JpaRepository<DataBean,Integer> {
    List<DataBean> findAll();
    DataBean findByCkey(int ckey);
}