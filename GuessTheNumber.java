import java.util.Scanner;
import java.util.Random;
class Game
{
	int system,user,guesses=0;
	Game()
	{
		Random random = new Random();
		this.system = random.nextInt(100) + 1;
	}
	public boolean takeUserInput()
	{
		if(guesses < 10)
		{
			System.out.println("Guess the number: ");
			this.user = GuessTheNumber.takeIntegerInput(100);
			guesses++;
			return false;
		}
		else
		{
			System.out.println("Oops.......! Game over :( better luck next time\n");
			return true;
		}
	}
	public boolean isCorrectGuess()
	{
	if(system == user)
	{
		System.out.println("Hurry!!!, you found  the number " + system + "in " + guesses + " guesses");
		switch(guesses)
		{
			case 1 : System.out.println("Your  have scored 10 points");
			               break;
			case 2 : System.out.println("Your have scored  9 points");
			               break;
			case 3 : System.out.println("Your have scored  8 points");
			               break;
			case 4 : System.out.println("Your have scored  7 points");
			               break;
			case 5 : System.out.println("Your have scored  6 points");
			               break;
			case 6 : System.out.println("Your have scored 5 points");
			               break;
			case 7 : System.out.println("Your have scored 4 points");
			               break;
			case 8 : System.out.println("Your have scored  3 points");
			               break;
			case 9 : System.out.println("Your have scored  2 points");
			               break;
			case 10 : System.out.println("Your have scored  1 points");
			               break;
		}
		System.out.println();
		return true;
	}
	else if (guesses < 10 && user > system)
	{
		if(user - system >10)
		{
			System.out.println("Too much high");
		}
		else
		{
			System.out.println("somewhat high");
		}
	}
	else if  (guesses < 10 && user < system)
	{
		if(system - user >10)
		{
			System.out.println("Too  much low");
		}
		else
		{
			System.out.println("somewhat low");
		}
	}
	return false;
	}
}


public class GuessTheNumber
{
	public static int takeIntegerInput(int limit)
	{
		int input = 0;
		boolean flag = false;
		while (!flag)
		{
			try
			{
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				if(flag && input > limit || input<1)
				{
					System.out.println("choose the number between 1 to " + limit);
					flag = false;
				}
			}
			catch (Exception e)
			{
				System.out.println("Enter integer value");
				flag = false;
			}
		};
		return input;
	}
	public static void main(String[] args)
	{
		System.out.println("1. Start the Game :) \n2.Exit :(");
		System.out.println("Enter your option : ");
		int choice = takeIntegerInput(2);
		int nextRound = 1;
		int noOfRound = 0;
		if(choice == 1)
		{
			while(nextRound == 1)
			{
				Game game = new Game();
				boolean isMatched = false;
				boolean isLimitCross = false;
				System.out.println("\nGood to see you \nRound "+ ++noOfRound + " starts.....");
				while(!isMatched && !isLimitCross)
				{
					isLimitCross = game.takeUserInput();
					isMatched = game.isCorrectGuess();
				}
				System.out.println("1. Next Round \n2. Exit");
				System.out.println("Enter your option : ");
				nextRound = takeIntegerInput(2);
				if(nextRound != 1)
				{
					System.exit(0);
				}
			}
		}
		else
		{
			System.exit(0);
		}
	}
}	
		
		



