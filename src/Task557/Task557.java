package Task557;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Владислав on 25.01.2018.
 */
public class Task557 {
    public static void main(String[] args) throws IOException {
        Task557 task557 = new Task557();
        ArrayList<String> strings= task557.readFile();
        int[] infoAboutMas = task557.parseInfo(strings);
        ArrayList<int[][]> masMas = task557.parseMas(strings,infoAboutMas);
        System.out.println(masMas.size());
        int[][] mas = task557.doMathPart(masMas,infoAboutMas);
        System.out.println(mas[0][1]);
        FileWriter nFile = new FileWriter("D:\\Projects\\GPTest\\src\\Task557\\output.txt");
        nFile.write(mas[0][1]+"");
        nFile.close();
    }

    private ArrayList<String> readFile(){
        ArrayList<String> strings = new ArrayList<>();

        try {
            FileReader reader = new FileReader("D:\\Projects\\GPTest\\src\\Task557\\input.txt");
            Scanner scanner = new Scanner(reader);
            while(scanner.hasNextLine()) {
                strings.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return strings;
    }

    private int[] parseInfo(ArrayList<String> strings){
        int[] mas = new int[5];
        String[] first=strings.get(0).split(" ");
        String[] second=strings.get(1).split(" ");
        int a=Integer.parseInt(strings.get(2));
        mas[0]=Integer.parseInt(first[0]);
        mas[1]=Integer.parseInt(first[1]);
        mas[2]=Integer.parseInt(second[0]);
        mas[3]=Integer.parseInt(second[1]);
        mas[4]=a;
        return mas;
    }

    private ArrayList<int[][]> parseMas(ArrayList<String> strings, int[] mas){
        int [][] massive = new int[mas[1]][mas[1]];
        ArrayList<int[][]> masMas =new ArrayList<>();
        int indexFirstMassiveStr = 4;
        int indexLastString = indexFirstMassiveStr+(2*mas[0]+1);
        int kolvoMas = mas[0];
        int razmerMas = mas[1];
        int j=0,i=0,k=0;
        ArrayList<String> masLine = new ArrayList<>(razmerMas);
        while( j<kolvoMas){
            i=0;
            while (i<razmerMas){
                masLine.add(i,strings.get(indexFirstMassiveStr));
                indexFirstMassiveStr++;
                i++;
            }

            indexFirstMassiveStr=indexFirstMassiveStr+1;
            masMas.add(compMas(masLine,razmerMas));
            if(indexFirstMassiveStr>indexLastString){
                break;
            }

            j++;
        }
        return masMas;
    }

    private int[][] compMas(ArrayList<String> masLine, int size){
        int[][] mas = new int[size][size];

        for(int i=0;i<size;i++){
            String elemMasByOneStr[] = masLine.get(i).split(" ");
            for(int j=0;j<size;j++){
                mas[i][j]=Integer.parseInt(elemMasByOneStr[j]);
            }
        }
        return mas;
    }

    private int[][] doMathPart(ArrayList<int[][]> mas, int[] info){

        int[][] startMas = mas.get(0);
        for(int i=1;i<mas.size();i++){
            int[][] secondMas = mas.get(i);
            startMas=matrYmnosh(startMas,secondMas,info[1]);
        }


        return startMas;

    }

    private int[][] matrYmnosh(int[][] first,int[][] second, int size){
        int c[][] = new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                c[i][j]=0;
                for(int k=0;k<size;k++){
                    c[i][j]+=first[i][k]*second[k][j];
                }
                if(c[i][j]>=239){
                    c[i][j]=c[i][j]%239;
                }
            }
        }

        return c;
    }
}
