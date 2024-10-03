package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CarroController {

    private final CarroRepository repository;

    CarroController(CarroRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/carro")
    List<Carro> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/carro")
    Carro newCarro(@RequestBody Carro newCarro) {
        return repository.save(newCarro);
    }

    // Single item

    @GetMapping("/carro/{id}")
    Carro one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new CarroNotFoundException(id));
    }

    @PutMapping("/carro/{id}")
    Carro replaceCarro(@RequestBody Carro newCarro, @PathVariable Long id) {

        return repository.findById(id)
                .map(carroo -> {
                    carroo.setMarca(newCarro.getMarca());
                    carroo.setModelo(newCarro.getModelo());
                    carroo.setCor(newCarro.getCor());
                    carroo.setAno(newCarro.getAno());
                    return repository.save(carroo);
                })
                .orElseGet(() -> {
                    return repository.save(newCarro);
                });
    }

    @DeleteMapping("/carro/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}