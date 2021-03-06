package controledemilhagem;

import java.io.*;
import java.util.*;
import java.text.*;

public class Voocliente implements Serializable{
    private int codVooCli;
    private int codVoo;
    private int data;
    private int hora;

    public int getCodVooCli() {
        return codVooCli;
    }

    public void setCodVooCli(int codCli) {
        this.codVooCli = codCli;
    }

    public int getCodVoo() {
        return codVoo;
    }

    public void setCodVoo(int codVoo) {
        this.codVoo = codVoo;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public Voocliente(int codVooCli, int codVoo, int data, int hora) {
        setCodVooCli(codVooCli);
        setCodVoo(codVoo);
        setData(data);
        setHora(hora);
    }

}
