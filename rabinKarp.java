import java.io.*;
//import java.io.FileReader;
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
import java.util.*;
//import java.util.Scanner;

public class rabinKarp
{
	public static void main(String[] args)
	{ 
		Vector<Character> list = new Vector<Character>();

		File f = new File("pi.txt");
			try
		{
			list=readLines(f);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		System.out.println("\n\t       Rabin Karp Algorithum\n");
		String fileName="results.txt";
				
		    	String jj = new String();
		    	//input string want to search
		    	Scanner suuu = new Scanner(System.in);
				System.out.println("Enter your string: ");
				jj = suuu.nextLine();

				try
				{    
		           BufferedWriter results=new BufferedWriter(new FileWriter(fileName,true));
		           results.write("\n\t       Rabin Karp Algorithum");
		           results.write("\nSearch results of : "+jj+"\n");
		           results.close();    
		        }
		        catch(Exception e5)
		        {	
		        	System.out.println(e5);
		        }
				
				int vv,uu,countt = 0,dd;
				for(vv = 0; vv < jj.length(); vv++) {
					int yy = (int)jj.charAt(vv);
					countt = countt + yy;	
				}
				
				int i,j=0,k,l,x,count1=0,count2,count3,count4=0;

				while(j<=list.size()-jj.length())
				{
					count2=0;
					for(k=j;k<j+jj.length();k++)
					{
						count2=count2+(int)list.get(k);
					}

					if(countt==count2)
					{
						count3=0;x=0;
						for(l=j;l<j+jj.length();l++)
						{
							if(list.get(l)==jj.charAt(x))
							{
								count3++;
								x++;
							}
						}
						if(count3==jj.length())
						{
							count4++;
				            System.out.println("Matching substring found, starting at : "+j);
				            try
				        	{ 
		   
				            	BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true)); 
				            	out.write("Matching substring found, starting at : "+j+"\n"); 
				            	out.close(); 
				        	} 
				        	catch(IOException e6)
				        	{	 
				            	System.out.println("exception occoured" + e6); 
				        	}
						}
					}
					j++;
				}
				
				if (count4 == 0) {
					System.err.println("\nPattern not found.");
				}
				else
				{
					System.out.println("Numbers of matching pattern: "+count4);
				}
	}
	
	public static Vector readLines(File f) throws IOException
	{
		Vector<Character> vectorlist = new Vector<Character>();
		try
		{
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			int numberOfLines = 0;
			int n,i,k;
			int charCount = 0;
		
			while((line = br.readLine()) != null)
			{
				numberOfLines++;
				n = numberOfLines;
				if (n >= 22)
				{
					if (!line.isEmpty())
					{
						char[] sChars = line.toCharArray();
						
						for(int l = 0; l < 54; l++)
						{
							if(sChars[l] != ' ')
							{
								vectorlist.add(sChars[l]); 
								charCount += line.length();
							    charCount = 0;
							} 	
						}		
					}			
				}	
			}
			br.close();
			fr.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return vectorlist;
	}
}