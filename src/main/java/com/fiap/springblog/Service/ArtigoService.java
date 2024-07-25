package com.fiap.springblog.Service;

import com.fiap.springblog.model.Artigo;

import java.util.List;

public interface ArtigoService {

    public List<Artigo> obterTodos();
    public Artigo obterPorCodigo(String codigo);
    public Artigo criar(Artigo artigo);
    public void remover(String codigo);
}
