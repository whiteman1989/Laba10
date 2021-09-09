package com.company.data.intarfaces;

import com.company.data.models.Student;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public interface IStudentRepository {
    List<Student> GetStudents();
    List<Student> GetFilteredStudent(Predicate<? super Student> filter);
    Student GetStudentById(UUID id);
    void AddStudent(Student student);
    void DeleteStudentById(UUID id);
    void SaveChange();
    void Load();
    void DropRepository();
}
