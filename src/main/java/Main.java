import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("SpaceObject.jpg"))) {

            HttpGet request = new HttpGet("https://api.nasa.gov/planetary/apod?api_key=fa0ArK7xyFRHw5Pq35kGimrJLW8HeAhDPhWnIEfb");
            CloseableHttpResponse response = httpClient.execute(request);

            HttpEntity entity = response.getEntity();

            ObjectMapper mapper = new ObjectMapper();

            CosmosObj cosmosObj = mapper.readValue(entity.getContent(), new TypeReference<>() {
            });

            request = new HttpGet(cosmosObj.getHdurl());
            response = httpClient.execute(request);

            entity = response.getEntity();
            InputStream stream = entity.getContent();
            long size = entity.getContentLength();

            while (size != 0) {
                byte[] buffer = new byte[stream.available()];
                size = size - stream.read(buffer);
                bos.write(buffer);
            }
            bos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
