package br.iesp.edu.api.resource;

import br.iesp.edu.api.entity.Serie;
import br.iesp.edu.api.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/serie")
public class SerieResource {

    @Autowired
    SerieService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Serie> create(@RequestBody Serie serie) {
        Serie serieCreated = service.create(serie);

        return ResponseEntity.status(201).body(serieCreated);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Serie> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@RequestBody Serie serie) {
        service.delete(serie);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Serie atualizar(@RequestBody Serie serie) {
        return service.atualizar(serie);
    }
}
