package ml.xiaoweiba.service;

import ml.xiaoweiba.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Integer i = 10;  //装箱
    int n = i;   //拆箱
}