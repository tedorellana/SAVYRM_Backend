package SAVYRM.PROJECT.Respositories;

import SAVYRM.Containers.ProductoBase;
import SAVYRM.PROJECT.Entities.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductoRepository extends PagingAndSortingRepository<Producto, Integer>{
    
    Iterable<Producto> findAllByEstadoProducto(Integer estadoProducto);
    
    Iterable<Producto> findAllByIdProducto(Integer idProducto);
    
    @Query(
            value = "SELECT DISTINCT p.idProducto, p.nombreProducto, p.codigoProducto FROM producto as p\n" +
            "INNER JOIN productoformula as pf on pf.fk_idProductoElaborado = p.idProducto\n" +
            "AND p.estadoProducto = 1", 
            nativeQuery = true)
    Iterable<ProductoBase> findProductsWithElaboration();
    
    Iterable<Producto> findByEstadoProductoAndTipoProductoIdTipoProductoNot(Integer estadoProducto, Integer idTipoProducto);
    
    
}
