package com.sahu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahu.model.Actor;

@RestController
@RequestMapping("/actor")
public class ActorOperationsController {
	
	/*@GetMapping("/wish")
	public ResponseEntity<String> displayWishMessage() {
		return new ResponseEntity<String>("Good morning", HttpStatus.OK);
	}*/
	
	@GetMapping("/wish/{id}/{name}")
	public ResponseEntity<String> displayWishMessage(@PathVariable Integer id, @PathVariable String name) {
		return new ResponseEntity<String>("Good morning "+id+" "+name, HttpStatus.OK);
	}
	
	@GetMapping("/register")
	public ResponseEntity<String> regiserActor(@RequestBody Actor actor) {
		return new ResponseEntity<String>("Actor data "+actor.toString(), HttpStatus.OK);
	}
	
}
