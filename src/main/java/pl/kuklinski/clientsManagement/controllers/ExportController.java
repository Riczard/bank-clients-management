package pl.kuklinski.clientsManagement.controllers;

import pl.kuklinski.clientsManagement.javaFX.model.ExportModel;

public class ExportController {

    private ExportModel exportModel;

    public void initialize() {
        exportModel = new ExportModel();
    }

    public void eksportClients() {
        this.exportModel.exportClients();
    }
}
