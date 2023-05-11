package persistencia;

import model.DiscosDonPepe;

public class Persistencia {

    public static final String RUTA_ARCHIVO_MODELO_SUBASTAS_BINARIO = "src/persistencia/model.dat";
    public static final String RUTA_ARCHIVO_MODELO_SUBASTAS_XML = "src/persistencia/model.xml";

    
//	----------------------LOADS------------------------

   



    //------------------------------------SERIALIZACION  y XML
    public static DiscosDonPepe cargarRecursoDiscosBinario() {

    	DiscosDonPepe discos = null;

        try {
        	discos = (DiscosDonPepe) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_SUBASTAS_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return discos;
    }

    public static void guardarRecursoDiscosBinario(DiscosDonPepe discos) {

        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_SUBASTAS_BINARIO, discos);
            // Revisar si en binario guarda el tipo File y Date, de lo contrario, hay que buscar cómo hacerlo
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static DiscosDonPepe cargarRecursodiscosXML() {

    	DiscosDonPepe discos  = null;

        try {
        	discos = (DiscosDonPepe) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_SUBASTAS_XML);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return discos;
    }


    public static void guardarRecursodiscosXML(DiscosDonPepe discos ) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_SUBASTAS_XML, discos);
            // Revisar si en XML también guarda el tipo File y Date, de lo contrario, hay que buscar cómo hacerlo
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
