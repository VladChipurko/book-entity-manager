package telran.java2022.book.dao;

import java.util.List;
import java.util.Optional;

import telran.java2022.book.model.Book;
import telran.java2022.book.model.Publisher;

public interface BookRepository{

	List<Book> findBooksByAuthors_Name(String name);
	
	List<Book> findBooksByPublisher(Publisher publisher);

	Optional<Book> findById(String isbn);

	Book save(Book book);

	void deleteById(String isbn);

	boolean existsById(String isbn);
}
