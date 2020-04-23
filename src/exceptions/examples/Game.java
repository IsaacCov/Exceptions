package exceptions.examples;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Game {

    public void saveGame() {
        try {
            saveProgress();
            saveScore();
            saveStadistics();
        } catch (SaveProgressException ex) {
            System.err.println("Error can't save progress " + ex.getMessage());
        } catch (SaveScoreException ex) {
            //System.err.println("Error can't save score " + ex.getMessage());
            ex.printStackTrace();
        } catch (SaveStadisticsException ex) {
            System.err.println("Error can't save stadistics " + ex.getMessage());
        }

    }

    private void saveStadistics() throws SaveStadisticsException {
        try (FileWriter writer = new FileWriter("Stadistics.txt", true)) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

            writer.append("Guardado: ").append(now.format(formatter)).append(System.lineSeparator());
        } catch (IOException e) {
            throw new SaveStadisticsException();
        }
        throw new IndexOutOfBoundsException("IndexOutOfBoundsException thrown just because");
    }

    private void saveScore() throws SaveScoreException {
        try (FileWriter writer = new FileWriter("Score.txt", true)) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

            writer.append("Guardado: ").append(now.format(formatter)).append(System.lineSeparator());

            throw new IOException("IOException de prueba");
        } catch (IOException e) {
            throw new SaveScoreException("El mensaje", e);
        }
    }

    private void saveProgress() throws SaveProgressException{
        try (FileWriter writer = new FileWriter("Progress.txt", true)) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

            writer.append("Guardado: ").append(now.format(formatter)).append(System.lineSeparator());
        }catch(IOException e){
            throw new SaveProgressException();
        }
    }
}
