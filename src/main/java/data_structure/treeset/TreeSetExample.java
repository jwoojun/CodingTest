package data_structure.treeset;


import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String args []){
//        TreeSet<Integer> set = new TreeSet();
//        Integer from = "b";
//        Integer from2 = "B";
//        Integer to = "d";
//
//        set.add("baa");
//        set.add("bbc");
//        set.add("cbc");
//        set.add("Car");
//        set.add("cbcaaa");
//        set.add("dcbcbaaa");
//
//        System.out.println("result= "+set.subSet(from, to));
//        System.out.println("resul2= "+set.subSet(from, to+"zzz"));
//        System.out.println("resul2= "+set.subSet(from2, to+"zzz"));
//        System.out.println();

        char ch =' ';
        for(int i=0; i<95; i++){
            System.out.print(ch++);
            if(i==45){
                System.out.println();
            }
        }
        System.out.println();
        char a = ' ';
        a+=1;
        System.out.println(a);


        TreeSet<Integer> integerSet = new TreeSet<>();
        int [] numbers = {80, 95, 50, 40, 65, 10, 100};
        for (int number : numbers) {
            integerSet.add(number);
        }

        System.out.println("50미만= "+integerSet.headSet(50));
        System.out.println("50이상= "+integerSet.tailSet(50));
    }
}



interface Human{
    void speak();
}

class GrandParent implements Human{

    @Override
    public void speak() {

    }
}

class Child extends GrandParent{

}



