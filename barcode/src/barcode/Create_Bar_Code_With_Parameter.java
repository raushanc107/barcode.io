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
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * Servlet implementation class Create_Bar_Code_With_Parameter
 */
@WebServlet("/Create_Bar_Code_With_Parameter")
public class Create_Bar_Code_With_Parameter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Create_Bar_Code_With_Parameter() {
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
        responseOutputStream.write(getupccodeimage(value, 400, 100));
        responseOutputStream.flush();
        responseOutputStream.close();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	private byte[] getupccodeimage(String text,int width,int height) {
		try {
			Hashtable<EncodeHintType,ErrorCorrectionLevel> hintMap=new Hashtable<>();
			hintMap.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.L);
			Writer writer=new Code128Writer();
			BitMatrix bitmatrix=writer.encode(text,BarcodeFormat.CODE_128,width, height);
			ByteArrayOutputStream bytearrayoutputstream=new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitmatrix,"png",bytearrayoutputstream);
			return bytearrayoutputstream.toByteArray();
		}catch (Exception e) {
			System.out.println(e.getMessage());
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
