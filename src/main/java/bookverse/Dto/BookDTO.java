package bookverse.Dto;

public class BookDTO {
    private String name;
    private String author;
    private double price;

    public BookDTO(){

    }
    public BookDTO(String name,String author,double price){
        this.name = name;
        this.author = author;
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
