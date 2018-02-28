

<%@page import="java.util.Date"%>
<%@page import="BusinessObject.Email"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.File"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%!
    private List<String> Milestones = new ArrayList<String>();
    private List<String> InitialPropisedPlanes = new ArrayList<String>();
    private List<String> LastAgreedPlanes = new ArrayList<String>();
    private List<String> PresentForeCasts = new ArrayList<String>();
    private List<String> Achieveds = new ArrayList<String>();
    private List<String> Delays = new ArrayList<String>();
    private String Id;
    private String Achievements;
    private String Issues;
    private String Details;
    private String Plan;
    private String UserName;
    private String Header;
    private String storeDate;

    String Milestoneroot = "C:\\Users\\singhj1\\Downloads\\NetBeansProjects\\PIMDSWEB\\web\\Weekly\\ProjectWeekly\\Option\\Create\\Data\\Milestone";
    String Reportingroot = "C:\\Users\\singhj1\\Downloads\\NetBeansProjects\\PIMDSWEB\\web\\Weekly\\ProjectWeekly\\Option\\Create\\Data\\Reporting";
    StringBuffer HTML = new StringBuffer();
    StringBuffer HTML2 = new StringBuffer();
    BusinessObject.Email email = new Email();
%>
<%
    HTML.delete(0, HTML.length());
    HTML2.delete(0, HTML2.length());
    HTML.append("<!DOCTYPE html>\n"
            + "<html>\n"
            + "    <head>\n"
            + "    </head>\n"
            + "    <body>\n"
            + "\n"
            + "    <html>\n"
            + "        <body> "
            + "<style>\n"
            + "                table#customers {\n"
            + "                    font-size: 16px;\n"
            + "                    font-family: Arial, Helvetica, sans-serif;\n"
            + "                    border-collapse: collapse;\n"
            + "                    color: #707070;"
            + "                    border-spacing: 0;\n"
            + "                    width: 100%;\n"
            + "                    table-layout: fixed;\n"
            + "\n"
            + "                }\n"
            + "                tbody {\n"
            + "                    display: table-row-group;\n"
            + "                    vertical-align: middle;\n"
            + "                    border-color: inherit;\n"
            + "                }\n"
            + "                tr {\n"
            + "                    display: table-row;\n"
            + "                    vertical-align: inherit;\n"
            + "                    border-color: inherit;\n"
            + "                }\n"
            + "                #customers th {\n"
            + "                    padding-top: 11px;\n"
            + "                    padding-bottom: 11px;\n"
            + "                    background-color: #38678f;"
            + "                    color: #ddd;"
            + "                    font-weight: lighter;\n"
            + "                    transition: all 0.2s;\n"
            + "                    \n"
            + "                }\n"
            + "                #customers td, #customers th {\n"
            + "                    border: 1px solid #ddd;\n"
            + "                    text-align: left;\n"
            + "                    padding: 8px;\n"
            + "\n"
            + "                }\n"
            + "\n"
            + "                #customers tr:nth-child(even) {\n"
            + "                    background-color: #f2f2f2;\n"
            + "                }\n"
            + "                .LinkToDetail{\n"
            + "                    text-decoration: none;\n"
            + "                    color: blue;\n"
            + "                    font-size: large;\n"
            + "                    font-family: sans-serif;\n"
            + "                    font-weight: lighter;\n"
            + "                }.LinkToDetail:hover{\n"
            + "                    color: crimson;\n"
            + "                }\n"
            + "            </style>"
            + "            <h1 style=\"color: lightslategrey; font-family: Trebuchet MS, Arial, Helvetica, sans-serif;\">WEEKLY::LAB::W " + request.getParameter("WeekNumber") + ":: Y " + request.getParameter("Year") + "</h1>\n"
            + "            <p style=\"font-weight: lighter;font-family: sans-serif;\">Weekly compiled by <span style=\"color: tomato;\"> " + request.getSession().getAttribute("Name") + " </span> on <span style=\"color: tomato;\"> " + new Date().toString() + " </span></p>\n"
            + "            <p style=\"font-size: medium;font-weight: lighter;font-family: sans-serif;color: black;\"> PROJECT SUMMARY & LINKS FOR DETAILS  </p>\n"
            + "           <a name=\"Top\" ></a><table id=\"customers\">\n"
            + "                <tbody>\n"
            + "                    <tr>\n"
            + "                        <th> PROJECT NAME </th>\n"
            + "                        <th> IPNEED </th>\n"
            + "                        <th> TECHNOLOGY </th>\n"
            + "                        <th> VERSION </th>\n"
            + "                        <th> PRODUCT </th>\n"
            + "                        <th> DIVISION </th>\n"
            + "                        <th> Action </th>\n"
            + "                       \n"
            + "                    </tr>\n");
    for (int i = 0; i < request.getParameterValues("File").length; i++) {

        BusinessObject.ProjectDetail projectDetail = BusinessLogic.ProjectDetailBL.GetSingle(Integer.parseInt(request.getParameterValues("File")[i].split("_")[0]));

        HTML.append("<tr>\n"
                + "                        <td width='20%'>" + projectDetail.getName() + "</td>\n"
                + "                        <td width='10%'>" + projectDetail.getIPNeed() + "</td>\n"
                + "                        <td width='10%'>" + projectDetail.getTechnology() + "</td>\n"
                + "                        <td width='10%'>" + projectDetail.getVersion() + "</td>\n"
                + "                        <td width='20%'>" + projectDetail.getProduct() + "</td>\n"
                + "                        <td width='20%'>" + projectDetail.getDivision() + "</td>\n"
                + "                        <td width='10%'> <a href=\"#" + projectDetail.getName() + "\" class=\"LinkToDetail\">Details</a> </td>\n"
                + "                    </tr>\n");
    }
    HTML2.append("</tbody></table></br><hr style=\"background-color: #fff;border-top: 5px dashed #8c8b8b;\">\n"
            + "            </br>\n"
            + "            <h3 style=\"color: #38678f; font-family: sans-serif;\"> Reporting and Milestone Details </h3>\n");
    for (int i = 0; i < request.getParameterValues("File").length; i++) {
        BusinessObject.ProjectDetail projectDetail = BusinessLogic.ProjectDetailBL.GetSingle(Integer.parseInt(request.getParameterValues("File")[i].split("_")[0]));
        File Reporting_file = new File(Reportingroot + "/" + "Reporting_" + request.getParameterValues("File")[i]);
        Scanner Reportingfilescan = new Scanner(Reporting_file);
        Reportingfilescan.useDelimiter(",");
        while (Reportingfilescan.hasNext()) {

            try {
                UserName = Reportingfilescan.next();
                storeDate = Reportingfilescan.next();
                Header = Reportingfilescan.next();
                Achievements = Reportingfilescan.next();
                Issues = Reportingfilescan.next();
                Details = Reportingfilescan.next();
                Plan = Reportingfilescan.next();

            } catch (Exception ex) {

            }
        }

        Scanner Milestonefilescan = new Scanner(new File(Milestoneroot + "/" + "Milestone_" + request.getParameterValues("File")[i]));

        Milestonefilescan.useDelimiter(",");
        while (Milestonefilescan.hasNext()) {

            try {
                Milestones.clear();
                InitialPropisedPlanes.clear();
                LastAgreedPlanes.clear();
                PresentForeCasts.clear();
                Achieveds.clear();
                Delays.clear();

                Milestones.add(Milestonefilescan.next());
                InitialPropisedPlanes.add(Milestonefilescan.next());
                LastAgreedPlanes.add(Milestonefilescan.next());
                PresentForeCasts.add(Milestonefilescan.next());
                Achieveds.add(Milestonefilescan.next());
                Delays.add(Milestonefilescan.next());

            } catch (Exception ex) {
                out.println("<script>alert(" + ex.getMessage() + ");</script>");

            }
        }
        HTML2.append("<a name=\"" + projectDetail.getName() + "\"></a>\n"
                + "<p style=\"color: brown; font-size: lighter;font-weight: bold; font-family: Trebuchet MS, Arial, Helvetica, sans-serif;\"> # " + projectDetail.getName() + " </p>\n"
                + "<table id=\"customers\">\n"
                + "                <tbody>\n"
                + "                    <tr>\n"
                + "                        <th> Milestone </th>\n"
                + "                        <th> Initial Proposed Plan </th>\n"
                + "                        <th> Last Agreed Plan </th>\n"
                + "                        <th> Present Forecast </th>\n"
                + "                        <th> Achieved </th>\n"
                + "                        <th> Delay </th>\n"
                + "                    </tr>\n");
        for (int j = 0; j < Milestones.size(); j++) {

            HTML2.append("<tr><td>" + Milestones.get(j) + "</td><td>" + InitialPropisedPlanes.get(j) + "</td><td>" + LastAgreedPlanes.get(j) + "</td><td>" + PresentForeCasts.get(j) + "</td><td>" + Achieveds.get(j) + "</td><td>" + Delays.get(j) + "</td></tr>");
        }

        HTML2.append("</tbody>\n"
                + "            </table>\n"
                + "            \n"
                + "            <br>\n"
                + "            <table id=\"customers\">\n"
                + "                <tbody>\n"
                + "                    <tr>\n"
                + "                        <th colspan=\"2\"> Reporting </th>\n"
                + "                      \n"
                + "                    </tr>\n"
                + "                    <tr>\n"
                + "                        <td> Achievements </td>\n"
                + "                        <td> " + Achievements + " </td>\n"
                + "                      \n"
                + "                    </tr>\n"
                + "                    <tr>\n"
                + "                        <td> Issues </td>\n"
                + "                        <td>" + Issues + "</td>\n"
                + "                        \n"
                + "                    </tr>\n"
                + "                    <tr>\n"
                + "                        <td> Details </td>\n"
                + "                        <td>" + Details + "</td>\n"
                + "                        \n"
                + "                    </tr>\n"
                + "                    <tr>\n"
                + "                        <td> Plan  </td>\n"
                + "                        <td>" + Plan + "</td>\n"
                + "                        \n"
                + "                    </tr>\n"
                + "                \n"
                + "                </tbody></table><br>\n"
                + "             <hr style=\"background-color: #fff;border-top: 5px dashed #8c8b8b;\"><a href=\"#Top\" class=\"LinkToDetail\"> Back to top</a>\n");

    }

    HTML2.append("\n"
            + "        </body>\n"
            + "    </html>\n"
            + "\n"
            + "</body>\n"
            + "</html>");
    email.setTo(request.getSession().getAttribute("Email").toString());
    email.setFrom(request.getSession().getAttribute("FromEmail").toString());
    email.setSubject("Compile Weekly By " + request.getSession().getAttribute("Name").toString());
    email.setBody(HTML.toString() + HTML2.toString());

    if (BusinessLogic.EmailBL.sendMail(email)) {
        out.println("<h1 style='colour:red;font-weight: bold; font-family:sans-serif;'> The mail have been successfully sent. </h1>");
    } else {
        out.println("<h1 style='colour:red;font-weight: bold; font-family:sans-serif;'> Error while Sending mail. </h1>");
    }
%>