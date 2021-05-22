package entities;

import java.util.ArrayList;

public class Book {

    private int id;
    private String name;
    private int isbn;
    private String category;
    private ArrayList<Member> members;

    public Book() {
    }

    public Book(int id, String name, int isbn, String category) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.category = category;
        this.members = new ArrayList();
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

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isbn=" + isbn +
                ", category='" + category + '\'' +
                '}';
    }
}
