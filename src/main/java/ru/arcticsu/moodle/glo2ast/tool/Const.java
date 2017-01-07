package ru.arcticsu.moodle.glo2ast.tool;

public interface Const
{
	/**
	 * Корневой XML-элемент файла с глоссарием.
	 */
	static final String XML_GLOSSARY_ROOT="GLOSSARY";
	
	/**
	 * Элемент ЗАПИСЬ-ГЛОССАРИЯ
	 */
	static final String XML_DEFINITIONS="ENTIRES";
	/**
	 * Элемент ОПРЕДЕЛЕНИЕ
	 */
	static final String XML_DEFINITIONS_ENTRY="ENTRY";
	/**
	 * Элемент НАЗВАНИЕ ТЕРМИНА
	 */
	static final String XML_DEFINITIONS_ENTRY_CONCEPT="CONCEPT";
	/**
	 * Элемент ОПРЕДЕЛЕНИЕ ТЕРМИНА
	 */
	static final String XML_DEFINITIONS_ENTRY_DEFINITION="DEFINITION";
	/**
	 * Элемент Псевдоним-Alias ТЕРМИНА
	 */
	static final String XML_DEFINITIONS_ENTRY_ALIAS="ALIAS";

	/**
	 * Элемент имя псевдонима ТЕРМИНА
	 */
	static final String XML_DEFINITIONS_ENTRY_ALIASNAME="NAME";

	
	/**
	 * Имя выходного файла по-умолчанию.
	 */
	static final String OUTPUT_FILENAME="out-ast-test.txt";
	
	/**
	 * Начало вопроса
	 */
	static final String QUESTION_BEGINNING = "Укажите название термина, имеющего следующее определение: ";
	
	/**
	 * Подсказка кол-ва слов ответе.
	 */
	static final String QUESTION_HELP = " - Cлов в основном ответе: ";
	
	/**
	 * Конец вопроса
	 */
	static final String QUESTION_END = " Это";

	/**
	 * если «сомнительные» буквы находятся в окончании слова, 
	 * то заменить следующими символами: *. 
	 * В этом случае буквы, замененные символами не будут анализироваться системой.
	 */
	static final String END_MASK_STAR ="*";
	
	
	
	//////////////////////////////////////////////////////////
	///////////// AST-temptate ///////////////////////////////
	//////////////////////////////////////////////////////////
	
	
	/**
	 * Название теста
	 */
	static final String HEADER_AST_TEST_NAME = "F1: ";

	/**
	 * Название автора
	 */
	static final String HEADER_AST_TEST_AUTHOR = "F2: ";
	
	/**
	 * Идентификатор начала открытого и закрытого задания
	 */
	static final String OPEN_CLOSED_QUESTION_IDENT ="I: \n";
	/**
	 * Преффикс текста вопроса. 
	 */
	static final String QUESTION_PREFFIX ="S: ";
	/**
	 * Преффикс верного ответа.
	 */
	static final String CORRECT_ANSWER ="+: ";
	
	/**
	 * Замена неизвестного термина в открытых заданиях.
	 */
	static final String UNKNOWN_TERM_IN_QUESTION =" ### ";
	
	/**
	 * когда система тестирования не будет воспринимать верный 
	 * ответ из-за орфографических ошибок, правильный 
	 * ответ можно ввести, заменив «трудные» буквы знаками *,
	 */
	static final String SINGLE_SYMBOL_MASK ="*";

	/**
	 * если «сомнительные» буквы находятся в окончании слова, 
	 * то заменить следующими символами: #$#. 
	 * В этом случае буквы, замененные символами не будут анализироваться системой.
	 */
	static final String END_MASK_AST ="#$#";
}
