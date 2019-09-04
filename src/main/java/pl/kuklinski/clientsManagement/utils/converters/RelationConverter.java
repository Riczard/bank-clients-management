package pl.kuklinski.clientsManagement.utils.converters;

import pl.kuklinski.clientsManagement.database.models.Relation;
import pl.kuklinski.clientsManagement.javaFX.modelFX.RelationFX;

public class RelationConverter {

    public static RelationFX convertToRelationFX(Relation relation) {
        RelationFX relationFX = new RelationFX();
        relationFX.setId(relation.getId());
        relationFX.setTitle(relation.getTitle());
        return relationFX;
    }

    public static Relation convertToRelation(RelationFX relationFX) {
        Relation relation = new Relation();
        relation.setId(relationFX.getId());
        relation.setTitle(relationFX.getTitle());
        return  relation;
    }
}
