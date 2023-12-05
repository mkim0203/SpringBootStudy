package com.example.demo.model;

import com.fasterxml.jackson.databind.util.ClassUtil;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ValidateItem {
    @NotNull
    @Length(min = 6, max = 15)
    private String userId ;
    @Min(value = 0)
    private Integer avg;
    @Email(message = "잘못된 mail 주소")
    private String email;
}
