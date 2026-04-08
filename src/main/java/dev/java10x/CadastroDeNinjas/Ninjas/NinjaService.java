package dev.java10x.CadastroDeNinjas.Ninjas;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //? Anotação para indicar que esta classe é um serviço, responsável pela lógica de negócios da aplicação
@RequiredArgsConstructor
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    //Listar todos os meus ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    //Lista ninja por ID
    public NinjaModel listarNinjasPorId(Long id) {
        var ninja = ninjaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ninja não encontrado com o ID: " + id));;

        return ninja;
    }

}
