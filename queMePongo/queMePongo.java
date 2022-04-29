class Borrador{
    TipoPrenda tipoPrenda;
    Material material;
    Color colorPrincipal;
    Color colorSecundario;
    Trama trama = Trama.LISA;

    Borrador(TipoPrenda tipoPrenda){

        // VALIDAR QUE NO SEA NULO

        this.tipoPrenda = tipoPrenda;
    }

    public void especificarColorPrincipal(Color color){
        this.colorPrincipal = color;
    }

    public void especificarColorSecundario(Color color){
        this.colorSecundario = color;
    }

    public void especificarMaterial(Material material){
        this.material = material;
    }

    public void especificarTrama(Trama trama){
        this.trama = trama;
    }

    public Prenda crearPrenda(){

        // VALIDAR QUE NINGUN ATRIBUTO SEA NULL (menos color secundario), CASO CONTARIO, LANZAR EXCEPCION

        return new Prenda(tipoPrenda, material, colorPrincipal, colorSecundario, trama);
    }
}

class Prenda{
    TipoPrenda tipoPrenda;
    Material material;
    Color colorPrincipal;
    Color colorSecundario;
    Trama trama;
    
    Prenda(TipoPrenda tipoPrenda, Material material, Color colorPrincipal, Color colorSecundario, Trama trama){
        this.tipoPrenda = tipoPrenda;
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = colorSecundario;
        this.trama = trama;
    }

    Categoria categoria(){
        return tipoPrenda.getCategoria();
    }
}

enum Material{
    ALGODON,
    JEAN,
    PLASTICO,
    LAYCRA,
    CUERO
}
class Color{
    int rojo, azul, verde;

    Color(int rojo, int azul, int verde){
        this.rojo = rojo;
        this.azul = azul;
        this.verde = verde;
    }
}

class TipoPrenda{

    Categoria categoria;

    TipoPrenda(Categoria categoria){

        // VALIDAR QUE LA CATEGORIA ES VALIDA PARA EL TIPO DE PRENDA, CASO CONTARIO, LANZAR EXCEPCION

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