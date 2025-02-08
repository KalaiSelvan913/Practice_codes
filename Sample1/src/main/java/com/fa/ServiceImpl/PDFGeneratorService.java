package com.fa.ServiceImpl;

import com.fa.Entity.SampleEntity;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.RGBColor;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class PDFGeneratorService {
	public void export(SampleEntity entity,  HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        float width = document.getPageSize().getWidth();

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);
        fontTitle.setColor(255, 0, 0);

        Paragraph paragraph = new Paragraph("Individual DataTable", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        Paragraph paragraph2 = new Paragraph("This is a paragraph.", fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
        
        document.add(paragraph);
        document.add( Chunk.NEWLINE );
//        document.add(paragraph2);
     
        float[] columnDefinitionSize = { 2.0f, 3.3f, 3.5f, 3.0f, 2.5f, };
//        Font font8 = FontFactory.getFont(FontFactory.HELVETICA, 8);
      PdfPTable  table = new PdfPTable(columnDefinitionSize); 
      table.getDefaultCell().setBorder(0);
      table.setHorizontalAlignment(0);
      table.setTotalWidth(width - 72);
      table.setLockedWidth(true);
      
      Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

      PdfPCell hcell;
      hcell = new PdfPCell(new Phrase("EmpId", headFont));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      hcell.setBackgroundColor(new RGBColor(226, 226, 226));
      hcell.setPadding(7f);
      table.addCell(hcell);

      hcell = new PdfPCell(new Phrase("UserName", headFont));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      hcell.setBackgroundColor(new RGBColor(226, 226, 226));
      hcell.setPadding(7f);
      table.addCell(hcell);

      hcell = new PdfPCell(new Phrase("Email", headFont));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      hcell.setBackgroundColor(new RGBColor(226, 226, 226));
      hcell.setPadding(7f);
      table.addCell(hcell);
      
      hcell = new PdfPCell(new Phrase("Created By", headFont));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      hcell.setBackgroundColor(new RGBColor(226, 226, 226));
      hcell.setPadding(7f);
      table.addCell(hcell);
      
      hcell = new PdfPCell(new Phrase("Created ON", headFont));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      hcell.setBackgroundColor(new RGBColor(226, 226, 226));
      hcell.setPadding(7f);
      table.addCell(hcell);
      
      hcell = new PdfPCell(new Phrase(entity.getEmpId()));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      hcell.setPadding(5f);
      table.addCell(hcell);
      
      hcell = new PdfPCell(new Phrase(entity.getUserName()));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      hcell.setPadding(7f);
      table.addCell(hcell);
      
      hcell = new PdfPCell(new Phrase(entity.getEmail()));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      hcell.setPadding(7f);
      table.addCell(hcell);
      
      hcell = new PdfPCell(new Phrase(entity.getCreatedBy()));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      hcell.setPadding(7f);
      table.addCell(hcell);
      
      hcell = new PdfPCell(new Phrase(entity.getCreatedDate()));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      hcell.setPadding(7f);
      table.addCell(hcell);
      
      document.add(table);
      
        
        
        document.close();
    }
	
}
