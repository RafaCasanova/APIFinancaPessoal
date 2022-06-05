package br.com.minhafinanca.controlefinanceiro.controller.form;

import br.com.minhafinanca.controlefinanceiro.model.Despesa;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter @Setter
public class DespesaForm {

    private String nome;

    private String descricao;

    private BigDecimal valor;

    public Despesa converter(){
        return new Despesa(nome,descricao,valor);
    }
}
