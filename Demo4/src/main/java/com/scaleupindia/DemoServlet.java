package com.scaleupindia;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.service.OwnerService;
import com.scaleupindia.service.impl.OwnerServiceImpl;

/**
 * @author abhishekvermaa10
 *
 */
@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OwnerService ownerService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ownerService = new OwnerServiceImpl();
		try {
			response.setContentType("text/html");
			List<OwnerDTO> ownerDTOList = ownerService.findAllOwners();
			response.getWriter().println("<h3>There are " + ownerDTOList.size() + " owners.</h3>");
			// response.getWriter().println("<h3> " + ownerDTOList + " </h3>");
		} catch (Exception exception) {
			response.getWriter().println("<h1> " + exception.getMessage() + " </h1>");
		}
	}
}
