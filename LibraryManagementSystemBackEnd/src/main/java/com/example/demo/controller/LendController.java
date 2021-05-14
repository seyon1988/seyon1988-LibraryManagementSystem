package com.example.demo.controller;

import java.util.ArrayList;
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
import com.example.demo.model.Lend;
import com.example.demo.repository.LendRepository;

@RestController
@RequestMapping("/api/v1/")
public class LendController {

	@Autowired
	private LendRepository lendRepository;
	
	//getting all lends
	@GetMapping("/lends")
	public List<Lend> getAllLends(){
		return lendRepository.findAll();
	}
	
	
	//create lend rest api
	@PostMapping("/lends")
	public Lend createLend(@RequestBody Lend lend) {
		return lendRepository.save(lend);
	}
	
	
	
	//get lend by id using rest api
	@GetMapping("/lends/{id}")
	public ResponseEntity<Lend> getLendByID(@PathVariable int id){
		Lend lend = lendRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Lend not exists with id: "+id));
		return ResponseEntity.ok(lend);
	}
	
	
	//update lend by id using rest api
	@PutMapping("/lends/{id}")
	public ResponseEntity<Lend> updateLend(@PathVariable int id , @RequestBody Lend lendDetails){
		Lend lend = lendRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Lend not exists with id: "+id));

		lend.setUserID(lendDetails.getUserID());
		lend.setMaterialID(lendDetails.getMaterialID());
		Lend updatedLend = lendRepository.save(lend);
		return ResponseEntity.ok(updatedLend);
	}
	
	//delete lend rest api
	@DeleteMapping("/lends/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteLend(@PathVariable int id){
		Lend lend = lendRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Lend not exists with id: "+id));
		lendRepository.delete(lend);
		Map<String , Boolean > response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	//get lend by userid using rest api
	@GetMapping("/lends/byuserid/{userID}")
	public List<Lend> getLendByUserID(@PathVariable int userID){
		List <Lend> usrLends = new ArrayList<Lend>();
		List <Lend> allLends = lendRepository.findAll();
		for(Lend lend : allLends) {
			if(lend.getUserID()==userID) {
				usrLends.add(lend);
			}
		}
		return usrLends;
	}
	
  	//get lend by email and password using rest api
	@GetMapping("/lends/{userID}/{materialID}")
	public  Lend getLendByUsrIdMatId(@PathVariable int userID,@PathVariable int materialID){
		List <Lend> lends = lendRepository.findAll();
		for(Lend lend : lends) {
			if(lend.getUserID()==userID && lend.getMaterialID()==materialID) {
				return lend;
			}
		}
		return null;
	}
	
	
	
}
