package com.company.data.repositories;

import com.company.data.intarfaces.IStudentRepository;
import com.company.data.models.Student;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class DBRepository implements IStudentRepository {
    @Override
    public List<Student> GetStudents() {
        return null;
    }

    @Override
    public List<Student> GetFilteredStudent(Predicate<? super Student> filter) {
        return null;
    }

    @Override
    public Student GetStudentById(UUID id) {
        return null;
    }

    @Override
    public void AddStudent(Student student) {

    }

    @Override
    public void DeleteStudentById(UUID id) {

    }

    @Override
    public void SaveChange() {

    }

    @Override
    public void Load() {

    }

    @Override
    public void DropRepository() {

    }
}
