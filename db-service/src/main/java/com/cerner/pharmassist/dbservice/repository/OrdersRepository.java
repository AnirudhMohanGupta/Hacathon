package com.cerner.pharmassist.dbservice.repository;

import com.cerner.pharmassist.dbservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Order, Integer> {


    @Modifying(clearAutomatically = true)
    @Query(value ="update test.order o set o.status = 1 WHERE o.id= :id" , nativeQuery = true)
    List<Order> updateStatus(@Param("id") Integer id);


    List<Order> findByPatientName(String patientname);

    List<Order> findAllByStatus(Integer status);


    @Query(value ="select * from test.order o WHERE o.patient_name = :patientname AND o.drug= :drug" , nativeQuery = true)
    List<Order> findId(@Param("patientname") String patientname, @Param("drug") String drug);

}
