package br.com.minhafinanca.controlefinanceiro.controller;

import br.com.minhafinanca.controlefinanceiro.DTO.DespesaDTO;
import br.com.minhafinanca.controlefinanceiro.DTO.DetalheDespesaDTO;
import br.com.minhafinanca.controlefinanceiro.controller.form.AtualizarDespesaForm;
import br.com.minhafinanca.controlefinanceiro.controller.form.DespesaForm;
import br.com.minhafinanca.controlefinanceiro.model.Despesa;
import br.com.minhafinanca.controlefinanceiro.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
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
    @Transactional
    public ResponseEntity<DespesaDTO> cadastrar(@RequestBody @Valid DespesaForm form, UriComponentsBuilder uriBuilder){
        Despesa despesa = form.converter();
        despesaRepository.save(despesa);
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(despesa.getId()).toUri();
        return ResponseEntity.created(uri).body(new DespesaDTO(despesa));
    }

    @GetMapping("/{id}")//caso o PathVariable tiver nomeclatura diferente usar o @PathVariable("id")
    public DetalheDespesaDTO detalhe(@PathVariable("id") Long id){
        Despesa despesa = despesaRepository.getById(id);
        return new DetalheDespesaDTO(despesa);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DespesaDTO> atualizar(@PathVariable("id") Long id, @RequestBody @Valid AtualizarDespesaForm form){
        Despesa despesa = form.atualizar(id,despesaRepository);

        return ResponseEntity.ok(new DespesaDTO(despesa));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity remover(@PathVariable Long id){
        despesaRepository.deleteById(id);
        return  ResponseEntity.ok().build();
    }
}