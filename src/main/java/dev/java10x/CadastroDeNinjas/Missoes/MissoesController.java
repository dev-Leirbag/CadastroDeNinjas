package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes") //? Anotação para mapear as requisições HTTP para um caminho específico (neste caso, "/missoes")
public class MissoesController {

    // Adicionar missão (CREATE)
    @PostMapping("/criar")
    public String criarMissao(){
        return "Criando missão";
    }

    // Mostrar todas as missoes (READ)
    @GetMapping("/todos")
    public String mostrarTodasAsMissoes(){
        return "Mostrar todas as missões";
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
