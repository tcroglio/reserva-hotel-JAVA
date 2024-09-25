package utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author tiago
 */
public class Utils {

    public Utils() {
    }

    //--------------------------------------------------------------------------------------//
    public static Date converterStringToDate(String texto) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;

        try {
            data = formato.parse(texto);

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao converter a data");

        }

        return data;
    }

    //--------------------------------------------------------------------------------------//
    public static String converterDateToString(Date data) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String texto = "";

        try {
            texto = formato.format(data);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao converter a data");

        }

        return texto;
    }

    //--------------------------------------------------------------------------------------//
    public static String calcularSHA1(String senha) {

        String hashSHA1 = "";

        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA1");
            sha1.update(senha.getBytes());

            byte[] digest = sha1.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            hashSHA1 = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Algoritmo SHA1 não encontrado");

        }

        return hashSHA1;
    }

    //--------------------------------------------------------------------------------------//
    public static Icon converterFileParaIcon(File arquivo) {
        ImageIcon icone = new ImageIcon(arquivo.getAbsolutePath());

        return icone;
    }

    //--------------------------------------------------------------------------------------//
    public static ImageIcon redimensionarIcon(Icon originalIcon, int largura, int altura) {
        Image imagemOriginal = ((ImageIcon) originalIcon).getImage();
        Image novaImagem = imagemOriginal.getScaledInstance(largura, altura, Image.SCALE_SMOOTH);

        return new ImageIcon(novaImagem);
    }

    //--------------------------------------------------------------------------------------//
    public static byte[] iconToBytes(Icon imagem) {
        BufferedImage image = new BufferedImage(
                imagem.getIconWidth(),
                imagem.getIconHeight(),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        imagem.paintIcon(null, g2d, 0, 0);
        g2d.dispose();

        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", byteArray);
        } catch (IOException erro) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, erro);
        }

        return byteArray.toByteArray();
    }

}