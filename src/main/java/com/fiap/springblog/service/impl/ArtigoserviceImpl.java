package com.fiap.springblog.service.impl;

import com.fiap.springblog.model.Artigo;
import com.fiap.springblog.model.Autor;
import com.fiap.springblog.repository.ArtigoRepository;
import com.fiap.springblog.repository.AutorRepository;
import com.fiap.springblog.service.ArtigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtigoserviceImpl implements ArtigoService {

    @Autowired
    private ArtigoRepository artigoRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<Artigo> obterTodos() {
        return this.artigoRepository.findAll();
    }

    @Override
    public Artigo obterPorCodigo(String codigo) {
        return this.artigoRepository
                .findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Artigo não existe!"));
    }

    @Override
    public Artigo criar(Artigo artigo) {
        // se o autor existe
        if (artigo.getAutor().getCodigo() != null){

            //recuperar o autor
            Autor autor = this.autorRepository
                    .findById(artigo.getAutor().getCodigo())
                    .orElseThrow(() -> new IllegalArgumentException("Autor inexistente!"));

            //Definie o autor no artigo
            artigo.setAutor(autor);
        }else {
            //senão, não atribuir um autor ao artigo
            artigo.setAutor(null);
        }
        //System.out.println("Salvando artigo: " + artigo); // Adicione logs para verificar
        //Salvo o artigo com o autor já cadastrado
        return this.artigoRepository.save(artigo);
    }

}
