package com.universe.family.model.cronous.shop;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface WebNewsRepository extends JpaRepository<WebNews,Integer> {
    List<WebNews> findAll();

    @Query("select w from WebNews w where w.title like ?1")
    Page<WebNews> findAllByTitle(String title,Pageable page);

    @Query("select w from WebNews w where w.info like ?1")
    Page<WebNews> findAllByInfo(String info, Pageable page);

    Page<WebNews> findAllByType(String type, Pageable page);

    @Transactional
    @Modifying
    @Query("UPDATE WebNews w SET w.info = ?1, w.title=?2 WHERE w.id=?3")
    void updateNews(String userName, String title, int id);
}