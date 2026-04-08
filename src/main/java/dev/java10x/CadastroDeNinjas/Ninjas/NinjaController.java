package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController //? Anotação para indicar que esta classe é um controlador REST
@RequestMapping("/ninja") //? Anotação para mapear as requisições HTTP para um caminho específico (neste caso, a raiz "/")
public class NinjaController {

    @GetMapping("/boasvindas") //? Anotação para mapear as requisições GET para o caminho "/boasvindas"
    public String boasVindas() {
        return "Boas vindas, esse é o meu primeiro projeto em Java 10x, estou muito feliz por isso!";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar") //? Anotação para mapear as requisições POST para o caminho "/criar")
    public String criarNinja() {
        return "Ninja Criado";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public String mostrarTodosOsNinja() {
        return "Mostrar ninja";
    }

    // Mostrar ninjas por id (READ)
    @GetMapping("/listarID")
    public String mostrarTodosOsNinjaPorId() {
        return "Mostrar ninja por ID";
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId() {
        return "Aletar ninja por ID";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId() {
        return "Ninja deletado por ID";
    }

}
