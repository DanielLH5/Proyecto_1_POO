import java.time.LocalDate; //Necesario para el date 

public class DanielLiao_PrimerosObjetos{
    public static void main(String[] args) {
        
        // Creamos una nueva cámara con un número de serie
        CamaraDidactica miCamara = new CamaraDidactica("Sonny123");
        
        // Asignamos valores a los atributos usando los setters
        miCamara.setMemoriaDisponible(512.0f); //(Privado)
        miCamara.setBateria(100); //(Privado)
        miCamara.setModoGranAngular(false);
        miCamara.setZoom(0.0f);
        
        // Mostramos la información de la cámara usando los getters
        System.out.println("--- Información de la cámara ---");
        System.out.println("Número de Serie: " + miCamara.getNumeroDeSerie());
        System.out.println("Batería restante: " + miCamara.getBateria() + "%");
        System.out.println("Modo gran angular: " + miCamara.getModoGranAngular());
        
        // Llamamos al método adicional
        miCamara.tomarFotografia();
        System.out.println("\n"); // Para dejar un espacio en la salida

        
        // Creamos un objeto de licencia usando el constructor con parámetros
        LocalDate fechaHoy = LocalDate.now();
        LicenciaCursoOnline miLicencia = new LicenciaCursoOnline(fechaHoy, "d.liao.1@estudiantec.cr", "Daniel Liao");
        
        // Asignamos el costo usando el setter
        miLicencia.setCosto(25); //(Privado)
        
        // Mostramos la información de la licencia
        System.out.println("--- Información de la licencia ---");
        System.out.println("Cuenta de Usuario: " + miLicencia.getCuentaDeUsuario());
        System.out.println("Fecha de Inscripción: " + miLicencia.getFechaDeInscripcion());
        System.out.println("Costo: $" + miLicencia.getCosto());
        System.out.println("Estado del estudiante: " + miLicencia.getEstadoDelEstudiante());
    }
}

class CamaraDidactica {

    //Atributos
    private float memoriaDisponible;
    private int bateria;
    private String numeroDeSerie;
    private boolean modoGranAngular;
    private float zoom;

    //Constructor
    public CamaraDidactica(String serie) {
        this.numeroDeSerie = serie;
    }
    //Métodos (Getters y Setters)
    public void setMemoriaDisponible(float memoria) {
        this.memoriaDisponible = memoria;
    }
    public float getMemoriaDisponible() {
        return memoriaDisponible;
    }
    public void setBateria(int bateria) {
        this.bateria = bateria;
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
    //Métodos adicionales
    public void tomarFotografia() {
    }
}

class LicenciaCursoOnline {

    // Atributos de la clase
    private LocalDate fechaDeInscripcion;
    private boolean estadoDelEstudiante;
    private String correoElectronico;
    private String cuentaDeUsuario;
    private int costo;

    // Primer constructor: Constructor por defecto (sin parámetros)
    public LicenciaCursoOnline() {
        // Puedes inicializar atributos con valores por defecto si lo deseas
        this.estadoDelEstudiante = true; // Por ejemplo, el estudiante está activo por defecto
    }
    // Segundo constructor: Inicializa el objeto con valores específicos
    public LicenciaCursoOnline(LocalDate fecha, String correo, String cuenta) {
        this.fechaDeInscripcion = fecha;
        this.correoElectronico = correo;
        this.cuentaDeUsuario = cuenta;
        // Los demás atributos se pueden inicializar aquí o dejarlos con sus valores por defecto
    }

    // Métodos (Getters y Setters)
    // El diagrama los muestra con el símbolo '+' que significa 'public'
    public void setFechaDeInscripcion(LocalDate fecha) {
        this.fechaDeInscripcion = fecha;
    }
    public LocalDate getFechaDeInscripcion() {
        return fechaDeInscripcion;
    }
    public void setEstadoDelEstudiante(boolean estado) {
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
    public void setCosto(int costo) {
        this.costo = costo;
    }
    public int getCosto() {
        return costo;
    }

    // Métodos adicionales
    public void renovarSubscripcion() {
    }
    public LocalDate getFechaCaducidad() {
        return null; // Devuelve null si no hay fecha calculada
    }
}