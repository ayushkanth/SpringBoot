package com.leaning.myProject.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.leaning.myProject.Model.JournalModel;
import com.leaning.myProject.Service.JournalService;

@RestController
@RequestMapping("/api")
public class JournalController {
	
	@Autowired
	private JournalService journalService;
	
	@GetMapping
	public List<JournalModel> getJournal()
	{
		List<JournalModel> jm = journalService.getAll();
		return jm;
	}
	
	@PostMapping
	public JournalModel postJournal(@RequestBody JournalModel journalEntity)
	{
		JournalModel je= journalService.postJournal(journalEntity);
		return je;
	}
	
	@GetMapping("/{id}")
	public JournalModel getByID(@PathVariable ObjectId id)
	{
		return journalService.getByID(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteJournal(@PathVariable ObjectId id)
	{
		journalService.deleteByID(id);
	}
	
	@PutMapping("/{id}")
	public JournalModel updateJournal(@PathVariable ObjectId id, @RequestBody JournalModel journalModel) {
		JournalModel jm = journalService.getByID(id);
		if(jm!=null)
		{
			jm.setTitle((journalModel.getTitle()!=null && !journalModel.equals(""))?journalModel.getTitle():jm.getTitle());
			jm.setContent((journalModel.getContent()!=null && !journalModel.equals(""))?journalModel.getContent():jm.getContent());
		}
		journalService.postJournal(jm);
		return jm;
	}
	
	
	
}
