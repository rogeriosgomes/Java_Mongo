package com.fiap.springblog.Service.service.impl;

import com.fiap.springblog.Repository.AutorRepository;
import com.fiap.springblog.Service.AutorService;
import com.fiap.springblog.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<Autor> obterTodos() {
        return this.autorRepository.findAll();
    }

    @Override
    public Autor obterPorCodigo(String codigo) {
        return this.autorRepository
                .findById(codigo)
                .orElseThrow(()-> new IllegalArgumentException("Autor não encontrado"));
    }

    @Override
    public Autor criar(Autor autor) {
        return this.autorRepository.save(autor);
    }

    @Override
    public void remover(String id) {
         this.autorRepository.deleteById(id);
    }
}
