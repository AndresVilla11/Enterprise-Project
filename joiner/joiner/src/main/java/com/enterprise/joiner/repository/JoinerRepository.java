package com.enterprise.joiner.repository;

import com.enterprise.joiner.model.entity.JoinerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface JoinerRepository extends JpaRepository<JoinerEntity, Long> {

    JoinerEntity findByIdentificationNumber(Long identificationNumber);
}