package org.jspider.Vertical_ask.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.jspider.Vertical_ask.module.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class PdfUtil {

    public static ByteArrayInputStream generatePdf(List<User> users) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfPTable table = new PdfPTable(3);
        Font headFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);

        PdfPCell hcell;
        hcell = new PdfPCell(new Paragraph("User ID", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Paragraph("Name", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Paragraph("Email", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);


        for (User user : users) {
            PdfPCell cell;

            cell = new PdfPCell(new Paragraph(String.valueOf(user.getUserId())));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(user.getUserName()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(user.getUserEmail()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);


        }

        PdfWriter.getInstance(document, out);
        document.open();
        document.add(new Paragraph("User Report"));
        document.add(new Paragraph("\n"));
        document.add(table);
        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }
}


