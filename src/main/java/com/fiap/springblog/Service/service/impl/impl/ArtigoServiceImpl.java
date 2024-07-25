package com.fiap.springblog.Service.service.impl.impl;

import com.fiap.springblog.Repository.ArtigoRepository;
import com.fiap.springblog.Service.ArtigoService;
import com.fiap.springblog.model.Artigo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArtigoServiceImpl implements ArtigoService {

    @Autowired
    private ArtigoRepository artigoRepository;

    @Override
    public List<Artigo> obterTodos() {

        return this.artigoRepository.findAll();
    }

    @Override
    public Artigo obterPorCodigo(String codigo) {
        return this.artigoRepository
                .findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Artigo não existe"));
    }

    @Override
    public Artigo criar(Artigo artigo) {
        return this.artigoRepository.save(artigo);
    }

    @Override
    public void remover(String codigo) {
       this.artigoRepository.deleteById(codigo);

    }
}
