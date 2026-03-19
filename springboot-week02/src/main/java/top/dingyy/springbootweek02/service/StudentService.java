package top.dingyy.springbootweek02.service;

import org.springframework.stereotype.Service;
import top.dingyy.springbootweek02.entity.Phone;
import top.dingyy.springbootweek02.entity.Student;

import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Service

public class StudentService {
    public static final Map<Long, Student> STUDENT_DATA = new ConcurrentHashMap<>();

    static {
        Student student1 = Student.builder().id(1001L).name("张三").gender("男").birthday(LocalDate.of(1999,1,
                1)).phone(Phone.builder().band("iphone").price(9999.99).color("black").build()).build();
        Student student2 = Student.builder().id(1002L).name("张三丰").gender("男").birthday(LocalDate.of(1998,1,
                1)).phone(Phone.builder().band("huawei").price(5999.99).color("black").build()).build();
        STUDENT_DATA.put(student1.getId(), student1);
        STUDENT_DATA.put(student2.getId(), student2);
    }

    /**
     * 创建学生
     */
    public void createStudent(Student student) {
        STUDENT_DATA.put(student.getId(), student);
    }

    /**
     * 根据id查询学生
     */
    public Student getStudentById(Long id) {
        return STUDENT_DATA.get(id);
    }
    /**
     * 根据姓名查询学生
     */
    public Student getStudentByName(String name) {
        return STUDENT_DATA.values().stream().filter(stu -> stu.getName().equals(name)).findFirst().orElse(null);
    }

    /**
     * 获取所以学生
     */
    public Iterable<Student> getAllStudents() {
        return STUDENT_DATA.values();
    }
    /**
     * 根据id更新学生信息
     */
    public void updateStudentById(Long id,Student student) {
        STUDENT_DATA.put(id, student);
    }
    /**
     * 根据id删除学生
     */
    public void deleteStudentById(Long id) {
        STUDENT_DATA.remove(id);
    }
}
