package com.alfie.quarkusbooktracker.resource;

import com.alfie.quarkusbooktracker.model.Book;
import com.alfie.quarkusbooktracker.model.BookRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    @GET
    public List<Book> list() {
        long startTime = System.currentTimeMillis();
        List<Book> result = Book.listAll();
        log.info("Fetched book list in {} ms", System.currentTimeMillis() - startTime);
        return result;
    }

    @POST
    @Transactional
    public Response create(@Valid BookRequest request) {
        long startTime = System.currentTimeMillis();
        Book book = new Book();
        book.title = request.getTitle();
        book.author = request.getAuthor();
        book.status = request.getStatus();
        book.rating = request.getRating();
        book.notes = request.getNotes();
        book.persist();
        log.info("Created book list in {} ms", System.currentTimeMillis() - startTime);
        return Response.status(Response.Status.CREATED).entity(book).build();
    }

    @GET
    @Path("/{id}")
    public Book get(@PathParam("id") Long id) {
        long startTime = System.currentTimeMillis();
        Book result = Book.findById(id);
        log.info("Found book in {} ms", System.currentTimeMillis() - startTime);
        return result;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Book update(@PathParam("id") Long id, @Valid BookRequest request) {
        long startTime = System.currentTimeMillis();
        Book book = Book.findById(id);
        if (book == null) throw new NotFoundException();

        book.title = request.getTitle();
        book.author = request.getAuthor();
        book.status = request.getStatus();
        book.rating = request.getRating();
        book.notes = request.getNotes();
        log.info("Updated book in {} ms", System.currentTimeMillis() - startTime);
        return book;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        long startTime = System.currentTimeMillis();
        Book.deleteById(id);
        log.info("Deleted book in {} ms", System.currentTimeMillis() - startTime);
    }

    @GET
    @Path("/dummy")
    @Transactional
    public String createDummyBooks(@QueryParam("count") @DefaultValue("10000") int count) {
        long start = System.currentTimeMillis();

        for (int i = 1; i <= count; i++) {
            Book book = new Book();
            book.title = "Book #" + i;
            book.author = "Author " + i;
            book.status = Book.Status.READING;
            book.rating = (i % 5) + 1;
            book.notes = "Auto-generated dummy book";
            book.persist();
        }

        long end = System.currentTimeMillis();
        log.info("Inserted {} dummy records in {} ms", count, (end - start));

        return "Inserted " + count + " dummy records in " + (end - start) + " ms";
    }

}
