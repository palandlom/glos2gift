/**
 * 
 */
package ru.arcticsu.moodle.glo2ast.tool;

import java.util.ArrayList;

/**
 * @author Lomov P. A.
 *
 */
public class OpenQuestion extends TestQuestion
{

	/**
	 * Текст ответа.
	 */
	private String answerText;


	/**
	 * Список других вариантов ответа.
	 */
	private ArrayList<String> aliasAnswers;

	protected OpenQuestion()
	{
		super();

	}

	protected OpenQuestion(String answerText, ArrayList<String> aliasAnswers,
			String questionText)
	{
		super(questionText);
		this.answerText = answerText;

		this.aliasAnswers = aliasAnswers;
	}

	public void setAnswerText(String answerText)
	{
		this.answerText = answerText;

	}

	@Override
	public String getAnswerText()
	{
		return answerText;
	}



	@Override
	public String toString()
	{
		return "\nQuestion: " + this.getQuestionText() + "\nAnswer: "
				+ this.getAnswerText();
	}

	public ArrayList<String> getAliasAnswers()
	{
		return aliasAnswers;
	}

	public void setAliasAnswers(ArrayList<String> aliasAnswers)
	{
		this.aliasAnswers = aliasAnswers;
	}

}
