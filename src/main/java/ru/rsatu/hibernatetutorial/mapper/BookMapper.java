package ru.rsatu.hibernatetutorial.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.rsatu.hibernatetutorial.pojo.dto.BookDto;
import ru.rsatu.hibernatetutorial.pojo.entity.Author;
import ru.rsatu.hibernatetutorial.pojo.entity.Book;

import javax.inject.Inject;
import javax.persistence.EntityManager;

@Mapper(componentModel = "cdi")
public abstract class BookMapper {

    @Inject
    EntityManager entityManager;

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "authorId", source = "author.id")
    public abstract BookDto toBookDto(Book book);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    public abstract Book toBook(BookDto bookDto);

    @AfterMapping
    public void afterBookMapping(@MappingTarget Book result, BookDto bookDto) {
        Author author = entityManager.getReference(Author.class, bookDto.getAuthorId());
        result.setAuthor(author);
    }

}
