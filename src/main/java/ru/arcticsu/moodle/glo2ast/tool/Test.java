package ru.arcticsu.moodle.glo2ast.tool;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashSet;

/**
 * ����, ��������� �� ������ ��������.
 * @author Lomov P. A.
 *
 */
public class Test
{
	/**
	 * ��� �����
	 */
	private String name;
	
	/**
	 * �����
	 */
	private String author;
	
	/**
	 * ����������� ��������.
	 */
	private String description;
	
	/**
	 * ����� ��������.
	 */
	private HashSet <? extends TestQuestion> questions;
	
	
	protected Test()
	{
		super();
	}

	protected Test(String name, String author, String description, Glossary gloss)
	{
		this.setName(name);
		this.setAuthor(author);
		this.setDescription(description);
		this.setQuestions(gloss.getOpenQuestionList());
	}
	
	


	protected  Test(HashSet<? extends TestQuestion> questions)
	{
		super();
		this.questions = questions;
	}



	public HashSet<? extends TestQuestion> getQuestions()
	{
		return questions;
	}



	public void setQuestions(HashSet<? extends TestQuestion> questions)
	{
		this.questions = questions;
	}



	protected Test(String name, String author, String description,
			HashSet<TestQuestion> questions)
	{
		super();
		this.name = name;
		this.author = author;
		this.description = description;
		this.questions = questions;
	}



	///////////////////////////////////
	public String getName()
	{
		return name;
	}


	public String getAuthor()
	{
		return author;
	}

	public String getDescription()
	{
		return description;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
	
	
	public void toMoodleTest()
	{
		
	}

	/**
	 * ��������� ��������� ������ � �����.
	 * @param buf ������
	 * @param name ������ ��� �����
	 * @return
	 */
	public static void toFile(StringBuffer buf, String name)
	{

		
		//File fl = new File (name == null ? Const.OUTPUT_FILENAME : name);
		String fileName = name == null ? Const.OUTPUT_FILENAME : name;
		
		try
		{			
			//BufferedWriter out = new BufferedWriter(new FileWriter(fl));
			BufferedWriter out = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
					
	        //fl.createNewFile();
	        //write contents of StringBuffer to a file
	        out.write(buf.toString());
              
	        //flush the stream
	        out.flush();
	        
	        //close the stream
	        out.close();			
			
		} catch (Exception e)
		{
			
		}

		//return fl.getAbsolutePath();
	}
	
	/**
	 * ������������ ���������� ����� - ��������� ������� ����� � �����
	 * @param termName
	 * @return
	 */
	public static String getMaskedAnswer(String termName, String mask)
	{
		/* ����� � ������ �������.. */
		String rez = termName.toLowerCase().trim();

		/* ��������� ������ �� ����� � ������� �����������
		 * ����� ��� ��������� */
		String words[] = rez.split("\\s");
		rez = "";
		for (String word : words)
		{
			if (word.trim().length()<=2) continue;
			
			/* ���������� ������� ���� ������� �� �����,
			 * �������� � ��������� ��������� */
			int cutIndex = word.length() > 4 ? 2 : 1; 
			word = word.substring(0, word.length()-cutIndex) + mask;
			
			rez = rez + word + " ";
		}
		return rez;
	}
	
	/**
	 * �������������� ������.
	 * @param termName
	 * @return
	 */
	public static String getAnswer(String termName)
	{
		/* ����� � ������ �������.. */
		String rez = termName.toLowerCase().trim();
		return rez;
	}

	@Override
	public String toString()
	{
		String str = "Test:" + this.getName()+
				"\n-Questions quality:" + this.getQuestions().size();
		return str;
	}


}
