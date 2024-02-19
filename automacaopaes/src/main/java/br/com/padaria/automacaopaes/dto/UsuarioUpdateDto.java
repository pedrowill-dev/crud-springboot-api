package br.com.padaria.automacaopaes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Date;
@Data

public class UsuarioUpdateDto {

    @JsonProperty
    private String nome;

    @JsonProperty("dt-nascimento")
    private Date dtNascimento;

    @JsonProperty
    private Long id;
}
