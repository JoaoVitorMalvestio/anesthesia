package br.uem.iss.anesthesia.controller.request;

import br.uem.iss.anesthesia.model.entity.DoctorModel;
import br.uem.iss.anesthesia.model.entity.PatientModel;

import java.time.LocalDate;

public class DoctorReportRequest {

    private DoctorModel doctor;
    private LocalDate initial;
    private LocalDate end;

    public LocalDate getInitial() {
        return initial;
    }

    public void setInitial(LocalDate initial) {
        this.initial = initial;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public DoctorModel getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorModel doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "DoctorReportRequest{" +
                "doctor=" + doctor +
                ", initial=" + initial +
                ", end=" + end +
                '}';
    }
}
