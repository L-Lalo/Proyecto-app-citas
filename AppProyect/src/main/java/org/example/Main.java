package org.example;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main extends Application {
    private void abrirVentanaOpciones() {
        Stage opcionesStage = new Stage();
        opcionesStage.setTitle("Opciones avanzadas");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(15);

        Image img = new Image("/job297-ploy-17c-pink-01.jpg");
        BackgroundImage fondo = new BackgroundImage(
                img, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO,
                        false, false, true, true)
        );
        grid.setBackground(new Background(fondo));

        Label bio = new Label("Acerca de ti:");
        bio.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
        TextArea txtBio = new TextArea();
        txtBio.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px; -fx-background-radius: 8; -fx-border-color: #6a5acd; -fx-border-radius: 8; -fx-padding: 6;");
        grid.add(bio, 0, 1);
        grid.add(txtBio, 1, 1, 2, 1);

        Label orientacion = new Label("Orientación sexual:");
        orientacion.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
        ComboBox<String> comboOrientacion = new ComboBox<>();
        comboOrientacion.getItems().addAll("Heterosexual", "Homosexual", "Bisexual", "Pansexual", "Otro");
        comboOrientacion.setPromptText("Seleccione su orientación");
        grid.add(orientacion, 0, 2);
        grid.add(comboOrientacion, 1, 2);

        Label hobbies = new Label("Hobbies:");
        hobbies.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
        TextField txtHobbies = new TextField();
        txtHobbies.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px; -fx-background-radius: 8; -fx-border-color: #6a5acd; -fx-border-radius: 8; -fx-padding: 6;");
        grid.add(hobbies, 0, 3);
        grid.add(txtHobbies, 1, 3, 2, 1);

        Label actividades = new Label("Actividades favoritas:");
        actividades.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
        TextField txtActividades = new TextField();
        txtActividades.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px; -fx-background-radius: 8; -fx-border-color: #6a5acd; -fx-border-radius: 8; -fx-padding: 6;");
        grid.add(actividades, 0, 4);
        grid.add(txtActividades, 1, 4, 2, 1);

        Label estilo = new Label("Estilo de vida:");
        estilo.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
        TextField txtEstilo = new TextField();
        txtEstilo.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px; -fx-background-radius: 8; -fx-border-color: #6a5acd; -fx-border-radius: 8; -fx-padding: 6;");
        grid.add(estilo, 0, 5);
        grid.add(txtEstilo, 1, 5, 2, 1);

        Label visibilidad = new Label("Visibilidad del perfil:");
        visibilidad.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
        ComboBox<String> comboVisibilidad = new ComboBox<>();
        comboVisibilidad.getItems().addAll("Público", "Solo coincidencias", "Privado");
        comboVisibilidad.setPromptText("Seleccione su preferencia");
        grid.add(visibilidad, 0, 6);
        grid.add(comboVisibilidad, 1, 6);


        Label rangoEdad = new Label("Rango de edad preferido:");
        rangoEdad.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
        Slider sliderEdad = new Slider(18, 60, 25);
        sliderEdad.setShowTickLabels(true);
        sliderEdad.setShowTickMarks(true);
        sliderEdad.setMajorTickUnit(10);
        sliderEdad.setMinorTickCount(4);
        sliderEdad.setBlockIncrement(1);

        Label edadSeleccionada = new Label("Edad seleccionada: 25");
        edadSeleccionada.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");

        sliderEdad.valueProperty().addListener((obs, oldVal, newVal) -> {
            edadSeleccionada.setText("Edad seleccionada: " + newVal.intValue());
        });

        grid.add(rangoEdad, 0, 7);
        grid.add(sliderEdad, 1, 7);
        grid.add(edadSeleccionada, 2, 7);


        Button guardar = new Button("Guardar cambios");
        guardar.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 10;");
        grid.add(guardar, 1, 8);

        guardar.setOnAction(actionEvent -> {
            ((Stage) guardar.getScene().getWindow()).close();
        });

        Scene escenaOpciones = new Scene(grid, 950, 450);
        opcionesStage.setScene(escenaOpciones);
        opcionesStage.show();
    }

    private void contenido() {
        Stage opcionesStage = new Stage();
        opcionesStage.setTitle("Pagina principal");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(15);

        Label filtroGenero = new Label("Filtro de genero:");
        filtroGenero.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
        ComboBox<String> comboGenero = new ComboBox<>();
        comboGenero.getItems().addAll("Todos", "Masculino", "Femenino", "Otro");
        comboGenero.setValue("Todos");
        grid.add(filtroGenero, 0, 0);
        grid.add(comboGenero, 1, 0);

        Label filtroDeEdad = new Label("Filtro de edad:");
        filtroDeEdad.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
        Slider sliderEdad = new Slider(18, 60, 25);
        sliderEdad.setShowTickLabels(true);
        sliderEdad.setShowTickMarks(true);
        Label edadSeleccionada = new Label("Edad seleccionada: 25");
        edadSeleccionada.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");

        sliderEdad.valueProperty().addListener((obs, oldVal, newVal) -> {
            edadSeleccionada.setText("Edad seleccionada: " + newVal.intValue());
        });
        grid.add(filtroDeEdad, 0, 1);
        grid.add(sliderEdad, 1, 1);
        grid.add(edadSeleccionada, 2, 1);

        Label listaCercano = new Label("Usuarios cercanos:");
        listaCercano.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
        ListView<String> listaUsuarios = new ListView<>();
        listaUsuarios.setStyle("-fx-background-color: white; -fx-border-color: #6a5acd; -fx-border-radius: 8; -fx-background-radius: 8; -fx-font-size: 14px; -fx-text-fill: black;");
        listaUsuarios.getItems().addAll(
                "Ana - 25 años - cp 2400",
                "Joaquin - 30 años - cp 24100",
                "Luis - 28 años - cp 24123",
                "Maria - 40 años - cp 24389"
        );
        grid.add(listaCercano, 0, 2);
        grid.add(listaUsuarios, 1, 2, 2, 1);
        Button btnContactar = new Button("Contactar usuario");
        btnContactar.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 10;");
        btnContactar.setOnAction(e -> {
            String seleccionado = listaUsuarios.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                abrirFormularioContacto(seleccionado);
            } else {
                System.out.println("No se seleccionó ningún usuario.");
            }
        });
        grid.add(btnContactar, 1, 3);

        Button myMsj = new Button("Mis mensajes");
        myMsj.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 10;");
        myMsj.setOnAction(ñ -> {
            abrirMensajesRecibidos();
        });
        grid.add(myMsj, 2, 3);


        Image img = new Image("/job297-ploy-17c-pink-01.jpg");
        BackgroundImage fondo = new BackgroundImage(
                img, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO,
                        false, false, true, true)
        );
        grid.setBackground(new Background(fondo));


        Scene escenaOpciones = new Scene(grid, 530, 300);
        opcionesStage.setScene(escenaOpciones);
        opcionesStage.show();
    }

    private void abrirMensajesRecibidos() {
        Stage contactoStage = new Stage();
        contactoStage.setTitle("Bandeja de entrada.");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(15);

        Label titulo = new Label("Tus mensajes:");
        titulo.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
        ListView<String> listaMensajes = new ListView<>();
        listaMensajes.setStyle("-fx-background-color: white; -fx-border-color: #6a5acd; -fx-border-radius: 8; -fx-background-radius: 8; -fx-font-size: 14px; -fx-text-fill: black;");
        listaMensajes.getItems().addAll(
                "Ana quiere contactarte.",
                "Luis te envío un mensaje.",
                "Maria quiere conocerte."
        );
        Button open = new Button("Abrir");
        open.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 10;");
        open.setOnAction(r -> {
            String seleccionado = listaMensajes.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                abrirDetalleMensaje(seleccionado);
            }
        });
        grid.add(titulo, 0, 0);
        grid.add(listaMensajes, 1, 0, 2, 1);
        grid.add(open, 1, 1);

        Image img = new Image("/job297-ploy-17c-pink-01.jpg");
        BackgroundImage fondo = new BackgroundImage(
                img, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO,
                        false, false, true, true)
        );

        grid.setBackground(new Background(fondo));
        Scene escenaOpciones = new Scene(grid, 490, 150);
        contactoStage.setScene(escenaOpciones);
        contactoStage.show();
    }

    private void abrirDetalleMensaje(String mensaje) {
        Stage detalleStage = new Stage();
        detalleStage.setTitle("Detalle del mensaje");

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);

        Label lblMensaje = new Label("Mensaje recibido: " + mensaje);
        lblMensaje.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");

        Button btnAceptar = new Button("Aceptar");
        btnAceptar.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 10;");
        Button btnRechazar = new Button("Rechazar");
        btnRechazar.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-background-radius: 10;");

        btnAceptar.setOnAction(e -> {
            Label contacto = new Label("Datos de contacto: usuario@mail.com");
            contacto.setStyle("-fx-font-size: 14px; -fx-text-fill: yellow;");
            layout.getChildren().add(contacto);
            abrirFormularioContacto(mensaje);
            detalleStage.close();
        });

        btnRechazar.setOnAction(e -> detalleStage.close());

        layout.getChildren().addAll(lblMensaje, btnAceptar, btnRechazar);

        Scene escena = new Scene(layout, 400, 250);
        detalleStage.setScene(escena);
        detalleStage.show();
    }


    private void abrirFormularioContacto(String seleccionado) {
        Stage contactoStage = new Stage();
        contactoStage.setTitle("Mensajeria.");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(15);


        Image img = new Image("/job297-ploy-17c-pink-01.jpg");
        BackgroundImage fondo = new BackgroundImage(
                img, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO,
                        false, false, true, true)
        );
        Label medioContacto = new Label("Elige el medio de contacto");
        medioContacto.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
        ToggleGroup grupoContacto = new ToggleGroup();
        RadioButton conTelefono = new RadioButton("Telefono.");
        conTelefono.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");
        conTelefono.setToggleGroup(grupoContacto);
        RadioButton conCorreo = new RadioButton("Correo electronico.");
        conCorreo.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");
        conCorreo.setToggleGroup(grupoContacto);
        RadioButton conRedes = new RadioButton("Redes sociales");
        conRedes.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");
        conRedes.setToggleGroup(grupoContacto);
        RadioButton conPersona = new RadioButton("En persona");
        conPersona.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");
        conPersona.setToggleGroup(grupoContacto);
        grid.add(medioContacto, 0, 0);
        grid.add(conTelefono, 1, 0);
        grid.add(conCorreo, 2, 0);
        grid.add(conRedes, 1, 1);
        grid.add(conPersona, 2, 1);

        Label labMsj = new Label("Escribe tu mensaje:");
        labMsj.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
        TextArea textMsj = new TextArea();
        textMsj.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px; -fx-background-radius: 8; -fx-border-color: #6a5acd; -fx-border-radius: 8; -fx-padding: 6;");
        textMsj.setPrefSize(300, 100);
        grid.add(labMsj, 0, 2);
        grid.add(textMsj, 1, 2, 2, 1);

        Button enviar = new Button("Enviar");
        enviar.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 10;");
        Button cancelar = new Button("Cancelar");
        cancelar.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-background-radius: 10;");

        grid.add(enviar, 1, 3);
        grid.add(cancelar, 2, 3);

        enviar.setOnAction(ñ -> {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Solicitud enviada");
            alerta.setHeaderText(null);
            alerta.setContentText("Tu mensaje ha sido enviado a " + seleccionado + " correctamente.");
            alerta.showAndWait();
            contactoStage.close();
        });

        cancelar.setOnAction(p -> {
            contactoStage.close();
        });


        grid.setBackground(new Background(fondo));
        Scene escenaOpciones = new Scene(grid, 550, 300);
        contactoStage.setScene(escenaOpciones);
        contactoStage.show();
    }

    private void abrirVentanaPerfil() {
        Stage perfilStage = new Stage();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(15);
        Image img = new Image("/job297-ploy-17c-pink-01.jpg");
        BackgroundImage fondo = new BackgroundImage(
                img, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO,
                        false, false, true, true));
        Label apodo = new Label("Apodo del usuario:");
        apodo.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
        TextField txtApodo = new TextField();
        txtApodo.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px; -fx-background-radius: 8; -fx-border-color: #6a5acd; -fx-border-radius: 8; -fx-padding: 6;");
        grid.add(apodo, 0, 1);
        grid.add(txtApodo, 1, 1, 2, 1);

        Label pine = new Label("Añada su foto (Minimo 3 y Maximo 6)");
        pine.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
        Button btnPine = new Button("Subir imagen");
        Button btnPine2 = new Button("Tomar una foto");
        Button addPhoto = new Button("Añadir una foto");
        Button supPhoto = new Button("Eliminar una foto");
        grid.add(pine, 0, 3);
        grid.add(btnPine, 1, 3);
        grid.add(btnPine2, 2, 3);
        grid.add(addPhoto, 1, 4);
        grid.add(supPhoto, 2, 4);

        Label cp = new Label("Codigo postal");
        cp.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
        TextField txtCp = new TextField();
        txtCp.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px; -fx-background-radius: 8; -fx-border-color: #6a5acd; -fx-border-radius: 8; -fx-padding: 6;");
        grid.add(cp, 0, 5);
        grid.add(txtCp, 1, 5, 2, 1);

        Button continuar = new Button("Continuar");
        continuar.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 10;");
        Button otherOpcion = new Button("Más opciones");
        otherOpcion.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-background-radius: 10;");
        grid.add(continuar, 0, 6);
        grid.add(otherOpcion, 1, 6);

        otherOpcion.setOnAction(e -> {
            abrirVentanaOpciones();
        });
        continuar.setOnAction(actionEvent -> {
            contenido();
        });


        perfilStage.setTitle("Editar perfil");
        grid.setBackground(new Background(fondo));
        Scene escenaNueva = new Scene(grid, 650, 370);
        perfilStage.setScene(escenaNueva);
        perfilStage.show();
    }

    public void start(Stage stage) throws Exception {
        //imagen
        Image img = new Image("/job297-ploy-17c-pink-01.jpg");
        BackgroundImage fondo = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO,
                        false, false, true, true));


        //Contenido pagina uno

        //formas de iniciar sesión
        Label user = new Label("Bienvenid@ por favor, indique que método usara para entrar a la app.");
        user.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
        //google
        Image IconoGoogle = new Image("/iconoGoogle.png");
        ImageView Google = new ImageView(IconoGoogle);
        Google.setFitHeight(32);
        Google.setFitWidth(32);
        Button btnGoogle = new Button("", Google);
        btnGoogle.setStyle("-fx-background-radius: 20; -fx-padding; 5;");

        btnGoogle.setOnAction(e -> {
            Stage escena = new Stage();
            escena.setTitle("Inicio de sesión por Google");
            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(20);
            grid.setVgap(15);
            Label Correo = new Label("Correo: ");
            Correo.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
            TextField txtCorreo = new TextField();
            txtCorreo.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px; -fx-background-radius: 8; -fx-border-color: #6a5acd; -fx-border-radius: 8; -fx-padding: 6;");
            grid.add(Correo, 0, 1);
            grid.add(txtCorreo, 1, 1);

            Label Contraseña = new Label("Contraseña:");
            Contraseña.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
            TextField txtContraseña = new TextField();
            txtContraseña.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px; -fx-background-radius: 8; -fx-border-color: #6a5acd; -fx-border-radius: 8; -fx-padding: 6;");

            grid.add(Contraseña, 0, 2);
            grid.add(txtContraseña, 1, 2);

            CheckBox condiciones = new CheckBox("Acepta las condiciones del servicio");
            condiciones.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");
            grid.add(condiciones, 0, 3);

            Button aceptar = new Button("Acepar");
            aceptar.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 10;");
            Button negar = new Button("Cancelar");
            negar.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-background-radius: 10;");
            grid.add(aceptar, 0, 4);
            grid.add(negar, 1, 4);

            aceptar.setOnAction(r -> {
                abrirVentanaPerfil();
            });

            negar.setOnAction(w -> {
                ((Stage) negar.getScene().getWindow()).close();
            });

            grid.setAlignment(Pos.CENTER);
            grid.setBackground(new Background(fondo));
            Scene escenaNueva = new Scene(grid, 600, 300);
            grid.setVgap(20);
            grid.setVgap(15);
            escena.setScene(escenaNueva);
            escena.show();
        });

        //facebook
        Image IconoFacebook = new Image("/iconoFacebook.png");
        ImageView Facebook = new ImageView(IconoFacebook);
        Facebook.setFitWidth(32);
        Facebook.setFitHeight(32);
        Button btnFacebook = new Button("", Facebook);
        btnFacebook.setStyle("-fx-background-radius: 20; -fx-padding; 5;");

        btnFacebook.setOnAction(e -> {
            Stage escena = new Stage();
            escena.setTitle("Inicio de sesión por Facebook");
            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(20);
            grid.setVgap(15);
            Label Correo = new Label("Correo: ");
            Correo.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
            TextField txtCorreo = new TextField();
            txtCorreo.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px; -fx-background-radius: 8; -fx-border-color: #6a5acd; -fx-border-radius: 8; -fx-padding: 6;");
            grid.add(Correo, 0, 1);
            grid.add(txtCorreo, 1, 1);

            Label Contraseña = new Label("Contraseña:");
            Contraseña.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
            TextField txtContraseña = new TextField();
            txtContraseña.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px; -fx-background-radius: 8; -fx-border-color: #6a5acd; -fx-border-radius: 8; -fx-padding: 6;");

            grid.add(Contraseña, 0, 2);
            grid.add(txtContraseña, 1, 2);

            CheckBox condiciones = new CheckBox("Acepta las condiciones del servicio");
            condiciones.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");
            grid.add(condiciones, 0, 3);

            Button aceptar = new Button("Acepar");
            aceptar.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 10;");
            Button negar = new Button("Cancelar");
            negar.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-background-radius: 10;");
            grid.add(aceptar, 0, 4);
            grid.add(negar, 1, 4);

            aceptar.setOnAction(k -> {
                abrirVentanaPerfil();
            });

            negar.setOnAction(w -> {
                ((Stage) negar.getScene().getWindow()).close();
            });
            grid.setBackground(new Background(fondo));

            Scene sceneNew = new Scene(grid, 600, 300);
            escena.setScene(sceneNew);
            escena.show();
        });


        Image iconoGmail = new Image("/iconoGmail.png");
        ImageView Gmail = new ImageView(iconoGmail);
        Gmail.setFitHeight(32);
        Gmail.setFitWidth(32);
        Button btnGmail = new Button("", Gmail);
        btnGmail.setStyle("-fx-background-radius: 20; -fx-padding; 5;");

        btnGmail.setOnAction(e -> {
            Stage escena = new Stage();
            escena.setTitle("Inicio de sesión por instagram");
            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(20);
            grid.setVgap(15);
            Label Correo = new Label("Correo: ");
            Correo.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
            TextField txtCorreo = new TextField();
            txtCorreo.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px; -fx-background-radius: 8; -fx-border-color: #6a5acd; -fx-border-radius: 8; -fx-padding: 6;");
            grid.add(Correo, 0, 1);
            grid.add(txtCorreo, 1, 1);

            Label Contraseña = new Label("Contraseña:");
            Contraseña.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
            TextField txtContraseña = new TextField();
            txtContraseña.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px; -fx-background-radius: 8; -fx-border-color: #6a5acd; -fx-border-radius: 8; -fx-padding: 6;");

            grid.add(Contraseña, 0, 2);
            grid.add(txtContraseña, 1, 2);

            CheckBox condiciones = new CheckBox("Acepta las condiciones del servicio");
            condiciones.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");
            grid.add(condiciones, 0, 3);

            Button aceptar = new Button("Acepar");
            aceptar.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 10;");
            Button negar = new Button("Cancelar");
            negar.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-background-radius: 10;");
            grid.add(aceptar, 0, 4);
            grid.add(negar, 1, 4);

            aceptar.setOnAction(k -> {
                abrirVentanaPerfil();
            });
            negar.setOnAction(w -> {
                ((Stage) negar.getScene().getWindow()).close();
            });
            grid.setBackground(new Background(fondo));
            Scene escenaNew = new Scene(grid, 600, 300);
            escena.setScene(escenaNew);
            escena.show();
        });

        Image iconoSms = new Image("/iconoSms.png");
        ImageView Sms = new ImageView(iconoSms);
        Sms.setFitWidth(32);
        Sms.setFitHeight(32);
        Button btnSms = new Button("", Sms);
        btnSms.setStyle("-fx-background-radius: 20; -fx-padding; 5;");

        btnSms.setOnAction(e -> {
            Stage escena = new Stage();
            escena.setTitle("Inicio de sesión por SMS");
            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(20);
            grid.setVgap(15);
            Label Correo = new Label("Número de celular:");
            Correo.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
            TextField txtCorreo = new TextField();
            txtCorreo.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px; -fx-background-radius: 8; -fx-border-color: #6a5acd; -fx-border-radius: 8; -fx-padding: 6;");
            grid.add(Correo, 0, 1);
            grid.add(txtCorreo, 1, 1);

            Label Contraseña = new Label("Contraseña:");
            Contraseña.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
            TextField txtContraseña = new TextField();
            txtContraseña.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px; -fx-background-radius: 8; -fx-border-color: #6a5acd; -fx-border-radius: 8; -fx-padding: 6;");

            grid.add(Contraseña, 0, 2);
            grid.add(txtContraseña, 1, 2);

            CheckBox condiciones = new CheckBox("Acepta las condiciones del servicio");
            condiciones.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");
            grid.add(condiciones, 0, 3);

            Button aceptar = new Button("Acepar");
            aceptar.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 10;");
            Button negar = new Button("Cancelar");
            negar.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-background-radius: 10;");
            grid.add(aceptar, 0, 4);
            grid.add(negar, 1, 4);

            aceptar.setOnAction(f -> {
                abrirVentanaPerfil();
            });
            negar.setOnAction(w -> {
                ((Stage) negar.getScene().getWindow()).close();
            });
            grid.setBackground(new Background(fondo));
            Scene escenaNew = new Scene(grid, 600, 300);
            escena.setScene(escenaNew);
            escena.show();
        });

        //opciones si de crear o ya eres usuario
        Label Metodo = new Label("Si usted tiene o quiere crear una por favor seleccione una opción: ");
        Metodo.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
        Button nuevo = new Button("Nuevo usuario");
        nuevo.setStyle("-fx-font-size: 18px; -fx-background-radius: 20;");
        Button old = new Button("Registrarse");
        old.setStyle("-fx-font-size: 18px; -fx-background-radius: 20;");

        nuevo.setOnAction(e -> {
            Stage nuevoEscena = new Stage();
            nuevoEscena.setTitle("Bienvenido nuevo.");

            // GridPane para organizar en dos columnas
            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(20);
            grid.setVgap(15);

            // Nombres
            Label lblNombres = new Label("Nombres:");
            lblNombres.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
            TextField txtNombres = new TextField();
            txtNombres.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px; -fx-background-radius: 8; -fx-border-color: #6a5acd; -fx-border-radius: 8; -fx-padding: 6;");
            grid.add(lblNombres, 0, 0);
            grid.add(txtNombres, 1, 0);

            // Apellidos
            Label lblApellidos = new Label("Apellidos:");
            lblApellidos.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
            TextField txtApellidos = new TextField();
            txtApellidos.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px; -fx-background-radius: 8; -fx-border-color: #6a5acd; -fx-border-radius: 8; -fx-padding: 6;");
            grid.add(lblApellidos, 0, 1);
            grid.add(txtApellidos, 1, 1);

            //Correo
            Label correo = new Label("Ingrese su correo");
            correo.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
            TextField tntCorreo = new TextField("");
            tntCorreo.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px; -fx-background-radius: 8; -fx-border-color: #6a5acd; -fx-border-radius: 8; -fx-padding: 6;");
            grid.add(correo, 0, 2);
            grid.add(tntCorreo, 1, 2);

            // Contraseña
            Label lblContra = new Label("Contraseña:");
            lblContra.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
            TextField txtContra = new TextField();
            txtContra.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px; -fx-background-radius: 8; -fx-border-color: #6a5acd; -fx-border-radius: 8; -fx-padding: 6;");
            grid.add(lblContra, 0, 3);
            grid.add(txtContra, 1, 3);

            // Confirmar contraseña
            Label lblRContra = new Label("Confirme la contraseña:");
            lblRContra.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
            TextField txtRContra = new TextField();
            txtRContra.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px; -fx-background-radius: 8; -fx-border-color: #6a5acd; -fx-border-radius: 8; -fx-padding: 6;");
            grid.add(lblRContra, 0, 4);
            grid.add(txtRContra, 1, 4);

            // Género (ComboBox)
            Label lblGenero = new Label("Género:");
            lblGenero.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
            ComboBox<String> comboGenero = new ComboBox<>();
            comboGenero.getItems().addAll("Masculino", "Femenino", "Otro");
            comboGenero.setPromptText("Seleccione su género");
            grid.add(lblGenero, 0, 5);
            grid.add(comboGenero, 1, 5);

            // Términos y condiciones
            CheckBox condicion = new CheckBox("Usted acepta los términos y condiciones");
            condicion.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");
            grid.add(condicion, 0, 6, 2, 1);

            // Botón aceptar
            Button aceptar = new Button("Ingresar");
            aceptar.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 10;");
            grid.add(aceptar, 0, 7);
            Button negar = new Button("Volver");
            negar.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-background-radius: 10;");
            grid.add(negar, 1, 7);

            aceptar.setOnAction(f -> {
                abrirVentanaPerfil();
            });

            negar.setOnAction(r -> {
                ((Stage) negar.getScene().getWindow()).close();
            });


            //fondo
            grid.setBackground(new Background(fondo));
            Scene escenaNuevo = new Scene(grid, 435, 450);
            nuevoEscena.setScene(escenaNuevo);
            nuevoEscena.show();

        });

        old.setOnAction(e -> {
            Stage nuevoEscena = new Stage();
            nuevoEscena.setTitle("Bienvenido de regreso.");
            Label msjNuevo = new Label("Cuenta o número celular:");
            msjNuevo.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
            TextField txtNuevo = new TextField("");
            txtNuevo.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px; -fx-background-radius: 8; -fx-border-color: #6a5acd; -fx-border-radius: 8; -fx-padding: 6;");

            Label msjContra = new Label("Contraseña:");
            msjContra.setStyle("-fx-font-size: 18px; -fx-text-fill: White; -fx-font-weight: bold;");
            TextField txtContra = new TextField("");
            txtContra.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px; -fx-background-radius: 8; -fx-border-color: #6a5acd; -fx-border-radius: 8; -fx-padding: 6;");

            CheckBox condicion = new CheckBox("Usted acepta los términos y condiciones");
            condicion.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");
            condicion.setAlignment(Pos.CENTER);
            Button aceptar = new Button("Ingresar");
            aceptar.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 10;");
            aceptar.setAlignment(Pos.CENTER);
            Button negar = new Button("Volver");
            negar.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-background-radius: 10;");

            aceptar.setOnAction(l -> {
                abrirVentanaPerfil();
            });

            negar.setOnAction(r -> {
                ((Stage) negar.getScene().getWindow()).close();
            });
            HBox leyout = new HBox(20, msjNuevo, txtNuevo);
            leyout.setAlignment(Pos.CENTER);
            HBox leyoutContra = new HBox(20, msjContra, txtContra);
            leyoutContra.setAlignment(Pos.TOP_RIGHT);
            HBox btn = new HBox(20, aceptar, negar);
            btn.setAlignment(Pos.CENTER);
            VBox completo = new VBox(20, leyout, leyoutContra, condicion, btn);
            completo.setBackground(new Background(fondo));
            completo.setAlignment(Pos.CENTER);
            Scene escenaNuevo = new Scene(completo, 408, 300);
            nuevoEscena.setScene(escenaNuevo);
            nuevoEscena.show();
        });

        //terminos y soporte
        Label terminos = new Label("Consulte:");
        terminos.setStyle("-fx-font-size: 18px; -fx-text-fill: Blue; -fx-font-weight: bold;");

        terminos.setOnMouseClicked(e -> {
            try {
                InputStream input = getClass().getResourceAsStream("/miArchivo.txt");
                if (input != null) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder contenido = new StringBuilder();
                    String linea;
                    while ((linea = reader.readLine()) != null) {
                        contenido.append(linea).append("\n");
                    }
                    reader.close();

                    Stage ventanaTxt = new Stage();
                    ventanaTxt.setTitle("Términos y condiciones");

                    TextArea areaTexto = new TextArea(contenido.toString());
                    areaTexto.setEditable(false);

                    VBox layout = new VBox(areaTexto);
                    Scene escenaTxt = new Scene(layout, 1300, 240);

                    ventanaTxt.setScene(escenaTxt);
                    ventanaTxt.show();
                } else {
                    System.out.println("Archivo no encontrado en resources.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });


        Label soporte = new Label("Ayuda en:");
        soporte.setStyle("-fx-font-size: 18px; -fx-text-fill: Blue; -fx-font-weight: bold;");

        soporte.setOnMouseClicked(e -> {
            try {
                InputStream input = getClass().getResourceAsStream("/miArchivo2.txt");
                if (input != null) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder contenido = new StringBuilder();
                    String linea;
                    while ((linea = reader.readLine()) != null) {
                        contenido.append(linea).append("\n");
                    }
                    reader.close();

                    Stage ventanaTxt = new Stage();
                    ventanaTxt.setTitle("Ayuda y asistencia.");

                    TextArea areaTexto = new TextArea(contenido.toString());
                    areaTexto.setEditable(false);

                    VBox layout = new VBox(areaTexto);
                    Scene escenaTxt = new Scene(layout, 1300, 240);

                    ventanaTxt.setScene(escenaTxt);
                    ventanaTxt.show();
                } else {
                    System.out.println("Archivo no encontrado en resources.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });


        HBox filaRedes = new HBox(10, btnGoogle, btnFacebook, btnGmail, btnSms);
        HBox filaNew = new HBox(20, nuevo, old);
        HBox leyes = new HBox(20, terminos);
        HBox ayuda = new HBox(20, soporte);

        filaRedes.setAlignment(Pos.CENTER);
        filaNew.setAlignment(Pos.CENTER);
        leyes.setAlignment(Pos.BOTTOM_CENTER);
        ayuda.setAlignment(Pos.BOTTOM_CENTER);


        VBox ContenidoCentral = new VBox(20, user, filaRedes, Metodo, filaNew, terminos, leyes, soporte, ayuda);
        ContenidoCentral.setAlignment(Pos.CENTER);

        VBox ContenidoInferior = new VBox(terminos, soporte);
        ContenidoInferior.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setCenter(ContenidoCentral);
        root.setBottom(ContenidoInferior);
        root.setBackground(new Background(fondo));

        Scene escena = new Scene(root, 600, 360);
        stage.setTitle("DEMO");
        stage.setScene(escena);
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}