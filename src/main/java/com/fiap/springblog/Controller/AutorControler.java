package com.fiap.springblog.Controller;

import com.fiap.springblog.Repository.AutorRepository;
import com.fiap.springblog.Service.AutorService;
import com.fiap.springblog.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/autor")
public class AutorControler {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<Autor> obtertodos(){
        return autorService.obterTodos();
    }

    @GetMapping("/{codigo}")
    public Autor obterPorCodigo(@PathVariable String codigo){
        return autorService.obterPorCodigo(codigo);
    }

    @PostMapping
    public Autor criar(@RequestBody  Autor autor){
        return autorService.criar(autor);
    }

    @PutMapping("/{codigo}")
    public void remover(@PathVariable  String codigo){
        autorService.remover(codigo);
    }
}
