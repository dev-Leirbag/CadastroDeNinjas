package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MissoesMapper {

    @Autowired
    private NinjaMapper ninjaMapper;

    public MissoesModel map(MissoesDTO missoesDTO) {
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        return missoesModel;
    }

    public MissoesDTO map(MissoesModel missoesModel) {
        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNome(missoesModel.getNome());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());

        if(missoesModel.getNinjas()!=null){
            List<NinjaDTO> ninjaDTOList = missoesModel.getNinjas().stream()
                    .map(ninjaModel -> {
                        NinjaDTO dto = ninjaMapper.map(ninjaModel);
                        dto.setMissoes(null);

                        return dto;
                    })
                    .collect(Collectors.toList());
            missoesDTO.setNinjas(ninjaDTOList);
        }

        return missoesDTO;
    }

}
