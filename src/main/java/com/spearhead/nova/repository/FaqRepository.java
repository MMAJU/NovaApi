package com.spearhead.nova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spearhead.nova.model.Faq;


@Repository
public interface FaqRepository extends JpaRepository<Faq, Long> {

}
