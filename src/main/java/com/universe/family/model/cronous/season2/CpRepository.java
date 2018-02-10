package com.universe.family.model.cronous.season2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CpRepository extends JpaRepository<CharacterPack,Integer> {
    List<CharacterPack> findAll();
    List<CharacterPack> findByPersonid(int pid);
}