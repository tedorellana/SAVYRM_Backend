package SAVYRM.PROJECT.Respositories;

import SAVYRM.PROJECT.Entities.Servicio;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ServicioRepository extends PagingAndSortingRepository<Servicio, Integer>{
    
    List<Servicio> findByHoraFinServicio(String horaFinServicio);
    
    Optional<Servicio> findByPersonaAtendida(Integer personaAtendida);
    
    Optional<Servicio> findByIdServicio(Integer idServicio);
    
    List<Servicio> findByTipoServicioIdTipoServicio(Integer idTipoServicio);
    
    List<Servicio> findByTipoServicioIdTipoServicioOrderByHoraFinServicioDesc(Integer idTipoServicio);
}
