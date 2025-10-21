package suites;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import tests.CrearCuentaAdminParametrizado;
import tests.CrearCuentaTesterParametrizado;
import tests.EliminarCuentaTesterParametrizado;
import tests.ReiniciarContraseñaParametrizado;

@Suite
@SelectClasses({CrearCuentaAdminParametrizado.class,
        CrearCuentaTesterParametrizado.class,
        EliminarCuentaTesterParametrizado.class,
        ReiniciarContraseñaParametrizado.class
})
public class SuitePorClase {
}
