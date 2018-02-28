/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdftodoc;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


/**
 *
 * @author singhj1
 */
public class PDFTODOC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        XWPFDocument doc = new XWPFDocument();
        
        try {

// Open the pdf file
            String pdf = "C:\\Users\\singhj1\\Downloads\\NetBeansProjects\\PDFTODOC\\src\\pdftodoc\\AD19SDMUXLP_36to24_M10_v0_2.pdf";

            PdfReader reader = new PdfReader(pdf);

            PdfReaderContentParser parser = new PdfReaderContentParser(reader);

// Read the PDF page by page
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                TextExtractionStrategy strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
                // Extract the text
                String text = strategy.getResultantText();
                // Create a new paragraph in the word document, adding the extracted text

                XWPFParagraph p = doc.createParagraph();
                XWPFRun run = p.createRun();
                run.setText(text);
                // Adding a page break
                run.addBreak(BreakType.PAGE);
            }
// Write the word document
            FileOutputStream out = new FileOutputStream("myfile.docx");
            doc.write(out);
// Close all open files
            out.close();
            reader.close();

        } catch (IOException ex) {

        }
    }

}
