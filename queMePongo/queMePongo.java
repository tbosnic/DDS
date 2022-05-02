import static java.util.Objects.requireNonNull;

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

        // VALIDAR QUE NINGUN ATRIBUTO SEA NULL (menos color secundario), CASO CONTARIO, LANZAR EXCEPCION
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
    ZAPATOS(Categoria.CALZADO),
    CAMISA_MANGAS_CORTAS(Categoria.PARTE_SUPERIOR),
    PANTALON(Categoria.PARTE_INFERIOR);

    private Categoria categoria;

    private TipoPrenda(Categoria categoria){
        this.categoria = categoria;
    }

    public Categoria getCategoria(){
        return categoria;
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