package com.fiap.springblog.Controller;

import com.fiap.springblog.Service.ArtigoService;
import com.fiap.springblog.model.Artigo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    @GetMapping("/maiordata")
    public List<Artigo> findByDataGreaterThan(@RequestParam("data")LocalDateTime data){
        return this.artigoService.findByDataGreaterThan(data);
    }

    @GetMapping("/data-status")
    public List<Artigo> findByDataAndStatus(@RequestParam("data")LocalDateTime data,
                                            @RequestParam("status") int status){
        return this.artigoService.findByDataAndStatus(data, status);
    }

    @PutMapping
    public void atualizar(@RequestBody Artigo artigo){
        this.artigoService.atualizar(artigo);
    }

    @PutMapping("/{id}")
    public void atualizarUrl(@PathVariable String id, @RequestBody String novaUrl){

        this.atualizarUrl(id, novaUrl);

    }

}
