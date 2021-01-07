package SAVYRM.PROJECT.Respositories;

import SAVYRM.PROJECT.Entities.Persona;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonaRepository extends PagingAndSortingRepository<Persona, Integer>{
    
    List<Persona> findByUsuarioTipoUsuarioIdTipoUsuario(Integer idTIpoUsuario);
    
}
