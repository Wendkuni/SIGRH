package com.sigrh.gestionressourceh.services;

import com.sigrh.gestionressourceh.common.InterfaceTemplete;
import com.sigrh.gestionressourceh.dao.ConnectionDAO;
import com.sigrh.gestionressourceh.daoImplement.personnel.MatiereDAOImplement;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.util.List;

public class ExporteService implements InterfaceTemplete <PersonnelModel> {
    private final MatiereDAOImplement dao= new MatiereDAOImplement(ConnectionDAO.getInstance());

    @Override
    public boolean create(PersonnelModel obj) {
        return false;
    }

    @Override
    public boolean delete(PersonnelModel obj) {
        return false;
    }

    @Override
    public boolean update(PersonnelModel obj) {
        return false;
    }

    @Override
    public PersonnelModel find(int id) {

        return null;
    }

    @Override
    public List<PersonnelModel> findAll() {
        return null;
    }

   /* PersonnelModel personnel = null;
    String query = "{CALL GetPersonnelDetails(?)}";

        try (
    DataSource connection = getConnection();
    CallableStatement stmt = connection.prepareCall(query)) {

        stmt.setInt(1, id);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                personnel = new Personnel(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("poste"),
                        rs.getString("departement"),
                        rs.getDate("date_embauche").toLocalDate()
                );
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

        return personnel;
}

    public void exporterEtatPersonnelEnExcel(Personnel personnel, String filePath) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Etat du Personnel");

        Row headerRow = sheet.createRow(0);
        String[] columns = {"ID", "Nom", "Poste", "Département", "Date d'Embauche"};
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }

        Row row = sheet.createRow(1);
        row.createCell(0).setCellValue(personnel.getId());
        row.createCell(1).setCellValue(personnel.getNom());
        row.createCell(2).setCellValue(personnel.getPoste());
        row.createCell(3).setCellValue(personnel.getDepartement());
        row.createCell(4).setCellValue(personnel.getDateEmbauche().toString());

        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exporterEtatPersonnelEnPDF(Personnel personnel, String filePath) {
        try {
            PdfWriter writer = new PdfWriter(filePath);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            document.add(new Paragraph("Etat du Personnel"));

            float[] pointColumnWidths = {150F, 150F};
            Table table = new Table(pointColumnWidths);

            table.addCell("ID");
            table.addCell(String.valueOf(personnel.getId()));
            table.addCell("Nom");
            table.addCell(personnel.getNom());
            table.addCell("Poste");
            table.addCell(personnel.getPoste());
            table.addCell("Département");
            table.addCell(personnel.getDepartement());
            table.addCell("Date d'Embauche");
            table.addCell(personnel.getDateEmbauche().toString());

            document.add(table);
            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }*/
}
