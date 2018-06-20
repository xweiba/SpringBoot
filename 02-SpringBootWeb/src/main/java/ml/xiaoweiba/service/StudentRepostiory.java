package ml.xiaoweiba.service;

import ml.xiaoweiba.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepostiory extends JpaRepository<Student, Long>{
    Student findByStudentName(String studentName);
    Student findByStudentNameOrAge(String studentName, int age);
}
