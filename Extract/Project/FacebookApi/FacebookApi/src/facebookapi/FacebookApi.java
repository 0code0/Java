/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookapi;


import facebook4j.*;
import facebook4j.conf.ConfigurationBuilder;
import facebook4j.internal.http.RequestMethod;
import static facebook4j.internal.http.RequestMethod.POST;
import facebook4j.internal.org.json.JSONException;
import facebook4j.internal.org.json.JSONObject;
import facebook4j.json.DataObjectFactory;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import jdk.nashorn.internal.parser.JSONParser;

/**
 *
 * @author jaswinder
 */

public class FacebookApi {
    
    /**
     * @param args the command line arguments
     * @throws facebook4j.FacebookException
     */
    private final static String AccessToken = "EAACEdEose0cBAKcnjkmcxCZB4kvXQ04fZACseWFuPDm56SoLimaD3FtANBJGrS9A604f2R3ch7XwrMurwapcTXO6lVEIZAwQAnkYAPgByt2r7cblzNJZAGOcceYygVb6OCRu2w2PND6SBjTUHenFXTSEtIVqsWNbNJd75rEhZCwZDZD";
    private final static String AppId = "939873682746936";
    private final static String AppSecret ="425b3f54eff413c7715395cc9822d267";
        
    
    public static void main(String[] args) throws FacebookException, FileNotFoundException, JSONException{
        // TODO code application logic here
    
        
        
        
     ConfigurationBuilder cb = new ConfigurationBuilder();
     cb.setDebugEnabled(true)
    .setOAuthAppId(AppId)
    .setOAuthAppSecret(AppSecret)
    .setOAuthAccessToken(AccessToken);
    
     FacebookFactory ff = new FacebookFactory(cb.build());
     Facebook facebook = ff.getInstance();
          
        
 
    // home post
   
//    ResponseList<Post> List = facebook.getHome();
//    
//        for (Post post : List) {            
//            //System.out.println(post.getName()+"   "+post.getId()+" "+post.getMessage() );
//            System.out.println(post.getId()+ " "+post.getName());
//        
//            
//        }
// 
    
 
    //    System.out.println(facebook.getMe().getLocation());
    
        
            // get album photo
/*
    ResponseList<Photo> pic = facebook.getAlbumPhotos("107016059469566");
    String phot;    
    for (Photo photo : pic) {
            
            phot = photo.getImages().toString();
            System.out.println(phot);
        
        }
        
  */
    
    // get albums comment 
    
//    ResponseList<Album> pic =  facebook.getAlbums(facebook.getId());
//   int count = 0;
//   int max = 0;
//   String name = null;
//        for (Album album : pic) {
//            
//            ResponseList<Photo> photos = facebook.getAlbumPhotos(album.getId());
//            
//            for (Photo photo : photos) {
//                
//               // System.out.println(photo.getId()+" "+photo.getName());
//                count = 0;
//                PagableList<Like> likes   = photo.getLikes();
//            
//                for (Like like : likes) {
//                    count++;
//                    name = photo.getId();
//                }
//                                
//                if(max < count){
//                    max = count;                    
//                }
//                
//            }
//            
//        }
//    System.out.println(max);
//      
    // get post 
    /*
    ResponseList<Post> post = facebook.getPosts(facebook.getId());
    
        for (Post posts : post) {
            System.out.println(posts.getId()+" "+posts.getMessage());
            
        }
    */
    
    // get post 
    
    
//    ResponseList<Post> post = facebook.getPosts(facebook.getId());
//    
//    
//        for (Post posts : post) {
//            
//            PagableList<Comment> comm = posts.getComments();
//            
//            for(Comment comms : comm){
//            
//                System.out.println("Id:" + comms.getId()+"Comments"+comms.getMessage());
//            }
//            
//        }
    
          //System.out.println(facebook.getUser("1103453299671859"));
            
          //System.out.println(facebook.getMe().getId());
            
            
            
            
    // get Friends    
   
//    ResponseList<Friend> frnd = facebook.getFriends();
//    
//        for (Friend friend : frnd) {
//            
//            System.out.println(friend.getId()+" "+friend.getName());
//        }


//    ResponseList<User> Results = facebook.searchUsers("naveen.koneti.9") ;
//    
//        for (User Result : Results) {
//            
//            System.out.println(Result.getId());
//        }
//        
      /*  
        ResponseList<Checkin> act = facebook.getCheckins();
        
        for (Checkin activity : act) {
            
            System.out.println(activity.getId());
        }
        
*/     
    
    // Set limit to 25 feeds.
//    ResponseList<Post> feeds = facebook.getFeed(facebook.getId(),new Reading().limit(25));
//
//        // For all 25 feeds...
//        for (int i = 0; i < feeds.size(); i++) {
//            // Get post.
//            Post post = feeds.get(i);
//            // Get (string) message.
//            String message = post.getMessage();
//                            // Print out the message.
//            System.out.println(message);
//
//            // Get more stuff...
//            PagableList<Comment> comments = post.getComments();
//            String date = post.getCreatedTime().toString();
//            String name = post.getFrom().getName();
//            String id = post.getId();
    //}           
    
//        
//        ResponseList<JSONObject> result = facebook.search("jaswinder singh");
//        
//        for (JSONObject results : result) {
//            
//            System.out.println(results);
//        }
//        
        
//        ResponseList<Book> book = facebook.getBooks();
//        
//        for (Book book1 : book) {
//            
//            System.out.println(book1.getName());
//        }
   
//                InboxResponseList<Message> msgs = facebook.getInbox();
//                
//                for (Message msg : msgs) {
//            
//                   System.out.println(facebook.getMessage(msg.getId()));
//                   
//                   
//        }
    
//         ResponseList<Message> msg = facebook.getOutbox(new Reading().limit(10));
//         
//         for (Message msg1 : msg) {
//            
//             System.out.println(facebook.getMessage(msg1.getId()));
//        }
                
        
//    ResponseList<User> result = facebook.searchUsers("");
//    
//        for (User result1 : result) {
//            
//            System.out.println(result1.getName());
//        }
    
//    ResponseList<Page> result = facebook.searchPages("jaswinder");
//    
//        for (Page result1 : result) {
//            
//            System.out.println(result1.getName());
//  
//    }
    
//   ResponseList<Place> result = facebook.searchPlaces("Delhi");
//    
//        for (Place result1 : result) {
//            
//            System.out.println(result1.getName());
//        } 
   
//     FQL Query
//        String Query = "SELECT name, birthday, email, uid FROM user WHERE uid in (SELECT uid2 FROM friend WHERE uid1 = me()) AND birthday_date != 'null' ORDER BY birthday_date";
//        String friends = "SELECT uid2,sex FROM friend WHERE uid1 = me()";
//        facebook4j.internal.org.json.JSONArray json = facebook.executeFQL(friends);
//        
//        System.out.println(json);
        
        
    
    }
    
    
    
}
   
    

