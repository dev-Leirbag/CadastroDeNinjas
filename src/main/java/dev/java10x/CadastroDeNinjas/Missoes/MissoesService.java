package dev.java10x.CadastroDeNinjas.Missoes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissoesService {

    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    // Lista todas as minhas missoes
    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();

        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    // Lista as missoes por ID
    public MissoesDTO listarMissoesPorId(long id) {
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);

        return missoesModel.map(missoesMapper::map).orElse(null);
    }

    // Cria uma nova missao
    public MissoesDTO criarMissao(MissoesDTO missao){
        MissoesModel missoesModel = missoesMapper.map(missao);
        var missaoSalva = missoesRepository.save(missoesModel);

        return missoesMapper.map(missaoSalva);
    }

    // Atualiza missao
    public MissoesDTO alterarMissaoPorId(Long id, MissoesDTO missao){
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);

        if (missoesModel.isPresent()){
            MissoesModel missaoAtualizada = missoesMapper.map(missao);
            missaoAtualizada.setId(id);
            var missaoSalva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }
            return null;
    }

    // Deleta uma missao
    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }
}
