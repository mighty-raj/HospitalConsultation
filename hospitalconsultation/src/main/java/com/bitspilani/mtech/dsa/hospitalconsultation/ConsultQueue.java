package com.bitspilani.mtech.dsa.hospitalconsultation;

import sun.awt.geom.AreaOp;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ConsultQueue {

    // Creating empty priority queue
    //PriorityQueue<PatientRecord> pQueue = new PriorityQueue<PatientRecord>(Collections.reverseOrder());

    PriorityQueue<PatientRecord> pQueue = new PriorityQueue<PatientRecord>(new Comparator<PatientRecord>() {
        public int compare(PatientRecord a, PatientRecord b) {
            return b.getpAge() - a.getpAge();
        }
    });

    PatientRecord getPatientRecord(int patientId) {

        PatientRecord pr = null;
        return pr;
    }

    void enqueuePatient(int patientId) {

        PatientRecord pr = getPatientRecord(patientId);

        pQueue.add(pr);

    }

    void nextPatient(){
        System.out.println();
        System.out.println("Next Patient in queue: " + pQueue.peek());
        dequeuePatient(0000);
    }

    void dequeuePatient(int patientId) {

        PatientRecord pr = getPatientRecord(patientId);
        if(pQueue.contains(pr)){
            pQueue.remove(pr);
        }

    }

    void displayQueue(){

        Object[] arr = pQueue.toArray();
        System.out.println("Value in array: ");

        int seqNo = 1;
        for (int i = 0; i < arr.length; i++){

            seqNo+=i;
            System.out.println( seqNo + ": " + arr[i].toString());
    }

}

}
