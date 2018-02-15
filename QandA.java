public class QandA
{
    private String question;
    private String [] answer = new String[10];

    public QandA(String question, String[] answer)//Constructor that initializes question string and its respective answer strings
    {
        this.question = question;
        for (int i = 0; i<10; i++)
            this.answer[i] = answer[i];
    }

    public int check (String guess) // method that see if guess matches anything in answer arry 
    {
        int correct = -1;
        guess.replaceAll(" ", ""); // get rid of empty spaces 
        for(int i = 0; i<10; i++) // going through the arry 
        {
            answer[i].replaceAll(" ",""); // to get rid of empty spaces 
            if(answer[i].equalsIgnoreCase(guess)) // guess equals to anything in answer array 
                correct = i; 
        }
        return correct; //return where the correct answer was in the array 
    }

    public String getQuestion() //Method that returns question String
    {
        return question;
    }

    public String answer(int num) //Method that returns answer String at given index
    {
        return answer[num];
    }
}