package br.com.padaria.automacaopaes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Date;

@Data
public class UsuarioCreateDto {

    @JsonProperty
    private String nome;

    @JsonProperty("dt-nascimento")
    private Date dtNascimento;


}


