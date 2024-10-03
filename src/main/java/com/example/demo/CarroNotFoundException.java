package com.example.demo;

class CarroNotFoundException extends RuntimeException {

    CarroNotFoundException(Long id) {
        super("Could not find car " + id);
    }
}