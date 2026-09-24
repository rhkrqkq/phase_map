package com.study.handson.phase1_jpa;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	// FK (author_id)는 Book 테이블에만 존재하게 됨.
	// JPA에서 양방향 맺으면, Author에서도 List<Book> books 를 들고 있어야 autho.getBooks()가 가능해짐.
	// 여기서 mappedBy="author" 붙여서 이 매핑은 Book엔티이의 author 필드가 담당한다고 명시
	@OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST)
	private List<Book> books = new ArrayList<>();

	public void addBook(Book book) {
		this.books.add(book);
		// 여기서 this: addBook()를 호출한 Author 객체
		book.setAuthor(this);
	}

	public Author(String name) {
		this.name = name;
	}
}
