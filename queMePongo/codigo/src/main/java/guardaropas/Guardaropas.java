package codigo.src.main.java.guardaropas;
import codigo.src.main.java.usuario.Usuario;
import guardaropas.Atuendo;

import prenda.Prenda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guardaropas {
  private List<Prenda> prendas;
  private Usuario propietario;

  private List<PropuestaModificacion> propuestas;

  private

  public Guardaropas(Usuario propietario){
    prendas = new ArrayList<>();
    propuestas = new ArrayList<>();
    this.propietario = propietario;
  }

  public void agregarPrenda(Prenda prenda){
    prendas.add(prenda);
  }

  public void quitarPrenda(Prenda prenda){
    prendas.remove(prenda);
  }

  public List<PropuestaModificacion> propuestasPendientes(){
    this.propuestas.stream().filter(propuesta -> propuesta.getEstado() == Estado.PENDIENTE).collect(Collectors.toList());
  }

  public List<Atuendo> combinacionesPosibles(){
    // TODO: Algoritmo para obtener todas las combinaciones de atuendos posibles. Un atuendo tiene que estar compuesto de prendas de las 4 categorias.
    return null;
  }
}
