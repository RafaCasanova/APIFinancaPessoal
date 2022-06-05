package br.com.minhafinanca.controlefinanceiro.controller.form;

import br.com.minhafinanca.controlefinanceiro.model.Despesa;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
@Getter @Setter
public class DespesaForm {

    @NotNull @NotEmpty
    private String nome;

    private String descricao;

    @NotEmpty @NotNull
    private BigDecimal valor;

    public Despesa converter(){
        return new Despesa(nome,descricao,valor);
    }
}
