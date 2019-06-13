package SAVYRM.PROJECT.Respositories;

import SAVYRM.PROJECT.Entities.Producto;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductoRepository extends PagingAndSortingRepository<Producto, Integer>{
    
    Iterable<Producto> findAllByEstadoProducto(Integer estadoProducto);
    
    Iterable<Producto> findByEstadoProductoAndTipoProductoIdTipoProductoNot(Integer estadoProducto, Integer idTipoProducto);
    
    
}
