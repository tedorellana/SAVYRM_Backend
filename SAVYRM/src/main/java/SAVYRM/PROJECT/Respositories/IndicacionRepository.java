package SAVYRM.PROJECT.Respositories;

import SAVYRM.PROJECT.Entities.Indicacion;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IndicacionRepository extends PagingAndSortingRepository<Indicacion, Integer>{
    
    Iterable<Indicacion> findByPreparacionProductoIdProducto(Integer idProducto);
}
