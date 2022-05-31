package asesorDeImagen;

import guardaropas.Atuendo;
import guardaropas.Guardaropas;
import servicioMeteorologico.ServicioMeteorologico;

import java.util.List;
import java.util.stream.Collectors;

public class AsesorDeImagen {
  private ServicioMeteorologico servicioMeteorologico;

  public AsesorDeImagen(ServicioMeteorologico servicioMeteorologico){
    this.servicioMeteorologico = servicioMeteorologico;
  }

  public Atuendo sugerirAtuendo(String lugar, Guardaropas guardaropas){
    int temperatura = this.servicioMeteorologico.obtenerTemperatura(lugar);
    List<Atuendo> combinaciones = guardaropas.combinacionesPosibles();
    return combinaciones.stream().filter(atuendo -> atuendo.aptoParaTemperatura(temperatura)).collect(Collectors.toList()).get(0);
  }
}
