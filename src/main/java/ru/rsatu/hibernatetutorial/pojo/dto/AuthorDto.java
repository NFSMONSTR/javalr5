package ru.rsatu.hibernatetutorial.pojo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorDto {

    private Long id;
    private String name;
    private String birthDate;
    private String nickName;
}
