package pl.kuklinski.clientsManagement.utils.converters;

import pl.kuklinski.clientsManagement.database.models.Adviser;
import pl.kuklinski.clientsManagement.modelFX.AdviserFX;

public class AdviserConverter {

    public static AdviserFX convertToAdviserFx(Adviser adviser) {
        AdviserFX adviserFX = new AdviserFX();
        adviserFX.setName(adviser.getName());
        adviserFX.setId(adviser.getId());
        adviserFX.setSurname(adviser.getName());
        return adviserFX;
    }
}
