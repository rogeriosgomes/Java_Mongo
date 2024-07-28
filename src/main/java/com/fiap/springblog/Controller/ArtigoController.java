package com.fiap.springblog.Controller;

import com.fiap.springblog.Service.ArtigoService;
import com.fiap.springblog.model.Artigo;
import com.fiap.springblog.model.ArtigoStatusCount;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/status-maiordata")
    public List<Artigo> findByStatusAndDataGreaterThan (@RequestParam("status") Integer status,
                                                        @RequestParam("data") LocalDateTime data){
        return this.artigoService.findByStatusAndDataGreaterThan(status, data);
    }

    @GetMapping("/periodo")
    public List<Artigo> obterArtigoPorDataHora(@RequestParam("de") LocalDateTime de,
                                               @RequestParam("ate") LocalDateTime ate){
        return this.artigoService.obterArtigoPorDataHora(de, ate);
    }

    @GetMapping("/complexos")
    public List<Artigo> encontrarArtigoComplexos(@RequestParam Integer status,
                                                 @RequestParam LocalDateTime data,
                                                 @RequestParam String nome){
        return  this.artigoService.encontrarArtigoComplexos(status,data,nome);
    }

    @GetMapping("/pagina-artigos")
    public ResponseEntity<Page<Artigo>> listaArtigos(Pageable pageable){
        Page<Artigo> artigos = this.artigoService.listaArtigos(pageable);

        return ResponseEntity.ok(artigos);

    }

    @GetMapping("/ordem")
    public List<Artigo> findByStatusOrderByNomeAsc(@RequestParam("status") Integer Status){
        return this.artigoService.findByStatusOrderByNomeAsc(Status);
    }

    @GetMapping("/pesquisa-texto")
    public List<Artigo> findByTexto(@RequestParam("searchTerm") String searchTerm){
        return this.artigoService.findByTexto(searchTerm);
    }

    @GetMapping("/agregracao")
    public List<ArtigoStatusCount> contarArtigosPorStatus(Integer status){
        return this.artigoService.contarArtigosPorStatus(status);
    }

}
