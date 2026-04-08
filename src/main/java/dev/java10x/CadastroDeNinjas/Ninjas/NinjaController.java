package dev.java10x.CadastroDeNinjas.Ninjas;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //? Anotação para indicar que esta classe é um controlador REST
@RequestMapping("/ninja") //? Anotação para mapear as requisições HTTP para um caminho específico (neste caso, a raiz "/")
@RequiredArgsConstructor
public class NinjaController {

    private final NinjaService ninjaService;

    @GetMapping("/boasvindas") //? Anotação para mapear as requisições GET para o caminho "/boasvindas"
    public String boasVindas() {
        return "Boas vindas, esse é o meu primeiro projeto em Java 10x, estou muito feliz por isso!";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar") //? Anotação para mapear as requisições POST para o caminho "/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // Mostrar ninjas por id (READ)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable long id) {
        return ninjaService.listarNinjasPorId(id);
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
