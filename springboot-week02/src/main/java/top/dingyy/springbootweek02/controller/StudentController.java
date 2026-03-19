package top.dingyy.springbootweek02.controller;


import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.dingyy.springbootweek02.entity.Student;
import top.dingyy.springbootweek02.service.StudentService;

/**
 * @author dingy
 */
@RestController
@RequestMapping("/api/v1/students")
@Slf4j
public class StudentController {

    @Resource
    private StudentService studentService;

    /**
     * 创建学生
     * @param student
     * @return
     */
    @PostMapping()
    public String createStudent(@RequestBody Student student){
        log.info("接收到学生对象参数：{}" ,student);
        studentService.createStudent(student);
        return "创建学生成功：";
    }


    /**
     * 根据id查询学生
     */
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        log.info("接收学生id参数：{}",id);
        return studentService.getStudentById(id);
    }
    /**
     * 根据姓名查询学生
     */

    @GetMapping()
    public Student getStudentByName(@RequestParam String name){
        log.info("接收学生姓名参数：{}",name);
        return studentService.getStudentByName(name);
    }

    /**
     * 获取所有学生
     */
    @GetMapping("/all")
    public Iterable<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    /**
     * 更新学生
     */
    @PutMapping("/{id}")
    public String updateStudent(@PathVariable Long id,@RequestBody Student student){
        log.info("接收到学生id参数：{}",id);
        log.info("接收到学生对象参数：{}",student);
        studentService.updateStudentById(id,student);
        return "更新学生成功";
    }

    /**
     * 删除学生
     */
    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable Long id){
        log.info("接收到学生id参数：{}",id);
        studentService.deleteStudentById(id);
        return "删除学生成功";
    }





}
