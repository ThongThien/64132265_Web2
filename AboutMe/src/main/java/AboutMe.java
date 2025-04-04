import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AboutMe") // URL để truy cập servlet
public class AboutMe extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8"); 

        PrintWriter out = response.getWriter(); // Đối tượng để ghi nội dung trả về

        out.println("<html>");
        
        out.println("<head><title>About Me</title></head>");
        
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; text-align: center; background-color: #f4f4f4; }");
        out.println(".container { width: 50%; margin: auto; padding: 20px; background: white; border-radius: 10px; box-shadow: 0px 0px 10px gray; }");
        out.println("h1 { color: #333; }");
        out.println("p { font-size: 18px; }");
        out.println("</style>");
        
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>Thông tin cá nhân</h1>");
        out.println("<p><b>Họ và tên:</b> Nguyễn Thông Thiên</p>");
        out.println("<p><b>Email:</b> thien.nt.64cntt@ntu.edu.vn</p>");
        out.println("<p><b>Sở thích:</b> Lập trình, chơi game, tập gym</p>");
        out.println("<p><b>Kênh Youtube:</b> https://www.youtube.com/@86neihtnro</p>");
        out.println("</div>");
        out.println("</body>");
        
        out.println("</html>");
    }
}
