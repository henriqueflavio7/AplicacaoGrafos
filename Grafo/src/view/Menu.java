package view;

import br.com.davesmartins.graphviewlib.ViewGraph;
import br.com.davesmartins.graphviewlib.erro.EGraphViewExcpetion;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.Aresta;
import model.Grafo;
import model.TipoGrafo;
import model.Vertice;

public class Menu extends javax.swing.JFrame {

    private Vertice vertice;
    private Aresta aresta;
    private Grafo grafo = new Grafo();
    private ArrayList<Vertice> listaVertice = new ArrayList<Vertice>();
    private ArrayList<Aresta> listaAresta = new ArrayList<Aresta>();
    private List<List<Vertice>> listaAdjacencia = new ArrayList<List<Vertice>>();
    private List<Vertice> nosVisitados = new ArrayList<Vertice>();
    private List<Vertice> todosNos = new ArrayList<Vertice>();
    private List<Vertice> nosDestino = new ArrayList<Vertice>();
    private List<Vertice> nosOrigem = new ArrayList<Vertice>();
    XStream xstream = new XStream(new DomDriver());

    public Menu() {
        initComponents();
        xstream.alias("Node", Vertice.class);
        xstream.alias("Graph", Grafo.class);
        xstream.alias("edge", Aresta.class);
        xstream.omitField(Aresta.class, "v1");
        xstream.omitField(Aresta.class, "v2");
        xstream.useAttributeFor("source", String.class);
        xstream.useAttributeFor("target", String.class);
        xstream.addImplicitCollection(Grafo.class, "listaVertice", Vertice.class);
        xstream.addImplicitCollection(Grafo.class, "listaAresta", Aresta.class);
        xstream.useAttributeFor("id", String.class);
        xstream.useAttributeFor("valor", int.class);
        xstream.useAttributeFor("ordenacao", TipoGrafo.class);
        xstream.aliasAttribute("edgedefault", "tipo");

    }

