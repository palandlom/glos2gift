/**
 * 
 */
package ru.arcticsu.moodle.glo2ast.tool;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Lomov P. A.
 * @deprecated недоделан
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
	 * Возвращяет тест в формате AST.
	 * @return
	 */
	public StringBuffer	getASTTestDoc()
	{
		StringBuffer docBuffer = new StringBuffer();
		
		/* Шапка теста ====================================
		 * 	F1: Финансовые рынки
			F2: Немирова В.С. */
		docBuffer.append(Const.HEADER_AST_TEST_NAME+this.getName()+"\n");
		
		if (this.getAuthor()!=null && !this.getAuthor().isEmpty())
					docBuffer.append(Const.HEADER_AST_TEST_AUTHOR+this.getAuthor()+"\n");
		
		docBuffer.append("\n");
		
		/* Вопросы теста =================================
		 * 	I:
			S: Совокупность методов и приемов страхования рисков валютных потерь представляет собой систему ###
			+: хеджирования */ 
		for ( TestQuestion quest : this.getQuestions())
		{
			docBuffer.append(Const.OPEN_CLOSED_QUESTION_IDENT);
			docBuffer.append(Const.QUESTION_PREFFIX + this.getCorrectQuestion(quest.getQuestionText())+"\n");
			docBuffer.append(Const.CORRECT_ANSWER + Test.getMaskedAnswer(quest.getAnswerText(), Const.END_MASK_AST)+"\n");
		}
		
		
		return docBuffer;
	}
	
	
	
	/**
	 * Формируем коректный текст вопроса с вводной.
	 * @param defenition
	 * @return
	 */
	private String getCorrectQuestion(String defenition)
	{
		String rez = defenition.toLowerCase().trim();
		
		
		/*Вырезаем слово "это" из начала строки*/
		if (rez.indexOf("это") == 0)
		{
			rez = rez.replaceAll("это", "").trim();

			//LOGGER.info(Integer.parseInt(i));
			LOGGER.info("Make correction - result:"+rez.trim());
		}
		
		/* Добавляем вводную вопроса */
		rez = Const.QUESTION_BEGINNING + rez;
		
		/* Добавляем конец вопроса + заменитель неизвестного */
		rez = rez + Const.QUESTION_END + Const.UNKNOWN_TERM_IN_QUESTION;
		
		LOGGER.info("Final question:{}", rez);
		return rez;
	}
	
	
	
	
	

}
