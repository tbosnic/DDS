package guardaropas;

import prenda.Prenda;

public class Atuendo {
  private Prenda parteSuperior;
  private Prenda parteInferior;
  private Prenda calzado;
  private Prenda accesorio;

  public Atuendo(Prenda parteSuperior, Prenda parteInferior, Prenda calzado, Prenda accesorio){
    this.parteSuperior = parteSuperior;
    this.parteInferior = parteInferior;
    this.calzado = calzado;
    this.accesorio = accesorio;
  }

  public boolean aptoParaTemperatura(int temperatura){
    return parteSuperior.esAptaParaTemperatura(temperatura) &&
        parteInferior.esAptaParaTemperatura(temperatura) &&
        calzado.esAptaParaTemperatura(temperatura) &&
        accesorio.esAptaParaTemperatura(temperatura);
  }
}
