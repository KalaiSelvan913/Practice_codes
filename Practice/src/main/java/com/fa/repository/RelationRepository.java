package com.fa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fa.entity.RelationEntity;

@Repository
public interface RelationRepository extends JpaRepository<RelationEntity, Long> {

}
