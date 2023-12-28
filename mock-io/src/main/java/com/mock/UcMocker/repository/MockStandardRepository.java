package com.mock.UcMocker.repository;

import com.mock.UcMocker.model.MockStandard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MockStandardRepository extends JpaRepository<MockStandard, String> {

}
