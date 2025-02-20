import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
package br.iesp.edu.api.service;

import br.iesp.edu.api.entity.Filme;
import br.iesp.edu.api.entity.Pessoa;
import br.iesp.edu.api.repository.FilmeRepository;
import br.iesp.edu.api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {
    private static final Logger logger = LoggerFactory.getLogger(FilmeService.class);

    @Autowired
    private FilmeRepository repository;

    public Filme salvar(Filme filme){
        logger.info("Saving filme: {}", filme);
        filme = repository.save(filme);
        logger.info("Saved filme with ID: {}", filme.getId());
        return filme;
    }

    public Filme atualizar(Filme filme){
        if(filme.getId()==null){
            logger.error("Attempted to update filme with null ID");
            throw new RuntimeException("ID Nulo");
        }
        logger.info("Updating filme with ID: {}", filme.getId());
        filme = repository.save(filme);
        logger.info("Updated filme with ID: {}", filme.getId());
        return filme;
    }

    public void excluir(Filme filme){
        if(filme.getId()==null){
            logger.error("Attempted to delete filme with null ID");
            throw new RuntimeException("ID Nulo");
        }
        logger.info("Deleting filme with ID: {}", filme.getId());
        repository.delete(filme);
        logger.info("Deleted filme with ID: {}", filme.getId());
    }

    public void excluirPorID(Integer id){
        logger.info("Deleting filme by ID: {}", id);
        repository.deleteById(id);
        logger.info("Deleted filme by ID: {}", id);
    }

    public List<Filme> listarFilmes(){
        logger.info("Listing all filmes");
        return repository.findAll();
    }
}
