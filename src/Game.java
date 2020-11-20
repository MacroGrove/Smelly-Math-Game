import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Game {

	private Scanner sc; //
	private Random r; //
	private JLabel label;
	private JTextField text;
	private ArrayList<String> operations; //
	private int level; //
	private int points; //
	int part1, part2, numCorrect = 0, numWrong = 0;
	double guess = -1, answer = -1;
	String op;

	public Game(JLabel l, JTextField t) {
		sc = new Scanner(System.in);
		r = new Random();
		label = l;
		text = t;
		operations = new ArrayList<String>();
		operations.add("+");
		level = 1;
		points = 0;
	}

	public void setEquation() {
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
		} else if (op.equals("^")) {
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
//		System.out.printf("\n%d %s %d = ", part1, op, part2);
		label.setText(part1 + " " + op + " " + part2 + " = ");
	}

	public void guess() {
		guess = Integer.valueOf(text.getText());

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
