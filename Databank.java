import java.util.*;
import java.io.*;
public class Databank
{
    // instance variables
    private ArrayList<QandA> data = new ArrayList<QandA>();
    private int counter;
    private Random r = new Random();

    public Databank(String category)
    {
        String line;
        String [] temp = new String[2];
        String [] answerGroup = new String[10];
        String question = new String();
        int counter = 0;
        try  // try to read in file and make QandA objects 
        {
            BufferedReader brQues = new BufferedReader(new FileReader(category)); // read in file 
            while ((line = brQues.readLine())!= null) 
            {
                temp = line.split(","); // split line depending on location of commas 
                //"trump is","bad"
                //temp = {"trump is", "bad");
                //take index 1
                answerGroup [counter] = temp[1]; // add each part of temp to answerGroup 
                question = temp[0]; // question is first element in temp 
                counter ++;  // add to counter 
                if(counter == 10) // once 10 answers are filled, that's one QandA object 
                {
                    data.add(new QandA(question, answerGroup)); // add this QandA object to data array list
                    counter = 0; // set counter back to 0 
                }
            }
        }
        catch (Exception ex) 
        {
            ex.printStackTrace(); // finds what happened and where in the code error occured  
        }
        shuffle(data);
    }

    public QandA get() // returns QandA obejct 
    {
        QandA out = data.get(counter); // retrieves QandA object from data 
        counter++;
        return out;
    }

    public QandA get(int a) // returns QandA object from data depending on a 
    {
        return data.get(a);
    }

    public void swap (ArrayList<QandA> arr, int a, int b) // swaps QandA objects at position a and b in array list arr
    {
        QandA hold = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, hold);
    }

    public void shuffle (ArrayList<QandA> arr) // shuffles objects in an array list 
    {
        int a, b;
        for (int x = 0; x < 100; x++)
        {
            a = r.nextInt(arr.size());
            b = r.nextInt(arr.size());
            swap(arr, a, b);
        }
    }
}