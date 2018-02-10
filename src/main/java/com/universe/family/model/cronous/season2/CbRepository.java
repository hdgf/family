package com.universe.family.model.cronous.season2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CbRepository extends JpaRepository<CharacterBottom,Integer> {
    List<CharacterBottom> findAll();
    CharacterBottom findByCKey(int ckey);
}