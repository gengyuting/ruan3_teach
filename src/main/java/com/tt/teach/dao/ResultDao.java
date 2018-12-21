package com.tt.teach.dao;

import com.tt.teach.pojo.Result;
import com.tt.teach.pojo.Subject;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ResultDao {
    @Select("SELECT result.*,student.studentName AS studentName,subject.subjectName AS subjectName FROM result,student,subject WHERE result.subjectNo = subject.subjectNo AND student.studentNo = result.studentNo order by result.examDate desc")
    List<Result> getResultList();

    @Delete("delete from result where resultNo = #{resultNo}")
    int deleteResult(Integer resultNo);

    @Update("update result set studentResult = #{studentResult} where resultNo = #{resultNo}")
    int updateResult(Result result);

    @Update("insert into result(studentNo,subjectNo,examDate,studentResult) values (#{studentNo},#{subjectNo},#{examDate},#{studentResult})")
    int addResult(Result result);

    @Select("select * from subject")
    List<Subject> getSubject();
}
