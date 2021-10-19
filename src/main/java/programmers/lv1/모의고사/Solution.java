package programmers.lv1.모의고사;

import java.util.*;

public class Solution {
    static int[] studentA = {1,2,3,4,5};
    static int[] studentB = {2,1,2,3,2,4,2,5};
    static int[] studentC = {3,3,1,1,2,2,4,4,5,5};
    static int[][] allStudents = {studentA, studentB, studentC};
    static List<Student> students = new ArrayList<>();
    public static int[] solution(int[] answers) {
        return bfs(answers);
    }

    static int[] bfs(int[] answers){
        Queue<Student> queue = new LinkedList<>();
        queue.add(new Student(1, 0, 0));
        queue.add(new Student(2, 0, 0));
        queue.add(new Student(3, 0, 0));
        while (!queue.isEmpty()){
            Student student = queue.poll();
            if(student.count == answers.length){
                students.add(student);
            }else {
                if(answers[student.count]==allStudents[student.no-1][student.count%allStudents[student.no-1].length]){
                    queue.add(new Student(student.no, student.answer_count+1, student.count+1));
                }else {
                    queue.add(new Student(student.no, student.answer_count, student.count+1));
                }
            }
        }
        return sort(students);
    }

    static int[] sort(List<Student> students){
        students.sort(Student::compareTo);
        if(students.get(0).answer_count != students.get(1).answer_count){
            int[] temp = new int[1];
            temp[0] = students.get(0).no;
            return temp;
        } else if (students.get(0).answer_count == students.get(1).answer_count
                && students.get(1).answer_count != students.get(2).answer_count) {
            int[] temp = new int[2];
            temp[0] = students.get(0).no;
            temp[1] = students.get(1).no;
            return temp;
        }else if((students.get(0).answer_count == students.get(1).answer_count) &&
                students.get(1).answer_count == students.get(2).answer_count){
            int[] temp = new int[3];
            for(int i=0; i<students.size(); i++){
                temp[i] = students.get(i).no;
            }
            return temp;
        }
        return new int[0];
    }

    static class Student implements Comparable<Student>{
        int no;
        int answer_count = 0;
        int count;

        public Student(int no, int answer_count, int count) {
            this.no = no;
            this.answer_count = answer_count;
            this.count = count;
        }

        @Override
        public int compareTo(Student o) {
            return Integer.compare(o.answer_count, this.answer_count);
        }
    }
}
