package ru.tp;

import ru.tp.add_01.Add;
import ru.tp.add_01.Leap;
import ru.tp.tree_02.Tree;
import ru.tp.weather_03.Weather;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.NotDirectoryException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, NotDirectoryException {
        {
            Add.add(2, 2);
            System.out.println(Leap.isLeap(2020));
        }

        {
            Tree.getTree("./", true);
        }
        {
            Weather weather = new Weather();
            weather.setApiKey("Set your api key");

            try {
                System.out.println(weather.getTemperature("London"));

                System.out.println(weather.getDifferenceString("London", "Moscow"));
                System.out.println(weather.getTomorrowDiff("London"));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }
}
