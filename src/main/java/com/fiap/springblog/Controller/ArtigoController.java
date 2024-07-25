package com.fiap.springblog.Controller;

import com.fiap.springblog.Service.ArtigoService;
import com.fiap.springblog.model.Artigo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/artigos")
public class ArtigoController {

    @Autowired
    private ArtigoService artigoService;


    @GetMapping
    public List<Artigo> obterTodos(){

        return this.artigoService.obterTodos();
    }

    @GetMapping("/{codigo}")
    public Artigo obterPorCodigo(@PathVariable String codigo){

        return this.artigoService.obterPorCodigo(codigo);
    }

    @PostMapping
    public Artigo criar(@RequestBody  Artigo artigo){

        return this.artigoService.criar(artigo);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable String codigo){
        this.artigoService.remover(codigo);
    }

}
