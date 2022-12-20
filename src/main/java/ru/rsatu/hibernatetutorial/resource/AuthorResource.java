package ru.rsatu.hibernatetutorial.resource;


import ru.rsatu.hibernatetutorial.pojo.dto.AuthorDto;
import ru.rsatu.hibernatetutorial.service.AuthorsService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books/api/v1")
public class AuthorResource {

    @Inject
    AuthorsService authorsService;

    /**
     * Получение всех авторов
     */
    @GET
    @Path("/author")
    public List<AuthorDto> getAuthors() {
        return authorsService.getAuthors();
    }

    /**
     * Сохранение автора
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/author")
    public AuthorDto saveAuthor(AuthorDto authorDto) {
        return authorsService.saveAuthor(authorDto);
    }

    /**
     * Удаление автора
     */
    @DELETE
    @Path("/author/{authorId}")
    public void deleteAuthor(@PathParam("authorId") Long authorId) {
        authorsService.deleteAuthor(authorId);
    }

}
