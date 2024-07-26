package com.fiap.springblog.Service;

import com.fiap.springblog.Repository.AutorRepository;
import com.fiap.springblog.model.Autor;

import java.util.List;

public interface AutorService {

    public List<Autor> obterTodos();
    public Autor obterPorCodigo(String codigo);
    public Autor criar(Autor autor);
    public void remover(String id);
}
