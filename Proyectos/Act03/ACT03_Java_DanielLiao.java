import java.time.LocalDate; //Necesario para el date 
import java.time.Period; //Necesario para el date 

public class ACT03_Java_DanielLiao{
    public static void main(String[] args) {
        System.out.println("=== Información Cámara Didáctica ===\n");
        
        // 1. Crear e inicializar una cámara
        System.out.println("1. Estado inicial de la cámara:");
        CamaraDidactica camara = new CamaraDidactica("Sonny123", "XYZ", false); // Este es el método constructor
        System.out.println(camara.toString());
        System.out.println("----------------------------------");

        // 2. Usamos los setters para modificar atributos y mostrar con toString()
        System.out.println("\n2. Modificando atributos con setters:");
        camara.setNumeroDeSerie("Sonny987");
        camara.setModelo("ABC");
        camara.setEsPrestada(true);
        camara.setResolucion(CamaraDidactica.Calidad.FULLHD); // Accede a la camara -> accede a la enumeracion Calidad -> Declara que es FULLHD
        /*
        -------------Otra alternativa:-------------
        import CamaraDidactica.Calidad; //Por fuera d ela funcion
        // Luego en el código:
        camara.setResolucion(Calidad.FULLHD);
        */
        camara.setModoGranAngular(true);
        camara.setZoom(2.5f); // Se pone f para decir que es flotante; si no se pone, es para un double
        System.out.println("Estado después de modificar atributos:");
        System.out.println(camara.toString());
        System.out.println("----------------------------------");
        
        // 3. Probar métodos de batería y mostrar cambios con toString()
        // 3.1 Consumir batería
        camara.recargarBateria(-70);
        System.out.println("\nDespués de consumir 70% de batería:");
        System.out.println(camara.toString());
        // 3.2 Consumir más para cambiar a modo ahorro
        camara.recargarBateria(-25);
        System.out.println("\nDespués de consumir 25% más:");
        System.out.println(camara.toString());
        // 3.3 Consumir para modo crítico
        camara.recargarBateria(-30);
        System.out.println("\nDespués de consumir 30% más: (No puede por el límite, se pone en 0)");
        System.out.println(camara.toString());
        // 3.4 Recarga parcial
        camara.recargarBateria(20);
        System.out.println("\nDespués de recarga parcial del 20%:");
        System.out.println(camara.toString());
        System.out.println("----------------------------------");
        // 3.4 Recarga completa
        camara.recargarBateria();
        System.out.println("\nDespués de recarga completa:");
        System.out.println(camara.toString());
        System.out.println("----------------------------------");
        
        // 4. Probar tomar fotos con diferentes resoluciones
        System.out.println("\n4. Prueba de fotos:");
        // Probar con resolución 4K
        camara.setResolucion(CamaraDidactica.Calidad.CUATRO_K);
        System.out.println("Intentando tomar foto en 4K");
        boolean exito1 = camara.tomarFoto();
        System.out.println("¿Foto tomada?: " + (exito1 ? "Sí" : "No"));
        System.out.println(camara.toString()); 
        // Probar con resolución FULLHD
        camara.setResolucion(CamaraDidactica.Calidad.FULLHD);
        System.out.println("\nIntentando tomar foto en FULLHD");
        boolean exito2 = camara.tomarFoto();
        System.out.println("¿Foto tomada?: " + (exito2 ? "Sí" : "No"));
        System.out.println(camara.toString());
        // Probar con batería crítica (no debería permitir)
        camara.recargarBateria(-95); // Dejar en 5%
        System.out.println("\nIntentando tomar foto con batería crítica");
        boolean exito3 = camara.tomarFoto();
        System.out.println("¿Foto tomada?: " + (exito3 ? "Sí" : "No"));
        System.out.println(camara.toString());
        System.out.println("----------------------------------");

        // 5. Mostrar valores constantes
        System.out.println("\n5. VALORES CONSTANTES:");
        System.out.println("Porcentaje mínimo referencial: " + camara.getPMinimoReferencial() + "%");
        System.out.println("Porcentaje mínimo para recarga: " + camara.getPMinimoRecarga() + "%");
        System.out.println("----------------------------------");

        // Prueba licencia curso online
        System.out.println("\n\n=== Prueba licencia curso online ===\n");
        
        // 1. Crear licencia con constructor
        LicenciaCursoOnline miLicencia = new LicenciaCursoOnline("d.liao.1@estudiantec.cr", "123456789", "Daniel Liao");
        System.out.println("1. Licencia inicializada:");
        System.out.println(miLicencia.toString());
        System.out.println("----------------------------------");
        
        // 1.1 Método activarLicencia
        System.out.println("\n1.1 Probando activarLicencia():");
        boolean activacion = miLicencia.activarLicencia();
        System.out.println("Licencia activada?: " + (activacion ? "Sí" : "No"));
        System.out.println("Estado actual: " + miLicencia.toString());
        System.out.println("----------------------------------");
        
        // 1.2 Probar acceso a diferentes contenidos
        System.out.println("\n1.2 Probando acceso a contenidos:");
        System.out.println("Accediendo a VIDEOS: " + miLicencia.accederContenido(LicenciaCursoOnline.Contenido.VIDEOS));
        System.out.println("Accediendo a EJERCICIOS: " + miLicencia.accederContenido(LicenciaCursoOnline.Contenido.EJERCICIOS));
        System.out.println("Accediendo a FOROS: " + miLicencia.accederContenido(LicenciaCursoOnline.Contenido.FOROS));
        System.out.println("----------------------------------");
        
        // 1.3 Probar método pausar
        System.out.println("\n1.3 Método pausar():");
        miLicencia.pausar();
        System.out.println("Después de pausar - Estado: " + (miLicencia.getEstadoDelEstudiante() ? "Activa" : "Inactiva"));
        System.out.println("Fecha última pausa: " + miLicencia.getFechaUltimaPausa());
        System.out.println("----------------------------------");
        
        // 1.4 Probar método reanudar
        System.out.println("\n1.4 Método reanudar():");
        boolean reanudacion = miLicencia.reanudar();
        System.out.println("¿Reanudación exitosa?: " + (reanudacion ? "Sí" : "No"));
        System.out.println("Estado después de reanudar: " + (miLicencia.getEstadoDelEstudiante() ? "Activa" : "Inactiva"));
        System.out.println("Días acumulados de pausa: " + miLicencia.getPausasDiasAcumuladas());
        System.out.println("----------------------------------");
        
        // 1.5 Probar métodos de información
        System.out.println("\n1.5 Información de la licencia:");
        System.out.println("Fecha de caducidad: " + miLicencia.getFechaCaducidad());
        System.out.println("Días restantes: " + miLicencia.getDiasRestantes());
        System.out.println("Meses de vigencia: " + miLicencia.getMesesVigencia());
        System.out.println("Límite de pausa: " + miLicencia.getPausaMaxDias() + " días");
        System.out.println("----------------------------------");
        
        // 2 Probar con licencia expirada
        System.out.println("\n2 Probando con licencia expirada:");
        // Crear licencia con fecha muy antigua
        LocalDate fechaExpirada = LocalDate.of(2023, 1, 1);
        LicenciaCursoOnline licenciaExpirada = new LicenciaCursoOnline(fechaExpirada, "expirado@ejemplo.com", "expirado1234", "Usuario Expirado");
        System.out.println("Acceso a contenido expirado: " + licenciaExpirada.accederContenido(LicenciaCursoOnline.Contenido.VIDEOS));
        System.out.println("Estado: " + (licenciaExpirada.getEstadoDelEstudiante() ? "Activa" : "Inactiva"));
        System.out.println("Información general de licencia expirada: ");
        System.out.println(licenciaExpirada.toString());
        System.out.println("----------------------------------");
        
        // 3 Mostrar todos los getters
        System.out.println("\n3 Todos los valores de la licencia:");
        System.out.println("Correo: " + miLicencia.getCorreoElectronico());
        System.out.println("Usuario: " + miLicencia.getCuentaDeUsuario());
        System.out.println("Código: " + miLicencia.getCodigoLicencia());
        System.out.println("Costo: $" + miLicencia.getCosto());
        System.out.println("Fecha inscripción: " + miLicencia.getFechaDeInscripcion());
        System.out.println("Tipo contenido: " + miLicencia.getTipoContenido());
        System.out.println("----------------------------------");
        
        // 4 Estado final completo
        System.out.println("\n4 Estado final de la licencia:");
        System.out.println(miLicencia.toString());
    }
}

