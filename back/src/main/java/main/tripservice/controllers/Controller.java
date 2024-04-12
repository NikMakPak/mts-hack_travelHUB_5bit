package main.tripservice.controllers;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import main.tripservice.enums.DocumentNameEnum;
import main.tripservice.models.DAO.BidDAO;
import main.tripservice.models.dto.BidDTO;
import main.tripservice.models.dto.UserDto;
import main.tripservice.models.repository.Role;
import main.tripservice.repositories.RoleRepository;
import main.tripservice.servicies.BidService;
import main.tripservice.servicies.DocumentService;
import main.tripservice.servicies.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@AllArgsConstructor
@RestController
public class Controller {

    private final BidService bidService;
    private final UserService userService;
    private final DocumentService documentService;

    @PostMapping("/api/user/trip/business/create")
    public void createBid(@RequestHeader("Authorization") String token,
                          @RequestBody BidDTO bidDTO) {
        bidService.createBid(token, bidDTO);
    }

    @GetMapping("/api/user/bids")
    public ResponseEntity<BidDAO> findBidsForUser(@RequestHeader("Authorization") String token) {
        return new ResponseEntity<>(bidService.findAllBidForUser(token), HttpStatus.OK);
    }
    @GetMapping("/api/tribe/trips")
    public ResponseEntity<BidDAO> finBidsForTribe(@RequestHeader("Authorization") String token) {
        return new ResponseEntity<>(bidService.findAllBidForTribe(token), HttpStatus.OK);
    }

    @GetMapping("/api/accounting/trips")
    public ResponseEntity<BidDAO> findBidsForAccounting(@RequestHeader("Authorization") String token) {
        return new ResponseEntity<>(bidService.findAllBidForAccounting(token), HttpStatus.OK);
    }

    @PostMapping("/api/tribe/trip/approve")
    public void approveSquad(@RequestHeader("Authorization") String token,
                             @RequestBody BidDTO bidDTO){
        bidService.approveSquad(bidDTO);
    }

    @PostMapping("/api/tribe/trip/reject")
    public void rejectSquad(@RequestHeader("Authorization") String token,
                             @RequestBody BidDTO bidDTO){
        bidService.rejectSquad(bidDTO);
    }

    @PostMapping("/api/accounting/trip/approve")
    public void approveAccounting(@RequestHeader("Authorization") String token,
                                 @RequestBody BidDTO bidDTO) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        bidService.approveAccounting(bidDTO);
    }

    @PostMapping("/api/accounting/trip/reject")
    public void rejectAccounting(@RequestHeader("Authorization") String token,
                            @RequestBody BidDTO bidDTO){
        bidService.rejectAccounting(bidDTO);
    }

    @PostMapping("/api/manager/trip/approve")
    public void approveManager(@RequestParam("files") MultipartFile[] file, @RequestHeader("Authorization") String token,
                                 @RequestBody BidDTO bidDTO) throws IOException {
        bidService.approveManager(bidDTO);
        documentService.pdfUpload(bidDTO, file, DocumentNameEnum.DOCUMENT_TICKET.getDocumentName());
    }

    @PostMapping("/api/registration")
    public void creatUser(@RequestBody UserDto userDto){
        userService.creatUser(userDto);
    }

    @GetMapping("/pdf")
    public void generatePDF(HttpServletResponse response) throws IOException {

        documentService.pdfReader(response, documentService.pdfCreat("Vladick and Sashik"));
    }

    /*@GetMapping("/save")
    public void savePdf(@RequestParam("files") MultipartFile[] file) throws IOException {
        documentService.pdfUpload(file, DocumentNameEnum.DOCUMENT_BILL.getDocumentName());
    }*/

    /*@GetMapping("/save")
    public void savePdf(HttpServletResponse response) throws IOException {
        documentService.getDocument(1, response);
    }
*/



}
