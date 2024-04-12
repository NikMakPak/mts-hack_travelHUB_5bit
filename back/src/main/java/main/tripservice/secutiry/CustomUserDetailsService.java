package main.tripservice.secutiry;

import main.tripservice.models.repository.User;
import main.tripservice.models.service.UserServiceModel;
import main.tripservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;



    /*public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userRepo =  userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Email not found"));
        UserServiceModel userServiceModel = new UserServiceModel(userRepo);
        UserDetails user = org.springframework.security.core.userdetails.User.builder()
                .username(userServiceModel.getEmail())
                .password(userServiceModel.getPassword())
                .roles(userServiceModel.getRole().getName())
                .build();
        return user;
    }

    /*public GrantedAuthority jwtGetRole(UserDetails userDetails){
        for (GrantedAuthority element : userDetails.getAuthorities())
            return element;

    }*/


}
