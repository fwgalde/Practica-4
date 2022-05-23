import java.util.LinkedList;
import java.util.Queue;

class NodoArbol {

    private NodoArbol nodoIzq;
    private int datos;
    private NodoArbol nodoDer;

    public NodoArbol(int datosNodo) {
        datos = datosNodo;
        nodoIzq = nodoDer = null;
    }

    public void insertar(int valorInsertar) {
        if(valorInsertar < datos) {
            if(nodoIzq==null) {
                nodoIzq = new NodoArbol(valorInsertar);
            } else {
                nodoIzq.insertar(valorInsertar);
            }
        } else if(valorInsertar > datos) {
            if(nodoDer==null) {
                nodoDer = new NodoArbol(valorInsertar);
            } else {
                nodoDer.insertar(valorInsertar);
            }

        }
    }

    public NodoArbol getNodoIzq() {
	return nodoIzq;
    }

    public NodoArbol getNodoDer() {
	return nodoDer;
    }

    public int getDato() {
	return datos;
    }
}

public class Arbol {

    private NodoArbol raiz;

    /**
     *	Método constructor de árbol.
     */
    public Arbol() {
        raiz = null;
    }

    public void insertarNodo(int valorInsertar) {

        if(raiz==null) {
            raiz = new NodoArbol(valorInsertar);
        } else {
            raiz.insertar(valorInsertar);
        }
    }

    public void preorden() {
        recorrePreorden(raiz);
    }

    public void recorrePreorden(NodoArbol nodo) {
        if (nodo==null) {
            return;
        }
        System.out.print(nodo.getDato() + " ");
        recorrePreorden(nodo.getNodoIzq());
        recorrePreorden(nodo.getNodoDer());
    }

    /**
     * Método que implementa el recorrido inorden.
     */
    public void Inorden(){
        recorreInorden(raiz);
    }


    public void recorreInorden(NodoArbol nodo) {
        if (nodo==null) {
            return;
        }
        recorreInorden(nodo.getNodoIzq());
        System.out.print(nodo.getDato() + " ");
        recorreInorden(nodo.getNodoDer());
    }

    public void Postorden(){
        recorrePostorden(raiz);
    }

    public void recorrePostorden(NodoArbol nodo) {
        if (nodo==null) {
            return;
        }
        recorrePostorden(nodo.getNodoIzq());
        recorrePostorden(nodo.getNodoDer());
        System.out.print(nodo.getDato() + " ");
    }


    public void nivel(NodoArbol raiz) {
    	if(raiz == null)
    		return;
    	Queue<NodoArbol> cola = new LinkedList<>();
    	cola.add(raiz);
    	cola.add(null);

    	while(!cola.isEmpty()) {
	    NodoArbol actual = cola.remove();

	    if(actual == null) {
		System.out.println();
		if(cola.isEmpty()) {
		    break;
		} else {
		    cola.add(null);
		}
	    } else {
		System.out.print(actual.getDato() + " ");
		if(actual.getNodoIzq() != null) {
		    cola.add(actual.getNodoIzq());
		}
		if(actual.getNodoDer() != null) {
		    cola.add(actual.getNodoDer());
		}
	    }
    	}
    }

    /**
     * Método que devuelve si un valor está contenido en el árbol.
     * @param dato Valor del nodo que se busca.
     * @return true si está en el árbol, false en otro caso.
     */
    public boolean contiene(int dato){
	return contiene(raiz, dato);
    }

    /**
     * Método auxiliar recursivo que revisa si un valor está contenido en el árbol.
     * @param dato Dato que se busca del árbol.
     * @param raiz Raíz del árbol del cual queremos conocer si tiene el dato.
     * @return True en caso de que lo encuentre False en otro caso.
     */
    protected boolean contiene(NodoArbol raiz, int dato) {
    	boolean b = false;
    	if (raiz == null)
    		return b;
    	if(raiz.getDato() == dato)
    		b = true;
    	else if(dato < raiz.getDato())
	    b = contiene(raiz.getNodoIzq(), dato);
    	else
	    b = contiene(raiz.getNodoDer(), dato);
    	return b;
    }

