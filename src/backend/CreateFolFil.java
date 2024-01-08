package backend;

import java.io.File;

import MyPackages.FileIO;
import utils.Utils;



public class CreateFolFil {
  public static  void createFolder() throws Exception{
        File folder = new File(Utils.getRootDir()+"data");
        System.out.println(folder.mkdir());
    }

   public static  void createFile() throws Exception{
        File file1 =  new File(Utils.getDataDir()+"AutoGenPid.txt");
        if(file1.createNewFile()){
            System.out.println("initializing pid file");
            FileIO fo = new FileIO();
            fo.writeBits(Utils.getDataDir()+"AutoGenPid.txt", 100000);
        }
        File file2 = new File(Utils.getDataDir()+"LocationsDB.txt");
        System.out.println(file2.createNewFile());

        File file3 = new File(Utils.getDataDir()+"PatientDetails.csv");
        System.out.println(file3.createNewFile());

        File file4 = new File(Utils.getDataDir()+"Report.txt");
        System.out.println(file4.createNewFile());

        File file5 = new File(Utils.getDataDir()+"userIDs.txt");
        System.out.println(file5.createNewFile());
        
    }
}
