/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Weekly;

import BusinessObject.Email;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author singhj1
 */
public class CreateMilestoneAndReporting extends HttpServlet {

    private String Id;
    private String Achievements;
    private String Issues;
    private String Details;
    private String Plan;
    private String Week;
    private String Header;
    private String Year;
    private String EmailSelectedManager = null;
    private List<String> Milestones = new ArrayList<>();
    private List<String> InitialPropisedPlanes = new ArrayList<>();
    private List<String> LastAgreedPlanes = new ArrayList<>();
    private List<String> PresentForeCasts = new ArrayList<>();
    private List<String> Achieveds = new ArrayList<>();
    private List<String> Delays = new ArrayList<>();
    BusinessObject.Email email = new Email();
    StringBuffer HTMLEmailBody = new StringBuffer();
    Date date = new Date();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List items = upload.parseRequest(request);

                Iterator iterator = items.iterator();

                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();

                    if (item.getFieldName().equals("Header")) {
                        Header = item.getString();
                    } else if (item.getFieldName().equals("Achievements")) {

                        Achievements = item.getString();
                    } else if (item.getFieldName().equals("Issues")) {

                        Issues = item.getString();
                    } else if (item.getFieldName().equals("Details")) {

                        Details = item.getString();
                    } else if (item.getFieldName().equals("Plan")) {

                        Plan = item.getString();
                    } else if (item.getFieldName().equals("Milestone")) {
                        Milestones.add(item.getString());

                    } else if (item.getFieldName().equals("InitialPropisedPlane")) {
                        InitialPropisedPlanes.add(item.getString());

                    } else if (item.getFieldName().equals("LastAgreedPlane")) {
                        LastAgreedPlanes.add(item.getString());

                    } else if (item.getFieldName().equals("PresentForeCast")) {
                        PresentForeCasts.add(item.getString());

                    } else if (item.getFieldName().equals("Achieved")) {
                        Achieveds.add(item.getString());

                    } else if (item.getFieldName().equals("Delay")) {
                        Delays.add(item.getString());

                    } else if (item.getFieldName().equals("Id")) {
                        Id = item.getString();

                    } else if (item.getFieldName().equals("Week")) {
                        Week = item.getString();

                    } else if (item.getFieldName().equals("Year")) {
                        Year = item.getString();

                    } else if (item.getFieldName().equals("EmailSelectedManager")) {
                        EmailSelectedManager = item.getString();

                    }
                }

                String Reportingroot = "C:\\Users\\singhj1\\Downloads\\NetBeansProjects\\PIMDSWEB\\web\\Weekly\\ProjectWeekly\\Option\\Create\\Data\\Reporting";
                String Milestonrroot = "C:\\Users\\singhj1\\Downloads\\NetBeansProjects\\PIMDSWEB\\web\\Weekly\\ProjectWeekly\\Option\\Create\\Data\\Milestone";

                File Reportingfile = new File(Reportingroot + "/Reporting_" + Id + "_" + Week + "_" + Year + ".txt");
                File Milestonefile = new File(Milestonrroot + "/Milestone_" + Id + "_" + Week + "_" + Year + ".txt");

                boolean ReportingfileFlag = Reportingfile.createNewFile();
                boolean MilestonefileFlag = Milestonefile.createNewFile();

                if (ReportingfileFlag) {
                    try (Writer ReportingfileWriter = new BufferedWriter(new FileWriter(Reportingfile))) {
                        ReportingfileWriter.write(request.getSession().getAttribute("UserName") + " " + "," + date.toString() + " " + "," + Header + " " + "," + Achievements + " " + "," + " " + Issues + " " + "," + " " + Details + " " + "," + " " + Plan + " " + ",");
                        ReportingfileWriter.flush();
                        ReportingfileWriter.close();

                    }

                }

                if (MilestonefileFlag) {

                    try (Writer MilestonefileWriter = new BufferedWriter(new FileWriter(Milestonefile))) {

                        for (int i = 0; i < Milestones.size(); i++) {

                            MilestonefileWriter.write(Milestones.get(i) + " " + "," + " " + InitialPropisedPlanes.get(i) + " " + "," + " " + LastAgreedPlanes.get(i) + " " + "," + " " + PresentForeCasts.get(i) + " " + "," + " " + Achieveds.get(i) + " " + "," + " " + Delays.get(i) + ",");

                        }
                        MilestonefileWriter.flush();
                        MilestonefileWriter.close();

                    }
                }
                BusinessObject.ProjectDetail projectDetail = BusinessLogic.ProjectDetailBL.GetSingle(Integer.parseInt(Id));
                List<BusinessObject.ProjectAllocation> projectAllocations = BusinessLogic.ProjectAllocationBL.GetAllByProjectDetailId(projectDetail.getId());

                HTMLEmailBody.append(Header).append("</br><table style=\"border-collapse: collapse;width: 100%;text-align: left;border: 1px solid darkorange;\"   >\n"
                        + "            <tr style=\"background-color: #4CAF50;color: white;font-family: sans-serif;\">\n"
                        + "                                                    <th style='padding: 8px;'> Milestone </th>\n"
                        + "                                                    <th style='padding: 8px;'> Initial Proposed Plan </th>\n"
                        + "                                                    <th style='padding: 8px;'> Last Agreed Plan </th>\n"
                        + "                                                    <th style='padding: 8px;'> Present Forecast  </th>\n"
                        + "                                                    <th style='padding: 8px;'> Achieved </th>\n"
                        + "                                                    <th style='padding: 8px;'> Delay </th>\n"
                        + "\n"
                        + "                                                </tr>\n");
                for (int i = 0; i < Milestones.size(); i++) {
                    HTMLEmailBody.append("<tr style=\"background-color: #f2f2f2;font-family: sans-serif;\">\n"
                            + "                                                    <td style='padding: 8px;'> " + Milestones.get(i) + " </td>\n"
                            + "                                                    <td style='padding: 8px;'> " + InitialPropisedPlanes.get(i) + " </td>\n"
                            + "                                                    <td style='padding: 8px;'> " + LastAgreedPlanes.get(i) + " </td>\n"
                            + "                                                    <td style='padding: 8px;'> " + PresentForeCasts.get(i) + " </td>\n"
                            + "                                                    <td style='padding: 8px;'> " + Achieveds.get(i) + " </td>\n"
                            + "                                                    <td style='padding: 8px;'> " + Delays.get(i) + " </td>\n"
                            + "                                                </tr>\n");
                }
                HTMLEmailBody.append("</table>");
                Milestones.clear();
                InitialPropisedPlanes.clear();
                LastAgreedPlanes.clear();
                PresentForeCasts.clear();
                Achieveds.clear();
                Delays.clear();
                String Report = "</br><table style=\"border-collapse: collapse;width: 40%;text-align: left;border: 1px solid darkorange;\"   >\n"
                        + "<tr style=\"background-color: #f2f2f2;\" >\n"
                        + "                <td colspan=\"2\" style=\"color: red;font-weight: bold;font-family: sans-serif;\"> Reporting </td>\n"
                        + "            </tr>\n"
                        + "            <tr style=\"background-color: #f2f2f2;\">\n"
                        + "                <td style=\"padding: 8px;color: black;font-weight: bold;font-family: sans-serif;\"> Achievements </td>\n"
                        + "                <td style='padding: 8px;'> " + Achievements + " </td>\n"
                        + "            </tr>\n"
                        + "            <tr style=\"background-color: #f2f2f2;\">\n"
                        + "                <td style=\"padding: 8px;color: black;font-weight: bold;font-family: sans-serif;\"> Issues </td>\n"
                        + "                <td style='padding: 8px;'> " + Issues + " </td>\n"
                        + "            </tr>\n"
                        + "            <tr style=\"background-color: #f2f2f2;\">\n"
                        + "                <td style=\"padding: 8px;color: black;font-weight: bold;font-family: sans-serif;\"> Details </td>\n"
                        + "                <td style='padding: 8px;'> " + Details + " </td>\n"
                        + "            </tr>\n"
                        + "            <tr style=\"background-color: #f2f2f2;\">\n"
                        + "                <td style=\"padding: 8px;color: black;font-weight: bold;font-family: sans-serif;\"> Plan </td>\n"
                        + "                <td style='padding: 8px;'> " + Plan + " </td>\n"
                        + "            </tr>\n"
                        + "\n"
                        + "        </table></br> Thanks & Regards</br><p style='color:red;font-family: sans-serif;'>This is a system generated mail. Please do not reply</p>";

                for (BusinessObject.ProjectAllocation projectAllocation : projectAllocations) {

                    BusinessObject.User user = BusinessLogic.UserBL.GetSingle(projectAllocation.getUserId());

                    email.setFrom(request.getSession().getAttribute("FromEmail").toString());
                    email.setPassword(request.getSession().getAttribute("Password").toString());
                    email.setTo(user.getEmail());
                    email.setSubject("WEEKLY SUBMITED Project:-" + projectDetail.getName() + " WEEK:-" + Week + " YEAR:- " + Year);
                    email.setBody("Hello,</br>" + request.getSession().getAttribute("Name") + " has submited weekly for " + projectDetail.getName() + "</br> Detail are here:</br>" + HTMLEmailBody + "</br>" + Report);

                    BusinessLogic.EmailBL.sendMail(email);

                }
                // Manager
                if(!(EmailSelectedManager == null)){
                 BusinessObject.User Manager = BusinessLogic.UserBL.GetSingle(Integer.parseInt(EmailSelectedManager));

                    email.setFrom(request.getSession().getAttribute("FromEmail").toString());
                    email.setPassword(request.getSession().getAttribute("Password").toString());
                    email.setTo(Manager.getEmail());
                    email.setSubject("WEEKLY SUBMITED Project:-" + projectDetail.getName() + " WEEK:-" + Week + " YEAR:- " + Year);
                    email.setBody("Hello,</br>" + request.getSession().getAttribute("Name") + " has submited weekly for " + projectDetail.getName() + "</br> Detail are here:</br>" + HTMLEmailBody + "</br>" + Report);

                    BusinessLogic.EmailBL.sendMail(email);
                }
                response.sendRedirect("/PIMDSWEB/Weekly/ProjectWeekly/Option/Create/AfterCreateNew.jsp?Milestonefile=" + Milestonefile.getName() + "&Reportingfile=" + Reportingfile.getName() + "&Id=" + Id + "&Week=" + Week + "&Year=" + Year);

            } catch (FileUploadException ex) {
                response.sendRedirect("/PIMDSWEB/Weekly/ProjectWeekly/Option/Create/CreateNew.jsp");

            }

        }

    }

}
