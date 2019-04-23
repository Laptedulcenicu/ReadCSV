package com.nicu;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.sql.SQLException;


public class Main1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        String csvFile = "C:\\Users\\SweetMilk\\Desktop\\ReadCSV\\file\\Interview-task-data-osh.csv";   //sa da denumirea fisierului care o sa fie citit
        CSVReader reader = null;
        String csv1 = "C:\\Users\\SweetMilk\\Desktop\\ReadCSV\\file\\bad-data-timestamp.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(csv1));
         int Successful;
         int Failed = -1;
         int Received = -1;//-1 because program consider the las line also like a data


        conn conection = new conn();
        conection.CreateDB();

        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                Received++;
                if (line[0].isEmpty() || line[1].isEmpty() || line[2].isEmpty() || line[3].isEmpty() || line[4].isEmpty() || line[5].isEmpty() || line[6].isEmpty() || line[7].isEmpty() || line[8].isEmpty() || line[9].isEmpty()) {
                    writer.writeNext(line);
                    Failed++;
                    continue;
                }
                conection.WriteDB(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7], line[8], line[9]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        conection.CloseDB();
        writer.close();

        Successful = Received - Failed;
        File fout = new File("C:\\Users\\SweetMilk\\Desktop\\ReadCSV\\file\\statistics.log");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        bw.write("All is " + Received);
        bw.newLine();
        bw.write("Succesiful is " + Successful);
        bw.newLine();
        bw.write("Faild is " + Failed);
        bw.close();
    }
}