package book;

import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.PersistenceModule;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        Injector injector = Guice.createInjector(new PersistenceModule("JpaUnitTest"));
        BookDao bookDao = injector.getInstance(BookDao.class);
        BookGenerator bookgen = new BookGenerator();

        for (int i = 0; i < 50; i++)
            bookDao.persist(bookgen.randomBook());

        bookDao.findAll().stream().forEach(System.out::println);
    }
}