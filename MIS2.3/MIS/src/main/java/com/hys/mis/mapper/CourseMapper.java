package com.hys.mis.mapper;

import com.hys.mis.pojo.DaySchedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.time.LocalDate;
import java.util.List;

@Mapper
public interface CourseMapper
{
    DaySchedule getDailyCourses(@Param("date")LocalDate date);
    List<DaySchedule> getManyDaysCourses(@Param("beginDate") LocalDate beginDate,
                                         @Param("endDate") LocalDate endDate);
}
