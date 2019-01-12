package com.bitspilani.mtech.dsa.hospitalconsultation;

import java.io.*;

public class HospitalConsultation {

    DoublyLinkedList patientDList;
    ConsultQueue cq;

    public static void main(String[] args) {

        String inpFilePath = args[0];
        String outFilePath = args[1];

        if(args.length != 2){
            System.out.println("Please pass req. arguments, input file path and output file path");
            System.exit(-1);
        }

        HospitalConsultation hc = new HospitalConsultation();
        hc.patientDList = new DoublyLinkedList();
        hc.cq = new ConsultQueue(hc.patientDList, outFilePath);

        hc.readInput(inpFilePath);

        //Printing Consultation queue to console
        System.out.println();
        System.out.println("Size of Consult Queue: " + hc.patientDList.size);
        hc.cq.displayQueue();


        //Testing Dequeing a patient

        long dequeStartTime = System.nanoTime();
        hc.cq.dequeuePatient(113);
        long dequeEndTime = System.nanoTime();
        long totalDequeTime = dequeEndTime - dequeStartTime;
        System.out.println();
        System.out.println("Deque Time 113: " + totalDequeTime + " nano secs");


        long displayQueueStartTime = System.nanoTime();
        hc.cq.displayQueue();
        long displayQueueEndTime = System.nanoTime();
        long totalDispQTime = displayQueueEndTime - displayQueueStartTime;
        System.out.println("Display queue Time: " + totalDispQTime + " nano seconds");


        //Testing Next Patient
        hc.cq.nextPatient();
        hc.cq.displayQueue();

        hc.writeToFile();

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

    public void readInput(String inpFile){

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(inpFile))) {
            String line = bufferedReader.readLine();


            while(line != null) {
                //System.out.println(line);
                String[] lineSplit = line.split(",");

                int a = registerPatient(lineSplit[0], Integer.parseInt(lineSplit[1].trim()));

                long enqueStartTime = System.nanoTime();
                cq.enqueuePatient(a);
                long enqueEndTime = System.nanoTime();
                long totalEnqueTime = enqueEndTime - enqueStartTime;
                System.out.println("Enque Time " + a + ": " + totalEnqueTime + " nano secs");

                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found: " + inpFile);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeToFile(){

        try {

            cq.writeToFile();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
