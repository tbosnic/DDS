class Prenda{
    TipoPrenda tipoPrenda;
    Material material;
    Color colorPrincipal;
    Color colorSecundario;

    Prenda(TipoPrenda tipoPrenda, Material material, Color colorPrincipal, Color colorSecundario){

        //VALIDAR QUE SE PASAN TODOS LOS PARAMETROS (no validar el color secundario), CASO CONTARIO, LANZAR EXCEPCION

        this.tipoPrenda = tipoPrenda;
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = colorSecundario;
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

abstract class TipoPrenda{
    Categoria categoria;

    TipoPrenda(Categoria categoria){
        if(!this.esCategoriaValida(categoria)){
            // LANZAR EXCEPCION
        }
        this.categoria = categoria;
    }

    Categoria getCategoria(){
        return categoria;
    }

    abstract boolean esCategoriaValida(Categoria categoria);
}

class Zapatos extends TipoPrenda{

    Zapatos(Categoria categoria){
        super(categoria);
    }

    boolean esCategoriaValida(Categoria categoria){
        if (categoria != Categoria.CALZADO){
            return false;
        }
        else{
            return true;
        }
    }
}

class CamisaMangasCortas extends TipoPrenda{

    CamisaMangasCortas(Categoria categoria){
        super(categoria);
    }

    boolean esCategoriaValida(Categoria categoria){
        if (categoria != Categoria.PARTE_SUPERIOR){
            return false;
        }
        else{
            return true;
        }
    }
}

class Pantalon extends TipoPrenda{

    Pantalon(Categoria categoria){
        super(categoria);
    }

    boolean esCategoriaValida(Categoria categoria){
        if (categoria != Categoria.PARTE_INFERIOR){
            return false;
        }
        else{
            return true;
        }
    }
}

enum Categoria{
    PARTE_SUPERIOR, 
    CALZADO, 
    PARTE_INFERIOR, 
    ACCESORIOS;
}