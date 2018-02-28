/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Weekly;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
public class CreateFromCloneMilestoneAndReporting extends HttpServlet {

    private String Id;
    private String Achievements;
    private String Issues;
    private String Details;
    private String Plan;
    private String Week;
    private String Header;
    private String Year;
    private List<String> Milestones = new ArrayList<>();
    private List<String> InitialPropisedPlanes = new ArrayList<>();
    private List<String> LastAgreedPlanes = new ArrayList<>();
    private List<String> PresentForeCasts = new ArrayList<>();
    private List<String> Achieveds = new ArrayList<>();
    private List<String> Delays = new ArrayList<>();
    
    Date date = new Date();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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

                    }else if (item.getFieldName().equals("Week")) {
                        Week = item.getString();

                    }else if (item.getFieldName().equals("Year")) {
                        Year = item.getString();

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
                        ReportingfileWriter.write(request.getSession().getAttribute("UserName")+" "+","+date.toString()+" "+","+Header+" "+","+Achievements + " " + "," + " " + Issues + " " + "," + " " + Details + " " + "," + " " + Plan + " " + ",");
                        ReportingfileWriter.flush();
                        ReportingfileWriter.close();

                    }

                }

                if (MilestonefileFlag) {

                    try (Writer MilestonefileWriter = new BufferedWriter(new FileWriter(Milestonefile))) {

                        for (int i = 0; i < Milestones.size(); i++) {

                            MilestonefileWriter.write(Milestones.get(i) + " " + "," + " " + InitialPropisedPlanes.get(i) + " " + "," + " " + LastAgreedPlanes.get(i) + " " + "," + " " + PresentForeCasts.get(i) + " " + "," + " " + Achieveds.get(i) + " " + "," + " " + Delays.get(i)+ ",");

                        }
                        MilestonefileWriter.flush();
                        MilestonefileWriter.close();

                    }
                }
                response.sendRedirect("/PIMDSWEB/Weekly/ProjectWeekly/Option/Create/AfterCreateNew.jsp?Milestonefile="+Milestonefile.getName()+"&Reportingfile="+Reportingfile.getName()+"&Id="+Id+"&Week="+Week+"&Year="+Year);
                
            } catch (FileUploadException ex) {
                response.sendRedirect("/PIMDSWEB/Weekly/ProjectWeekly/Option/Create/CreateNew.jsp");
                
            }

        }
    }

}
