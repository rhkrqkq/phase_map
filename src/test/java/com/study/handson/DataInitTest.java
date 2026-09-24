package com.study.handson;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.study.handson.phase1_jpa.Author;
import com.study.handson.phase1_jpa.AuthorRepository;
import com.study.handson.phase1_jpa.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
class DataInitTest {
	@Autowired
	AuthorRepository authorRepository;

	@PersistenceContext
	EntityManager em;

	@Test
	@Transactional
	void 데이터_생성_조회() {
		for (int i=0; i<5; i++) {
			Author author = new Author("작가" + i);
			for (int j=0; j<3; j++) {
				author.addBook(new Book("작가 " + i + "의 책" + j));
			}
			authorRepository.save(author);
		}

		em.flush();
		em.clear();

		List<Author> authors = authorRepository.findAll();

		for (int i=0; i<authors.size(); i++) {
			Author author = authors.get(i);
			System.out.println(author.getName() + "의 책" + author.getBooks());
		}
	}
}
