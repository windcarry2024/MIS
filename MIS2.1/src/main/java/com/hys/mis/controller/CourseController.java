package com.hys.mis.controller;

import com.hys.mis.pojo.Result;
import com.hys.mis.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@CrossOrigin("*")
@RestController
public class CourseController
{
    @Autowired
    CourseService cs;

    @GetMapping("/getDailyCourses/{date}")
    public Result getDailyCourses(@DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable("date") LocalDate date)
    {
        Result result = cs.getDailyCourses(date);
        return result;
    }

    @GetMapping("/getManyDaysCourses/{beginDate}/{endDate}")
    public Result getManyDaysCourses(@DateTimeFormat(pattern = "yyyy-MM-dd")
                                     @PathVariable("beginDate") LocalDate beginDate,
                                     @DateTimeFormat(pattern = "yyyy-MM-dd")
                                     @PathVariable("endDate") LocalDate endDate)
    {
        Result result = cs.getManyDaysCourses(beginDate,endDate);
        return result;
    }
}
