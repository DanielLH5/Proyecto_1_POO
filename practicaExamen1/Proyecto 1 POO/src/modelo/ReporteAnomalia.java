package modelo;

import java.time.LocalDateTime;

public class ReporteAnomalia {
    private Evento evento;
    private LocalDateTime fechaHora;
    private String idDron;
    private Accion accionEjecutada;

    public ReporteAnomalia(Evento evento, LocalDateTime fechaHora, String idDron) {
        this.evento = evento;
        this.fechaHora = fechaHora;
        this.idDron = idDron;
    }

    // Getters y Setters
    public Evento getEvento() {
        return evento;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getIdDron() {
        return idDron;
    }

    public Accion getAccionEjecutada() {
        return accionEjecutada;
    }

    public void setAccionEjecutada(Accion accionEjecutada) {
        this.accionEjecutada = accionEjecutada;
    }

    @Override
    public String toString() {
        return "ReporteAnomalia{" +
                "evento=" + evento +
                ", fechaHora=" + fechaHora +
                ", idDron='" + idDron + '\'' +
                ", accionEjecutada=" + accionEjecutada +
                '}';
    }
}