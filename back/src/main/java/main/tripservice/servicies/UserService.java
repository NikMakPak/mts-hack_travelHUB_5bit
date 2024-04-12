package main.tripservice.servicies;

import lombok.AllArgsConstructor;
import main.tripservice.models.dto.UserDto;
import main.tripservice.models.repository.User;
import main.tripservice.repositories.RoleRepository;
import main.tripservice.repositories.SquadRepository;
import main.tripservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

        private final CryptService cryptService;
        private final UserRepository userRepository;
        private final AuthentificationService authentificationService;
        private final RoleRepository roleRepository;
        private final SquadRepository squadRepository;
    public void creatUser(UserDto userDto){
        User user = new User(cryptService.encryption(userDto.getName()),cryptService.encryption(userDto.getSurname()),userDto.getEmail(), userDto.getPassword(), userDto.getGrade(),cryptService.encryption(userDto.getPassport()));
        user.setRole(roleRepository.findRoleById(userDto.getRole()).orElseThrow());
        user.setSquad(squadRepository.findSquadById(userDto.getSquad()).orElseThrow());
        userRepository.save(user);
    }

    /*public Set<User> creatUser(String token){
        return userRepository.findAllBySquad(authentificationService.getUserFromToken(token).getSquad()).orElseThrow();
    }
*/
}
