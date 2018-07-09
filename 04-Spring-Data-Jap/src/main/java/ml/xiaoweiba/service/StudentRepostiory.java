package ml.xiaoweiba.service;

import ml.xiaoweiba.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: demo
 * @description: Spring-Data-Jpa 测试
 * @author: Mr.xweiba
 * @create: 2018-06-26 11:44
 **/

public interface StudentRepostiory extends JpaRepository<Student, Long>{
    List<Student> findByStudentName(String studentName);
    Student findByStudentNameOrAge(String studentName, int age);
    Long deleteById(Long id);
    Long countByStudentName(String studentName);
    List<Student> findByStudentNameLike(String likeString);

    Page<Student> findAll(Pageable pageable);

    Page<Student> findByStudentName(String studentName, Pageable pageable);
}
