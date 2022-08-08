package ru.netology.repository;

import ru.netology.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    //сохранение
    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];
        System.arraycopy(products, 0, tmp, 0, products.length);
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    //получить все сохраненные
    public Product[] findAll() {

        return products;
    }

    //найти по ID
    public Product findById (int id){
        for (Product product: products) {
            if (product.getId() ==id){
                return product;
            }
        }
        return null;
    }


    //удаление
    public void removeById(int id) {
        if (findById(id) == null){
            throw new NotFoundException ("Element with id: " + id + " not found");
        }
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }

}
