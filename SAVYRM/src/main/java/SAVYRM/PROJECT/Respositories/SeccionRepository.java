package SAVYRM.PROJECT.Respositories;

import SAVYRM.PROJECT.Entities.Seccion;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SeccionRepository extends PagingAndSortingRepository<Seccion, Integer>{
    
    Iterable<Seccion> findAllByAlmacenIdAlmacenIn(Iterable<Integer> idAlmacen);
    
    Iterable<Seccion> findAllByAlmacenIdAlmacen(Integer idAlmacen);
    
    
}
