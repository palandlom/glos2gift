/**
 * 
 */
package ru.arcticsu.moodle.glo2ast.tool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Lomov P. A.
 *
 */
public class Glossary
{

	private static final Logger LOGGER = LoggerFactory
			.getLogger(Glossary.class);

	/**
	 * ����� ����������� ���������.
	 */
	HashSet<Defenition> defenitionSet;

	/**
	 * XML-���� � ����������.
	 */
	File glossFile;

	public Glossary(File glossFile)
	{
		super();
		this.glossFile = glossFile;
	}

	public void init()
	{
		try
		{
			if (this.glossFile.exists())
			{
				LOGGER.info("Load glossary from: {}",
						this.glossFile.getCanonicalPath());
				this.defenitionSet = this.getGlossary(this.glossFile);
			} else
			{
				LOGGER.error("!!! File <{}> not exists",
						this.glossFile.getCanonicalPath());
			}
		} catch (IOException e)
		{
			LOGGER.error("!!! Exeption:", e.getMessage());
		}

	}

	/**
	 * ���������� ����� ����������� �� �����
	 * 
	 * @param xmlGlossaryFilePath
	 * @return
	 */
	public HashSet<Defenition> getGlossary(File fXmlFile)
	{
		NodeList nEntry = null;

		/* ������ ���� */
		try
		{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			LOGGER.info("Glossary is loaded..");

			/* �������� ������ ��������� � �������������... */
			nEntry = doc.getElementsByTagName(Const.XML_DEFINITIONS_ENTRY);

		} catch (Exception e)
		{
			LOGGER.error("Error during read file:", e);
		}

		Node entryNode;
		Element entryElement, conceptElement, defenitionElement;
		NodeList valueList, aliasList;
		String conceptName, conceptDefenition;
		HashSet<Defenition> defSet = new HashSet<Defenition>();

		/* ��� ������� ��������-����������� ENTRY... */
		for (int i = 0; i < nEntry.getLength(); i++)
		{
			/* ... �������� ��� � ��������.... */
			entryNode = nEntry.item(i);
			entryElement = entryNode.getNodeType() == Node.ELEMENT_NODE
					? (Element) entryNode : null;

			/*
			 * ... ������� �� ���� �������� ����������� (CONCEPT) �
			 * (�����������)
			 */
			conceptElement = (Element) entryElement
					.getElementsByTagName(Const.XML_DEFINITIONS_ENTRY_CONCEPT)
					.item(0);
			defenitionElement = (Element) entryElement.getElementsByTagName(
					Const.XML_DEFINITIONS_ENTRY_DEFINITION).item(0);

			/* TODO ... ������� �������� ����� - alias */
			aliasList = entryElement
					.getElementsByTagName(Const.XML_DEFINITIONS_ENTRY_ALIAS);

			/*
			 * ����� � ��������� �������� � ����������� 1 �������� ���� �
			 * ��������� ���������
			 */
			valueList = conceptElement.getChildNodes();
			conceptName = getTaglessString(valueList.item(0).getNodeValue());
			valueList = defenitionElement.getChildNodes();
			conceptDefenition = getTaglessString(
					valueList.item(0).getNodeValue());

			/*
			 * TODO ... ����� � ��������� ALIAS ���������� NAME � �� ����
			 * ��������� ��������
			 */
			ArrayList<String> aliasNameList = getAliasNames(aliasList);

			LOGGER.info("Concept: " + conceptName);
			LOGGER.info("Defenition: " + conceptDefenition);
			LOGGER.info("--------------------------------------------------");

			/* ... ������� ����������� � ������� ��� � ����� */
			defSet.add(new Defenition(conceptName, conceptDefenition,
					aliasNameList));
		}

		LOGGER.info("Glosarry is read. Number of read defenition: "
				+ defSet.size());
		return defSet;
	}

	/**
	 * ���������� ������ ��������-����������� (�������� ����) �������.
	 * 
	 * @param aliasList
	 *            ������ ��������� ALIAS
	 * @return
	 */
	private ArrayList<String> getAliasNames(NodeList aliasList)
	{
		ArrayList<String> aliasElements = new ArrayList<String>();
		Element aliasElement;
		NodeList childList;
		String aliasName;

		for (int j = 0; j < aliasList.getLength(); j++)
		{
			aliasElement = (Element) aliasList.item(j);

			/* �� �������� ����� ����� ���������� NAME... */
			Element nameElement = (Element) aliasElement
					.getElementsByTagName(Const.XML_DEFINITIONS_ENTRY_ALIASNAME)
					.item(0);
			/* ... � ��� ����� ��������� �������� - ������������ ����� ��� */
			childList = nameElement.getChildNodes();

			/* ... ���� ��� �� ����� - ������� ��� � ���������� */
			if (childList != null)
			{
				aliasName = getTaglessString(childList.item(0).getNodeValue());
				LOGGER.info("AliasNAme: {}", aliasName);
				aliasElements.add(aliasName);
			}
		}
		return aliasElements;
	}

	/**
	 * ������� �� ������ ����.
	 * 
	 * @param str
	 * @return
	 */
	private String getTaglessString(String str)
	{
		// LOGGER.info("Initial str: {}", str);
		str = str.replaceAll("<(.)+?>", "");
		str = str.replaceAll("<(\n)+?>", "");
		// LOGGER.info("Correct str: {}", str);
		return str.replaceAll("<[a-zA-Z\\s/]+>", "");
	}

	/**
	 * ���� ������ �����������
	 * 
	 * @return
	 */
	public HashSet<Defenition> getDefenitionSet()
	{
		return defenitionSet;
	}

	public void setDefenitionSet(HashSet<Defenition> defenitionSet)
	{
		this.defenitionSet = defenitionSet;
	}

	/**
	 * ���������� ������ �������� ��������.
	 * 
	 * @return
	 */
	public HashSet<OpenQuestion> getOpenQuestionList()
	{
		HashSet<OpenQuestion> qlist = new HashSet<OpenQuestion>();

		LOGGER.info("== Form open question list ==");
		for (Defenition def : this.getDefenitionSet())
		{
			String answer = def.getTermName();
			ArrayList<String> aliasAnswer = def.getAliases();

			String question = Const.QUESTION_BEGINNING + "<br>"
					+ def.getTermDefenition() + Const.QUESTION_HELP
					+ Glossary.getWordCount(answer);

			OpenQuestion oQuestion = new OpenQuestion(answer, aliasAnswer,
					question);
			qlist.add(oQuestion);

			LOGGER.info("Result:" + oQuestion.toString());
		}

		LOGGER.info("== End = Get open question quality: {}", qlist.size());

		return qlist;
	}

	static int getWordCount(String str)
	{
		String[] mas = str.split("\\s");
		LOGGER.info("In string: " + str + " = " + mas.length + " words");
		return mas.length;
	}

}
