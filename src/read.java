import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

import javax.imageio.ImageIO;

import com.google.zxing.*;
import com.google.zxing.aztec.detector.Detector;
import com.google.zxing.common.*;
import com.google.zxing.qrcode.QRCodeReader;

public class read {

	public static void main(String[] args) throws ReaderException {
		// TODO Auto-generated method stub
		//File file = new File("./qr.png");
		String a = readQRCode("./qr-sample.jpg");
		System.out.println(a);
	}


	public static String readQRCode(String fileName) throws ReaderException {
	    File file = new File(fileName);
	    BufferedImage image = null;
	    BinaryBitmap bitmap = null;
	    Result result = null;
	 
	    try {
	        image = ImageIO.read(file);
	        int[] pixels = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
	        RGBLuminanceSource source = new RGBLuminanceSource(image.getWidth(), image.getHeight(), pixels);
	        bitmap = new BinaryBitmap(new HybridBinarizer(source));
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	 
	    if (bitmap == null)
	        return null;
	    DataMatrixReader dr = new DataMatrixReader();
//	    MultiFormatReader reader1 = new MultiFormatReader();
//	    Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>(2);
//	    Vector<BarcodeFormat> decodeFormats = new Vector<BarcodeFormat>();
//	    if (decodeFormats == null || decodeFormats.isEmpty()) {
//	        decodeFormats = new Vector<BarcodeFormat>();
//	        decodeFormats.add(BarcodeFormat.DATA_MATRIX);
//	    }
//	    hints.put(DecodeHintType.POSSIBLE_FORMATS, decodeFormats);
//	    reader1.setHints(hints);
	    try {
	        result = dr.decode(bitmap);
	        //result = reader1.decode(bitmap);
	        return result.getText();
	    } catch (NotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }catch (ReaderException e) {
	    }
	    
	    
	 
	    return null;
	}
}