import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.*;

public class DuplicateCounter
{	
	//  Declaring instance variable 
	Integer wordCounter = 0;
	// Stores strings and integers into a map
	HashMap<String,Integer> map = new HashMap<>();

	public void count(String dataFile)
	{
		try
		{	// Reads in the file using scanner while != null
			Scanner inputText = new Scanner(new File(dataFile));
			while(inputText.hasNextLine())
			{	
				// Reads in a line and splits using space
				String[] info = inputText.nextLine().split(" ");
				for(String word : info)
				{	
					// Converts the word to uppercase
					wordCounter = map.get(word.toUpperCase());
					// If the word counter is null, it becomes 1
					if(wordCounter == null)
					{
						wordCounter = 1;
					}
					// Otherwise it adds 1 to itself
					else
						wordCounter++;
					// Stores the word and iterations of that word into a map
					map.put(word.toUpperCase(), wordCounter);
				}
			}
			// Closes the scanner
			inputText.close();
		}
		// Exception catcher, terminates if caught
		catch(IOException exception)
		{
			System.out.println("You silly goose, something went wrong!");
			System.exit(0);
		}
	}

	public void write(String outputFile)
	{
		try
		{	
			// Creates/overwrites a file
			FileWriter newFile = new FileWriter(new File(outputFile));
			// Loops through the map
			for(Map.Entry<String, Integer> count : map.entrySet())
			{	
				// Transfers the map into the outputFile
				newFile.write(count.getKey() + "\t" + count.getValue() + "\n");
			}
			// Closes the FileWriter
			newFile.close();
		// Exception Catcher, terminates if caught
		}catch(IOException exception)
		{
			System.out.println("You silly goose, something went wrong!");
			System.exit(0);
		}
	}
}