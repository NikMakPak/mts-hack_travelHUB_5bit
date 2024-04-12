package main.tripservice.servicies;

import lombok.AllArgsConstructor;
import main.tripservice.enums.BidStatusEnum;
import main.tripservice.exception.NoSuchException;
import main.tripservice.models.DAO.BidDAO;
import main.tripservice.models.dto.BidDTO;
import main.tripservice.models.repository.Bid;
import main.tripservice.models.repository.Status;
import main.tripservice.models.repository.StatusCode;
import main.tripservice.models.repository.User;
import main.tripservice.repositories.BidRepository;
import main.tripservice.repositories.StatusCodeRepository;
import main.tripservice.repositories.UserRepository;
import main.tripservice.secutiry.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@AllArgsConstructor
@Service
public class BidService {

    private final BidRepository bidRepository;
    private final AuthentificationService authentificationService;
    private final StatusCodeRepository statusCodeRepository;
    private final UserRepository userRepository;

    public void createBid(String token, BidDTO bidDTO) {
        User user = authentificationService.getUserFromToken(token);
        ArrayList<Status> status = new ArrayList<>();
        status.add(new Status(statusCodeRepository.findByCode(1).orElseThrow(() -> new NoSuchException("No such START status code in database"))));
        Bid bid = new Bid(status, bidDTO.getReason(), bidDTO.getDepartureCity(), bidDTO.getArrivalCity(), bidDTO.getDepartureDate(), bidDTO.getArrivalDate(), user);
        bidRepository.save(bid);
    }

    public BidDAO findAllBidForTribe(String token){
        Set<User> users = userRepository.findAllBySquad(authentificationService.getUserFromToken(token).getSquad()).orElseThrow();
        Set<Bid> bids = new HashSet<>();
        for (User user : users){
            for (Bid bid : user.getBids()){
                if (bid.getStatuses().get(bid.getStatuses().size() - 1).getStatusCode().getName().equals(BidStatusEnum.BID_CREATED.getBidStatus()) || bid.getStatuses().get(bid.getStatuses().size() - 1).getStatusCode().getName().equals(BidStatusEnum.BID_FIRST_ACCOUNTING_APPROVED.getBidStatus()))
                    bids.add(bid);
            }
        }
        return new BidDAO(bids);
    }

    public BidDAO findAllBidForAccounting(String token){
        Iterable<User> users = userRepository.findAll();
        Set<Bid> bids = new HashSet<>();
        for (User user : users){
            for (Bid bid : user.getBids()){
                if (bid.getStatuses().get(bid.getStatuses().size() - 1).getStatusCode().getName().equals(BidStatusEnum.BID_FIRST_MANAGER_APPROVED.getBidStatus()) || bid.getStatuses().get(bid.getStatuses().size() - 1).getStatusCode().getName().equals(BidStatusEnum.BID_TRIP_CLOSED.getBidStatus()))
                    bids.add(bid);
            }
        }
        return new BidDAO(bids);
    }

    public BidDAO findAllBidForUser(String token){
        User user = authentificationService.getUserFromToken(token);
        return new BidDAO(user.getBids());
    }


    public void approveSquad(BidDTO bidDTO){
        Bid bid = bidRepository.findById(bidDTO.getId()).orElseThrow(() -> new NoSuchException("No such user with id" + bidDTO.getId() + "in database"));
        ArrayList<Status> bidStatus = bid.getStatuses();
        int lastCode = bid.getStatuses().get(bid.getStatuses().size() - 1).getStatusCode().getCode();
        /*Status status = new Status(statusCodeRepository.findByCode(lastCode +1).orElseThrow());
        bidStatus.add(status);
        bid.setStatuses(bidStatus);
        bidRepository.save(bid);*/
        Status status = new Status();
        switch (lastCode){
            case (0):
                status = new Status(statusCodeRepository.findByCode(2).orElseThrow());
                break;
            case (5):
                status = new Status(statusCodeRepository.findByCode(12).orElseThrow());
                break;
        }
        bidStatus.add(status);
        bid.setStatuses(bidStatus);
        bidRepository.save(bid);
    }

    public void rejectSquad(BidDTO bidDTO){
        Bid bid = bidRepository.findById(bidDTO.getId()).orElseThrow(() -> new NoSuchException("No such user with id" + bidDTO.getId() + "in database"));
        ArrayList<Status> bidStatus = bid.getStatuses();
        int lastCode = bid.getStatuses().get(bid.getStatuses().size() - 1).getStatusCode().getCode();
        Status status = new Status();
        switch (lastCode){
            case (0):
                status = new Status(statusCodeRepository.findByCode(3).orElseThrow());
                break;
            case (5):
                status = new Status(statusCodeRepository.findByCode(8).orElseThrow());
                break;
        }
        bidStatus.add(status);
        bid.setStatuses(bidStatus);
        bidRepository.save(bid);
    }

    public void rejectAccounting(BidDTO bidDTO){
        Bid bid = bidRepository.findById(bidDTO.getId()).orElseThrow(() -> new NoSuchException("No such user with id" + bidDTO.getId() + "in database"));
        ArrayList<Status> bidStatus = bid.getStatuses();
        int lastCode = bid.getStatuses().get(bid.getStatuses().size() - 1).getStatusCode().getCode();
        Status status = new Status(statusCodeRepository.findByCode(6).orElseThrow());
        bidStatus.add(status);
        bid.setStatuses(bidStatus);
        bidRepository.save(bid);
    }

    public void approveManager(BidDTO bidDTO){
        Bid bid = bidRepository.findById(bidDTO.getId()).orElseThrow(() -> new NoSuchException("No such user with id" + bidDTO.getId() + "in database"));
        ArrayList<Status> bidStatus = bid.getStatuses();
        int lastCode = bid.getStatuses().get(bid.getStatuses().size() - 1).getStatusCode().getCode();
        Status status = new Status();
        switch (lastCode){
            case (2):
                status = new Status(statusCodeRepository.findByCode(4).orElseThrow());
                break;
            case (7):
                status = new Status(statusCodeRepository.findByCode(9).orElseThrow());
                break;
        }
        bidStatus.add(status);
        bid.setStatuses(bidStatus);
        bidRepository.save(bid);
    }

    public void approveAccounting(BidDTO bidDTO){

    }


}
