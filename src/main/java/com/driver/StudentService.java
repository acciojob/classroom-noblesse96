package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){studentRepository.addStudent(student);}

    public void addTeacher(Teacher teacher){studentRepository.addTeacher(teacher);}

    public void addStudentTeacherPair(String newStudent, String teacher){studentRepository.addStudentTeacherPair(newStudent, teacher);}

    public Student getStudentByName(String name){return studentRepository.getStudentByName(name);}

    public Teacher getTeacherByName(String teacher){return studentRepository.getTeacherByName(teacher);}

    public List<String> getStudentsByTeacherName(String teacherName){return studentRepository.getStudentsByTeacherName(teacherName);}

    public List<String> getAllStudents(){return studentRepository.getAllStudents();}

    public void deleteTeacherByName(String teacher) { studentRepository.deleteTeacherByName(teacher);}

    public void deleteAllTeachers(){studentRepository.deleteAllTeachers();}

}
