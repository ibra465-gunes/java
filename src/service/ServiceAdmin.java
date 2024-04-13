package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import menu.MenuPage;
import model.ModelAdmin;
import model.ModelAdminRegister;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ServiceAdmin {
    private  MenuPage menu = new MenuPage();
    public int readFile(ModelAdmin admin) {
        try {
            FileInputStream file = new FileInputStream(new File("D:\\Çok Gizli Belgeler\\kod çalışmalarım\\java\\JFrame çalışmaları\\Staj Projesi\\src\\model\\AdminInfo.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() == CellType.NUMERIC) {

                    } else if (cell.getCellType() == CellType.STRING) {
                        String name = cell.getStringCellValue();
                        if (name.equals(admin.getName())) {
                            cell = cellIterator.next();
                            System.out.println(name);
                            String surname = cell.getStringCellValue();
                            if (surname.equals(admin.getSurname())) {
                                cell = cellIterator.next();
                                System.out.println(surname);
                                String password = cell.getStringCellValue();
                                if (password.equals(admin.getPassword())) {
                                    System.out.println(password);
                                    menu.setBottomText(name+" "+surname);
                                    return 1;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }

    public int readFileForRegister(ModelAdminRegister adminRegister) {
        try {
            FileInputStream file = new FileInputStream(new File("D:\\Çok Gizli Belgeler\\kod çalışmalarım\\java\\JFrame çalışmaları\\Staj Projesi\\src\\model\\AdminInfo.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() == CellType.NUMERIC) {

                    } else if (cell.getCellType() == CellType.STRING) {
                        String name = cell.getStringCellValue();
                        if (name.equals(adminRegister.getAdminRName())) {
                            cell = cellIterator.next();
                            System.out.println(name);
                            String surname = cell.getStringCellValue();
                            if (surname.equals(adminRegister.getAdminRSurname())) {
                                cell = cellIterator.next();
                                System.out.println(surname);
                                String password = cell.getStringCellValue();
                                if (password.equals(adminRegister.getAdminRPassword())) {
                                    System.out.println(password);
                                    return 1;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }

    public void writeRegister(ModelAdmin admin) {
        int countRow = 0;
        try {
            FileInputStream file = new FileInputStream(new File("D:\\Çok Gizli Belgeler\\kod çalışmalarım\\java\\JFrame çalışmaları\\Staj Projesi\\src\\model\\AdminInfo.xlsx"));
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
                    while (cellnum < 5) {
                        Cell cell = row.createCell(cellnum++);
                        switch (cellnum) {
                            case 1:
                                cell.setCellValue((Integer) (--countRow));
                                break;
                            case 2:
                                cell.setCellValue((String) admin.getName());
                                break;
                            case 3:
                                cell.setCellValue((String) admin.getSurname());
                                break;
                            case 4:
                                cell.setCellValue((String) admin.getPassword());
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
            file.close();
            FileOutputStream file1 = new FileOutputStream(new File("D:\\Çok Gizli Belgeler\\kod çalışmalarım\\java\\JFrame çalışmaları\\Staj Projesi\\src\\model\\AdminInfo.xlsx"));
            workbook.write(file1);
            file1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
