import java.util.Scanner;
public class DriverExam
{
public static int correctAnswers;
public static int incorrectAnswers;
public static int questionsMissedArrayIndex;
static Scanner scanner = new Scanner(System.in);
private String answerKey[] = {"B", "D", "A", "A", "C", "A", "B", "A", "C", "D", "B", "C", "D", "A", "D", "C", "C", "B", "D", "A"};
private String studentAnswers[];
private int numberOfQuestions = answerKey.length;
public static void main(String[] args )
{	
	System.out.println("Welcome to the local Driver's License Office");
	String studentAnswers[] = new String[20];
	studentInputArray(studentAnswers);
	DriverExam drivingTest = new DriverExam(studentAnswers);
	testResults(drivingTest);
}

public static void studentInputArray(String studentAnswers[])
{
	for(int index = 0; index < studentAnswers.length; index++)
	{
		System.out.println("What is the answer for question #" + (index+1) + "?");
		String studentInput = scanner.next();
		while(!studentInput.equalsIgnoreCase("A") && !studentInput.equalsIgnoreCase("B") &&
				  !studentInput.equalsIgnoreCase("C") && !studentInput.equalsIgnoreCase("D"))
			{
				System.out.println("Please enter a valid input.");
				studentInput = scanner.next();
			}	
		studentAnswers[index] = studentInput;
	}
}

public int totalCorrect()
{
	int correctAnswers = 0;
	for(int index = 0; index < numberOfQuestions; index++)
	{
		if(answerKey[index].equalsIgnoreCase(studentAnswers[index]))
		{
			correctAnswers++;
		}

	}
	return correctAnswers;
}

public int totalIncorrect()
{
	int incorrectAnswers = 0;
	for(int index = 0; index < numberOfQuestions; index++)
	{
		if(!(answerKey[index].equalsIgnoreCase(studentAnswers[index])))
		{
			incorrectAnswers++;
		}

	}
	return incorrectAnswers;
}

boolean passed()
{
	int passingScore = 15;
	if(totalCorrect() >= passingScore)
	{
		return true;
	}
	else
	{
		return false;
	}
}

public int[] questionsMissed()
{
	int questionsMissedArray[] = new int [numberOfQuestions];
	int questionsMissedArrayIndex = 0;
	for(int index = 0; index < numberOfQuestions; index++)
	{
		if(!(answerKey[index].equalsIgnoreCase(studentAnswers[index])))
		{
			questionsMissedArray[questionsMissedArrayIndex] = index + 1;
			questionsMissedArrayIndex++;
		}	
	}
	return questionsMissedArray;
}

public static void testResults(DriverExam driverExamObject)
{
	System.out.println("Correct answers: " + driverExamObject.totalCorrect());
	System.out.println("Incorrect answers: " + driverExamObject.totalIncorrect());
	System.out.print("Missed questions: ");
	for(int index = 0; index < driverExamObject.questionsMissed().length; index++)
	{
		if(driverExamObject.questionsMissed()[index] != 0)
		{
			System.out.print(driverExamObject.questionsMissed()[index] + " ");
			System.out.print("");
		}
	}
	if(driverExamObject.passed())
	{
		System.out.println("");
		System.out.println("Congratulations. You passed the driver's exam.");
	}
	else
	{	
		System.out.println("");
		System.out.println("You failed the driver's exam.");
	}
}


public DriverExam(String studentArrayGiven[])
{
	studentAnswers = studentArrayGiven;
}
}