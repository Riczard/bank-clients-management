package pl.kuklinski.clientsManagement.utils.converters;

import pl.kuklinski.clientsManagement.database.models.ContactStatus;
import pl.kuklinski.clientsManagement.javaFX.modelFX.ContactStatusFX;

public class ContactStatusConverter {

    public static ContactStatusFX convertToAccStatusFX(ContactStatus contactStatus) {
        ContactStatusFX contactStatusFX = new ContactStatusFX();
        contactStatusFX.setId(contactStatus.getId());
        contactStatusFX.setContactStatus(contactStatus.getTitle());
        return contactStatusFX;
    }

    public static ContactStatus convertToContactStatus(ContactStatusFX contactStatusFX) {
        ContactStatus contactStatus = new ContactStatus();
        contactStatus.setId(contactStatusFX.getId());
        contactStatus.setTitle(contactStatusFX.getContactStatus());
        return contactStatus;
    }
}
