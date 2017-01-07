/**
 * 
 */
package ru.arcticsu.moodle.glo2ast.tool;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Lomov P. A.
 * @deprecated ���������
 *
 */
public class ASTtest extends Test
{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ASTtest.class);

	protected ASTtest()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	protected ASTtest(String name, String author, String description,
			HashSet<TestQuestion> questions)
	{
		super(name, author, description, questions);
		// TODO Auto-generated constructor stub
	}

	
	
	
	protected ASTtest(String name, String author, String description,
			Glossary gloss)
	{
		super(name, author, description, gloss);
		// TODO Auto-generated constructor stub
	}

	/**
	 * ���������� ���� � ������� AST.
	 * @return
	 */
	public StringBuffer	getASTTestDoc()
	{
		StringBuffer docBuffer = new StringBuffer();
		
		/* ����� ����� ====================================
		 * 	F1: ���������� �����
			F2: �������� �.�. */
		docBuffer.append(Const.HEADER_AST_TEST_NAME+this.getName()+"\n");
		
		if (this.getAuthor()!=null && !this.getAuthor().isEmpty())
					docBuffer.append(Const.HEADER_AST_TEST_AUTHOR+this.getAuthor()+"\n");
		
		docBuffer.append("\n");
		
		/* ������� ����� =================================
		 * 	I:
			S: ������������ ������� � ������� ����������� ������ �������� ������ ������������ ����� ������� ###
			+: ������������ */ 
		for ( TestQuestion quest : this.getQuestions())
		{
			docBuffer.append(Const.OPEN_CLOSED_QUESTION_IDENT);
			docBuffer.append(Const.QUESTION_PREFFIX + this.getCorrectQuestion(quest.getQuestionText())+"\n");
			docBuffer.append(Const.CORRECT_ANSWER + Test.getMaskedAnswer(quest.getAnswerText(), Const.END_MASK_AST)+"\n");
		}
		
		
		return docBuffer;
	}
	
	
	
	/**
	 * ��������� ��������� ����� ������� � �������.
	 * @param defenition
	 * @return
	 */
	private String getCorrectQuestion(String defenition)
	{
		String rez = defenition.toLowerCase().trim();
		
		
		/*�������� ����� "���" �� ������ ������*/
		if (rez.indexOf("���") == 0)
		{
			rez = rez.replaceAll("���", "").trim();

			//LOGGER.info(Integer.parseInt(i));
			LOGGER.info("Make correction - result:"+rez.trim());
		}
		
		/* ��������� ������� ������� */
		rez = Const.QUESTION_BEGINNING + rez;
		
		/* ��������� ����� ������� + ���������� ������������ */
		rez = rez + Const.QUESTION_END + Const.UNKNOWN_TERM_IN_QUESTION;
		
		LOGGER.info("Final question:{}", rez);
		return rez;
	}
	
	
	
	
	

}
