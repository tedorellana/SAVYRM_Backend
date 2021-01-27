package SAVYRM.PROJECT.Respositories;

import SAVYRM.Containers.ProductoSeccionPrecio;
import SAVYRM.PROJECT.Entities.OrdenCompra;
import SAVYRM.PROJECT.Entities.OrdenCompraProducto;
import SAVYRM.PROJECT.Entities.ProductoSeccion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrdenCompraRepository extends PagingAndSortingRepository<OrdenCompra, Integer>{
    
}
