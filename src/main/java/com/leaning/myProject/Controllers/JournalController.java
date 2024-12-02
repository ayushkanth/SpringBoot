package com.leaning.myProject.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.leaning.myProject.Entity.User;
import com.leaning.myProject.Service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leaning.myProject.Entity.JournalEntity;
import com.leaning.myProject.Service.JournalService;

@RestController
@RequestMapping("/api")
public class JournalController {
	
	@Autowired
	private JournalService journalService;

	@Autowired
	private UserService userService;

	@GetMapping("{userName}")
	public ResponseEntity<List<JournalEntity>> getAllJournalsOfUser(@PathVariable String userName)
	{
		User user=userService.findByUserName(userName);
		List<JournalEntity> jm = user.getJournalEntityList();
		if(jm!=null && !jm.isEmpty())
		{
			return new ResponseEntity<>(jm,HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("{userName}")
	public ResponseEntity<JournalEntity> postJournal(@RequestBody JournalEntity journalEntity, @PathVariable String userName)
	{
		try {
			journalService.postJournal(journalEntity,userName);
			return new ResponseEntity<JournalEntity>(journalEntity,HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<JournalEntity>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<JournalEntity> getByID(@PathVariable ObjectId id)
	{
		JournalEntity jm = journalService.getByID(id);
		 if(jm!=null)
		 {
			 return new ResponseEntity<JournalEntity>(jm,HttpStatus.OK);
		 }
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{userName}/{id}")
	public ResponseEntity<?> deleteJournal(@PathVariable ObjectId id, @PathVariable String userName)
	{
		journalService.deleteByID(id,userName);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	@PutMapping("/{userName}/{id}")
	public ResponseEntity<JournalEntity> updateJournal(@PathVariable ObjectId id,
													   @RequestBody JournalEntity journalModel,
														@PathVariable String userName
	) {
		JournalEntity jm = journalService.getByID(id);
		if(jm!=null)
		{
			jm.setTitle((journalModel.getTitle()!=null && !journalModel.equals(""))?journalModel.getTitle():jm.getTitle());
			jm.setContent((journalModel.getContent()!=null && !journalModel.equals(""))?journalModel.getContent():jm.getContent());
			journalService.postJournal(jm);
			return new ResponseEntity<JournalEntity>(jm,HttpStatus.OK);
		}
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
}
