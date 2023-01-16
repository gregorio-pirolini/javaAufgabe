import java.util.ArrayList;
import java.util.Scanner;
 

public class AufgabeQuizz {
	/*
	 * Aufgabe Java-Quiz Hinweise: Teambildung und nutzen von Google erwünscht!!!
	 * Anforderung: Das Programm soll nach dem Start ein Hauptmenü anzeigen. Es soll
	 * folgende Auswahl möglich sein: (S) Start (Q) Quiz beenden.
	 * 
	 * Wenn das Quiz gestartet wurde, soll eine Frage ausgegeben und darunter 4
	 * Antwortmöglichkeiten: Bsp. "Was ist Java ebenfalls?" A) Eine Insel B) Ein
	 * Fluss C) Ein Königreich D) Ein Betriebssystem
	 * 
	 * Zum Vergleichen der Eingabe werden nur Großbuchstaben beim Auswerten der
	 * Eingabe erlaubt. Sollte ein Kleinbuchstabe eingegeben werden, so überlegen
	 * Sie was zu tun ist. (Neue Eingabe verlangen oder Kleinbuchstabe in
	 * Großbuchstaben umwandeln (eventuell bietet die String-Klasse eine Methode).
	 * Wenn die Antwort richtig war, soll die nächste Frage ausgegeben werden usw.
	 * (5 mal maximal durchlaufen). Wurde aber eine falsche Antwort gegeben, soll
	 * eine Ausgabe erfolgen, daß die falsche Antwort gegeben wurde und die
	 * erreichten Punkteanzahl. Pro richtige Antwort bekommt man 1 Punkt.
	 * Anschließend soll eine Abfrage erfolgen, ob man noch einmal spielen möchte
	 * oder nicht. Wenn ja, werden die Fragen erneut angezeigt und wenn nicht, wird
	 * das Quiz beendet. Tip: Eventuell lagern sie Code in entsprechende Methoden
	 * aus. Aufgabe: Entwickeln Sie ein Struktogramm für die Eingabe der
	 * Menüauswahl, der eigentlichen Quizfragenlogik und den entsprechenden
	 * Quellcode. Zusatzaufgabe: 1.) Wenn Sie im Menü sind und eine Zahl eingeben,
	 * die nicht vorgegeben ist, soll ein Hinweistext ausgegeben werden und das Menü
	 * erneut angezeigt werden. 2.) Was passiert, wenn Sie eine Taste drücken im
	 * Menü, die keine Zahl ist? Überlegen Sie erst und testen Sie es denn.
	 * Versuchen Sie dafür einen Workaround(Lösung) zu finden. 3.) Lassen Sie die
	 * Fragen zufälliger Reihenfolge anzeigen. Tip: Random-Klasse oder Math-Klasse
	 */

	static String[][] myQuestions = {
			{ "Was ist Java ebenfalls?", "A) Eine Insel", "B) Ein Fluss", "C) Ein Königreich", "D) Ein Betriebssystem","A" },
			{ "click A", "A) Volvo", "B) BMW", "C) Ford", "D) Mazda", "B" },
			{ "click B", "A) Volvo", "B) BMW", "C) Ford", "D) Mazda", "C" },
			{ "click C", "A) Volvo", "B) BMW", "C) Ford", "D) Mazda", "D" },
			{ "click D", "A) Volvo", "B) BMW", "C) Ford", "D) Mazda", "A" }, };
 
	static ArrayList <String> allowed = new ArrayList <String> (); // Create an ArrayList object
	
	
	static int round=0;
	static int turn=1;
	static int points=0;
	
	static Scanner sc = new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		allowed.add("A");
		allowed.add("B");
		allowed.add("C");
		allowed.add("D");
		

		if(round>0) {
			System.out.println("You have: "+ points+ "points" );
		}
		System.out.println("Main Menu");
		if(round>0) {
			System.out.println("You have: "+ points+ "points" );
			System.out.println("(S) RE-Start\r\n" + "(Q) Quiz beenden");
		}else {System.out.println("(S) Start\r\n" + "(Q) Quiz beenden");}
		
		
		String Choice = sc.next().toUpperCase();

		if (Choice.equals("S")) {
			System.out.println("starting...");
			round=0;
			turn=1;
			questionMe();
		} else if (Choice.equals("Q")) {
			System.out.println("Restarting...");
			main(null);
		} else {
			System.out.println("couldnt understand & Restarting...");
			main(null);
		}
	 

	}

	private static void questionMe() {
		// TODO Auto-generated method stub
	 

		System.out.println("round "+turn);
		System.out.println("turn "+turn +" points "+points   );
		System.out.println(myQuestions[round][0]);
		System.out.println(myQuestions[round][1]);
		System.out.println(myQuestions[round][2]);
		System.out.println(myQuestions[round][3]);
		System.out.println(myQuestions[round][4]);
		String Choice = sc.next().toUpperCase();

			boolean inputCorrect=checkinput(Choice);
			if(inputCorrect) {
				checkAnswer(Choice);
				if(round<4) {
					round++;
					turn++;
					questionMe();
				}else {main(null);}
				
				
			}else {
				System.out.println("couldnt understand & i ask again...");
				questionMe();
			}
			
		 
	}

	private static void checkAnswer(String choice) {
		// TODO Auto-generated method stub
		if(choice.equals(myQuestions[round][5])) {points++;}

		
		
	}

	private static boolean checkinput(String choice) {
		// TODO Auto-generated method stub
		boolean correct = false;
		if(allowed.contains(choice)) {correct = true;}
		return correct;
	}
}
