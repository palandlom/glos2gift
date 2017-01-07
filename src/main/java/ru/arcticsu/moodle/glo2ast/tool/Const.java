package ru.arcticsu.moodle.glo2ast.tool;

public interface Const
{
	/**
	 * �������� XML-������� ����� � ����������.
	 */
	static final String XML_GLOSSARY_ROOT="GLOSSARY";
	
	/**
	 * ������� ������-���������
	 */
	static final String XML_DEFINITIONS="ENTIRES";
	/**
	 * ������� �����������
	 */
	static final String XML_DEFINITIONS_ENTRY="ENTRY";
	/**
	 * ������� �������� �������
	 */
	static final String XML_DEFINITIONS_ENTRY_CONCEPT="CONCEPT";
	/**
	 * ������� ����������� �������
	 */
	static final String XML_DEFINITIONS_ENTRY_DEFINITION="DEFINITION";
	/**
	 * ������� ���������-Alias �������
	 */
	static final String XML_DEFINITIONS_ENTRY_ALIAS="ALIAS";

	/**
	 * ������� ��� ���������� �������
	 */
	static final String XML_DEFINITIONS_ENTRY_ALIASNAME="NAME";

	
	/**
	 * ��� ��������� ����� ��-���������.
	 */
	static final String OUTPUT_FILENAME="out-ast-test.txt";
	
	/**
	 * ������ �������
	 */
	static final String QUESTION_BEGINNING = "������� �������� �������, �������� ��������� �����������: ";
	
	/**
	 * ��������� ���-�� ���� ������.
	 */
	static final String QUESTION_HELP = " - C��� � �������� ������: ";
	
	/**
	 * ����� �������
	 */
	static final String QUESTION_END = " ���";

	/**
	 * ���� ������������� ����� ��������� � ��������� �����, 
	 * �� �������� ���������� ���������: *. 
	 * � ���� ������ �����, ���������� ��������� �� ����� ��������������� ��������.
	 */
	static final String END_MASK_STAR ="*";
	
	
	
	//////////////////////////////////////////////////////////
	///////////// AST-temptate ///////////////////////////////
	//////////////////////////////////////////////////////////
	
	
	/**
	 * �������� �����
	 */
	static final String HEADER_AST_TEST_NAME = "F1: ";

	/**
	 * �������� ������
	 */
	static final String HEADER_AST_TEST_AUTHOR = "F2: ";
	
	/**
	 * ������������� ������ ��������� � ��������� �������
	 */
	static final String OPEN_CLOSED_QUESTION_IDENT ="I: \n";
	/**
	 * �������� ������ �������. 
	 */
	static final String QUESTION_PREFFIX ="S: ";
	/**
	 * �������� ������� ������.
	 */
	static final String CORRECT_ANSWER ="+: ";
	
	/**
	 * ������ ������������ ������� � �������� ��������.
	 */
	static final String UNKNOWN_TERM_IN_QUESTION =" ### ";
	
	/**
	 * ����� ������� ������������ �� ����� ������������ ������ 
	 * ����� ��-�� ��������������� ������, ���������� 
	 * ����� ����� ������, ������� �������� ����� ������� *,
	 */
	static final String SINGLE_SYMBOL_MASK ="*";

	/**
	 * ���� ������������� ����� ��������� � ��������� �����, 
	 * �� �������� ���������� ���������: #$#. 
	 * � ���� ������ �����, ���������� ��������� �� ����� ��������������� ��������.
	 */
	static final String END_MASK_AST ="#$#";
}
