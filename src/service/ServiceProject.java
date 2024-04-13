package service;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.ModelProject;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ServiceProject {

    DecimalFormat df = new DecimalFormat("#");
    List<Object[]> list = new ArrayList<>();
    Object[] array;

    public List readSearchFile(ModelProject project, String phrease, String subPhrease) {
        try {
            FileInputStream file = new FileInputStream(new File("D:\\Çok Gizli Belgeler\\kod çalışmalarım\\java\\JFrame çalışmaları\\Staj Projesi\\src\\model\\ProjectInfo.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            System.out.println(phrease);
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    array = new Object[5];
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() == CellType.NUMERIC) {
                        array[0] = cell.getNumericCellValue();
                    } else if (cell.getCellType() == CellType.STRING) {
                        break;
                    }
                    array[0] = df.format(cell.getNumericCellValue());
                    cell = cellIterator.next();
                    if (phrease.equals(cell.getStringCellValue())) {
                        array[1] = cell.getStringCellValue();
                        cell = cellIterator.next();
                        if ((subPhrease.equals(cell.getStringCellValue())) || (subPhrease.equals("0"))) {
                            array[2] = cell.getStringCellValue();
                            cell = cellIterator.next();
                            array[3] = cell.getStringCellValue();
                            cell = cellIterator.next();
                            array[4] = cell.getStringCellValue();
                            list.add(array);
                        } else {
                            break;
                        }

                    } else {
                        break;
                    }
                }
            }
            file.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
