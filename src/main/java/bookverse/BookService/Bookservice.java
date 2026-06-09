package bookverse.BookService;

import bookverse.Dto.BookDTO;
import bookverse.Exception.BookNotFoundException;
import bookverse.Model.Book;
import bookverse.Repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
public class Bookservice {

private BookRepository repository;

public Bookservice(BookRepository repository){
    this.repository = repository;
}

// Get all Books in repository
    public List<Book> getAllbooks() {
        return repository.findAll();
    }
// Get the Book By Id
    public Book getbookbyId(Long id){
            return repository.findById(id)
                    .orElseThrow(()->
                            new BookNotFoundException(
        "Book not Found by this id "+id));
    }
    // Add Book to Books
    public Book addBook(Book book){
        repository.save(book);
        return book;
    }
    // Update Book By id
    public Book updateBook( Long id,Book updatebook){
    Book existingBook = repository.findById(id)
            .orElseThrow(()->
                    new BookNotFoundException("Book not found with ID" + id)
                    );
    existingBook.setName(updatebook.getName());
    existingBook.setAuthor(updatebook.getAuthor());
    existingBook.setPrice(updatebook.getPrice());
    existingBook.setCategory(updatebook.getCategory());

      return repository.save(existingBook);
    }
    //Delete the book by Id
    public String deleteBook(Long id){
    Book book = repository.findById(id)
            .orElseThrow(() ->
                    new BookNotFoundException("Book not found with ID" + id));
    repository.delete(book);
    return "Book Deleted Successfully";
    }
    // Pagenation
    public Page<Book> getBooksWithPagination(int page,int size){
        Pageable pageable = PageRequest.of(page,size);
    return repository.findAll(pageable);
    }
    //Sort by Prize
    public List<Book> getByPrize(){
    return repository.findAll(Sort.by("price"));
    }
    //DTO
    public BookDTO getBookDTO(Long id){
    Book book = repository.findById(id)
            .orElseThrow(() ->
                    new BookNotFoundException("Book Not found with ID" + id));

    return new BookDTO(
            book.getName(),
            book.getAuthor().toString(),
            book.getPrice()
    );
    }
    public List<Book> getBookByName(String name){
    return repository.findByName(name);
    }

    public List<Book> getBookByCategory(String category){
    return repository.findByCategory(category);
    }

    public List<Book> getBookByPrice(double price){
    return repository.findByPriceGreaterThan(price);
    }

    public List<Book> getBookByAuthor(String author){
    return repository.findByAuthorAuthorName(author);
    }
}
