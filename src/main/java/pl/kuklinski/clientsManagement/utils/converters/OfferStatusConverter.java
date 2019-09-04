package pl.kuklinski.clientsManagement.utils.converters;

import pl.kuklinski.clientsManagement.database.models.OfferStatus;
import pl.kuklinski.clientsManagement.javaFX.modelFX.OfferStatusFX;

public class OfferStatusConverter {

    public static OfferStatusFX convertToOfferStatusFX(OfferStatus status) {
        OfferStatusFX offerStatusFX = new OfferStatusFX();
        offerStatusFX.setId(status.getId());
        offerStatusFX.setTitle(status.getTitle());
        return offerStatusFX;
    }

    public static OfferStatus convertToOfferStatus(OfferStatusFX statusFX) {
        OfferStatus offerStatus = new OfferStatus();
        offerStatus.setId(statusFX.getId());
        offerStatus.setTitle(statusFX.getTitle());
        return offerStatus;
    }
}
