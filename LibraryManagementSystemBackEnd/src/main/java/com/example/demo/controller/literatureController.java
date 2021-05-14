package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Literature;
import com.example.demo.repository.LiteratureRepository;

@RestController
@RequestMapping("/api/v1/")
public class literatureController {

	@Autowired
	private LiteratureRepository literatureRepository;
	
	
	//getting all literatures
	@GetMapping("/literatures")
	public List<Literature> getAllLiteratures(){
		return literatureRepository.findAll();
	}
	
	//create literature rest api
	@PostMapping("/literatures")
	public Literature createLiterature(@RequestBody Literature literature) {
		System.out.println(literature);
		return literatureRepository.save(literature);
	}
	
	//get literature by id using rest api
	@GetMapping("/literatures/{id}")
	public ResponseEntity<Literature> getLiteratureByID(@PathVariable int id){
		Literature literature = literatureRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Literature not exists with id: "+id));
		return ResponseEntity.ok(literature);
	}
	
	//update literature by id using rest api
	@PutMapping("/literatures/{id}")
	public ResponseEntity<Literature> updateLiterature(@PathVariable int id , @RequestBody Literature literatureDetails){
		Literature literature = literatureRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Literature not exists with id: "+id));
		System.out.println("Here");
		literature.setAuthor(literatureDetails.getAuthor());
		literature.setCategory(literatureDetails.getCategory());
		literature.setIsbn(literatureDetails.getIsbn());
		literature.setIssuedDate(literatureDetails.getIssuedDate());
		literature.setTitle(literatureDetails.getTitle());
		literature.setTotalBooks(literatureDetails.getTotalBooks());
		literature.setLendedBooks(literatureDetails.getLendedBooks());

		Literature updatedLiterature = literatureRepository.save(literature);
		return ResponseEntity.ok(updatedLiterature);
	}
	
	//delete literature rest api
	@DeleteMapping("/literatures/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteLiterature(@PathVariable int id){
		Literature literature = literatureRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Literature not exists with id: "+ id));
		literatureRepository.delete(literature);
		Map<String , Boolean > response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	

	

}