class CamaraDidactica {

    //Las enumeraciones
    public enum Calidad {
        HD,
        FULLHD,
        CUATRO_K //No permite numeros
    }
    
    public enum ModoBateria {
        NORMAL,
        AHORRO,
        CRITICO
    }

    //Atributos
    private float memoriaDisponible;
    private int bateria;
    private String numeroDeSerie;
    private boolean modoGranAngular;
    private float zoom;
    //Atributos nuevos
    private String modelo;
    private boolean esPrestada;
    private Calidad resolucion;
    private static final int pMinimoReferencial = 5;
    private ModoBateria modoBateria;
    private static final int pMinimoRecarga = 10;
    private int cantidadFotos;

    //Constructores
    public CamaraDidactica(String serie, String modelo, boolean prestada) {
        this.numeroDeSerie = serie;
        this.modelo = modelo;
        this.esPrestada = prestada;
        this.bateria = 100;  // Valor por defecto
        this.resolucion = Calidad.HD;  // Valor por defecto
        this.modoBateria = ModoBateria.NORMAL;  // Valor por defecto
        this.cantidadFotos = 0;
    }
    //Métodos (Getters y Setters)
    private void setMemoriaDisponible(float memoria) { //Privado, solo podrá ser modificado por métodos de la misma clase
        this.memoriaDisponible = memoria;
    }
    public float getMemoriaDisponible() {
        return memoriaDisponible;
    }
    private void setBateria(int bateria) { //Privado y con ajustes 
        if (bateria < 0) {
            this.bateria = 0;
        } else if (bateria > 100) {
            this.bateria = 100;
        } else {
            this.bateria = bateria;
        }
    }
    public int getBateria() {
        return bateria;
    }
    public void setNumeroDeSerie(String serie) {
        this.numeroDeSerie = serie;
    }
    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }
    public void setModoGranAngular(boolean modo) {
        this.modoGranAngular = modo;
    }
    public boolean getModoGranAngular() {
        return modoGranAngular;
    }
    public void setZoom(float zoom) {
        this.zoom = zoom;
    }
    public float getZoom() {
        return zoom;
    }
    //Métodos nuevos agregados (Getters y Setters)
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    public String getModelo(){
        return modelo;
    }
    public void setEsPrestada(boolean prestada){
        this.esPrestada = prestada;
    }
    public boolean getEsPrestada(){
        return esPrestada;
    }
    public void setResolucion(Calidad resolucion){
        this.resolucion = resolucion;
    }
    public Calidad getResolucion(){
        return resolucion;
    }
    public int getPMinimoReferencial(){ //No cuenta con setter pues siento que es irrelevante debido al static final
        return pMinimoReferencial;
    }
    private void setModoBateria(ModoBateria modo){ //Privado
        this.modoBateria = modo;
    }
    public ModoBateria getModoBateria(){ 
        return modoBateria;
    }
    public int getPMinimoRecarga(){ //No cuenta con setter pues siento que es irrelevante debido al static final
        return pMinimoRecarga;
    }
    private void setCantidadFotos(int cantidad){ 
        this.cantidadFotos = cantidad;
    }
    public int getCantidadFotos(){ 
        return cantidadFotos;
    }
    //Métodos adicionales
    public boolean tomarFoto() {
        if (bateria <= 5 || esPrestada != true || modoBateria == ModoBateria.CRITICO) { // || representa un or
            return false;
        } 
        cantidadFotos++;
        registrarConsumoBateria();
        return true;
    }
    //Métodos adicionales nuevos
    public boolean registrarConsumoBateria() {
        if (resolucion == Calidad.HD){
            recargarBateria(-2);
            return true;
        } 
        else if (resolucion == Calidad.FULLHD){
            recargarBateria(-4);
            return true;
        } 
        else if (resolucion == Calidad.CUATRO_K){
            if (bateria >= 7){
                recargarBateria(-7);
                return true;
            }
        }
        return false;
    }
    public void recargarBateria(int valor) {
        setBateria(bateria + valor);
        actualizarModoBateria();
    }
    public void recargarBateria() {
        setBateria(100);
        actualizarModoBateria();
    }
    private void actualizarModoBateria() {  
        if (bateria > pMinimoReferencial) {
            setModoBateria(ModoBateria.NORMAL);
        } 
        else if (bateria == pMinimoReferencial) {
            setModoBateria(ModoBateria.AHORRO);
        } 
        else {
            setModoBateria(ModoBateria.CRITICO);
        }
    }
    @Override
    public String toString(){
        return "Cámara Didáctica" +
               "\n- Número de Serie: " + numeroDeSerie +
               "\n- Modelo: " + modelo +
               "\n- Batería: " + bateria + "%" +
               "\n- Modo de batería: " + modoBateria + 
               "\n- Prestada: " + (esPrestada ? "Sí" : "No") +
               "\n- Resolucion: " + resolucion + 
               "\n- Cantidad de fotos: " + cantidadFotos;
    }
}

