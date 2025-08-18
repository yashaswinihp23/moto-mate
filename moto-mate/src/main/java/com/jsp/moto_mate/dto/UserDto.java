package com.jsp.moto_mate.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    @Size(min = 3, max = 20, message = "* Name should be 3~20 charecters")
    private String name;
    @Email(message = "* Enter Proper Email format")
    @NotEmpty(message = "* It is required Field")
    private String email;
    @DecimalMin(value = "6000000000", message = "* Enter Proper Mobile Number")
    @DecimalMax(value = "9999999999", message = "* Enter Proper Mobile Number")
    @NotNull(message = "* It is required Field")
    private Long mobile;
    @Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "* Enter atleast 8 charecter consisting of one number , one uppercase, one lowercase and one special charecter")
    private String password;
    @Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "* Enter atleast 8 charecter consisting of one number , one uppercase, one lowercase and one special charecter")
    private String confirmPassword;
    @AssertTrue(message = "* Check the terms before continuing")
    private boolean terms;
}
