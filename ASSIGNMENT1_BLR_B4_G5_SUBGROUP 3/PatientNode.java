package com.bitspilani.mtech.dsa.hospitalconsultation;

public class PatientNode {

    protected PatientRecord patient;
    protected PatientNode next, prev;

    /* Constructor */
    public PatientNode()
    {
        next = null;
        prev = null;
        patient = null;
    }

    /* Constructor */
    public PatientNode(PatientRecord pat, PatientNode nxt, PatientNode prv)
    {
        patient = pat;
        next = nxt;
        prev = prv;
    }

    /* Function to set link to next node */
    public void setLinkNext(PatientNode n)
    {
        next = n;
    }

    /* Function to set link to previous node */
    public void setLinkPrev(PatientNode p)
    {
        prev = p;
    }


    /* Funtion to get link to next node */
    public PatientNode getLinkNext()
    {
        return next;
    }

    /* Function to get link to previous node */
    public PatientNode getLinkPrev()
    {
        return prev;
    }

    /* Function to set data to node */
    public void setPatient(PatientRecord pat)
    {
        patient = pat;
    }
    /* Function to get data from node */
    public PatientRecord getPatient()
    {
        return patient;
    }

}
