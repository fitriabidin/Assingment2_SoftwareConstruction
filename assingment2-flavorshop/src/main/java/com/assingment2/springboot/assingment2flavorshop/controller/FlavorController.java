package com.assingment2.springboot.assingment2flavorshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assingment2.springboot.assingment2flavorshop.exception.ResourceNotFoundException;
import com.assingment2.springboot.assingment2flavorshop.model.Flavor;
import com.assingment2.springboot.assingment2flavorshop.repository.FlavorRepository;


@RestController
@RequestMapping("/api/v1")
public class FlavorController {
	
	@Autowired
	private FlavorRepository flavorRepository;
	
	// create get all flavors api
	@GetMapping("/flavors")
	public List<Flavor> getAllFlavor(){
		return flavorRepository.findAll();
	}
	
	// create flavor
	@PostMapping("/flavors")
	public Flavor createFlavor(@Validated @RequestBody Flavor flavor) {
		return flavorRepository.save(flavor);
	}
	
	// get flavor by id
	@GetMapping("/flavors/{id}")
	public ResponseEntity<Flavor> getFlavorById(@PathVariable(value = "id") long flavorId) 
			throws ResourceNotFoundException{
		Flavor flavor = flavorRepository.findById(flavorId)
				.orElseThrow(() -> new ResourceNotFoundException("Flavor not found for this id :: " + flavorId));
		return ResponseEntity.ok().body(flavor);
	}
	
	// update flavor
	@PutMapping("/flavors/{id}")
	public ResponseEntity<Flavor> updateFlavor(@PathVariable(value = "id") long flavorId 
			, @RequestBody Flavor flavorDetails) throws ResourceNotFoundException {
		Flavor flavor = flavorRepository.findById(flavorId)
				.orElseThrow(() -> new ResourceNotFoundException("Flavor not found for this id :: " + flavorId));
		flavor.setFlavortype(flavorDetails.getFlavortype());
		flavor.setFlavorname(flavorDetails.getFlavorname());
		flavor.setFlavorniclevel(flavorDetails.getFlavorniclevel());
		flavorRepository.save(flavor);
		return ResponseEntity.ok().body(flavor);
	}
	
	// delete flavor
	
	@DeleteMapping("/flavors/{id}")
	public ResponseEntity<?> deleteFlavor(@PathVariable(value = "id") long flavorId) throws ResourceNotFoundException {
		flavorRepository.findById(flavorId)
				.orElseThrow(() -> new ResourceNotFoundException("Flavor not found for this id :: " + flavorId));
		
		flavorRepository.deleteById(flavorId);
		return ResponseEntity.ok().build();
		
		
	}


}
