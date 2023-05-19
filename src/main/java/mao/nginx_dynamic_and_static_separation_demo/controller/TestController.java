package mao.nginx_dynamic_and_static_separation_demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Project name(项目名称)：nginx_dynamic_and_static_separation_demo
 * Package(包名): mao.nginx_dynamic_and_static_separation_demo.controller
 * Class(类名): TestController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/5/19
 * Time(创建时间)： 13:22
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@RestController
@RequestMapping("/student")
public class TestController
{
    private static final Logger log = LoggerFactory.getLogger(TestController.class);


    public static int getIntRandom(int min, int max)
    {
        if (min > max)
        {
            min = max;
        }
        return min + (int) (Math.random() * (max - min + 1));
    }


    /**
     * 通过id得到学生信息
     *
     * @param id id
     * @return {@link Student}
     */
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id)
    {
        Student student = new Student();
        student.id = id;
        student.name = "张三";
        student.sex = "男";
        student.age = getIntRandom(15, 25);
        log.info(student.toString());
        return student;
    }


    /**
     * 得到所有学生信息
     *
     * @return {@link List}<{@link Student}>
     */
    @GetMapping("/all")
    public List<Student> getAll()
    {
        List<Student> studentList = new ArrayList<>(3);
        Student student = new Student();
        student.id = 10001L;
        student.name = "张三";
        student.sex = "男";
        student.age = getIntRandom(15, 25);
        studentList.add(student);
        student = new Student();
        student.id = 10002L;
        student.name = "李四";
        student.sex = "女";
        student.age = getIntRandom(15, 25);
        studentList.add(student);
        student = new Student();
        student.id = 10003L;
        student.name = "王五";
        student.sex = "男";
        student.age = getIntRandom(15, 25);
        studentList.add(student);
        log.info(studentList.toString());
        return studentList;
    }

    /**
     * 学生实体类
     *
     * @author mao
     * @date 2023/05/19
     */
    public static class Student
    {
        public Long id;
        public String name;
        public String sex;
        public Integer age;

        public Long getId()
        {
            return id;
        }

        public String getName()
        {
            return name;
        }

        public String getSex()
        {
            return sex;
        }

        public Integer getAge()
        {
            return age;
        }

        @Override
        public String toString()
        {
            return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                    .add("id=" + id)
                    .add("name='" + name + "'")
                    .add("sex='" + sex + "'")
                    .add("age=" + age)
                    .toString();
        }
    }
}
