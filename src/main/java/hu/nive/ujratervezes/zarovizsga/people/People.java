package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class People {


    public int getNumberOfMales(String s) {
        Path path = Path.of(s);
        int counter = 0;
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("Male")) {
                    counter = counter + 1;
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Can not read file!", e);
        }
        return counter;
    }
}