package com.leaning.myProject.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leaning.myProject.Model.JournalModel;

@RestController
@RequestMapping("/api")
public class JournalController {
	
	private Map<Long,JournalModel> map = new HashMap<>();
	
	@GetMapping()
	public List<JournalModel> getJournal()
	{
		return new ArrayList<>(map.values());
	}
	
	@PostMapping
	public JournalModel postJournal(@RequestBody JournalModel journalEntity)
	{
		map.put(journalEntity.getId(), journalEntity);
		return journalEntity;
	}
	
	@DeleteMapping("/{id}")
	public void deleteJournal(@PathVariable long myid)
	{
		map.remove(myid);
	}
	
	@PutMapping
	public void updateJournal(@RequestBody JournalModel journalModel) {
		map.put(journalModel.getId(), journalModel);
	}
	
	
	
}