class LicenciaCursoOnline {

    public enum Contenido{
        VIDEOS,
        EJERCICIOS,
        FOROS
    }

    //Atributos
    private static final int mesesVigencia = 6;
    private static final int pausaMaxDias = 30;

    private LocalDate fechaDeInscripcion;
    private boolean estadoDelEstudiante;
    private String correoElectronico;
    private String cuentaDeUsuario;
    private int costo = 25;
    //Atributos Nuevos
    private String codigoLicencia;
    private Contenido tipoContenido;
    private static int pausasMaxDiasAcumuladas = 30;
    private int pausasDiasAcumuladas;
    private LocalDate fechaUltimaPausa = null;

    // Primer constructor:
    public LicenciaCursoOnline(String correo, String codigo, String cuenta) {
        this.correoElectronico = correo;
        this.codigoLicencia = codigo;
        this.cuentaDeUsuario = cuenta;
        this.fechaDeInscripcion = LocalDate.now();
        this.estadoDelEstudiante = true;
    }
    // Segundo constructor: Con fecha
    public LicenciaCursoOnline(LocalDate fecha, String correo, String codigo, String cuenta) {
        this.correoElectronico = correo;
        this.codigoLicencia = codigo;
        this.cuentaDeUsuario = cuenta;
        this.fechaDeInscripcion = fecha;
        this.estadoDelEstudiante = true;
    }

