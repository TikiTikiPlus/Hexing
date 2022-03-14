import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Paths;
class dehexing
{
    public static void main(String[] args) throws IOException
    {
        try
        {
        String path = new String(args[0]);
        String array = conversion(path);
        byte[] ans = new byte[array.length()/2];
        int i;
        for(i = 0; i<array.length()/2; i++)
        {
            int index = i*2;
            int val = Integer.parseInt(array.substring(index, index+2), 16);
            ans[i]=(byte)val;
        }
        File byteFile = new File("DehexingOf"+args[0]);
        byteFile.createNewFile();
        FileWriter writer = new FileWriter(byteFile);
        for(int a = 0; a < ans.length; a++)
        {
            writer.write(ans[a]);
            System.out.println(ans[a]);   
        }
        writer.flush();
        writer.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    static String conversion(String file) throws IOException
    {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) 
        {
 
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) 
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        }
            catch (IOException e) 
        {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}