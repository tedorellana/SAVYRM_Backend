package SAVYRM.PROJECT.Respositories;

import SAVYRM.Containers.ProductoSeccionPrecio;
import SAVYRM.PROJECT.Entities.OrdenCompra;
import SAVYRM.PROJECT.Entities.OrdenCompraProducto;
import SAVYRM.PROJECT.Entities.ProductoSeccion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrdenCompraProductoRepository extends PagingAndSortingRepository<OrdenCompraProducto, Integer>{
    Iterable<OrdenCompraProducto> findAllByProductoIdProducto(Integer idProducto);
    
    Iterable<OrdenCompraProducto> findByProductoIdProductoOrderByFechaEntregaPrevistaOrdenCompraProductoDesc(Integer idProducto);
}