    protected boolean contieneNodo(NodoArbol raiz, NodoArbol n) {
    	boolean b = false;
    	if(raiz == null)
    		return b;
    	if(raiz == n)
    		b = true;
    	else if(contieneNodo(raiz.getNodoDer(), n) || contieneNodo(raiz.getNodoIzq(),n))
    		b = true;
    	return b;
    }

    /**
     * Método que devuelve el nodo de un valor dado.
     * @param dato Valor del nodo a buscar.
     * @return Primer nodo que contenga el valor buscado.
     */
    public NodoArbol busca(int dato){
	return busca(raiz, dato);
    }

    /**
     * Método auxiliar recursivo que devuelve el nodo de un valor dado.
     * @param raiz Raíz del árbol binario.
     * @param dato Valor del nodo a buscar.
     * @return Primer nodo que contenga el valor buscado.
     */
    protected NodoArbol busca(NodoArbol raiz, int dato) {
    	if(!contiene(dato))
    		return null;
    	else if(raiz.getDato() == dato)
    		return raiz;
    	else if(dato < raiz.getDato())
	    return busca(raiz.getNodoIzq(), dato);
    	else
	    return busca(raiz.getNodoDer(), dato);
    }

    /**
     * Método que devuelve el camino de la raíz a un nodo en específico.
     * @param dato Valor del nodo que buscamos.
     */
    public void busquedaSeguimiento(int dato) {
    	if(!contiene(dato)) {
	    System.out.println("Nodo no encontrado");
    	} else {
	    ruta(raiz, dato);
	    System.out.println();
	}
    }

    /**
     * Método auxiliar de busquedaSeguimiento. Encuentra la ruta para llegar de la raíz al nodo que buscamos.
     * @param raiz Raíz del árbol binario.
     * @param dato Valor del nodo que buscamos.
     */
    public void ruta(NodoArbol raiz, int dato) {
	if(dato < raiz.getDato()) {
    		System.out.print("L");
    		ruta(raiz.getNodoIzq(),dato);
    	} else {
    		System.out.print("D");
    		ruta(raiz.getNodoDer(), dato);
    	}
    }

    /**
     * Método que devuleve el número de descendientes de un nodo de un árbol.
     * @param dato El valor del nodo.
     * @return El número de descendientes del nodo.
     */
    public int getNumeroDescendientes(int dato) {
    	if(!contiene(dato)) {
    		return -1;
    	}
    	NodoArbol padre = busca(dato);
    	int descendientes = cuentaHijos(padre);
    	return descendientes;
    }

    /**
     * Método auxiliar de getNumeroDescendientes.
     * Cuenta el número de descendientes de un nodo n recursivamente.
     * @param n El nodo padre.
     * @return El número de descendientes del nodo n.
     */
    public int cuentaHijos(NodoArbol n) {
    	if(n == null)
    		return 0;
    	int hijos = 0;
    	if(n.getNodoIzq() != null)
    		hijos++;
    	if(n.getNodoDer() != null)
    		hijos++;
    	return hijos + cuentaHijos(n.getNodoDer()) + cuentaHijos(n.getNodoIzq());
    }

    /**
     * Método que imprime que tipo de árbol binario es.
     */
    public void imprimeTipo() {
	if (isFullBinaryTree(raiz)) {
	    System.out.println("El árbol es un Full binary tree.");
	}
	if (isPerfectBinaryTree(raiz)) {
	    System.out.println("El árbol es un Perfect binary tree.");
	}
	if (isBalancedBinaryTree(raiz)) {
	    System.out.println("El árbol es un Balanced binary tree");
	}
	if (isDegenerateBinaryTree(raiz)) {
	    System.out.println("El árbol es un Degenerate binary tree");
	}
    }

