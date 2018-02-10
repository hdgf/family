package com.universe.family.model.cronous.game;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BottomRepository extends JpaRepository<CharacterBottom,Integer> {
    List<CharacterBottom> findAll();
    CharacterBottom findByCKey(int ckey);
}