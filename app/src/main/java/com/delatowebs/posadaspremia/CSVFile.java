package com.delatowebs.posadaspremia;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVFile {
    InputStream inputStream;

    public CSVFile(InputStream inputStream){
        this.inputStream = inputStream;
    }

    public List read(){
        List resultList = new ArrayList();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null) {
                String[] row = csvLine.split(";");
                if (row.length > 1){
                    resultList.add(row);
                }

            }
        }
        catch (IOException ex) {
            throw new RuntimeException("Error leyendo el archivo CSV: "+ex);
        }
        finally {
            try {
                inputStream.close();
            }
            catch (IOException e) {
                throw new RuntimeException("Error while closing input stream: "+e);
            }
        }
        return resultList;
    }

    public ArrayList<Padron> readPadron(){
        ArrayList<Padron> padronList = new ArrayList<Padron>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null) {
                String[] row =csvLine.split(";", 9);
                if (row.length > 1){
                    Padron oPadron = new Padron(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8]);
                    padronList.add(oPadron);
                }

            }
        }
        catch (IOException ex) {
            throw new RuntimeException("Error leyendo el archivo CSV: "+ex);
        }
        finally {
            try {
                inputStream.close();
            }
            catch (IOException e) {
                throw new RuntimeException("Error while closing input stream: "+e);
            }
        }
        return padronList;
    }
}