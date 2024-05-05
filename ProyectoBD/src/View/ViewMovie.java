package View;

import Control.*;
import Model.*;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ListModel;

public class ViewMovie extends javax.swing.JPanel {
    JPanel previousPanel;
    MainFrame mainFrame;
    Product product;
    boolean isWished;
    boolean isInCart;
    Artist director;
    ArrayList<String> photos;
    int currentPhoto = 0;
    
    public ViewMovie(MainFrame mainFrame, JPanel previousPanel,
            Product product) {
        this.mainFrame = mainFrame;
        this.previousPanel = previousPanel;
        this.product = product;
        isWished = false;
        isInCart = false;
        initComponents();
        loadInfo();
        addToHistory();
    }
    
    private void addToHistory() {
        if (mainFrame.userAccount == null) {
            return;
        }
        int idUser = mainFrame.userAccount.getId_user();
        int idProduct = product.getId();
        try {
            Insertions.insertViewedProduct(idUser, idProduct);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    private void loadInfo() {
        ArrayList<Integer> artistIds;
        try {
            photos =  Cursors.getProductPhotos(product.getId());
            //setLabelIcon(movie_img, Cursors.getProductMainImg(product.getId()));
            setLabelIcon(movie_img, photos.get(0));
            currentPhoto = 0;
            artistIds = Cursors.getArtistsInProduct(product.getId());
        }
        catch (Exception e) {
            mainFrame.showError("Error al cargar película.");
                System.out.println(e);
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
                mainFrame.showError("Error al recuperar artista.");
                continue;
            }
            switch (artist.getId_artistType()) {
                case 1:
                    actorsModel.addElement(artist);
                    break;
                case 3:
                    writersModel.addElement(artist);
                    break;
                case 2:
                    movie_director.setText(artist.getName());
                    director = artist;
                    break;
                default:
                    break;
            }
        }
        String category = "Categoría: -";
        int duration = 0;
        try {
            duration = Cursors.getMovieDuration(product.getId());
            category = "Categoría: " + Cursors.getProductCategory(product.getId());
        }
        catch (Exception e) {
        }
        String dur = duration > 0 ? "Duración: " + Integer.toString(duration) : "Duración: -";
        dur = dur + " mins";
        movie_duration.setText(dur);
        movie_category.setText(category);
        movie_actors.setModel(actorsModel);
        movie_writers.setModel(writersModel);
        movie_title.setText(product.getTitle());
        movie_synopsis.setText(product.getSynopsis());
        movie_premier.setText("Estreno: " + Integer.toString(product.getPremier()));
        movie_buy.setText("Comprar: $" + Float.toString(product.getPrice()));
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        String avgRatingString = "-";
        float avgRating = -1;
        try{
            avgRating = Cursors.getAverageRating(product.getId());
        }
        catch(Exception e) {
            mainFrame.showError("Error al cargar puntuación.");
            System.out.println(e);
        }
        if (avgRating > -1)
            avgRatingString = decimalFormat.format(avgRating);
        ratingTxt.setText(avgRatingString);
        
        if (mainFrame.userAccount != null) {
            try {
                int idWishlist = Cursors.getWishlistId(mainFrame.userAccount.getId_user());
                ArrayList<Product> wishedProducts = Cursors.getProductsInWishlist(idWishlist);
                for (Product p : wishedProducts) {
                    if (product.getTitle().equals(p.getTitle())) {
                        movie_favorites.setText("Quitar");
                        isWished = true;
                    }
                }
            }
            catch (Exception e) {
                mainFrame.showError("Error al recuperar favoritos.");
                System.out.println(e);
            }
            try {
                int idCart = Cursors.getCartId(mainFrame.userAccount.getId_user());
                ArrayList<Product> cartProducts = Cursors.getProductsInCart(idCart);
                for (Product p : cartProducts) {
                    if (product.getTitle().equals(p.getTitle())) {
                        movie_buy.setText("    En Carrito    ");
                        isInCart = true;
                    }
                }
            }
            catch (Exception e) {
                mainFrame.showError("Error al recuperar favoritos.");
                System.out.println(e);
            }
                try {
                ArrayList<Product> ownedProducts = Cursors.getOwnedProducts(mainFrame.userAccount.getId_user());
                for (Product p : ownedProducts) {
                    if (product.getTitle().equals(p.getTitle())) {
                        movie_buy.setText("Comprado");
                        movie_buy.setEnabled(false);
                    }
                }
            }
            catch (Exception e) {
                mainFrame.showError("Error al recuperar compras.");
                System.out.println(e);
            }
        }
    }
    
    private void setLabelIcon(JLabel label, String path) {
    //Receives a label and an image path, sets the label's icon to the image.
        File file = new File(path);
        BufferedImage originalImage = null;
        try {
            originalImage = ImageIO.read(file);
        }
        catch (Exception e) {
            mainFrame.showError("Error al cargar imagen");
        }
        int maxWidth = label.getWidth(); 
        int maxHeight = label.getHeight(); 
        Image scaledImage = originalImage.getScaledInstance(144, 195, Image.SCALE_SMOOTH);
        // Create a new ImageIcon
        ImageIcon icon = new ImageIcon(scaledImage);
        label.setIcon(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ViewMovie = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        MainMenuLbl2 = new javax.swing.JLabel();
        movie_title = new javax.swing.JLabel();
        movie_img = new javax.swing.JLabel();
        ratingTxt = new javax.swing.JLabel();
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
        AdmMenuBackBtn2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        movie_viewActor1 = new javax.swing.JButton();
        movie_viewActor2 = new javax.swing.JButton();

        ViewMovie.setBackground(new java.awt.Color(0, 0, 0));

        jPanel19.setBackground(new java.awt.Color(51, 51, 51));

        MainMenuLbl2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        MainMenuLbl2.setForeground(new java.awt.Color(255, 255, 255));
        MainMenuLbl2.setText("Belphegor");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainMenuLbl2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainMenuLbl2, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        movie_title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        movie_title.setForeground(new java.awt.Color(255, 255, 255));
        movie_title.setText("Shutter Island");

        ratingTxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ratingTxt.setForeground(new java.awt.Color(255, 255, 255));
        ratingTxt.setText("-");

        movie_synopsis.setEditable(false);
        movie_synopsis.setBackground(new java.awt.Color(51, 51, 51));
        movie_synopsis.setColumns(20);
        movie_synopsis.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        movie_synopsis.setForeground(new java.awt.Color(255, 255, 255));
        movie_synopsis.setLineWrap(true);
        movie_synopsis.setRows(5);
        movie_synopsis.setWrapStyleWord(true);
        jScrollPane16.setViewportView(movie_synopsis);

        movie_category.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        movie_category.setForeground(new java.awt.Color(255, 255, 255));
        movie_category.setText("Categoría: -");

        jLabel73.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Sinópsis");

        jLabel74.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("Director:");

        movie_director.setBackground(new java.awt.Color(0, 0, 0));
        movie_director.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        movie_director.setForeground(new java.awt.Color(255, 255, 255));
        movie_director.setText("-");
        movie_director.setBorder(null);
        movie_director.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movie_directorActionPerformed(evt);
            }
        });