    // Métodos (Getters y Setters)
    // El diagrama los muestra con el símbolo '+' que significa 'public'
    private void setFechaDeInscripcion(LocalDate fecha) { //Private
        this.fechaDeInscripcion = fecha;
    }
    public LocalDate getFechaDeInscripcion() {
        return fechaDeInscripcion;
    }
    private void setEstadoDelEstudiante(boolean estado) { //Private
        this.estadoDelEstudiante = estado;
    }
    public boolean getEstadoDelEstudiante() {
        return estadoDelEstudiante;
    }
    public void setCorreoElectronico(String correo) {
        this.correoElectronico = correo;
    }
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCuentaDeUsuario(String nombre) {
        this.cuentaDeUsuario = nombre;
    }
    public String getCuentaDeUsuario() {
        return cuentaDeUsuario;
    }
    private void setCosto(int costo) { //Private
        this.costo = costo;
    }
    public int getCosto() {
        return costo;
    }
    //Metodos Nuevos (Getters y Setters)
    public void setCodigoLicencia(String codigo) {
        this.codigoLicencia = codigo;
    }
    public String getCodigoLicencia() {
        return codigoLicencia;
    }
    public void setTipoContenido(Contenido tipo) {
        this.tipoContenido = tipo;
    }
    public Contenido getTipoContenido() {
        return tipoContenido;
    }
    public int getMesesVigencia(){ //No cuenta con setter pues siento que es irrelevante debido al static final
        return mesesVigencia;
    }
    public int getPausaMaxDias(){ //No cuenta con setter pues siento que es irrelevante debido al static final
        return pausaMaxDias;
    }
    private void setPausasMaxDiasAcumuladas(int dias){
        this.pausasMaxDiasAcumuladas = dias;
    }
    public int getPausasMaxDiasAcomuladas() {
        return pausasMaxDiasAcumuladas;
    }
    private void setPausasDiasAcumuladas(int dias){
        this.pausasDiasAcumuladas = dias;
    }
    public int getPausasDiasAcumuladas() {
        return pausasDiasAcumuladas;
    }
    private void setFechaUltimaPausa(LocalDate fecha){
        this.fechaUltimaPausa = fecha;
    }
    public LocalDate getFechaUltimaPausa() {
        return fechaUltimaPausa;
    }
    // Métodos adicionales
    public boolean activarLicencia() {
        if (fechaDeInscripcion != null) {
            LocalDate fechaExpiracionCalculada = fechaDeInscripcion.plusMonths(mesesVigencia);
            
            if (LocalDate.now().isBefore(fechaExpiracionCalculada) || 
                LocalDate.now().isEqual(fechaExpiracionCalculada)) {
                this.estadoDelEstudiante = true;
                return true;
            }
        }
        return false;
    }
    public String accederContenido(Contenido tipo){
        // Verificar si la licencia está activa
        if (estadoDelEstudiante == false) {
            return "La licencia no está activa";
        }
        // Verificar si no está expirada
        LocalDate fechaExpiracion = getFechaCaducidad();
        if (LocalDate.now().isAfter(fechaExpiracion)) {
            this.estadoDelEstudiante = false;
            return "La licencia ha expirado.";
        }
        // Acceso permitido
        this.tipoContenido = tipo;
        return "Usted ha accedido al contenido " + getTipoContenido();
    }
    public LocalDate getFechaCaducidad() {
        if (fechaDeInscripcion != null) {
            return fechaDeInscripcion.plusMonths(mesesVigencia);
        }
        return null;
    }
    public void pausar(){
         if (pausasDiasAcumuladas < pausaMaxDias) {
            this.estadoDelEstudiante = false;
            this.fechaUltimaPausa = LocalDate.now();
        }
    }
    public boolean reanudar(){
        if (fechaUltimaPausa == null || estadoDelEstudiante == true) {
            return false;
        }
        // Calcular días transcurridos desde la última pausa
        int diasPausa = Period.between(fechaUltimaPausa, LocalDate.now()).getDays();
        // Verificar si no excede el tiempo máximo permitido para pausa
        if (diasPausa > pausaMaxDias) {
            this.estadoDelEstudiante = false; // Se expira automáticamente
            return false;
        }
        // Verificar si la licencia no ha expirado
        if (LocalDate.now().isAfter(getFechaCaducidad())) {
            this.estadoDelEstudiante = false; // Se expira automáticamente
            return false;
        }
        // Reanudar exitosamente
        this.estadoDelEstudiante = true;
        this.pausasDiasAcumuladas += (int) diasPausa; // Acumular días de pausa
        this.fechaUltimaPausa = null;
        return true;
    }
    public int getDiasRestantes() {
        LocalDate fechaCaducidad = getFechaCaducidad();
        if (fechaDeInscripcion == null || fechaCaducidad == null) {
            return 0;
        }
        // Si ya expiró, retorna 0
        if (LocalDate.now().isAfter(fechaCaducidad)) {
            return 0;
        }
        // Calcular días restantes
        return Period.between(LocalDate.now(), fechaCaducidad).getDays();
    }
    @Override
    public String toString(){
        return "Licencia curso online" +
               "\n- Correo: " + correoElectronico +
               "\n- Usuario: " + cuentaDeUsuario +
               "\n- Fecha de inscripción: " + fechaDeInscripcion +
               "\n- Estado: " + (estadoDelEstudiante ? "Activa" : "Inactiva") +
               "\n- Días acumulados de pausa: " + pausasDiasAcumuladas +
               "\n- Días restantes: " + getDiasRestantes() +
               "\n- Fecha caducidad: " + getFechaCaducidad() +
               "\n- Ultima pausa: " + fechaUltimaPausa;
    }
}