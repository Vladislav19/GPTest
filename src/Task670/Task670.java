package Task670;

import java.io.IOException;

/**
 * Created by Владислав on 24.01.2018.
 */
public class Task670 {
    public static void main(String[] args) throws IOException {
        WorkWithFile workWithFile = new WorkWithFile();
        int n = workWithFile.readFile(System.getProperty("user.dir")+"/src/Task670/input.txt");
        int mas[] = workWithFile.createAntonNewMas(9999);
        workWithFile.writeFile(mas[n-1]);

    }


}
