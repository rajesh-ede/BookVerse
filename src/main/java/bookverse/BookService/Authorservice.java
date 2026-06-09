package bookverse.BookService;

import bookverse.Exception.AuthorNotFoundException;
import bookverse.Model.Author;
import java.util.List;
import bookverse.Repository.AuthorRepository;
import bookverse.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Authorservice {
    private AuthorRepository authorRepository;


    public Author addAuthor(Author author){
        return authorRepository.save(author);
    }
    public List<Author> getAllauthors(){
        return authorRepository.findAll();
    }
    public Author getAuthorById(Long id){
        return authorRepository.findById(id)
                .orElseThrow(()->
                        new AuthorNotFoundException("Author not found by id" + id));
    }

}
