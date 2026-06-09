package bookverse.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Book name cannot be empty")
    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonBackReference
    private Author author;

    @Positive(message = "Price must be greater than zero")
    private double price;

    @NotBlank(message = "You must mention Category")
    private String category;

    public Book() {
    }

    public Book(Long id, String name, Author author, double price, String category) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}