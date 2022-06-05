package br.com.minhafinanca.controlefinanceiro.controller;

import br.com.minhafinanca.controlefinanceiro.DTO.DespesaDTO;
import br.com.minhafinanca.controlefinanceiro.controller.form.DespesaForm;
import br.com.minhafinanca.controlefinanceiro.model.Despesa;
import br.com.minhafinanca.controlefinanceiro.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/despesas")
public class ComprasController {

    @Autowired
    private DespesaRepository despesaRepository;

    @GetMapping
    public List<DespesaDTO> lista(String nome) {
        System.out.println(nome);
        if (nome == null) {
            List<Despesa> despesaList = despesaRepository.findAll();
            return DespesaDTO.converte(despesaList);
        } else {
            List<Despesa> despesaList = despesaRepository.findByNome(nome);
            return DespesaDTO.converte(despesaList);
        }
    }

    @PostMapping
    public ResponseEntity<DespesaDTO> cadastrar(@RequestBody DespesaForm form, UriComponentsBuilder uriBuilder){
        Despesa despesa = form.converter();
        despesaRepository.save(despesa);
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(despesa.getId()).toUri();
        return ResponseEntity.created(uri).body(new DespesaDTO(despesa));
    }
}