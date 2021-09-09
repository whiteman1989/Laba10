package com.company.data.DB;

import com.company.data.models.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileSystemDB implements Serializable {
    private static final String dbFile = "db.ser";
    List<Student> students;

    public FileSystemDB() {
        students = new ArrayList<>();
    }

    public void Load() {
        try {
            FileInputStream file = new FileInputStream(dbFile);
            ObjectInputStream in = new ObjectInputStream(file);

            ArrayList<Student> s;
            s = (ArrayList<Student>) in.readObject();
            in.close();
            file.close();
            students = s;
        } catch (FileNotFoundException e) {
            System.out.println("File not found!\n\tCreate new file");
            Save();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void Save() {
        try {
            FileOutputStream file = new FileOutputStream(dbFile);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(students);
            out.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Student> GetStudentsData() {
        return students;
    }

    public void Drop() {
        students = new ArrayList<>();
        Save();
    }

    public void InitData() {
        students.add(new Student("Ivan", "Lazarev", 17));
        students.add(new Student("Oleg", "Radchenko", 20));
        students.add(new Student("Andrii", "Kurochkin", 18));
        students.add(new Student("Olha", "Lailina", 17));
        students.add(new Student("Olha", "Kurochkina", 18));
        students.add(new Student("Maxim", "Timofeev", 19));
        Save();
    }


}
