package entities;

public class Book {

    private int id;
    private String name;
    private String ISBN;
    private String category;


    public Book() {
    }

    public Book(int id, String name, String isbn, String category) {
        this.id = id;
        this.name = name;
        ISBN = isbn;
        this.category = category;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}
