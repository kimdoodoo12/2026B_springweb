package example.day01;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 1. 해당 컨트롤러에게 HTTP(웹기술) 적용하기 <- 서블릿 필요(톰캣 포함(스프링부트 포함))
// 2. 서블릿에게 상속(해당 클래스로부터 멤버변수/메소드 물려)받기 , extends HttpServlet
// 3. 물려받은 기능(init, service, destory)
// 4. HTTP doXXX 메소드 오버라이딩하여 비즈니스 로직 및 기능 구현 (컨트롤러 역할)
// 5. 해당 컨트롤러에게 HTTP 주소 등록하기
@WebServlet("/example/day01")
public class BoardController extends HttpServlet{
    @Override
    public void init() throws ServletException {
        // [1] 서블릿이 최초 실행 된 경우 딱 1번 실행되는 메소드
        super.init();
    }

    // [2] 서블릿이 생성되고 요청마다 (스레드풀에서 스레드할당받아) 실행되는 메소드
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 활용 : 요청한 사람 IP
        super.service(req, res);
    }

    // [3] 서블릿이 사라질 때 (서버 종료될 때) 1번 실행되는 메소드
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        super.destroy();
    }

    // ************************ HTTP METHOD CRUD ************************************** //
    // [4-1] doGet : HTTP 요청이 GET이면
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // DAO 호출하여 로그인처리
        super.doGet(req, resp);
    }

    // [4-2] doPost : HTTP 요청이 POST이면
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }

    // [4-3] doPut : HTTP 요청이 PUT이면
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPut(req, resp);
    }

    // [4-4] doDelete : HTTP요청이 DELETE이면 실행
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doDelete(req, resp);
    }

}
