package MyPackages;
import java.io.*;
public class FileIO
{
  public int readBits(String filename)
  {
    int bit_value = 0;
    try
    {
    
    FileInputStream fin = new FileInputStream(filename);
    InputStreamReader in = new InputStreamReader(fin);
    BufferedReader br = new BufferedReader(in);
    String line = br.readLine();
    bit_value = Integer.parseInt(line);

    fin.close();
    }catch(Exception e){System.out.println(e);}
    
    
    return bit_value;

  }
  
  
  
  public void writeBits(String filename, int bit_value)
  {
    try{    
             FileOutputStream fout=new FileOutputStream(filename);  
             String line = Integer.toString(bit_value) ;
             byte[] strToBytes = line.getBytes();
             fout.write(strToBytes);  
             fout.close();       
            }catch(Exception e){System.out.println(e);}    
   }


  public void filetoarray(String filename, String[] arr)
   {
    try{
      int i = 0;
    FileInputStream fin = new FileInputStream(filename);
    InputStreamReader in = new InputStreamReader(fin);
    BufferedReader br = new BufferedReader(in);
    String line;

    while((line = br.readLine())!=null)
    {
      arr[i] = line;
      i++;
    }
    }catch(Exception e){System.out.println(e);}
   }

  public void filetoarray(String filename, int[] arr)
   {
    try{
    int i = 0;
    FileInputStream fin = new FileInputStream(filename);
    InputStreamReader in = new InputStreamReader(fin);
    BufferedReader br = new BufferedReader(in);
    String line;
    while((line = br.readLine())!=null)
    {
      arr[i] = Integer.parseInt(line);
      i++;
    }
    }catch(Exception e){System.out.println(e);}
   }
   



  public void arraytofile(String filename, String arr[], int endingpoint)
   {
     try{
    int i = 0;
    FileOutputStream fos =  new FileOutputStream(filename);
    OutputStreamWriter os = new OutputStreamWriter(fos);
    BufferedWriter bw = new BufferedWriter(os);
    for(i=0;i<endingpoint;i++)
    {
      bw.write(arr[i]);
      bw.newLine();
    }
    bw.close();
    }catch(Exception e){System.out.println(e);}
    
  }


  public void arraytofile(String filename, int[] arr, int endingpoint)
   {
     try{
    int i = 0;
    FileOutputStream fos =  new FileOutputStream(filename);
    OutputStreamWriter os = new OutputStreamWriter(fos);
    BufferedWriter bw = new BufferedWriter(os);
    for(i=0;i<endingpoint;i++)
    {
      bw.write(Integer.toString(arr[i]));
      bw.newLine();
    }
    bw.close();
    }catch(Exception e){System.out.println(e);}
    
  }



  public void reset(String filename)
  {
  try
  {
   FileOutputStream fos = new FileOutputStream(filename);
   fos.close();
  }catch(Exception e){System.out.println(e);}
  }

 
}
