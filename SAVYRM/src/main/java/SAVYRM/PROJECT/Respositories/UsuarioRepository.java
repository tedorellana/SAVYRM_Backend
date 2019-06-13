package SAVYRM.PROJECT.Respositories;

import SAVYRM.PROJECT.Entities.Usuario;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Integer>{
    
    Optional<Usuario> findUsuarioByNombreUsuarioAndContrasenhaUsuario(String nombreUsuario, String contrasenhaUsuario);
    
}
