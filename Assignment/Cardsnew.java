package prani;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Cardsnew
{
	static Scanner myObj = new Scanner(System.in);
	 
	String[] suits= {"S","C","H","D"}	;
	String[] numbers= {"A","2","3","4", "5","6","7","8","9","10","J","Q","K"};
	//private static String temp[]= {"H#A","H#2","H#3","H#4"};  //H#A,H#2,H#3,H#4
	//private static String temp[]= {"S#10","S#J","S#Q","S#A"}; //S#10,S#J,S#Q,S#A
	//private static String temp[]= {"S#10","S#J","S#Q"}; //S#10,S#J,S#Q,
	//private static String temp[]= {"S#10","S#J","S#Q","S#K"}; //S#10,S#J,S#Q,
	//private static String temp[]= {"C#Q","C#K","C#A","C#2"}; //C#Q,C#K,C#A,C#2
	//private static String temp[]= {"D#5","D#6","H#7"};  //D#5,D#6,H#7
	
	private static String temp[];
	
	public static void main(String[] args) {
		System.out.println("Enter length of sequence");
		int seqsize=  myObj.nextInt();
		//System.out.println("size is"+seqsize);
		temp = new String[seqsize];
		System.out.println("Enter sequence");
		 for(int i=0; i<seqsize; i++ ) {
	         temp[i] = myObj.next();
	      }
		
		Cardsnew c=new Cardsnew();
		c.CheckSeq(temp);
		
		//System.out.println(c.CheckSeq(temp));
	}



	public void CheckSeq(String[] temp)
	{
		String suit=null;
		boolean res=false;
		for(int i=0;i<temp.length;i++)
		{
			
			String s[]=temp[i].split("#",2);
			//System.out.println(s[i]);
			if(i==0)
			{
				suit=s[0];
				
				//System.out.println(suit);
				
			}
			if(suit.equals(s[0]))
			{
				suit=s[0];
				res=true;
			}
			else
			{
				res=false;
			}

		}
		
		if(res==true)
		{
			//System.out.println("yesssssssssssss");
			addRank(suit);
		}
		
		  else 
		  { 
			  System.out.println("Not a Valid Sequence"); 
		  }
		 
		//return true;


	}
	
	public void addRank(String s)
	{
		String[] rankarr=new String[13];
		
		
		for(int i=0;i<numbers.length;i++)
		{
			rankarr[i]=s+"#"+numbers[i];
			//System.out.println(rankarr[i]);
		}
		validsequence(rankarr);
		
	}
	
	public void validsequence(String[] arr)
	{
		List<String> list = Arrays.asList(arr);
		List<String> templist = Arrays.asList(temp);
		List<String> finallist = new ArrayList();
		
		
		String abc=templist.get(0);
		int index=list.indexOf(abc);
		/*
		 * for(int i=index;i<templist.size()+index-1;i++) { String ele=list.get(i);
		 * finallist.add(ele);
		 * 
		 * }
		 */
		for(int i=0;i<templist.size();i++)
		{
			if(index>=0 &&  index<=12)
			{
			String ele=list.get(index);
			index++;
			finallist.add(ele);
			}
			else
			{
				finallist.add(null);
			}
		}
	
		//System.out.println(finallist);
		if(templist.equals(finallist))
		{
			System.out.println("Valid Sequence");
		}
		else
		{
			System.out.println("Not a Valid Sequence");
		}
		
		
		
	}


}

