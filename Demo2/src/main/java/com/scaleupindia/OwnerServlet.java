package com.scaleupindia;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.service.OwnerService;
import com.scaleupindia.service.impl.OwnerServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author abhishekvermaa10
 *
 */
@WebServlet("/owners")
public class OwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OwnerService ownerService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ownerService = new OwnerServiceImpl();
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();

		printWriter.println("<html>");
		printWriter.println("<head>");
		printWriter.println("<title>Petistaan</title>");
		printWriter.println("<style>");
		printWriter.println("body { text-align: center; margin: 0; padding: 0; }");
		printWriter.println(
				"header { background-color: #ffd700; padding: 5px; text-align: center; position: fixed; top: 0; width: 100%; }");
		printWriter.println(
				"footer { background-color: #ffd700; padding: 5px; text-align: center; position: fixed; bottom: 0; width: 100%; }");
		printWriter.println("main { padding-top: 100px; padding-bottom: 100px; }");
		printWriter.println("table { margin: 0 auto; border-collapse: collapse; width: 100%; padding-bottom: 50px; }");
		printWriter.println("th, td { border: 1px solid black; padding: 8px; }");
		printWriter.println("th { background-color: #f2f2f2; }");
		printWriter.println("</style>");
		printWriter.println("</head>");

		printWriter.println("<body>");
		printWriter.println("<header>");
		printWriter.println("<h1>Petistaan</h1>");
		printWriter.println("<h4><i>by ScaleUp India</i></h4>");
		printWriter.println("</header>");

		printWriter.println("<main>");

		try {
			List<OwnerDTO> ownerDTOList = ownerService.findAllOwners();
			printWriter.println("<h1 style='padding-top: 20px;'>There are " + ownerDTOList.size() + " owners.</h1>");

			if (!ownerDTOList.isEmpty()) {
				printWriter.println("<table>");
				printWriter.println("<tr>" + "<th>Id</th>" + "<th>First Name</th>" + "<th>Last Name</th>"
						+ "<th>Gender</th>" + "<th>City</th>" + "<th>State</th>" + "<th>Mobile Number</th>"
						+ "<th>Email</th>" + "<th>Pet Id</th>" + "<th>Pet Name</th>" + "<th>Pet Birth Date</th>"
						+ "<th>Pet Gender</th>" + "<th>Pet Type</th>" + "</tr>");

				for (OwnerDTO owner : ownerDTOList) {
					printWriter.println("<tr>" + "<td>" + owner.getId() + "</td>" + "<td>" + owner.getFirstName()
							+ "</td>" + "<td>" + owner.getLastName() + "</td>" + "<td>" + owner.getGender() + "</td>"
							+ "<td>" + owner.getCity() + "</td>" + "<td>" + owner.getState() + "</td>" + "<td>"
							+ owner.getMobileNumber() + "</td>" + "<td>" + owner.getEmailId() + "</td>" + "<td>"
							+ owner.getPetId() + "</td>" + "<td>" + owner.getPetName() + "</td>" + "<td>"
							+ owner.getPetBirthDate() + "</td>" + "<td>" + owner.getPetGender() + "</td>" + "<td>"
							+ owner.getPetType() + "</td>" + "</tr>");
				}

				printWriter.println("</table>");
			} else {
				printWriter.println("<h1>No owners found.</h1>");
			}

		} catch (Exception exception) {
			printWriter.println("<h1 style='padding-top: 20px;'>" + exception.getMessage() + " </h1>");
		} finally {
			printWriter.println("</main>");
			printWriter.println("<footer>");
			printWriter.println("<p>&copy; " + LocalDate.now().getYear() + " ScaleUp India. All rights reserved.</p>");
			printWriter.println("</footer>");

			printWriter.println("</body>");
			printWriter.println("</html>");
		}
	}

}
