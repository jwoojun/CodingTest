package boj.dp.boj_1623;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int temp =0;
    static Employee[] company;
    static int max = Integer.MIN_VALUE + 100000;
    static int min = Integer.MAX_VALUE - 100000;
    static List<Employee> participants = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        n = input.integer();
        company = new Employee[n];
        for (int i = 0; i < n; i++) {
            int interesting = input.integer();
            company[i] = new Employee(i, 0, interesting, false, new ArrayList<>());
        }
        for (int i = 0; i < n-1; i++) {
            int boss = input.integer();
            company[i+1].boss = boss-1;
            company[boss-1].list.add(company[i+1]);
        }


        for(int i=1; i<n; i++){
            if(!participants.contains(company[i])){
                dfs(i, i+1);
            }
        }
        System.out.println(temp);
    }

    static boolean isEmployee(int no){
        return company[no].no != 0;
    }

    static boolean participate(int no){
        return company[no].participate;
    }

    static boolean participateBoss(int no){
        int bossNo = company[no].boss;
        Employee employee = company[no];
        return !company[bossNo].participate && !company[bossNo].list.contains(employee);
    }


    static void dfs(int no, int count) {
        participants.forEach(System.out::println);
        if(count == n-1){
            max = Math.max(max, temp);
            participants.clear();
        }
        for(int i=0; i<n; i++){
            if(!company[no].participate){
                Employee employee = company[no];
                if(!participants.contains(company[employee.boss])){
                    company[no].participate = true;
                    for(Employee e : company[employee.boss].list){
                        temp+=e.interesting;
                        participants.add(e);
                    }
                    company[no].participate = true;
                    for(Employee e : company[employee.boss].list){
                        temp-=e.interesting;
                        participants.remove(e);
                    }
                }
            }
        }




    }

    static class Employee {
        int no;
        int boss;
        int interesting;
        boolean participate;
        List<Employee> list = new ArrayList<>();

        public Employee(int no, int boss, int interesting, boolean participate, List<Employee> list) {
            this.no = no;
            this.boss = boss;
            this.interesting = interesting;
            this.participate = participate;
            this.list = list;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "no=" + no +
                    '}';
        }
    }
    static Input input = new Input();
    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        public int integer() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
        public String next() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        public char[] nToCharArray() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken().toCharArray();
        }
    }


}
