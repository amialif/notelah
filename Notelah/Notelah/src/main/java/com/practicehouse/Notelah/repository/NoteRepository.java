package com.practicehouse.Notelah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practicehouse.Notelah.model.*;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
