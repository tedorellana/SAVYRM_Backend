package SAVYRM.PROJECT.Respositories;

import SAVYRM.PROJECT.Entities.ProductoSeccion;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductoSeccionRepository extends PagingAndSortingRepository<ProductoSeccion, Integer>{
    
    Iterable<ProductoSeccion> findAllBySeccionIdSeccionIn(Iterable<Integer> idSeccion);
}
