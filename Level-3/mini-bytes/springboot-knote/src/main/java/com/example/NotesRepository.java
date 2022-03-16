package com.example;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotesRepository extends MongoRepository<Note,String> {
}
