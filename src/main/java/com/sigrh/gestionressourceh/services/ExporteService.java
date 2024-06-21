package com.sigrh.gestionressourceh.services;

import com.sigrh.gestionressourceh.common.InterfaceTemplete;
import com.sigrh.gestionressourceh.dao.ConnectionDAO;
import com.sigrh.gestionressourceh.daoImplement.personnel.MatiereDAOImplement;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.sql.DataSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.util.List;

public class ExporteService {
    public ByteArrayInputStream exportToExcel(List<PersonnelModel> personnelList) throws IOException {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("personnel");

            Row headerRow = sheet.createRow(0);
            String[] headers = {"ID", "Name", "Position", "TypeEducation"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            int rowIdx = 1;
            for (PersonnelModel personnel : personnelList) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(personnel.getIdAgent());
                row.createCell(1).setCellValue(personnel.getNomPrenom());
                row.createCell(2).setCellValue(personnel.getNomPrenomArab());
                row.createCell(2).setCellValue(personnel.getMatricule());
                row.createCell(3).setCellValue(personnel.getNni());
                row.createCell(2).setCellValue(personnel.getDteRecrutement());

            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("Failed to export data to Excel file: " + e.getMessage());
        }
    }


}
