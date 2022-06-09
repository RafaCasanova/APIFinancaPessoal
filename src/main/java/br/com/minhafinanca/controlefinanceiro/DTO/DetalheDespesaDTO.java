package br.com.minhafinanca.controlefinanceiro.DTO;

import br.com.minhafinanca.controlefinanceiro.model.Despesa;
import br.com.minhafinanca.controlefinanceiro.model.StatusDaCompra;
import br.com.minhafinanca.controlefinanceiro.model.TipoDePagamento;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class DetalheDespesaDTO {

    private Long id;

    private String nome;

    private String descricao;

    private BigDecimal valor;

    private String dataDeCompra;

    private String status;

    private String tipoDePagamento;


    public DetalheDespesaDTO(Despesa despesa){
        this.id = despesa.getId();
        this.nome = despesa.getNome();
        this.valor = despesa.getValor();
        this.dataDeCompra = despesa.getDataDeCompra();
        this.descricao = despesa.getDescricao();
        this.tipoDePagamento = despesa.getTipoDePagamento().toString();
        this.status = despesa.getStatusDaCompra().toString();
    }

//    public  static List<DespesaDTO> converte(List<Despesa> despesa){
//        return despesa.stream().map(DespesaDTO::new).collect(Collectors.toList());
//    }

}
