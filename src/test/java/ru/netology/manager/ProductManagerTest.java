package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.Book;
import ru.netology.Product;
import ru.netology.ProductsManager;
import ru.netology.Smartphone;
import ru.netology.repository.NotFoundException;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductsManager manager = new ProductsManager(repository);
    Smartphone phone1 = new Smartphone(1250, "phone1", 54500, "Honor");
    Smartphone phone2 = new Smartphone(4012, "phone2", 52300, "Panasonic");
    Book book1 = new Book(1010, "Confrontation", 810, "King");
    Book book2 = new Book(1004, "The Bronze Horseman", 790, "Pushkin");


    //сохранение
    @Test
    public void shouldFindAll() {
        manager.add(phone1);
        manager.add(phone2);
        manager.add(book1);
        manager.add(book2);
        Product[] actual = repository.findAll();
        Product[] expected = {phone1, phone2, book1, book2};
        assertArrayEquals(actual, expected);

    }

    //удаление по id
    @Test
    public void shouldRemoveById() {
        manager.add(phone1);
        manager.add(phone2);
        manager.add(book1);
        manager.add(book2);

        manager.removeById(4012);

        Product[] actual = repository.findAll();
        Product[] expected = {phone1, book1, book2};
        assertArrayEquals(actual, expected);
    }


    // поиск по id
    @Test public void shouldFindById(){
        manager.add(phone1);
        manager.add(phone2);
        manager.add(book1);
        manager.add(book2);
        Product actual = repository.findById(1010);
        int[] expected = new int[]{1010};
    }

     // генерация NotFoundException
    @Test
    public void NotFoundExceptionTest(){
        manager.add(phone1);
        manager.add(phone2);
        manager.add(book1);
        manager.add(book2);
        assertThrows(NotFoundException.class,() ->{repository.removeById(401); });
    }


}
