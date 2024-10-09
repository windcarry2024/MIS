package com.hys.mis.service;

import com.hys.mis.pojo.Result;

import java.time.LocalDate;

public interface CourseService
{
    Result getDailyCourses(LocalDate date);

    Result getManyDaysCourses(LocalDate beginDate,LocalDate endDate);
}
