package bookverse.Repository;

import bookverse.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByName(String name);
    List<Book> findByAuthorAuthorName(String authorName);
    List<Book> findByPriceGreaterThan(double price);
    List<Book> findByCategory(String category);
}
