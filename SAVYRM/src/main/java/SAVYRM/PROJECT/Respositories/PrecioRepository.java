package SAVYRM.PROJECT.Respositories;

import SAVYRM.PROJECT.Entities.Precio;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PrecioRepository extends PagingAndSortingRepository<Precio, Integer>{
    
    Iterable<Precio> findByProductoIdProductoAndVigentePrecio(Integer idProducto, Integer vigente);
}
