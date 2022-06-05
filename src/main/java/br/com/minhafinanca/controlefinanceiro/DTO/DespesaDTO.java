package br.com.minhafinanca.controlefinanceiro.DTO;

import br.com.minhafinanca.controlefinanceiro.model.Despesa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class DespesaDTO {
    //por boa pratica classes DTO não usam como atributo outras classes.
    private Long id;

    private String nome;

    private String descricao;

    private BigDecimal valor;

    private String dataDeCompra;

    public DespesaDTO(Despesa despesa){
        this.id = despesa.getId();
        this.nome = despesa.getNome();
        this.valor = despesa.getValor();
        this.dataDeCompra = despesa.getDataDeCompra();
        this.descricao = despesa.getDescricao();
    }
    public  static List<DespesaDTO> converte(List<Despesa> despesa){
        return despesa.stream().map(DespesaDTO::new).collect(Collectors.toList());
    }

}
