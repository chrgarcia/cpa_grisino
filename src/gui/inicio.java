package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;

import controlador.Sistema;
import dao.DAO;
import negocio.*;

import javax.swing.JMenu;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.ScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Canvas;
import java.awt.Label;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import java.awt.Window.Type;
import javax.swing.JMenuItem;
import javax.swing.JInternalFrame;
import java.awt.Panel;
import javax.swing.JEditorPane;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.ScrollPaneConstants;

public class inicio {

	private JFrame frmBusquedaDeCpa;
	private JTextField cp;
	private JTable table;
	private JTextField barrio;
	private JTextField calle;
	private JTextField altura;
	private JTable table_1;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private JTable table_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inicio window = new inicio();
					window.frmBusquedaDeCpa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public inicio() {
		initialize();
	}

	private void initialize() {
		frmBusquedaDeCpa = new JFrame();
		frmBusquedaDeCpa.setType(Type.UTILITY);
		frmBusquedaDeCpa.setForeground(SystemColor.activeCaption);
		frmBusquedaDeCpa.setTitle("Busqueda de CPA GRISINO");
		frmBusquedaDeCpa.setBounds(100, 100, 1200, 600);
		frmBusquedaDeCpa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		JMenuBar menuBar = new JMenuBar();
		frmBusquedaDeCpa.setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnInicio.add(mntmSalir);
		
		//Sistema s = new Sistema();

				frmBusquedaDeCpa.getContentPane().setLayout(null);
				
				cp = new JTextField();
				cp.setBounds(39, 30, 70, 19);
				frmBusquedaDeCpa.getContentPane().add(cp);
				cp.setColumns(10);
				
				
				JLabel lblCp = new JLabel("CP:");
				lblCp.setFont(new Font("Arial", Font.PLAIN, 11));
				lblCp.setBounds(10, 31, 30, 16);
				frmBusquedaDeCpa.getContentPane().add(lblCp);
				
				JLabel lblCalle = new JLabel("Calle:");
				lblCalle.setFont(new Font("Arial", Font.PLAIN, 11));
				lblCalle.setHorizontalAlignment(SwingConstants.CENTER);
				lblCalle.setBounds(110, 33, 47, 14);
				frmBusquedaDeCpa.getContentPane().add(lblCalle);
				
				table = new JTable();
				table.setBounds(65, 167, 1, 1);
				frmBusquedaDeCpa.getContentPane().add(table);
				
				JLabel lblBarrio = new JLabel("Barrio: ");
				lblBarrio.setFont(new Font("Arial", Font.PLAIN, 11));
				lblBarrio.setHorizontalAlignment(SwingConstants.CENTER);
				lblBarrio.setBounds(119, 87, 63, 14);
				frmBusquedaDeCpa.getContentPane().add(lblBarrio);
				
				barrio = new JTextField();
				barrio.setBounds(180, 84, 253, 20);
				frmBusquedaDeCpa.getContentPane().add(barrio);
				barrio.setColumns(10);
				
				calle = new JTextField();
				calle.setColumns(10);
				calle.setBounds(153, 29, 303, 20);
				frmBusquedaDeCpa.getContentPane().add(calle);
				
				JLabel lblAltura = new JLabel("Altura: ");
				lblAltura.setFont(new Font("Arial", Font.PLAIN, 11));
				lblAltura.setHorizontalAlignment(SwingConstants.CENTER);
				lblAltura.setBounds(466, 32, 47, 14);
				frmBusquedaDeCpa.getContentPane().add(lblAltura);
				
				altura = new JTextField();
				altura.setColumns(10);
				altura.setBounds(516, 29, 63, 20);
				frmBusquedaDeCpa.getContentPane().add(altura);
				
				scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 111, 1164, 418);
				frmBusquedaDeCpa.getContentPane().add(scrollPane);

				table_2 = new JTable();
				scrollPane.setViewportView(table_2);
				modelo = new DefaultTableModel();
				table_2 = new JTable(modelo); //Metemos el modelo dentro de la tabla
				//DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer(); 
				//Alinear.setHorizontalAlignment(SwingConstants.CENTER);//.LEFT .RIGHT .CENTER
				//table_2.getColumnModel().getColumn(2).setCellRenderer(Alinear);
			
				
				modelo.addColumn("Provincia"); //Añadimos las columnas a la tabla (tantas como queramos)
				modelo.addColumn("Paraje");
				modelo.addColumn("Localidad");
				modelo.addColumn("Barrio");
				modelo.addColumn("Calle");
				modelo.addColumn("Desde");
				modelo.addColumn("Hasta");
				modelo.addColumn("CP");
				modelo.addColumn("CPA");
				 
				
				 
				scrollPane.setViewportView(table_2);//Esto añade la tabla al portView del scrollPane, si estaba puesto anteriormente
				                                  //hay que borrarlo del otro sitio, sino puede dar error de NullPointerException
				
				
				
				
				JButton btnBuscar = new JButton("Buscar");
				btnBuscar.setForeground(Color.BLACK);
				btnBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
	
