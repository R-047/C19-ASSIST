package backend;

import java.io.*;

public class report {

   static  boolean check(String location, String filename){
        String line;
        try{
            FileInputStream fin = new FileInputStream(filename);
            InputStreamReader in = new InputStreamReader(fin);
            BufferedReader br = new BufferedReader(in);
            while((line = br.readLine()) != null){
                if(line.equals(location)){
                    return true;
                }
             }
             br.close();
            }catch(Exception e){System.out.println(e);}
            return false;
        }


    public static void autoFormulatedLocationDB(String location){
        String filename = "/home/rohith/Desktop/C19-ASSIST/LocationsDB.txt";//createFiles.LOCATIONDBfilename;
        if(!check(location, filename)){
            CSVwriter.awriter(location, filename);
        }
    }




    public void Summary(){
        linkedList ls = new linkedList();
        linkedList.reportListHead = null;
        linkedList.reportListCurrNode = null;
        linkedList.node PatientListpointer = linkedList.patientListHead;
        String in_city;
        int in_numCases = 0, in_numDeaths = 0, in_activecases = 0;
        double in_recovRate, totalRecCase = 0;
        String filename = "/home/rohith/Desktop/C19-ASSIST/LocationsDB.txt", line;
        try {
            FileInputStream fin = new FileInputStream(filename);
            InputStreamReader in = new InputStreamReader(fin);
            BufferedReader br = new BufferedReader(in);
            boolean bit = false;
            while ((line = br.readLine()) != null) {
                in_city = line;
                while (PatientListpointer != null) {
                    if (line.equals(PatientListpointer.city) && (PatientListpointer.status != null) && (PatientListpointer.status.equals("Active") || PatientListpointer.status.equals("Expired") || PatientListpointer.status.equals("Recovered"))) {

                        bit = true;
                            in_numCases++;
                        if(PatientListpointer.status.equals("Active")){
                            in_activecases++;
                        }
                        if(PatientListpointer.status.equals("Expired")){
                            in_numDeaths++;
                        }
                        if(PatientListpointer.status.equals("Recovered")){
                            totalRecCase++;
                        }
                    }
                    PatientListpointer = PatientListpointer.link;
                }
                PatientListpointer = linkedList.patientListHead;
                if(bit){
                in_recovRate = (totalRecCase/in_numCases)*100;
                ls.loadlist(in_city, in_numCases, in_activecases, in_numDeaths, in_recovRate);
                in_numCases = 0; in_numDeaths = 0; totalRecCase = 0;in_recovRate = 0;in_activecases = 0;
                }
                bit = false;
            }
            br.close();
        }catch(Exception e){System.out.println(e);}
    }
}
