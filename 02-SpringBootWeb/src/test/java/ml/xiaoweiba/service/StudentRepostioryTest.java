package ml.xiaoweiba.service;

import ml.xiaoweiba.entity.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepostioryTest {
    @Resource
    private StudentRepostiory studentRepostiory;
    @Test
    public void findByStudentName() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        studentRepostiory.save(new Student("aa1",88,"123@qw.com",formattedDate));
        studentRepostiory.save(new Student("a3a1",15,"13223@qw.com",formattedDate));
        studentRepostiory.save(new Student("ad1",16,"123213@qw.com",formattedDate));
        studentRepostiory.save(new Student("eqw1",13,"3123@qw.com",formattedDate));

        Assert.assertEquals(20, studentRepostiory.findAll().size());
        Assert.assertEquals("ad1", studentRepostiory.findByStudentName("ad1").get(0).getStudentName());
        // studentRepostiory.delete(studentRepostiory.findByStudentName("aa1"));
    }
    @Test
    public void findByStudentNameOrAge() {
        Assert.assertEquals("aa13213", studentRepostiory.findByStudentName("aa13213").get(0).getStudentName());
    }
}