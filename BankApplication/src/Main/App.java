package Main;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.IOmanager;

public class App {
    public static void main(String[] args) throws Exception {
        IOmanager reader = new IOmanager();
        
        Path accountPath = Paths.get("src/com/account.csv");
        reader.readCSV(accountPath);
    }
}
