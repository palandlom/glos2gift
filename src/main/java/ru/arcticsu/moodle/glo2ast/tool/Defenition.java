package ru.arcticsu.moodle.glo2ast.tool;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Lomov P. A.
 *
 */
public class Defenition
{
	
	
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(Defenition.class);

	/**
	 * Название термина 
	 */
	private String termName;
	
	/**
	 * Ключевые слова или псевдонимы названия термина
	 */
	private ArrayList<String> aliases;
	
	
	/**
	 * Определение термина.
	 */
	private  String termDefenition;
	

	public Defenition(String termName, String termDefenition)
	{
		super();
		this.termName = termName.replaceAll("[\\s]{2,}", " ");
		this.termDefenition = termDefenition.replaceAll("[\\s]{2,}", " ");
		
	}
	
	/**
	 * Определение с ключевыми словами
	 * @param termName
	 * @param termDefenition
	 * @param aliases
	 */
	public Defenition(String termName, String termDefenition, ArrayList<String> aliases)
	{
		super();
		this.termName = termName.replaceAll("[\\s]{2,}", " ");
		this.termDefenition = termDefenition.replaceAll("[\\s]{2,}", " ");
		
		ArrayList<String> chAliases = new ArrayList<String>();
		
		for (String alias : aliases)
		{
			chAliases.add(alias.replaceAll("[\\s]{2,}", " ")); 
		}
		
		this.aliases = chAliases;
	}
	

	public String getTermName()
	{
		return termName;
	}

	public String getTermDefenition()
	{
		return termDefenition;
	}

	public void setTermName(String termName)
	{
		this.termName = termName;
	}

	public void setTermDefenition(String termDefenition)
	{
		this.termDefenition = termDefenition;
	}

	public ArrayList<String> getAliases()
	{
		return aliases;
	}

	public void setAliases(ArrayList<String> aliases)
	{
		this.aliases = aliases;
	}
	
	
	
}
