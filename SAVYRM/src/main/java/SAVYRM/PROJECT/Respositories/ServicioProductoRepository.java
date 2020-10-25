package SAVYRM.PROJECT.Respositories;

import SAVYRM.PROJECT.Entities.ServicioProducto;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ServicioProductoRepository extends PagingAndSortingRepository<ServicioProducto, Integer>{

    //List<ServicioProducto> findByIdServicioProductoSeccionAndServicioTipoServicioIdTipoServicio(Integer idTipoServicio);
    
    List<ServicioProducto> findByServicioTipoServicioIdTipoServicio(Integer idTipoServicio);
    
    List<ServicioProducto> findByIdServicioProductoSeccion(Integer idServicioProductoSeccion);
    
}
