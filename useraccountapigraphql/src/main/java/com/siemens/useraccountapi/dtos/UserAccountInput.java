package com.siemens.useraccountapi.dtos;

import com.siemens.useraccountapi.models.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountInput {
    private FullNameRequest fullName;

    private Gender gender;


    private String email;


     private String password;



    private LocalDate dob;
}
