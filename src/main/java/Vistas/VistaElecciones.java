/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Clases.ClsCandidato;
import Clases.ClsEleccion;
import Clases.ClsMensaje;
import Controladores.CtlCandidato;
import Controladores.CtlEleccion;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author larrc0
 */
public class VistaElecciones extends javax.swing.JFrame {
    JFrame menuPrincipal;
    CtlEleccion controladorEleccion;
    CtlCandidato controladorCandidato;

    /**
     * Creates new form VistaElecciones
     */
    public VistaElecciones(JFrame menuPrincipal) {
        initComponents();
        this.menuPrincipal = menuPrincipal;

        this.controladorEleccion = new CtlEleccion();
        this.controladorCandidato = new CtlCandidato();

        this.setDefaultCloseOperation(0);
        this.ObtenerElecciones();
        this.ObtenerCandidatos();

        this.EnabledControls(false);
        
        this.btnAdicionar.setEnabled(true);
        this.btnGuardar.setEnabled(false);
        this.btnEditar.setEnabled(true);
        this.btnActualizar.setEnabled(false);   
        this.btnCancelar.setEnabled(false);         

        
        // table header
        JTableHeader th = this.tblElecciones.getTableHeader();
        th.setFont(new Font("Segoe UI", Font.BOLD, 15));
        th.setBackground(Color.black);
        th.setForeground(Color.yellow);
        
        JTableHeader ch = this.tblEleCandidato.getTableHeader();
        ch.setFont(new Font("Segoe UI", Font.BOLD, 15));
        ch.setBackground(Color.black);
        ch.setForeground(Color.yellow);

        JTableHeader lc = this.tblCandidato.getTableHeader();
        lc.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lc.setBackground(Color.black);
        lc.setForeground(Color.yellow);

        JTableHeader ec = this.tblEleccionCandidato.getTableHeader();
        ec.setFont(new Font("Segoe UI", Font.BOLD, 15));
        ec.setBackground(Color.black);
        ec.setForeground(Color.yellow);
    }

