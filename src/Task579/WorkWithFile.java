package Task579;

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
    public ArrayList<String> readFile(String inputTXTPath){
        ArrayList<String> lines = new ArrayList<>(2);
        try {
            FileReader reader = new FileReader(inputTXTPath);
            Scanner scanner = new Scanner(reader);
            while(scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void  writeFile(ArrayList<Integer> indexes) throws IOException {
        FileWriter nFile = new FileWriter(System.getProperty("user.dir")+"/src/Task579/output.txt");
        nFile.write(indexes.size()+"\n");
        for(int i=0;i<indexes.size();i++){
            nFile.write(indexes.get(i)+1+" ");
        }

        nFile.close();
    }
}
