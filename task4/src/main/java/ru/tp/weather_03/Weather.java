package ru.tp.weather_03;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;


public class Weather {
    private String apiKey;
    private final String baseUrl = "http://api.openweathermap.org/data/2.5/weather";
    private final String forecastUrl = "http://api.openweathermap.org/data/2.5/forecast";

    private HttpClient client = HttpClientBuilder.create().build();

    public JSONObject getResponseForCity(String city, String urlHost) throws IOException, URISyntaxException {
        HttpResponse response = get(city, urlHost);
        if (response.getStatusLine().getStatusCode() != 200) {
            throw new HttpResponseException(400, "Api error. City is bad");
        }
        String responseString = EntityUtils.toString(response.getEntity());

        return new JSONObject(EntityUtils.toString(response.getEntity()));
    }

    public float getTemperature(String city) throws IOException, URISyntaxException {
        JSONObject response = getResponseForCity(city, baseUrl);
        return response.getJSONObject("main").getFloat("temp");
    }

    public HttpResponse get(String city, String urlHost) throws IOException, URISyntaxException {
        URIBuilder builder = new URIBuilder(urlHost);
        builder.setParameter(
        "q", city
        ).setParameter(
        "appid", apiKey
        ).setParameter(
        "units", "metric"
        );
        HttpGet request = new HttpGet(builder.build());

        return client.execute(request);
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public float findDiffBetweenTwoCities(String city1, String city2) throws IOException, URISyntaxException {
        return getTemperature(city1) - getTemperature(city2);
    }

    public String getDifferenceString(String city1, String city2) throws IOException, URISyntaxException {
        float diff = findDiffBetweenTwoCities(city1, city2);
        StringBuilder output = new StringBuilder();
        output.append("Weather in ");
        output.append(city1);
        output.append(" ");
        if (diff < 0) {
            output.append("is colder than in ");
            output.append(city2);
            output.append(" by ");
            output.append((int) -diff);
            output.append(" degrees");
        } else {
            output.append("is warmer than in ");
            output.append(city2);
            output.append(" by ");
            output.append((int) diff);
            output.append(" degrees");
        }
        return output.toString();
    }

    public float getTomorrowTemperature(String city) throws IOException, URISyntaxException {
        JSONObject response = getResponseForCity(city, forecastUrl);
        return response.getJSONArray(
                "list"
        ).getJSONObject(
                7
        ).getJSONObject(
                "main"
        ).getFloat("temp");
    }

    public String getTomorrowDiff(String city) throws IOException, URISyntaxException {
        float diff = getTomorrowTemperature(city) - getTemperature(city);

        StringBuilder builder = new StringBuilder();
        builder.append("The weather in ");
        builder.append(city);
        builder.append(" tomorrow will be ");
        String response;
        if (diff > 3) {
            response = "much warmer";
        } else if (diff > 0.5) {
            response = "warmer";
        } else if (diff < -3) {
            response = "much colder";
        } else if (diff < -0.5) {
            response = "colder";
        } else {
            response = "the same";
        }
        builder.append(response).append(" than today.");
        return builder.toString();
    }
}
