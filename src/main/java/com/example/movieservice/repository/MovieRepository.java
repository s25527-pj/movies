package com.example.movieservice.repository;

import com.example.movieservice.model.Movie;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Override
    Optional<Movie> findById(Long aLong);

    @Override
    List<Movie> findAll();

    @Override
    void delete(Movie entity);

    @Override
    <S extends Movie> S save(S entity);

    @Modifying
    @Transactional
    @Query("UPDATE Movie m SET m.isAvailable = true WHERE m.id = :id")
    void setStatusToUnavailable(@Param("id") Long id);
}