package com.spring.idgeneration;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.idgeneration.Repository.BookRepository;

import com.spring.idgeneration.Service.SequenceGeneratorService;
import com.spring.idgeneration.entity.Book;

@EnableCaching
@RestController
@SpringBootApplication
public class IdGenerationApplication {

	@Autowired
	private BookRepository repository;
	

	@Autowired
	private SequenceGeneratorService service;
	
	@PostMapping("/saveBook" )
	
	public Book save(@RequestBody Book book) {
		
		book.setno(service.getSequenceNumber(Book.SEQUENCE_NAME));
		System.out.println(book.getno());
		return repository.save(book);
	}
	
	@GetMapping("/books/{no}")
	@Cacheable(value="books" ,key="#no")
	public List<Book> getBookByNo(@PathVariable Integer no){
		return repository.findByNo(no);
	}
	
	@GetMapping("/books")
	@Cacheable(value="books")
	public List<Book> getBooks(){
		return repository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(IdGenerationApplication.class, args);
	}

}
