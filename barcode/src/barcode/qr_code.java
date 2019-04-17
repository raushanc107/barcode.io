package barcode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter; 
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
/**
 * Servlet implementation class qr_code
 */
@WebServlet("/qr_code")
public class qr_code extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public qr_code() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String value=request.getParameter("value");
		response.setContentType("image/png");
		ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(getqrcodeimage(value,250,250));
        responseOutputStream.flush();
        responseOutputStream.close();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	private byte[] getqrcodeimage(String text,int width,int height) {
		try {
			QRCodeWriter qrcodewriter=new QRCodeWriter();
			BitMatrix bitmatrix =qrcodewriter.encode(text,BarcodeFormat.QR_CODE, width, height);
			ByteArrayOutputStream bytearrayoutputstream=new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitmatrix, "png", bytearrayoutputstream);
			return bytearrayoutputstream.toByteArray();
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
