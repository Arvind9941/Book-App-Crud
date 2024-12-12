package in.arvind.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.arvind.entity.Book;
import in.arvind.repo.BookRepo;

@Service
public class BookService {
	
	@Autowired
	private BookRepo repo;
	
	public Book getBookById(Integer id) {
		Optional<Book> byId = repo.findById(id);
		if(byId.isPresent()) {
			return byId.get();
		}
		return null;
	}
	public List<Book> getBookData() {
		List<Book> all = repo.findByActiveSw("Y");
		return all;
	}
	
	public boolean saveBook(Book b) {
		b.setActiveSw("Y");
		Book save = repo.save(b);
		return save.getBookId()!=null;
	}
	public void deletBook(Integer bookId) {
		// hard delete
		//repo.deleteById(bookId);
		//soft delete
		Optional<Book> book = repo.findById(bookId);
		if(book.isPresent()) {
			Book b = book.get();
			b.setActiveSw("N");
			repo.save(b);
		}
	}

}
