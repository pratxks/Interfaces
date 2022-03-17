import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister
{
    private static ArrayList<String> wordListArray = new ArrayList<>();

    private static Filter MyShortWordFilter = new ShortWordFilter();

    public static void ReadFileDataToArrayList()
    {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String strLine = "";
        wordListArray.clear();

        try
        {
            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                // Finally we can read the file LOL!
                int line = 0;
                while(reader.ready())
                {
                    strLine = reader.readLine();

                    String [] CSVArray = strLine.split(" ");

                    for(String Word : CSVArray)
                    {
                        wordListArray.add(Word.trim());
                    }
                }

                reader.close(); // must close the file to seal it and flush buffer
                //System.out.println("\n\nData file read!");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> collectAll()
    {
        ArrayList<String> shortWordArray = new ArrayList<>();

        for(String Word : wordListArray)
        {
            boolean bAccepted = MyShortWordFilter.accept(Word);

            if(bAccepted) shortWordArray.add(Word);
        }

        return shortWordArray;
    }

    public static void main(String[] args)
    {
        ReadFileDataToArrayList();

        ArrayList<String> shortWordArray = collectAll();

        String DisplayShortWords = "";

        for(String ShortWord : shortWordArray)
        {
            DisplayShortWords += "(" + ShortWord + ")";
        }

        System.out.println("Strings less than length of 5 chars are:\n" + DisplayShortWords);
    }
}
