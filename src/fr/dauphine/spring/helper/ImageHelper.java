package fr.dauphine.spring.helper;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;

public class ImageHelper {
 
	private static final int IMG_WIDTH = 150;
	private static final int IMG_HEIGHT = 150;
 
	public static BufferedImage resizeImage(BufferedImage originalImage, int type){
		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		g.dispose();
	 
		return resizedImage;
    }
 
    public static BufferedImage resizeImageWithHint(BufferedImage originalImage, int type){
	 
		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		g.dispose();	
		g.setComposite(AlphaComposite.Src);
	 
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
		RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.setRenderingHint(RenderingHints.KEY_RENDERING,
		RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		RenderingHints.VALUE_ANTIALIAS_ON);
	 
		return resizedImage;
    }
    
    public static byte[] BufferedImageToByteArray(BufferedImage originalImage){
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	try {
			ImageIO.write( originalImage, "jpg", baos );
			baos.flush();
			baos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	byte[] imageInByte = baos.toByteArray();
    	
    	return imageInByte;
    }
    
    public static byte[] MultipartFileToByteArray(MultipartFile file){

    	BufferedImage image = null;
		try {
			image = ImageIO.read(file.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return BufferedImageToByteArray(image);
    }
    
    public static byte[] RedimPhoto(MultipartFile file){

    	BufferedImage resizeImageHintJpg = null, image = null;
    	try {
    		// Récupération de l'image BufferedImage depuis le Multipart
			image = ImageIO.read(file.getInputStream());
			// Récupération du type de fichier d'origine
			int type = image.getType() == 0? BufferedImage.TYPE_INT_ARGB : image.getType();
			// Redimensionnement
			resizeImageHintJpg = resizeImageWithHint(image, type);
			// Réécriture du fichier redimensionné
			ImageIO.write(resizeImageHintJpg, "jpg", new File(file.getName())); 
		} catch (IOException e) {
			e.printStackTrace();
		}
    	// Conversion
    	return BufferedImageToByteArray(resizeImageHintJpg);
    }
}