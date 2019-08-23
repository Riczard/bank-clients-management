package pl.kuklinski.clientsManagement.utils.converters;

import pl.kuklinski.clientsManagement.database.models.Adviser;
import pl.kuklinski.clientsManagement.modelFX.AdviserFX;

public class AdviserConverter {

    public static AdviserFX convertToAdviserFx(Adviser adviser) {
        AdviserFX adviserFX = new AdviserFX();
        adviserFX.setName(adviser.getName());
        adviserFX.setId(adviser.getId());
        adviserFX.setSurname(adviser.getSurname());
        return adviserFX;
    }

    public static Adviser convertToAdviser(AdviserFX adviserFX) {
        Adviser adviser = new Adviser();
        adviser.setId(adviserFX.getId());
        adviser.setName(adviserFX.getName());
        adviser.setSurname(adviserFX.getSurname());
        return adviser;
    }
}
