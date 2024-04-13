package log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Logger {

    List<Object[]> list = new ArrayList<>();

    public void logger(String string) {
        try {
            File file = new File("D:\\Çok Gizli Belgeler\\kod çalışmalarım\\java\\JFrame çalışmaları\\Staj Projesi\\src\\log\\Logger.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("\n" + string + " " + date());
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String date() {
        SimpleDateFormat format = new SimpleDateFormat();
        Date date = new Date();
        return format.format(date);
    }

    public List readLogger() {
        try {
            File file = new File("D:\\Çok Gizli Belgeler\\kod çalışmalarım\\java\\JFrame çalışmaları\\Staj Projesi\\src\\log\\Logger.txt");
            FileReader fileReader = new FileReader(file);
            String[] line = new String[1];
            BufferedReader br = new BufferedReader(fileReader);
            System.out.println(br.readLine());
            while ((line[0] = br.readLine()) != null) {
                line = new String[1];
                list.add(line);
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
