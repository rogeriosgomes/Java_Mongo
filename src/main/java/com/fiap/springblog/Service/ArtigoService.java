package com.fiap.springblog.Service;

import com.fiap.springblog.model.Artigo;
import com.fiap.springblog.model.ArtigoStatusCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface ArtigoService {

    public List<Artigo> obterTodos();
    public Artigo obterPorCodigo(String codigo);
    public Artigo criar(Artigo artigo);
    public void remover(String codigo);
    public List<Artigo> findByDataGreaterThan(LocalDateTime data);
    public List<Artigo> findByDataAndStatus(LocalDateTime data, int status);

    public void atualizar(Artigo updateArtigo);

    public void atualizarUrl(String id, String novaUrl);

    public List<Artigo> findByStatusAndDataGreaterThan(Integer Status, LocalDateTime data);

    public List<Artigo> obterArtigoPorDataHora(LocalDateTime de, LocalDateTime ate);

    public List<Artigo> encontrarArtigoComplexos(Integer status, LocalDateTime data, String nome);

    public Page<Artigo> listaArtigos(Pageable pageable);

    public List<Artigo> findByStatusOrderByNomeAsc(Integer Status);

    public List<Artigo> findByTexto(String searchTerm);

    public List<ArtigoStatusCount> contarArtigosPorStatus(Integer status);






}
