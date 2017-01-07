package ru.arcticsu.moodle.glo2ast.tool;

import java.util.HashSet;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Тест в формате GIFT для загрузки в moodle
 * 
 * @author Lomov P. A.
 * 
 *
 */
public class GiftTest extends Test
{

	private static final Logger LOGGER = LoggerFactory
			.getLogger(GiftTest.class);

	/**
	 * Добавлять ли синонимы в ответ.
	 */
	private boolean includeAliasAnswers = true;

	/**
	 * Использовать ли маску в концовках ответов.
	 */
	private boolean useMaskedAnswers = true;

	public GiftTest(HashSet<? extends TestQuestion> questions)
	{
		super(questions);
	}

	public void toFile(String filePath)
	{
		StringBuffer docBuffer = new StringBuffer();

		int num = 0;
		for (Iterator it = this.getQuestions().iterator(); it.hasNext();)
		{
			OpenQuestion oQuestion = (OpenQuestion) it.next();
			num++;
			String qStr = "::Q" + oQuestion.hashCode() + ":: " + "[html]<p>"
					+ oQuestion.getQuestionText() + "</p> "
					+ this.getAnswersPart(oQuestion) + "\n\n";

			LOGGER.info(qStr);
			/*
			 * ::название вопроса:: [html]<p>текст вопроса</p>{ =%100%вариан1#
			 * =%100%вариан2# =%100%вариан3# }
			 */
			docBuffer.append(qStr);
		}
		LOGGER.info("Question quality: {}", num);
		Test.toFile(docBuffer, filePath);

	}

	/**
	 * Формирует кусок вопроса теста с ответами
	 * 
	 * @param oQuestion
	 * @return
	 */
	private String getAnswersPart(OpenQuestion oQuestion)
	{
		/* Сначала основной ответ... */
		StringBuffer answerPart = new StringBuffer();

		String mainAnswer = this.useMaskedAnswers
				? Test.getMaskedAnswer(oQuestion.getAnswerText(),
						Const.END_MASK_STAR)
				: Test.getAnswer(oQuestion.getAnswerText());

		answerPart.append("\n{=%100%" + mainAnswer + "#");

		/* ... потом добавляем АЛИАСы */
		if (this.includeAliasAnswers)
			for (String alias : oQuestion.getAliasAnswers())
			{
				alias = this.useMaskedAnswers
						? Test.getMaskedAnswer(alias, Const.END_MASK_STAR)
						: Test.getAnswer(alias);

				answerPart.append("\n=%100%"
						+ alias
						+ "#");
			}
		
		answerPart.append("}");
		return answerPart.toString();
	}

	public void setIncludeAliasAnswers(boolean includeAliasAnswers)
	{
		this.includeAliasAnswers = includeAliasAnswers;
	}

	public void setUseMaskedAnswers(boolean useMaskedAnswers)
	{
		this.useMaskedAnswers = useMaskedAnswers;
	}

}
