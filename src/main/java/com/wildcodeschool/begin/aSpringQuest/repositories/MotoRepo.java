package com.wildcodeschool.begin.aSpringQuest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wildcodeschool.begin.aSpringQuest.entities.Moto;

@Repository
public interface MotoRepo extends JpaRepository<Moto, Long> {
}
