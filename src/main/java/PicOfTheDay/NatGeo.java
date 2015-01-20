package PicOfTheDay;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import java.time.LocalDate;

class NatGeo {

    public static void main(String[] args) {
        String natgeo;
        String today = getDay();
        try {
            natgeo = NatGeo.getUrl();
            System.out.println(natgeo);
            //the filename will be NatGeoPOTD-2015-01-31
            saveImage(natgeo, "NatGeoPOTD-" + today + ".jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() throws IOException {
        try {
            Document doc = Jsoup.connect("http://photography.nationalgeographic.com/photography/photo-of-the-day/").get();
            Element div = doc.select("div[class=primary_photo]").first();
            if (div == null) {
                return null;
            }
            Element href = div.select("a[href]").first();
            Element src = div.select("img[src]").first();
            if (href == null || src == null) {
                return null;
            }
            return "http:" + src.attr("src");


        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    public static void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
    }
    public static String getDay() {
        LocalDate today = LocalDate.now();
        return today.toString();
    }
}
