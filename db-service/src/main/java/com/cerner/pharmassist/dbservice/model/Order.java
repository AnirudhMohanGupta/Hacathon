package com.cerner.pharmassist.dbservice.model;

import javax.persistence.*;

@Entity
@Table(name = "order", catalog = "test")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "drug")
    private String drug;

    @Column(name = "status")
    private Integer status;


    public Order(String patientName, String drug, Integer status) {
        this.patientName = patientName;
        this.drug = drug;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDrug() {
        return drug;
    }

    public Order() {
    }
}
