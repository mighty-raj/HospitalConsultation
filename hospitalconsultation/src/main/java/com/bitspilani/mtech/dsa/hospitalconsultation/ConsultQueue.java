package com.bitspilani.mtech.dsa.hospitalconsultation;

import sun.awt.geom.AreaOp;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ConsultQueue {

    // Creating empty priority queue
    //PriorityQueue<PatientRecord> pQueue = new PriorityQueue<PatientRecord>(Collections.reverseOrder());

    PriorityQueue<PatientRecord> pQueue;
    DoublyLinkedList patientList;

    public ConsultQueue(DoublyLinkedList plist) {

        pQueue = new PriorityQueue<PatientRecord>(new Comparator<PatientRecord>() {
            public int compare(PatientRecord a, PatientRecord b) {
                return b.getpAge() - a.getpAge();
            }
        });
        patientList = plist;

    }

    PatientRecord getPatientRecord(int patientId) {

        PatientRecord pr = patientList.getPatientRecord(patientId);
        return pr;
    }

    void enqueuePatient(int patientId) {

        PatientRecord pr = getPatientRecord(patientId);

        pQueue.add(pr);

    }

    void nextPatient(){

        PatientRecord pr = pQueue.peek();

        System.out.println();
        System.out.println("Next Patient in queue: " + pr.toString());

        dequeuePatient(pr.getpId());
    }

    void dequeuePatient(int patientId) {

        PatientRecord pr = getPatientRecord(patientId);
        if(pQueue.contains(pr)){
            pQueue.remove(pr);
        }

    }

    void displayQueue(){

        Object[] arr = pQueue.toArray();
        System.out.println();
        System.out.println("Patient Consultation Queue in order: ");
        System.out.println();

        int seqNo;
        for (int i = 0; i < arr.length; i++){

            seqNo = i +1;

            PatientRecord patient = (PatientRecord) arr[i];

            System.out.println( seqNo + ": "
                    + patient.getpId() + ", "
                    + patient.getpName() + ", "
                    + patient.getpAge()
            );
    }

}

}
