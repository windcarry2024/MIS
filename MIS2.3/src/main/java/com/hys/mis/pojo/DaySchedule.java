package com.hys.mis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DaySchedule
{
    LocalDate date;
    String realtime;

    String session1_2;
    String position1_2;
    String teacher1_2;

    String session3_4;
    String position3_4;
    String teacher3_4;

    String session5_6;
    String position5_6;
    String teacher5_6;

    String session7_8;
    String position7_8;
    String teacher7_8;

    String session9_10;
    String position9_10;
    String teacher9_10;

    String session11_12;
    String position11_12;
    String teacher11_12;
}
