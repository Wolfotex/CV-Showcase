import java.util.Scanner;

public class Task2b {
    // test cases
    // "helllo" (a word with a repeated letter)
    //"helo" (a word missing a letter)
    //"helloo" (a word with an extra letter)
    //"halo" (a word with a different letter substitution)
    //"hullo" (a word with a different letter substitution that sounds similar)
    public static void main(String[] args) {
        Checker checker = new Checker();
        Scanner input = new Scanner(System.in);
        String word, option;

        // create the set of words
        checker.createDictionary();

       while (true){
           System.out.println("""
                   \n
                   Type 'c' to check for spellings
                   Type 'e' to exit the program
                   """);
           System.out.print("Type your choice: ");
           option = input.nextLine();
           option = option.toUpperCase();

           if (option.equals("C")){
               // get input word from user
               System.out.print("Type your word: ");
               word = input.nextLine();
               word = word.toLowerCase();

               // check for spellings and display the suggested words
               LinkedList.printList(checker.checkForSpellings(word));

           } else if (option.equals("E")) {
               System.out.println("Exiting...");
               break;
           }else {
               System.out.println("Not an option, please try again.");
           }
       }
    }
}
