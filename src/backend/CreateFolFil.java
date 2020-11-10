package backend;

import java.io.File;



public class CreateFolFil {
  public static  void createFolder() throws Exception{
        File folder = new File(System.getProperty("user.home")+"/C19-ASSIST");
        System.out.println(folder.mkdir());
    }

   public static  void createFile() throws Exception{
        File file1 =  new File("/home/rohith/C19-ASSIST/AutoGenPid.txt");
        if(file1.createNewFile()){
            new CSVwriter("/home/rohith/C19-ASSIST/AutoGenPid.txt").writer("100000");
        }
        File file2 = new File("/home/rohith/C19-ASSIST/LocationsDB.txt");
        System.out.println(file2.createNewFile());

        File file3 = new File("/home/rohith/C19-ASSIST/PatientDetails.csv");
        System.out.println(file3.createNewFile());

        File file4 = new File("/home/rohith/C19-ASSIST/Report.txt");
        System.out.println(file4.createNewFile());

        File file5 = new File("/home/rohith/C19-ASSIST/userIDs.txt");
        System.out.println(file5.createNewFile());
        
    }
}
