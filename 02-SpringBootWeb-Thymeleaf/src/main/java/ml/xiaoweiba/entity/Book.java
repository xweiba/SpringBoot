package ml.xiaoweiba.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @program: demo
 * @description: 测试类
 * @author: Mr.xweiba
 * @create: 2018-06-26 19:38
 **/

@Entity
@Table(name="book")
public class Book implements Serializable{
    private static final long serialVersionUID = 8268075906761987667L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(nullable = false,name = "name")
    private String name;

    @Column(nullable = false,name = "isbn")
    private String isbn;

    @Column(nullable = false,name = "author")
    private String author;

    public Book (String name,String isbn,String author){
        this.name = name;
        this.isbn = isbn;
        this.author = author;
    }
    public Book(){

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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}