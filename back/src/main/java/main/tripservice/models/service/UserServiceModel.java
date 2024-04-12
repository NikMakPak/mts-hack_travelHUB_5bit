package main.tripservice.models.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import main.tripservice.models.repository.Role;
import main.tripservice.models.repository.Squad;
import main.tripservice.models.repository.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceModel {

    long id;


    byte[] name;


    byte[] surname;


    String email;


    String password;


    int grade;


    byte[] passport;


    Squad squad;


    Role role;

    public UserServiceModel (User user){
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.grade = user.getGrade();
        this.passport = user.getPassport();
        this.squad = user.getSquad();
        this.role = user.getRole();
    }

}