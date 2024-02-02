package com.crudtesting.crud.services;

import com.crudtesting.crud.dto.CrudDto;
import com.crudtesting.crud.entity.Crud;
import com.crudtesting.crud.repository.CrudRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class CrudService {

    @Autowired
    private CrudRepository crudRepository;

    public String saveData(CrudDto crudDto) {

        Crud newData = new Crud(crudDto);

        return crudRepository.save(newData).toString();


    }




    public String deleteData(int studentId) {
        try {
            crudRepository.deleteById(studentId);
            return "Crud deleted successfully.";
        } catch (EmptyResultDataAccessException e) {

            return "Crud not found with studentId: " + studentId;
        } catch (Exception e) {
            return "Error deleting Crud with studentId: " + e;
        }
    }

    public String updateData(int studentId, CrudDto CrudDto) {

        if (crudRepository.existsById(studentId)) {
            Crud existingCrud = crudRepository.getReferenceById(studentId);
            existingCrud.setAge(CrudDto.getAge() != 0 ? CrudDto.getAge() : existingCrud.getAge());
            existingCrud.setAddress(CrudDto.getAddress() != null ? CrudDto.getAddress() : existingCrud.getAddress());
            existingCrud.setName(CrudDto.getName() != null ? CrudDto.getName() : existingCrud.getName());
            crudRepository.save(existingCrud);


        }
        else
        {
            System.out.println("Crud studentId "+studentId+"do not Exist");
        }
        return "Updated successfully:"+studentId;
    }

    public List<Crud> getAllRecords() {
        return crudRepository.findAll();
    }

    public Crud getSingleRecord(int studentId) {
        return crudRepository.findById(studentId).orElse(null);
    }

    public List<Crud> getByName(String name) {
        return crudRepository.findByName(name);
    }


}
