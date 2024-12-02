package com.leaning.myProject.Service;

import java.util.List;
import java.util.Optional;

import com.leaning.myProject.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.leaning.myProject.Entity.JournalEntity;
import com.leaning.myProject.Repo.JournalRepo;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JournalService {

	@Autowired
	private JournalRepo journalRepo;

	@Autowired
	UserService userService;

	public List<JournalEntity> getAll()
	{
//		List<JournalEntity> list=journalRepo.findAll();
//		List<JournalModel> modelList = new ArrayList<>();
//		for(JournalEntity i: list)
//		{
//			JournalModel journalModel = new JournalModel();
//			journalModel.setId(i.getId());
//			journalModel.setContent(i.getContent());
//			journalModel.setTitle(i.getTitle());
//			modelList.add(journalModel);
//		}
		return null;
	}

	@Transactional
	public void postJournal(JournalEntity journalEntity, String userName)
	{
		User user = userService.findByUserName(userName);
		JournalEntity saved = journalRepo.save(journalEntity);
		user.getJournalEntityList().add(saved);
		userService.saveEntry(user);
	}

	public void postJournal(JournalEntity journalEntity)
	{
		journalRepo.save(journalEntity);
	}
	
	public JournalEntity getByID(ObjectId id)
	{
		Optional<JournalEntity> o= journalRepo.findById(id);

		return o.get();
	}

	public void deleteByID(ObjectId id, String userName) {
		User byUserName = userService.findByUserName(userName);
		byUserName.getJournalEntityList().removeIf(x->x.getId().equals(id));
		userService.saveEntry(byUserName);
		journalRepo.deleteById(id);
	}
	
	
	 
	
}
