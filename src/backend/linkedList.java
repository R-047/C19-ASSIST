package backend;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class linkedList{
    public static node patientListHead = null;
    public static node patientListCurrNode = null;
    public static node reportListHead = null;
    public static node reportListCurrNode = null;

    public static class node{
        public String name, gender, DOB, city, ph_no, status; 
        public int PID, age, zip, numCase, numDeaths, activeCases;
        public double recovRate;
        public boolean result;
        public node link;
        public LocalDate date;
        public LocalTime time;
        public LocalDateTime resultDateTime, expiryDateTime, recoveryDateTime;
        node(int in_PID, String in_name, String in_gender, String in_DOB, int in_age, String in_city, int in_zip, String in_status, String in_phno, boolean in_result, LocalDate in_date, LocalTime in_time, LocalDateTime in_resultDT, LocalDateTime in_expiryDT, LocalDateTime in_recoveredDT){
            PID = in_PID;
            name = in_name;
            gender = in_gender;
            DOB = in_DOB;
            city = in_city;
            status = in_status;
            age = in_age;
            zip = in_zip;
            ph_no = in_phno;
            result = in_result;
            date = in_date;
            time = in_time;
            resultDateTime = in_resultDT;
            expiryDateTime = in_expiryDT;
            recoveryDateTime = in_recoveredDT;
            link = null;

        }

        node(String in_city, int in_numCases, int in_activecases, int in_numDeaths, double in_recovRate){
            city = in_city;
            numCase = in_numCases;
            activeCases = in_activecases;
            numDeaths = in_numDeaths;
            recovRate = in_recovRate;
            link = null;
        }

    }

        

    public void loadList(int in_PID, String in_name, String in_gender, String in_DOB, int in_age, String in_city, int in_zip, String in_status, String in_phno, boolean in_result, LocalDate in_date, LocalTime in_time, LocalDateTime in_resultDT, LocalDateTime in_expiryDT, LocalDateTime in_recoveredDT){
        node newNode = new node(in_PID, in_name, in_gender, in_DOB, in_age, in_city, in_zip, in_status, in_phno, in_result, in_date, in_time, in_resultDT, in_expiryDT, in_recoveredDT);
        if(patientListHead == null){
            patientListHead = newNode;
            patientListCurrNode = patientListHead;
        }
        else{
            patientListCurrNode.link = newNode;
            patientListCurrNode = newNode;
        }
    }

  

   public void loadlist(String in_city, int in_numCases, int in_activecases, int in_numDeaths, double in_recovRate){
        node newNode = new node(in_city, in_numCases, in_activecases, in_numDeaths, in_recovRate);
        if(reportListHead == null){
            reportListHead = newNode;
            reportListCurrNode = reportListHead;
        }
        else{
            reportListCurrNode.link = newNode;
            reportListCurrNode = newNode;
        }
    }


    public static int getTotalPatients(){
        linkedList.node pointer = patientListHead;
        int count = 0;
        while(pointer != null){
            count++;
            pointer = pointer.link;
        }
        return count;
    }

    
}