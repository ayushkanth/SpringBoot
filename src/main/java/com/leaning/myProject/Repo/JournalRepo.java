package com.leaning.myProject.Repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.leaning.myProject.Entity.JournalEntity;


public interface JournalRepo extends MongoRepository<JournalEntity, ObjectId>{

}
