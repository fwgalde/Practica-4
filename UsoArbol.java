public class UsoArbol {
	

	public static void main(String[] args) {
		
		Arbol a = new Arbol();
		a.insertarNodo(4);
		a.insertarNodo(2);
		a.insertarNodo(5);
		a.insertarNodo(3);
		a.insertarNodo(1);
		a.insertarNodo(6);


		a.preorden();
		System.out.println("\n");
		a.Inorden();
		System.out.println("\n");
		a.Postorden();
		System.out.println("\n");
		a.nivel(a.getRaiz());
		System.out.println();
		System.out.println(a.contiene(a.getRaiz(), 33));
		a.ruta(a.getRaiz(), 3);
		System.out.println(a.getNumeroDescendientes(a.getRaiz(), 5));
		System.out.println(a.altura(a.getRaiz()));
		System.out.println(a.isBalancedBinaryTree(a.getRaiz()));
		System.out.println(a.numberOfLeafs(a.getRaiz()));
		System.out.println("es degenerado: " + a.isDegenerateBinaryTree(a.getRaiz()));
		System.out.println("es balanceado: " + a.isBalancedBinaryTree(a.getRaiz()));
		System.out.println("es completo: " + a.isFullBinaryTree(a.getRaiz()));
		System.out.println("es perfecto: " + a.isPerfectBinaryTree(a.getRaiz()));
		
		System.out.println("CODORNIZ\n\n");
		System.out.println(a.hasTwoChildren(a.getRaiz()));
		System.out.println(a.isLeaf(a.getRaiz().nodoDer));
		System.out.println(a.hasTwoChildren(a.getRaiz().nodoIzq));
		System.out.println(a.isLeaf(a.getRaiz().nodoIzq.nodoDer));
		System.out.println(a.isLeaf(a.getRaiz().nodoIzq.nodoIzq));
	}





}
