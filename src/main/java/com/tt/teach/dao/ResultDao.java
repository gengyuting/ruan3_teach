package com.tt.teach.dao;

import com.tt.teach.pojo.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ResultDao {
    @Select("SELECT result.*,student.studentName AS studentName,subject.subjectName AS subjectName FROM result,student,subject WHERE result.subjectNo = subject.subjectNo AND student.studentNo = result.studentNo order by result.examDate desc")
    List<Result> getResultList();
}
