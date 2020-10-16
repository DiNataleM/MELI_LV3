package com.meli.lv3.db.repository;


import com.meli.lv3.db.entity.DNA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DNARepository extends JpaRepository<DNA, Long> {

    @Query("select count(d) > 0 from dna_checked d where d.dna = :dna")
    boolean existsByDna(@Param("dna") String dna);
}
