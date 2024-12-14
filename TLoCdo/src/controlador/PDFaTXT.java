package controlador;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFaTXT {

    public static byte[] convertPDFToBytes(File pdfFile) throws IOException {
        // Convert PDF to text
        FileInputStream inputStream = new FileInputStream(pdfFile);
        PDDocument document = null;
        File txtFile = new File ("txtFile.txt");
        try {
            document = PDDocument.load(inputStream);
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);
            FileWriter writer = new FileWriter(txtFile);
            writer.write(text);
            writer.close();
            System.out.println("PDF converted to text successfully.");
        } finally {
            if (document != null) {
                document.close();
                
            }
            inputStream.close();
         
        }

        // Convert text to bytes
        FileInputStream textInputStream = new FileInputStream(txtFile);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        try {
            while ((bytesRead = textInputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
        } finally {
            textInputStream.close();
            baos.close();
        }
        return baos.toByteArray();
    }
}
