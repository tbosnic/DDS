package guardaropas;

import prenda.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Guardaropas {
  private List<Prenda> prendas;
  private static final Guardaropas INSTANCE = new Guardaropas();

  public static Guardaropas instance(){
    return INSTANCE;
  }

  private Guardaropas(){
    prendas = new ArrayList<Prenda>();
  }

  public void agregarPrenda(Prenda prenda){
    prendas.add(prenda);
  }

  public List<Atuendo> combinacionesPosibles(){
    // TODO: Algoritmo para obtener todas las combinaciones de atuendos posibles. Un atuendo tiene que estar compuesto de prendas de las 4 categorias.
    return null;
  }
}
