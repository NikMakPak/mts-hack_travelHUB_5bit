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

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@AllArgsConstructor
@RestController
public class Controller {

    private final BidService bidService;
    private final UserService userService;
    private final DocumentService documentService;

    @PostMapping("/user/trip/business/create")
    public void createBid(@RequestHeader("Authorization") String token,
                          @RequestBody BidDTO bidDTO) {
        bidService.createBid(token, bidDTO);
    }

    @GetMapping(value = {"/user/bids", "/accounting/trips"})
    public ResponseEntity<BidDAO> findBidsForUser(@RequestHeader("Authorization") String token) {
        return new ResponseEntity<>(bidService.findAllForUser(token), HttpStatus.OK);
    }
    @GetMapping(value = {"/tribe/trips"})
    public ResponseEntity<BidDAO> finBidsForTribe(@RequestHeader("Authorization") String token) {
        return new ResponseEntity<>(bidService.findAllForUser(token), HttpStatus.OK);
    }

    @PostMapping("/tribe/trip/approve")
    public void approveSquad(@RequestHeader("Authorization") String token,
                             @RequestBody BidDTO bidDTO){
        bidService.approveSquad(bidDTO);
    }

    @PostMapping("/tribe/trip/reject")
    public void rejectSquad(@RequestHeader("Authorization") String token,
                             @RequestBody BidDTO bidDTO){
        bidService.rejectSquad(bidDTO);
    }

    @PostMapping("/accounting/trip/reject")
    public void rejectAccounting(@RequestHeader("Authorization") String token,
                            @RequestBody BidDTO bidDTO){
        bidService.rejectAccounting(bidDTO);
    }

    @PostMapping("/registration")
    public void creatUser(@RequestBody UserDto userDto){
        userService.creatUser(userDto);
    }

    @GetMapping("/pdf")
    public void generatePDF(HttpServletResponse response) throws IOException {

        documentService.pdfReader(response, documentService.pdfCreat("Vladick and Sashik"));
    }

    /*@GetMapping("/save")
    public void savePdf(@RequestParam("Document") MultipartFile file) throws IOException {
        documentService.pdfUpload(file, DocumentNameEnum.DOCUMENT_BILL.getDocumentName());
    }*/

    @GetMapping("/save")
    public void savePdf(HttpServletResponse response) throws IOException {
        documentService.getDocument(1, response);
    }


}
