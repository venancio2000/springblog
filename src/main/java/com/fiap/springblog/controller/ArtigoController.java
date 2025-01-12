package com.fiap.springblog.controller;

import com.fiap.springblog.model.Artigo;
import com.fiap.springblog.service.ArtigoService;
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
    public Artigo criar(@RequestBody Artigo artigo) {
        System.out.println("Artigo recebido: " + artigo); // Para depuração
        return this.artigoService.criar(artigo);
    }
    @GetMapping("/maiordata")
    public List<Artigo> findByDataGreaterThan(@RequestParam("data") String dataParam) {
        System.out.println("Data recebida como String: " + dataParam);
        try {
            LocalDateTime data = LocalDateTime.parse(dataParam);
            System.out.println("Data convertida para LocalDateTime: " + data);
            return this.artigoService.findByDataGreaterThan(data);
        } catch (Exception e) {
            throw new IllegalArgumentException("Formato inválido. Use o formato: yyyy-MM-dd'T'HH:mm:ss", e);
        }
    }

    @GetMapping("/data-status")
    public List<Artigo> findByDataAndStatus(
            @RequestParam LocalDateTime data,
            @RequestParam Integer status){
        return this.artigoService.findByDataAndStatus(data, status);
    }

    @PutMapping  
    public void atualizar(@RequestBody Artigo updateArtigo){
        this.artigoService.atualizar(updateArtigo);
    }






}
