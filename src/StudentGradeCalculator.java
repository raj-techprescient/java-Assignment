import java.util.HashMap;
import java.util.Scanner;

class Student{
    private String name;
    private int [] scores;

    public Student(String name, int [] scores){
        this.name = name;
        this.scores = scores;
    }

    public String getName(){
        return this.name;
    }
    public int[] getScores(){
        return this.scores;
    }
}

class StudentManagement{
    HashMap<String, int[]> studentMap = new HashMap<>();

    public void addStudent(Student s) {
        studentMap.put(s.getName(), s.getScores());
    }
    public char calculateGrade(String name){
        int [] scores = studentMap.get(name);
        int totalScore = 0;
        for (int score: scores){
            totalScore+=score;
        }
        double grade = (double)totalScore/5;
        if (grade >= 90) {
            return 'A';
        } else if (grade >= 80) {
            return 'B';
        } else if (grade >= 70) {
            return 'C';
        } else if (grade >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
public class StudentGradeCalculator {
    public static void main(String[] args){
        StudentManagement sm = new StudentManagement();
        Scanner scan = new Scanner(System.in);
        int option = 0;
        while (option != 3) {
            System.out.println("1. Add Student details");
            System.out.println("2. Calculate score");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            option = scan.nextInt();
            scan.nextLine();
            switch (option) {
                case 1:
                    System.out.print("Enter student name ");
                    String name = scan.next();
                    scan.nextLine();
                    System.out.print("Enter Scores in 5 subjects ");
                    int[] scores = new int[5];
                    for(int i =0; i<5; i++){
                        scores[i] = scan.nextInt();
                    }
                    Student st = new Student(name, scores);
                    sm.addStudent(st);
                    System.out.println("Employee added successfully!");
                    break;
                case 2:
                    System.out.print("Enter student name for grade calculation ");
                    String studentName = scan.next();
                    scan.nextLine();
                    char grade = sm.calculateGrade(studentName);
                    System.out.println(studentName+ " grade is "+ grade);
                    break;
                case 3:
                    System.out.println("Exiting Student management Management System...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
        scan.close();
    }
}
