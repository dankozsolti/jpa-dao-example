package book;

import book.model.Book;
import com.github.javafaker.Faker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Locale;


public class BookGenerator {
    Faker faker = new Faker(new Locale("ja"));


    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd",Locale.ENGLISH);

    public Book randomBook() throws ParseException {
        Book book = Book.builder()
                .isbn13(faker.code().isbn13())
                .author(faker.book().author())
                .title(faker.book().title())
                .format(faker.options().option(Book.Format.class))
                .publisher(faker.book().publisher())
                .publicationDate(faker.date().between(formatter.parse("1977-01-01"), formatter.parse("2020-05-01"))
                        .toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .pages(faker.number().numberBetween(30,500))
                .available(faker.bool().bool())
                .build();

        return book;
    }
}
