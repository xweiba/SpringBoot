package ml.xiaoweiba.service;

import ml.xiaoweiba.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepostiory extends JpaRepository<Student, Long>{
    List<Student> findByStudentName(String studentName);
    Student findByStudentNameOrAge(String studentName, int age);
}
