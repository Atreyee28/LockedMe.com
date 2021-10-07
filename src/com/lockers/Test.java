package com.lockers;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Test {
	void showMainMenu() {
        System.out.println("--------Main Menu--------"); //showing the main menu
		System.out.println("1. View the list of files inside current directory \n2. View UI options \n3. Exit from Application");
		System.out.println("Enter your choice:");
        try{
            Scanner s1 = new Scanner(System.in);
            int option = s1.nextInt();
            switch (option){
                case 1 : {
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
                    showMainMenu();
                }
                case 2 : {
                    showSubMenu();
                }
                case 3 : {
                    System.out.println("Thank You. End of application.");
                    System.exit(0);
                }
                default:
                	System.out.println("Invalid Input. Showing main menu...");
                	showMainMenu();
            }
        }
        catch (Exception e){
            System.out.println("Please enter 1, 2 or 3");
            showMainMenu();
        }
    }
	void showSubMenu() {
		System.out.println("A. Add a file \nB. Delete a specific file \nC. Search for a specific file \nD. Main Memu ");
    	System.out.println("Enter your choice:");
            Scanner s2 = new Scanner(System.in);
            String c= s2.next();
            switch (c){
                case "A" : 
                {
                	Scanner s3=new Scanner(System.in);
        			System.out.println("Enter File Name:");
        	        String filename=s3.next();
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
                case "B" : 
                	{
    	    		Scanner s4=new Scanner(System.in);
    		    	System.out.println("Enter the File Name to be deleted:");
    		    	String filename1=s4.next();
    		    	FileOperations.delete(filename1);
    		    	break;
    		    	}
                case "C" : 
                    {
            	    	Scanner s4= new Scanner (System.in);
            	    	System.out.println("Enter the file name to be searched:");
            	    	String filename2=s4.next();
            	    	FileOperations.search(filename2);
            	    	List l1 = FileOperations.readFileInList(filename2); 
            		    Iterator<String> itr1 = l1.iterator(); 
            		    while (itr1.hasNext()) 
            		    	{
            		    	System.out.println("The content of the file is:"+itr1.next()); 	
            		    	}
            	    	break;
            	    	}
                case "D" : {
                    System.out.println("Showing main menu");
                    showMainMenu();
                    break;
                }
                default :
                	System.out.println("Invalid Input. Please enter A, B, C or D");
            }
            showSubMenu();
        }
	public static void main(String args[])
	{
		System.out.println("*****************************");
		System.out.println("Welcome to LockedMe.com!");
        System.out.println("*****************************");
        System.out.println("Developed by: Atreyee Mondal");
        Test obj= new Test();
        obj.showMainMenu();
	}
}