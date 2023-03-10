/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traductor1;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Torrado'sLaptop
 */
public class Traductor extends javax.swing.JFrame {

    /**
     * Creates new form Traductor
     */
    public Traductor() {
        initComponents();
        DefaultListModel modelIdiomas = new DefaultListModel();
        
        DefaultListModel modelPalabras = new DefaultListModel();
        PalabrasList.setModel(modelPalabras);
        ptr = null;
    }
    
    void showList(NodoP ptr) {
        DefaultListModel model = (DefaultListModel) PalabrasList.getModel();
        model.clear();
        NodoP p = ptr;
        while (p != null) {
            model.addElement(p.Palabras);
            p = p.linkPalabra;
        }
    }
    
    
    
    Nodo ptr;
    
    class Nodo{
        String Idiomas;
        Nodo linkIdiomas;
        NodoP linkPalabra;
    }
    
    class NodoP{
        String Palabras;
        NodoP linkPalabra;
    }
    
    Nodo addcola(Nodo ptr, String Idio){
        Nodo p = ptr;
        Nodo q = new Nodo();
        q.Idiomas = Idio;
        if(ptr == null){
            ptr = q;
        }else{
            while(p.linkIdiomas!=null){
                p = p.linkIdiomas;
            }
            p.linkIdiomas = q;
        }
        return ptr;
    }
    Nodo BuscaIdiomas(Nodo ptr, String IdiomaB){
        Nodo p = ptr;
        while(p.linkIdiomas!=null && !p.Idiomas.equalsIgnoreCase(IdiomaB)){
            p = p.linkIdiomas;
        }
        if(!p.Idiomas.equals(IdiomaB)){
            JOptionPane.showMessageDialog(null, "No se encontro el idioma");
        }
        return p;
    }
    
    void BuscaPalabras(String word, String IdiomaB){
        Nodo p = ptr;
        BuscaIdiomas(p, IdiomaB);
    }
    
    

    void TranslateWord(Nodo ptr, String IdiomaO, String IdiomaD, String word){
        Nodo p = ptr;
        int cont=0,i=0;
        while(p != null && !p.Idiomas.equals(IdiomaO)){ 
            p=p.linkIdiomas;
        }
        if(p!=null){
            if(p.Idiomas.equals(IdiomaO)){      
                if(p.linkPalabra != null){      
                    NodoP q = p.linkPalabra;    
                    while(q != null && !q.Palabras.equals(word)){   
                        q = q.linkPalabra;      
                        cont=cont+1;
                    }
                    if(q!=null && q.Palabras.equals(word)){ 
                        Nodo pp = ptr;
                        while(pp != null && !pp.Idiomas.equals(IdiomaD)){ 
                            pp=pp.linkIdiomas;
                        }
                        if(pp!=null && pp.Idiomas.equals(IdiomaD)){     
                            NodoP qq = pp.linkPalabra;
                            while(i!=cont){                            
                                qq=qq.linkPalabra;
                                i=i+1;
                            }
                            TraduccionTxt.setText(qq.Palabras);         
                        }else{
                           JOptionPane.showMessageDialog(null, "No se encuentra el idioma al que se desea traducir"); // Esto nunca sucede
                        }
                    }else{
                           JOptionPane.showMessageDialog(null, "No se encuentra la palabra que se desea traducir"); 
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "No hay palabras registradas para ese idioma");
                }    
            }else{
                   JOptionPane.showMessageDialog(null, "No se encuentra el idioma de origen de la palabra"); 
            }
        }
    }
    
        
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuElegir = new javax.swing.JFrame();
        AgregarBtnMenu = new javax.swing.JButton();
        TraducirBtnMenu = new javax.swing.JButton();
        EliminarBtnMenu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        MenuAgregar = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        AddItaTxt2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        AddSpaBtn2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        AddSpaTxt2 = new javax.swing.JTextField();
        AddEngTxt2 = new javax.swing.JTextField();
        AddFreTxt2 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        MenuTraducir = new javax.swing.JFrame();
        jLabel19 = new javax.swing.JLabel();
        TranslateTxt2 = new javax.swing.JTextField();
        IdiomaOrigenBtn2 = new javax.swing.JComboBox<>();
        TranslateBtn1 = new javax.swing.JButton();
        IdiomaDestinoBtn2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TraduccionTxt = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        MenuEliminar = new javax.swing.JFrame();
        jLabel9 = new javax.swing.JLabel();
        ElimTxt = new javax.swing.JTextField();
        ElimBtn2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PalabrasList = new javax.swing.JList<>();
        MostrarPalabras = new javax.swing.JButton();
        AtrasElim = new javax.swing.JButton();
        JLabel = new javax.swing.JLabel();
        GeneradorBtn = new javax.swing.JButton();

