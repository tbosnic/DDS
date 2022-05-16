package prenda;

import static java.util.Objects.requireNonNull;

public class Color {
  private int rojo, azul, verde;

  Color(int rojo, int azul, int verde){
    this.rojo = requireNonNull(rojo, "Debe especificar la intensidad del color rojo");
    this.azul = requireNonNull(azul, "Debe especificar la intensidad del color azul");
    this.verde = requireNonNull(verde, "Debe especificar la intensidad del color verde");
  }

  public int getIntensidadRojo(){
    return rojo;
  }

  public int getIntensidadAzul(){
    return azul;
  }

  public int getIntensidadVerde(){
    return verde;
  }
}
