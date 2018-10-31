package webserver;

//  http://localhost:8092/Lab01.html
/* An example of a very simple, multi-threaded HTTP server.
 
 */
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;

class WebServer
{

    /* static class data/methods */
//    static File root; // the web server's virtual root
    static Scanner sc;
    public static void main(String[] a)
    {
        try
        {
            sc = new Scanner(System.in);
//            root = new File(System.getProperty("user.dir"));
            int port = 8092;

            ServerSocket ss = new ServerSocket(port);
            System.out.println(String.format("Web server started. Listening on port %d\r\n", port));
  
            
            while (true) // listen for requests on port 8092
            {
                Socket s = ss.accept();
                System.out.println("Accepted connection");
     
                handleHTTPRequest(s);  // process the request
            }
        } catch (Throwable ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    // process GET or POST request from a browser
    public static void handleHTTPRequest(Socket s) throws Exception
    {
        byte[] b = null;
        FileInputStream fis = null;
        try
        {
            InputStream is = new BufferedInputStream(s.getInputStream());
            s.setSoTimeout(2000);	  // block on read for this many milliseconds

            StringBuilder sb = new StringBuilder();
            String line = null;
            int contentLength = -1;
            // get all the header info from request..
            do
            {
                line = readLine(is);

                if (line.toLowerCase().startsWith("content-length"))
                {
                    // Remember length of the content of the request body [ if it exists]
                    Pattern p = Pattern.compile("\\d+$");
                    Matcher m = p.matcher(line);
                    if (m.find())
                    {
                        contentLength = Integer.parseInt(m.group());
                    }
                }
                sb.append(String.format("%s\r\n", line));
            } while (line.length() > 0);
            
            // If we have a request body...
            if (contentLength != -1)
            {
                b = new byte[contentLength];
                is.read(b);
                sb.append(new String(b, "UTF-8"));
            }
            
            System.out.format("The web browser sent the following request:\r\n\r\n%s\r\n ",
                    sb.toString());
            System.out.format("Enter name of file that contains your HTTP response\r\n> ");

           // Output response
            String fileName = sc.next();
            fis = new FileInputStream(fileName);
            int len = fis.available();
            b = new byte[len];
            fis.read(b);
            OutputStream os = s.getOutputStream();
            os.write(b);            
        } catch (Exception ex)
        {
            System.out.format("%s: %s", ex.getClass().getName(), ex.getMessage());
        } finally
        {
            s.close();
            fis.close();
        }
    }

// read socket until \r\n found. If stream ends before this is found return null, else return
// bytes up to but not including \r\n
    private static String readLine(InputStream is) throws Exception
    {
        int ch = 0;
        ArrayList<Integer> a = new ArrayList<Integer>();
        while (true)
        {
            ch = is.read();
            if (ch == -1)
            {
                return null;
            }	  // shouldn't happen with HTTP headers
            if (ch == '\r')
            {
                ch = is.read();
                break;
            } else
            {
                a.add(ch);
            }
        }

        int len = a.size();
        byte[] b = new byte[len];
        for (int i = 0; i < len; i++)
        {
            b[i] = (byte) ((Integer) a.get(i)).intValue();
        }

        return new String(b, 0, b.length, "UTF-8");
    }
}
