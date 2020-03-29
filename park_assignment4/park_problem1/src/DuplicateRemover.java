import java.io.FileWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class DuplicateRemover
{   
    // Stores strings into Sets which does not hold duplicate words
    Set<String> uniqueWords = new HashSet<>();

    public void remove(String dataFile) 
    {
        try 
        {   // Reads in the file using scanner while != null
            Scanner inputText = new Scanner(new File(dataFile));
            while(inputText.hasNextLine())
            {   
                // Reads in a line and splits using space
                String[] words=inputText.nextLine().split(" "); 
                for(int i = 0; i < words.length; i++) 
                {   
                    // Converts text into uppercase and Adds to the set
                    String specialWord = words[i].toUpperCase();
                    uniqueWords.add(specialWord);
                }
            }
            // Closes the scanner
            inputText.close();
        }
        // Exception catcher, terminates if caught
        catch(IOException exception)
        {
            System.out.println("You silly goose, something went wrong! " + exception);
            System.exit(0);
        }
    }

    public void write(String outputFile)
    {
        try 
        {   
            // Creates/overwrites the file
            FileWriter newFile = new FileWriter(outputFile);    
            // Loops through the set 
            for(String uniqueWord : uniqueWords)
            {   
                // transfers the set into the outputFile
                newFile.write(uniqueWord);
                newFile.write("\n");
            } 
            // Closes the FileWriter
            newFile.close();
        }
        // Exception Catcher, terminates if caught
        catch(IOException exception)
        {
            System.out.println("You silly goose, something went wrong! " + exception);
            System.exit(0);
        }
    }
}
