package com.universe.family.model.cronous.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserPointRepository extends JpaRepository<UserPoint,Integer> {

    List<UserPoint> findAll();

    UserPoint findUserPointByUserName(String username);

    @Transactional
    @Modifying
    @Query("UPDATE UserPoint u SET u.point = u.point + ?2 WHERE u.userName=?1")
    void updatePoint(String userName, int point);
}
