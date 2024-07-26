package com.fiap.springblog.Service.service.impl;

import com.fiap.springblog.Repository.ArtigoRepository;
import com.fiap.springblog.Repository.AutorRepository;
import com.fiap.springblog.Service.ArtigoService;
import com.fiap.springblog.model.Artigo;
import com.fiap.springblog.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.*;

@Service
public class ArtigoServiceImpl implements ArtigoService {

    private final MongoTemplate mongoTemplate;

    public ArtigoServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Autowired
    private ArtigoRepository artigoRepository;

    @Autowired
    private AutorRepository autorRepository;

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
         //se autor
        if(artigo.getAutor().getCodigo() != null){
            Autor autor = this.autorRepository
                    .findById(artigo.getAutor().getCodigo())
                    .orElseThrow(()->new IllegalArgumentException("Autor não encontrado"));

            artigo.setAutor(autor);
        } else {
            artigo.setAutor(null);
        }
        return this.artigoRepository.save(artigo);
    }

    @Override
    public void remover(String codigo) {


       this.artigoRepository.deleteById(codigo);

    }

    @Override
    public List<Artigo> findByDataGreaterThan(LocalDateTime data) {
        Query query = new Query(Criteria.where("data").gt(data));

        return mongoTemplate.find(query, Artigo.class);
    }

    @Override
    public List<Artigo> findByDataAndStatus(LocalDateTime data, int status) {
        Query query = new Query(Criteria.where("data").is(data).and("status").is(status));
        return mongoTemplate.find(query, Artigo.class);
    }

    @Override
    public void atualizar(Artigo updateArtigo) {
        this.artigoRepository.save(updateArtigo);
    }

    @Override
    public void atualizarUrl(String id, String novaUrl) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update().set("url", novaUrl);
        this.mongoTemplate.updateFirst(query, update, Artigo.class);
    }
}
