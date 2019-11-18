package br.uem.iss.anesthesia.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Process")
public class ProcessModel extends DefaultModel {


    @OneToMany(cascade = CascadeType.PERSIST)
    private List<ProcessExamsModel> procesexams;
    private boolean active = true;
    private LocalDate inicialDate;

    public LocalDate getInicialDate() {
        return inicialDate;
    }

    public void setInicialDate(LocalDate inicialDate) {
        this.inicialDate = inicialDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void inactivate() {
        active = false;
    }

    public List<ProcessExamsModel> getProcesexams() {
        return procesexams;
    }

    public void setProcesexams(List<ProcessExamsModel> procesexams) {
        this.procesexams = procesexams;
    }

    public ProcessModel() {
    }
    public ProcessModel(Long id) {
        this.setId(id);
    }
}
