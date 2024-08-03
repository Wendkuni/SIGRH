package net.gestion.pgrecrutement.services.personnel;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;


public class FileTransferUtilService {

	public static byte[] downloadFile(String serverpath){
		byte [] mydata;	
		
		File serverpathfile = new File(serverpath);			
		mydata=new byte[(int) serverpathfile.length()];
		FileInputStream in;
		try {
			in = new FileInputStream(serverpathfile);
			try {
				in.read(mydata, 0, mydata.length);
			} catch (IOException e) {
				
				e.printStackTrace();
			}						
			try {
				in.close();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Le fichier spécifié est introuvable");
//			e.printStackTrace();
		}		
		
		return mydata;
		
		
	}
	
	
	public  static void uploadFileToServer(byte[] mydata, String fileName, long length,String path)  {
		
    	try {
    		String path_dir = System.getenv("APPDATA");
    		Path pathTest = Paths.get(path_dir,path);
    		File fichier = new File(pathTest.toString());
    		if(!fichier.exists())
    		{
    			fichier.mkdirs();
    		}
    	      Date date = new Date();
    		FileOutputStream out=new FileOutputStream(pathTest.toString()+"/"+fileName);
    		byte [] data=mydata;
			
    		out.write(data);
			out.flush();
	    	out.close();
	 
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	
    	System.out.println("Done writing data...");
		
	}
		
	public static String lienRecu() {
	Path path_dir=Paths.get(System.getenv("APPDATA"));
	return path_dir.toString();
	}
	
	public static String lienAppdata() {		
			return lienRecu();
		
		
	}
	
}
