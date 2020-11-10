package backend;

import java.io.*;

public class CSVwriter{

    static FileOutputStream fos = null;
    static OutputStreamWriter os =null;
    static BufferedWriter bw = null;

    public  CSVwriter(String filename){
        try{
            fos =  new FileOutputStream(filename);
            os = new OutputStreamWriter(fos);
            bw = new BufferedWriter(os);
         }catch(Exception e){System.out.println(e);}
    }
    
     public void writeToPatientsFile(){
        linkedList.node pointer = linkedList.patientListHead;
        while(pointer != null){
            String line = pointer.PID+","+pointer.name+","+pointer.gender+","+pointer.DOB+","+pointer.age+","+pointer.city+","+pointer.zip+","+pointer.status+","+pointer.ph_no+","+pointer.result+","+pointer.date+","+pointer.time+","+pointer.resultDateTime+","+pointer.expiryDateTime+","+pointer.recoveryDateTime;
            writer(line);
            pointer = pointer.link;
        }
        try{
            bw.close();
        }catch(Exception e){System.out.println(e);}

    }


    public void writeToCovidFile(){
        linkedList.node pointer = linkedList.patientListHead;
        while(pointer != null){
            if(pointer.result){
                String line = pointer.PID+","+pointer.name+","+pointer.gender+","+pointer.DOB+","+pointer.city+","+pointer.status+","+pointer.age+","+pointer.zip;
                writer(line);
            }
            
            pointer = pointer.link;
        }
        try{
            bw.close();
        }catch(Exception e){System.out.println(e);}
    }


    public void writeToReportFile(){
        linkedList.node pointer = linkedList.reportListHead;
        while(pointer != null){
            if(pointer.result){
                String line = pointer.city+","+pointer.numCase+","+pointer.activeCases+","+pointer.numDeaths+","+pointer.recovRate;
                writer(line);
            }
            pointer = pointer.link;
        }
        try{
            bw.close();
        }catch(Exception e){System.out.println(e);}
    }

    

    public void writer(String line){
        try{
            bw.write(line);
            bw.newLine();
        }catch(Exception e){System.out.println(e);}
    }

    static void awriter(String line, String filename){
        try{
            FileOutputStream fos =  new FileOutputStream(filename, true);
            OutputStreamWriter os = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(os);
            bw.write(line);
            bw.newLine();
            bw.close();
        }catch(Exception e){System.out.println(e);}
    }
    

}
