package View;
import Model.*;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import Control.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
        
public class MainFrame extends javax.swing.JFrame {
    public MainFrame() {
        initComponents();
        loadMainMenu();
    }
    
    //Global variables
    Account userAccount;
    ArrayList<Movie> menuMovies;
    ArrayList<Series> menuSeries;
    String previousCard;
    
    private <T> DefaultListModel buildListModel(ArrayList<T> arrList) {
        DefaultListModel listModel = new DefaultListModel();
        try{
            for (T element : arrList) {
                listModel.addElement(element);
            }
        }
        catch (Exception e) {
            System.out.println("Couldn't fetch countries: " + e);
        }
        return listModel;
    }
    
    private <T> DefaultComboBoxModel buildComboModel(ArrayList<T> list) {
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        try {
            for (T element : list) {
                comboModel.addElement(element);
            }
        }
        catch (Exception e) {
            System.out.println("Couldn't fetch countries: " + e);
        }
        return comboModel;
    }
    
    private void setLabelIcon(JLabel label, String path) {
    //Receives a label and an image path, sets the label's icon to the image.
        File file = new File(path);
        BufferedImage originalImage = null;
        try {
            originalImage = ImageIO.read(file);
        }
        catch (Exception e) {
            showError("Error al cargar imagen");
        }
        int maxWidth = label.getWidth(); 
        int maxHeight = label.getHeight(); 
        Image scaledImage = originalImage.getScaledInstance(maxWidth, maxHeight, Image.SCALE_SMOOTH);
        // Create a new ImageIcon
        ImageIcon icon = new ImageIcon(scaledImage);
        label.setIcon(icon);
    }
    
    private void loadMainMenu() {
    //Loads movies and series to the main menu.
        try {
            menuMovies = Cursors.getNmovies(5);
        }
        catch (Exception e) {
            System.out.println(e);
            showError("Error al recuperar productos.");
            return;
        }
        try {
            if (menuMovies.size() < 1) return;
            movie1_name.setText(menuMovies.get(0).getName());
            setLabelIcon(movie1_img, Cursors.getProductMainImg(menuMovies.get(0).getIdProduct()));
            if (menuMovies.size() < 2) return;
            movie2_name.setText(menuMovies.get(1).getName());
            setLabelIcon(movie2_img, Cursors.getProductMainImg(menuMovies.get(1).getIdProduct()));
            if (menuMovies.size() < 3) return;
            movie3_name.setText(menuMovies.get(2).getName());
            setLabelIcon(movie3_img, Cursors.getProductMainImg(menuMovies.get(2).getIdProduct()));
            if (menuMovies.size() < 4) return;
            movie4_name.setText(menuMovies.get(3).getName());
            setLabelIcon(movie4_img, Cursors.getProductMainImg(menuMovies.get(3).getIdProduct()));
            if (menuMovies.size() < 5) return;
            movie5_name.setText(menuMovies.get(4).getName());
            setLabelIcon(movie5_img, Cursors.getProductMainImg(menuMovies.get(4).getIdProduct()));
        }
        catch (Exception e) {
        
        }
        
        
    }
    
    private void showError(String error) {
        ErrorDialog.pack();
        ErrorDialogTxt.setText(error);
        ErrorDialog.setVisible(true);
    }
    
