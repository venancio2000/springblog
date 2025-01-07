package com.fiap.springblog.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "autor")
@Data
@ToString
public class Autor {
    @Id
    private String codigo;
    private String nome;
    private String biografia;
    private String imagem;
}
