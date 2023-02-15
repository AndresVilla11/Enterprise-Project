package com.enterprise.joiner.repository;

import com.enterprise.joiner.model.entity.JoinerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoinerRepository extends JpaRepository<JoinerEntity, Long> {

}
