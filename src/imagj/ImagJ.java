/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagj;

import ij.*;
import ij.io.OpenDialog;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import loci.formats.FormatException;
import loci.plugins.*;
import org.imagearchive.lsm.reader.*;


/**
 *
 * @author Anokhin
 */
public class ImagJ {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws FormatException {
        //ImagePlus imp = IJ.openImage("C:\\Users\\Anokhin\\Desktop\\0239 Mikroskop Datenbank\\frauen_laufen.jpg");
        //ImagePlus[] imp = BF.openImagePlus("C:\\Users\\Anokhin\\Desktop\\0239 Mikroskop Datenbank\\test.lsm");
        OpenDialog od = new OpenDialog("Open Image File...");
       
        String dir = od.getDirectory();
        String name = od.getFileName();
        String id = dir + name;
        try{
            //ImagePlus[] imps = BF.openImagePlus(id);
            //ij.IJ.openImage(name);
            Reader rd = new Reader();
            rd.open(id, false);
            ImagePlus imp = rd.open(id, false);
            String info = "";
            info = imp.getFileInfo().toString();
            System.out.println(info);
            imp.show("Das LSM Bild");
        }
        catch (Exception ex){
            //Logger.getLogger(ImagJ.class.getName()).log(Level.SEVERE, null, ex);
        }
//        try {
//            imps = BF.openImagePlus(id);
//            for (ImagePlus imp : imps)
//            {
//                String info = imp.getOriginalFileInfo().toString();
//                System.out.println(info);
//                imp.show();
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(ImagJ.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }
    
}
