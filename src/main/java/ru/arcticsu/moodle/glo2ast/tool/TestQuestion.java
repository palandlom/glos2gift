package ru.arcticsu.moodle.glo2ast.tool;

/**
 * ������ �����.
 * @author Lomov P. A.
 *
 */
public abstract class TestQuestion
{
	/**
	 * ����� �������.
	 */
	private String questionText;
	
	////////////////////////////////////////////////////

	protected TestQuestion()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	
	///////////////////////////////////////////////
	
	

	///////////////////////////////////////////////

	
	
	public abstract String getAnswerText();


	protected TestQuestion(String questionText)
	{
		super();
		this.questionText = questionText;
	}


	public String getQuestionText()
	{
		return questionText;
	}


	public void setQuestionText(String questionText)
	{
		this.questionText = questionText;
	}
	
	

}
