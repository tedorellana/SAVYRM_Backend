package SAVYRM.PROJECT.Respositories;

import SAVYRM.PROJECT.Entities.Persona;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonaRepository extends PagingAndSortingRepository<Persona, Integer>{
    
}
