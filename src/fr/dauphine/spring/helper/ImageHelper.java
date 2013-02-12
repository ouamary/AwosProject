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
 
	private static final int IMG_WIDTH = 200;
	private static final int IMG_HEIGHT = 200;
 
	public static void main(String [] args){
 
	try{
 
		BufferedImage originalImage = ImageIO.read(new File("c:\\image\\mkyong.jpg"));
		int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
 
		BufferedImage resizeImageJpg = resizeImage(originalImage, type);
		ImageIO.write(resizeImageJpg, "jpg", new File("c:\\image\\mkyong_jpg.jpg")); 
 
		BufferedImage resizeImagePng = resizeImage(originalImage, type);
		ImageIO.write(resizeImagePng, "png", new File("c:\\image\\mkyong_png.jpg")); 
 
		BufferedImage resizeImageHintJpg = resizeImageWithHint(originalImage, type);
		ImageIO.write(resizeImageHintJpg, "jpg", new File("c:\\image\\mkyong_hint_jpg.jpg")); 
 
		BufferedImage resizeImageHintPng = resizeImageWithHint(originalImage, type);
		ImageIO.write(resizeImageHintPng, "png", new File("c:\\image\\mkyong_hint_png.jpg")); 
 
	}catch(IOException e){
		System.out.println(e.getMessage());
	}
 
    }
 
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