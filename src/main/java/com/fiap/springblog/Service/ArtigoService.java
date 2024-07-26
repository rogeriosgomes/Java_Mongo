package com.fiap.springblog.Service;

import com.fiap.springblog.model.Artigo;

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




}
