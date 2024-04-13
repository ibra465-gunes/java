package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import model.ModelAdmin;

import model.ModelPersonel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ServicePersonel {

    DecimalFormat df = new DecimalFormat("#");
    Object[] dizi = new Object[8];
    Object[] array;
    Object[] array1;
    private List<Object[]> list = new ArrayList<>();
    private List<Object[]> list1 = new ArrayList<>();

    public List readAllFile(ModelPersonel personel) {
        try {
            FileInputStream file = new FileInputStream(new File("D:\\Çok Gizli Belgeler\\kod çalışmalarım\\java\\JFrame çalışmaları\\Staj Projesi\\src\\model\\PersonelInfo.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    array = new Object[8];
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() == CellType.NUMERIC) {
                        array[0] = cell.getNumericCellValue();
                    } else if (cell.getCellType() == CellType.STRING) {
                        String temp = cell.getStringCellValue();
                        System.out.println(temp);
                        break;
                    }
                    array[0] = df.format(cell.getNumericCellValue());
                    System.out.println(array[0]);
                    cell = cellIterator.next();
                    array[1] = cell.getStringCellValue();
                    System.out.println(array[1]);
                    cell = cellIterator.next();
                    array[2] = cell.getStringCellValue();
                    cell = cellIterator.next();
                    array[3] = df.format(cell.getNumericCellValue());
                    cell = cellIterator.next();
                    array[4] = cell.getStringCellValue();
                    cell = cellIterator.next();
                    array[5] = cell.getStringCellValue();
                    cell = cellIterator.next();
                    array[6] = cell.getStringCellValue();
                    cell = cellIterator.next();
                    array[7] = cell.getStringCellValue();

                    list.add(array);
                }
            }
            file.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Object[] readAdminFile(ModelPersonel personel, String name) {
        StringTokenizer st = new StringTokenizer(name, " ");
        String name1 = st.nextToken();
        String surname = st.nextToken();
        Object[] dizi1 = new Object[8];
        int i;
        try {
            FileInputStream file = new FileInputStream(new File("D:\\Çok Gizli Belgeler\\kod çalışmalarım\\java\\JFrame çalışmaları\\Staj Projesi\\src\\model\\PersonelInfo.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Object[] dizi = new Object[8];
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                i = 1;
                int b = 0;
                while (rowIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() == CellType.NUMERIC) {
                        dizi[0] = cell.getNumericCellValue();
                    } else if (cell.getCellType() == CellType.STRING) {
                        String temp = cell.getStringCellValue();
                        if (temp.equals(name1)) {
                            dizi[1] = cell.getStringCellValue();
                            cell = cellIterator.next();
                            temp = cell.getStringCellValue();
                            if (temp.equals(surname)) {
                                dizi[2] = cell.getStringCellValue();
                                cell = cellIterator.next();
                                dizi[3] = cell.getNumericCellValue();
                                cell = cellIterator.next();
                                dizi[4] = cell.getStringCellValue();
                                cell = cellIterator.next();
                                dizi[5] = cell.getStringCellValue();
                                cell = cellIterator.next();
                                dizi[6] = cell.getStringCellValue();
                                cell = cellIterator.next();
                                dizi[7] = cell.getStringCellValue();
                                dizi1 = dizi;
                                b++;
                                break;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    i++;

                }
                if (b == 1) {
                    break;
                }
            }
            for (int a = 0; a < 8; a++) {
                System.out.println(dizi1[a]);
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dizi1;
    }

    public List readSearchFile(ModelPersonel personel, String name, String surname) {
        try {
            FileInputStream file = new FileInputStream(new File("D:\\Çok Gizli Belgeler\\kod çalışmalarım\\java\\JFrame çalışmaları\\Staj Projesi\\src\\model\\PersonelInfo.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            System.out.println(name + " " + surname);
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    array1 = new Object[8];
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() == CellType.NUMERIC) {
                        array1[0] = cell.getNumericCellValue();
                    } else if (cell.getCellType() == CellType.STRING) {
                        break;
                    }
                    array1[0] = df.format(cell.getNumericCellValue());
                    cell = cellIterator.next();
                    if (name.equals(cell.getStringCellValue())) {
                        array1[1] = cell.getStringCellValue();
                        cell = cellIterator.next();
                        if (surname.equals(cell.getStringCellValue())) {
                            array1[2] = cell.getStringCellValue();
                            cell = cellIterator.next();
                            array1[3] = df.format(cell.getNumericCellValue());
                            cell = cellIterator.next();
                            array1[4] = cell.getStringCellValue();
                            cell = cellIterator.next();
                            array1[5] = cell.getStringCellValue();
                            cell = cellIterator.next();
                            array1[6] = cell.getStringCellValue();
                            cell = cellIterator.next();
                            array1[7] = cell.getStringCellValue();
                            list1.add(array1);
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            file.close();
            return list1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list1;
    }

    public int writePersonel(ModelPersonel personel) {
        int countRow = 0;
        try {
            FileInputStream file = new FileInputStream(new File("D:\\Çok Gizli Belgeler\\kod çalışmalarım\\java\\JFrame çalışmaları\\Staj Projesi\\src\\model\\PersonelInfo.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                rowIterator.next();
                countRow++;
                System.out.println("1");
            }
            Iterator<Row> rowIterator1 = sheet.iterator();
            int a = countRow;
            while (rowIterator1.hasNext()) {
                rowIterator1.next();
                a--;
                if (a == 0) {
                    Row row = sheet.createRow(countRow++);
                    int cellnum = 0;
                    while (cellnum < 9) {
                        Cell cell = row.createCell(cellnum++);
                        switch (cellnum) {
                            case 1:
                                cell.setCellValue((Integer) (--countRow));
                                break;
                            case 2:
                                cell.setCellValue((String) personel.getName());
                                break;
                            case 3:
                                cell.setCellValue((String) personel.getSurname());
                                break;
                            case 4:
                                cell.setCellValue((Integer) personel.getAge());
                                break;
                            case 5:
                                cell.setCellValue((String) personel.getEmail());
                                break;
                            case 6:
                                cell.setCellValue((String) personel.getPhoneNumber());
                                break;
                            case 7:
                                cell.setCellValue((String) personel.getAdress());
                                break;
                            case 8:
                                cell.setCellValue((String) personel.getDepartmant());
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
            file.close();
            FileOutputStream file1 = new FileOutputStream(new File("D:\\Çok Gizli Belgeler\\kod çalışmalarım\\java\\JFrame çalışmaları\\Staj Projesi\\src\\model\\PersonelInfo.xlsx"));
            workbook.write(file1);
            file1.close();
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }
    public void deleteSearchFile(String name, String surname) {
        try {
            FileInputStream file = new FileInputStream(new File("D:\\Çok Gizli Belgeler\\kod çalışmalarım\\java\\JFrame çalışmaları\\Staj Projesi\\src\\model\\PersonelInfo.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            int countRow = 0;
            int b =0;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                countRow++;
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    
                    if (cell.getCellType() == CellType.NUMERIC) {
                    } else if (cell.getCellType() == CellType.STRING) {
                      
                    }
                    if(b==1){
                        int a =(int) cell.getNumericCellValue();
                        cell.setCellValue((Integer)a-1);
                    }
                    cell = cellIterator.next();
                    if (name.equals(cell.getStringCellValue())) {
                        System.out.println(name);
                        cell = cellIterator.next();
                        if (surname.equals(cell.getStringCellValue())) {
                            System.out.println(surname);
                            sheet.removeRow(row);
                            b++;
                            break;
                            
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if(b==1){
                    //sheet.shiftRows(countRow, sheet.getLastRowNum(), -1);
                    
                }
            }
            file.close();
            FileOutputStream file1 = new FileOutputStream(new File("D:\\Çok Gizli Belgeler\\kod çalışmalarım\\java\\JFrame çalışmaları\\Staj Projesi\\src\\model\\PersonelInfo.xlsx"));
            workbook.write(file1);
            file1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
