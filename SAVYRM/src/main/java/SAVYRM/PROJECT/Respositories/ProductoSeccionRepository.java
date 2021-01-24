package SAVYRM.PROJECT.Respositories;

import SAVYRM.Containers.ProductoSeccionPrecio;
import SAVYRM.PROJECT.Entities.ProductoSeccion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductoSeccionRepository extends PagingAndSortingRepository<ProductoSeccion, Integer>{
    
    Iterable<ProductoSeccion> findAllBySeccionIdSeccionIn(Iterable<Integer> idSeccion);
    
    Iterable<ProductoSeccion> findByOrderByLoteFechaCaducidadLoteDesc();
    
    Iterable<ProductoSeccion> findByOrderByLoteFechaCaducidadLoteAsc();
//LoteFechaCaducidadLote
    @Query(
            value = "SELECT p.idProducto, p.nombreProducto, ps.idProductoSeccion, ps.cantidadProductoSeccion, " +
                "ps.fechaIngreso, pr.idPrecio, pr.unitarioPrecio, pr.vigentePrecio, p.codigoProducto, " + 
                "um.abreviacion FROM producto p " +
                "inner join productoseccion ps on p.idProducto = ps.fk_idProducto " +
                "inner join lote l on l.idLote = ps.fk_idLote " +
                "inner join unidadmedida um on um.idUnidadMedida = p.fk_idUnidadMedida " +
                "inner join precio pr on pr.fk_idProducto = p.idProducto " +
                "where pr.vigentePrecio = 1", 
            nativeQuery = true)
    Iterable<ProductoSeccionPrecio> findProductoSeccionWithPrecio();
}
