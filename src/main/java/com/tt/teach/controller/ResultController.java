package com.tt.teach.controller;

import com.tt.teach.pojo.Result;
import com.tt.teach.service.ResultService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/res")
public class ResultController {
    @Resource
    private ResultService resultService;

    //页面的请求  (文件夹+ html)
    //请求：http://localhost:8080/stu/doLogin
    @RequestMapping("/result")
    public String result() {
        return "/result/result";
    }
    //
    @RequestMapping(value = "/getResultList",method = RequestMethod.GET)
    @ResponseBody
    public Object getResultList() {
        List<Result> list = resultService.getResultList();
        return list;
    }
}
