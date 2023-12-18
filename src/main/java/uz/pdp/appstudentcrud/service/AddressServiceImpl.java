package uz.pdp.appstudentcrud.service;

import uz.pdp.appstudentcrud.payload.AddressDTO;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class AddressServiceImpl implements AddressService {
    public List<AddressDTO> addressDTOS = Collections.synchronizedList(new ArrayList<>());

    private static AddressServiceImpl instance;

    private AddressServiceImpl() {
    }

    public static AddressServiceImpl getInstance() {
        if (Objects.isNull(instance))
            instance = new AddressServiceImpl();
        return instance;
    }

    @Override
    public List<AddressDTO> all() {
        return addressDTOS;
    }

    @Override
    public AddressDTO add(AddressDTO addressDTO) {
        addressDTO.setId(addressDTOS.size() + 1);
        addressDTOS.add(addressDTO);
        return addressDTO;
    }

    @Override
    public AddressDTO edit(Integer id, AddressDTO addressDTO) {
        AddressDTO newAddress = getByIdOrElseThrow(id);

        newAddress.setAddressLine(addressDTO.getAddressLine());
        newAddress.setCity(addressDTO.getCity());
        newAddress.setRegion(addressDTO.getRegion());

        return newAddress;
    }

    @Override
    public boolean delete(Integer id) {
        return addressDTOS.remove(getByIdOrElseThrow(id));
    }

    @Override
    public AddressDTO getByIdOrElseThrow(Integer id) {

        return addressDTOS.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }
}
