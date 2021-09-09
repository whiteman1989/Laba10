package com.company;

import com.company.data.DB.FileSystemDB;
import com.company.data.intarfaces.IStudentRepository;
import com.company.data.models.Student;
import com.company.data.repositories.DBRepository;
import com.company.data.repositories.FSRepository;

import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        IStudentRepository repository = new FSRepository();;

        System.out.println("Get adult students from");
        var students = repository.GetFilteredStudent(s -> s.GetAge() >= 18);
        for (Student s: students) {
            System.out.println(s.toString());
        }

//        FileSystemDB db2 = new FileSystemDB();
//        db2.InitData();
    }
}
