package uz.pdp.appstudentcrud.payload;

import uz.pdp.appstudentcrud.entity.Address;
import uz.pdp.appstudentcrud.entity.Group;
import uz.pdp.appstudentcrud.entity.Student;

import java.io.Serializable;
import java.time.LocalDate;

public class StudentDTO implements Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private LocalDate birthDate;
    private GroupDTO groupDTO;
    private AddressDTO addressDTO;
    private String biographyFilePath;

    public StudentDTO(Integer id, String firstName, String lastName, String phoneNumber, LocalDate birthDate, GroupDTO groupDTO, AddressDTO addressDTO, String biographyFilePath) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.groupDTO = groupDTO;
        this.addressDTO = addressDTO;
        this.biographyFilePath = biographyFilePath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public GroupDTO getGroupDTO() {
        return groupDTO;
    }

    public void setGroupDTO(GroupDTO groupDTO) {
        this.groupDTO = groupDTO;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public String getBiographyFilePath() {
        return biographyFilePath;
    }

    public void setBiographyFilePath(String biographyFilePath) {
        this.biographyFilePath = biographyFilePath;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthDate=" + birthDate +
                ", groupDTO=" + groupDTO +
                ", addressDTO=" + addressDTO +
                ", biographyFilePath='" + biographyFilePath + '\'' +
                '}';
    }
}
