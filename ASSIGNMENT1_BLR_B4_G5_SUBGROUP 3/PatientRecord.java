package com.bitspilani.mtech.dsa.hospitalconsultation;

public class PatientRecord {

    private String pName;
    private int pAge;
    private int pId;

    private static int incrementer = 110;


    public PatientRecord(String pName, int pAge) {
        incrementer++;
        this.pName = pName;
        this.pAge = pAge;
        this.pId = incrementer;

    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpAge() {
        return pAge;
    }

    public void setpAge(int pAge) {
        this.pAge = pAge;
    }

    public int getpId() {
        return pId;
    }

    /*public void setpId(int pId) {
        this.pId = pId;
    }*/

    @Override
    public String toString() {
        return "PatientRecord{" +
                "pName='" + pName + '\'' +
                ", pAge='" + pAge + '\'' +
                ", pId='" + pId + '\'' +
                '}';
    }

}
