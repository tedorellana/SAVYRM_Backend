package SAVYRM.PROJECT.Respositories;

import SAVYRM.PROJECT.Entities.ProductoFormula;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductoFormulaRepository extends PagingAndSortingRepository<ProductoFormula, Integer>{
    
    Iterable<ProductoFormula> findAllByProductoElaboradoIdProducto(Integer idProducto);
    
}
