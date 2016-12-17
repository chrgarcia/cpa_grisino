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

public class inicio {

	private JFrame frame;
	private JTextField cp;
	private JTable table;
	private JTextField barrio;
	private JTextField calle;
	private JTextField altura;
	private JTextField localidad;
	private JTextField provincia;
	private JTable table_1;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private JTable table_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inicio window = new inicio();
					window.frame.setVisible(true);
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1128, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		//Sistema s = new Sistema();

				frame.getContentPane().setLayout(null);
				
				cp = new JTextField();
				cp.setBounds(46, 8, 86, 19);
				frame.getContentPane().add(cp);
				cp.setColumns(10);
				
				
				JLabel label = new JLabel("CP");
				label.setBounds(17, 10, 19, 16);
				frame.getContentPane().add(label);
				
				JLabel lblCalle = new JLabel("Calle");
				lblCalle.setHorizontalAlignment(SwingConstants.CENTER);
				lblCalle.setBounds(126, 13, 47, 14);
				frame.getContentPane().add(lblCalle);
				
				table = new JTable();
				table.setBounds(65, 167, 1, 1);
				frame.getContentPane().add(table);
				
				JLabel lblBarrio = new JLabel("Barrio");
				lblBarrio.setHorizontalAlignment(SwingConstants.CENTER);
				lblBarrio.setBounds(10, 71, 38, 14);
				frame.getContentPane().add(lblBarrio);
				
				barrio = new JTextField();
				barrio.setBounds(46, 68, 253, 20);
				frame.getContentPane().add(barrio);
				barrio.setColumns(10);
				
				calle = new JTextField();
				calle.setColumns(10);
				calle.setBounds(167, 10, 279, 20);
				frame.getContentPane().add(calle);
				
				JLabel lblAltura = new JLabel("Altura");
				lblAltura.setHorizontalAlignment(SwingConstants.CENTER);
				lblAltura.setBounds(456, 13, 47, 14);
				frame.getContentPane().add(lblAltura);
				
				altura = new JTextField();
				altura.setColumns(10);
				altura.setBounds(504, 10, 84, 20);
				frame.getContentPane().add(altura);
				
				JLabel lblLoc = new JLabel("Loc");
				lblLoc.setHorizontalAlignment(SwingConstants.CENTER);
				lblLoc.setBounds(10, 39, 35, 14);
				frame.getContentPane().add(lblLoc);
				
				localidad = new JTextField();
				localidad.setColumns(10);
				localidad.setBounds(46, 36, 253, 20);
				frame.getContentPane().add(localidad);
				
				JLabel lblProv = new JLabel("Prov.");
				lblProv.setHorizontalAlignment(SwingConstants.CENTER);
				lblProv.setBounds(309, 38, 35, 14);
				frame.getContentPane().add(lblProv);
				
				provincia = new JTextField();
				provincia.setColumns(10);
				provincia.setBounds(354, 36, 234, 20);
				frame.getContentPane().add(provincia);
				
				scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 101, 1092, 315);
				frame.getContentPane().add(scrollPane);

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
				btnBuscar.setBounds(517, 67, 165, 23);
				frame.getContentPane().add(btnBuscar);
				
				JButton btnX = new JButton("X");
				btnX.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						cp.setText("");
						calle.setText("");
						altura.setText("");
						
						while (modelo.getRowCount() > 0) modelo.removeRow(0);
						
					}
				});
				
				btnX.setForeground(Color.BLACK);
				btnX.setBackground(Color.LIGHT_GRAY);
				btnX.setBounds(692, 67, 58, 23);
				frame.getContentPane().add(btnX);
				
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
				btnBarrio.setBounds(309, 67, 165, 23);
				frame.getContentPane().add(btnBarrio);

				

				
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
