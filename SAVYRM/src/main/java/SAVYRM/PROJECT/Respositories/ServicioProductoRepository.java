package SAVYRM.PROJECT.Respositories;

import SAVYRM.Containers.LabelAndNodeReport;
import SAVYRM.PROJECT.Entities.ServicioProducto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ServicioProductoRepository extends PagingAndSortingRepository<ServicioProducto, Integer>{

    //List<ServicioProducto> findByIdServicioProductoSeccionAndServicioTipoServicioIdTipoServicio(Integer idTipoServicio);
    
    List<ServicioProducto> findByServicioTipoServicioIdTipoServicio(Integer idTipoServicio);
    
    // find all sales summatory grouped by product id
    @Query(
            value = "SELECT p.nombreProducto as label, SUM(sp.cantidadServicioProducto) as y FROM savyrm.servicioproducto sp \n" +
                "inner join savyrm.servicio as s on s.idServicio = sp.fk_idServicio\n" +
                "inner join savyrm.tiposervicio as ts on ts.idTipoServicio = s.fk_idTipoServicio\n" +
                "inner join savyrm.productoSeccion as ps on ps.idProductoSeccion = sp.fk_idProductoSeccion\n" +
                "inner join savyrm.producto as p on p.idProducto = ps.fk_idProducto\n" +
                "where ts.idTipoServicio = '2'\n" +
                "GROUP BY p.idProducto", 
            nativeQuery = true)
    List<LabelAndNodeReport> findAllSales(Integer idTipoServicio);
    
    // find revenue per date
    @Query(
            value = "SELECT CONCAT(YEAR(s.horaInicioServicio), \"-\" , MONTH(s.horaInicioServicio), \"-\", DAY(s.horaInicioServicio)) as label, SUM(sp.costoTotal) as y FROM savyrm.servicioproducto sp\n" +
                "inner join savyrm.servicio as s on s.idServicio = sp.fk_idServicio\n" +
                "inner join savyrm.tiposervicio as ts on ts.idTipoServicio = s.fk_idTipoServicio\n" +
                "inner join savyrm.productoSeccion as ps on ps.idProductoSeccion = sp.fk_idProductoSeccion\n" +
                "inner join savyrm.producto as p on p.idProducto = ps.fk_idProducto\n" +
                "where ts.idTipoServicio = '2'\n" +
                "GROUP BY YEAR(s.horaInicioServicio), MONTH(s.horaInicioServicio), DAY(s.horaInicioServicio)", 
            nativeQuery = true)
    List<LabelAndNodeReport> findRevenuePerDay(Integer idTipoServicio);
    
    // find the average of sales per day
    @Query(
            value = "SELECT CONCAT(YEAR(s.horaInicioServicio), \"-\" , MONTH(s.horaInicioServicio), \"-\", DAY(s.horaInicioServicio)) as label, COUNT(s.idServicio) as y FROM savyrm.servicioproducto sp\n" +
                "inner join savyrm.servicio as s on s.idServicio = sp.fk_idServicio\n" +
                "inner join savyrm.tiposervicio as ts on ts.idTipoServicio = s.fk_idTipoServicio\n" +
                "inner join savyrm.productoSeccion as ps on ps.idProductoSeccion = sp.fk_idProductoSeccion\n" +
                "inner join savyrm.producto as p on p.idProducto = ps.fk_idProducto\n" +
                "where ts.idTipoServicio = '2'\n" +
                "GROUP BY YEAR(s.horaInicioServicio), MONTH(s.horaInicioServicio), DAY(s.horaInicioServicio)", 
            nativeQuery = true)
    List<LabelAndNodeReport> findSalesAveragePerDay(Integer idTipoServicio);
    
    // find revenue per product
    @Query(
            value = "SELECT p.nombreProducto as label, SUM(sp.costoTotal) as y FROM savyrm.servicioproducto sp \n" +
                "inner join savyrm.servicio as s on s.idServicio = sp.fk_idServicio\n" +
                "inner join savyrm.tiposervicio as ts on ts.idTipoServicio = s.fk_idTipoServicio\n" +
                "inner join savyrm.productoSeccion as ps on ps.idProductoSeccion = sp.fk_idProductoSeccion\n" +
                "inner join savyrm.producto as p on p.idProducto = ps.fk_idProducto\n" +
                "where ts.idTipoServicio = '2'\n" +
                "GROUP BY p.idProducto;", 
            nativeQuery = true)
    List<LabelAndNodeReport> findRevenuePerProduct(Integer idTipoServicio);    
    
    // find the sales atended per employee
    @Query(
            value = "SELECT CONCAT(pe.apellidoPaternoPersona, \" \", pe.apellidoMaternoPersona, \" \", pe.nombrePersona) as label, Count(s.idServicio) as y FROM savyrm.servicioproducto sp \n" +
                "inner join savyrm.servicio as s on s.idServicio = sp.fk_idServicio\n" +
                "inner join savyrm.persona as pe on pe.idPersona = s.idPersonaEmpleado\n" +
                "inner join savyrm.tiposervicio as ts on ts.idTipoServicio = s.fk_idTipoServicio\n" +
                "inner join savyrm.productoSeccion as ps on ps.idProductoSeccion = sp.fk_idProductoSeccion\n" +
                "inner join savyrm.producto as p on p.idProducto = ps.fk_idProducto\n" +
                "where ts.idTipoServicio = '2'\n" +
                "GROUP BY s.idPersonaEmpleado;", 
            nativeQuery = true)
    List<LabelAndNodeReport> findSalesAtendedPerEmployeee(Integer idTipoServicio);
    
    List<ServicioProducto> findByIdServicioProductoSeccion(Integer idServicioProductoSeccion);
    
    List<ServicioProducto> findByServicioIdServicio(Integer idServicioProductoSeccion);
    
    List<ServicioProducto> findAllByEntregado(Boolean entregado);
    
    List<ServicioProducto> findAllByEntregadoOrderByFechaEntregaPrevistaAsc(Boolean entregado);
}
