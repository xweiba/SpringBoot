package ml.xiaoweiba.service;

import ml.xiaoweiba.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SudentRepostioryTest {
    @Autowired
    StudentRepostiory studentRepostiory;

    @Test
    public void testBaseQuery(){
        Student student = new Student();

        // 查询id 为 1 的值是否存在
        System.out.println(studentRepostiory.exists(1L));

        // 获取所有数据
        List<Student> studentList = studentRepostiory.findAll();
        for (Student s :
                studentList) {
            System.out.println(s.toString());
        }

        // 获取id=2的数据
        System.out.println(studentRepostiory.findOne(2L).toString());

        // 保存对象
        System.out.println(studentRepostiory.save(student));

        // 删除 无返回值
        studentRepostiory.delete(student);

        // 统计个数
        long l = studentRepostiory.count();
        System.out.println(l);

    }

    @Test
    public void Page(){
        // 分页测试
        int page = 1, size=2;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);


        List<Student> student = (List<Student>)studentRepostiory.findAll(pageable);
        for (Student s :
                student) {
            System.out.println(student.toString());
        }

        System.out.println(studentRepostiory.findByStudentName("aa1", pageable));

    }
}