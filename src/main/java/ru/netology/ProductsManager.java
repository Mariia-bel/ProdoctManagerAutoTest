package ru.netology;

import ru.netology.repository.ProductRepository;

public class ProductsManager {

    private ProductRepository repository;
    private Product[] products = new Product[0];

    public ProductsManager(ProductRepository repository) {
        this.repository = repository;// передаем репозиторий менеджеру
    }


    //добавление
    public void add(Product product) {
        repository.save(product);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

}


