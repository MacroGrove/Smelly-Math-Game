import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

	private Scanner sc;	// 
	private Random r;	// 
	private ArrayList<String> operations;	//
	private int level; 	// 
	private int points;	// 

	public Game() {
		sc = new Scanner(System.in);
		r = new Random();
		operations = new ArrayList<String>();
		operations.add("+");
		level = 1;
		points = 0;
	}

	/**
	 * 
	 */
	public void play() {
		int part1, part2, numCorrect = 0, numWrong = 0;
		double guess = -1, answer = -1;
		String op;

		// 
		while (true) {
			
			//
			part1 = r.nextInt(10);
			op = operations.get(r.nextInt(operations.size()));
			part2 = r.nextInt(10);

			// 
			if (op.equals("+")) {
				answer = part1 + part2;
			} else if (op.equals("-")) {
				answer = part1 - part2;
			} else if (op.equals("*")) {
				answer = part1 * part2;
			} else if (op.equals("/")) {
				answer = part1 / part2;
			} else if (op.equals("**")) {
				answer = Math.pow(part1, part2);
			} else {
				System.out.println("Error!");
			}

			// 
			if (numCorrect == 5) {
				System.out.println("Level Up!");
				levelUp(level++);
				numCorrect = 0;
			} else if (numWrong == 5 && level > 1) {
				System.out.println("Level Down!");
				levelUp(level--);
				numWrong = 0;
			}

			// 
			System.out.printf("\n%d %s %d = ", part1, op, part2);
			guess = sc.nextDouble();

			// 
			if (guess == answer) {
				System.out.println("Correct!");
				numCorrect++;

				if (numWrong > 0) {
					numWrong--;
				}
			} else {
				System.out.println("Incorrect.");
				numWrong++;

				if (numCorrect > 0) {
					numCorrect--;
				}
			}
		}
	}

	/**
	 * 
	 * @param level
	 */
	public void levelUp(int level) {
		switch (level) {
		case 1:
			if (level == 1) {
				operations.remove("-");
			}
		case 2:
			if (level > 2) {
				operations.remove("*");
			} else {
				operations.add("-");
			}
			break;
		case 3:
			if (level > 3) {
				operations.remove("/");
			} else {
				operations.add("*");
			}
			break;
		case 4:
			if (level > 4) {
				operations.remove("**");
			} else {
				operations.add("/");
			}
			break;
		case 5:
			operations.add("**");
			break;
		}
	}

	/**
	 * 
	 */
	public void restart() {
		points = 0;
		operations.clear();
	}

}
