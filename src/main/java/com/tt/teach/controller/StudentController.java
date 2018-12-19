package com.tt.teach.controller;

import com.tt.teach.pojo.Student;
import com.tt.teach.service.StudentService;
import com.tt.teach.utils.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/stu")
public class StudentController extends BaseController {
    @Resource
    private StudentService studentService;

    //登录的请求
    @RequestMapping("/login")
    //请求：http://localhost:8080/stu/login
    public String login() {
        return "/student/login";
    }
    //判断
    @RequestMapping("/index")
    //请求：http://localhost:8080/stu/index
    public String index() {
        String studentName = (String) getSession().getAttribute(SESSION_KEY);
        if (studentName!=null){
            return "/student/index";
        }
        return REDIRECT+"/stu/login";
    }
    //学生查询的请求
    @RequestMapping("/student")
    //请求：http://localhost:8080/stu/student
    public String student() {
        return "/student/student";
    }

    //注销的请求
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute(SESSION_KEY);
        return REDIRECT+"/stu/login";
    }


    //登录方法
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    //请求：http://localhost:8080/stu/doLogin
    public String doLogin() {
        String xuehao = getRequest().getParameter("studentNo");
        Integer studentNo = Integer.parseInt(xuehao);
        String loginPwd = getRequest().getParameter("loginPwd");
        Student student = new Student();
        student.setLoginPwd(loginPwd);
        student.setStudentNo(studentNo);
        Student student1 = studentService.doLogin(student);
        if (student!=null){
            getSession().setAttribute("studentName",student1.getStudentName());
            return FORWARD+"/stu/index";
        }
         return REDIRECT+"/stu/login";
    }

    //查询所有学生信息的方法
    //请求：http://localhost:8080/stu/getStudentList
    @RequestMapping(value = "/getStudentList",method = RequestMethod.GET)
    @ResponseBody
    public Object getStudentList() {
        List<Student> list = studentService.getStudentList();
        return list;
    }

    //删除学生的方法
    @RequestMapping(value = "/deleteStudent",method = RequestMethod.GET)
    public String deleteStudent() {
        return "明见";
    }
}
