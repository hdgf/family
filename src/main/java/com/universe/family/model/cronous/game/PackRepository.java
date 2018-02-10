package com.universe.family.model.cronous.game;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackRepository extends JpaRepository<CharacterPack,Integer> {
    List<CharacterPack> findAll();
    List<CharacterPack> findByPersonid(int pid);
}