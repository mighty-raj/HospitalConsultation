package com.bitspilani.mtech.dsa.hospitalconsultation;

public class DoublyLinkedList {

    protected PatientNode start;
    protected PatientNode end ;
    public int size;

    /* Constructor */
    public DoublyLinkedList()
    {
        start = null;
        end = null;
        size = 0;
    }

    /* Function to check if list is empty */
    public boolean isEmpty()
    {
        return start == null;
    }

    /* Function to get size of list */
    public int getSize()
    {
        return size;
    }

    /* Function to insert element at begining */
    public void insertAtStart(PatientRecord pat)
    {
        PatientNode nptr = new PatientNode(pat, null, null);
        if(start == null)
        {
            start = nptr;
            end = start;
        }
        else
        {
            start.setLinkPrev(nptr);
            nptr.setLinkNext(start);
            start = nptr;
        }
        size++;
    }

    /* Function to insert element at end */
    public void insertAtEnd(PatientRecord pat)
    {
        PatientNode nptr = new PatientNode(pat, null, null);
        if(start == null)
        {
            start = nptr;
            end = start;
        }
        else
        {
            nptr.setLinkPrev(end);
            end.setLinkNext(nptr);
            end = nptr;
        }
        size++;
    }


    /* Function to insert element at position */
    public void insertAtPos(PatientRecord pat , int pos)
    {
        PatientNode nptr = new PatientNode(pat, null, null);
        if (pos == 1)
        {
            insertAtStart(pat);
            return;
        }
        PatientNode ptr = start;
        for (int i = 2; i <= size; i++)
        {
            if (i == pos)
            {
                PatientNode tmp = ptr.getLinkNext();
                ptr.setLinkNext(nptr);
                nptr.setLinkPrev(ptr);
                nptr.setLinkNext(tmp);
                tmp.setLinkPrev(nptr);
            }
            ptr = ptr.getLinkNext();
        }
        size++ ;
    }

    /* Function to delete node at position */
    public void deleteAtPos(int pos)
    {
        if (pos == 1)
        {
            if (size == 1)
            {
                start = null;
                end = null;
                size = 0;
                return;
            }
            start = start.getLinkNext();
            start.setLinkPrev(null);
            size--;
            return ;
        }
        if (pos == size)
        {
            end = end.getLinkPrev();
            end.setLinkNext(null);
            size-- ;
        }
        PatientNode ptr = start.getLinkNext();
        for (int i = 2; i <= size; i++)
        {
            if (i == pos)
            {
                PatientNode p = ptr.getLinkPrev();
                PatientNode n = ptr.getLinkNext();

                p.setLinkNext(n);
                n.setLinkPrev(p);
                size-- ;
                return;
            }
            ptr = ptr.getLinkNext();
        }
    }

    public PatientRecord getPatientRecord(int patientId) {

        PatientRecord pr = null;

        if (size == 0) {
            System.out.print("List is Empty\n");
            return null;
        }

        PatientNode ptr = start;

        if (ptr.patient.getpId() == patientId) {
            pr = ptr.patient;
        }

        ptr = start.getLinkNext();
        while (ptr.getLinkNext() != null) {

            if (ptr.patient.getpId() == patientId)
                pr = ptr.patient;

            ptr = ptr.getLinkNext();
        }

        if (ptr.patient.getpId() == patientId)
            pr= ptr.patient;

        return pr;
    }

    /* Function to display status of list */
    public void display()
    {
        System.out.print("\nPatient List = ");
        if (size == 0)
        {
            System.out.print("empty\n");
            return;
        }
        if (start.getLinkNext() == null)
        {
            System.out.println(start.getPatient() );
            return;
        }

        PatientNode ptr = start;
        System.out.print(start.getPatient()+ " <-> ");
        ptr = start.getLinkNext();
        while (ptr.getLinkNext() != null)
        {
            System.out.print(ptr.getPatient()+ " <-> ");
            ptr = ptr.getLinkNext();
        }
        System.out.print(ptr.getPatient()+ "\n");
    }


}
