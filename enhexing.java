import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.nio.file.Files;
class enhexing
{
    public static void main(String[] args)
    {
        try
        {
        File path = new File("Files/"+args[0]);
        byte[] array = turnBytes(path);
        String fullBytes="";
        for(byte b : array)
        {
            String st = String.format("%02X",b);
            fullBytes+=st;
        }
        File byteFile = new File("byteOf"+args[0]);
        byteFile.createNewFile();
        FileWriter writer = new FileWriter(byteFile);
        writer.write(fullBytes);
        writer.flush();
        writer.close();
        System.out.println("\n"+fullBytes);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    static byte[] turnBytes(File file) throws IOException
    {
        FileInputStream fis = new FileInputStream(file);
        byte[] arr = new byte[(int)file.length()];
        fis.read(arr);
        fis.close();
        return arr;
    }
}