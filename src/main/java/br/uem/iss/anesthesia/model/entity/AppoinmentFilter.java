package br.uem.iss.anesthesia.model.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public class AppoinmentFilter  {
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
}
