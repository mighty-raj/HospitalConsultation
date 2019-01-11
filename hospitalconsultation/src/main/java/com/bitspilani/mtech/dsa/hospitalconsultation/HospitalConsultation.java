package com.bitspilani.mtech.dsa.hospitalconsultation;

import java.util.concurrent.atomic.AtomicLong;

public class HospitalConsultation {

    DoublyLinkedList patientDList = new DoublyLinkedList();
    ConsultQueue cq = new ConsultQueue(patientDList);

    public static void main(String[] args) {

        HospitalConsultation hc = new HospitalConsultation();
        hc.registerPatient("Pradeep", 45);
        hc.registerPatient("Surya", 60);
        hc.registerPatient("Ajit", 55);
        hc.registerPatient("Mary", 64);
        hc.registerPatient("Radha", 56);

        System.out.println("Size of Consult Queue: " + hc.patientDList.size);

        //hc.cq.displayQueue();
        //System.out.println(hc.cq.getPatientRecord(111).toString());

        hc.cq.enqueuePatient(111);
        hc.cq.enqueuePatient(112);
        hc.cq.enqueuePatient(113);
        hc.cq.enqueuePatient(114);
        hc.cq.enqueuePatient(115);

        hc.cq.displayQueue();

    }

    public int registerPatient(String pName, int age){

        int pId;
        PatientRecord patient = new PatientRecord(pName, age);
        pId = patient.getpId();

        if (patientDList.start == null) {
            patientDList.insertAtStart(patient);
        } else {
            patientDList.insertAtEnd(patient);
        }

        //cq.enqueuePatient(pId);

        return pId;
    }


}
