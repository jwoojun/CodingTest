package baek;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public enum DayOfTheWeek implements EnumMapper {

    SUNDAY("일요일", 0), MONDAY("월요일",1), TUESDAY("화요일",2),
    WEDNESDAY("수요일",3), THURSDAY("목요일",4), FRIDAY("금요일", 5),
    SATURDAY("토요일", 6);

    private final String when;
    private final int ordinal;

    DayOfTheWeek(String when, int ordinal) {
        this.when = when;
        this.ordinal = ordinal;
    }

    private final static int a = 7;
    public static final List<DayOfTheWeek> calender = new ArrayList<>();

    static {
        Arrays.stream(values()).forEachOrdered(dayOfTheWeek -> calender.add(dayOfTheWeek));
    }

    public int getStartDate() {
        return ordinal;
    }

//    static void putBlank(DayOfTheWeek dayOfWeek){
//        IntStream.rangeClosed(1, dayOfWeek.getStartDate())
//                .forEachOrdered(day->calender.add());
//    }

    static void print(){
        for(int i=0; i<a; i++){
            for(int j=0; j<a; j++){
                if(j%7==0){
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
        DayOfWeek dayOfWeek =  DayOfWeek.WEDNESDAY;
        System.out.println(DayOfTheWeek.WEDNESDAY.getCode());
        System.out.println(DayOfTheWeek.WEDNESDAY.getName());
        System.out.println(dayOfWeek.name());
        System.out.println("=================");
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

    List<Object[]> lst = new ArrayList<>();

    public void fillDay(){
    }


    //    private final String code;
//    private final String name;

//    DayOfWeeks(String code, String name) {
//        this.code = code;
//        this.name = name;
//    }
    //    public static void main(String args []){
//        Object [] arr = new Object[42];
//        arr[0] = new int[]{1, 3};
//        java.time.DayOfWeek result = LocalDate.of(2017, 3, 1).getDayOfWeek();
//        System.out.println(result);
//    }
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

