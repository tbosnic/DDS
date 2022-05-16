import static java.util.Objects.requireNonNull;

// PATRON BUILDER -> USO UNA CLASE PARA CONFIGURAR LA CLASE FINAL QUE QUIERO CREAR. ME PERMITE HACERLO POR ETAPAS, TENER UNA REPRESENTACION MUTABLE DE UN OBJETO NO MUTABLE,
//                   DELEGAR LAS VALIDACIONES, TENER VALORES DE ATRIBUTOS POR DEFECTO.

class Borrador{
    private TipoPrenda tipoPrenda;
    private Material material;
    private Color colorPrincipal;
    private Color colorSecundario;
    private Trama trama = Trama.LISA;

    public Borrador setTipoPrenda(TipoPrenda tipoPrenda){
        this.tipoPrenda = tipoPrenda;
        return this;
    }

    public Borrador setMaterial(Material material){
        this.material = material;
        return this;
    }

    public Borrador setColorPrincipal(Color color){
        this.colorPrincipal = color;
        return this;
    }

    public Borrador setColorSecundario(Color color){
        this.colorSecundario = color;
        return this;
    }

    public Borrador setTrama(Trama trama){
        this.trama = trama;
        return this;
    }

    public Prenda crearPrenda(){

        requireNonNull(tipoPrenda, "Debe especificar el tipo de prenda");
        requireNonNull(material, "Debe especificar el material");
        requireNonNull(colorPrincipal, "Debe especificar el color principal");

        // OTRA MANERA DE HACERLO ES CREAR UNA FUNCION validarParametros(tipoPrenda, material, colorPrincipal) (*)

        return new Prenda(tipoPrenda, material, colorPrincipal, colorSecundario, trama);
    }

// (*) private void validarParametros(TipoPrenda tipoPrenda, Material material, Color colorPrincipal){
//          if(tipoPrenda == null){
//              throw new PrendaInvalidaException("debe especificar el tipo de prenda");
//           }
//          if(material == null){
//              throw new PrendaInvalidaException("debe especificar el material");
//           }
//          if(colorPrincipal == null){
//              throw new PrendaInvalidaException("debe especificar el color principal");
//           }
//      }
}

// public PrendaInvalidaException extends RuntimeException{
//      public PrendaInvalidaException(String causa){
//          super("La prenda es invalida porque: " + causa);
//      }   
// }

class Prenda{
    private TipoPrenda tipoPrenda;
    private Material material;
    private Color colorPrincipal;
    private Color colorSecundario;
    private Trama trama;
    
    Prenda(TipoPrenda tipoPrenda, Material material, Color colorPrincipal, Color colorSecundario, Trama trama){
        this.tipoPrenda = tipoPrenda;
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = colorSecundario;
        this.trama = trama;
    }

    public Categoria categoria(){
        return tipoPrenda.getCategoria();
    }

    public boolean esAptaParaTemperatura(int temperatura){
        return tipoPrenda.esAptaParaTemperatura(temperatura);
    }
}

enum Material{
    ALGODON,
    JEAN,
    PLASTICO,
    LAYCRA,
    CUERO;
}

class Color{
    private int rojo, azul, verde;

    Color(int rojo, int azul, int verde){
        this.rojo = requireNonNull(rojo, "Debe especificar la intensidad del color rojo");
        this.azul = requireNonNull(azul, "Debe especificar la intensidad del color azul");
        this.verde = requireNonNull(verde, "Debe especificar la intensidad del color verde");
    }
}

enum TipoPrenda{
    ZAPATOS(Categoria.CALZADO, 25),
    CAMISA_MANGAS_CORTAS(Categoria.PARTE_SUPERIOR, 35),
    PANTALON(Categoria.PARTE_INFERIOR, 20),
    REMERA_MANGAS_LARGAS(Categoria.PARTE_SUPERIOR, 20);

    private Categoria categoria;
    private int temperaturaMaximaOptima;

    private TipoPrenda(Categoria categoria, int temperaturaMaximaOptima){
        this.categoria = categoria;
        this.temperaturaMaximaOptima = temperaturaMaximaOptima;
    }

    public Categoria getCategoria(){
        return categoria;
    }

    public boolean esAptaParaTemperatura(int temperatura){
        return temperaturaMaximaOptima > temperatura;
    }
}

enum Categoria{
    PARTE_SUPERIOR, 
    CALZADO, 
    PARTE_INFERIOR, 
    ACCESORIOS;
}

enum Trama{
    LISA,
    RAYADA,
    LUNARES,
    CUADROS,
    ESTAMPADO;
}

interface ServicioMeteorologico{
    int obtenerTemperatura(String lugar);
}

class ServicioMeteorologicoAccuWeather implements ServicioMeteorologico{
    private Map<String, Object> ultimasRespuestas;
    private AccuWeatherAPI api;
    private int tiempoDeValidez;

    // TODO: Constructor
    public int obtenerTemperatura(String lugar){
        if (!this.ultimasRespuestas.contains(lugar) || this.ultimasRespuestas.get(lugar).expiro()) {
            ultimasRespuestas.put(lugar, new RespuestaMeteorologica(this.consultarApi(lugar), this.proximaExpiracion()));
        }
        return this.ultimasRespuestas.get(lugar).getTemperatura();
    }

    private LocalDateTime proximaExpiracion() {
        return LocalDateTime.now().plus(this.tiempoDeValidez);
    }

    private Map<String, Object> consultarApi(String lugar) {
        return this.api.getWeather(lugar).get(0).get("Temperature");
    }
}

public class RespuestaMeteorologica {
    private LocalDateTime expiracion;
    private int temperatura;

    // TODO: Constructor.

    public boolean expiro() {
        return this.expiracion.isAfter(LocalDateTime.now);
    }

    public int getTemperatura(){
        return temperatura;
    }
}


class AsesorDeImagen{
    private ServicioMeteorologico servicioMeteorologico;

    // TODO: Constructor y validaciones.

    public Atuendo sugerirAtuendo(String lugar){
        int temperatura = this.servicioMeteorologico.obtenerTemperatura(lugar);
        // TODO: llamar al singleton guardaropas y que devuelva todas las posibles combinaciones que existen.

        return combinaciones.filter(atuendo -> atuendo.aptoParaTemperatura(temperatura)).first();
    }
}

class GuardaRopas{
    private List<Prenda> prendas;
    // TODO: Constructor y validaciones. Debe ser un singleton.

    // TODO: Cada vez que se crea una prenda, se agrega a la lista.

    // TODO: Metodo para generar una lista con todos los atuendos posibles y devolverlos.
}

class Atuendo{
    private Prenda parteSuperior;
    private Prenda parteInferior;
    private Prenda calzado;
    private Prenda accesorio;

    // TODO: Constructor y validaciones.

    public boolean aptoParaTemperatura(int temperatura){
        return parteSuperior.esAptaParaTemperatura(temperatura) &&
        parteInferior.esAptaParaTemperatura(temperatura) &&
        calzado.esAptaParaTemperatura(temperatura) &&
        accesorio.esAptaParaTemperatura(temperatura);
    }
}