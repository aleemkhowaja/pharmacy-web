package com.pharm.repository.dci;

import com.pharm.model.DCI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DCIRepository extends JpaRepository<DCI,Integer> {
}
