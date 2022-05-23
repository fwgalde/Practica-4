public class UsoArbol {

    public static void main(String[] args) {

	Arbol test0 = new Arbol(); // Árbol vacío.

	Arbol test1 = new Arbol(); // Árbol con 1 nodo.
	test1.insertarNodo(1);

	Arbol test2 = new Arbol(); // Árbol perfecto con 2 niveles.
	test2.insertarNodo(2);
	test2.insertarNodo(1);
	test2.insertarNodo(3);

	Arbol test3 = new Arbol(); // Árbol degenerado con 3 niveles.
	test3.insertarNodo(1);
	test3.insertarNodo(2);
	test3.insertarNodo(3);

	Arbol test4 = new Arbol(); // Árbol completo con 4 niveles.
	test4.insertarNodo(45);
	test4.insertarNodo(23);
	test4.insertarNodo(65);
	test4.insertarNodo(2);
	test4.insertarNodo(38);
	test4.insertarNodo(52);
	test4.insertarNodo(96);
	test4.insertarNodo(7);
	test4.insertarNodo(1);

	Arbol test5 = new Arbol(); // Árbol balanceado con 5 niveles.
	test5.insertarNodo(45);
	test5.insertarNodo(23);
	test5.insertarNodo(65);
	test5.insertarNodo(2);
	test5.insertarNodo(38);
	test5.insertarNodo(52);
	test5.insertarNodo(96);
	test5.insertarNodo(7);
	test5.insertarNodo(1);
	test5.insertarNodo(48);
	test5.insertarNodo(29);
	test5.insertarNodo(22);

	Arbol test6 = new Arbol(); //Árbol con 6 niveles.
	test6.insertarNodo(45);
	test6.insertarNodo(23);
	test6.insertarNodo(65);
	test6.insertarNodo(2);
	test6.insertarNodo(38);
	test6.insertarNodo(52);
	test6.insertarNodo(96);
	test6.insertarNodo(7);
	test6.insertarNodo(1);
	test6.insertarNodo(48);
	test6.insertarNodo(29);
	test6.insertarNodo(22);
	test6.insertarNodo(9);

	System.out.println(test1.toString());
	test1.imprimeTipo();
	System.out.println(test2.toString());
	test2.imprimeTipo();
	System.out.println(test3.toString());
	test3.imprimeTipo();
	System.out.println(test4.toString());
	test4.imprimeTipo();
	System.out.println(test5.toString());
	test5.imprimeTipo();
	test5.busquedaSeguimiento(29);
	System.out.println(test6.toString());
	System.out.println(test6.getNumeroDescendientes(23));
	test6.busquedaSeguimiento(9);
    }
}
