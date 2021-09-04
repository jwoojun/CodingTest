public class Testtt {
    public static void main(String args []){
        String a = new String("a");
        String a2 = new String("a");
        String a3 = "a";

        System.out.println(a.hashCode());
        System.out.println(a2.hashCode());
        System.out.println(a3.hashCode());

        System.out.println(a.equals(a2));
        System.out.println(a2.equals(a3));
//        Object o = new Object();
//        String s = "asdf";
//        Object o2 = new Object();
//                System.out.println(System.identityHashCode(s));
//                System.out.println(System.identityHashCode(o));
//                System.out.println(o.hashCode());
    }
}