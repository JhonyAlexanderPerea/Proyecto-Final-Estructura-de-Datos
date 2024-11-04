package util;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class correoUtil {

    // Método principal para enviar un correo electrónico
    public static void sendEmail(String[] toAddress, String subject, MimeBodyPart... messageBodyParts)
            throws AddressException, MessagingException, IOException {

        // Credenciales de la cuenta desde la que se enviará el correo
        final String username = "uniquindioarlines@gmail.com";
        final String password = "esvo rkht udjp pnju";

        // Crear el mensaje de correo
        Message msg = new MimeMessage(getCreateSession(username, password));

        // Configurar el remitente del correo
        msg.setFrom(new InternetAddress(username));

        // Configurar destinatarios del correo
        InternetAddress[] toAddresses = new InternetAddress[toAddress.length];
        for (int i = 0; i < toAddresses.length; i++) {
            toAddresses[i] = new InternetAddress(toAddress[i]);
        }
        msg.setRecipients(Message.RecipientType.TO, toAddresses);

        // Asunto del correo
        msg.setSubject(subject);

        // Fecha de envío del correo
        msg.setSentDate(new Date());

        // Crear el contenido del mensaje con múltiples partes (por ejemplo, texto y archivos adjuntos)
        Multipart multipart = new MimeMultipart();
        for (MimeBodyPart messageBodyPart : messageBodyParts) {
            multipart.addBodyPart(messageBodyPart);
        }

        // Establecer el contenido del mensaje
        msg.setContent(multipart);

        // Enviar el correo electrónico utilizando las credenciales del remitente
        Transport.send(msg, username, password);
    }

    // Método que crea la sesión de autenticación con las credenciales proporcionadas
    private static Session getCreateSession(String mailFrom, String mailPassword) {
        Session session = Session.getInstance(getGmailProperties(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailFrom, mailPassword);
            }
        });
        return session;
    }

    // Método que configura las propiedades del servidor SMTP de Gmail
    private static Properties getGmailProperties() {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        return prop;
    }

    // Método auxiliar para enviar un correo de recuperación de cuenta
    public static void enviarCorreo(String correo, String nombre, String codigoRecuperacion)
            throws MessagingException, IOException {
        String[] listaCorreos = {correo};

        // Crear el contenido HTML del mensaje de recuperación
        StringBuilder sb = new StringBuilder();
        sb.append("<p>");
        sb.append("Estimado/a, ");
        sb.append("<b>");
        sb.append(nombre);
        sb.append("</b>");
        sb.append("<br><br>");
        sb.append("Este es tu para recuperar tu cuenta ");
        sb.append(codigoRecuperacion);

        // Crear la parte del mensaje con el contenido HTML
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(sb.toString(), "text/html");

        // Llamar al método para enviar el correo
        sendEmail(listaCorreos, "Código de recuperación", messageBodyPart);
    }

    public static void enviarCorreoConfirmacionCompra(String correo, String nombre)
            throws MessagingException, IOException {
        String[] listaCorreos = {correo};

        // Crear el contenido HTML del mensaje de confirmación de compra
        StringBuilder sb = new StringBuilder();
        sb.append("<p>");
        sb.append("Estimado/a, ");
        sb.append("<b>");
        sb.append(nombre);
        sb.append("</b>");
        sb.append("<br><br>");
        sb.append("Gracias por su compra. Su transacción se ha realizado con éxito.");
        sb.append("<br>");
        sb.append("Les deseamos un feliz viaje.");
        sb.append("<br><br>");
        sb.append("Saludos cordiales,");
        sb.append("<br>");
        sb.append("UniQuindio Airlines.");

        // Crear la parte del mensaje con el contenido HTML
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(sb.toString(), "text/html");

        // Llamar al método para enviar el correo
        sendEmail(listaCorreos, "Confirmación de Compra Exitosa", messageBodyPart);
    }
}



