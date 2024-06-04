package net.gestion.pgpu.common.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageUtil {

	public static String getLienImage(String nomImage) {
		String var ="ersto/images";
		Path path_dir = Paths.get(System.getenv("APPDATA"));
		Object path = Paths.get(path_dir.toString(), var);
		File nf = new File(path+"/"+nomImage);
		if(nf.exists()) {
			String lienImage= nf.toURI().toString();
			return lienImage;			
		}else return null;
	}

	public static boolean isBase64(String base64Image){
		String partSeparator = ",";
		try {
			if(base64Image.contains(partSeparator)){
				Base64.getDecoder().decode(base64Image.split(partSeparator)[1]);
				return true;
			}
			Base64.getDecoder().decode(base64Image);
			return true;
		} catch (IllegalArgumentException e){
			System.err.println("Echec de decodage");
          return false;
		}
	}

	public static byte[] getByteImage(String base64Image){
		String partSeparator = ",";
		if(base64Image.contains(partSeparator)){
			return Base64.getDecoder()
					.decode(base64Image.split(",")[1]);
		}
		return Base64.getDecoder()
				.decode(base64Image);
	}

	public static String getExtensionFromBase64(String base64Image){
		Pattern pattern = Pattern.compile("^data:image/(.*);base64.*$");
		Matcher matcher = pattern.matcher(base64Image);
		if (matcher.matches()) {
			return matcher.group(1);
		}
		return null;
	}

	public static String saveImage(String base64Image){
		String nomImage;
		String var ="ersto/images";
		Path path_dir = Paths.get(System.getenv("APPDATA"));
		Object path = Paths.get(path_dir.toString(), var);
		if(!new File(path.toString()).exists()){
			new File(path.toString()).mkdirs();
		}
		nomImage="Image_"+new Date().getTime();
		String imagePath = path+"\\"+nomImage;
		File nf = new File(path+"\\"+nomImage);
		String imageFormat = getExtensionFromBase64(base64Image);
		byte [] imageBytes = getByteImage(base64Image);
		try {
			convert(imageBytes, imagePath, imageFormat);
			System.out.println("Nom de l'image "+nomImage);
			return nomImage;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	public static void convert(byte[] imageBytes, String outputPath, String imageFormat) throws IOException {
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageBytes);
		BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
		File file = new File(outputPath);
		ImageIO.write(bufferedImage, imageFormat, file);
	}

	public static String convertImageToBase64(String imagePath) throws IOException {
		//URL url = new URL(imagePath);
		//File file = new File(imagePath);
		//InputStream inputStream = url.openStream();
		//byte[] bytes = inputStream.readAllBytes();
		byte[] bytes = Files.readAllBytes(Paths.get(imagePath));
		//inputStream.close();
		return Base64.getEncoder().encodeToString(bytes);
	}
}
