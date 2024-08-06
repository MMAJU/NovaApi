//package com.spearhead.nova.repository;
//
//import java.util.Optional;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import com.spearhead.nova.domain.Organisation;
//
//@Repository
//public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
//
//	@Query("FROM Organisation WHERE id = :id")
//	Optional<Organisation> findById(@Param("id") Long id);
//}