        AgregarBtnMenu.setText("Agregar Palabras");
        AgregarBtnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarBtnMenuActionPerformed(evt);
            }
        });

        TraducirBtnMenu.setText("Traducir Palabras");
        TraducirBtnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TraducirBtnMenuActionPerformed(evt);
            }
        });

        EliminarBtnMenu.setText("Eliminar Palabras");
        EliminarBtnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarBtnMenuActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Men?? Principal");

        javax.swing.GroupLayout MenuElegirLayout = new javax.swing.GroupLayout(MenuElegir.getContentPane());
        MenuElegir.getContentPane().setLayout(MenuElegirLayout);
        MenuElegirLayout.setHorizontalGroup(
            MenuElegirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuElegirLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(MenuElegirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(MenuElegirLayout.createSequentialGroup()
                        .addComponent(AgregarBtnMenu)
                        .addGap(92, 92, 92)
                        .addComponent(TraducirBtnMenu)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(EliminarBtnMenu)
                .addGap(69, 69, 69))
        );
        MenuElegirLayout.setVerticalGroup(
            MenuElegirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuElegirLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(MenuElegirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AgregarBtnMenu)
                    .addComponent(TraducirBtnMenu)
                    .addComponent(EliminarBtnMenu))
                .addGap(118, 118, 118))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Agregar Palabras");

        AddItaTxt2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel15.setText("Espa??ol:");

        AddSpaBtn2.setFont(new java.awt.Font("Verdana", 2, 11)); // NOI18N
        AddSpaBtn2.setText("Agregar");
        AddSpaBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSpaBtn2ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel16.setText("Frances:");

        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel17.setText("Italiano:");

        AddSpaTxt2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        AddEngTxt2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        AddFreTxt2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        AddFreTxt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddFreTxt2ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel18.setText("Ingles:");

        jButton2.setText("Atras");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuAgregarLayout = new javax.swing.GroupLayout(MenuAgregar.getContentPane());
        MenuAgregar.getContentPane().setLayout(MenuAgregarLayout);
        MenuAgregarLayout.setHorizontalGroup(
            MenuAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuAgregarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddSpaBtn2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuAgregarLayout.createSequentialGroup()
                        .addGroup(MenuAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(MenuAgregarLayout.createSequentialGroup()
                                .addGroup(MenuAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(MenuAgregarLayout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(97, 97, 97)
                                        .addGroup(MenuAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(AddEngTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel18)))
                                    .addComponent(AddSpaTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                                .addGroup(MenuAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AddFreTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)))
                            .addGroup(MenuAgregarLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(47, 47, 47)))
                        .addGap(60, 60, 60)
                        .addGroup(MenuAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddItaTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuAgregarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        MenuAgregarLayout.setVerticalGroup(
            MenuAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuAgregarLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(MenuAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(7, 7, 7)
                .addGroup(MenuAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddSpaTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddEngTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddFreTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddItaTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(AddSpaBtn2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        jLabel19.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel19.setText("Traducir Palabras");

        TranslateTxt2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        IdiomaOrigenBtn2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        IdiomaOrigenBtn2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Espanol", "Ingles", "Frances", "Italiano" }));
        IdiomaOrigenBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdiomaOrigenBtn2ActionPerformed(evt);
            }
        });

        TranslateBtn1.setFont(new java.awt.Font("Verdana", 2, 12)); // NOI18N
        TranslateBtn1.setText("Traducir");
        TranslateBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TranslateBtn1ActionPerformed(evt);
            }
        });

        IdiomaDestinoBtn2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        IdiomaDestinoBtn2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Espanol", "Ingles", "Frances", "Italiano" }));
        IdiomaDestinoBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdiomaDestinoBtn2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Idioma Origen");

        jLabel4.setText("Idioma Destino");

        TraduccionTxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuTraducirLayout = new javax.swing.GroupLayout(MenuTraducir.getContentPane());
        MenuTraducir.getContentPane().setLayout(MenuTraducirLayout);
        MenuTraducirLayout.setHorizontalGroup(
            MenuTraducirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuTraducirLayout.createSequentialGroup()
                .addGroup(MenuTraducirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuTraducirLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(MenuTraducirLayout.createSequentialGroup()
                        .addGroup(MenuTraducirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(MenuTraducirLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(TranslateTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(149, 149, 149)
                                .addComponent(TraduccionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MenuTraducirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(MenuTraducirLayout.createSequentialGroup()
                                    .addGap(198, 198, 198)
                                    .addComponent(TranslateBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(MenuTraducirLayout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(IdiomaOrigenBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(163, 163, 163)
                                    .addComponent(IdiomaDestinoBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel4))
                                .addGroup(MenuTraducirLayout.createSequentialGroup()
                                    .addGap(235, 235, 235)
                                    .addComponent(jLabel19))))
                        .addGap(0, 60, Short.MAX_VALUE)))
                .addContainerGap())
        );
        MenuTraducirLayout.setVerticalGroup(
            MenuTraducirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuTraducirLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel19)
                .addGap(59, 59, 59)
                .addGroup(MenuTraducirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdiomaOrigenBtn2)
                    .addComponent(IdiomaDestinoBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(57, 57, 57)
                .addComponent(TranslateBtn1)
                .addGap(47, 47, 47)
                .addGroup(MenuTraducirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TraduccionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TranslateTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jButton1)
                .addContainerGap())
        );

        MenuEliminar.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel9.setText("Eliminar Palabras");

        ElimTxt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ElimTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ElimTxtActionPerformed(evt);
            }
        });

        ElimBtn2.setFont(new java.awt.Font("Verdana", 2, 11)); // NOI18N
        ElimBtn2.setText("Eliminar");
        ElimBtn2.setToolTipText("");
        ElimBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ElimBtn2ActionPerformed(evt);
            }
        });

        PalabrasList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(PalabrasList);

        MostrarPalabras.setText("Mostrar Palabras");
        MostrarPalabras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarPalabrasActionPerformed(evt);
            }
        });

        AtrasElim.setText("Atras");
        AtrasElim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasElimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuEliminarLayout = new javax.swing.GroupLayout(MenuEliminar.getContentPane());
        MenuEliminar.getContentPane().setLayout(MenuEliminarLayout);
        MenuEliminarLayout.setHorizontalGroup(
            MenuEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuEliminarLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(MenuEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuEliminarLayout.createSequentialGroup()
                        .addComponent(ElimTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(MenuEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(ElimBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(182, Short.MAX_VALUE))
                    .addGroup(MenuEliminarLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(MenuEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MenuEliminarLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(MostrarPalabras))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuEliminarLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AtrasElim)
                                .addGap(28, 28, 28))))))
        );
        MenuEliminarLayout.setVerticalGroup(
            MenuEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuEliminarLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel9)
                .addGap(62, 62, 62)
                .addGroup(MenuEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ElimTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ElimBtn2))
                .addGroup(MenuEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuEliminarLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(MenuEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MostrarPalabras, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(43, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuEliminarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AtrasElim)
                        .addGap(19, 19, 19))))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        JLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabel.setText("Bienvenido al traductor");

        GeneradorBtn.setFont(new java.awt.Font("Verdana", 2, 12)); // NOI18N
        GeneradorBtn.setText("Continuar");
        GeneradorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeneradorBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JLabel)
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(GeneradorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(JLabel)
                .addGap(47, 47, 47)
                .addComponent(GeneradorBtn)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    void agregar(String Idioma, String Palabra) {
        
        if(!Idioma.isEmpty() && !Palabra.isEmpty()){
            Nodo p = ptr;
            while(p != null){
                if(p.Idiomas.equals(Idioma)){
                    NodoP q = new NodoP();
                    q.Palabras = Palabra;
                    q.linkPalabra = p.linkPalabra;
                    p.linkPalabra = q;
                    break;
                }
                p = p.linkIdiomas;
            }
        }
    }
    private void ElimTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ElimTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ElimTxtActionPerformed

    private void GeneradorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeneradorBtnActionPerformed
        ptr = addcola(ptr, "Espanol");
        ptr = addcola(ptr, "Ingles");
        ptr = addcola(ptr, "Frances");
        ptr = addcola (ptr, "Italiano");
        MenuElegir.setVisible(true);
        MenuElegir.setBounds(300, 200, 725, 315);
        setVisible(false);
    }//GEN-LAST:event_GeneradorBtnActionPerformed

    private void ElimBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ElimBtn2ActionPerformed
        String PalabraE = ElimTxt.getText();
        int pos = EliminarPalabra(ptr, PalabraE, "Espa??ol");
        //int pos = 1;
        EliminarPalabraC(ptr, pos, "Ingles");
        EliminarPalabraC(ptr, pos, "Frances");
        EliminarPalabraC(ptr, pos, "Italiano");
        ElimTxt.setText("");
    
    }//GEN-LAST:event_ElimBtn2ActionPerformed

    private void MostrarPalabrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarPalabrasActionPerformed
        Nodo p = ptr;
        showList(p.linkPalabra);
    }//GEN-LAST:event_MostrarPalabrasActionPerformed

    private void AddSpaBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSpaBtn2ActionPerformed
        String PalabraE = AddSpaTxt2.getText().trim();
        String PalabraIng = AddEngTxt2.getText().trim();
        String PalabraF = AddFreTxt2.getText().trim();
        String PalabraIta = AddItaTxt2.getText().trim();
        
        int sw = 0;
        Nodo p = ptr;
        NodoP q = p.linkPalabra;
        while (q != null) {
            if (q.Palabras.equals(PalabraE)) {
                sw = 1;
            }
            q = q.linkPalabra;
        }
        
        if (sw == 0) {
            agregar("Espanol", PalabraE);
            agregar("Ingles", PalabraIng);
            agregar("Frances", PalabraF);
            agregar("Italiano", PalabraIta); 
        } else {
            JOptionPane.showMessageDialog(null, "Esta palabra ya se encuentra en el traductor.");
        }
        
        AddSpaTxt2.setText("");
        AddEngTxt2.setText("");
        AddFreTxt2.setText("");
        AddItaTxt2.setText("");
    }//GEN-LAST:event_AddSpaBtn2ActionPerformed

    private void AddFreTxt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddFreTxt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddFreTxt2ActionPerformed

    private void IdiomaOrigenBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdiomaOrigenBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdiomaOrigenBtn2ActionPerformed

    private void TranslateBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TranslateBtn1ActionPerformed
        String IdiomaOri = IdiomaOrigenBtn2.getSelectedItem().toString();
        String IdiomaDest = IdiomaDestinoBtn2.getSelectedItem().toString();
        String w = TranslateTxt2.getText();
        TranslateWord(ptr, IdiomaOri,IdiomaDest,w);
    }//GEN-LAST:event_TranslateBtn1ActionPerformed

    private void IdiomaDestinoBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdiomaDestinoBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdiomaDestinoBtn2ActionPerformed

    private void AgregarBtnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarBtnMenuActionPerformed
        MenuAgregar.setVisible(true);
        MenuAgregar.setBounds(250, 250, 560, 340);
        
    }//GEN-LAST:event_AgregarBtnMenuActionPerformed

    private void TraducirBtnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TraducirBtnMenuActionPerformed
        MenuTraducir.setVisible(true);
        MenuTraducir.setBounds(630, 500, 650, 420);
    }//GEN-LAST:event_TraducirBtnMenuActionPerformed

    private void EliminarBtnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarBtnMenuActionPerformed
        MenuEliminar.setVisible(true);
        MenuEliminar.setBounds(1300, 500, 510, 390);
    }//GEN-LAST:event_EliminarBtnMenuActionPerformed

    private void AtrasElimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasElimActionPerformed
        MenuElegir.setVisible(true);
    }//GEN-LAST:event_AtrasElimActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MenuElegir.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        MenuElegir.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
    
    int EliminarPalabra(Nodo ptr, String word, String Idioma){
        Nodo p = ptr;
        int posicion = 1;
        
        // Arreglado
        if (p.linkPalabra != null) {
            NodoP anteQ = null;
            NodoP q = p.linkPalabra;
            while (q != null && !q.Palabras.equals(word)) {
                anteQ = q;
                q = q.linkPalabra;
                posicion++;
            }
            if (q != null && anteQ == null) {
                p.linkPalabra = q.linkPalabra;
                //q.linkPalabra = null;
            } else {
                if (q!=null && anteQ!=null) {
                    anteQ.linkPalabra = q.linkPalabra;
                    //q.linkPalabra = null;
                }
            }
        }
        return posicion;
    }
    
    void EliminarPalabraC(Nodo ptr, int pos,  String Idioma) {
        int cont = 1;
        Nodo p = ptr;
        while(p.linkIdiomas!=null && !p.Idiomas.equalsIgnoreCase(Idioma)){ 
            p = p.linkIdiomas;
        }
        if(p.linkPalabra!=null){
            NodoP anteQ = null;
            NodoP q = p.linkPalabra; 
            while(q!=null && cont != pos){ 
                anteQ = q;
                q = q.linkPalabra;
                cont++;
            }
            if(q!=null && anteQ==null){
                p.linkPalabra=q.linkPalabra;
            } else {
                if (q!=null && anteQ!=null) {
                    anteQ.linkPalabra = q.linkPalabra;
                }
            }
        }
        
        
        
        
    }
    
    
    
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
            java.util.logging.Logger.getLogger(Traductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Traductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Traductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Traductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Traductor().setVisible(true);
            }
        });
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddEngTxt2;
    private javax.swing.JTextField AddFreTxt2;
    private javax.swing.JTextField AddItaTxt2;
    private javax.swing.JButton AddSpaBtn2;
    private javax.swing.JTextField AddSpaTxt2;
    private javax.swing.JButton AgregarBtnMenu;
    private javax.swing.JButton AtrasElim;
    private javax.swing.JButton ElimBtn2;
    private javax.swing.JTextField ElimTxt;
    private javax.swing.JButton EliminarBtnMenu;
    private javax.swing.JButton GeneradorBtn;
    private javax.swing.JComboBox<String> IdiomaDestinoBtn2;
    private javax.swing.JComboBox<String> IdiomaOrigenBtn2;
    private javax.swing.JLabel JLabel;
    private javax.swing.JFrame MenuAgregar;
    private javax.swing.JFrame MenuElegir;
    private javax.swing.JFrame MenuEliminar;
    private javax.swing.JFrame MenuTraducir;
    private javax.swing.JButton MostrarPalabras;
    private javax.swing.JList<String> PalabrasList;
    private javax.swing.JLabel TraduccionTxt;
    private javax.swing.JButton TraducirBtnMenu;
    private javax.swing.JButton TranslateBtn1;
    private javax.swing.JTextField TranslateTxt2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
