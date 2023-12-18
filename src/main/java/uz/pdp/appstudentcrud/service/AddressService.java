package uz.pdp.appstudentcrud.service;

import uz.pdp.appstudentcrud.entity.Address;
import uz.pdp.appstudentcrud.payload.AddressDTO;

import java.util.List;

public interface AddressService {

    List<AddressDTO> all();

    AddressDTO add(AddressDTO addressDTO);

    AddressDTO edit(Integer id, AddressDTO addressDTO);

    boolean delete(Integer id);

    AddressDTO getByIdOrElseThrow(Integer id);

}
