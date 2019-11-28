package br.uem.iss.anesthesia.model.entity;

public class AdvanceFilter {
    private String Initial;
    private String End;
    private String periodo;

    public String getInitial() {
        return Initial;
    }

    public void setInitial(String initial) {
        Initial = initial;
    }

    public String getEnd() {
        return End;
    }

    public void setEnd(String end) {
        End = end;
    }
    public String getPeriodo() {
        return periodo;
    }
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
