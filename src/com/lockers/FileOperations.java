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
	//This function will show all the files in ascending order.
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
	//add user specified files to the existing directory
		public static void createFileUsingFileClass(String fileName) throws IOException
	    {
	          File file = new File(fileName);
	          //Create the file
	          if (file.createNewFile()){
	            System.out.println("File is added!");
	            //Write Content from UI
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
	            //if the file name already exist in the directory,the application will show it.
	        	  System.out.println("File already exists.");
	          }
	    }
		//this function is used to read file contents
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
		//this function is used to delete the user specified file from the existing directory.
		public static void delete(String filename)
		{
		boolean a;
		try {
			a = Files.deleteIfExists(Paths.get(filename));
		  	//if file found in the directory,it will get deleted.
			if (a == true)
	       	{
	       		System.out.println(filename + "-Deleted Successfully.");
	       	}
	       	//if the user specified file is not in the directory it will show file not found.
			else
	       	{
	       		System.out.println("File not Found");
	       	}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		}
		//This function will return the file if found while searching.
		public static void search(String filename) {
	        File folder_name=new File (System.getProperty("user.dir"));
			String[] list = folder_name.list();
	        for (String file: list) {
	            if (filename.equals(file)) {
	                System.out.println("File Found : File " + filename + " exists at " + folder_name);
	                return;
	            }
	        }
	        System.out.println("File not Found");
			     
	    }
}
