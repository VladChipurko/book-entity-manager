package telran.java2022.book.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import telran.java2022.book.model.Book;
import telran.java2022.book.model.Publisher;

@Repository
public class BookRepositoryImpl implements BookRepository {
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Book> findBooksByAuthors_Name(String name) {
		TypedQuery<Book> query = 
				em.createQuery("select b from Book b join b.authors a where a.name=?1", Book.class);
				query.setParameter(1, name);
		return query.getResultList();
	}

	@Override
	public List<Book> findBooksByPublisher(Publisher publisher) {
		TypedQuery<Book> query = 
				em.createQuery("select b from Book b join b.publisher p where p=?1", Book.class);
				query.setParameter(1, publisher);
		return query.getResultList();
	}

	@Override
	public Optional<Book> findById(String isbn) {
		return Optional.ofNullable(em.find(Book.class, isbn));
	}

	@Override
	//@Transactional
	public Book save(Book book) {
		em.persist(book);
		//em.merge(book);
		return book;
	}

	@Override
	@Transactional
	public void deleteById(String isbn) {
		Book book = em.find(Book.class, isbn);
		em.remove(book);

	}

	@Override
	public boolean existsById(String isbn) {
		return em.find(Book.class, isbn) != null;
	}

}
