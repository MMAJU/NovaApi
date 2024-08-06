package com.spearhead.nova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spearhead.nova.model.NextOfKin;
@Repository
public interface NextOfKinRepository extends JpaRepository <NextOfKin, Long>{

}
