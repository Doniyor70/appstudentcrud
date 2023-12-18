package uz.pdp;

import uz.pdp.appstudentcrud.entity.Address;
import uz.pdp.appstudentcrud.entity.Group;
import uz.pdp.appstudentcrud.entity.Student;
import uz.pdp.appstudentcrud.payload.AddressDTO;
import uz.pdp.appstudentcrud.payload.GroupDTO;
import uz.pdp.appstudentcrud.payload.StudentDTO;
import uz.pdp.appstudentcrud.service.AddressServiceImpl;
import uz.pdp.appstudentcrud.service.GroupServiceImpl;
import uz.pdp.appstudentcrud.service.StudentService;
import uz.pdp.appstudentcrud.service.StudentServiceImpl;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        GroupServiceImpl groupService = GroupServiceImpl.getInstance();
        GroupDTO groupDTO = new GroupDTO(32, "G32");
        groupService.add(groupDTO);

        AddressServiceImpl addressService = AddressServiceImpl.getInstance();
        AddressDTO addressDTO = new AddressDTO(21, "Tashkent", "Tashkent city", "Chilanzar 12, 76A");
        addressService.add(addressDTO);

        StudentDTO studentDTO = new StudentDTO(
                1,
                "Doniyor",
                "Umarov",
                "+998907001213",
                LocalDate.of(2000, 12, 1),
                groupDTO,
                addressDTO,
                "something"
        );

        StudentServiceImpl studentService = StudentServiceImpl.getInstance();

        studentService.add(studentDTO);

        System.out.println(studentService.getById(1));

        studentService.serialize();

    }
}