						List<Object[]> listado = Sistema.getInstancia().getCPAGui(Integer.valueOf(cp.getText()), String.valueOf(calle.getText()), Integer.valueOf(altura.getText()));
						
						//System.out.println(listado);
						for(int i=0; i<listado.size();i++){

							Object[] fila = new Object[9];
			                                            
			                fila[0] = listado.get(i)[0]; //Lo que hay entre comillas son los campos de la base de datos
			                fila[1] = listado.get(i)[1];
			                fila[2] = listado.get(i)[2];
			                fila[3] = listado.get(i)[3];
			                fila[4] = listado.get(i)[4];
			                fila[5] = listado.get(i)[5];
			                fila[6] = listado.get(i)[6];
			                fila[7] = listado.get(i)[7];
			                fila[8] = listado.get(i)[8];
			                
			                //System.out.println(listado.get(0)[0]);
			                
			                modelo.addRow(fila); // Añade una fila al final del modelo de la tabla*/
			            }
						
						
						resize();
						
					}
				});
				btnBuscar.setBackground(Color.LIGHT_GRAY);
				btnBuscar.setBounds(587, 28, 165, 23);
				frmBusquedaDeCpa.getContentPane().add(btnBuscar);
				
				JButton btnX = new JButton("Borrar Resultados");
				btnX.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						cp.setText("");
						calle.setText("");
						altura.setText("");
						barrio.setText("");
						
						while (modelo.getRowCount() > 0) modelo.removeRow(0);
						
					}
				});
				
				btnX.setForeground(Color.BLACK);
				btnX.setBackground(Color.LIGHT_GRAY);
				btnX.setBounds(762, 3, 156, 101);
				frmBusquedaDeCpa.getContentPane().add(btnX);
				
				JButton btnBarrio = new JButton("Buscar Barrio");
				btnBarrio.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						List<Object[]> listado = Sistema.getInstancia().getCPAGuiBarrio(String.valueOf(barrio.getText()));
						
						for(int i=0; i<listado.size();i++){

							Object[] fila = new Object[9];
			                                            
			                fila[0] = listado.get(i)[0]; //Lo que hay entre comillas son los campos de la base de datos
			                fila[1] = listado.get(i)[1];
			                fila[2] = listado.get(i)[2];
			                fila[3] = listado.get(i)[3];
			                fila[4] = listado.get(i)[4];
			                fila[5] = listado.get(i)[5];
			                fila[6] = listado.get(i)[6];
			                fila[7] = listado.get(i)[7];
			                fila[8] = listado.get(i)[8];
			                
			                //System.out.println(listado.get(0)[0]);
			                
			                modelo.addRow(fila); // Añade una fila al final del modelo de la tabla*/
			            }
						
						
						resize();
						
						
					}
				});
				btnBarrio.setForeground(Color.BLACK);
				btnBarrio.setBackground(Color.LIGHT_GRAY);
				btnBarrio.setBounds(443, 83, 165, 23);
				frmBusquedaDeCpa.getContentPane().add(btnBarrio);
				
				Label label = new Label("Busqueda de CPA por calle");
				label.setForeground(SystemColor.text);
				label.setAlignment(Label.CENTER);
				label.setBackground(SystemColor.activeCaption);
				label.setFont(new Font("Arial", Font.PLAIN, 14));
				label.setBounds(7, 3, 745, 22);
				frmBusquedaDeCpa.getContentPane().add(label);
				
				Label label_1 = new Label("Busqueda por barrios");
				label_1.setForeground(SystemColor.text);
				label_1.setFont(new Font("Arial", Font.PLAIN, 14));
				label_1.setBackground(SystemColor.activeCaption);
				label_1.setAlignment(Label.CENTER);
				label_1.setBounds(7, 55, 745, 22);
				frmBusquedaDeCpa.getContentPane().add(label_1);

				

				
	}
	
	
	public void resize(){
		table_2.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
	 
		for (int column = 0; column < table_2.getColumnCount(); column++)
		{
			TableColumn tableColumn = table_2.getColumnModel().getColumn(column);
			int preferredWidth = tableColumn.getMinWidth();
			int	maxWidth = tableColumn.getMaxWidth();
	 
			for (int row = 0; row < table_2.getRowCount(); row++)
			{
				TableCellRenderer cellRenderer = table_2.getCellRenderer(row, column);
				Component c = table_2.prepareRenderer(cellRenderer, row, column);
				int width = c.getPreferredSize().width + table_2.getIntercellSpacing().width;
				preferredWidth = Math.max(preferredWidth, width);
	 
				//  We've exceeded the maximum width, no need to check other rows
	 
				if (preferredWidth >= maxWidth)
				{
					preferredWidth = maxWidth;
					break;
				}
			}
	 
			tableColumn.setPreferredWidth( preferredWidth + 25 );
		}
	}
}
