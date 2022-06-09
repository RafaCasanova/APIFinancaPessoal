package br.com.minhafinanca.controlefinanceiro.controller.form;

import br.com.minhafinanca.controlefinanceiro.model.Despesa;
import br.com.minhafinanca.controlefinanceiro.model.StatusDaCompra;
import br.com.minhafinanca.controlefinanceiro.repository.DespesaRepository;
import com.sun.istack.NotNull;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Getter
public class AtualizarDespesaForm {

    @NotNull
    private String descricao;

    @NotNull @NotEmpty
    private BigDecimal valor;

    @NotNull @NotEmpty
    private String nome;

    private String statusDaCompra;

    private String tipoDePagamento;

    public Despesa atualizar(Long id,DespesaRepository despesaRepository){
        Despesa despesa = despesaRepository.getById(id);
        despesa.setDescricao(this.descricao);
        despesa.setValor(this.valor);
        despesa.setNome(this.nome);
        if(this.statusDaCompra != null){
            despesa.setStatusDaCompra(StatusDaCompra.valueOf(this.statusDaCompra));
        }
        if(this.tipoDePagamento != null){
            despesa.setStatusDaCompra(StatusDaCompra.valueOf(this.tipoDePagamento));
        }
        return despesa;
    }

}
