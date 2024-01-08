package utils;

public class Utils {
    public static String getRootDir(){
        return System.getProperty("user.dir")+"/";
    }

    public static String getDataDir(){
        return System.getProperty("user.dir")+"/data/";
    }
}