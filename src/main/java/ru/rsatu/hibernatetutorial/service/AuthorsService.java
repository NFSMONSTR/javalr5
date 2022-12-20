package ru.rsatu.hibernatetutorial.service;

import ru.rsatu.hibernatetutorial.mapper.AuthorMapper;
import ru.rsatu.hibernatetutorial.mapper.BookMapper;
import ru.rsatu.hibernatetutorial.pojo.dto.AuthorDto;
import ru.rsatu.hibernatetutorial.pojo.dto.BookDto;
import ru.rsatu.hibernatetutorial.repository.AuthorsRepository;
import ru.rsatu.hibernatetutorial.repository.BooksRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Сервис для работы с авторами
 */
@ApplicationScoped
public class AuthorsService {

    @Inject
    AuthorMapper authorMapper;

    @Inject
    AuthorsRepository authorsRepository;

    /**
     * Получить всех авторов
     */
    public List<AuthorDto> getAuthors() {
        return authorsRepository.getAuthors()
                .stream()
                .map(authorMapper::toAuthorDto)
                .toList();
    }

    /**
     * Сохранение автора
     */
    public AuthorDto saveAuthor(AuthorDto authorDto) {
        return authorMapper.toAuthorDto(authorsRepository.saveAuthor(authorDto));
    }

    /**
     * Удаление автора
     */
    public void deleteAuthor(Long authorId) {
        authorsRepository.deleteAuthor(authorId);
    }

}
