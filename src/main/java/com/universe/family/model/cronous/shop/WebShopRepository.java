package com.universe.family.model.cronous.shop;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface WebShopRepository extends JpaRepository<WebShop,Integer> {
    List<WebShop> findAll();

    WebShop findByBitemid(String bitemid);

    @Query("select w from WebShop w where w.type = ?1 and w.yn>0 and w.istop>0")
    Page<WebShop> findAllByType(String type, Pageable page);

    @Query("select w from WebShop w where w.type = ?1 and w.time<=?2 order by w.name desc")
    List<WebShop> findByTypeAndTime(String id, Date time);

    @Query("select w from WebShop w where w.name like ?1 and w.type in ('wuqizhuangbei','baoshi')")
    Page<WebShop> findByName(String name, Pageable page);
}