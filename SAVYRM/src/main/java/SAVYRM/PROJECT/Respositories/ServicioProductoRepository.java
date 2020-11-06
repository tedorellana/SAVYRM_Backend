package SAVYRM.PROJECT.Respositories;

import SAVYRM.Containers.SalesReport;
import SAVYRM.PROJECT.Entities.ServicioProducto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ServicioProductoRepository extends PagingAndSortingRepository<ServicioProducto, Integer>{

    //List<ServicioProducto> findByIdServicioProductoSeccionAndServicioTipoServicioIdTipoServicio(Integer idTipoServicio);
    
    List<ServicioProducto> findByServicioTipoServicioIdTipoServicio(Integer idTipoServicio);
    
    // find all sales summatory grouped by product id
    @Query(
            value = "SELECT p.nombreProducto, SUM(sp.cantidadServicioProducto) as cantidadTotal FROM savyrm.servicioproducto sp \n" +
                "inner join savyrm.servicio as s on s.idServicio = sp.fk_idServicio\n" +
                "inner join savyrm.tiposervicio as ts on ts.idTipoServicio = s.fk_idTipoServicio\n" +
                "inner join savyrm.productoSeccion as ps on ps.idProductoSeccion = sp.fk_idProductoSeccion\n" +
                "inner join savyrm.producto as p on p.idProducto = ps.fk_idProducto\n" +
                "where ts.idTipoServicio = '2'\n" +
                "GROUP BY p.idProducto", 
            nativeQuery = true)
    List<SalesReport> findAllSales(Integer idTipoServicio);
    
    List<ServicioProducto> findByIdServicioProductoSeccion(Integer idServicioProductoSeccion);
    
    List<ServicioProducto> findByServicioIdServicio(Integer idServicioProductoSeccion);
}
