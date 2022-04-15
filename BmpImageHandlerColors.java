import java.io.*;

public class BmpImageHandlerColors extends ImageHandler {

	/** Arreglo que contiene la imagen con el header **/
	protected byte[] filebytes;
	/** Nombre que se le dara a la copia de la imagen **/
	protected String copyname;
	/** Areglos que contienen las imagenes separadas por color **/
	protected byte[] outputRed;
	protected byte[] outputGreen;
	protected byte[] outputBlue;
	protected byte[] outputSepia;

	
	public BmpImageHandlerColors(String name) {
		super(name);
		this.copyname = name;
	}

	/** Lee la imagen y el header como bytes. **/
	public void readFile() throws Exception {
		
		try{
			FileInputStream input = new FileInputStream(this.handledFileName);
			filebytes = new byte[input.available()];
			input.read(filebytes);
			input.close();
		}
		catch (Exception e) {
			System.out.println("Error! La imagen no existe o esta en otro direcctorio.");	
		}
	}

	/** Crea la imagen en rojo. **/
	public byte[] getRmat() {
		byte[] redIMG = new byte[filebytes.length];
		for (int i=0; i<54; i++) {
			redIMG[i] = filebytes[i];
		}

		for (int i=56; i<filebytes.length; i+=3) {
			redIMG[i] = filebytes[i];
			redIMG[i-1] = 0;
			redIMG[i-2] = 0;
		}
		return redIMG;
	}

	/** Crea la imagen en azul. **/
	public byte[] getBmat() {
		byte[] blueIMG = new byte[filebytes.length];
		for (int i=0; i<54; i++) {
			blueIMG[i] = filebytes[i];
		}

		for (int i=57; i<filebytes.length; i+=3) {
			blueIMG[i] = filebytes[i];
			blueIMG[i-1] = 0;
			blueIMG[i+1] = 0;
		}
		return blueIMG;
	}

	/** Crea la imagen en verde. **/
	public byte[] getGmat() {
		byte[] greenIMG = new byte[filebytes.length];
		for (int i=0; i<54; i++) {
			greenIMG[i] = filebytes[i];
		}

		for (int i=58; i<filebytes.length; i+=3) {
			greenIMG[i] = filebytes[i];
			greenIMG[i-1] = 0;
			greenIMG[i-2] = 0;
		}
		return greenIMG;
	}

	
	/** Crea la imagen en sepia. **/
	public byte[] getSepia() {
		byte[] sepiaIMG = new byte[filebytes.length];
		for (int i=0; i<54; i++) {
			sepiaIMG[i] = filebytes[i];
		}

		for (int i=57; i<filebytes.length; i+=3) {
			int azul = filebytes[i] &0xFF;
			int rojo = filebytes[i-1] &0xFF;
			int verde = filebytes[i-2] &0xFF;

			int sepiaRed = (int) (0.393*rojo + 0.769*verde + 0.189*azul);
			if(sepiaRed > 255) sepiaRed = 255;
			int sepiaVerde = (int) (0.349*rojo + 0.686*verde + 0.168*azul);
			if(sepiaVerde > 255) sepiaVerde = 255;
			int sepiaAzul = (int) (0.272*rojo + 0.534*verde + 0.131*azul);
			if(sepiaAzul > 255) sepiaAzul = 255;

			sepiaIMG[i] = (byte) sepiaAzul;
			sepiaIMG[i-1] = (byte) sepiaRed;
			sepiaIMG[i-2] = (byte) sepiaVerde;	
		}
		return sepiaIMG;
	}
	

	/** Genera los archivos de cada color. **/
	public void generateFiles() throws Exception {
		outputRed = this.getRmat();
		FileOutputStream outred = new FileOutputStream("Red-"+copyname);
		outred.write(outputRed);
		outred.close();
		
		outputBlue = this.getBmat();
		FileOutputStream outblue = new FileOutputStream("Blue-"+copyname);
		outblue.write(outputBlue);
		outblue.close();

		outputGreen = this.getGmat();
		FileOutputStream outgreen = new FileOutputStream("Green-"+copyname);
		outgreen.write(outputGreen);
		outgreen.close();

		outputSepia = this.getSepia();
		FileOutputStream outsepia = new FileOutputStream("Sepia-"+copyname);
		outsepia.write(outputSepia);
		outsepia.close();
	}
}