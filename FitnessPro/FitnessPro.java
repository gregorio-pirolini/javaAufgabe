package FitnessPro;

import java.util.Scanner;

/**
 * Fitness
 */
public class FitnessPro {

    //  definieren training class
    static class Training {
        String activities;
        String time;
        String weight;
      
        Training(String activities, String time, String weight) {
          this.activities = activities;
          this.time = time;
          this.weight = weight;
        }
    }
       //  definieren training from class Training
    static Training training = new Training("", "", "");
 //  definieren menu points
    static String[] activities = {"Radfahren", "Laufen", "Walken", "Programm verlassen"};
    static String[] time = {"15 min", "30 min", "45 min", "60 min", "Programm verlassen"};
    static String[] weight = {"55-64 kg"," 65-74 kg","75-84 kg","85-94 kg","95-104 kg","105-114 kg", "115-124 kg", "Programm verlassen"};
 //  add scanner
    static Scanner sc = new Scanner(System.in);

 //  !! STARTING HERE
    public static void main(String[] args) {
        System.out.println("Fitness");
        loadMenu(activities);
       int index = saveResponseMenu(activities);
         if(index > 3){main(null);} else{training.activities =activities[index]; } 
   loadMenu(time);
   int indexTime = saveResponseMenu(time);
   if(indexTime > 4){main(null);} else{training.time =time[indexTime]; } 

    
    loadMenu(weight);
    int indexWeight = saveResponseMenu(weight);
    if(indexWeight > 7){main(null);} else{training.weight =weight[indexWeight]; } 

    System.out.println(training.activities);

}

    private static int saveResponseMenu(String[] arr) {
        String answer = sc.next().toUpperCase();
        
        if (answer.equals("A")) {
            return 0;
          
             
        } else if (answer.equals("B")) {
            return 1;
           
        } else if (answer.equals("C")) {
            return 2;
          
        } else if (answer.equals("D")) {
            return 3;
           
        } else if (answer.equals("E")){
            return 4;
           
           
        } else if (answer.equals("E")){
            return 5;
          
    } else if (answer.equals("F")){
        return 6;
  
} else if (answer.equals("G")){
    return 7;
}  else{return 8;}
    
           
           
        
    }

    private static void loadMenu(String[]arr ) {
        System.out.println("Menu");
        char letter = 'A';
        for (int i = 0; i < arr.length; i++) {
            System.out.println("for " + arr[i] + " press " + letter);
            letter++;
        }
    }
}