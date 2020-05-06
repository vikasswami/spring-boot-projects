package com.ehcache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames="books")
public class BookRepository {
	
	private static Map<Integer, Book> bookMap;
	
	static{
		bookMap = new HashMap<Integer, Book>();
		bookMap.put(1000, new Book(1000,"Book 0","Author 0"));
		bookMap.put(1001, new Book(1001,"Book 1","Author 1"));
		bookMap.put(1002, new Book(1002,"Book 2","Author 2"));
		bookMap.put(1003, new Book(1003,"Book 3","Author 3"));
		bookMap.put(1004, new Book(1004,"Book 4","Author 4"));
		bookMap.put(1005, new Book(1005,"Book 5","Author 5"));
		bookMap.put(1006, new Book(1006,"Book 6","Author 6"));
		bookMap.put(1007, new Book(1007,"Book 7","Author 7"));
		bookMap.put(1008, new Book(1008,"Book 8","Author 8"));
		bookMap.put(1009, new Book(1009,"Book 9","Author 9"));
		bookMap.put(1010, new Book(1010,"Book 10","Author 10"));
	}
	
	@Cacheable
	public Book getBook(int _id){
		System.out.println("Getting book for id: "+_id+" from the repository..");
		return bookMap.get(_id);
	}

}
