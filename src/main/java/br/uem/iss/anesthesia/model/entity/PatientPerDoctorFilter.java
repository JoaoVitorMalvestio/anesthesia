package br.uem.iss.anesthesia.model.entity;

public class PatientPerDoctorFilter {
    private DoctorModel doctor;
    private String Initial;
    private String End;

    public String getInitial() {
        return Initial;
    } //ProcessModel

    public void setInitial(String initial) {
        Initial = initial;
    }

    public String getEnd() {
        return End;
    }

    public void setEnd(String end) {
        End = end;
    }

    public DoctorModel getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorModel doctor) {
        this.doctor = doctor;
    }
}
