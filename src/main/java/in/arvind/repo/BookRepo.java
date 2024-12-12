package in.arvind.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.arvind.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{
  public List<Book> findByActiveSw(String status);
}
