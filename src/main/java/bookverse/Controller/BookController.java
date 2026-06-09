package bookverse.Controller;

import bookverse.BookService.Bookservice;
import bookverse.Dto.BookDTO;
import bookverse.Model.Book;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class BookController {
    private Bookservice bookservice;

    public BookController(Bookservice bookservice){
        this.bookservice = bookservice;
    }
    @GetMapping("/home")
  public List<Book> getallbooks(){
  return bookservice.getAllbooks();
    }
    @GetMapping("/home/{id}")
    public Book getBybookId(@PathVariable Long id){
        return bookservice.getbookbyId(id);
    }
    @PostMapping ("/home/add")
    public Book addBook(@Valid @RequestBody Book book){
        return bookservice.addBook(book);
    }
    @PutMapping("/home/update/{id}")
    public Book updateBook(@PathVariable Long id,@RequestBody Book book){
        return bookservice.updateBook(id,book);
    }
    @DeleteMapping("/home/delete/{id}")
    public String deleteBook(@PathVariable long id){
        return bookservice.deleteBook((id));
    }
    @GetMapping("/home/pagination")
    public Page<Book> getBooksWithPagination(@RequestParam int page,@RequestParam int size){
        return bookservice.getBooksWithPagination(page, size);
    }
    @GetMapping("/home/sort")
    public List<Book> sortByprice(){
        return bookservice.getByPrize();
    }
    @GetMapping("/home/dto/{id}")
    public BookDTO getBookDto(@PathVariable Long id){
        return bookservice.getBookDTO(id);
    }
    @GetMapping("/home/search")
    public List<Book> searchBook(@RequestParam String name){
        return bookservice.getBookByName(name);
    }
@GetMapping("/category/{category}")
    public List<Book> getBookBycategory(@PathVariable String category){
        return bookservice.getBookByCategory(category);
    }
    @GetMapping("/price/{price}")
    public List<Book> getBookByPrice(@PathVariable double price){
        return bookservice.getBookByPrice(price);
    }
    @GetMapping("/author/{authorName}")
    public List<Book> getBookByAuthorName(@PathVariable String authorName){
        return bookservice.getBookByAuthor(authorName);
    }
}
