package tatf.core.properties;

/**
 * Interfaz para leer propiedades de diferentes archivos de configuración.
 */
public interface IPropertyReader {
    /**
     * Crea una instancia de IPropertyReader con la implementación adecuada.
     *
     * @param filePath Ruta del archivo de configuración.
     * @param fileName Nombre del archivo de configuración.
     * @return Una instancia de IPropertyReader.
     */
    static IPropertyReader create(String filePath, String fileName) {
        return new PropertyReaderImpl(filePath, fileName);
    }

    /**
     * Obtiene el valor asociado a una clave específica en el archivo de configuración.
     *
     * @param key Clave de la propiedad.
     * @return Valor asociado a la clave especificada.
     */
    String getValue(String key);
}
