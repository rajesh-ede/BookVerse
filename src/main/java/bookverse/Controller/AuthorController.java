package bookverse.Controller;

import bookverse.BookService.Authorservice;
import bookverse.Model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final Authorservice authorservice;

    public AuthorController(Authorservice service){
        this.authorservice = service;
    }
    @PostMapping
    public Author addAuthor(@RequestBody Author author){
        System.out.println(author.getAuthorName());
        return authorservice.addAuthor(author);
    }
    @GetMapping
    public List<Author> getByAuthor(){
        return authorservice.getAllauthors();
    }
    @GetMapping("/{id}")
    public Author getAuthorByid(@PathVariable Long id){
        return authorservice.getAuthorById(id);
    }
}
