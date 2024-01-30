package com.example.addressservice.address.repository;

import com.example.addressservice.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AddressRepo extends JpaRepository<Address,Integer> {


    Optional<Address> findAddressByEmployeeId(int employeeId);
}
