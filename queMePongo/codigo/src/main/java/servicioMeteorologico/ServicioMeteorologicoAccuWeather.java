package servicioMeteorologico;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.HashMap;
import java.util.Map;

public class ServicioMeteorologicoAccuWeather implements ServicioMeteorologico{
  private Map<String, RespuestaMeteorologica> ultimasRespuestas;
  private TemporalAmount tiempoDeValidez;

  public ServicioMeteorologicoAccuWeather(TemporalAmount periodoDeValidez) {
    this.tiempoDeValidez = periodoDeValidez;
    this.ultimasRespuestas = new HashMap<String, RespuestaMeteorologica>();
  }

  @Override
  public int obtenerTemperatura(String lugar) {
    if (!this.ultimasRespuestas.containsKey(lugar) || this.ultimasRespuestas.get(lugar).expiro()) {
      ultimasRespuestas.put(lugar, new RespuestaMeteorologica(this.consultarApi(lugar), this.proximaExpiracion()));
    }
    return this.ultimasRespuestas.get(lugar).getTemperatura();
  }

  private int consultarApi(String lugar){
    Map<String, Object> respuesta = AccuWeatherAPI.instance().getWeather(lugar).get(0);
    return (int) respuesta.get("Temperature");
  }

  private LocalDateTime proximaExpiracion(){
    return LocalDateTime.now().plus(this.tiempoDeValidez);
  }
}
