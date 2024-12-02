package com.leaning.myProject.Service;

import com.leaning.myProject.Entity.JournalEntity;
import com.leaning.myProject.Entity.User;
import com.leaning.myProject.Repo.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public List<User> getAll()
	{
		return userRepo.findAll();
	}
	
	public void saveEntry(User user)
	{
		userRepo.save(user);
	}
	
	public Optional<User> getByID(ObjectId id)
	{
		return userRepo.findById(id);
	}

	public void deleteByID(ObjectId id) {
		userRepo.deleteById(id);
	}

	public User findByUserName(String userName)
	{
		return userRepo.findByUserName(userName);
	}
}
