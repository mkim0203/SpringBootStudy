package com.example.demo.mapper;

import com.example.demo.model.jobs.JobRootItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
public interface JobRootMapper {
//    @Select("SELECT * FROM JOBS_ROOT WHERE code = #{value}")
//    JobRootItem findByColumn(String value);

    String selectTest();
}
