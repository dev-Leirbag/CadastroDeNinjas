package dev.java10x.CadastroDeNinjas.Ninjas;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service //? Anotação para indicar que esta classe é um serviço, responsável pela lógica de negócios da aplicação
@RequiredArgsConstructor
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    //Listar todos os meus ninjas
    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();

        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    //Lista ninja por ID
    public NinjaDTO listarNinjasPorId(Long id) {
         Optional<NinjaModel> ninja = ninjaRepository.findById(id);

        return ninja.map(ninjaMapper::map).orElse(null);
    }

    // Criar um novo ninja
    public NinjaDTO criarNinja (NinjaDTO ninjaDTO) {

        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        var ninjaSalvo = ninjaRepository.save(ninja);

        return ninjaMapper.map(ninjaSalvo);
    }

    // Deletar o ninja - tem que ser um metodo VOID
    public void deletarNinjaPorId (Long id) {
        ninjaRepository.deleteById(id);
    }

    // Atualizar Ninja
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);

        if (ninja.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            var ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }

}
