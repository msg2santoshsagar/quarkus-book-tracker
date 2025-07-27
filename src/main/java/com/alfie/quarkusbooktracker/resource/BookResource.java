package com.alfie.quarkusbooktracker.resource;

import com.alfie.quarkusbooktracker.model.Book;
import com.alfie.quarkusbooktracker.model.BookRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    @GET
    public List<Book> list() {
        return Book.listAll();
    }

    @POST
    @Transactional
    public Response create(@Valid BookRequest request) {
        Book book = new Book();
        book.title = request.title;
        book.author = request.author;
        book.status = request.status;
        book.rating = request.rating;
        book.notes = request.notes;
        book.persist();
        return Response.status(Response.Status.CREATED).entity(book).build();
    }

    @GET
    @Path("/{id}")
    public Book get(@PathParam("id") Long id) {
        return Book.findById(id);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Book update(@PathParam("id") Long id, @Valid BookRequest request) {
        Book book = Book.findById(id);
        if (book == null) throw new NotFoundException();

        book.title = request.title;
        book.author = request.author;
        book.status = request.status;
        book.rating = request.rating;
        book.notes = request.notes;
        return book;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        Book.deleteById(id);
    }
}
