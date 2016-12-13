package com.chapter13.collection;

import java.util.EnumSet;
import java.util.Iterator;

/**
 * Description: EnumSet test
 * Created by lixiong on 2016/12/13.
 */
public class EnumSetTest {
    enum WeekDays {Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday};
    public static void main(String[] args){
        EnumSet<WeekDays> always = EnumSet.allOf(WeekDays.class);
        EnumSet<WeekDays> never = EnumSet.noneOf(WeekDays.class);
        EnumSet<WeekDays> workday = EnumSet.range(WeekDays.Monday, WeekDays.Friday);
        EnumSet<WeekDays> mwf = EnumSet.of(WeekDays.Monday, WeekDays.Wednesday, WeekDays.Friday);
    }
}
