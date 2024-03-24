package br.com.faculdade.imepac.entidade.pessoa;

import lombok.Data;

import java.time.LocalDate;
@Data
public class CarteiraTrabalho {
    private String numero;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String endereco;
    private String profissao;
}
