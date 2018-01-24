package Task278;




import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Владислав on 24.01.2018.
 */
public class Task278 {

    public static void main(String[] args) {
        Task278 task278 = new Task278();
        ArrayList<String> strings = task278.readFile();
        String answer = task278.doLogic(strings);
        try {
            task278.writeFile(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private ArrayList<String> readFile(){
        ArrayList<String> strings = new ArrayList<>();

        try {
            FileReader reader = new FileReader("D:\\Projects\\GPTest\\src\\Task278\\input.txt");
            Scanner scanner = new Scanner(reader);
            while(scanner.hasNextLine()) {
                strings.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return strings;
    }

    private String doLogic(ArrayList<String> strings){
        String answer;
        char[] s = strings.get(0).toCharArray();
        char[] t = strings.get(1).toCharArray();
        int n=0;
        int j=0;
        char[] result = new char[t.length];
        for(int i=0;i<s.length;i++){
            if(n<t.length){
                n = searchElem(n,s[i],t);
                if(n<t.length){
                    result[j]=t[n];
                    j++;
                }
                else break;
            }
        }
        String res="";
        for (char a:result) {
            res+=a;
        }
        String st="";
        for (char a:s) {
            st+=a;
        }
        if(st.trim().equals(res.trim())){
            answer="YES";
        }
        else answer="NO";
        return answer;
    }

    private int searchElem(int indexStart, char elem, char[] mas){
        int i;
        if(indexStart==0){
            indexStart=0;
        }
        else indexStart=indexStart+1;
        for ( i=indexStart;i<mas.length;i++){
            if (mas[i]==elem){
                return i;
            }
        }
        return i;
    }

    private void writeFile(String answer) throws IOException {
        FileWriter nFile = new FileWriter("D:\\Projects\\GPTest\\src\\Task278\\output.txt");
        nFile.write(answer);
        nFile.close();
    }
}