    private void viewMovie(Product product) {
    //Opens view page for movie with index.
        ArrayList<Integer> artistIds;
        try {
            setLabelIcon(movie_img, Cursors.getProductMainImg(product.getId()));
            artistIds = Cursors.getArtistsInProduct(product.getId());
        }
        catch (Exception e) {
            showError("Error al cargar película.");
            return;
        }
        DefaultListModel actorsModel = new DefaultListModel();
        DefaultListModel writersModel = new DefaultListModel();
        for (Integer i : artistIds) {
            Artist artist;
            try {
                artist = Cursors.getArtist(i);
            }
            catch (Exception e) {
                showError("Error al recuperar artista.");
                System.out.println(e);
                continue;
            }
            System.out.println(artist.getId_artistType());
            if (artist.getId_artistType() == 1) {
                actorsModel.addElement(artist);
            }
            else if (artist.getId_artistType() == 3) {
                writersModel.addElement(artist);
            }
            else if (artist.getId_artistType() == 2) {
                movie_director.setText(artist.getName());
            }
        }
        movie_actors.setModel(actorsModel);
        movie_writers.setModel(writersModel);
        movie_title.setText(product.getTitle());
        movie_synopsis.setText(product.getSynopsis());
        movie_premier.setText("Estreno: " + Integer.toString(product.getPremier()));
        CardLayout card = (CardLayout) MainPanel.getLayout();
        card.show(MainPanel, "ViewMovie");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel20 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        ErrorDialog = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        ErrorDialogTxt = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        MainPanel = new javax.swing.JPanel();
        MainMenu = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        MainMenuLbl = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        MainMenu_SignInButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        movie1_img = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jButton29 = new javax.swing.JButton();
        movie1_name = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        series1_img = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jButton31 = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        movie2_img = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jButton39 = new javax.swing.JButton();
        movie2_name = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        movie3_img = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jButton40 = new javax.swing.JButton();
        movie3_name = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        movie4_img = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jButton41 = new javax.swing.JButton();
        movie4_name = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        movie5_img = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jButton42 = new javax.swing.JButton();
        movie5_name = new javax.swing.JLabel();
        jButton38 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        SearchResults = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        MainMenuLbl1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        MainMenu_SignInButton1 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jLabel69 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        movie1_img1 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jButton32 = new javax.swing.JButton();
        movie1_name1 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        movie2_img1 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jButton43 = new javax.swing.JButton();
        movie2_name1 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        movie3_img1 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jButton44 = new javax.swing.JButton();
        movie3_name1 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        movie4_img1 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jButton45 = new javax.swing.JButton();
        movie4_name1 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        movie5_img1 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jButton46 = new javax.swing.JButton();
        movie5_name1 = new javax.swing.JLabel();
        AdminPage = new javax.swing.JPanel();
        AdminMenu = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        AdmMenuBackBtn = new javax.swing.JButton();
        CountriesButton2 = new javax.swing.JButton();
        CountriesButton3 = new javax.swing.JButton();
        CountriesButton4 = new javax.swing.JButton();
        EditCountries = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        EditCountries_CountryList = new javax.swing.JList<>();
        AddCountryBtn = new javax.swing.JButton();
        RemoveCountryBtn = new javax.swing.JButton();
        EditCountBackBtn = new javax.swing.JButton();
        NewCountryTxtfield = new javax.swing.JTextField();
        EditArtists = new javax.swing.JPanel();
        EditArtistsMenu = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        EditArtists_ActorsList = new javax.swing.JList<>();
        EditCountBackBtn1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        EditArtists_DirectorsList = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        EditArtists_WritersList = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        AddArtist = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        addArtist_nameTxt = new javax.swing.JTextField();
        addArtist_lastnameTxt = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        addArtist_genderCombo = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        addArtist_height = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        addArtist_typeCombo = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        addArtist_bioTxt = new javax.swing.JTextArea();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        addArtist_triviaTxt = new javax.swing.JTextArea();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        addArtist_date = new com.toedter.calendar.JDateChooser();
        jLabel45 = new javax.swing.JLabel();
        EditArtist = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        editArtist_nameTxt = new javax.swing.JTextField();
        editArtist_lastnameTxt = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        editArtist_genderCombo = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        editArtist_heightCombo = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        editArtist_typeCombo = new javax.swing.JComboBox<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        editArtist_bioTxt = new javax.swing.JTextArea();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        editArtist_triviaTxt = new javax.swing.JTextArea();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        editArtist_date = new com.toedter.calendar.JDateChooser();
        jLabel46 = new javax.swing.JLabel();
        EditProducts = new javax.swing.JPanel();
        editProductsMenu = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        EditProducts_movies = new javax.swing.JList<>();
        jScrollPane10 = new javax.swing.JScrollPane();
        EditProducts_series = new javax.swing.JList<>();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        EditCountBackBtn2 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        addMovie = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        addMovie_title = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        addMovie_premier = new javax.swing.JComboBox<>();
        jLabel57 = new javax.swing.JLabel();
        addMovie_trailer = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        addMovie_synopsis = new javax.swing.JTextArea();
        EditCountBackBtn3 = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        addMovie_photos = new javax.swing.JList<>();
        jLabel60 = new javax.swing.JLabel();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        addMovie_duration = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        addMovie2 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        addMovie_categoryLbl = new javax.swing.JLabel();
        addMovie_category = new javax.swing.JComboBox<>();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        addMovie_availableActors = new javax.swing.JList<>();
        jScrollPane20 = new javax.swing.JScrollPane();
        addMovie_actors = new javax.swing.JList<>();
        jLabel77 = new javax.swing.JLabel();
        jButton34 = new javax.swing.JButton();
        jScrollPane21 = new javax.swing.JScrollPane();
        addMovie_availableWriters = new javax.swing.JList<>();
        jLabel78 = new javax.swing.JLabel();
        jButton35 = new javax.swing.JButton();
        jScrollPane22 = new javax.swing.JScrollPane();
        addMovie_writers = new javax.swing.JList<>();
        jLabel79 = new javax.swing.JLabel();
        addMovie_categoryLbl1 = new javax.swing.JLabel();
        addMovie_director = new javax.swing.JComboBox<>();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        addSeries = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        addSeries_title = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        addSeries_premier = new javax.swing.JComboBox<>();
        jLabel65 = new javax.swing.JLabel();
        addSeries_trailer = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        addSeries_synopsis = new javax.swing.JTextArea();
        EditCountBackBtn4 = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        addSeries_photos = new javax.swing.JList<>();
        jLabel68 = new javax.swing.JLabel();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        SignInPage = new javax.swing.JPanel();
        LogInPage = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        login_userTxt = new javax.swing.JTextField();
        login_passwordTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        RegisterPage1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        register_lastnameTxt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        register_nameTxt = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        register_userTxt = new javax.swing.JTextField();
        register_passwordTxt = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        register_genderCombo = new javax.swing.JComboBox<>();
        Register_date = new com.toedter.calendar.JDateChooser();
        RegisterPage2 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        register_phoneTxt = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        register_emailTxt = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        register_typesCombo = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        register_idTxt = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        register_countryCombo = new javax.swing.JComboBox<>();
        ViewMovie = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        MainMenuLbl2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        MainMenu_SignInButton2 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        movie_title = new javax.swing.JLabel();
        movie_img = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        movie_synopsis = new javax.swing.JTextArea();
        movie_category = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        movie_director = new javax.swing.JButton();
        jScrollPane17 = new javax.swing.JScrollPane();
        movie_actors = new javax.swing.JList<>();
        jLabel75 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        movie_writers = new javax.swing.JList<>();
        jLabel76 = new javax.swing.JLabel();
        movie_viewActor = new javax.swing.JButton();
        movie_viewWriter = new javax.swing.JButton();
        movie_premier = new javax.swing.JLabel();
        movie_duration = new javax.swing.JLabel();
        movie_buy = new javax.swing.JButton();
        movie_favorites = new javax.swing.JButton();
        movie_trailer = new javax.swing.JButton();
        AdmMenuBackBtn1 = new javax.swing.JButton();
        AdmMenuBackBtn2 = new javax.swing.JButton();
        ViewAllProducts = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        MainMenuLbl3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        MainMenu_SignInButton3 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        viewProducts_movies = new javax.swing.JTable();
        jButton49 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jScrollPane24 = new javax.swing.JScrollPane();
        viewProducts_series = new javax.swing.JTable();

        jLabel1.setText("jLabel1");

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Usuario");

        jTextField8.setBackground(new java.awt.Color(51, 51, 51));
        jTextField8.setForeground(new java.awt.Color(255, 255, 255));

        jInternalFrame2.setVisible(true);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Error!");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        ErrorDialogTxt.setForeground(new java.awt.Color(255, 255, 255));
        ErrorDialogTxt.setText("Algo salió mal. Por favor intente de nuevo.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ErrorDialogTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ErrorDialogTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ErrorDialogLayout = new javax.swing.GroupLayout(ErrorDialog.getContentPane());
        ErrorDialog.getContentPane().setLayout(ErrorDialogLayout);
        ErrorDialogLayout.setHorizontalGroup(
            ErrorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ErrorDialogLayout.setVerticalGroup(
            ErrorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        MainPanel.setLayout(new java.awt.CardLayout());

        MainMenu.setBackground(new java.awt.Color(0, 0, 0));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));

        MainMenuLbl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        MainMenuLbl.setForeground(new java.awt.Color(255, 255, 255));
        MainMenuLbl.setText("Belphegor");

        jTextField1.setText("Buscar");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        MainMenu_SignInButton.setBackground(new java.awt.Color(51, 51, 51));
        MainMenu_SignInButton.setForeground(new java.awt.Color(255, 255, 255));
        MainMenu_SignInButton.setText("Sign In");
        MainMenu_SignInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenu_SignInButtonActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 204, 204));
        jButton2.setText("Admin");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainMenuLbl)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MainMenu_SignInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MainMenuLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MainMenu_SignInButton)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Películas");

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Series");

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Not found");

        jButton29.setBackground(new java.awt.Color(102, 102, 102));
        jButton29.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jButton29.setForeground(new java.awt.Color(255, 255, 255));
        jButton29.setText("Ver");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        movie1_name.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        movie1_name.setForeground(new java.awt.Color(255, 255, 255));
        movie1_name.setText("Not found");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(movie1_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(movie1_name, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel48)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(movie1_img, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(movie1_name)
                .addGap(8, 8, 8)
                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(51, 51, 51));

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("4.6");

        jButton31.setBackground(new java.awt.Color(102, 102, 102));
        jButton31.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jButton31.setForeground(new java.awt.Color(255, 255, 255));
        jButton31.setText("Ver");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(series1_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel66)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(series1_img, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel25.setBackground(new java.awt.Color(51, 51, 51));

        jLabel80.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setText("Not found");

        jButton39.setBackground(new java.awt.Color(102, 102, 102));
        jButton39.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jButton39.setForeground(new java.awt.Color(255, 255, 255));
        jButton39.setText("Ver");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        movie2_name.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        movie2_name.setForeground(new java.awt.Color(255, 255, 255));
        movie2_name.setText("Not found");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(movie2_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(movie2_name, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel80)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(movie2_img, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel80)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(movie2_name)
                .addGap(8, 8, 8)
                .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel26.setBackground(new java.awt.Color(51, 51, 51));

        jLabel82.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setText("Not found");

        jButton40.setBackground(new java.awt.Color(102, 102, 102));
        jButton40.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jButton40.setForeground(new java.awt.Color(255, 255, 255));
        jButton40.setText("Ver");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        movie3_name.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        movie3_name.setForeground(new java.awt.Color(255, 255, 255));
        movie3_name.setText("Not found");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(movie3_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(movie3_name, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel82)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(movie3_img, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel82)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(movie3_name)
                .addGap(8, 8, 8)
                .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel27.setBackground(new java.awt.Color(51, 51, 51));

        jLabel84.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setText("Not found");

        jButton41.setBackground(new java.awt.Color(102, 102, 102));
        jButton41.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jButton41.setForeground(new java.awt.Color(255, 255, 255));
        jButton41.setText("Ver");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        movie4_name.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        movie4_name.setForeground(new java.awt.Color(255, 255, 255));
        movie4_name.setText("Not found");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(movie4_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(movie4_name, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel84)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(movie4_img, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel84)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(movie4_name)
                .addGap(8, 8, 8)
                .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel28.setBackground(new java.awt.Color(51, 51, 51));

        jLabel86.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setText("Not found");

        jButton42.setBackground(new java.awt.Color(102, 102, 102));
        jButton42.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jButton42.setForeground(new java.awt.Color(255, 255, 255));
        jButton42.setText("Ver");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        movie5_name.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        movie5_name.setForeground(new java.awt.Color(255, 255, 255));
        movie5_name.setText("Not found");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(movie5_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(movie5_name, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel86)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(movie5_img, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel86)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(movie5_name)
                .addGap(8, 8, 8)
                .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jButton38.setBackground(new java.awt.Color(0, 0, 0));
        jButton38.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton38.setForeground(new java.awt.Color(255, 255, 255));
        jButton38.setText("Ver todas");
        jButton38.setBorder(null);
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jButton47.setBackground(new java.awt.Color(0, 0, 0));
        jButton47.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton47.setForeground(new java.awt.Color(255, 255, 255));
        jButton47.setText("Ver todas");
        jButton47.setBorder(null);
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainMenuLayout = new javax.swing.GroupLayout(MainMenu);
        MainMenu.setLayout(MainMenuLayout);
        MainMenuLayout.setHorizontalGroup(
            MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MainMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainMenuLayout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton38))
                    .addGroup(MainMenuLayout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton47))
                    .addGroup(MainMenuLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(552, Short.MAX_VALUE))
            .addGroup(MainMenuLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        MainMenuLayout.setVerticalGroup(
            MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainMenuLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jButton47, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        MainPanel.add(MainMenu, "mainMenu");

        SearchResults.setBackground(new java.awt.Color(0, 0, 0));

        jPanel15.setBackground(new java.awt.Color(51, 51, 51));

        MainMenuLbl1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        MainMenuLbl1.setForeground(new java.awt.Color(255, 255, 255));
        MainMenuLbl1.setText("Belphegor");

        jTextField2.setText("Buscar");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        MainMenu_SignInButton1.setBackground(new java.awt.Color(51, 51, 51));
        MainMenu_SignInButton1.setForeground(new java.awt.Color(255, 255, 255));
        MainMenu_SignInButton1.setText("Sign In");
        MainMenu_SignInButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenu_SignInButton1ActionPerformed(evt);
            }
        });

        jButton30.setBackground(new java.awt.Color(102, 102, 102));
        jButton30.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jButton30.setForeground(new java.awt.Color(204, 204, 204));
        jButton30.setText("Admin");
        jButton30.setBorderPainted(false);
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainMenuLbl1)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MainMenu_SignInButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MainMenuLbl1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MainMenu_SignInButton1)
                    .addComponent(jButton30))
                .addContainerGap())
        );

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Resultados:");

        jPanel16.setBackground(new java.awt.Color(51, 51, 51));

        jLabel71.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("4.6");

        jButton32.setBackground(new java.awt.Color(102, 102, 102));
        jButton32.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jButton32.setForeground(new java.awt.Color(255, 255, 255));
        jButton32.setText("Ver");

        movie1_name1.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        movie1_name1.setForeground(new java.awt.Color(255, 255, 255));
        movie1_name1.setText("Very Long Movie Title aaaaa");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(movie1_img1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(movie1_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel71)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(movie1_img1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel71)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(movie1_name1)
                .addGap(8, 8, 8)
                .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel29.setBackground(new java.awt.Color(51, 51, 51));

        jLabel81.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setText("4.6");

        jButton43.setBackground(new java.awt.Color(102, 102, 102));
        jButton43.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jButton43.setForeground(new java.awt.Color(255, 255, 255));
        jButton43.setText("Ver");

        movie2_name1.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        movie2_name1.setForeground(new java.awt.Color(255, 255, 255));
        movie2_name1.setText("Very Long Movie Title aaaaa");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(movie2_img1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(movie2_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel81)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(movie2_img1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel81)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(movie2_name1)
                .addGap(8, 8, 8)
                .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel30.setBackground(new java.awt.Color(51, 51, 51));

        jLabel83.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setText("4.6");

        jButton44.setBackground(new java.awt.Color(102, 102, 102));
        jButton44.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jButton44.setForeground(new java.awt.Color(255, 255, 255));
        jButton44.setText("Ver");

        movie3_name1.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        movie3_name1.setForeground(new java.awt.Color(255, 255, 255));
        movie3_name1.setText("Very Long Movie Title aaaaa");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(movie3_img1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(movie3_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel83)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(movie3_img1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel83)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(movie3_name1)
                .addGap(8, 8, 8)
                .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel31.setBackground(new java.awt.Color(51, 51, 51));

        jLabel85.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setText("4.6");

        jButton45.setBackground(new java.awt.Color(102, 102, 102));
        jButton45.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jButton45.setForeground(new java.awt.Color(255, 255, 255));
        jButton45.setText("Ver");

        movie4_name1.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        movie4_name1.setForeground(new java.awt.Color(255, 255, 255));
        movie4_name1.setText("Very Long Movie Title aaaaa");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(movie4_img1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(movie4_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel85)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(movie4_img1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel85)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(movie4_name1)
                .addGap(8, 8, 8)
                .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel32.setBackground(new java.awt.Color(51, 51, 51));

        jLabel87.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setText("4.6");

        jButton46.setBackground(new java.awt.Color(102, 102, 102));
        jButton46.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jButton46.setForeground(new java.awt.Color(255, 255, 255));
        jButton46.setText("Ver");

        movie5_name1.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        movie5_name1.setForeground(new java.awt.Color(255, 255, 255));
        movie5_name1.setText("Very Long Movie Title aaaaa");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(movie5_img1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(movie5_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel87)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(movie5_img1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel87)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(movie5_name1)
                .addGap(8, 8, 8)
                .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SearchResultsLayout = new javax.swing.GroupLayout(SearchResults);
        SearchResults.setLayout(SearchResultsLayout);
        SearchResultsLayout.setHorizontalGroup(
            SearchResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SearchResultsLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(SearchResultsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SearchResultsLayout.setVerticalGroup(
            SearchResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchResultsLayout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(SearchResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(140, Short.MAX_VALUE))
        );

        MainPanel.add(SearchResults, "SearchResults");

        AdminPage.setBackground(new java.awt.Color(0, 0, 0));
        AdminPage.setLayout(new java.awt.CardLayout());

        AdminMenu.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Admin");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(522, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );

        AdmMenuBackBtn.setBackground(new java.awt.Color(51, 51, 51));
        AdmMenuBackBtn.setForeground(new java.awt.Color(255, 255, 255));
        AdmMenuBackBtn.setText("Atrás");
        AdmMenuBackBtn.setBorderPainted(false);
        AdmMenuBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdmMenuBackBtnActionPerformed(evt);
            }
        });

        CountriesButton2.setBackground(new java.awt.Color(51, 51, 51));
        CountriesButton2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CountriesButton2.setForeground(new java.awt.Color(255, 255, 255));
        CountriesButton2.setText("Países");
        CountriesButton2.setBorderPainted(false);
        CountriesButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountriesButton2ActionPerformed(evt);
            }
        });

        CountriesButton3.setBackground(new java.awt.Color(51, 51, 51));
        CountriesButton3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CountriesButton3.setForeground(new java.awt.Color(255, 255, 255));
        CountriesButton3.setText("Artistas");
        CountriesButton3.setBorderPainted(false);
        CountriesButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountriesButton3ActionPerformed(evt);
            }
        });

        CountriesButton4.setBackground(new java.awt.Color(51, 51, 51));
        CountriesButton4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CountriesButton4.setForeground(new java.awt.Color(255, 255, 255));
        CountriesButton4.setText("Productos");
        CountriesButton4.setBorderPainted(false);
        CountriesButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountriesButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AdminMenuLayout = new javax.swing.GroupLayout(AdminMenu);
        AdminMenu.setLayout(AdminMenuLayout);
        AdminMenuLayout.setHorizontalGroup(
            AdminMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(AdminMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdminMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AdmMenuBackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AdminMenuLayout.createSequentialGroup()
                        .addComponent(CountriesButton3)
                        .addGap(18, 18, 18)
                        .addComponent(CountriesButton2)
                        .addGap(18, 18, 18)
                        .addComponent(CountriesButton4)))
                .addContainerGap(357, Short.MAX_VALUE))
        );
        AdminMenuLayout.setVerticalGroup(
            AdminMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminMenuLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AdminMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CountriesButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CountriesButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CountriesButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(281, 281, 281)
                .addComponent(AdmMenuBackBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        AdminPage.add(AdminMenu, "adminMenu");

        EditCountries.setBackground(new java.awt.Color(0, 0, 0));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Editar Paises");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        EditCountries_CountryList.setBackground(new java.awt.Color(51, 51, 51));
        EditCountries_CountryList.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EditCountries_CountryList.setForeground(new java.awt.Color(255, 255, 255));
        EditCountries_CountryList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Costa Rica", "Estados Unidos", "China", "Corea del Sur" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(EditCountries_CountryList);

        AddCountryBtn.setBackground(new java.awt.Color(51, 51, 51));
        AddCountryBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddCountryBtn.setText("Agregar");
        AddCountryBtn.setBorderPainted(false);
        AddCountryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCountryBtnActionPerformed(evt);
            }
        });

        RemoveCountryBtn.setBackground(new java.awt.Color(51, 51, 51));
        RemoveCountryBtn.setForeground(new java.awt.Color(255, 255, 255));
        RemoveCountryBtn.setText("Eliminar");
        RemoveCountryBtn.setBorderPainted(false);
        RemoveCountryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveCountryBtnActionPerformed(evt);
            }
        });

        EditCountBackBtn.setBackground(new java.awt.Color(51, 51, 51));
        EditCountBackBtn.setForeground(new java.awt.Color(255, 255, 255));
        EditCountBackBtn.setText("Atrás");
        EditCountBackBtn.setBorderPainted(false);
        EditCountBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditCountBackBtnActionPerformed(evt);
            }
        });

        NewCountryTxtfield.setBackground(new java.awt.Color(51, 51, 51));
        NewCountryTxtfield.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NewCountryTxtfield.setForeground(new java.awt.Color(255, 255, 255));
        NewCountryTxtfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewCountryTxtfieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EditCountriesLayout = new javax.swing.GroupLayout(EditCountries);
        EditCountries.setLayout(EditCountriesLayout);
        EditCountriesLayout.setHorizontalGroup(
            EditCountriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(EditCountriesLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(EditCountriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditCountriesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(AddCountryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))
                    .addGroup(EditCountriesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(NewCountryTxtfield)
                        .addContainerGap())))
            .addGroup(EditCountriesLayout.createSequentialGroup()
                .addGroup(EditCountriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditCountriesLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(RemoveCountryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EditCountriesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(EditCountBackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EditCountriesLayout.setVerticalGroup(
            EditCountriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditCountriesLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(EditCountriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditCountriesLayout.createSequentialGroup()
                        .addComponent(NewCountryTxtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AddCountryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(RemoveCountryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(EditCountBackBtn)
                .addContainerGap())
        );

        AdminPage.add(EditCountries, "editCountries");

        EditArtists.setLayout(new java.awt.CardLayout());

        EditArtistsMenu.setBackground(new java.awt.Color(0, 0, 0));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Editar Artistas");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        EditArtists_ActorsList.setBackground(new java.awt.Color(51, 51, 51));
        EditArtists_ActorsList.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EditArtists_ActorsList.setForeground(new java.awt.Color(255, 255, 255));
        EditArtists_ActorsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Leonardo DiCaprio", "Anne Hathaway", "Brad Pitt", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(EditArtists_ActorsList);

        EditCountBackBtn1.setBackground(new java.awt.Color(51, 51, 51));
        EditCountBackBtn1.setForeground(new java.awt.Color(255, 255, 255));
        EditCountBackBtn1.setText("Atrás");
        EditCountBackBtn1.setBorderPainted(false);
        EditCountBackBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditCountBackBtn1ActionPerformed(evt);
            }
        });

        EditArtists_DirectorsList.setBackground(new java.awt.Color(51, 51, 51));
        EditArtists_DirectorsList.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EditArtists_DirectorsList.setForeground(new java.awt.Color(255, 255, 255));
        EditArtists_DirectorsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Cristopher Nolan", "Quentin Tarantino" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(EditArtists_DirectorsList);

        EditArtists_WritersList.setBackground(new java.awt.Color(51, 51, 51));
        EditArtists_WritersList.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EditArtists_WritersList.setForeground(new java.awt.Color(255, 255, 255));
        EditArtists_WritersList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "George R. R. Martin", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(EditArtists_WritersList);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Actores");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Directores");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Escritores");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton7.setText("Eliminar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton10.setText("Eliminar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton11.setText("Editar");

        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton12.setText("Eliminar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton13.setText("Editar");

        jButton14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton14.setText("Agregar Artista");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EditArtistsMenuLayout = new javax.swing.GroupLayout(EditArtistsMenu);
        EditArtistsMenu.setLayout(EditArtistsMenuLayout);
        EditArtistsMenuLayout.setHorizontalGroup(
            EditArtistsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(EditArtistsMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EditArtistsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EditCountBackBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(EditArtistsMenuLayout.createSequentialGroup()
                        .addGroup(EditArtistsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addGroup(EditArtistsMenuLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(EditArtistsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addGroup(EditArtistsMenuLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(EditArtistsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EditArtistsMenuLayout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(EditArtistsMenuLayout.createSequentialGroup()
                                .addGroup(EditArtistsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(EditArtistsMenuLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton12)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        EditArtistsMenuLayout.setVerticalGroup(
            EditArtistsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditArtistsMenuLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(EditArtistsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGroup(EditArtistsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditArtistsMenuLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(EditArtistsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane4)))
                    .addGroup(EditArtistsMenuLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EditArtistsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton7)
                    .addComponent(jButton11)
                    .addComponent(jButton10)
                    .addComponent(jButton13)
                    .addComponent(jButton12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(EditCountBackBtn1)
                .addContainerGap())
        );

        EditArtists.add(EditArtistsMenu, "editArtistsMenu");

        AddArtist.setBackground(new java.awt.Color(0, 0, 0));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Agregar Artista");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(488, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nombre");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Apellido");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Nacimiento");

        addArtist_genderCombo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addArtist_genderCombo.setForeground(new java.awt.Color(51, 51, 51));
        addArtist_genderCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", " " }));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Género");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Estatura");

        addArtist_height.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addArtist_height.setForeground(new java.awt.Color(51, 51, 51));
        addArtist_height.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desconocida", "130", "131", "132", "133", "134", "135", "136", "137", "138", "139", "140", "141", "142", "143", "144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154", "155", "156", "157", "158", "159", "160", "161", "162", "163", "164", "165", "166", "167", "168", "169", "170", "171", "172", "173", "174", "175", "176", "177", "178", "179", "180", "181", "182", "183", "184", "185", "186", "187", "188", "189", "190", "191", "192", "193", "194", "195", "196", "197", "198", "199", "200", "201", "202", "203", "204", "205", "206", "207", "208", "209", "210", "211", "212", "213", "214", "215", "216", "217", "218", "219", "220", "221", "222", "223", "224", "225", "226", "227", "228", "229", "230" }));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Tipo");

        addArtist_typeCombo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addArtist_typeCombo.setForeground(new java.awt.Color(51, 51, 51));
        addArtist_typeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Actor", "Escritor" }));

        addArtist_bioTxt.setColumns(20);
        addArtist_bioTxt.setLineWrap(true);
        addArtist_bioTxt.setRows(5);
        jScrollPane5.setViewportView(addArtist_bioTxt);

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Biografía");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Dato de trivia");

        addArtist_triviaTxt.setColumns(20);
        addArtist_triviaTxt.setLineWrap(true);
        addArtist_triviaTxt.setRows(5);
        jScrollPane6.setViewportView(addArtist_triviaTxt);

        jButton15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton15.setText("Agregar");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(51, 51, 51));
        jButton16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("Atrás");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("cm");

        javax.swing.GroupLayout AddArtistLayout = new javax.swing.GroupLayout(AddArtist);
        AddArtist.setLayout(AddArtistLayout);
        AddArtistLayout.setHorizontalGroup(
            AddArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddArtistLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AddArtistLayout.createSequentialGroup()
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddArtistLayout.createSequentialGroup()
                        .addGroup(AddArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddArtistLayout.createSequentialGroup()
                                .addGroup(AddArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(AddArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addArtist_nameTxt)
                                    .addComponent(addArtist_lastnameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                            .addGroup(AddArtistLayout.createSequentialGroup()
                                .addGroup(AddArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel34))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(AddArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addArtist_typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(AddArtistLayout.createSequentialGroup()
                                        .addComponent(addArtist_height, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel45))
                                    .addComponent(addArtist_genderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addArtist_date, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(AddArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6)
                            .addComponent(jScrollPane5)
                            .addGroup(AddArtistLayout.createSequentialGroup()
                                .addGroup(AddArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel35))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        AddArtistLayout.setVerticalGroup(
            AddArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddArtistLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AddArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addArtist_nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGroup(AddArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddArtistLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(AddArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addArtist_lastnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(AddArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addArtist_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(AddArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addArtist_genderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AddArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addArtist_height, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45))
                        .addGap(18, 18, 18)
                        .addGroup(AddArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addArtist_typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AddArtistLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(AddArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16))
                .addContainerGap())
        );

        EditArtists.add(AddArtist, "addArtists");

        EditArtist.setBackground(new java.awt.Color(0, 0, 0));

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Editar Artista");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addContainerGap(514, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Nombre");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Apellido");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Nacimiento");

        editArtist_genderCombo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editArtist_genderCombo.setForeground(new java.awt.Color(51, 51, 51));
        editArtist_genderCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", " " }));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Género");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Estatura");

        editArtist_heightCombo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editArtist_heightCombo.setForeground(new java.awt.Color(51, 51, 51));
        editArtist_heightCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desconocida", "130", "131", "132", "133", "134", "135", "136", "137", "138", "139", "140", "141", "142", "143", "144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154", "155", "156", "157", "158", "159", "160", "161", "162", "163", "164", "165", "166", "167", "168", "169", "170", "171", "172", "173", "174", "175", "176", "177", "178", "179", "180", "181", "182", "183", "184", "185", "186", "187", "188", "189", "190", "191", "192", "193", "194", "195", "196", "197", "198", "199", "200", "201", "202", "203", "204", "205", "206", "207", "208", "209", "210", "211", "212", "213", "214", "215", "216", "217", "218", "219", "220", "221", "222", "223", "224", "225", "226", "227", "228", "229", "230" }));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Tipo");

        editArtist_typeCombo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editArtist_typeCombo.setForeground(new java.awt.Color(51, 51, 51));
        editArtist_typeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Actor", "Escritor" }));

        editArtist_bioTxt.setColumns(20);
        editArtist_bioTxt.setRows(5);
        jScrollPane7.setViewportView(editArtist_bioTxt);

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Biografía");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Dato de trivia");

        editArtist_triviaTxt.setColumns(20);
        editArtist_triviaTxt.setRows(5);
        jScrollPane8.setViewportView(editArtist_triviaTxt);

        jButton17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton17.setText("Guardar");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(51, 51, 51));
        jButton18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("Atrás");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("cm");

        javax.swing.GroupLayout EditArtistLayout = new javax.swing.GroupLayout(EditArtist);
        EditArtist.setLayout(EditArtistLayout);
        EditArtistLayout.setHorizontalGroup(
            EditArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditArtistLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EditArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(EditArtistLayout.createSequentialGroup()
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EditArtistLayout.createSequentialGroup()
                        .addGroup(EditArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EditArtistLayout.createSequentialGroup()
                                .addGroup(EditArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel37))
                                .addGap(18, 18, 18)
                                .addGroup(EditArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(editArtist_nameTxt)
                                    .addComponent(editArtist_lastnameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                            .addGroup(EditArtistLayout.createSequentialGroup()
                                .addGroup(EditArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel40)
                                    .addComponent(jLabel41)
                                    .addComponent(jLabel42))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(EditArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(editArtist_typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(EditArtistLayout.createSequentialGroup()
                                        .addComponent(editArtist_heightCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel46))
                                    .addComponent(editArtist_genderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(editArtist_date, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(EditArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8)
                            .addComponent(jScrollPane7)
                            .addGroup(EditArtistLayout.createSequentialGroup()
                                .addGroup(EditArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel43)
                                    .addComponent(jLabel44))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        EditArtistLayout.setVerticalGroup(
            EditArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditArtistLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EditArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editArtist_nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addGroup(EditArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditArtistLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(EditArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editArtist_lastnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(EditArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editArtist_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(EditArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editArtist_genderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(EditArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editArtist_heightCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46))
                        .addGap(18, 18, 18)
                        .addGroup(EditArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editArtist_typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(EditArtistLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(EditArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18))
                .addContainerGap())
        );

        EditArtists.add(EditArtist, "editArtist");

        AdminPage.add(EditArtists, "editArtists");

        EditProducts.setBackground(new java.awt.Color(0, 0, 0));
        EditProducts.setLayout(new java.awt.CardLayout());

        editProductsMenu.setBackground(new java.awt.Color(0, 0, 0));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Editar Productos");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel51)
                .addContainerGap(473, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane9.setBackground(new java.awt.Color(51, 51, 51));

        EditProducts_movies.setBackground(new java.awt.Color(51, 51, 51));
        EditProducts_movies.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EditProducts_movies.setForeground(new java.awt.Color(255, 255, 255));
        EditProducts_movies.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Shutter Island", "Inception", "Interstellar", "Oppenheimer" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane9.setViewportView(EditProducts_movies);

        jScrollPane10.setBackground(new java.awt.Color(51, 51, 51));

        EditProducts_series.setBackground(new java.awt.Color(51, 51, 51));
        EditProducts_series.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EditProducts_series.setForeground(new java.awt.Color(255, 255, 255));
        EditProducts_series.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Game Of Thrones", "House of the Dragon", "Attack on Titan", "Death Note" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        EditProducts_series.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                EditProducts_seriesAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane10.setViewportView(EditProducts_series);

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Películas");

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Series");

        EditCountBackBtn2.setBackground(new java.awt.Color(51, 51, 51));
        EditCountBackBtn2.setForeground(new java.awt.Color(255, 255, 255));
        EditCountBackBtn2.setText("Atrás");
        EditCountBackBtn2.setBorderPainted(false);
        EditCountBackBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditCountBackBtn2ActionPerformed(evt);
            }
        });

        jButton19.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton19.setText("Editar");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton20.setText("Eliminar");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton21.setText("Eliminar");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton22.setText("Editar");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setText("Agregar Serie");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setText("Agregar Película");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editProductsMenuLayout = new javax.swing.GroupLayout(editProductsMenu);
        editProductsMenu.setLayout(editProductsMenuLayout);
        editProductsMenuLayout.setHorizontalGroup(
            editProductsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(editProductsMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EditCountBackBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(editProductsMenuLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(editProductsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editProductsMenuLayout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(editProductsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(editProductsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53)
                    .addGroup(editProductsMenuLayout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(editProductsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton22))))
                .addGap(30, 30, 30)
                .addGroup(editProductsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        editProductsMenuLayout.setVerticalGroup(
            editProductsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editProductsMenuLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(editProductsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editProductsMenuLayout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addGap(5, 5, 5)
                        .addGroup(editProductsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(editProductsMenuLayout.createSequentialGroup()
                                .addComponent(jButton19)
                                .addGap(18, 18, 18)
                                .addComponent(jButton20))))
                    .addGroup(editProductsMenuLayout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addGap(5, 5, 5)
                        .addGroup(editProductsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(editProductsMenuLayout.createSequentialGroup()
                                .addComponent(jButton22)
                                .addGap(18, 18, 18)
                                .addComponent(jButton21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(EditCountBackBtn2)
                .addContainerGap())
        );

        EditProducts.add(editProductsMenu, "editProductsMenu");

        addMovie.setBackground(new java.awt.Color(0, 0, 0));

        jPanel17.setBackground(new java.awt.Color(51, 51, 51));

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Agregar Película");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel54)
                .addContainerGap(475, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Título");

        addMovie_title.setBackground(new java.awt.Color(51, 51, 51));
        addMovie_title.setForeground(new java.awt.Color(255, 255, 255));

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Estreno");

        addMovie_premier.setBackground(new java.awt.Color(51, 51, 51));
        addMovie_premier.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addMovie_premier.setForeground(new java.awt.Color(255, 255, 255));
        addMovie_premier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905", "1904", "1903", "1902", "1901", "1900" }));

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Tráiler");

        addMovie_trailer.setBackground(new java.awt.Color(51, 51, 51));
        addMovie_trailer.setForeground(new java.awt.Color(255, 255, 255));

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Duración");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Sinópsis");

        addMovie_synopsis.setBackground(new java.awt.Color(51, 51, 51));
        addMovie_synopsis.setColumns(20);
        addMovie_synopsis.setForeground(new java.awt.Color(255, 255, 255));
        addMovie_synopsis.setLineWrap(true);
        addMovie_synopsis.setRows(5);
        jScrollPane12.setViewportView(addMovie_synopsis);

        EditCountBackBtn3.setBackground(new java.awt.Color(51, 51, 51));
        EditCountBackBtn3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EditCountBackBtn3.setForeground(new java.awt.Color(255, 255, 255));
        EditCountBackBtn3.setText("Atrás");
        EditCountBackBtn3.setBorderPainted(false);
        EditCountBackBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditCountBackBtn3ActionPerformed(evt);
            }
        });

        addMovie_photos.setBackground(new java.awt.Color(51, 51, 51));
        addMovie_photos.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane13.setViewportView(addMovie_photos);

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Fotos");

        jButton25.setBackground(new java.awt.Color(51, 51, 51));
        jButton25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton25.setForeground(new java.awt.Color(255, 255, 255));
        jButton25.setText("Agregar Foto");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setBackground(new java.awt.Color(51, 51, 51));
        jButton26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton26.setForeground(new java.awt.Color(255, 255, 255));
        jButton26.setText("Agregar");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        addMovie_duration.setBackground(new java.awt.Color(51, 51, 51));
        addMovie_duration.setForeground(new java.awt.Color(255, 255, 255));

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("mins");

        javax.swing.GroupLayout addMovieLayout = new javax.swing.GroupLayout(addMovie);
        addMovie.setLayout(addMovieLayout);
        addMovieLayout.setHorizontalGroup(
            addMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(addMovieLayout.createSequentialGroup()
                .addGroup(addMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addMovieLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(EditCountBackBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addMovieLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(addMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addMovieLayout.createSequentialGroup()
                                .addGroup(addMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel56)
                                    .addComponent(jLabel55)
                                    .addComponent(jLabel57))
                                .addGap(18, 18, 18)
                                .addGroup(addMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addMovie_trailer, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addMovie_title, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addMovie_premier, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(addMovieLayout.createSequentialGroup()
                                .addGroup(addMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel59)
                                    .addComponent(jLabel58))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(addMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(addMovieLayout.createSequentialGroup()
                                        .addComponent(addMovie_duration, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel61)))))
                        .addGap(18, 18, 18)
                        .addGroup(addMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel60)
                            .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        addMovieLayout.setVerticalGroup(
            addMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addMovieLayout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addMovieLayout.createSequentialGroup()
                        .addGroup(addMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addMovieLayout.createSequentialGroup()
                                .addGroup(addMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel55)
                                    .addComponent(addMovie_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(addMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel56)
                                    .addComponent(addMovie_premier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(addMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel57)
                                    .addComponent(addMovie_trailer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(addMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel58)
                                    .addComponent(addMovie_duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel61))
                                .addGap(18, 18, 18)
                                .addGroup(addMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel59)
                                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(addMovieLayout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton25)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(EditCountBackBtn3))
                    .addGroup(addMovieLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        EditProducts.add(addMovie, "addMovie");

        addMovie2.setBackground(new java.awt.Color(0, 0, 0));

        jPanel20.setBackground(new java.awt.Color(51, 51, 51));

        jLabel72.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("Agregar Película");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel72)
                .addContainerGap(475, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        addMovie_categoryLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addMovie_categoryLbl.setForeground(new java.awt.Color(255, 255, 255));
        addMovie_categoryLbl.setText("Categoría:");

        addMovie_category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acción", "Drama", "Comedia", "Terror", "Suspenso", "Amor" }));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Actores");

        addMovie_availableActors.setBackground(new java.awt.Color(51, 51, 51));
        addMovie_availableActors.setForeground(new java.awt.Color(255, 255, 255));
        addMovie_availableActors.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane19.setViewportView(addMovie_availableActors);

        addMovie_actors.setBackground(new java.awt.Color(51, 51, 51));
        addMovie_actors.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane20.setViewportView(addMovie_actors);

        jLabel77.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("Agregados");

        jButton34.setBackground(new java.awt.Color(51, 51, 51));
        jButton34.setForeground(new java.awt.Color(255, 255, 255));
        jButton34.setText("Agregar");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        addMovie_availableWriters.setBackground(new java.awt.Color(51, 51, 51));
        addMovie_availableWriters.setForeground(new java.awt.Color(255, 255, 255));
        addMovie_availableWriters.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane21.setViewportView(addMovie_availableWriters);

        jLabel78.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("Escritores");

        jButton35.setBackground(new java.awt.Color(51, 51, 51));
        jButton35.setForeground(new java.awt.Color(255, 255, 255));
        jButton35.setText("Agregar");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        addMovie_writers.setBackground(new java.awt.Color(51, 51, 51));
        addMovie_writers.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane22.setViewportView(addMovie_writers);

        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setText("Agregados");

        addMovie_categoryLbl1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addMovie_categoryLbl1.setForeground(new java.awt.Color(255, 255, 255));
        addMovie_categoryLbl1.setText("Director");

        addMovie_director.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cristohper Nolan", "Quentin Tarantino", "Martin Scorsese", "Seteven Spielberg" }));

        jButton36.setText("Agregar");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jButton37.setBackground(new java.awt.Color(51, 51, 51));
        jButton37.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton37.setForeground(new java.awt.Color(255, 255, 255));
        jButton37.setText("Atrás");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addMovie2Layout = new javax.swing.GroupLayout(addMovie2);
        addMovie2.setLayout(addMovie2Layout);
        addMovie2Layout.setHorizontalGroup(
            addMovie2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(addMovie2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addMovie2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addMovie2Layout.createSequentialGroup()
                        .addComponent(jButton37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addMovie2Layout.createSequentialGroup()
                        .addGroup(addMovie2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addMovie2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(addMovie2Layout.createSequentialGroup()
                                    .addGroup(addMovie2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(addMovie2Layout.createSequentialGroup()
                                            .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton34))
                                        .addComponent(jLabel47))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(addMovie2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel77)
                                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(addMovie2Layout.createSequentialGroup()
                                    .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton35)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addMovie2Layout.createSequentialGroup()
                                    .addComponent(jLabel78)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel79)
                                    .addGap(15, 15, 15)))
                            .addGroup(addMovie2Layout.createSequentialGroup()
                                .addComponent(addMovie_categoryLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addMovie_category, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(addMovie_categoryLbl1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addMovie_director, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        addMovie2Layout.setVerticalGroup(
            addMovie2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addMovie2Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addMovie2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addMovie_categoryLbl)
                    .addComponent(addMovie_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addMovie_categoryLbl1)
                    .addComponent(addMovie_director, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addMovie2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addMovie2Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addMovie2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(addMovie2Layout.createSequentialGroup()
                            .addComponent(jLabel77)
                            .addGap(55, 55, 55)
                            .addComponent(jButton34)
                            .addGap(51, 51, 51))
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(addMovie2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addMovie2Layout.createSequentialGroup()
                        .addComponent(jLabel79)
                        .addGroup(addMovie2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addMovie2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addMovie2Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jButton35))))
                    .addGroup(addMovie2Layout.createSequentialGroup()
                        .addComponent(jLabel78)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(addMovie2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton37)
                    .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        EditProducts.add(addMovie2, "addMovie2");

        addSeries.setBackground(new java.awt.Color(0, 0, 0));

        jPanel18.setBackground(new java.awt.Color(51, 51, 51));

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Agregar Serie");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel62)
                .addContainerGap(508, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Título");

        addSeries_title.setBackground(new java.awt.Color(51, 51, 51));
        addSeries_title.setForeground(new java.awt.Color(255, 255, 255));

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Estreno");

        addSeries_premier.setBackground(new java.awt.Color(51, 51, 51));
        addSeries_premier.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addSeries_premier.setForeground(new java.awt.Color(255, 255, 255));
        addSeries_premier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905", "1904", "1903", "1902", "1901", "1900" }));

        jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Tráiler");

        addSeries_trailer.setBackground(new java.awt.Color(51, 51, 51));
        addSeries_trailer.setForeground(new java.awt.Color(255, 255, 255));
        addSeries_trailer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSeries_trailerActionPerformed(evt);
            }
        });

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("Sinópsis");

        addSeries_synopsis.setBackground(new java.awt.Color(51, 51, 51));
        addSeries_synopsis.setColumns(20);
        addSeries_synopsis.setForeground(new java.awt.Color(255, 255, 255));
        addSeries_synopsis.setRows(5);
        jScrollPane14.setViewportView(addSeries_synopsis);

        EditCountBackBtn4.setBackground(new java.awt.Color(51, 51, 51));
        EditCountBackBtn4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EditCountBackBtn4.setForeground(new java.awt.Color(255, 255, 255));
        EditCountBackBtn4.setText("Atrás");
        EditCountBackBtn4.setBorderPainted(false);
        EditCountBackBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditCountBackBtn4ActionPerformed(evt);
            }
        });

        addSeries_photos.setBackground(new java.awt.Color(51, 51, 51));
        addSeries_photos.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane15.setViewportView(addSeries_photos);

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("Fotos");

        jButton27.setBackground(new java.awt.Color(51, 51, 51));
        jButton27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton27.setForeground(new java.awt.Color(255, 255, 255));
        jButton27.setText("Agregar Foto");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setBackground(new java.awt.Color(51, 51, 51));
        jButton28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton28.setForeground(new java.awt.Color(255, 255, 255));
        jButton28.setText("Agregar");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addSeriesLayout = new javax.swing.GroupLayout(addSeries);
        addSeries.setLayout(addSeriesLayout);
        addSeriesLayout.setHorizontalGroup(
            addSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(addSeriesLayout.createSequentialGroup()
                .addGroup(addSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addSeriesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(EditCountBackBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addSeriesLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(addSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addSeriesLayout.createSequentialGroup()
                                .addGroup(addSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel64)
                                    .addComponent(jLabel63)
                                    .addComponent(jLabel65))
                                .addGap(18, 18, 18)
                                .addGroup(addSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addSeries_trailer, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addSeries_title, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addSeries_premier, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(addSeriesLayout.createSequentialGroup()
                                .addComponent(jLabel67)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(addSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel68)
                            .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        addSeriesLayout.setVerticalGroup(
            addSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSeriesLayout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addSeriesLayout.createSequentialGroup()
                        .addGroup(addSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(addSeriesLayout.createSequentialGroup()
                                .addGroup(addSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel63)
                                    .addComponent(addSeries_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(addSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel64)
                                    .addComponent(addSeries_premier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(addSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel65)
                                    .addComponent(addSeries_trailer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(addSeriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel67)
                                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25))
                            .addGroup(addSeriesLayout.createSequentialGroup()
                                .addComponent(jLabel68)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton27)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(EditCountBackBtn4))
                    .addGroup(addSeriesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        EditProducts.add(addSeries, "addSeries");

        AdminPage.add(EditProducts, "EditProducts");

        MainPanel.add(AdminPage, "AdminPage");

        SignInPage.setBackground(new java.awt.Color(0, 0, 0));
        SignInPage.setLayout(new java.awt.CardLayout());

        LogInPage.setBackground(new java.awt.Color(0, 0, 0));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Log In");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
        );

        login_userTxt.setBackground(new java.awt.Color(51, 51, 51));
        login_userTxt.setForeground(new java.awt.Color(255, 255, 255));

        login_passwordTxt.setBackground(new java.awt.Color(51, 51, 51));
        login_passwordTxt.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Contraseña");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Usuario");

        jButton3.setText("Ingresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("No tienes cuenta?");

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Crear cuenta");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Atrás");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LogInPageLayout = new javax.swing.GroupLayout(LogInPage);
        LogInPage.setLayout(LogInPageLayout);
        LogInPageLayout.setHorizontalGroup(
            LogInPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogInPageLayout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addGroup(LogInPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LogInPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(login_passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(login_userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(187, 187, 187))
            .addGroup(LogInPageLayout.createSequentialGroup()
                .addGroup(LogInPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LogInPageLayout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4))
                    .addGroup(LogInPageLayout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(jButton3))
                    .addGroup(LogInPageLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LogInPageLayout.setVerticalGroup(
            LogInPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogInPageLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addGroup(LogInPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login_userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(40, 40, 40)
                .addGroup(LogInPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login_passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(30, 30, 30)
                .addComponent(jButton3)
                .addGap(32, 32, 32)
                .addGroup(LogInPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addContainerGap())
        );

        SignInPage.add(LogInPage, "LogInPage");

        RegisterPage1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Registrarse");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
        );

        register_lastnameTxt.setBackground(new java.awt.Color(51, 51, 51));
        register_lastnameTxt.setForeground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Apellido");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Nombre");

        jButton6.setBackground(new java.awt.Color(51, 51, 51));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Siguiente");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(51, 51, 51));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Atrás");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        register_nameTxt.setBackground(new java.awt.Color(51, 51, 51));
        register_nameTxt.setForeground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Usuario");

        register_userTxt.setBackground(new java.awt.Color(51, 51, 51));
        register_userTxt.setForeground(new java.awt.Color(255, 255, 255));

        register_passwordTxt.setBackground(new java.awt.Color(51, 51, 51));
        register_passwordTxt.setForeground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Contraseña");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Nacimiento");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Género");

        register_genderCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre", "Mujer", "Otro" }));

        javax.swing.GroupLayout RegisterPage1Layout = new javax.swing.GroupLayout(RegisterPage1);
        RegisterPage1.setLayout(RegisterPage1Layout);
        RegisterPage1Layout.setHorizontalGroup(
            RegisterPage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(RegisterPage1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RegisterPage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegisterPage1Layout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addContainerGap(592, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterPage1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(RegisterPage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterPage1Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(register_passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterPage1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(register_userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterPage1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(35, 35, 35)
                                .addComponent(register_nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterPage1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(register_lastnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterPage1Layout.createSequentialGroup()
                                .addGroup(RegisterPage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterPage1Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addGap(18, 18, 18))
                                    .addGroup(RegisterPage1Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addGap(46, 46, 46)))
                                .addGroup(RegisterPage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(RegisterPage1Layout.createSequentialGroup()
                                        .addGap(84, 84, 84)
                                        .addComponent(jButton6))
                                    .addComponent(register_genderCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Register_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(112, 112, 112)))
                        .addGap(170, 170, 170))))
        );
        RegisterPage1Layout.setVerticalGroup(
            RegisterPage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterPage1Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegisterPage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(register_nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(RegisterPage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(register_lastnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(RegisterPage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(register_userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(RegisterPage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(register_passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(27, 27, 27)
                .addGroup(RegisterPage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22)
                    .addComponent(Register_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RegisterPage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(register_genderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(35, 35, 35)
                .addComponent(jButton8)
                .addContainerGap())
        );

        SignInPage.add(RegisterPage1, "RegisterPage1");

        RegisterPage2.setBackground(new java.awt.Color(0, 0, 0));

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Registrarse");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
        );

        register_phoneTxt.setBackground(new java.awt.Color(51, 51, 51));
        register_phoneTxt.setForeground(new java.awt.Color(255, 255, 255));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Teléfono");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("email");

        registerButton.setBackground(new java.awt.Color(51, 51, 51));
        registerButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        registerButton.setForeground(new java.awt.Color(255, 255, 255));
        registerButton.setText("Registrarse");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(51, 51, 51));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Atrás");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        register_emailTxt.setBackground(new java.awt.Color(51, 51, 51));
        register_emailTxt.setForeground(new java.awt.Color(255, 255, 255));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Tipo de identificación");

        register_typesCombo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        register_typesCombo.setForeground(new java.awt.Color(51, 51, 51));
        register_typesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cédula", "Pasaporte", " " }));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Identificación");

        register_idTxt.setBackground(new java.awt.Color(51, 51, 51));
        register_idTxt.setForeground(new java.awt.Color(255, 255, 255));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Nacionalidad");

        register_countryCombo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        register_countryCombo.setForeground(new java.awt.Color(51, 51, 51));
        register_countryCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", " " }));

        javax.swing.GroupLayout RegisterPage2Layout = new javax.swing.GroupLayout(RegisterPage2);
        RegisterPage2.setLayout(RegisterPage2Layout);
        RegisterPage2Layout.setHorizontalGroup(
            RegisterPage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(RegisterPage2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RegisterPage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegisterPage2Layout.createSequentialGroup()
                        .addComponent(jButton9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterPage2Layout.createSequentialGroup()
                        .addGap(0, 25, Short.MAX_VALUE)
                        .addGroup(RegisterPage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterPage2Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(35, 35, 35)
                                .addComponent(register_emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterPage2Layout.createSequentialGroup()
                                .addGroup(RegisterPage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel31))
                                .addGap(32, 32, 32)
                                .addGroup(RegisterPage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(register_phoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(register_typesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(register_idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(register_countryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(170, 170, 170))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterPage2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registerButton)
                .addGap(268, 268, 268))
        );
        RegisterPage2Layout.setVerticalGroup(
            RegisterPage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterPage2Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegisterPage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(register_emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(RegisterPage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(register_phoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(30, 30, 30)
                .addGroup(RegisterPage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(register_typesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(RegisterPage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(register_idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(RegisterPage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(register_countryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(registerButton)
                .addGap(39, 39, 39)
                .addComponent(jButton9)
                .addContainerGap())
        );

        SignInPage.add(RegisterPage2, "RegisterPage2");

        MainPanel.add(SignInPage, "signInPage");

        ViewMovie.setBackground(new java.awt.Color(0, 0, 0));

        jPanel19.setBackground(new java.awt.Color(51, 51, 51));

        MainMenuLbl2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        MainMenuLbl2.setForeground(new java.awt.Color(255, 255, 255));
        MainMenuLbl2.setText("Belphegor");

        jTextField3.setText("Buscar");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        MainMenu_SignInButton2.setBackground(new java.awt.Color(51, 51, 51));
        MainMenu_SignInButton2.setForeground(new java.awt.Color(255, 255, 255));
        MainMenu_SignInButton2.setText("Sign In");
        MainMenu_SignInButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenu_SignInButton2ActionPerformed(evt);
            }
        });

        jButton33.setBackground(new java.awt.Color(102, 102, 102));
        jButton33.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jButton33.setForeground(new java.awt.Color(204, 204, 204));
        jButton33.setText("Admin");
        jButton33.setBorderPainted(false);
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainMenuLbl2)
                .addGap(18, 18, 18)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MainMenu_SignInButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MainMenuLbl2, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MainMenu_SignInButton2)
                    .addComponent(jButton33))
                .addContainerGap())
        );

        movie_title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        movie_title.setForeground(new java.awt.Color(255, 255, 255));
        movie_title.setText("Shutter Island");

        jLabel70.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("4.8");

        movie_synopsis.setEditable(false);
        movie_synopsis.setBackground(new java.awt.Color(51, 51, 51));
        movie_synopsis.setColumns(20);
        movie_synopsis.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        movie_synopsis.setForeground(new java.awt.Color(255, 255, 255));
        movie_synopsis.setLineWrap(true);
        movie_synopsis.setRows(5);
        movie_synopsis.setText("Aqui va la sinopsis\n");
        jScrollPane16.setViewportView(movie_synopsis);

        movie_category.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        movie_category.setForeground(new java.awt.Color(255, 255, 255));
        movie_category.setText("Categoría: Acción");

        jLabel73.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Sinópsis");

        jLabel74.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("Director:");

        movie_director.setBackground(new java.awt.Color(0, 0, 0));
        movie_director.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        movie_director.setForeground(new java.awt.Color(255, 255, 255));
        movie_director.setText("Cristopher Nolan");
        movie_director.setBorder(null);
        movie_director.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movie_directorActionPerformed(evt);
            }
        });

        movie_actors.setBackground(new java.awt.Color(51, 51, 51));
        movie_actors.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        movie_actors.setForeground(new java.awt.Color(255, 255, 255));
        movie_actors.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Leonardo DiCaprio", "Ellen Paige" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane17.setViewportView(movie_actors);

        jLabel75.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("Actores");

        movie_writers.setBackground(new java.awt.Color(51, 51, 51));
        movie_writers.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        movie_writers.setForeground(new java.awt.Color(255, 255, 255));
        movie_writers.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Escritor 1", "Escritor 2", "Escritor 3" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane18.setViewportView(movie_writers);

        jLabel76.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("Escritores");

        movie_viewActor.setBackground(new java.awt.Color(51, 51, 51));
        movie_viewActor.setForeground(new java.awt.Color(255, 255, 255));
        movie_viewActor.setText("Ver");
        movie_viewActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movie_viewActorActionPerformed(evt);
            }
        });

        movie_viewWriter.setBackground(new java.awt.Color(51, 51, 51));
        movie_viewWriter.setForeground(new java.awt.Color(255, 255, 255));
        movie_viewWriter.setText("Ver");
        movie_viewWriter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movie_viewWriterActionPerformed(evt);
            }
        });

        movie_premier.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        movie_premier.setForeground(new java.awt.Color(255, 255, 255));
        movie_premier.setText("Estreno: 2011");

        movie_duration.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        movie_duration.setForeground(new java.awt.Color(255, 255, 255));
        movie_duration.setText("Duración: 134 minutos");

        movie_buy.setBackground(new java.awt.Color(51, 51, 51));
        movie_buy.setForeground(new java.awt.Color(255, 255, 255));
        movie_buy.setText("Comprar: $4.99");
        movie_buy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movie_buyActionPerformed(evt);
            }
        });

        movie_favorites.setBackground(new java.awt.Color(51, 51, 51));
        movie_favorites.setForeground(new java.awt.Color(255, 255, 255));
        movie_favorites.setText("Favoritos");
        movie_favorites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movie_favoritesActionPerformed(evt);
            }
        });

        movie_trailer.setBackground(new java.awt.Color(0, 0, 0));
        movie_trailer.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        movie_trailer.setForeground(new java.awt.Color(255, 255, 255));
        movie_trailer.setText("ver tráiler");
        movie_trailer.setBorder(null);
        movie_trailer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movie_trailerActionPerformed(evt);
            }
        });

        AdmMenuBackBtn1.setBackground(new java.awt.Color(51, 51, 51));
        AdmMenuBackBtn1.setForeground(new java.awt.Color(255, 255, 255));
        AdmMenuBackBtn1.setText("Atrás");
        AdmMenuBackBtn1.setBorderPainted(false);
        AdmMenuBackBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdmMenuBackBtn1ActionPerformed(evt);
            }
        });

        AdmMenuBackBtn2.setBackground(new java.awt.Color(51, 51, 51));
        AdmMenuBackBtn2.setForeground(new java.awt.Color(255, 255, 255));
        AdmMenuBackBtn2.setText("Atrás");
        AdmMenuBackBtn2.setBorderPainted(false);
        AdmMenuBackBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdmMenuBackBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ViewMovieLayout = new javax.swing.GroupLayout(ViewMovie);
        ViewMovie.setLayout(ViewMovieLayout);
        ViewMovieLayout.setHorizontalGroup(
            ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ViewMovieLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewMovieLayout.createSequentialGroup()
                        .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ViewMovieLayout.createSequentialGroup()
                                .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ViewMovieLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(movie_img, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ViewMovieLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(movie_buy)
                                            .addGroup(ViewMovieLayout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(movie_favorites)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel70)
                                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel73)
                                    .addComponent(movie_category)
                                    .addGroup(ViewMovieLayout.createSequentialGroup()
                                        .addComponent(jLabel74)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(movie_director))
                                    .addComponent(movie_premier)
                                    .addComponent(movie_duration)
                                    .addComponent(movie_trailer))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel75))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewMovieLayout.createSequentialGroup()
                                        .addComponent(movie_viewActor, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20))))
                            .addComponent(movie_title, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel76)
                            .addGroup(ViewMovieLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(movie_viewWriter, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36))
                    .addGroup(ViewMovieLayout.createSequentialGroup()
                        .addComponent(AdmMenuBackBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ViewMovieLayout.createSequentialGroup()
                    .addGap(308, 308, 308)
                    .addComponent(AdmMenuBackBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(302, Short.MAX_VALUE)))
        );
        ViewMovieLayout.setVerticalGroup(
            ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewMovieLayout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(movie_title, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewMovieLayout.createSequentialGroup()
                        .addComponent(movie_img, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(movie_buy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(movie_favorites)
                        .addGap(54, 54, 54)
                        .addComponent(AdmMenuBackBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(ViewMovieLayout.createSequentialGroup()
                        .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel70)
                            .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel75)
                                .addComponent(jLabel76)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane18)
                            .addGroup(ViewMovieLayout.createSequentialGroup()
                                .addComponent(jLabel73)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(movie_category)
                            .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(movie_viewActor, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(movie_viewWriter, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(movie_director))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(movie_premier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(movie_duration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(movie_trailer)
                        .addGap(72, 72, 72))))
            .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ViewMovieLayout.createSequentialGroup()
                    .addGap(223, 223, 223)
                    .addComponent(AdmMenuBackBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(224, 224, 224)))
        );

        MainPanel.add(ViewMovie, "ViewMovie");

        ViewAllProducts.setBackground(new java.awt.Color(0, 0, 0));

        jPanel21.setBackground(new java.awt.Color(51, 51, 51));

        MainMenuLbl3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        MainMenuLbl3.setForeground(new java.awt.Color(255, 255, 255));
        MainMenuLbl3.setText("Belphegor");

        jTextField4.setText("Buscar");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        MainMenu_SignInButton3.setBackground(new java.awt.Color(51, 51, 51));
        MainMenu_SignInButton3.setForeground(new java.awt.Color(255, 255, 255));
        MainMenu_SignInButton3.setText("Sign In");
        MainMenu_SignInButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenu_SignInButton3ActionPerformed(evt);
            }
        });

        jButton48.setBackground(new java.awt.Color(102, 102, 102));
        jButton48.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jButton48.setForeground(new java.awt.Color(204, 204, 204));
        jButton48.setText("Admin");
        jButton48.setBorderPainted(false);
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainMenuLbl3)
                .addGap(18, 18, 18)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MainMenu_SignInButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MainMenuLbl3, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MainMenu_SignInButton3)
                    .addComponent(jButton48))
                .addContainerGap())
        );

        jLabel88.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setText("Series");

        jLabel89.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setText("Películas");

        viewProducts_movies.setBackground(new java.awt.Color(51, 51, 51));
        viewProducts_movies.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        viewProducts_movies.setForeground(new java.awt.Color(255, 255, 255));
        viewProducts_movies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Puntuación", "Estreno"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Float.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane23.setViewportView(viewProducts_movies);

        jButton49.setBackground(new java.awt.Color(51, 51, 51));
        jButton49.setForeground(new java.awt.Color(255, 255, 255));
        jButton49.setText("Ver");
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });

        jButton50.setBackground(new java.awt.Color(51, 51, 51));
        jButton50.setForeground(new java.awt.Color(255, 255, 255));
        jButton50.setText("Ver");
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });

        jButton51.setBackground(new java.awt.Color(51, 51, 51));
        jButton51.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton51.setForeground(new java.awt.Color(255, 255, 255));
        jButton51.setText("Atrás");
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });

        viewProducts_series.setBackground(new java.awt.Color(51, 51, 51));
        viewProducts_series.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        viewProducts_series.setForeground(new java.awt.Color(255, 255, 255));
        viewProducts_series.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Puntuación", "Estreno"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Float.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane24.setViewportView(viewProducts_series);

        javax.swing.GroupLayout ViewAllProductsLayout = new javax.swing.GroupLayout(ViewAllProducts);
        ViewAllProducts.setLayout(ViewAllProductsLayout);
        ViewAllProductsLayout.setHorizontalGroup(
            ViewAllProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ViewAllProductsLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(ViewAllProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel89)
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ViewAllProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel88)
                    .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
            .addGroup(ViewAllProductsLayout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jButton49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton50)
                .addGap(125, 125, 125))
            .addGroup(ViewAllProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton51)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ViewAllProductsLayout.setVerticalGroup(
            ViewAllProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewAllProductsLayout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ViewAllProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel89)
                    .addComponent(jLabel88))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ViewAllProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ViewAllProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton49)
                    .addComponent(jButton50))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jButton51)
                .addContainerGap())
        );

        MainPanel.add(ViewAllProducts, "ViewAllProducts");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddCountryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCountryBtnActionPerformed
        String name = NewCountryTxtfield.getText();
        try {
            Insertions.insertCountry(name);
        }
        catch (Exception e) {
            System.out.println("Error inserting: " + e);
            return;
        }
        NewCountryTxtfield.setText("");
        try {
            EditCountries_CountryList.setModel(buildListModel(Cursors.getCountries()));
        }
        catch (Exception e) {
            System.out.println("Couldn't fetch countries: " + e);
        }
    }//GEN-LAST:event_AddCountryBtnActionPerformed

    private void RemoveCountryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveCountryBtnActionPerformed
        try{
            int index = EditCountries_CountryList.getSelectedIndex();
            ListModel model = EditCountries_CountryList.getModel();
            Country country = (Country)model.getElementAt(index);
            Deletions.deleteCountry(country.getId());
        }
        catch (Exception e) {
            System.out.println("Failed to delete" + e);
        }
        try {
            EditCountries_CountryList.setModel(buildListModel(Cursors.getCountries()));
        }
        catch (Exception e) {
            System.out.println("Couldn't fetch countries: " + e);
        }
    }//GEN-LAST:event_RemoveCountryBtnActionPerformed

    private void EditCountBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditCountBackBtnActionPerformed
        CardLayout card = (CardLayout) AdminPage.getLayout();
        card.show(AdminPage, "adminMenu");
    }//GEN-LAST:event_EditCountBackBtnActionPerformed

    private void AdmMenuBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdmMenuBackBtnActionPerformed
        CardLayout card = (CardLayout) MainPanel.getLayout();
        card.show(MainPanel, "mainMenu");
    }//GEN-LAST:event_AdmMenuBackBtnActionPerformed

    private void NewCountryTxtfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewCountryTxtfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewCountryTxtfieldActionPerformed

    private void CountriesButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountriesButton2ActionPerformed
        CardLayout card = (CardLayout) AdminPage.getLayout();
        card.show(AdminPage, "editCountries");
        try {
        DefaultListModel list = buildListModel(Cursors.getCountries());
        EditCountries_CountryList.setModel(list);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_CountriesButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        CardLayout card = (CardLayout) MainPanel.getLayout();
        card.show(MainPanel, "mainMenu");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int id = -1;
        try {
            id = Logic.verifyAccountCredentials(login_userTxt.getText(), 
                    login_passwordTxt.getText());
        }
        catch (Exception e) {
            System.out.println();
        }
        if (id >= 0) {
            userAccount = new Account(id, login_userTxt.getText());
            MainMenu_SignInButton.setText("Welcome");
            MainMenu_SignInButton.setEnabled(false);
            CardLayout card = (CardLayout) MainPanel.getLayout();
            card.show(MainPanel, "mainMenu");
        }
        else {
            showError("Usuario o contraseña incorrectos!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        CardLayout card = (CardLayout) SignInPage.getLayout();
        card.show(SignInPage, "RegisterPage1");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (register_nameTxt.getText().length() < 1 ||
        register_lastnameTxt.getText().length() < 1 ||
        register_userTxt.getText().length() < 1 ||
        register_passwordTxt.getText().length() < 1 ){
            showError("Por favor, complete todos los campos");
            return;
        }
        boolean isUniqueUser = false;
        try{
            isUniqueUser = Logic.getUsernameUnique(register_userTxt.getText());
        }
        catch (Exception e) {
            showError("Algo salió mal. Por favor intente de nuevo");
        }
        if (!isUniqueUser) {
            showError("El nombre de usuario ya está en uso.");
            return;
        }
        try {
            ComboBoxModel modelCountries = buildComboModel(Cursors.getCountries());
            ComboBoxModel modelIdTypes = buildComboModel(Cursors.getIdTypes());
            register_countryCombo.setModel(modelCountries);
            register_typesCombo.setModel(modelIdTypes);
        }
        catch (Exception e) {
            showError(e.toString());
            return;
        }
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            String birthDate = formatter.format(Register_date.getDate());
        }
        catch (Exception e) {
            showError("Fecha inválida.");
            return;
        }
        CardLayout card = (CardLayout) SignInPage.getLayout();
        card.show(SignInPage, "RegisterPage2");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        CardLayout card = (CardLayout) SignInPage.getLayout();
        card.show(SignInPage, "LogInPage");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        CardLayout card = (CardLayout) SignInPage.getLayout();
        card.show(SignInPage, "RegisterPage1");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        if (register_emailTxt.getText().length() < 1 ||
            register_phoneTxt.getText().length() < 1 ||
            register_idTxt.getText().length() < 1) {
                showError("Por favor, complete todos los campos");
                return;
        }
        int phone;
        int idNumber;
        try {
            phone = Integer.parseInt(register_phoneTxt.getText());
        }
        catch (Exception e) {
            showError("Ingrese un teléfono válido.");
            return;
        }
        try {
            idNumber = Integer.parseInt(register_idTxt.getText());
        }
        catch (Exception e) {
            showError("Ingrese una identificación válida.");
            return;
        } 
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String birthDate;
        try {
            birthDate = formatter.format(Register_date.getDate());
        }
        catch (Exception e) {
            showError("Fecha inválida.");
            return;
        }
        String name = register_nameTxt.getText();
        String lastName = register_lastnameTxt.getText();
        String username = register_userTxt.getText();
        String password = register_passwordTxt.getText();
        int index = register_genderCombo.getSelectedIndex();
        ListModel model = register_genderCombo.getModel();
        Gender gender = (Gender) model.getElementAt(index);
        String email = register_emailTxt.getText();
        IdType idType = (IdType) register_typesCombo.getSelectedItem();
        index = register_countryCombo.getSelectedIndex();
        model = register_countryCombo.getModel();
        Country country = (Country)model.getElementAt(index);
        int idPerson;
        try {
            System.out.println(birthDate);
            idPerson = Insertions.insertPerson(name, lastName, birthDate, 0, gender.getId());
            Insertions.insertUser(idPerson, email, phone, country.getId(), 
                idType.getId(), idNumber);
            Insertions.insertAccount(username, password, idPerson, 2, 0);
            System.out.println("Registered");
        }
        catch (Exception e) {
            System.out.println(e);
            showError(e.toString());
            return;
        }
        Account account = new Account(0, username, password, idPerson, 2, 0);
        userInfo userinfo = userInfo.getInstance();
        userinfo.setAccount(account);
        MainMenu_SignInButton.setText("Welcome");
        MainMenu_SignInButton.setEnabled(false);
        CardLayout card = (CardLayout) MainPanel.getLayout();
        card.show(MainPanel, "mainMenu");
    }//GEN-LAST:event_registerButtonActionPerformed

    private void CountriesButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountriesButton3ActionPerformed
        try {
            DefaultListModel actorsModel = buildListModel(Cursors.getArtistsOfType(1));
            DefaultListModel directorsModel = buildListModel(Cursors.getArtistsOfType(2));
            DefaultListModel writersModel = buildListModel(Cursors.getArtistsOfType(3));
            EditArtists_ActorsList.setModel(actorsModel);
            EditArtists_DirectorsList.setModel(directorsModel);
            EditArtists_WritersList.setModel(writersModel);
        }
        catch (Exception e) {
            showError("Error al leer de la base de datos.");
            System.out.println(e);
            return;
        }
        CardLayout card = (CardLayout) AdminPage.getLayout();
        card.show(AdminPage, "editArtists");
    }//GEN-LAST:event_CountriesButton3ActionPerformed

    private void EditCountBackBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditCountBackBtn1ActionPerformed
        CardLayout card = (CardLayout) AdminPage.getLayout();
        card.show(AdminPage, "adminMenu");
    }//GEN-LAST:event_EditCountBackBtn1ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        if (addArtist_nameTxt.getText().length() < 1 ||
            addArtist_lastnameTxt.getText().length() < 1 ||
            addArtist_bioTxt.getText().length() < 1 ||
            addArtist_triviaTxt.getText().length() < 1) {
                showError("Debe llenar todos los datos.");
                return;
        }
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String birthDate;
        try {
            birthDate = formatter.format(addArtist_date.getDate());
        }
        catch (Exception e) {
            showError("Fecha inválida.");
            return;
        }
        String name = addArtist_nameTxt.getText();
        String lastName = addArtist_lastnameTxt.getText();
        int index = addArtist_genderCombo.getSelectedIndex();
        ListModel model = addArtist_genderCombo.getModel();
        Gender gender = (Gender) model.getElementAt(index);
        index = addArtist_typeCombo.getSelectedIndex();
        model = addArtist_typeCombo.getModel();
        ArtistType type = (ArtistType) model.getElementAt(index);
        String bio = addArtist_bioTxt.getText();
        String trivia = addArtist_triviaTxt.getText();
        int height;
        System.out.println(addArtist_height.getSelectedItem().toString());
        try {
            height = Integer.parseInt(addArtist_height.getSelectedItem().toString());
        }
        catch (NumberFormatException e) {
            height = 0;
        }
        try {
            int id = Insertions.insertPerson(name, lastName, birthDate, height, gender.getId());
            Insertions.insertArtist(id, type.getId(), bio, trivia);
        }
        catch (Exception e) {
            showError("Verifique las entradas e intente nuevamente.");
            return;
        }
        try {
            DefaultListModel actorsModel = buildListModel(Cursors.getArtistsOfType(1));
            DefaultListModel directorsModel = buildListModel(Cursors.getArtistsOfType(2));
            DefaultListModel writersModel = buildListModel(Cursors.getArtistsOfType(3));
            EditArtists_ActorsList.setModel(actorsModel);
            EditArtists_DirectorsList.setModel(directorsModel);
            EditArtists_WritersList.setModel(writersModel);
        }
        catch (Exception e) {
            showError("Error al leer de la base de datos.");
        }
        CardLayout card = (CardLayout) EditArtists.getLayout();
        card.show(EditArtists, "editArtistsMenu");
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        try {
            DefaultComboBoxModel gendersModel = buildComboModel(Cursors.getGenders());
            addArtist_genderCombo.setModel(gendersModel);
            DefaultComboBoxModel typesModel = buildComboModel(Cursors.getArtistTypes());
            addArtist_typeCombo.setModel(typesModel);
        }
        catch (Exception e) {
            showError("Error al leer de la base de datos.");
            return;
        }
        CardLayout card = (CardLayout) EditArtists.getLayout();
        card.show(EditArtists, "addArtists");
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        CardLayout card = (CardLayout) EditArtists.getLayout();
        card.show(EditArtists, "editArtistsMenu");
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            int index = EditArtists_ActorsList.getSelectedIndex();
            ListModel model = EditArtists_ActorsList.getModel();
            Artist artist = (Artist)model.getElementAt(index);
            Deletions.deleteArtist(artist.getId());
            DefaultListModel actorsModel = buildListModel(Cursors.getArtistsOfType(1));
            EditArtists_ActorsList.setModel(actorsModel);
        }
        catch (Exception e) {
            showError("Error al eliminar. Intente nuevamente.");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
            int index = EditArtists_DirectorsList.getSelectedIndex();
            ListModel model = EditArtists_DirectorsList.getModel();
            Artist artist = (Artist)model.getElementAt(index);
            Deletions.deleteArtist(artist.getId());
            DefaultListModel directorsModel = buildListModel(Cursors.getArtistsOfType(2));
            EditArtists_DirectorsList.setModel(directorsModel);
        }
        catch (Exception e) {
            showError("Error al eliminar. Intente nuevamente.");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        try {
            int index = EditArtists_WritersList.getSelectedIndex();
            ListModel model = EditArtists_WritersList.getModel();
            Artist artist = (Artist)model.getElementAt(index);
            Deletions.deleteArtist(artist.getId());
            DefaultListModel writersModel = buildListModel(Cursors.getArtistsOfType(3));
            EditArtists_WritersList.setModel(writersModel);
        }
        catch (Exception e) {
            showError("Error al eliminar. Intente nuevamente.");
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        CardLayout card = (CardLayout) EditArtists.getLayout();
        card.show(EditArtists, "editArtistsMenu");
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CountriesButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountriesButton4ActionPerformed
        CardLayout card = (CardLayout) AdminPage.getLayout();
        card.show(AdminPage, "EditProducts");
        try {
            DefaultListModel movieList = buildListModel(Cursors.getMovies());
            DefaultListModel seriesList = buildListModel(Cursors.getSeries());
            EditProducts_series.setModel(seriesList);
            EditProducts_movies.setModel(movieList);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_CountriesButton4ActionPerformed

    private void EditProducts_seriesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_EditProducts_seriesAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_EditProducts_seriesAncestorAdded

    private void EditCountBackBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditCountBackBtn2ActionPerformed
        CardLayout card = (CardLayout) AdminPage.getLayout();
        card.show(AdminPage, "adminMenu");
    }//GEN-LAST:event_EditCountBackBtn2ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        try{
            int index = EditProducts_movies.getSelectedIndex();
            ListModel model = EditProducts_movies.getModel();
            Movie movie = (Movie) model.getElementAt(index);
            Deletions.deleteMovie(movie.getId());
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            EditProducts_movies.setModel(buildListModel(Cursors.getMovies()));
        }
        catch (Exception e) {
            System.out.println("Couldn't fetch movies.");
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        try{
            int index = EditProducts_series.getSelectedIndex();
            ListModel model = EditProducts_series.getModel();
            Series series = (Series) model.getElementAt(index);
            Deletions.deleteSeries(series.getId());
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            EditProducts_series.setModel(buildListModel(Cursors.getSeries()));
        }
        catch (Exception e) {
            System.out.println("Couldn't fetch series.");
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed

    private void EditCountBackBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditCountBackBtn3ActionPerformed
        CardLayout card = (CardLayout) EditProducts.getLayout();
        card.show(EditProducts, "editProductsMenu");
    }//GEN-LAST:event_EditCountBackBtn3ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        CardLayout card = (CardLayout) EditProducts.getLayout();
        card.show(EditProducts, "addMovie");
        DefaultListModel model = new DefaultListModel();
        addMovie_photos.setModel(model);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.showDialog(fc, "Agregar");
        File imgFile;
        String fileName;
        try {
            imgFile = fc.getSelectedFile();
            fileName = imgFile.getAbsolutePath();
        }
        catch (Exception e) {
            return;
        }
        if (!fileName.toLowerCase().endsWith(".jpg") 
           && !fileName.toLowerCase().endsWith(".jpeg")) {
               showError("Solo puede ingresar archivos jpg.");
               return;
        }
        
        ListModel oldModel = addMovie_photos.getModel();
        DefaultListModel newModel = new DefaultListModel();
        for (int i = 0; i < oldModel.getSize(); i++) {
            newModel.addElement(oldModel.getElementAt(i));
        }
        newModel.addElement(imgFile);
        addMovie_photos.setModel(newModel);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        if (addMovie_title.getText().length() < 1 ||
            addMovie_trailer.getText().length() < 1 ||
            addMovie_duration.getText().length() < 1 ||
            addMovie_synopsis.getText().length() < 1) {
                showError("Complete todos los campos.");
                return;
        }
        if (addMovie_photos.getModel().getSize() == 0) {
            showError("Debe ingresar al menos 1 foto.");
            return;
        }
        
        int duration;
        try {
            duration = Integer.parseInt(addMovie_duration.getText());
        }
        catch (Exception e) {
            showError("Duración inválida.");
            return;
        }
        if (duration > 500 || duration < 1) {
            showError("Duración inválida.");
            return;
        }
        try {
            DefaultListModel actorsModel = buildListModel(Cursors.getArtistsOfType(1));
            DefaultComboBoxModel directorsModel = buildComboModel(Cursors.getArtistsOfType(2));
            DefaultListModel writersModel = buildListModel(Cursors.getArtistsOfType(3));
            DefaultListModel emptyModel1 = new DefaultListModel();
            DefaultListModel emptyModel2 = new DefaultListModel();
            addMovie_availableActors.setModel(actorsModel);
            addMovie_director.setModel(directorsModel);
            addMovie_availableWriters.setModel(writersModel);
            addMovie_actors.setModel(emptyModel1);
            addMovie_writers.setModel(emptyModel2);
        }
        catch (Exception e) {
            showError("Error al leer de la base de datos.");
            System.out.println(e);
            return;
        }
        
        CardLayout card = (CardLayout) EditProducts.getLayout();
        card.show(EditProducts, "addMovie2");
    }//GEN-LAST:event_jButton26ActionPerformed

    private void EditCountBackBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditCountBackBtn4ActionPerformed
        CardLayout card = (CardLayout) EditProducts.getLayout();
        card.show(EditProducts, "editProductsMenu");
    }//GEN-LAST:event_EditCountBackBtn4ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.showDialog(fc, "Agregar");
        File imgFile = fc.getSelectedFile();
        String fileName = imgFile.getAbsolutePath();
        if (!fileName.toLowerCase().endsWith(".jpg") 
           && !fileName.toLowerCase().endsWith(".jpeg")) {
               showError("Solo puede ingresar archivos jpg.");
               return;
        }
        
        ListModel oldModel = addSeries_photos.getModel();
        DefaultListModel newModel = new DefaultListModel();
        for (int i = 0; i < oldModel.getSize(); i++) {
            newModel.addElement(oldModel.getElementAt(i));
        }
        newModel.addElement(imgFile);
        addSeries_photos.setModel(newModel);
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        if (addSeries_title.getText().length() < 1 ||
            addSeries_trailer.getText().length() < 1 ||
            addSeries_synopsis.getText().length() < 1) {
                showError("Complete todos los campos.");
                return;
        }
        if (addSeries_photos.getModel().getSize() == 0) {
            showError("Debe ingresar al menos 1 foto.");
            return;
        }
        
        String title = addSeries_title.getText();
        int premier = Integer.parseInt(
                addSeries_premier.getSelectedItem().toString());
        String trailer = addSeries_trailer.getText();
        String synopsis = addSeries_synopsis.getText();
        
        int idProduct;
        try {
            idProduct = Insertions.insertProduct(title, premier, synopsis, trailer);
            Insertions.insertSeries(idProduct);
        }
        catch (Exception e) {
            showError("Error al insertar");
            return;
        }
        ListModel photoModel = addSeries_photos.getModel();
        for (int i = 0; i < photoModel.getSize(); i++) {
            try {
                File img = (File) photoModel.getElementAt(i);
                String path = img.getAbsolutePath();
                int photoId = Insertions.insertPhoto(path);
                Insertions.insertProductPhoto(photoId, idProduct);
            }
            catch (Exception e) {
                showError("No se pudo insertar la imagen");
            }
        }
        try {
            EditProducts_series.setModel(buildListModel(Cursors.getSeries()));
        }
        catch (Exception e) {
            System.out.println("Couldn't fetch movies.");
        }
        CardLayout card = (CardLayout) EditProducts.getLayout();
        card.show(EditProducts, "editProductsMenu");
    }//GEN-LAST:event_jButton28ActionPerformed

    private void addSeries_trailerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSeries_trailerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addSeries_trailerActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        CardLayout card = (CardLayout) EditProducts.getLayout();
        card.show(EditProducts, "addSeries");
        DefaultListModel model = new DefaultListModel();
        addSeries_photos.setModel(model);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CardLayout card = (CardLayout) MainPanel.getLayout();
        card.show(MainPanel, "AdminPage");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void MainMenu_SignInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenu_SignInButtonActionPerformed
        try {
            DefaultComboBoxModel model = buildComboModel(Cursors.getGenders());
            register_genderCombo.setModel(model);
        }
        catch (Exception e) {
            showError("Error al recuperar de la base de datos.");
            return;
        }
        CardLayout card = (CardLayout) MainPanel.getLayout();
        card.show(MainPanel, "signInPage");
    }//GEN-LAST:event_MainMenu_SignInButtonActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void MainMenu_SignInButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenu_SignInButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MainMenu_SignInButton1ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton33ActionPerformed

    private void MainMenu_SignInButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenu_SignInButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MainMenu_SignInButton2ActionPerformed

    private void movie_directorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movie_directorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_movie_directorActionPerformed

    private void movie_viewActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movie_viewActorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_movie_viewActorActionPerformed

    private void movie_viewWriterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movie_viewWriterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_movie_viewWriterActionPerformed

    private void movie_buyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movie_buyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_movie_buyActionPerformed

    private void movie_favoritesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movie_favoritesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_movie_favoritesActionPerformed

    private void movie_trailerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movie_trailerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_movie_trailerActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        try {
            viewMovie(Cursors.getProduct(menuMovies.get(0).getIdProduct()));
        }
        catch(Exception e) {
            showError("Error al recuperar producto.");
        }
        previousCard = "mainMenu";
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        try {
            viewMovie(Cursors.getProduct(menuMovies.get(1).getIdProduct()));
        }
        catch(Exception e) {
            showError("Error al recuperar producto.");
        }
        previousCard = "mainMenu";
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        try {
            viewMovie(Cursors.getProduct(menuMovies.get(2).getIdProduct()));
        }
        catch(Exception e) {
            showError("Error al recuperar producto.");
        }
        previousCard = "mainMenu";
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        try {
            viewMovie(Cursors.getProduct(menuMovies.get(3).getIdProduct()));
        }
        catch(Exception e) {
            showError("Error al recuperar producto.");
        }
        previousCard = "mainMenu";
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        try {
            viewMovie(Cursors.getProduct(menuMovies.get(4).getIdProduct()));
        }
        catch(Exception e) {
            showError("Error al recuperar producto.");
        }
        previousCard = "mainMenu";
    }//GEN-LAST:event_jButton42ActionPerformed

    private void AdmMenuBackBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdmMenuBackBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdmMenuBackBtn1ActionPerformed

    private void AdmMenuBackBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdmMenuBackBtn2ActionPerformed
        CardLayout card = (CardLayout) MainPanel.getLayout();
        card.show(MainPanel, previousCard);
    }//GEN-LAST:event_AdmMenuBackBtn2ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        int index = addMovie_availableActors.getSelectedIndex();
        if (index == -1) {
            showError("Debe seleccionar un elemento");
            return;
        }
        ListModel avModel = addMovie_availableActors.getModel();
        ListModel selectModel = addMovie_actors.getModel();
        Artist actor = (Artist) avModel.getElementAt(index);
        for (int i = 0; i < selectModel.getSize(); i++) {
            Artist selectedActor = (Artist) selectModel.getElementAt(i);
            if (selectedActor.getId() == actor.getId()) {
                showError("El actor ya ha sido agregado.");
                return;
            }
        }
        DefaultListModel newModel = new DefaultListModel();
        for (int i = 0; i < selectModel.getSize(); i++) {
            Artist selectedActor = (Artist) selectModel.getElementAt(i);
            newModel.addElement(selectedActor);
        }
        newModel.addElement(actor);
        addMovie_actors.setModel(newModel);
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        int index = addMovie_availableWriters.getSelectedIndex();
        if (index == -1) {
            showError("Debe seleccionar un elemento");
            return;
        }
        ListModel avModel = addMovie_availableWriters.getModel();
        ListModel selectModel = addMovie_writers.getModel();
        Artist actor = (Artist) avModel.getElementAt(index);
        for (int i = 0; i < selectModel.getSize(); i++) {
            Artist selectedActor = (Artist) selectModel.getElementAt(i);
            if (selectedActor.getId() == actor.getId()) {
                showError("El escritor ya ha sido agregado.");
                return;
            }
        }
        DefaultListModel newModel = new DefaultListModel();
        for (int i = 0; i < selectModel.getSize(); i++) {
            Artist selectedActor = (Artist) selectModel.getElementAt(i);
            newModel.addElement(selectedActor);
        }
        newModel.addElement(actor);
        addMovie_writers.setModel(newModel);
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        CardLayout card = (CardLayout) EditProducts.getLayout();
        card.show(EditProducts, "addMovie");
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        String title = addMovie_title.getText();
        int premier = Integer.parseInt(
                addMovie_premier.getSelectedItem().toString());
        String trailer = addMovie_trailer.getText();
        String synopsis = addMovie_synopsis.getText();
        int duration = Integer.parseInt(addMovie_duration.getText());
        int idProduct;
        try {
            idProduct = Insertions.insertProduct(title, premier, synopsis, trailer);
            Insertions.insertMovie(idProduct, duration);
        }
        catch (Exception e) {
            showError("Error al insertar");
            return;
        }
        ListModel photoModel = addMovie_photos.getModel();
        for (int i = 0; i < photoModel.getSize(); i++) {
            try {
                File img = (File) photoModel.getElementAt(i);
                String path = img.getAbsolutePath();
                int photoId = Insertions.insertPhoto(path);
                Insertions.insertProductPhoto(photoId, idProduct);
            }
            catch (Exception e) {
                showError("No se pudo insertar la imagen");
            }
        }
        ListModel actorsModel = addMovie_actors.getModel();
        for (int i = 0; i < actorsModel.getSize(); i++) {
            Artist artist = (Artist) actorsModel.getElementAt(i);
            try {
                Insertions.insertProductArtist(idProduct, artist.getId());
            }
            catch(Exception e) {
                showError("Error al asignar actor: ." + artist.getName());
            }
        }
        ListModel writersModel = addMovie_writers.getModel();
        for (int i = 0; i < writersModel.getSize(); i++) {
            Artist artist = (Artist) writersModel.getElementAt(i);
            try {
                Insertions.insertProductArtist(idProduct, artist.getId());
            }
            catch(Exception e) {
                showError("Error al asignar escritor: ." + artist.getName());
            }
        }
        ListModel directorsModel = addMovie_director.getModel();
        int index = addMovie_director.getSelectedIndex();
        Artist director = (Artist) directorsModel.getElementAt(index);
        try {
            Insertions.insertProductArtist(idProduct, director.getId());
        }
        catch(Exception e) {
            showError("Error al asignar director.");
        }
        try {
            EditProducts_movies.setModel(buildListModel(Cursors.getMovies()));
        }
        catch (Exception e) {
            System.out.println("Couldn't fetch movies.");
        }
        CardLayout card = (CardLayout) EditProducts.getLayout();
        card.show(EditProducts, "editProductsMenu");
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        ArrayList<Movie> movies;
        ArrayList<Series> series;
        try { 
            movies = Cursors.getMovies();
            series = Cursors.getSeries();
        }
        catch (Exception e) {
            showError("Error al recuperar productos.");
            System.out.println(e);
            return;
        }
        DefaultTableModel movieModel = new DefaultTableModel();
        DefaultTableModel seriesModel = new DefaultTableModel();
        String[] columns = {"Título", "Puntuación", "Año"};
        movieModel.setColumnIdentifiers(columns);
        seriesModel.setColumnIdentifiers(columns);
        
        try {
            for (Movie movie : movies) {
                Product product = Cursors.getProduct(movie.getIdProduct());
                Object[] row = new Object[3];
                row[0] = product;
                row[1] = "4.6";
                row[2] = product.getPremier();
                movieModel.addRow(row);
            }

            for (Series serie : series) {
                Product product = Cursors.getProduct(serie.getId_product());
                Object[] row = new Object[3];
                row[0] = product;
                row[1] = "4.6";
                row[2] = product.getPremier();
                seriesModel.addRow(row);
            }
        }
        catch (Exception e) {}
        viewProducts_movies.setModel(movieModel);
        viewProducts_series.setModel(seriesModel);
        CardLayout card = (CardLayout) MainPanel.getLayout();
        card.show(MainPanel, "ViewAllProducts");
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void MainMenu_SignInButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenu_SignInButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MainMenu_SignInButton3ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        CardLayout card = (CardLayout) MainPanel.getLayout();
        card.show(MainPanel, "mainMenu");
    }//GEN-LAST:event_jButton51ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        TableModel model = viewProducts_movies.getModel();
        int index = viewProducts_movies.getSelectedRow();
        Product product = (Product) model.getValueAt(index, 0);
        try {
            viewMovie(Cursors.getProduct(product.getId()));
        }
        catch(Exception e) {
            showError("Error al recuperar producto.");
        }
        previousCard = "ViewAllProducts";
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        TableModel model = viewProducts_series.getModel();
        int index = viewProducts_series.getSelectedRow();
        Product product = (Product) model.getValueAt(index, 0);
        try {
            //viewMovie(Cursors.getProduct(product.getId()));
            //cambiar por viewSeries()
        }
        catch(Exception e) {
            showError("Error al recuperar producto.");
        }
        previousCard = "ViewAllProducts";
    }//GEN-LAST:event_jButton50ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddArtist;
    private javax.swing.JButton AddCountryBtn;
    private javax.swing.JButton AdmMenuBackBtn;
    private javax.swing.JButton AdmMenuBackBtn1;
    private javax.swing.JButton AdmMenuBackBtn2;
    private javax.swing.JPanel AdminMenu;
    private javax.swing.JPanel AdminPage;
    private javax.swing.JButton CountriesButton2;
    private javax.swing.JButton CountriesButton3;
    private javax.swing.JButton CountriesButton4;
    private javax.swing.JPanel EditArtist;
    private javax.swing.JPanel EditArtists;
    private javax.swing.JPanel EditArtistsMenu;
    private javax.swing.JList<String> EditArtists_ActorsList;
    private javax.swing.JList<String> EditArtists_DirectorsList;
    private javax.swing.JList<String> EditArtists_WritersList;
    private javax.swing.JButton EditCountBackBtn;
    private javax.swing.JButton EditCountBackBtn1;
    private javax.swing.JButton EditCountBackBtn2;
    private javax.swing.JButton EditCountBackBtn3;
    private javax.swing.JButton EditCountBackBtn4;
    private javax.swing.JPanel EditCountries;
    private javax.swing.JList<String> EditCountries_CountryList;
    private javax.swing.JPanel EditProducts;
    private javax.swing.JList<String> EditProducts_movies;
    private javax.swing.JList<String> EditProducts_series;
    private javax.swing.JDialog ErrorDialog;
    private javax.swing.JLabel ErrorDialogTxt;
    private javax.swing.JPanel LogInPage;
    private javax.swing.JPanel MainMenu;
    private javax.swing.JLabel MainMenuLbl;
    private javax.swing.JLabel MainMenuLbl1;
    private javax.swing.JLabel MainMenuLbl2;
    private javax.swing.JLabel MainMenuLbl3;
    private javax.swing.JButton MainMenu_SignInButton;
    private javax.swing.JButton MainMenu_SignInButton1;
    private javax.swing.JButton MainMenu_SignInButton2;
    private javax.swing.JButton MainMenu_SignInButton3;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JTextField NewCountryTxtfield;
    private javax.swing.JPanel RegisterPage1;
    private javax.swing.JPanel RegisterPage2;
    private com.toedter.calendar.JDateChooser Register_date;
    private javax.swing.JButton RemoveCountryBtn;
    private javax.swing.JPanel SearchResults;
    private javax.swing.JPanel SignInPage;
    private javax.swing.JPanel ViewAllProducts;
    private javax.swing.JPanel ViewMovie;
    private javax.swing.JTextArea addArtist_bioTxt;
    private com.toedter.calendar.JDateChooser addArtist_date;
    private javax.swing.JComboBox<String> addArtist_genderCombo;
    private javax.swing.JComboBox<String> addArtist_height;
    private javax.swing.JTextField addArtist_lastnameTxt;
    private javax.swing.JTextField addArtist_nameTxt;
    private javax.swing.JTextArea addArtist_triviaTxt;
    private javax.swing.JComboBox<String> addArtist_typeCombo;
    private javax.swing.JPanel addMovie;
    private javax.swing.JPanel addMovie2;
    private javax.swing.JList<String> addMovie_actors;
    private javax.swing.JList<String> addMovie_availableActors;
    private javax.swing.JList<String> addMovie_availableWriters;
    private javax.swing.JComboBox<String> addMovie_category;
    private javax.swing.JLabel addMovie_categoryLbl;
    private javax.swing.JLabel addMovie_categoryLbl1;
    private javax.swing.JComboBox<String> addMovie_director;
    private javax.swing.JTextField addMovie_duration;
    private javax.swing.JList<String> addMovie_photos;
    private javax.swing.JComboBox<String> addMovie_premier;
    private javax.swing.JTextArea addMovie_synopsis;
    private javax.swing.JTextField addMovie_title;
    private javax.swing.JTextField addMovie_trailer;
    private javax.swing.JList<String> addMovie_writers;
    private javax.swing.JPanel addSeries;
    private javax.swing.JList<String> addSeries_photos;
    private javax.swing.JComboBox<String> addSeries_premier;
    private javax.swing.JTextArea addSeries_synopsis;
    private javax.swing.JTextField addSeries_title;
    private javax.swing.JTextField addSeries_trailer;
    private javax.swing.JTextArea editArtist_bioTxt;
    private com.toedter.calendar.JDateChooser editArtist_date;
    private javax.swing.JComboBox<String> editArtist_genderCombo;
    private javax.swing.JComboBox<String> editArtist_heightCombo;
    private javax.swing.JTextField editArtist_lastnameTxt;
    private javax.swing.JTextField editArtist_nameTxt;
    private javax.swing.JTextArea editArtist_triviaTxt;
    private javax.swing.JComboBox<String> editArtist_typeCombo;
    private javax.swing.JPanel editProductsMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField login_passwordTxt;
    private javax.swing.JTextField login_userTxt;
    private javax.swing.JLabel movie1_img;
    private javax.swing.JLabel movie1_img1;
    private javax.swing.JLabel movie1_name;
    private javax.swing.JLabel movie1_name1;
    private javax.swing.JLabel movie2_img;
    private javax.swing.JLabel movie2_img1;
    private javax.swing.JLabel movie2_name;
    private javax.swing.JLabel movie2_name1;
    private javax.swing.JLabel movie3_img;
    private javax.swing.JLabel movie3_img1;
    private javax.swing.JLabel movie3_name;
    private javax.swing.JLabel movie3_name1;
    private javax.swing.JLabel movie4_img;
    private javax.swing.JLabel movie4_img1;
    private javax.swing.JLabel movie4_name;
    private javax.swing.JLabel movie4_name1;
    private javax.swing.JLabel movie5_img;
    private javax.swing.JLabel movie5_img1;
    private javax.swing.JLabel movie5_name;
    private javax.swing.JLabel movie5_name1;
    private javax.swing.JList<String> movie_actors;
    private javax.swing.JButton movie_buy;
    private javax.swing.JLabel movie_category;
    private javax.swing.JButton movie_director;
    private javax.swing.JLabel movie_duration;
    private javax.swing.JButton movie_favorites;
    private javax.swing.JLabel movie_img;
    private javax.swing.JLabel movie_premier;
    private javax.swing.JTextArea movie_synopsis;
    private javax.swing.JLabel movie_title;
    private javax.swing.JButton movie_trailer;
    private javax.swing.JButton movie_viewActor;
    private javax.swing.JButton movie_viewWriter;
    private javax.swing.JList<String> movie_writers;
    private javax.swing.JButton registerButton;
    private javax.swing.JComboBox<String> register_countryCombo;
    private javax.swing.JTextField register_emailTxt;
    private javax.swing.JComboBox<String> register_genderCombo;
    private javax.swing.JTextField register_idTxt;
    private javax.swing.JTextField register_lastnameTxt;
    private javax.swing.JTextField register_nameTxt;
    private javax.swing.JTextField register_passwordTxt;
    private javax.swing.JTextField register_phoneTxt;
    private javax.swing.JComboBox<String> register_typesCombo;
    private javax.swing.JTextField register_userTxt;
    private javax.swing.JLabel series1_img;
    private javax.swing.JTable viewProducts_movies;
    private javax.swing.JTable viewProducts_series;
    // End of variables declaration//GEN-END:variables
}
