package Week4_sort.BT_Lap_Trinh.Bai4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

class Student{
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa){
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId(){
        return id;
    }
    public String getFname(){
        return fname;
    }
    public double getCgpa(){
        return cgpa;
    }
}
class StudentComparator implements Comparator<Student>{
    @Override
    public int compare(Student x, Student y){
        if(x.getCgpa() != y.getCgpa()){
            return Double.compare(y.getCgpa(), x.getCgpa());
        }

        int nameCompare = x.getFname().compareTo(y.getFname());
        if (nameCompare != 0) {
            return nameCompare;
        }
        return Integer.compare(x.getId(), y.getId());
    }
}
public class JavaSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int testCase = Integer.parseInt(sc.nextLine());

        List<Student> studentList = new ArrayList<>();
        while(testCase > 0){
            int id = sc.nextInt();
            String fname = sc.next();
            double cgpa = sc.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCase--;
            }

        // hàm sort swap tưng căp theo cac gia tri duoc return ở StudentComparator
        studentList.sort(new StudentComparator());

        for(Student st : studentList){
            System.out.println(st.getFname());
        }
    }
}