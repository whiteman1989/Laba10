package com.company.data.repositories;

import com.company.data.DB.FileSystemDB;
import com.company.data.intarfaces.IStudentRepository;
import com.company.data.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class FSRepository implements IStudentRepository {

    FileSystemDB db;
    List<Student> students;

    public FSRepository() {
        db = new FileSystemDB();
        db.Load();
        students = db.GetStudentsData();
    }

    @Override
    public List<Student> GetStudents() {
        Load();
        return students;
    }

    @Override
    public List<Student> GetFilteredStudent(Predicate<? super Student> filter) {
        Load();
        return students.stream().filter(filter).toList();
    }

    @Override
    public Student GetStudentById(UUID id) {
        Load();
        return students.stream().filter(s -> s.GetId() == id).findFirst().get();
    }

    @Override
    public void AddStudent(Student student) {
        students.add(student);
        db.Save();
    }

    @Override
    public void DeleteStudentById(UUID id) {
        students.removeIf(s -> s.GetId() == id);
    }

    @Override
    public void SaveChange() {
        db.Save();
    }

    @Override
    public void Load() {
        db.Load();
        students = db.GetStudentsData();
    }

    @Override
    public void DropRepository() {
        db.Drop();
    }
}
