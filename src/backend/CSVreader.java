package backend;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.apache.commons.csv.*; 

public class CSVreader{
    public void readPatientsfile(String filename){
        try{
        	
            linkedList ls = new linkedList();
            Reader in = new FileReader(filename);
            Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
            for (CSVRecord record : records){
                int in_PID = Integer.parseUnsignedInt(record.get(0));
                String in_name = record.get(1);
                String in_gender = record.get(2);
                String in_DOB = record.get(3);
                int in_age = Integer.parseInt(record.get(4));
                String in_city = record.get(5);
                report.autoFormulatedLocationDB(in_city);
                int in_zip = Integer.parseInt(record.get(6));
                String in_status = record.get(7);
                String in_phno = record.get(8);
                Boolean in_result = Boolean.parseBoolean(record.get(9));
                LocalDate in_date = LocalDate.parse(record.get(10));
                LocalTime in_time = LocalTime.parse(record.get(11));
                LocalDateTime in_resultDT = null, in_expiryDT = null, in_recoveredDT = null;
                if(!record.get(12).equals("null")){
                    in_resultDT = LocalDateTime.parse(record.get(12));
                }
                if(!record.get(13).equals("null")){
                    in_expiryDT = LocalDateTime.parse(record.get(13));
                }
                if(!record.get(14).equals("null")){
                    in_recoveredDT = LocalDateTime.parse(record.get(14));
                }
               
                ls.loadList(in_PID, in_name, in_gender, in_DOB, in_age, in_city, in_zip, in_status, in_phno, in_result, in_date, in_time, in_resultDT, in_expiryDT, in_recoveredDT);
                
            }
            System.out.println("hi");
            
        }catch(Exception e){System.out.println(e);}
      

    }

    public static boolean readIDfile(String filename, String username, String password){
        boolean exist = false;
        try{
            Reader in = new FileReader(filename);
            Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
            for (CSVRecord record : records){
                if(record.get(0).equals(username) && record.get(1).equals(password)){
                    exist = true;
                }
                
            }
            System.out.println("check done");
            
        }catch(Exception e){System.out.println(e);}

        return exist;
    }


}