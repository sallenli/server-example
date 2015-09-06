package com.netease.server.example.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.netease.server.example.factory.ServiceFactory;
import com.netease.server.example.meta.User;
import com.netease.server.example.service.UserService;

/**
 *
 *
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 4607606190625660785L;

	/**
	 * Logger for this class.
	 */
	private static Logger logger = Logger.getLogger(UserServlet.class);

	@Override
	public void init() throws ServletException {
		logger.info("UserServlet init method is invoked.");
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.info("UserServlet post method is invoked.");
		process(request, response);
	}

	@Override
	public void destroy() {
		logger.info("UserServlet destroy method is invoked.");
	}

	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");

		UserService userService = ServiceFactory.getUserService();
		RequestDispatcher dispatcher = null;

		User u = new User();
		u.setUserName(userName);
		u.setUserPassword(userPassword);

		String value = this.getInitParameter("tomcat");

		try {
			User user = userService.getUserByAccount(u);
			if (user != null) {
				PrintWriter writer = response.getWriter();
				writer.println("<html>");
				writer.println("<head><title>用户中心</title></head>");
				writer.println("<body>");
				writer.println("<p>用户名：" + user.getUserName() + "</p>");
				writer.println("<p>用户说明：" + user.getUserDesc() + "</p>");
				if (value != null) {
					writer.println("<p>初始化参数 tomcat的 value值：" + value + "</p>");
				}
				writer.println("</body>");
				writer.println("</html>");
				writer.close();
			} else {
				dispatcher = request.getRequestDispatcher("/error.html");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			dispatcher = request.getRequestDispatcher("/error.html");
			dispatcher.forward(request, response);
		}

	}
}
