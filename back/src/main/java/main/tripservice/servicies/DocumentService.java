package main.tripservice.servicies;


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import main.tripservice.enums.DocumentNameEnum;
import main.tripservice.exception.PdfException;
import main.tripservice.models.dto.BidDTO;
import main.tripservice.models.repository.Bid;
import main.tripservice.repositories.BidRepository;
import main.tripservice.repositories.DocumentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@AllArgsConstructor
@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    private final BidRepository bidRepository;

    public byte[] pdfCreat(String message) {

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PdfWriter writer = new PdfWriter(outputStream);

            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph(message));
            document.close();

            byte[] pdfBytes = outputStream.toByteArray();

            return pdfBytes;
        } catch (Exception e) {
            throw new PdfException("Error with PDF");
        }

    }

    public void pdfReader(HttpServletResponse httpServletResponse, byte[] bytes) {
        try {
            httpServletResponse.setContentType("application/pdf");
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
            String currentDateTime = dateFormatter.format(new Date());

            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
            httpServletResponse.setHeader(headerKey, headerValue);

            httpServletResponse.getOutputStream().write(bytes);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pdfUpload(BidDTO bidDTO, MultipartFile[] file, String docType) throws IOException {

        for (MultipartFile file1 : file) {

            main.tripservice.models.repository.Document pdfFile = new main.tripservice.models.repository.Document();
            pdfFile.setName(file1.getOriginalFilename());
            pdfFile.setType(docType);
            pdfFile.setDocument(file1.getBytes());
            Bid bid = bidRepository.findById(bidDTO.getId()).orElseThrow();
            bid.getHotel().add(pdfFile);
            bidRepository.save(bid);
        }

    }

    public void getDocument(long id, HttpServletResponse httpServletResponse){
        pdfReader(httpServletResponse,documentRepository.findById(id).get().getDocument());
    }


}
