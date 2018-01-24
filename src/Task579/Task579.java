package Task579;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Владислав on 24.01.2018.
 */
public class Task579 {
    public static void main(String[] args) throws IOException {
        Task579 task = new Task579();
        int[] mass = task.parseDate();
        ArrayList<Integer> index = task.logic(mass);
        WorkWithFile workWithFile = new WorkWithFile();
        workWithFile.writeFile(index);
    }

    public int[] parseDate(){
        WorkWithFile workWithFile = new WorkWithFile();
        ArrayList<String> lines = workWithFile.readFile("D:\\Projects\\GPTest\\src\\Task579\\input.txt");
        int size = Integer.parseInt(lines.get(0));
        int[] arr = new int[size];
        String[] numb=lines.get(1).split(" ",size);
        for(int i=0;i<size;i++){
            arr[i]= Integer.parseInt(numb[i]);
        }
        return arr;
    }

    public ArrayList<Integer> logic(int[] arr){
        int plusSum=0;ArrayList<Integer> indexPlus = new ArrayList<>();
        int minusSum=0;ArrayList<Integer> indexMinus = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            if(arr[i]>=0){
                plusSum=plusSum+arr[i];
                indexPlus.add(i);
            }
            else {
                minusSum=minusSum+arr[i];
                indexMinus.add(i);
            }
        }

        if(plusSum>=Math.abs(minusSum)){
            return indexPlus;
        }
        else{
            return indexMinus;
        }
    }
}
