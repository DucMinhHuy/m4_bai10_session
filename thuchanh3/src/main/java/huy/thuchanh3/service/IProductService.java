package huy.thuchanh3.service;

import huy.thuchanh3.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product>findAll();
    Optional<Product> findById(Long id);
}
