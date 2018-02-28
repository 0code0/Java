/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BusinessObject.User;
import java.io.IOException;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jaswinder
 */
public class Login extends HttpServlet {

    HttpSession httpsession;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        httpsession = request.getSession();
/**
        BusinessObject.User user = new User();
        String Name = request.getParameter("username");
        String Pass = request.getParameter("pass");
        String UserName = "";
        String Email = "";
        String MobileNo = "";
        String SeatNo = "";
        String ExtentionNo = "";
        String FullName = "";

        if ((!Name.equals("")) && (!Pass.equals(""))) {

            String attributeGet = " ";
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://ldap.dlh.st.com:389/");
            DirContext ctx = null;
            try {
                ctx = new InitialDirContext(env);

            } catch (NamingException ex) {

                response.sendRedirect("/PIMDSWEB/index.jsp");
            }

            if (ctx != null) {

                try {

                    String UId = "uid=" + Name;
                    SearchControls searchControl = new SearchControls();
                    searchControl.setSearchScope(2);

                    NamingEnumeration namingEnumeration = ctx.search("dc=st,dc=com", UId, searchControl);

                    while (namingEnumeration.hasMore()) {

                        SearchResult searchResult = (SearchResult) namingEnumeration.next();
                        Attributes attributes = searchResult.getAttributes();
                        Attribute attribute = attributes.get("st-eduid");
                        attributeGet = (String) attribute.get();

                        Hashtable hashtable = new Hashtable();
                        hashtable.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
                        hashtable.put("java.naming.provider.url", "ldap://ldap.dlh.st.com:389");
                        hashtable.put("java.naming.security.principal", ("st-eduid=" + attributeGet + ",ou=people,dc=st,dc=com"));
                        hashtable.put("java.naming.security.credentials", Pass);
                        hashtable.put("java.naming.security.authentication", "simple");

                        try {
                            InitialDirContext initialdircontext = new InitialDirContext(hashtable);
                            SearchControls searchcontrols = new SearchControls();
                            searchcontrols.setSearchScope(2);

                            String dcDetail = "dc=st,dc=com";

                            NamingEnumeration namingenumeration = initialdircontext.search(dcDetail, UId, searchcontrols);
                            SearchResult searchresults = (SearchResult) namingenumeration.next();
                            Attributes attributess = searchresults.getAttributes();

                            Attribute mail = attributess.get("mail");
                            if (mail != null) {
                                Email = "" + mail.get();
                            }

                            Attribute uid = attributess.get("uid");
                            if (uid != null) {
                                UserName = "" + uid.get();
                            }

                            Attribute givenname = attributess.get("cn");
                            if (givenname != null) {
                                FullName = "" + givenname.get();
                            }

                            Attribute mobile = attributess.get("mobile");
                            if (mobile != null) {
                                MobileNo = "" + mobile.get();
                                MobileNo =  MobileNo.substring(4,MobileNo.length());
                            }

                            user = BusinessLogic.UserBL.IsValidUser(UserName);

                            if (user != null) {

                                httpsession.setAttribute("UserName", UserName);
                                httpsession.setAttribute("Email", Email);
                                httpsession.setAttribute("Role", user.getRole());
                                httpsession.setAttribute("Image", user.getUrl());
                                httpsession.setAttribute("Id", user.getId());
                                httpsession.setAttribute("Name", FullName);
                                httpsession.setAttribute("FromEmail", "jaswinder.singh@sgp.st.com");
                                httpsession.setAttribute("Password", "aezakmi0786@");
                                response.sendRedirect("/PIMDSWEB/DeshBoard.jsp");
                            } else {
                                httpsession.setAttribute("UserName", UserName);
                                httpsession.setAttribute("Email", Email);
                                httpsession.setAttribute("Name", FullName);
                                
                                response.sendRedirect("/PIMDSWEB/OtherUsers/OtherUser.jsp");
                            }
                            

                        } catch (NamingException namingexception) {

                            response.sendRedirect("/PIMDSWEB/index.jsp?UserNameAndPassword=InValid");
                        }
                    }

                } catch (NamingException ex) {
                    response.sendRedirect("/PIMDSWEB/index.jsp?UserNameAndPassword=InValid");
                }

            }

        } else {
            response.sendRedirect("/PIMDSWEB/index.jsp");

        }
        */
         response.sendRedirect("/PIMDSWEB/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

}
