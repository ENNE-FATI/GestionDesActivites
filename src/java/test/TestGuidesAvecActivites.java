package test;

import dao.GuideDao;
import entities.Guide;
import java.util.List;

public class TestGuidesAvecActivites {
    public static void main(String[] args) {
        GuideDao dao = new GuideDao();
        List<Guide> result = dao.findGuidesWithActivities();

        for (Guide guide : result) {
            System.out.println("ID: " + guide.getId() +
                               ", Nom: " + guide.getNom() +
                               ", Email: " + guide.getEmail() +
                               ", Langue: " + guide.getLangue());
        }
    }

}

