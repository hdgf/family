package com.universe.family.model.cronous.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppVersRepository extends JpaRepository<AppVers,Integer> {

    @Override
    @Query("select w from AppVers w order by w.time desc")
    List<AppVers> findAll();

}