    public List<Aresta> buscaProf(Vertice no) {
        List<Aresta> arestasSelecionadas = new ArrayList<Aresta>();
        List<Aresta> retornoArestas = new ArrayList<Aresta>();
        nosVisitados.add(no);
        for (List<Vertice> lista : listaAdjacencia) {
            if (lista.get(0) == no) {
                for (int i = 0; i < lista.size(); i++) {
                    if (!nosVisitados.contains(lista.get(i))) {
                        for (Aresta ares : listaAresta) {
                            if ((no.getId().equals(ares.getSource()) && lista.get(i).getId().equals(ares.getTarget())) || (lista.get(i).getId().equals(ares.getSource()) && no.getId().equals(ares.getTarget()))) {
                                for (Aresta are : buscaProf(lista.get(i))) {
                                    arestasSelecionadas.add(are);
                                }
                                retornoArestas.add(ares);
                                break;
                            }
                        }
                    }
                }
                break;
            }
        }
        for (Aresta are : arestasSelecionadas) {
            retornoArestas.add(are);
        }
        return retornoArestas;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textAresta = new javax.swing.JTextField();
        textVertice = new javax.swing.JTextField();
        InsereVertice = new javax.swing.JButton();
        InsereAresta = new javax.swing.JButton();
        vertice1 = new javax.swing.JComboBox();
        vertice2 = new javax.swing.JComboBox();
        nomeGrafo = new javax.swing.JTextField();
        criarMatrizIncidencia = new javax.swing.JButton();
        CriarMatrizAdjacencia = new javax.swing.JButton();
        CriarListaAdjacencia = new javax.swing.JToggleButton();
        InformacoesGrafo = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        valor = new javax.swing.JTextField();
        salvarGrafo = new javax.swing.JButton();
        abrirGrafo = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButtonDijkstra = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jButtonPrim = new javax.swing.JButton();
        jButtonKruskal = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAresta = new javax.swing.JTable();
        DeletaAresta = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableVertice = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jButtonMalgrange = new javax.swing.JButton();

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Inserir Aresta");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Inserir");

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setText("IFGraph");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setText("Aresta");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setText("Vértice");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        textAresta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textArestaActionPerformed(evt);
            }
        });
        getContentPane().add(textAresta, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 140, 28));

        textVertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textVerticeActionPerformed(evt);
            }
        });
        getContentPane().add(textVertice, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 124, 28));

        InsereVertice.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        InsereVertice.setText("Inserir");
        InsereVertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirVertice(evt);
            }
        });
        getContentPane().add(InsereVertice, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 90, 36));

        InsereAresta.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        InsereAresta.setText("Inserir");
        InsereAresta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirAresta(evt);
            }
        });
        getContentPane().add(InsereAresta, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 90, 40));

        getContentPane().add(vertice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 50, -1));

        vertice2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vertice2ActionPerformed(evt);
            }
        });
        getContentPane().add(vertice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 50, -1));

        nomeGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeGrafoActionPerformed(evt);
            }
        });
        getContentPane().add(nomeGrafo, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 60, 350, 27));

        criarMatrizIncidencia.setText("Matriz Incidencia");
        criarMatrizIncidencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarMatrizIncidenciaActionPerformed(evt);
            }
        });
        getContentPane().add(criarMatrizIncidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 135, 34));

        CriarMatrizAdjacencia.setText("Matriz Adjacencia");
        CriarMatrizAdjacencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CriarMatrizAdjacenciaActionPerformed(evt);
            }
        });
        getContentPane().add(CriarMatrizAdjacencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 135, 33));

        CriarListaAdjacencia.setText("Lista Adjacencia");
        CriarListaAdjacencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CriarListaAdjacenciaActionPerformed(evt);
            }
        });
        getContentPane().add(CriarListaAdjacencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 135, 33));

        InformacoesGrafo.setText("InformaçõesGrafo");
        InformacoesGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InformacoesGrafoActionPerformed(evt);
            }
        });
        getContentPane().add(InformacoesGrafo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 135, 33));

        jLabel14.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel14.setText("Nome:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, -1, -1));

        valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorActionPerformed(evt);
            }
        });
        getContentPane().add(valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 140, 30));

        salvarGrafo.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        salvarGrafo.setText("Salvar Grafo");
        salvarGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarGrafoActionPerformed(evt);
            }
        });
        getContentPane().add(salvarGrafo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 130, 50));

        abrirGrafo.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        abrirGrafo.setText("Abrir Grafo");
        abrirGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirGrafoActionPerformed(evt);
            }
        });
        getContentPane().add(abrirGrafo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 130, 50));

        jToggleButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jToggleButton1.setText("Mostrar Grafo");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1mostrarGrafo(evt);
            }
        });
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, -1, 50));

        jButtonDijkstra.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonDijkstra.setText("Dijkstra");
        jButtonDijkstra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDijkstraActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDijkstra, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 650, 100, 40));

        jLabel17.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel17.setText("Implementações complexas:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 590, -1, -1));

        jButtonPrim.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonPrim.setText("Prim");
        jButtonPrim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrimActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPrim, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 650, 100, 40));

        jButtonKruskal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonKruskal.setText("Kruskal");
        jButtonKruskal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKruskalActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonKruskal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 650, 100, 40));

        jTableAresta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Source", "Target", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableAresta);

        DeletaAresta.setText("Excluir aresta");
        DeletaAresta.setToolTipText("");
        DeletaAresta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletaArestaActionPerformed(evt);
            }
        });

        jTableVertice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableVertice);

        jButton3.setText("Excluir vertice");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(DeletaAresta)
                        .addGap(122, 122, 122)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeletaAresta)
                    .addComponent(jButton3))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, 470, 340));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel6.setText("Selecione o tipo do grafo:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 330, 40));

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel7.setText("Digite o nome do grafo:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 171, -1));

        jLabel15.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel15.setText("Valor:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, -1, -1));

        jLabel18.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel18.setText("Nome:");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jRadioButton2.setText("Grafo não Orientado");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2grafoNaoOrdenado(evt);
            }
        });
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 190, 40));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jRadioButton1.setText("Grafo Orientado");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1grafoOrdenado(evt);
            }
        });
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 138, 35));

        jButtonMalgrange.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonMalgrange.setText("Malgrange");
        jButtonMalgrange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMalgrangeActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMalgrange, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 650, 110, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textArestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textArestaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textArestaActionPerformed

    private void textVerticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textVerticeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textVerticeActionPerformed

    private void inserirAresta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirAresta
        aresta = new Aresta();
        aresta.setNome(textAresta.getText());
        if (valor.getText() == "") {
            aresta.setValor(0);
        } else {
            aresta.setValor(parseInt(valor.getText()));
        }
        aresta.setV1(listaVertice.get(vertice1.getSelectedIndex()));
        aresta.setV2(listaVertice.get(vertice2.getSelectedIndex()));
        listaAresta.add(aresta);

        textAresta.setText(null);
        valor.setText(null);

        DefaultTableModel linha = (DefaultTableModel) jTableAresta.getModel();

        linha.addRow(new String[]{aresta.getNome(), aresta.getSource(), aresta.getTarget(), Integer.toString(aresta.getValor())});

    }//GEN-LAST:event_inserirAresta

    private void inserirVertice(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirVertice
        vertice = new Vertice();
        vertice.setNome(textVertice.getText());
        listaVertice.add(vertice);

        vertice1.addItem(vertice.getId());
        vertice2.addItem(vertice.getId());
        DefaultTableModel linha = (DefaultTableModel) jTableVertice.getModel();
        linha.addRow(new String[]{vertice.getId()});
        textVertice.setText(null);
    }//GEN-LAST:event_inserirVertice

    private void vertice2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vertice2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vertice2ActionPerformed

    private void nomeGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeGrafoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeGrafoActionPerformed

    private void criarMatrizIncidenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criarMatrizIncidenciaActionPerformed
        int control = 0;
        String matrizIncidencia = "";
        Grafo g = grafo;
        int[][] v = g.criarMatrizIncidencia(g);
        for (int i = 0; i <= (g.getListaAresta().size() - 1); i++) {
            matrizIncidencia += "\n Matriz Incidencia \n";
            if (control == 0) {
                control = 1;
                matrizIncidencia += "             " + g.getListaAresta().get(i).getNome();
            } else {
                matrizIncidencia += "             " + g.getListaAresta().get(i).getNome();
            }
        }
        for (int j = 0; j <= (g.getListaVertice().size() - 1); j++) {
            matrizIncidencia += "          \n";
            matrizIncidencia += "          " + g.getListaVertice().get(j).getId();
            for (int i = 0; i <= (g.getListaAresta().size() - 1); i++) {
                matrizIncidencia += "  " + v[j][i];
            }
        }

        JOptionPane.showMessageDialog(null, matrizIncidencia);
    }//GEN-LAST:event_criarMatrizIncidenciaActionPerformed

    private void CriarMatrizAdjacenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CriarMatrizAdjacenciaActionPerformed
        String matrizAdjacencia = "";
        int control = 0;
        Grafo g = grafo;
        int[][] v = g.criarMatrizAdjacencia(g);
        for (int i = 0; i <= (g.getListaVertice().size() - 1); i++) {
            if (control == 0) {
                matrizAdjacencia += "\nVertices   ";
                control = 1;
                matrizAdjacencia += "   " + g.getListaVertice().get(i).getId();
            } else {
                matrizAdjacencia += "   " + g.getListaVertice().get(i).getId();
            }
        }
        for (int j = 0; j <= (g.getListaVertice().size() - 1); j++) {
            matrizAdjacencia += "\n";
            matrizAdjacencia += "                  " + g.getListaVertice().get(j).getId();
            for (int i = 0; i <= (g.getListaVertice().size() - 1); i++) {
                matrizAdjacencia += "  " + v[j][i];
            }
        }
        JOptionPane.showMessageDialog(null, matrizAdjacencia);
    }//GEN-LAST:event_CriarMatrizAdjacenciaActionPerformed

    private void CriarListaAdjacenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CriarListaAdjacenciaActionPerformed
        String listaAdjacenciaImpressao = " Lista de Adjacencia ";

        ArrayList<ArrayList> listaAdjacencia = grafo.criarListaAdjacencia(grafo);
        for (int i = 0; i < listaAdjacencia.size(); i++) {
            ArrayList<String> lista = listaAdjacencia.get(i);
            listaAdjacenciaImpressao += "\n";
            for (int j = 0; j < lista.size(); j++) {
                listaAdjacenciaImpressao += lista.get(j) + "->";
                if (j == (lista.size() - 1)) {
                    listaAdjacenciaImpressao += "null";
                }
            }
        }
        JOptionPane.showMessageDialog(null, listaAdjacenciaImpressao);
    }//GEN-LAST:event_CriarListaAdjacenciaActionPerformed

    private void InformacoesGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InformacoesGrafoActionPerformed

        String informacoesGrafos = "";
        informacoesGrafos += "\n A ordem do grafo é: " + grafo.getListaVertice().size();
        informacoesGrafos += "\n\n Incidentes do Grafo: ";
        for (int i = 0; i <= grafo.getListaAresta().size() - 1; i++) {
            informacoesGrafos += "\n Os vertices: " + grafo.getListaAresta().get(i).getSource() + " e " + grafo.getListaAresta().get(i).getTarget() + " são incidentes a aresta: " + grafo.getListaAresta().get(i).getNome();
        }
        informacoesGrafos += "\n\n Adjacentes do Grafo: ";
        for (int i = 0; i <= grafo.getListaAresta().size() - 1; i++) {
            informacoesGrafos += "\n Os vertices: " + grafo.getListaAresta().get(i).getSource() + " e " + grafo.getListaAresta().get(i).getTarget() + " são adjacentes a aresta: " + grafo.getListaAresta().get(i).getNome();
        }
        if (grafo.getOrdenacao() == TipoGrafo.unidirected) {
            for (int i = 0; i <= grafo.getListaAresta().size() - 1; i++) {
                String vertice1 = grafo.getListaAresta().get(i).getSource();
                String vertice2 = grafo.getListaAresta().get(i).getTarget();
                for (int j = 0; j <= grafo.getListaAresta().size() - 1; j++) {
                    String vertice3 = grafo.getListaAresta().get(j).getSource();
                    String vertice4 = grafo.getListaAresta().get(j).getTarget();
                    if (grafo.getListaAresta().get(i).getNome() == grafo.getListaAresta().get(j).getNome()) {
                        break;
                    } else if (vertice1.equals(vertice3) || vertice2.equals(vertice4) || vertice1.equals(vertice4) || vertice2.equals(vertice3)) {
                        informacoesGrafos += "\n As arestas: " + grafo.getListaAresta().get(i).getNome() + " e " + grafo.getListaAresta().get(j).getNome() + " são adjacentes";

                    }
                }
            }
        }

        informacoesGrafos += "\n\n Grau dos vertices: ";
        int x = 0;
        int y = 0;
        if (grafo.getOrdenacao() == TipoGrafo.unidirected) {
            for (int i = 0; i <= grafo.getListaVertice().size() - 1; i++) {
                String vertice1 = grafo.getListaVertice().get(i).getId();
                for (int j = 0; j <= grafo.getListaAresta().size() - 1; j++) {
                    if (vertice1.equals(grafo.getListaAresta().get(j).getSource()) || vertice1.equals(grafo.getListaAresta().get(j).getTarget())) {
                        x++;
                    }
                }
                informacoesGrafos += "\n vertice: " + grafo.getListaVertice().get(i).getId() + ": " + x;
                x = 0;
            }
        }
        if (grafo.getOrdenacao() == TipoGrafo.directed) {
            for (int i = 0; i <= grafo.getListaVertice().size() - 1; i++) {
                String vertice1 = grafo.getListaVertice().get(i).getId();
                for (int j = 0; j <= grafo.getListaAresta().size() - 1; j++) {
                    if (vertice1.equals(grafo.getListaAresta().get(j).getSource())) {
                        x++;
                    }
                    if (vertice1.equals(grafo.getListaAresta().get(j).getTarget())) {
                        y++;
                    }
                }
                informacoesGrafos += "\n vertice: " + grafo.getListaVertice().get(i).getId() + " Grau de Emissão: " + x;
                informacoesGrafos += "\n vertice: " + grafo.getListaVertice().get(i).getId() + " Grau de Recepção: " + y;
                x = 0;
                y = 0;
            }
        }
        JOptionPane.showMessageDialog(null, informacoesGrafos);

    }//GEN-LAST:event_InformacoesGrafoActionPerformed

    private void DeletaArestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletaArestaActionPerformed
        listaAresta.remove(jTableAresta.getSelectedRow());
        ((DefaultTableModel) jTableAresta.getModel()).removeRow(jTableAresta.getSelectedRow());
    }//GEN-LAST:event_DeletaArestaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        listaVertice.remove(jTableVertice.getSelectedRow());
        ((DefaultTableModel) jTableVertice.getModel()).removeRow(jTableVertice.getSelectedRow());

    }//GEN-LAST:event_jButton3ActionPerformed

    private void valorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorActionPerformed

    private void salvarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarGrafoActionPerformed
        grafo.setNome(nomeGrafo.getText());
        grafo.novaListaAresta(listaAresta);
        grafo.novaListaVertice(listaVertice);
        nomeGrafo.setText(null);

        String nomeGrafoxml = "";
        nomeGrafoxml = grafo.getNome();
        nomeGrafoxml += ".xml";

        String xml = xstream.toXML(grafo);

        System.out.println(xml);
        grafo = null;
        grafo = (Grafo) xstream.fromXML(xml);

        xml = xstream.toXML(grafo);
        System.out.println(xml);

        try {
            File xmlFile = new File(nomeGrafoxml);
            xstream.toXML(grafo, new FileWriter(xmlFile));
        } catch (IOException ex) {
            System.out.println("Erro ao Gravar Arquivo");
        }
        JOptionPane.showMessageDialog(rootPane, "Salvo com sucesso");
    }//GEN-LAST:event_salvarGrafoActionPerformed

    private void abrirGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirGrafoActionPerformed
        //Abrir do arquivo xml
        DefaultTableModel linhaVertice = (DefaultTableModel) jTableVertice.getModel();
        DefaultTableModel linhaAresta = (DefaultTableModel) jTableAresta.getModel();
        File xmlFileLer = null;
        JFileChooser arquivo = new JFileChooser();
        FileNameExtensionFilter filtroXML = new FileNameExtensionFilter("Arquivos XML", "xml");
        arquivo.addChoosableFileFilter(filtroXML);
        arquivo.setAcceptAllFileFilterUsed(false);
        if (arquivo.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            xmlFileLer = new File(arquivo.getSelectedFile().getAbsolutePath());
        }

        //        xmlFileLer = new File("arq.xml");
        Grafo grafoLer = (Grafo) xstream.fromXML(xmlFileLer);
        String xmlLer = xstream.toXML(grafoLer);
        System.out.println(xmlLer);
        this.grafo = grafoLer;

        for (int i = 0; i < listaVertice.size(); i++) {
            linhaVertice.removeRow(i);
        }
        for (int i = 0; i < listaAresta.size(); i++) {
            linhaAresta.removeRow(i);
        }

        this.listaAresta = null;
        this.listaVertice = null;
        this.listaAresta = grafo.getListaAresta();
        this.listaVertice = grafo.getListaVertice();

        for (Vertice n : listaVertice) {
            linhaVertice.addRow(new String[]{n.getId()});
        }

        for (Aresta n : listaAresta) {
            linhaAresta.addRow(new String[]{n.getNome(), n.getSource(), n.getTarget(), Integer.toString(n.getValor())});

        }

    }//GEN-LAST:event_abrirGrafoActionPerformed

    private void jToggleButton1mostrarGrafo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1mostrarGrafo
        grafo.setNome(nomeGrafo.getText());
        grafo.novaListaAresta(listaAresta);
        grafo.novaListaVertice(listaVertice);
        nomeGrafo.setText(null);

        String nomeGrafoxml = "";
        nomeGrafoxml = grafo.getNome();
        nomeGrafoxml += ".xml";

        String xml = xstream.toXML(grafo);

        System.out.println(xml);
        grafo = null;
        grafo = (Grafo) xstream.fromXML(xml);

        xml = xstream.toXML(grafo);
        System.out.println(xml);

        try {
            File xmlFile = new File(nomeGrafoxml);
            xstream.toXML(grafo, new FileWriter(xmlFile));
        } catch (IOException ex) {
            System.out.println("Erro ao Gravar Arquivo");
        }
        JOptionPane.showMessageDialog(rootPane, "Representação grafica gerada");
        try {
            ViewGraph.generateViewGraphByFrame(grafo.getNome() + ".xml");
        } catch (EGraphViewExcpetion ex) {
            JOptionPane.showMessageDialog(null, "-->" + ex.getMensagem());
        }
    }//GEN-LAST:event_jToggleButton1mostrarGrafo

    private void jButtonDijkstraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDijkstraActionPerformed

        Grafo g = grafo.copiaGrafo(grafo, grafo.getNome() + "-dijkstra");

        List<Vertice> listaNosFechados = new ArrayList<>();

        List<Vertice> listaNosAbertos = new ArrayList<>();
        int qtNos = listaVertice.size();

        int[][] matrizD = new int[qtNos][qtNos];

        listaNosAbertos.addAll(listaVertice);

        String verticeRaiz = JOptionPane.showInputDialog("Digite o vértice raiz:");

        int[] tabelaD = new int[listaNosAbertos.size() - 1];

        List<Vertice> lista = new ArrayList<>();
        lista.addAll(listaNosAbertos);

        for (int i = 0; i < tabelaD.length; i++) {
            tabelaD[i] = Integer.MAX_VALUE;
        }

        Vertice vo = null;
        while (listaNosAbertos.size() > 0) {
            Vertice v = null;

            int distanciaAnterior = 0;
            if (listaNosFechados.size() == 0) {

                v = Vertice.getVerticeById(verticeRaiz, listaNosAbertos);
                vo = v;
            } else {
                v = listaNosAbertos.get(0);

            }
            listaNosFechados.add(v);
            listaNosAbertos.remove(v);

            if (v != vo) {
                distanciaAnterior = tabelaD[listaNosFechados.size() - 2];
                if (distanciaAnterior == Integer.MAX_VALUE) {
                    distanciaAnterior = 0;
                }

            }

            int i = listaNosFechados.size() - 1;
            for (Vertice a : listaNosAbertos) {
                Aresta a1 = Aresta.getArestaByVertices(v, a, listaAresta);
                if (a1 == null) {

                } else if (tabelaD[i] > a1.getValor() + distanciaAnterior) {
                    tabelaD[i] = a1.getValor() + distanciaAnterior;
                }
                i++;
            }

            for (int j = 0; j < tabelaD.length; j++) {
                System.out.print(tabelaD[j] + "- ");
            }
            System.out.println("");

        }

        int p = 1;
        String imprime = "";
        for (int j = 0; j < tabelaD.length; j++) {
            imprime += "(" + verticeRaiz + " , " + lista.get(p).getId() + ") = " + tabelaD[j] + "\n";
            p++;
        }

        JOptionPane.showMessageDialog(null, "Caminho Minímo:\n" + imprime);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDijkstraActionPerformed

    private void jButtonPrimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrimActionPerformed
        Grafo g = grafo.copiaGrafo(grafo, grafo.getNome() + "-prim");

        ArrayList<Aresta> arestas = new ArrayList<Aresta>();
        List<Aresta> arestasPossiveis = new ArrayList<Aresta>();
        List<Aresta> arestasOriginais = new ArrayList<Aresta>(listaAresta);

        List<Vertice> v = new ArrayList<Vertice>(listaVertice);

        List<Vertice> b = new ArrayList<Vertice>();
        b.add(listaVertice.get(0));
        v.remove(v.get(0));
        while (b.size() <= listaVertice.size()) {

            for (Aresta are : arestasOriginais) {
                if (are.getSource().equals(b.get(b.size() - 1).getId()) || are.getTarget().equals(b.get(b.size() - 1).getId())) {
                    if (arestas.isEmpty()) {
                        arestasPossiveis.add(are);
                    } else {
                        for (Vertice nov : v) {
                            if (nov.getId() == are.getSource()) {
                                for (Vertice nob : b) {
                                    if (nob.getId() == are.getTarget()) {
                                        arestasPossiveis.add(are);
                                        break;
                                    }
                                }
                            }
                        }
                        for (Vertice nov : v) {
                            if (nov.getId() == are.getTarget()) {
                                for (Vertice nob : b) {
                                    if (nob.getId() == are.getSource()) {
                                        arestasPossiveis.add(are);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            boolean bw = true;
            boolean bo = false;
            boolean bd = false;

            while (bw == true) {
                bw = false;
                for (Aresta aresPos : arestasPossiveis) {
                    String ao = aresPos.getSource();
                    String ad = aresPos.getTarget();
                    for (Vertice no1 : b) {
                        if (no1.getId() == ao) {
                            bo = true;
                            break;
                        } else {
                            bw = false;
                            bo = false;
                        }
                    }

                    for (Vertice no2 : b) {
                        if (no2.getId() == ad) {
                            bd = true;
                            break;
                        } else {
                            bw = false;
                            bd = false;
                        }
                    }

                    if (bo == true && bd == true) {
                        arestasPossiveis.remove(aresPos);
                        bw = true;
                        for (Aresta a : arestasOriginais) {
                            if (aresPos.getNome() == a.getNome() && aresPos.getValor() == a.getValor() && aresPos.getSource() == a.getTarget() && aresPos.getTarget() == a.getTarget()) {
                                arestasOriginais.remove(a);
                                break;
                            }
                        }
                        break;
                    } else {
                        bw = false;
                        bo = false;
                        bd = false;
                    }
                }
                if (bw == false) {
                    break;
                }
            }

            if (arestasPossiveis.size() > 0) {
                int valorMenor = arestasPossiveis.get(0).getValor();

                for (Aresta aresPos : arestasPossiveis) {
                    if (aresPos.getValor() < valorMenor) {
                        valorMenor = aresPos.getValor();
                    }
                }
                for (Aresta aresPos : arestasPossiveis) {

                    if (aresPos.getValor() == valorMenor) {
                        arestas.add(new Aresta(aresPos.getNome(), aresPos.getValor(), aresPos.getSource(), aresPos.getTarget()));
                        for (Aresta a : arestasPossiveis) {
                            if (aresPos.getNome() == a.getNome() && aresPos.getValor() == a.getValor() && aresPos.getSource() == a.getSource() && aresPos.getTarget() == a.getTarget()) {
                                arestasPossiveis.remove(a);
                                break;
                            }
                        }
                        for (Aresta a : arestasOriginais) {
                            if (aresPos.getNome() == a.getNome() && aresPos.getValor() == a.getValor() && aresPos.getSource() == a.getTarget() && aresPos.getTarget() == a.getTarget()) {
                                arestasOriginais.remove(a);
                                break;
                            }
                        }
                        break;
                    }
                }
            }

            if (b.size() < listaVertice.size()) {
                String ao = arestas.get(arestas.size() - 1).getSource();
                String ad = arestas.get(arestas.size() - 1).getTarget();

                for (Vertice nov : v) {
                    if (nov.getId() == ao) {
                        for (Vertice nob : b) {
                            if (nob.getId() == ad) {
                                //adiciona
                                b.add(new Vertice(ao));
                                v.remove(new Vertice(ao));
                                break;
                            }
                        }
                        break;
                    }
                }
                for (Vertice nov : v) {
                    if (nov.getId() == ad) {
                        for (Vertice nob : b) {
                            if (nob.getId() == ao) {
                                b.add(new Vertice(ad));
                                v.remove(new Vertice(ad));
                                break;
                            }
                        }
                        break;
                    }
                }
            } else {
                break;
            }
        }
        /*String T = "{";
        for (Aresta aresta : arestas) {
            T += aresta.getNome() + ", ";
        }
        T += "}";
        g.getListaAresta().clear();
        g.novaListaAresta(arestas);

   
        JOptionPane.showMessageDialog(null, "Conjunto de arestas da árvore geradora mínima:\n" + T);
         */
        String xml = xstream.toXML(g);

        System.out.println(xml);
        g = null;
        g = (Grafo) xstream.fromXML(xml);

        xml = xstream.toXML(g);
        System.out.println(xml);

        try {
            File xmlFile = new File("prim.xml");
            JOptionPane.showMessageDialog(null, xml);
            xstream.toXML(g, new FileWriter(xmlFile));
        } catch (IOException ex) {
            System.out.println("Erro ao Gravar Arquivo");
        }
    }//GEN-LAST:event_jButtonPrimActionPerformed

    private void jButtonKruskalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKruskalActionPerformed

        Grafo g = grafo.copiaGrafo(grafo, grafo.getNome() + "-kruskal");
        List<Aresta> arestasOrdenadas = new ArrayList<Aresta>();
        ArrayList<Aresta> novasArestas = new ArrayList<Aresta>();
        List<Vertice> nosLigados = new ArrayList<Vertice>();
        List<Vertice> nosSoltos = new ArrayList<Vertice>();
        for (Aresta are : g.getListaAresta()) {
            arestasOrdenadas.add(are);
        }
        Collections.sort(arestasOrdenadas);

        int j = 0;
        while (novasArestas.size() < (g.getListaVertice().size() - 1) && arestasOrdenadas.size() != j) {
            for (Aresta ares : arestasOrdenadas) {
                if (novasArestas.size() == 0) {
                    nosLigados.add(g.getVerticePorId(ares.getSource()));
                    nosLigados.add(g.getVerticePorId(ares.getTarget()));
                    novasArestas.add(ares);
                    j++;
                } else if (nosLigados.contains(g.getVerticePorId(ares.getSource())) || nosLigados.contains(g.getVerticePorId(ares.getTarget()))) {
                    if (nosLigados.contains(g.getVerticePorId(ares.getSource())) && nosLigados.contains(g.getVerticePorId(ares.getTarget()))) {
                        if ((nosSoltos.contains(g.getVerticePorId(ares.getSource())) && !nosSoltos.contains(g.getVerticePorId(ares.getTarget()))) || (nosSoltos.contains(g.getVerticePorId(ares.getTarget())) && !nosSoltos.contains(g.getVerticePorId(ares.getSource())))) {
                            novasArestas.add(ares);
                            j++;
                            nosSoltos.clear();
                        }
                    } else if (!nosSoltos.contains(g.getVerticePorId(ares.getSource())) && !nosSoltos.contains(g.getVerticePorId(ares.getTarget()))) {
                        novasArestas.add(ares);
                        j++;
                        if (!nosLigados.contains(g.getVerticePorId(ares.getSource()))) {
                            nosLigados.add(g.getVerticePorId(ares.getSource()));
                        }
                        if (!nosLigados.contains(g.getVerticePorId(ares.getTarget()))) {
                            nosLigados.add(g.getVerticePorId(ares.getTarget()));
                        }
                    } else {
                        novasArestas.add(ares);
                        j++;
                        if (!nosSoltos.contains(g.getVerticePorId(ares.getSource()))) {
                            nosSoltos.add(g.getVerticePorId(ares.getSource()));
                            nosLigados.add(g.getVerticePorId(ares.getSource()));
                        }
                        if (!nosSoltos.contains(g.getVerticePorId(ares.getTarget()))) {
                            nosSoltos.add(g.getVerticePorId(ares.getTarget()));
                            nosLigados.add(g.getVerticePorId(ares.getTarget()));
                        }
                    }
                } else {
                    novasArestas.add(ares);
                    j++;
                    nosLigados.add(g.getVerticePorId(ares.getSource()));
                    nosLigados.add(g.getVerticePorId(ares.getTarget()));
                    nosSoltos.add(g.getVerticePorId(ares.getSource()));
                    nosSoltos.add(g.getVerticePorId(ares.getTarget()));
                }
            }
        }
        g.getListaAresta().clear();
        g.novaListaAresta(novasArestas);

        String xml = xstream.toXML(g);

        System.out.println(xml);
        g = null;
        g = (Grafo) xstream.fromXML(xml);

        xml = xstream.toXML(g);
        System.out.println(xml);

        try {
            File xmlFile = new File("kruskal.xml");
            JOptionPane.showMessageDialog(null, xml);
            xstream.toXML(g, new FileWriter(xmlFile));
        } catch (IOException ex) {
            System.out.println("Erro ao Gravar Arquivo");
        }
    }//GEN-LAST:event_jButtonKruskalActionPerformed

    private void jRadioButton2grafoNaoOrdenado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2grafoNaoOrdenado
        //Seta se o grafo é não ordenado
        grafo.setOrdenacao(TipoGrafo.unidirected);
    }//GEN-LAST:event_jRadioButton2grafoNaoOrdenado

    private void jRadioButton1grafoOrdenado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1grafoOrdenado
        //Seta se o grafo é ordenado
        grafo.setOrdenacao(TipoGrafo.directed);
    }//GEN-LAST:event_jRadioButton1grafoOrdenado

    private void jButtonMalgrangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMalgrangeActionPerformed
        Grafo g = grafo.copiaGrafo(grafo, grafo.getNome() + "-malgrange");
        List<String> ftd = new ArrayList<String>();
        List<String> fti = new ArrayList<String>();
        List<String> intersecao = new ArrayList<String>();
        List<String> analisados = new ArrayList<String>();
        List<String> analisados2 = new ArrayList<String>();

        int qt = listaVertice.size();
        grafo.criarMatrizAdjacencia(g);
        int[][] matrizADJ = grafo.criarMatrizAdjacencia(g);

        int i = 0, j = 0, contador = 0;

        int proximoDaLista = 0;
        ftd.add(0, listaVertice.get(0).getId());
        analisados.add(i, listaVertice.get(0).getId());

        while (contador < listaVertice.size()) {

            while (j < qt) {

                if (matrizADJ[i][j] == 1) {
                    if (!ftd.contains(analisados)) {
                        ftd.add(listaVertice.get(j).getId());
                    }

                }
                j++;
            }

            proximoDaLista++;
            analisados.add(i, listaVertice.get(i).getId());
            i = proximoDaLista;
            contador++;
            j = 0;
        }
        List novaLista = new ArrayList(new HashSet(ftd));

        contador = 0;
        int proximoDaLista2 = 0;
        i = 0;
        j = 0;

        fti.add(0, listaVertice.get(0).getId());
        analisados2.add(j, listaVertice.get(0).getId());

        while (contador < listaVertice.size()) {

            while (i < qt) {

                if (matrizADJ[i][j] == 1) {
                    if (!fti.contains(analisados2)) {
                        fti.add(listaVertice.get(i).getId());
                    }

                }
                i++;
            }

            proximoDaLista2++;
            analisados2.add(j, listaVertice.get(j).getId());
            j = proximoDaLista2;
            contador++;
            i = 0;
        }

        List novaLista2 = new ArrayList(new HashSet(fti));

        novaLista.retainAll(novaLista2);
        intersecao.addAll(novaLista);

        String imprimir = "(";
        for (int r = 0; r < intersecao.size(); r++) {
            imprimir += intersecao.get(r) + ",";
        }
        imprimir += ")";

        JOptionPane.showMessageDialog(null, "Vértices Fortemente Conexos:\n" + imprimir);
    }//GEN-LAST:event_jButtonMalgrangeActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton CriarListaAdjacencia;
    private javax.swing.JButton CriarMatrizAdjacencia;
    private javax.swing.JButton DeletaAresta;
    private javax.swing.JButton InformacoesGrafo;
    private javax.swing.JButton InsereAresta;
    private javax.swing.JButton InsereVertice;
    private javax.swing.JButton abrirGrafo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JButton criarMatrizIncidencia;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonDijkstra;
    private javax.swing.JButton jButtonKruskal;
    private javax.swing.JButton jButtonMalgrange;
    private javax.swing.JButton jButtonPrim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableAresta;
    private javax.swing.JTable jTableVertice;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField nomeGrafo;
    private javax.swing.JButton salvarGrafo;
    private javax.swing.JTextField textAresta;
    private javax.swing.JTextField textVertice;
    private javax.swing.JTextField valor;
    private javax.swing.JComboBox vertice1;
    private javax.swing.JComboBox vertice2;
    // End of variables declaration//GEN-END:variables
}
