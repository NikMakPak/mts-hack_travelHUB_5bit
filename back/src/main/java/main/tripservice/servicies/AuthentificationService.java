package main.tripservice.servicies;

import lombok.AllArgsConstructor;
import main.tripservice.exception.AuthenticationException;
import main.tripservice.exception.NoSuchException;
import main.tripservice.models.DAO.JwtUserDAO;
import main.tripservice.models.dto.AuthenticationRequest;
import main.tripservice.models.repository.User;
import main.tripservice.repositories.UserRepository;
import main.tripservice.secutiry.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthentificationService {

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private final UserRepository userRepository;

    private final CryptService cryptService;

    public JwtUserDAO logging(AuthenticationRequest authenticationRequest) {

        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getLogin(), authenticationRequest.getPassword()));
            String jwt = jwtService.GenerateToken(authenticationRequest.getLogin());
            User user = getUserFromToken(jwt);
            JwtUserDAO jwtUserDAO = new JwtUserDAO(jwt, user.getId(), cryptService.decryption(user.getName()), cryptService.decryption(user.getSurname()), user.getEmail(), user.getGrade(),cryptService.decryption(user.getPassport()), user.getBids(), user.getSquad(), user.getRole());
            return jwtUserDAO;
        }catch (Exception e){
            throw new AuthenticationException("Authentication failed");
        }
    }

    public User getUserFromToken(String token){
        String email = jwtService.extractUsername(token.replace("Bearer ", ""));
        User user = userRepository.findByEmail(email).orElseThrow(() -> new NoSuchException("No such user with email:" + email + " in database"));
        return user;
    }

}
