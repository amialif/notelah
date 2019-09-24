package com.practicehouse.Notelah.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practicehouse.Notelah.exception.ResourceNotFoundException;
import com.practicehouse.Notelah.model.Note;
import com.practicehouse.Notelah.repository.NoteRepository;

@RestController
@RequestMapping("/api")
public class NoteController {
	
	@Autowired
	NoteRepository noteRepo;
	
	
	// Get all the list
	@GetMapping("/notes")
	public List<Note> getAllNotes(){
		return noteRepo.findAll();
	}
	
	// create a note
	@PostMapping("notes/create")
	public Note createNote(@Valid @RequestBody Note note) {
		
		return noteRepo.save(note);
	}
	
	// Get a single Note
	
	@GetMapping("/notes/{id}")
	public Note getSingleNote(@PathVariable(value = "id") Long id) {
		return noteRepo.findById(id).orElseThrow( () -> new ResourceNotFoundException("Note","id",id));
	}
	
	@PutMapping("/notes/{id}")
	public Note updateNote(@PathVariable(value="id") Long id, @Valid @RequestBody Note noteDetails) {
		
	Note note =  noteRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Note","Id",id));
		
	note.setTitle(noteDetails.getTitle());
	note.setContent(noteDetails.getContent());
	
	Note updatedNote = noteRepo.save(note);
		
		return updatedNote;
	}
	
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<?> deleteNotes(@PathVariable(value="id") Long id){
		Note note = noteRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Note","id",id));
		
		noteRepo.delete(note);
		
		return ResponseEntity.ok().build();
		
	}

}
