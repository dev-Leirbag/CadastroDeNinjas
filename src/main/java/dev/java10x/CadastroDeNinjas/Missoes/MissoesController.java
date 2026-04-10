package dev.java10x.CadastroDeNinjas.Missoes;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missao") //? Anotação para mapear as requisições HTTP para um caminho específico (neste caso, "/missoes")
@RequiredArgsConstructor
public class MissoesController {

    private final MissoesService missoesService;

    // Adicionar missão (CREATE)
    @PostMapping("/criar")
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missao){
        return missoesService.criarMissao(missao);
    }

    // Mostrar todas as missoes (READ)
    @GetMapping("/listar")
    public List<MissoesDTO> mostrarTodasAsMissoes(){
        return missoesService.listarMissoes();
    }

    // Mostrar missoes por id (READ)
    @GetMapping("/listar/{id}")
    public MissoesDTO listarMissaoPorId(@PathVariable Long id){
        return missoesService.listarMissoesPorId(id);
    }

    // Alterar dados das missoes (UPDATE)
    @PutMapping("/alterar/{id}")
    public MissoesDTO alterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missao){
        return missoesService.alterarMissaoPorId(id, missao);
    }

    // Deletar Missao (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorId(@PathVariable Long id){
        missoesService.deletarMissaoPorId(id);
    }

}
