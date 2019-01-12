package com.bitspilani.mtech.dsa.hospitalconsultation;

import sun.awt.geom.AreaOp;

import java.io.*;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ConsultQueue {

    // Creating empty priority queue
    //PriorityQueue<PatientRecord> pQueue = new PriorityQueue<PatientRecord>(Collections.reverseOrder());

    PriorityQueue<PatientRecord> pQueue;
    DoublyLinkedList patientList;
    File file;

    public ConsultQueue(DoublyLinkedList plist, String filePathWithName) {

        pQueue = new PriorityQueue<PatientRecord>(new Comparator<PatientRecord>() {
            public int compare(PatientRecord a, PatientRecord b) {
                return b.getpAge() - a.getpAge();
            }
        });
        patientList = plist;
        file = new File (filePathWithName);

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

    void displayQueue() {

        Object[] arr = pQueue.toArray();
        System.out.println();
        System.out.println("Patient Consultation Queue in order: ");
        System.out.println();

        int seqNo;
        for (int i = 0; i < arr.length; i++){

            seqNo = i +1;

            PatientRecord patient = (PatientRecord) arr[i];

            String patientInfo = seqNo + ": "
                    + patient.getpId() + ", "
                    + patient.getpName() + ", "
                    + patient.getpAge()
                    ;

            System.out.println(patientInfo);

    }

 }

    public void writeToFile() throws IOException {

        Object[] arr = pQueue.toArray();

        int seqNo;

        /*if(file.delete())
        {
            System.out.println("File deleted successfully");
        }
        else
        {
            System.out.println("Failed to delete the file");
            System.exit(-1);
        }*/

        try
        {
            Files.deleteIfExists(Paths.get(file.getAbsolutePath()));
        }
        catch(NoSuchFileException e)
        {
            System.out.println("No such file/directory exists");
        }
        catch(DirectoryNotEmptyException e)
        {
            System.out.println("Directory is not empty.");
        }
        catch(IOException e)
        {
            System.out.println("Invalid permissions.");
        }

        for (int i = 0; i < arr.length; i++) {

            seqNo = i + 1;

            PatientRecord patient = (PatientRecord) arr[i];

            String patientInfo = seqNo + ": "
                    + patient.getpId() + ", "
                    + patient.getpName() + ", "
                    + patient.getpAge() + "\n";

            try {

                BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
                out.write(patientInfo);
                out.close();
            } catch (FileNotFoundException e) {
                System.out.println("File Not Found: " + file.getPath());
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
