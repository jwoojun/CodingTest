package baek;

public enum DayOfWeeks implements DayOfWeekType {
    SUNDAY("일요일"), MONDAY("월요일"), TUESDAY("화요일"), WEDNESDAY("수요일"),
    THURSDAY("목요일"), FRIDAY("금요일"), SATURDAY("토요일");
    private final String when;


    @Override
    public String getCode() {
        return getCode();
    }

    @Override
    public String getName() {
        return name();
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


interface DayOfWeekType {
    String getCode();
    String getName();
}

class DayOfWeekValue {
    private String code;
    private String name;

    public DayOfWeekValue(DayOfWeekType type) {
        this.code = type.getCode();
        this.name = type.getName();
    }
}