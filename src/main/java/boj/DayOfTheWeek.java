package boj;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum DayOfTheWeek implements EnumMapper {

    SUNDAY("일요일", 0,"S"), MONDAY("월요일",1, "M"),
    TUESDAY("화요일",2, "T"), WEDNESDAY("수요일",3, "W"),
    THURSDAY("목요일",4, "T"), FRIDAY("금요일", 5, "F"),
    SATURDAY("토요일", 6, "S");

    private final String when;
    private final int ordinal;
    private final String abbreviation;

    DayOfTheWeek(String when, int ordinal, String abbreviation) {
        this.when = when;
        this.ordinal = ordinal;
        this.abbreviation = abbreviation;
    }

    private final static int a = 7;
    public static final List<DayOfTheWeek> calender = new ArrayList<>();

    static {
        Arrays.stream(values()).forEachOrdered(dayOfTheWeek -> calender.add(dayOfTheWeek));
    }

    public int getStartDate() {
        return ordinal;
    }


    static void print(){
        for(int row=0; row<a; row++){
            for(int column=0; column<a; column++){
                if(column%7==0){
                    blank();
                }else {
                    blank2();
                }
            }
        }
    }

    private static void blank(){
        System.out.println();
    }

    private static void blank2(){
        System.out.println(" ");
    }


    public String getAbbreviation() {
        return abbreviation;
    }

    //    public void pushBlank(DayOfTheWeek dayOfTheWeek){
//        IntStream.rangeClosed(1, dayOfTheWeek.startDay)
//                .forEachOrdered(blank->calender.add(THE_DAY_OF_BLANK));
//    }

    @Override
    public String getCode() {
        return getWhen();
    }

    @Override
    public String getName() {
        return name();
    }

    public String getWhen() {
        return when;
    }

    public DayOfTheWeek t(int year, int month){
        return Arrays.stream(values())
                .filter(dayOfTheWeek->dayOfTheWeek.getName().equals(of(year, month)))
                .findAny()
                .orElseThrow();
    }


    public static void main(String[] args){
        calender.forEach(System.out::println);

        for(int i=1; i<10; i++){
            if(i%7==0) {
                System.out.println();
                System.out.print(i+" ");
            }else {
                System.out.print(i+" ");
            }
        }
    }

    public String of(int year, int month){
        return LocalDate.of(year, month, 1).getDayOfWeek().name();
    }

    public void fillDay(){
    }
}


interface EnumMapper {
    String getCode();
    String getName();
}

class Day {
    int day;
    private Time time;
    private DayOfTheWeek dayOfTheWeek;

}

class Time {
    int hour;
    int minute;
    int second;
}

class DayOfWeekValue {
    private String code;
    private String name;

    public DayOfWeekValue(EnumMapper type) {
        this.code = type.getCode();
        this.name = type.getName();
    }
    private static void test3(){
        System.out.println("될까?");
    }
}

