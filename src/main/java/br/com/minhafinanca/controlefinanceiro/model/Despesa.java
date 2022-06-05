package br.com.minhafinanca.controlefinanceiro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "despesas")
public class Despesa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private StatusDaCompra statusDaCompra = StatusDaCompra.AGUARDANDO_PAGAMENTO;
    @Enumerated(EnumType.STRING)
    private TipoDePagamento tipoDePagamento = TipoDePagamento.AVISTA;

    private LocalDateTime dataDeCompra = LocalDateTime.now();

    @ManyToOne
    private Usuario usuario;

    @JsonIgnore
    @Transient
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    public Despesa(String nome, String descricao, BigDecimal valor){
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDataDeCompra(){
        return this.dataDeCompra.format(format);
    }
}
