package com.bitspilani.mtech.dsa.hospitalconsultation;

public class PatientRecord {

    private String pName;
    private String pAge;
    private String pId;

    public PatientRecord(String pName, String pAge, String pId) {
        this.pName = pName;
        this.pAge = pAge;
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpAge() {
        return pAge;
    }

    public void setpAge(String pAge) {
        this.pAge = pAge;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    @Override
    public String toString() {
        return "PatientRecord{" +
                "pName='" + pName + '\'' +
                ", pAge='" + pAge + '\'' +
                ", pId='" + pId + '\'' +
                '}';
    }

}
