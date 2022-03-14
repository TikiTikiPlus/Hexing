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
            String st = String.format("%8s",Integer.toBinaryString(b&0XFF)).replace(' ', '0');
            System.out.println(st);
            if(fullBytes!="")
            {
                fullBytes+=","+st;
            }
            else
            {
                fullBytes += st;
            }
        }
        String[] arrayFullBytes = fullBytes.split(",",-1);
        String fullWord="";
        for(String s: arrayFullBytes)
        {
            long binaryBytes = Long.parseLong(s);
            int decimalBytes = binaryToDecimal(binaryBytes);
            String fullHex = decimalToHex(decimalBytes);
            fullWord+=fullHex;
            System.out.println(fullWord);
            System.out.println(s);
        }
        File byteFile = new File("byteOf"+args[0]);
        byteFile.createNewFile();
        FileWriter writer = new FileWriter(byteFile);
        writer.write(fullWord);
        writer.flush();
        writer.close();
        System.out.println("\n"+fullWord);
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
    static int binaryToDecimal(long binary)
    {
        int decimalNumber = 0, i=0;
        while(binary>0)
        {
            decimalNumber += Math.pow(2,i++)*(binary%10);
            binary /= 10;
        }
        return decimalNumber;
    }
    static String decimalToHex(int binaryText)
    {
        String hexa = Integer.toHexString(binaryText);
        hexa = hexa.toUpperCase();
        return hexa;
    }
}