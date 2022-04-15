/* CC2 - 2017 - PJ1 */

public class BmpHandler {

	public static void runHandler(ImageHandler imgh) throws Exception {
		/** NO CAMBIE ESTE CODIGO **/
		System.out.println("--------------------------------------");
		System.out.println(imgh.getClass().getTypeName().toUpperCase() + ": ");
		System.out.println("\nLeyendo imagen : " + imgh.getFileName());
		imgh.readFile();
		System.out.println("Proceso de lectura de imagen terminado!");
		System.out.println("\nGenerando imagenes : ");
		imgh.generateFiles();
		System.out.println("Proceso de generacion de archivos terminado!");
		System.out.println("\n--------------------------------------");
		/** --------------------- **/
	}


	public static void main(String[] args) throws Exception {
		
		if (args.length== 0) {
			System.out.println("Error! Falta parametros.");
		}
		else if (args.length== 1) {
			System.out.println("Error! Falta la direccion del la imagen.");
		}
		else if(args[0].equals("-colors")) {
			BmpImageHandlerColors bihc = new BmpImageHandlerColors(args[1]);
			runHandler(bihc);
		}
		else if (args[0].equals("-all")) {
			BmpImageHandlerColors bihc = new BmpImageHandlerColors(args[1]);
			runHandler(bihc);
		}
		else {
			System.out.println("Parametros incorrectos.")
		}
	}
}