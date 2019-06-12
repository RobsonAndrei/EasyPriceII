package carlos.robson.easyprice.Service;

import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AcessoRest {

    private int TIMEOUT_MILLISEC = 3000;

    public String postUsuario(String []objetos){

        StringBuilder content = new StringBuilder();
        String urlCaminho = "http://54.232.197.19:8080/EasyPrice/api/usuario";
        int responseCode = -1;

        URL url;
        try {

            System.out.println("EXECUTANDO MÉTODO POST");

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

            StrictMode.setThreadPolicy(policy);

            url = new URL(urlCaminho);

            HttpURLConnection client = (HttpURLConnection) url.openConnection();

            client.setRequestMethod("POST");
            client.setRequestProperty("Content-type", "application/json");
            client.setRequestProperty("Accept", "application/json");
            client.setDoOutput(true);

            //Populando o JSON para POST
            String jsonPost = "{\"cpf\":\""+objetos[0].toString()+"\",\"nome\":\""+objetos[1].toString()+"\",\"idade\":"+objetos[2].toString()+",\"email\":\""+objetos[3].toString()+"\",\"salario\":"+objetos[4].toString()+",\"senha\":\""+objetos[5].toString()+"\"}";

            System.out.println("JSON: " + jsonPost);

            //POST
            DataOutputStream writer = new DataOutputStream(client.getOutputStream());
            writer.writeBytes(jsonPost);
            writer.flush();
            writer.close();

            responseCode = client.getResponseCode();

            System.out.println("NÚMERO DA RESPOSTA: " + responseCode);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }

            bufferedReader.close();

            System.out.println("CONTENT: " + content.toString());

        } catch(MalformedURLException mfex){
            System.out.println("********ERRO 2" + mfex.getMessage());
        }catch(IOException ioex){
            System.out.println("******** ERRO aqui ******** " + ioex.toString());
        }

        return String.valueOf(content);
    }

    public String login(String []dadosLogin){

        StringBuilder content = new StringBuilder();
        String urlCaminho = "http://54.232.197.19:8080/EasyPrice/api/usuario/login";
        int responseCode = -1;

        URL url;

        try
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

            StrictMode.setThreadPolicy(policy);

            url = new URL(urlCaminho);

            HttpURLConnection client = (HttpURLConnection) url.openConnection();

            client.setRequestMethod("POST");
            client.setRequestProperty("Content-type", "application/json");
            client.setRequestProperty("Accept", "application/json");
            client.setDoOutput(true);

            //Populando o JSON para POST Login
            String jsonPost = "{\"email\":\""+dadosLogin[0].toString()+"\",\"senha\":\""+dadosLogin[1].toString()+"\"}";

            System.out.println("JSON: " + jsonPost);

            //POST
            DataOutputStream writer = new DataOutputStream(client.getOutputStream());
            writer.writeBytes(jsonPost);
            writer.flush();
            writer.close();

            responseCode = client.getResponseCode();

            System.out.println("NÚMERO DA RESPOSTA: " + responseCode);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }

            bufferedReader.close();

        }catch(Exception e){
            System.out.println("ERRO: " + e.getLocalizedMessage());
        }

        System.out.println("CONTENT: " + content);

        return content.toString();
    }

    public String get(String caminhoURL) {

        StringBuilder content = new StringBuilder();

        try {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

            StrictMode.setThreadPolicy(policy);

            URL url = new URL(caminhoURL);

            URLConnection urlConnection = url.openConnection();

            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
                System.out.println("LÁ NA CLASSE ACESSO REST: " + line);
            }

            bufferedReader.close();

        } catch (Exception e) {
            Log.i("erro", e.toString());
        }

        return content.toString();
    }
}
