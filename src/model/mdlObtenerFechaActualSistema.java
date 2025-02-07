package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author alsan
 */
public class mdlObtenerFechaActualSistema {

    public static String mostrarFecha() {

        // Obtener la fecha actual del sistema
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaActual = ahora.format(formatter);
        
        return fechaActual;

    } 

}
