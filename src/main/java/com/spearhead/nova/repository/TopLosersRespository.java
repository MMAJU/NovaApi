package com.spearhead.nova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spearhead.nova.model.TopLosers;

@Repository
public interface TopLosersRespository  extends JpaRepository <TopLosers, Long>  {

}
