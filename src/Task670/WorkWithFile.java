package Task670;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Владислав on 24.01.2018.
 */
public class WorkWithFile {

    public int readFile(String inputTXTPath){

        String lines=null ;
        try {
            FileReader reader = new FileReader(inputTXTPath);
            Scanner scanner = new Scanner(reader);
            while(scanner.hasNextLine()) {
                lines=scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int numb=Integer.parseInt(lines);
        return numb;
    }

    public int[] createAntonNewMas(int n){
        int[] mas = new int[n];
        int k=1;
        String s;
        int eden,dec,sot,tisac,decTis;
        for (int i=1;i<mas.length;i++){
            if(i<=10){
                mas[i-k]=i;
            }
            else if(i<100){
                s=""+i;
                eden=s.charAt(s.length()-1);
                dec=s.charAt(s.length()-2);
                if(eden!=dec){
                    mas[i-k]=i;
                }
                else k++;
            }
            else if(i<1000){
                s=""+i;
                eden=s.charAt(s.length()-1);
                dec=s.charAt(s.length()-2);
                sot=s.charAt(s.length()-3);
                if(eden!=dec & eden!=sot & dec!=sot){
                    mas[i-k]=i;
                }
                else k++;
            }
            else if(i<10000){
                s=""+i;
                eden=s.charAt(s.length()-1);
                dec=s.charAt(s.length()-2);
                sot=s.charAt(s.length()-3);
                tisac=s.charAt(s.length()-4);
                if(eden!=dec & eden!=sot & dec!=sot & eden!=tisac & dec!=tisac & sot!=tisac){
                    mas[i-k]=i;
                }
                else k++;
            }
            else if(i<100000){
                s=""+i;
                eden=s.charAt(s.length()-1);
                dec=s.charAt(s.length()-2);
                sot=s.charAt(s.length()-3);
                tisac=s.charAt(s.length()-4);
                decTis=s.charAt(s.length()-5);
                if(eden!=dec & eden!=sot & dec!=sot & eden!=tisac & dec!=tisac & sot!=tisac & decTis!=eden & decTis!=dec & decTis!=sot & decTis!=tisac){
                    mas[i-k]=i;
                }
                else k++;
            }
        }
        return mas;
    }

    public void  writeFile(int n) throws IOException {
        FileWriter nFile = new FileWriter(System.getProperty("user.dir")+"/src/Task670/output.txt");
        nFile.write(n+"");
        nFile.close();
    }
}
