package com.lockers;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileOperations {
	
	public static void RecursivePrint(File[] arr,int index,int level) 
    {
        // terminate condition
        if(index == arr.length)
            return;
        // tabs for internal levels
        for (int i = 0; i < level; i++)
            System.out.print("\t");
          
        // for files
        if(arr[index].isFile())
            System.out.println("File:" +arr[index].getName());
          
        // for sub-directories
        else if(arr[index].isDirectory())
        {
            System.out.println("Subdirectory: [" + arr[index].getName() + "]");
              
            // recursion for sub-directories
            RecursivePrint(arr[index].listFiles(), 0, level + 1);
        }
           
        // recursion for main directory
        RecursivePrint(arr,++index, level);
   }

	public static void createFileUsingFileClass(String fileName) throws IOException
    {
          File file = new File(fileName);
          //Create the file
          if (file.createNewFile()){
            System.out.println("File is added!");
            //Write Content
	          FileWriter writer = new FileWriter(file);
	          System.out.println("Type Yes to write content to the file:");
	          Scanner s=new Scanner(System.in);
	          String response=s.next();
	          if(response.equals("Yes")||response.equals("yes")||response.equals("YES"))
	          {
	          System.out.println("Enter File Content:");
	          Scanner sc=new Scanner(System.in);
	          writer.write(sc.nextLine());
	          writer.close();
	          }
	          else
	          {
	        	  System.out.println("File content not written.");
	          }
          	}
          else{
            System.out.println("File already exists.");
          }
    }
	public static List<String> readFileInList(String fileName) 
	  { 
		  
	    List<String> lines = Collections.emptyList(); 
	    try
	    { 
	      lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8); 
	    } 
	  
	    catch (IOException e) 
	    { 
	    	System.err.println(e.getMessage());
	    } 
	    return lines; 
	  } 
	public static void delete(String filename)
	{
	boolean a;
	try {
		a = Files.deleteIfExists(Paths.get(filename));
	  	if (a == true)
       	{
       		System.out.println(filename + "-Deleted Successfully.");
       	}
       	else
       	{
       		System.out.println("File not Found");
       	}
	} catch (IOException e) {
		System.err.println(e.getMessage());
	}
	}

	public static void search(String filename2) {
		File file = new File(filename2);
        try {
			if (file.createNewFile()== false)
				{
				System.out.println("File found in application");
				System.out.println("Want to read the content of the file? Type yes or no.");
			    Scanner s1=new Scanner(System.in);
			    String response=s1.next();
			    if(response.equals("Yes")||response.equals("YES")||response.equals("yes")) {} 
			    else if (response.equals("No")||response.equals("NO")||response.equals("no"))
			     	{
			     		System.exit(0); //back to main menu
			     	}
			    else
			     	{
			     		System.err.println("Invalid Input");
			     		System.exit(0);
			     	}
			}
			  else
			     {
			    	 System.out.println("File not Found");
			     }
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} 
        }
}