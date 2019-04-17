package barcode;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.keepdynamic.barcode.generator.BarCode;

/**
 * Servlet implementation class upc
 */
@WebServlet("/upc")
public class upc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public upc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try { 
			String value=request.getParameter("value");
            BarCode barcode = new BarCode(); 
            
            // set barcode properties 
            barcode.setSymbologyType(BarCode.UPCA); 
            barcode.setCodeText(value);
            barcode.setBarCodeHeight(200.0f);
            barcode.setBarCodeWidth(500.0f);
            barcode.setTopMargin(0);
            barcode.setLeftMargin(0);
            barcode.setRightMargin(0);
            barcode.setBottomMargin(0);
            
            // draw and generate barcode to response's ServletOutputStream 
            ServletOutputStream servletoutputstream = response.getOutputStream(); 
            
            barcode.drawBarCode2Stream(servletoutputstream); 

        } catch (Exception e) { 
        	System.out.println(e.getMessage());
            throw new ServletException(e); 
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
