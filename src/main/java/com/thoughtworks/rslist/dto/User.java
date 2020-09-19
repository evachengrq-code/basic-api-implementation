package com.thoughtworks.rslist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public User(String name, String gender, Integer age, String email, String phone) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    @NotEmpty
    @Size(max = 8)
    private String name;
    @NotEmpty
    private String gender;
    @Min(18)
    @Max(100)
    @NotNull
    private Integer age;
    @Email
    private String email;
    @NotEmpty
    @Pattern(regexp = "^1\\d{10}$")
    private String phone;
    private Integer vote = 10;
}
