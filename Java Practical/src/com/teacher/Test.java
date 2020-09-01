package com.teacher;

public class Test
{
    public static void main(String[] args)
    {
        Teacher teacher = new Teacher();
        teacher.setName("迪丽热巴");
        teacher.setAge(28);
        System.out.println(teacher.getName()+","+teacher.getAge());
        teacher.teach();

        Student student = new Student("马拉杰",24);
        System.out.println(student.getName()+","+student.getAge());
        student.study();
    }

}
