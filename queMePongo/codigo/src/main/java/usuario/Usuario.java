package codigo.src.main.java.usuario;
import guardaropas.Guardaropas;

import java.security.Guard;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
  List<Guardaropas> listaDeGuardaropas;

  public Usuario(){
    listaDeGuardaropas = new ArrayList<Guardaropas>();
  }

  public void agregarGuardaropas(Guardaropas nuevoGuardaropas){
    this.listaDeGuardaropas.add(nuevoGuardaropas);
  }

  public void sacarGuardaropas(Guardaropas guardaropas){
    this.listaDeGuardaropas.remove(guardaropas);
  }
}
