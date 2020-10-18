package com.meli.lv3.db.repository;


import com.meli.lv3.db.entity.DNA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DNARepository extends JpaRepository<DNA, Long> {

    @Query("select count(*) > 0 from dna_checked where dna = :dna")
    boolean existsByDna(@Param("dna") String dna);

    @Query("select count(distinct dna) from dna_checked where is_mutant = 0")
    int getHumanCount();

    @Query("select count(distinct dna) from dna_checked where is_mutant = 1")
    int getMutantCount();

}
