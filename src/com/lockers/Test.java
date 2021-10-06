package com.lockers;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		//Welcome the user and show the application name
		System.out.println("*****************************");
		System.out.println("Welcome to LockedMe.com!");
        System.out.println("*****************************");
        //while loop is used to navigate back to the main content if user wants.
        while(true)
        {
		System.out.println("--------Main Menu--------"); //showing the main menu
		System.out.println("1. View the list of files inside current directory \n2. View UI options \n3. Exit from Application");
		System.out.println("Enter your choice:"); //prompt the user to enter choice from the menu
		Scanner sc=new Scanner(System.in);
		String ch=sc.next();
		if(ch.equals("1"))
		{
			//showFilesinascendingorder
			String maindirpath = System.getProperty("user.dir");
            
	        // File object
	        File maindir = new File(maindirpath);
	           
	        if(maindir.exists() && maindir.isDirectory())
	        {
	            // array for files and sub-directories 
	            // of directory pointed by main_directory
	            File arr[] = maindir.listFiles();
	              
	            System.out.println("**********************************************");
	            System.out.println("All Files from current working directory (in ascending order) : " + maindir);
	            System.out.println("**********************************************");
	              
	            // Calling recursive method
	            FileOperations.RecursivePrint(arr,0,0); 
	       }	
	        System.out.println("Press 1 to return to the main menu 0 to exit");
	        Scanner d=new Scanner(System.in);
	        String re=d.next();
	        if(re.equals("0"))
	        {
	        	System.exit(0);
	        }
	        else if (re.equals("1"))
	        {
	        	System.out.println();
	        }
	        else {
	        	System.out.println("Invalid Input. Returning to Main menu..");
	        }
		}
		else if (ch.equals("2"))
				{
	    	//UI options
	    	System.out.println("A. Add a file \nB. Delete a specific file \nC. Search for a specific file ");
	    	System.out.println("Enter your choice:");
	    	Scanner s2=new Scanner(System.in);
	    	String c= s2.next();
	    	switch(c)
	    	{
	    	case "A":
	    	{
	    		//addfiles
	    	Scanner sc1=new Scanner(System.in);
			System.out.println("Enter File Name:");
	        String filename=sc1.next();
	        try {
				FileOperations.createFileUsingFileClass(filename);
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
	        List l = FileOperations.readFileInList(filename); 
		    Iterator<String> itr = l.iterator(); 
		    while (itr.hasNext()) 
		    	{
		    	System.out.println("The content of the file is:"+itr.next()); 	
		    	}
	    	break;
	    	}
	    case "B":
	    	//deleteFiles
	    	{
	    		Scanner sc3=new Scanner(System.in);
	    	System.out.println("Enter the File Name to be deleted:");
	    	String filename1=sc3.next();
	    	FileOperations.delete(filename1);
	    	break;
	    	}
	    case "C":
	    	//searchFiles
	    	{
	    	Scanner sc4= new Scanner (System.in);
	    	System.out.println("Enter the file name to be searched:");
	    	String filename2=sc4.next();
	    	FileOperations.search(filename2);
	    	List l1 = FileOperations.readFileInList(filename2); 
		    Iterator<String> itr1 = l1.iterator(); 
		    while (itr1.hasNext()) 
		    	{
		    	System.out.println("The content of the file is:"+itr1.next()); 	
		    	}
	    	break;
	    	}
	    default:
	    {
	        System.out.println("Invalid Input");
	        break;
	    	}
	    	}System.out.println("Press 1 to return to the main menu 0 to exit");
	        Scanner d=new Scanner(System.in);
	        String re=d.next();
	        if(re.equals("0"))
	        {
	        	System.exit(0);
	        }
	        else if (re.equals("1"))
	        {
	        	System.out.println();
	        }
	        else {
	        	System.out.println("Invalid Input.Showing Main Menu...");
	        }
				}
		//close the application
	    else if(ch.equals("3")) { 
	    	System.exit(0);
	    }else
	    	{
	        System.out.println("Invalid Input. Showing Main menu...");
	    }
        }
	}
}
