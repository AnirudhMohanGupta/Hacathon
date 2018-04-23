package com.cerner.pharmassist.dbservice.model;

import java.util.List;

public class Orders {

    private String patientName;
    private List<String> drugs;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    private Integer status;

    public Orders(String patientName, List<String> drugs) {
        this.patientName = patientName;
        this.drugs = drugs;
        this.status = 0;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public List<String> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<String> drugs) {
        this.drugs = drugs;
    }

    public Orders() {
    }
}
