package ru.arcticsu.moodle.glo2ast.tool;

import java.util.HashSet;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ���� � ������� GIFT ��� �������� � moodle
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
	 * ��������� �� �������� � �����.
	 */
	private boolean includeAliasAnswers = true;

	/**
	 * ������������ �� ����� � ��������� �������.
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
			 * ::�������� �������:: [html]<p>����� �������</p>{ =%100%������1#
			 * =%100%������2# =%100%������3# }
			 */
			docBuffer.append(qStr);
		}
		LOGGER.info("Question quality: {}", num);
		Test.toFile(docBuffer, filePath);

	}

	/**
	 * ��������� ����� ������� ����� � ��������
	 * 
	 * @param oQuestion
	 * @return
	 */
	private String getAnswersPart(OpenQuestion oQuestion)
	{
		/* ������� �������� �����... */
		StringBuffer answerPart = new StringBuffer();

		String mainAnswer = this.useMaskedAnswers
				? Test.getMaskedAnswer(oQuestion.getAnswerText(),
						Const.END_MASK_STAR)
				: Test.getAnswer(oQuestion.getAnswerText());

		answerPart.append("\n{=%100%" + mainAnswer + "#");

		/* ... ����� ��������� ������ */
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