        movie_actors.setBackground(new java.awt.Color(51, 51, 51));
        movie_actors.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        movie_actors.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane17.setViewportView(movie_actors);

        jLabel75.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("Actores");

        movie_writers.setBackground(new java.awt.Color(51, 51, 51));
        movie_writers.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        movie_writers.setForeground(new java.awt.Color(255, 255, 255));
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
        movie_premier.setText("Estreno: -");

        movie_duration.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        movie_duration.setForeground(new java.awt.Color(255, 255, 255));
        movie_duration.setText("Duración: -");

        movie_buy.setBackground(new java.awt.Color(51, 51, 51));
        movie_buy.setForeground(new java.awt.Color(255, 255, 255));
        movie_buy.setText("Comprar: $---");
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

        AdmMenuBackBtn2.setBackground(new java.awt.Color(51, 51, 51));
        AdmMenuBackBtn2.setForeground(new java.awt.Color(255, 255, 255));
        AdmMenuBackBtn2.setText("Atrás");
        AdmMenuBackBtn2.setBorderPainted(false);
        AdmMenuBackBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdmMenuBackBtn2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Ver reviews");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        movie_viewActor1.setBackground(new java.awt.Color(51, 51, 51));
        movie_viewActor1.setForeground(new java.awt.Color(255, 255, 255));
        movie_viewActor1.setText("<");
        movie_viewActor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movie_viewActor1ActionPerformed(evt);
            }
        });

        movie_viewActor2.setBackground(new java.awt.Color(51, 51, 51));
        movie_viewActor2.setForeground(new java.awt.Color(255, 255, 255));
        movie_viewActor2.setText(">");
        movie_viewActor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movie_viewActor2ActionPerformed(evt);
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
                            .addComponent(movie_title, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ViewMovieLayout.createSequentialGroup()
                                .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ViewMovieLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(movie_img, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ViewMovieLayout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(movie_favorites))
                                    .addGroup(ViewMovieLayout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(ViewMovieLayout.createSequentialGroup()
                                                .addComponent(movie_viewActor1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(movie_viewActor2))
                                            .addComponent(movie_buy))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ratingTxt)
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ViewMovieLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jButton1))
                                    .addGroup(ViewMovieLayout.createSequentialGroup()
                                        .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel75))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewMovieLayout.createSequentialGroup()
                                                .addComponent(movie_viewActor, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(23, 23, 23)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel76)
                                            .addGroup(ViewMovieLayout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(movie_viewWriter, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(75, 75, 75))
                    .addGroup(ViewMovieLayout.createSequentialGroup()
                        .addComponent(AdmMenuBackBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                        .addGap(130, 130, 130)
                        .addComponent(AdmMenuBackBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(ViewMovieLayout.createSequentialGroup()
                        .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ViewMovieLayout.createSequentialGroup()
                                .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ViewMovieLayout.createSequentialGroup()
                                        .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(ratingTxt)
                                            .addComponent(jLabel75))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(ViewMovieLayout.createSequentialGroup()
                                                .addComponent(jLabel73)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane17))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(movie_category)
                                            .addComponent(movie_viewActor, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(ViewMovieLayout.createSequentialGroup()
                                        .addComponent(jLabel76)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(movie_viewWriter, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(movie_director))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(movie_premier, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(movie_duration, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(movie_trailer)
                                    .addComponent(jButton1)))
                            .addGroup(ViewMovieLayout.createSequentialGroup()
                                .addGap(207, 207, 207)
                                .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(movie_viewActor1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(movie_viewActor2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(movie_buy)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(movie_favorites)
                                .addGap(7, 7, 7)))
                        .addGap(65, 65, 65))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ViewMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ViewMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void movie_directorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movie_directorActionPerformed
        if (director == null) {
            return;
        }
        mainFrame.showPage("ViewArtist", new ViewArtist(mainFrame, this, director.getId()));
    }//GEN-LAST:event_movie_directorActionPerformed

    private void movie_viewActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movie_viewActorActionPerformed
        int index = movie_actors.getSelectedIndex();
        if (index == -1) {
            mainFrame.showError("Debe seleccionar un elemento.");
            return;
        }
        ListModel model = movie_actors.getModel();
        Artist artist = (Artist) model.getElementAt(index);
        mainFrame.showPage("ViewArtist", new ViewArtist(mainFrame, this, artist.getId()));
    }//GEN-LAST:event_movie_viewActorActionPerformed

    private void movie_viewWriterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movie_viewWriterActionPerformed
        int index = movie_writers.getSelectedIndex();
        if (index == -1) {
            mainFrame.showError("Debe seleccionar un elemento.");
            return;
        }
        ListModel model = movie_writers.getModel();
        Artist artist = (Artist) model.getElementAt(index);
        mainFrame.showPage("ViewArtist", new ViewArtist(mainFrame, this, artist.getId()));
    }//GEN-LAST:event_movie_viewWriterActionPerformed

    private void movie_buyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movie_buyActionPerformed
        if (mainFrame.userAccount == null) {
            mainFrame.showPage("SignInPage", new SignInPage(mainFrame, this));
            return;
        }
        if (!isInCart) {
            try{
                int idCart = Cursors.getCartId(mainFrame.userAccount.getId_user());
                Insertions.insertCartProduct(product.getId(), idCart);
            }
            catch (Exception e) {
                mainFrame.showError("Error al añadir al carrito."); 
                return;
            }
            movie_buy.setText("    En Carrito    ");
            isInCart = true;
        }
        else{
            try {
                int idCart =  Cursors.getCartId(mainFrame.userAccount.getId_user());
                Deletions.deleteFromCart(idCart, product.getId());
            }
            catch (Exception e) {
                mainFrame.showError("Error al quitar del carrito.");
                return;
            }
            movie_buy.setText("Comprar: $" + product.getPrice());
            isInCart = false;
        }
    }//GEN-LAST:event_movie_buyActionPerformed

    private void movie_favoritesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movie_favoritesActionPerformed
        if (mainFrame.userAccount == null) {
            mainFrame.showPage("SignInPage", new SignInPage(mainFrame, this));
            return;
        }
        if (!isWished) {
            try{
                int idWishlist = Cursors.getWishlistId(mainFrame.userAccount.getId_user());
                Insertions.insertWishedProduct(product.getId(), idWishlist);
            }
            catch (Exception e) {
                mainFrame.showError("Error al añadir a favoritos"); 
            }
            movie_favorites.setText("Quitar");
            isWished = true;
        }
        else{
            try {
                int idWishlist =  Cursors.getWishlistId(mainFrame.userAccount.getId_user());
                Deletions.deleteFromWishlist(idWishlist, product.getId());
            }
            catch (Exception e) {
                mainFrame.showError("Error al quitar de favoritos.");
                return;
            }
            movie_favorites.setText("Favoritos");
            isWished = false;
        }
    }//GEN-LAST:event_movie_favoritesActionPerformed

    private void movie_trailerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movie_trailerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_movie_trailerActionPerformed

    private void AdmMenuBackBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdmMenuBackBtn2ActionPerformed
        mainFrame.showPage("NewPage", previousPanel);
    }//GEN-LAST:event_AdmMenuBackBtn2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        mainFrame.showPage("ReviewsPage", new ViewReviewsProduct(mainFrame, product, this));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void movie_viewActor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movie_viewActor1ActionPerformed
        if (currentPhoto > 0) {
            currentPhoto--;
            setLabelIcon(movie_img, photos.get(currentPhoto));
        }
    }//GEN-LAST:event_movie_viewActor1ActionPerformed

    private void movie_viewActor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movie_viewActor2ActionPerformed
        if (currentPhoto < photos.size()-1) {
            currentPhoto++;
            setLabelIcon(movie_img, photos.get(currentPhoto));
        }
    }//GEN-LAST:event_movie_viewActor2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdmMenuBackBtn2;
    private javax.swing.JLabel MainMenuLbl2;
    private javax.swing.JPanel ViewMovie;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
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
    private javax.swing.JButton movie_viewActor1;
    private javax.swing.JButton movie_viewActor2;
    private javax.swing.JButton movie_viewWriter;
    private javax.swing.JList<String> movie_writers;
    private javax.swing.JLabel ratingTxt;
    // End of variables declaration//GEN-END:variables
}
