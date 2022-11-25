package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IOmanager {
    List<List<String>> ret = new ArrayList<>();
    BufferedReader br = null;
    
    public IOmanager() {
    }

    public String createCSV(String path, int index) {

        String fileName = "trade" + index + ".csv";
        File csv = new File(path + fileName);

        FileOutputStream output = null;
        BufferedWriter bw = null;
        
        try {
            output = new FileOutputStream(csv, true);
            bw = new BufferedWriter(new OutputStreamWriter(output, "UTF-8"));
            String aData = "일자,시간,I/O,금액,은행명";
            bw.write(aData);
            bw.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if (bw!=null) {
                    bw.flush();
                    bw.close();
                } 
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 

        return fileName;
    }

    public List<List<String>> readCSV(String path) {
        try {
            // 입력 스트림 생성
            FileInputStream input = new FileInputStream(path);
            InputStreamReader reader = new InputStreamReader(input, "UTF-8");
            br = new BufferedReader(reader);
            String line = "";

            while((line = br.readLine()) != null) {
                // CSV 1행을 저장하는 리스트
                List<String> tmpList = new ArrayList<>();
                String array[] = line.split(",");
                // 배열에서 리스트 반환
                tmpList = Arrays.asList(array);
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
                if(br != null) {
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return ret;
    }

    public void writeCSV(String path, List<String> list) {

        File csv = new File(path);
        FileOutputStream output = null;
        BufferedWriter bw = null;

        try {
            // 출력 스트림 생성
            output = new FileOutputStream(csv, true);
            bw = new BufferedWriter(new OutputStreamWriter(output, "UTF-8"));
            String aData = "";
            for(int i=0; i<list.size(); i++){
                aData += list.get(i);
                aData += ",";
            }
            bw.write(aData);
            bw.newLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw!=null) {
                    bw.flush();
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
