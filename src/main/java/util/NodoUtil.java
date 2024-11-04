package util;

public class NodoUtil <T> {
    private NodoUtil<T> siguienteNodo;
    private T valorNodo;


    /**
     * Constructor de la clase Nodo
     * @param valorNodo Elemento que se guarda en el Nodo
     */
    public NodoUtil(T valorNodo) {
        this.valorNodo = valorNodo;
    }


    /**
     * Constructor de la clase Nodo
     * @param dato Elemento que se guarda en el Nodo
     * @param siguiente Enlace al siguiente Nodo
     */
    public NodoUtil(T dato, NodoUtil<T> siguiente) {
        super();
        this.valorNodo = dato;
        this.siguienteNodo = siguiente;
    }


    //Metodos get y set de la clase Nodo

    public NodoUtil<T> getSiguienteNodo() {
        return siguienteNodo;
    }


    public void setSiguienteNodo(NodoUtil<T> siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }


    public T getValorNodo() {
        return valorNodo;
    }


    public void setValorNodo(T valorNodo) {
        this.valorNodo = valorNodo;
    }
}
