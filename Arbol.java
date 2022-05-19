import java.util.LinkedList;
import java.util.Queue;

class NodoArbol {
    

    NodoArbol nodoIzq;
    int datos;
    NodoArbol nodoDer;


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

}

public class Arbol {


    NodoArbol raiz;

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
        System.out.print(nodo.datos + " ");
        recorrePreorden(nodo.nodoIzq);
        recorrePreorden(nodo.nodoDer);
    }


    public void Inorden(){
        recorreInorden(raiz);
    }


    public void recorreInorden(NodoArbol nodo) { 
        if (nodo==null) {
            return;
        }
        recorreInorden(nodo.nodoIzq);
        System.out.print(nodo.datos + " ");
        recorreInorden(nodo.nodoDer);
    }

    public void Postorden(){
        recorrePostorden(raiz);
    }

    public void recorrePostorden(NodoArbol nodo) { 
        if (nodo==null) {
            return;
        }
        recorrePostorden(nodo.nodoIzq);
        recorrePostorden(nodo.nodoDer);
        System.out.print(nodo.datos + " ");
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
    			System.out.print(actual.datos + " ");
    			if(actual.nodoIzq != null) {
    				cola.add(actual.nodoIzq);
    			}
    			if(actual.nodoDer != null) {
    				cola.add(actual.nodoDer);
    			}
    		}		
    	}
    }
    
    public boolean contiene(NodoArbol raiz, int dato) {
    	boolean b = false;
    	if (raiz == null)
    		return b;
    	if(raiz.datos == dato)
    		b = true;
    	else if(dato < raiz.datos)
    		b = contiene(raiz.nodoIzq, dato);
    	else
    		b = contiene(raiz.nodoDer, dato);
    	return b;    			
    }
    
    public boolean contieneNodo(NodoArbol raiz, NodoArbol n) {
    	boolean b = false;
    	if(raiz == null)
    		return b;
    	if(raiz == n)
    		b = true;
    	else if(contieneNodo(raiz.nodoDer, n) || contieneNodo(raiz.nodoIzq,n))
    		b = true;
    	return b;
    }
    
    public NodoArbol busca(NodoArbol raiz, int dato) {
    	if(!contiene(raiz, dato))
    		return null;
    	else if(raiz.datos == dato)
    		return raiz;
    	else if(dato < raiz.datos)
    		return busca(raiz.nodoIzq, dato);
    	else
    		return busca(raiz.nodoDer, dato);
    }
    
//    public void busquedaSeguimiento(NodoArbol n) {
//    	if(!contiene(raiz, n)) {
//    		
//    	}
//    }
    
    public void ruta(NodoArbol raiz, int dato) {
    	if(!contiene(raiz, dato)) 
    		System.out.println("Nodo no encontrado.");
    	else if (raiz.datos == dato)
    		System.out.println();
    	else if(dato < raiz.datos) {
    		System.out.print("L");
    		ruta(raiz.nodoIzq,dato);
    	} else {
    		System.out.print("D");
    		ruta(raiz.nodoDer, dato);
    	}
    }
    
    public int getNumeroDescendientes(NodoArbol raiz, int dato) {
    	if(!contiene(raiz,dato)) {
    		return -1;
    	}
    	NodoArbol padre = busca(raiz, dato);
    	int descendientes = cuentaHijos(padre);
    	return descendientes;
    }
    
    public int cuentaHijos(NodoArbol raiz) {
    	if(raiz == null)
    		return 0;
    	int hijos = 0;
    	if(raiz.nodoIzq != null)
    		hijos++;    	
    	if(raiz.nodoDer != null) 
    		hijos++;    	
    	return hijos + cuentaHijos(raiz.nodoDer) + cuentaHijos(raiz.nodoIzq);
    }
    
    public boolean isBalancedBinaryTree(NodoArbol raiz) {
    	boolean b = false;
    	int diferencia = altura(raiz.nodoIzq) - altura(raiz.nodoDer);
    	if(diferencia == 0 || Math.abs(diferencia) == 1)
    		b = true;
    	return b;
    }
    
    public boolean isPerfectBinaryTree(NodoArbol raiz) {
    	if(numberOfLeafs(raiz) == Math.pow(2, level(raiz)))
    		return true;
    	return false;
    }
    
    public boolean isFullBinaryTree(NodoArbol raiz) {
    	if(raiz == null)
    		return false;
    	
    	if(!hasTwoChildren(raiz) && !isLeaf(raiz))
    		return false;
    	
    	if(isLeaf(raiz))
    		return true;
    	
    	return isFullBinaryTree(raiz.nodoDer) && isFullBinaryTree(raiz.nodoIzq);
    }
    
    public boolean isDegenerateBinaryTree(NodoArbol raiz) {
       	if(raiz == null) {
    		return false;
    	}    	
    	if(hasTwoChildren(raiz))
    		return false;
    	
    	if(raiz.nodoIzq != null) 
    		isDegenerateBinaryTree(raiz.nodoIzq);
    	else 
    		isDegenerateBinaryTree(raiz.nodoDer);
    	
    	return true;
    }
    
    public boolean isLeaf(NodoArbol raiz) {
    	if(raiz == null) {
    		return false;
    	}
    	boolean b = false;
    	if(raiz.nodoIzq == null && raiz.nodoDer == null)
    		b = true;
    	return b;
    }
    
    public boolean hasTwoChildren(NodoArbol raiz) {
    	if(raiz == null)
    		return false;    	
    	boolean b = false;
    	if(raiz.nodoIzq != null && raiz.nodoDer != null)
    		b = true;
    	return b;
    }
    
    public int altura(NodoArbol raiz) {
    	if(raiz == null)
    		return 0;
    	return 1 + Math.max(altura(raiz.nodoIzq), altura(raiz.nodoDer));
    }
    
    public int numberOfLeafs(NodoArbol raiz) {
    	if(raiz == null) {
    		return 0;
    	}
    	if(isLeaf(raiz)) {
    		return 1;
    	}
    	
    	return numberOfLeafs(raiz.nodoIzq) + numberOfLeafs(raiz.nodoDer);
    }
    
    public int level(NodoArbol raiz) {
    	return altura(raiz)-1;
    }
    
    public NodoArbol getRaiz() {
    	return raiz;
    }

}
