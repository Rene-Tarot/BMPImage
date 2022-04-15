import java.io.*;

public class BmpImageHandleRotator extends ImageHandler {

	protected byte[] filebytes;
	protected String copyname;
	protected int width;
	

	public BmpImageHandleRotator(String name){
		super(name);
		this.copyname = name;
	}

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

	public byte[][] hRotation(){
		int height = filebytes[]
	}

	public void generateFiles() throws Exception {
		outputRed = this.getRmat();
		FileOutputStream outred = new FileOutputStream("Red-"+copyname);
		outred.write(outputRed);
		outred.close();
		
		outputBlue = this.getBmat();
		FileOutputStream outblue = new FileOutputStream("Blue-"+copyname);
		outblue.write(outputBlue);
		outblue.close();
	}
}