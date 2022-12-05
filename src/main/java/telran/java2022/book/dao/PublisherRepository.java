package telran.java2022.book.dao;

import java.util.List;
import java.util.Optional;
import telran.java2022.book.model.Publisher;

public interface PublisherRepository{

	List<String> findPublishersByAuthor(String name);

	Optional<Publisher> findById(String publisher);

	Publisher save(Publisher publisher);
}