    /**
     * Método que revisa si es un árbol binario balanceado.
     * @param raiz Raíz del árbol binario.
     * @return true si es un BalancedBinaryTree, false en otro caso.
     */
    public boolean isBalancedBinaryTree(NodoArbol raiz) {
    	boolean b = false;
    	int diferencia = altura(raiz.getNodoIzq()) - altura(raiz.getNodoDer());
    	if(diferencia == 0 || Math.abs(diferencia) == 1)
    		b = true;
    	return b;
    }

    /**
     * Método que revisa si es un árbol binario perfecto.
     * @param raiz Raíz del árbol binario.
     * @return true si es un PerfectBinaryTree, false en otro caso.
     */
    public boolean isPerfectBinaryTree(NodoArbol raiz) {
    	if(numberOfLeafs(raiz) == Math.pow(2, level(raiz)))
    		return true;
    	return false;
    }

    /**
     * Método que revisa si es un árbol binario completo.
     * @param raiz Raíz del árbol binario.
     * @return true si es un FullBinaryTree, false en otro caso.
     */
    public boolean isFullBinaryTree(NodoArbol raiz) {
    	if(raiz == null)
    		return false;

    	if(!hasTwoChildren(raiz) && !isLeaf(raiz))
    		return false;

    	if(isLeaf(raiz))
    		return true;

    	return isFullBinaryTree(raiz.getNodoDer()) && isFullBinaryTree(raiz.getNodoIzq());
    }

    /**
     * Método que revisa si es un árbol binario denegerado.
     * @param raiz Raíz del árbol binario.
     * @return true si es un DegenerateBinaryTree, false en otro caso.
     */
    protected boolean isDegenerateBinaryTree(NodoArbol raiz) {
       	if(raiz == null) {
    		return false;
    	}
    	if(hasTwoChildren(raiz))
    		return false;

    	if(raiz.getNodoIzq() != null)
	    isDegenerateBinaryTree(raiz.getNodoIzq());
    	else
	    isDegenerateBinaryTree(raiz.getNodoDer());
    	return true;
    }

    /**
     * Método que comprueba si el nodo es una hoja.
     * @param n Nodo del cual queremos saber si es una hoja
     * @return true si es una hoja, false en otro caso.
     */
    protected boolean isLeaf(NodoArbol n) {
    	if(n == null) {
    		return false;
    	}
    	boolean b = false;
    	if(n.getNodoIzq() == null && n.getNodoDer() == null)
    		b = true;
    	return b;
    }

    /**
     * Método para saber si un nodo tiene dos hijos
     * @param n Nodo del cual queremos saber si tiene dos hijos
     * @return true si tiene dos hijos, false en otro caso.
     */
    protected boolean hasTwoChildren(NodoArbol n) {
    	if(n == null)
    		return false;
    	boolean b = false;
    	if(n.getNodoIzq() != null && n.getNodoDer() != null)
    		b = true;
    	return b;
    }

    /**
     * Método que devuleve la altura del árbol binario.
     * @param raiz Raíz del árbol binario.
     * @return La altura del árbol.
     */
    public int altura(NodoArbol raiz) {
    	if(raiz == null)
    		return 0;
    	return 1 + Math.max(altura(raiz.getNodoIzq()), altura(raiz.getNodoDer()));
    }

    /**
     * Método que devuelve el número de hojas que tiene un árbol binario.
     * @param raiz Raiz del árbol binario.
     * @return El número de hojas en el árbol binario.
     */
    protected int numberOfLeafs(NodoArbol raiz) {
    	if(raiz == null) {
    		return 0;
    	}
    	if(isLeaf(raiz)) {
    		return 1;
    	}

    	return numberOfLeafs(raiz.getNodoIzq()) + numberOfLeafs(raiz.getNodoDer());
    }

    /**
     *	Método para obtener el número de niveles que tiene un nodo. Empezando de 0.
     * @param raiz Raíz del árbol binario.
     * @return El número de niveles que tiene el árbol binario.
     */
    public int level(NodoArbol raiz) {
    	return altura(raiz)-1;
    }

    public NodoArbol getRaiz() {
    	return raiz;
    }

}
