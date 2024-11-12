package com.leaning.myProject.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.leaning.myProject.Entity.JournalEntity;
import com.leaning.myProject.Model.JournalModel;
import com.leaning.myProject.Repo.JournalRepo;

@Service
public class JournalService {

	@Autowired
	private JournalRepo journalRepo;
	
	public List<JournalModel> getAll()
	{
		List<JournalEntity> list=journalRepo.findAll();
		List<JournalModel> modelList = new ArrayList<>();
		for(JournalEntity i: list)
		{
			JournalModel journalModel = new JournalModel();
			journalModel.setId(i.getId());
			journalModel.setContent(i.getContent());
			journalModel.setTitle(i.getTitle());
			modelList.add(journalModel);
		}
		return modelList;
	}
	
	public JournalModel postJournal(JournalModel journalModel)
	{
		JournalEntity journalEntity = new JournalEntity();
		  journalEntity.setTitle(journalModel.getTitle());
		  journalEntity.setContent(journalModel.getContent());

		journalRepo.save(journalEntity);
		return journalModel;
	
//		journalRepo.save(journalEntity);
	}
	
	public JournalModel getByID(ObjectId id)
	{
		Optional<JournalEntity> o= journalRepo.findById(id);
		if(o.isPresent()) {
			JournalEntity je = o.get();
			JournalModel jm = new JournalModel();
			  jm.setId(je.getId());
			  jm.setTitle(je.getTitle());
			  jm.setContent(je.getContent());
			return jm;
		}
		return null;
	}

	public void deleteByID(ObjectId id) {
		journalRepo.deleteById(id);
	}
	
	
	 
	
}
