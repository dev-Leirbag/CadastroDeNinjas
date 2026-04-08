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
    public String criarMissao(){
        return "Criando missão";
    }

    // Mostrar todas as missoes (READ)
    @GetMapping("/listar")
    public List<MissoesModel> mostrarTodasAsMissoes(){
        return missoesService.listarMissoes();
    }

    // Mostrar missoes por id (READ)
    @GetMapping("/todosID")
    public String mostrarTodasAsMissoesPorId(){
        return "Mostrar todas as missões por ID";
    }

    // Alterar dados das missoes (UPDATE)
    @PutMapping("/alterarID")
    public String alterarID(){
        return "Alterar missão por ID";
    }

    // Deletar Missao (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarID(){
        return "Deletar missão por ID";
    }

}
