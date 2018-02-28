/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImageData;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author singhj1
 */
public class ImageData {

    public static List<Integer> ImageProcess(String file) {

        List<Integer> lists = new ArrayList<>();
        List<Color> colors = new ArrayList<>();
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(file));

            int Height = bufferedImage.getHeight();
            int Width = bufferedImage.getWidth();

            for (int i = 0; i < Height; i++) {
                for (int j = 0; j < Width; j++) {

                    colors.add(new Color(bufferedImage.getRGB(j, i)));

                }

            }

            for (int i = 0; i < colors.size(); i++) {

                if (colors.get(i).getBlue() > 50) {

                    lists.add(0);

                } else {
                    lists.add(1);
                }
            }

        } catch (Exception ex) {

            System.out.println(ex);
        }
        
        return lists;
    }

    public static void main(String[] args) {
        // TODO code application logic here
//        int Height = 100;
//        int Width = 100;
//        
//        BufferedImage bufferedImage = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_ARGB);
//        
//        File file = null;
//        
//        for(int y=0; y<Height;y++){
//            for(int x=0;x<Width;x++){
//            
//                //int A = (int) (Math.random() * 256);
//                int R = 0;
//                int G = 225;
//                int B = 0;
//                
//                int P = (R <<24)| (G <<24)| B;
//             // System.out.println(P);
//                bufferedImage.setRGB(x,y,P);
//            //System.out.println(bufferedImage.getRGB(x,y));
//            }
//        
//        }
//        try{
//            file = new File("file.png");
//            
//            ImageIO.write(bufferedImage, "png", file);
//        
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }

    }

}
