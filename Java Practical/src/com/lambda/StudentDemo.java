package com.lambda;

import com.studentmanager.Student;

public class StudentDemo
{
    public static void main(String[] args)
    {
        useStudentBuilder((String name, String age)->{
            return new Student(name, age);
        });

        useStudentBuilder((name, age)-> new Student(name, age));

        useStudentBuilder(Student::new);

    }

    private static void useStudentBuilder(StudentBuilder sb){
        Student s = sb.build("迪丽热巴", "28");
        System.out.println(s.toString());
    }
}
