package com.spring.idgeneration.Repository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.spring.idgeneration.entity.Book;

public interface BookRepository extends MongoRepository<Book, Integer> {
	@Query("{'no': ?0}")
	List<Book> findByNo(Integer no);
}
