package ru.rsatu.hibernatetutorial.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import ru.rsatu.hibernatetutorial.pojo.entity.Book;

@Getter
@Setter
public class BookDto {

    private Long id;
    private String name;
    private Long authorId;

}
