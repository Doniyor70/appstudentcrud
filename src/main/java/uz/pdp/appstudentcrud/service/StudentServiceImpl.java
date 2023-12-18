package uz.pdp.appstudentcrud.service;

import uz.pdp.appstudentcrud.payload.StudentDTO;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {
    private List<StudentDTO> studentDTOS = Collections.synchronizedList(new ArrayList<>());

    private static StudentServiceImpl instance;

    private StudentServiceImpl() {
    }

    public static StudentServiceImpl getInstance() {
        if (Objects.isNull(instance))
            instance = new StudentServiceImpl();

        return instance;
    }

    @Override
    public List<StudentDTO> getByGroup(Integer groupId) {
        return studentDTOS.stream()
                .filter(s -> s.getGroupDTO().getId().equals(groupId))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getById(Integer id) {
        return getByIdOrElseThrow(id);
    }

    @Override
    public StudentDTO add(StudentDTO studentDTO) {
        studentDTO.setId(studentDTOS.size() + 1);
        studentDTOS.add(studentDTO);
        return studentDTO;
    }

    @Override
    public StudentDTO edit(Integer id, StudentDTO studentDTO) {

        StudentDTO newStudent = getByIdOrElseThrow(id);

        newStudent.setAddressDTO(studentDTO.getAddressDTO());
        newStudent.setGroupDTO(studentDTO.getGroupDTO());
        newStudent.setBirthDate(studentDTO.getBirthDate());
        newStudent.setFirstName(studentDTO.getFirstName());
        newStudent.setLastName(studentDTO.getLastName());
        newStudent.setPhoneNumber(studentDTO.getPhoneNumber());
        newStudent.setBiographyFilePath(studentDTO.getBiographyFilePath());

        return newStudent;
    }

    @Override
    public boolean delete(Integer id) {
        return studentDTOS.remove(getByIdOrElseThrow(id));
    }

    @Override
    public String read(Integer id) {
        StudentDTO student = getByIdOrElseThrow(id);
        try (InputStream input = new FileInputStream(student.getBiographyFilePath())) {
            byte[] bytes = input.readAllBytes();
            return new String(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean serialize() {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("db/students.txt"))) {
            output.writeObject(studentDTOS);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deserialize() {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("db/students.txt"))) {
            studentDTOS = (List<StudentDTO>) input.readObject();
            return true;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private StudentDTO getByIdOrElseThrow(Integer id) {
        return studentDTOS.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }
}
