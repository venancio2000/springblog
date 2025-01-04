package com.fiap.springblog.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "artigo") // Define a coleção do MongoDB
@Data
@ToString
public class Artigo {

    @Id
    private String codigo; // Esse campo será o _id no MongoDB

    private String titulo;
    private LocalDateTime data;
    private String texto;
    private String url;
    private Integer status;
}
