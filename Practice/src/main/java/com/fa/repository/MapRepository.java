package com.fa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fa.entity.MapEntity;

@Repository
public interface MapRepository extends JpaRepository<MapEntity, Long>{

}
