package com.bitspilani.mtech.dsa.hospitalconsultation;

import java.util.concurrent.atomic.AtomicLong;

public class HospitalConsultation {

    DoublyLinkedList patientDList = new DoublyLinkedList();
    ConsultQueue cq = new ConsultQueue(patientDList);

    public static void main(String[] args) {

        HospitalConsultation hc = new HospitalConsultation();
        int a = hc.registerPatient("Pradeep", 45);
        hc.cq.enqueuePatient(a);

        int b = hc.registerPatient("Surya", 60);
        hc.cq.enqueuePatient(b);

        int c = hc.registerPatient("Ajit", 55);
        hc.cq.enqueuePatient(c);

        int d = hc.registerPatient("Mary", 64);
        hc.cq.enqueuePatient(d);

        int e = hc.registerPatient("Radha", 56);
        hc.cq.enqueuePatient(e);


        //Printing Consultation queue to console
        System.out.println("Size of Consult Queue: " + hc.patientDList.size);
        hc.cq.displayQueue();


        //Testing Dequeing a patient
        hc.cq.dequeuePatient(b);
        hc.cq.displayQueue();


        //Testing Next Patient
        hc.cq.nextPatient();
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

        return pId;
    }

}
