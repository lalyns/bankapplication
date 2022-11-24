package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IOmanager {
    List<List<String>> ret = new ArrayList<>();
    BufferedReader br = null;
    
    public IOmanager() {
    }

    public void readCSV(String path) {
        try {
            var temp = path;
            Path temp2 = Paths.get(temp);
            br = Files.newBufferedReader(temp2);
            String line = "";

            while((line = br.readLine()) != null){
                // CSV 1행을 저장하는 리스트
                List<String> tmpList = new ArrayList<>();
                String array[] = line.split(",");
                // 배열에서 리스트 반환
                tmpList = Arrays.asList(array);
                System.out.println(tmpList);
                ret.add(tmpList);
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(br != null){
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public void writeCSV(String path) {
        File csv = new File(path);
    }
}
