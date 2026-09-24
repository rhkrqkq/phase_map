package com.study.handson;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.handson.phase1_jpa.Author;
import com.study.handson.phase1_jpa.AuthorRepository;
import com.study.handson.phase1_jpa.Book;

@SpringBootTest
class DataInitTest {
	@Autowired
	AuthorRepository authorRepository;

	@Test
	void 데이터_생성() {
		for (int i=0; i<5; i++) {
			Author author = new Author("작가" + i);
			for (int j=0; j<3; j++) {
				author.addBook(new Book("작가 " + i + "의 책" + j));
			}
			authorRepository.save(author);
		}
	}
}
