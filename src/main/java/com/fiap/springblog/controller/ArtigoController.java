package com.fiap.springblog.controller;

import com.fiap.springblog.model.Artigo;
import com.fiap.springblog.service.ArtigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
    public Artigo criar(@RequestBody Artigo artigo) {
        System.out.println("Artigo recebido: " + artigo); // Para depuração
        return this.artigoService.criar(artigo);
    }
    @GetMapping("/maiordata")
    public List<Artigo> findByDataGreaterThan(@RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime data) {
        System.out.println("Recebido parâmetro data: " + data);
        return this.findByDataGreaterThan(data);
    }





}
