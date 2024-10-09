package com.hys.mis.service.impl;

import com.hys.mis.mapper.CourseMapper;
import com.hys.mis.pojo.DaySchedule;
import com.hys.mis.pojo.Result;
import com.hys.mis.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

@Service
public class CourseServiceImpl implements CourseService
{
    @Autowired
    CourseMapper cm;

    @Override
    public Result getDailyCourses(LocalDate date)
    {
        DaySchedule ds = cm.getDailyCourses(date);
        LocalDate ld = ds.getDate();
        DayOfWeek dayOfWeek = ld.getDayOfWeek();
        String dayOfWeekString = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.CHINA);
        String temp = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(ld);
        String realtime = temp + " " + dayOfWeekString;
        ds.setRealtime(realtime);
        return Result.generate(200,"获取完毕",ds);
    }

    @Override
    public Result getManyDaysCourses(LocalDate beginDate, LocalDate endDate)
    {
        List<DaySchedule> list = cm.getManyDaysCourses(beginDate, endDate);
        for (DaySchedule daySchedule : list)
        {
            LocalDate ld = daySchedule.getDate();
            DayOfWeek dayOfWeek = ld.getDayOfWeek();
            String dayOfWeekString = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.CHINA);
            String date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(ld);
            String realtime = date + " " + dayOfWeekString;
            daySchedule.setRealtime(realtime);
        }
        return Result.generate(200,"获取完毕,共获取到了"+list.size()+"天的课程",list);
    }
}
