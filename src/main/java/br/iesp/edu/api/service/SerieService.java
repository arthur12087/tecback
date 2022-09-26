package br.iesp.edu.api.service;

import br.iesp.edu.api.entity.Serie;
import br.iesp.edu.api.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieService {

    @Autowired
    SerieRepository serieRepository;

    //post
    public Serie create(Serie serie) {
        return serieRepository.save(serie);
    }

    //put
    public Serie atualizar(Serie serie) {
        if(serie.getId()==null) {
            throw new RuntimeException("Id nula");
        }
        return serieRepository.save(serie);
    }

    //get all
    public List<Serie> findAll() {
        return serieRepository.findAll();
    }

    //delete without id
    public void delete(Serie serie) {
        if(serie.getId()==null) {
            throw new RuntimeException("Id nulo");
        }
        serieRepository.delete(serie);
    }

    //delete by id
    public void deleteById(Integer id) {
        serieRepository.deleteById(id);
    }

    //get by id
    public Optional findById(Integer id) {
        return serieRepository.findById(id);
    }
}
