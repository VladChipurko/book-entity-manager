package telran.java2022.book.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import telran.java2022.book.model.Author;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Optional<Author> findById(String authorName) {
		return Optional.ofNullable(em.find(Author.class, authorName));
	}

	@Override
	public Author save(Author author) {
		em.persist(author);
		//em.merge(author);
		return author;
	}

	@Override
	public Author deleteById(String authorName) {
		Author author = em.find(Author.class, authorName);
		em.remove(author);
		return author;
	}

}
