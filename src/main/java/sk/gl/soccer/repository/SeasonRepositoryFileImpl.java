package sk.gl.soccer.repository;

import sk.gl.soccer.domain.Season;
import sk.gl.soccer.util.AppendableOOS;

import java.io.*;
import java.util.List;

public class SeasonRepositoryFileImpl implements SeasonRepository {

    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private void writeToOutputStream(Season data) {
        try (FileOutputStream f = new FileOutputStream(new File(fileName), true)) {
            ObjectOutputStream os = new AppendableOOS(f);
            os.writeObject(data);
            os.flush();
        } catch (Exception e) {
            throw new PersistenceException("Something went wrong during writing to stream", e);
        }
    }

    private Season readFromInputStreamById(final Long id) {
        try (FileInputStream fi = new FileInputStream(new File(fileName))) {
            ObjectInputStream oi = new ObjectInputStream(fi);
            int i=0;
            while (true) {
                System.out.println(i++);
                Season season = getSeasonFromStream(id, oi);
                if (season != null) return season;
            }
        } catch (EOFException e) {
            return null;
        } catch (PersistenceException e) {
            throw e;
        } catch (Exception e) {
            throw new PersistenceException("Something went wrong during reading from stream", e);
        }
    }

    private Season getSeasonFromStream(Long id, ObjectInputStream oi) throws IOException, ClassNotFoundException {
        Season season = (Season) oi.readObject();
        if (season.getId().equals(id)) {
            return season;
        }
        return null;
    }

    @Override
    public List<Season> findAll() {
        return null;
    }

    @Override
    public Season create(Season data) {
        Long id = data.getId();
        if (id == null) {
            throw new PersistenceException("Cannot create season, id is null.");
        }
        Season byId = findById(id);
        if (byId != null) {
            throw new PersistenceException("Season with id: " + id + " already exist.");
        }
        writeToOutputStream(data);
        return data;
    }

    @Override
    public Season update(Season data) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Season findById(Long id) {
        return readFromInputStreamById(id);
    }
}
