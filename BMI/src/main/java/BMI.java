import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/BMI")
public class BMI extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head><title>Tính BMI</title></head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>Tính Chỉ Số BMI</h1>");
        out.println("<form action='BMI' method='POST'>");
        out.println("Chiều cao (m): <input type='text' name='height' required><br>");
        out.println("Cân nặng (kg): <input type='text' name='weight' required><br>");
        out.println("<button type='submit'>Tính BMI</button>");
        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        double height = Double.parseDouble(request.getParameter("height"));
        double weight = Double.parseDouble(request.getParameter("weight"));
        double bmi = weight / (height * height);
     	String result;
     	
        if (bmi < 18.5) {
            result = "Gầy";
        } else if (bmi < 24.9) {
            result = "Bình thường";
        } else if (bmi < 29.9) {
            result = "Thừa cân";
        } else {
            result = "Béo phì";
        }

        out.println("<html>");
        out.println("<head><title>Kết Quả BMI</title></head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>Kết Quả BMI</h1>");
        out.println("<p><b>Chiều cao:</b> " + height + " m</p>");
        out.println("<p><b>Cân nặng:</b> " + weight + " kg</p>");
        out.println("<p><b>BMI:</b> " + String.format("%.2f", bmi) + "</p>");
        out.println("<p><b>Kết luận:</b> " + result + "</p>");
        out.println("<a href='BMI'>Tính lại</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
	}
}