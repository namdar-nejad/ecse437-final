module hexanome.thirteen.client {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
//    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires javafx.graphics;
    requires org.apache.httpcomponents.httpcore;
    requires org.apache.httpcomponents.httpclient;
    requires com.google.gson;

    opens hexanome.thirteen.client to javafx.fxml;
    exports hexanome.thirteen.client;
  exports hexanome.thirteen.client.controller;
  opens hexanome.thirteen.client.controller to javafx.fxml;
}