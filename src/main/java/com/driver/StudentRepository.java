package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String, Student> studentMap = new HashMap<>();
    HashMap<String, Teacher> teacherMap = new HashMap<>();
    HashMap<String, List<String>> teacherStudentMap = new HashMap<>();

    public StudentRepository() {
        this.studentMap = new HashMap<String, Student>();
        this.teacherMap = new HashMap<String, Teacher>();
        this.teacherStudentMap = new HashMap<String, List<String>>();
    }

    public void addStudent(Student student){ studentMap.put(student.getName(), student);}

    public void addTeacher(Teacher teacher){teacherMap.put(teacher.getName(), teacher);}

    public void addStudentTeacherPair(String newStudent, String teacher){

        if(studentMap.containsKey(newStudent) && teacherMap.containsKey(teacher)) {
            List<String> currStudents = new ArrayList<>();
            if (teacherStudentMap.containsKey(teacher)) currStudents = teacherStudentMap.get(teacher);
            currStudents.add(newStudent);
            teacherStudentMap.put(teacher, currStudents);
        }

    }

    public Student getStudentByName(String name){ return studentMap.get(name);    }

    public Teacher getTeacherByName(String teacher){ return teacherMap.get(teacher);}

    public List<String>  getStudentsByTeacherName(String teacherName){
        List<String> studentsOfTeacher = new ArrayList<>();
        if(teacherStudentMap.containsKey(teacherName)) studentsOfTeacher = teacherStudentMap.get(teacherName);
        return studentsOfTeacher;
    }

    public List<String> getAllStudents(){
        List<String> allStudents = new ArrayList<>();
        for(String student: studentMap.keySet()){
            allStudents.add(student);
        }
        return allStudents;
    }

    public void deleteTeacherByName(String teacher){

        List<String> students = new ArrayList<>();
        if(teacherStudentMap.containsKey(teacher)){
            students = teacherStudentMap.get(teacher);
            for(String student: students){
                if(studentMap.containsKey(student)){
                    studentMap.remove(student);
                }
            }
            teacherStudentMap.remove(teacher);
        }



        if(teacherMap.containsKey(teacher)) teacherMap.remove(teacher);

    }

    public void deleteAllTeachers(){

        HashSet<String> students = new HashSet<>();
        for(String teacher: teacherStudentMap.keySet()){
            for(String student: teacherStudentMap.get(teacher)) {
                students.add(student);
            }
        }
        for(String student : students){
            if(studentMap.containsKey(student)){
                studentMap.remove(student);
            }
        }
        teacherStudentMap.clear();
        teacherMap.clear();


    }
}
