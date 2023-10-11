module emailClient {

    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.web;
    requires activation;
    requires java.mail;
    requires java.desktop;

    opens pl.pierogmichal;
    opens pl.pierogmichal.controller;
    opens pl.pierogmichal.model;
}
