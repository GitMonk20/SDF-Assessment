package sg.edu.nus.iss;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;    
import java.io.FileReader;    
import java.util.ArrayList; 

public class MyReader implements Runnable {
 
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {    

        //Gathering all the files from a directory and reading through them
        String target_dir = "C:\Users\ravis\Downloads\Assessmen\task02\seuss";  
        String para;
        File dir = new File(target_dir);

        //Using hashmap collection
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (File file: files) {
            if(file.isFile()){
                BufferedReader inputStream = null;

                //Strip all punctuations from a word and universally change to lowercase
                try{
                    inputStream = new BufferedReader(new FileReader(file));
                    while ((line = inputStream.readLine())!= null){
                    System.out.println(para);
                    processedLine = line.replaceAll("[^a-zA-Z0-9]"," ").toLowerCase().replaceAll("( )+-!", " ");
                    out.write(processedLine);
                    out.write(System.getProperty("line.separator"));
                    }
                //Splitting up of the words
                String arr[]=str.split(" ");

                //Finding the frequency of next words
                for(int i=0,i<arr.length,i++)
                {
                    if (map.containsKey(arr[i]))
                    {
                        map.put(arr[i],map.get(arr[i])+1);
                    }
                    else{
                        map.put(arr[i],1);
                    }
                    count_freq(str);

                //Count of all next words
                int count=0;
                for (int i=0, i<str.length(); i++);
                {
                    if(str.charAt(i)== ' ')
                    count++;
                    count = count + 1;
                }
                int probability = 
                }
for(String arr: map.containsKey()){
    System.out.println(para + " " +map.get(para));
}
              
            }
        }

    
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }

