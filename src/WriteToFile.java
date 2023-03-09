import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile
{


    public static void writeData(String result1, String result2, String result3, String result4)
    {
        try
        {
            String toStore = "Your bmiIndex is " + result1 + " your blood pressure is " + result2 + " hearing " + result3 + " vision " + result4;

            FileWriter myWriter = new FileWriter("C:\\Users\\joeny\\Desktop\\myData.txt");

            myWriter.write(toStore);
            myWriter.close();

            System.out.println("Succes in writing file");


        }
        catch (IOException e)
        {
            System.out.println("An error occured");
            e.printStackTrace();
            throw new RuntimeException(e);

        }
    }


}