    private void ClearControls(){
            this.txtIdEleccion.setText("");
            this.txtDescripcion.setText("");
            this.cboxCategorias.setSelectedItem("");
            
            try {
                Date today = java.sql.Date.valueOf(LocalDate.now());
                this.dateFechaInicio.setDate(today);
                this.dateFechaFinal.setDate(today);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            this.cboxEstados.setSelectedItem("");
    }
    
    private void EnabledControls(boolean flag){
            this.txtIdEleccion.setEnabled(false);
            this.txtDescripcion.setEnabled(flag);
            this.cboxCategorias.setEnabled(flag);
            this.dateFechaInicio.setEnabled(flag);
            this.dateFechaFinal.setEnabled(flag);
            this.cboxEstados.setEnabled(flag);
    }    

    public void ObtenerElecciones() {
        LinkedList<ClsEleccion> listaElecciones = this.controladorEleccion.ObtenerElecciones();
        this.actualizarTabla(listaElecciones);
    }
    
   public void ObtenerCandidatos(){
        LinkedList<ClsCandidato> listaCandidatos = this.controladorCandidato.ObtenerCandidatos();
        this.actualizarCandidatoTabla(listaCandidatos);
    } 
    
    private void actualizarCandidatoTabla(LinkedList<ClsCandidato> candidatos){
        DefaultTableModel modelo3 = (DefaultTableModel) this.tblCandidato.getModel();
        modelo3.setRowCount(0);
        for (ClsCandidato c : candidatos){
            Object[] fila ={c.getNumeroDocumento(),  c.getNombre(),c.getPartidopolitico()};
            modelo3.addRow(fila);
        }
        this.tblCandidato.getColumnModel().getColumn(0).setMinWidth(0);
        this.tblCandidato.getColumnModel().getColumn(0).setMaxWidth(0);
        this.tblCandidato.getColumnModel().getColumn(0).setWidth(0);
    }	

   
    
    private void actualizarTabla(LinkedList<ClsEleccion> elecciones) {
        DefaultTableModel modelo1 = (DefaultTableModel) this.tblElecciones.getModel();
        modelo1.setRowCount(0);
        
        DefaultTableModel modelo2 = (DefaultTableModel) this.tblEleCandidato.getModel();
        modelo2.setRowCount(0);
        
        
        for (ClsEleccion c : elecciones) {
        
            String fecha = c.getFechainicio();
            String[] arrayFecha = fecha.split("-",2);
            Object[] fila = {c.getIdeleccion(), c.getCategoria(),c.getDescripcion(),arrayFecha[0]};
            modelo1.addRow(fila);
            modelo2.addRow(fila);
        }
        this.tblElecciones.getColumnModel().getColumn(0).setMinWidth(0);
        this.tblElecciones.getColumnModel().getColumn(0).setMaxWidth(0);
        this.tblElecciones.getColumnModel().getColumn(0).setWidth(0);
        this.tblElecciones.getColumnModel().getColumn(3).setMinWidth(50);
        this.tblElecciones.getColumnModel().getColumn(3).setMaxWidth(50);
        this.tblElecciones.getColumnModel().getColumn(3).setWidth(50);

        this.tblEleCandidato.getColumnModel().getColumn(0).setMinWidth(0);
        this.tblEleCandidato.getColumnModel().getColumn(0).setMaxWidth(0);
        this.tblEleCandidato.getColumnModel().getColumn(0).setWidth(0);
        this.tblEleCandidato.getColumnModel().getColumn(3).setMaxWidth(50);
        this.tblEleCandidato.getColumnModel().getColumn(3).setMaxWidth(50);
        this.tblEleCandidato.getColumnModel().getColumn(3).setWidth(50);
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblElecciones = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnAdicionar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        dateFechaInicio = new com.toedter.calendar.JDateChooser();
        dateFechaFinal = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtIdEleccion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        cboxCategorias = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cboxEstados = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEleCandidato = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCandidato = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblEleccionCandidato = new javax.swing.JTable();
        btnAsociar = new javax.swing.JButton();
        btnDelAsociar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestión de las Elecciones");
        jLabel1.setToolTipText("");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setPreferredSize(new java.awt.Dimension(526, 499));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Elecciones"));

        tblElecciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Categoria", "Descripción", "Año"
            }
        ));
        tblElecciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEleccionesMouseClicked(evt);
            }
        });
        tblElecciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblEleccionesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblEleccionesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblElecciones);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(245, 245, 245))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));
        jPanel3.setPreferredSize(new java.awt.Dimension(110, 280));

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.setPreferredSize(new java.awt.Dimension(72, 22));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de la Elección"));

        jLabel2.setText("Identificación  Elección:");

        jLabel3.setText("Descripción:");

        jLabel4.setText("Fecha de Inicio:");

        jLabel5.setText("Fecha Final:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jLabel6.setText("Categoría:");

        cboxCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Presidenciales 1ra Vuelta", "Presidenciales 2da Vuelta", "Legislativas", "Regionales" }));

        jLabel7.setText("Estado:");

        cboxEstados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cerrada", "Abierta" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dateFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdEleccion)
                            .addComponent(cboxCategorias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboxEstados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(6, 6, 6))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdEleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateFechaFinal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFechaInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Elecciones", jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel5.setPreferredSize(new java.awt.Dimension(540, 391));

        tblEleCandidato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Categoría", "Descripción", "Año"
            }
        ));
        tblEleCandidato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEleCandidatoMouseClicked(evt);
            }
        });
        tblEleCandidato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblEleCandidatoKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tblEleCandidato);

        tblCandidato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Candidato"
            }
        ));
        jScrollPane4.setViewportView(tblCandidato);

        tblEleccionCandidato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Partido", "Cargo"
            }
        ));
        jScrollPane5.setViewportView(tblEleccionCandidato);

        btnAsociar.setText("Asociar Candidato");
        btnAsociar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsociarActionPerformed(evt);
            }
        });

        btnDelAsociar.setText("Eliminar Asociación");
        btnDelAsociar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelAsociarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane5))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnAsociar)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelAsociar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAsociar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelAsociar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Candidatos", jPanel5);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.setVisible(false);
        this.menuPrincipal.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void tblEleccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEleccionesMouseClicked
        llenarCampos();
    }//GEN-LAST:event_tblEleccionesMouseClicked

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        this.ClearControls();
        this.EnabledControls(true);
        this.btnAdicionar.setEnabled(false);
        this.btnGuardar.setEnabled(true);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnCancelar.setEnabled(true);
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        ClsMensaje respuesta;

        String descripcion = this.txtDescripcion.getText();
        String categoria = this.cboxCategorias.getSelectedItem().toString();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaini = formato.format(this.dateFechaInicio.getDate());
        String fechafin = formato.format(this.dateFechaFinal.getDate());
        String estado = this.cboxEstados.getSelectedItem().toString();

        String fila = this.controladorEleccion.obtenerFilas();
        String[] arrayFecha = fechaini.split("-",2);
        String ideleccion = fila + "-" + categoria + "-" + arrayFecha[0];

                
        ClsEleccion eleccion = new ClsEleccion(ideleccion, descripcion, categoria,fechaini,fechafin,estado);
        respuesta = this.controladorEleccion.agregarEleccion(eleccion);

        if (respuesta.getTipo().equals(ClsMensaje.OK)) {
            JOptionPane.showMessageDialog(rootPane, respuesta.getTexto());
        }else {
            JOptionPane.showMessageDialog(rootPane, respuesta.getTexto());
        }
        ObtenerElecciones();
        llenarCampos();
        this.EnabledControls(false);

        this.btnAdicionar.setEnabled(true);
        this.btnEliminar.setEnabled(true);
        this.btnEditar.setEnabled(true);
        this.btnGuardar.setEnabled(false);
        this.btnActualizar.setEnabled(false);
        this.btnCancelar.setEnabled(false);
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.EnabledControls(true);
        this.btnEditar.setEnabled(false);
        this.btnActualizar.setEnabled(true);
        this.btnAdicionar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnCancelar.setEnabled(true);

        //this.txtIdEleccion.setEnabled(false);

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        ClsMensaje respuesta;

        String ideleccion = this.txtIdEleccion.getText();
        String descripcion = this.txtDescripcion.getText();
        String categoria = this.cboxCategorias.getSelectedItem().toString();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaini = formato.format(this.dateFechaInicio.getDate());
        String fechafin = formato.format(this.dateFechaFinal.getDate());
        String estado = this.cboxEstados.getSelectedItem().toString();

        ClsEleccion eleccion = new ClsEleccion(ideleccion, descripcion, categoria,fechaini,fechafin,estado);
        respuesta = this.controladorEleccion.actualizarEleccion(eleccion);

        if (respuesta.getTipo().equals(ClsMensaje.OK)) {
            JOptionPane.showMessageDialog(rootPane, respuesta.getTexto());
        }
        ObtenerElecciones();
        this.EnabledControls(false);
        this.btnAdicionar.setEnabled(true);
        this.btnEliminar.setEnabled(true);
        this.btnEditar.setEnabled(true);
        this.btnGuardar.setEnabled(false);
        this.btnActualizar.setEnabled(false);
        this.btnCancelar.setEnabled(false);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.EnabledControls(false);
        this.btnAdicionar.setEnabled(true);
        this.btnEliminar.setEnabled(true);
        this.btnEditar.setEnabled(true);
        this.btnGuardar.setEnabled(false);
        this.btnActualizar.setEnabled(false);
        this.btnCancelar.setEnabled(false);

        llenarCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = this.tblElecciones.getSelectedRow();
        String ideleccion = this.tblElecciones.getValueAt(fila, 0).toString();

        ClsMensaje respuesta = this.controladorEleccion.eliminarEleccion(ideleccion);

        if (respuesta.getTipo().equals(ClsMensaje.OK)) {
            JOptionPane.showMessageDialog(rootPane, respuesta.getTexto());
        }
        ObtenerElecciones();
        llenarCampos();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblEleccionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblEleccionesKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblEleccionesKeyPressed

    private void tblEleccionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblEleccionesKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP)  {
            //this.txtNombre.setText("Down");
            llenarCampos();
        }        
    }//GEN-LAST:event_tblEleccionesKeyReleased

    private void btnAsociarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsociarActionPerformed
        int columna = 0;
        int fila = this.tblEleCandidato.getSelectedRow();
        String ideleccion = this.tblEleCandidato.getValueAt(fila, 0).toString();
        
        int fila1 = this.tblCandidato.getSelectedRow();
        String idcandidato = this.tblCandidato.getValueAt(fila1, 0).toString();
        
        
        ClsMensaje respuesta = this.controladorEleccion.asociarCandidato(idcandidato,ideleccion);
        if (respuesta.getTipo().equals(ClsMensaje.OK)) {
            JOptionPane.showMessageDialog(rootPane, respuesta.getTexto());
            this.obtenerCandidatosPorEleccion(ideleccion);
        }else {
            JOptionPane.showMessageDialog(rootPane, respuesta.getTexto());
        }
    }//GEN-LAST:event_btnAsociarActionPerformed

    private void tblEleCandidatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEleCandidatoMouseClicked
        // TODO add your handling code here:
        int columna = 0;
        int fila = this.tblEleCandidato.getSelectedRow();
        String ideleccion = this.tblEleCandidato.getValueAt(fila, 0).toString();        
        this.obtenerCandidatosPorEleccion(ideleccion);
    }//GEN-LAST:event_tblEleCandidatoMouseClicked

    private void btnDelAsociarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelAsociarActionPerformed
        int fila = this.tblEleCandidato.getSelectedRow();
        String ideleccion = this.tblEleCandidato.getValueAt(fila, 0).toString();
        
        int fila1 = this.tblEleccionCandidato.getSelectedRow();
        String idcandidato = this.tblEleccionCandidato.getValueAt(fila1, 0).toString();

        ClsMensaje respuesta = this.controladorEleccion.borraAsociarCandidato(idcandidato,ideleccion);
        if (respuesta.getTipo().equals(ClsMensaje.OK)) {
            JOptionPane.showMessageDialog(rootPane, respuesta.getTexto());
            this.obtenerCandidatosPorEleccion(ideleccion);
        }else {
            JOptionPane.showMessageDialog(rootPane, respuesta.getTexto());
        }
    }//GEN-LAST:event_btnDelAsociarActionPerformed

    private void tblEleCandidatoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblEleCandidatoKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP)  {
            int columna = 0;
            int fila = this.tblEleCandidato.getSelectedRow();
            String ideleccion = this.tblEleCandidato.getValueAt(fila, 0).toString();        
            this.obtenerCandidatosPorEleccion(ideleccion);
        }        
    }//GEN-LAST:event_tblEleCandidatoKeyReleased

    private void obtenerCandidatosPorEleccion(String idEleccion){
        LinkedList<ClsCandidato> candidatos = this.controladorEleccion.ObtenerCandidatosEleccion(idEleccion);
        this.actualizarTablaAsociados(candidatos);
    }

    private void actualizarTablaAsociados(LinkedList<ClsCandidato> lista) {
        DefaultTableModel modelo4 = (DefaultTableModel) this.tblEleccionCandidato.getModel();
        modelo4.setRowCount(0);
        
        for (ClsCandidato c : lista) {
            Object[] fila = {c.getNumeroDocumento(), c.getNombre(),c.getPartidopolitico(),c.getCargo()};
            modelo4.addRow(fila);
        }
        this.tblEleccionCandidato.getColumnModel().getColumn(0).setMinWidth(0);
        this.tblEleccionCandidato.getColumnModel().getColumn(0).setMaxWidth(0);
        this.tblEleccionCandidato.getColumnModel().getColumn(0).setWidth(0);
    }                        




    
    private void llenarCampos(){
        int fila = this.tblElecciones.getSelectedRow();
        String id = this.tblElecciones.getValueAt(fila, 0).toString();

        ClsEleccion eleccion = this.controladorEleccion.recuperarEleccion(id);
        if (eleccion != null){
            this.txtIdEleccion.setText(eleccion.getIdeleccion());
            this.txtDescripcion.setText(eleccion.getDescripcion());
            this.cboxCategorias.setSelectedItem(eleccion.getCategoria());
            this.cboxEstados.setSelectedItem(eleccion.getEstado());
            
            try {
                String finicio = eleccion.getFechainicio();
                java.util.Date dfi = new SimpleDateFormat("yyyy-MM-dd").parse(finicio);                
                this.dateFechaInicio.setDate(dfi);
                String ffinal = eleccion.getFechafinal();
                java.util.Date dff = new SimpleDateFormat("yyyy-MM-dd").parse(ffinal);                
                this.dateFechaFinal.setDate(dff);
            } catch (Exception e) {
                System.out.println(e.getMessage());
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
            java.util.logging.Logger.getLogger(VistaElecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaElecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaElecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaElecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaElecciones(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAsociar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDelAsociar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cboxCategorias;
    private javax.swing.JComboBox<String> cboxEstados;
    private com.toedter.calendar.JDateChooser dateFechaFinal;
    private com.toedter.calendar.JDateChooser dateFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblCandidato;
    private javax.swing.JTable tblEleCandidato;
    private javax.swing.JTable tblEleccionCandidato;
    private javax.swing.JTable tblElecciones;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtIdEleccion;
    // End of variables declaration//GEN-END:variables
}
