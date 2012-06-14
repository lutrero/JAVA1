package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import basicas.Punto;

public class VistaFiguras implements Vista {
	
	private Modelo modelo;
	private Controlador controlador;
	private Container contenedor;
	private DrawPanel panelDibujo;
	private JSlider sliderHorizontal;
	private JSlider sliderVertical;
	private JSlider sliderRotar;
	private JSlider sliderEscalar;
	private int tipo;
	
	public VistaFiguras(){
		super();
		creaGUI();
	}

	@Override
	public void setControlador(Controlador t) {
		controlador = t;
	}

	@Override
	public void setModelo(Modelo m) {
		modelo = m;
	}
	
	@Override
	public void repintar(){
		panelDibujo.repaint();
	}

	@Override
	public Container getContenedor() {
		return contenedor;
	}

	@Override
	public void setSliders(Punto p) {
		if (p != null ){
			sliderHorizontal.setValue((int) p.getX());
			sliderVertical.setValue((int) p.getY());
			sliderRotar.setValue(modelo.getSeleccion().getAngulo());
		}
		sliderEscalar.setValue(modelo.getSeleccion().getEscalado());
	}
	
	@Override
	public int getTipoFigura() {
		return tipo;
	}

	
///////////////////////////////////////////////////////////////////////////////////////	
	private void creaGUI(){
		try{
			SwingUtilities.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					contenedor = new Container();
					contenedor.setLayout(new BorderLayout());
//		____________________________________________________________________________________________________________
					panelDibujo = new DrawPanel();
					panelDibujo.setLayout(new BorderLayout(1, 1));
					panelDibujo.setMinimumSize(new Dimension(600, 500));
					panelDibujo.setBackground(Color.BLACK);
					panelDibujo.setPreferredSize(new Dimension(600, 500));
			        JPanel contControl = new JPanel();
			        contControl.setOpaque(false);
					contControl.setLayout(new BoxLayout(contControl, BoxLayout.Y_AXIS));
					contControl.add(contenedorBotonesFiguras1());
					contControl.add(contenedorSliders());
					contControl.setPreferredSize(new Dimension(220,500));
//		__________________________________________________________________________________
					contenedor.add(panelDibujo, BorderLayout.CENTER);
        			contenedor.add(contControl, BorderLayout.EAST);
        			contenedor.addMouseListener(panelDibujo);
        			contenedor.addMouseMotionListener(panelDibujo);
        			contenedor.addMouseWheelListener(panelDibujo);
        			contenedor.setPreferredSize(new Dimension(820, 500));
				}
			});
		}catch (InterruptedException e){
			e.printStackTrace();
		}catch (InvocationTargetException e){
			e.printStackTrace();
		}
	}
	
	private JPanel contenedorBotonesFiguras1(){
		JFPanel contBot1 = new JFPanel(new ImageIcon(getClass().getResource("/gui/imagenes/nebulosa.jpg")).getImage());
		contBot1.setLayout(null);
		contBot1.setOpaque(false);
		contBot1.setPreferredSize(new Dimension( 210, 300));
		JButton jbRectangulo = new JButton(new ImageIcon(getClass().getResource("/gui/imagenes/rectangulo4n.png")));
		jbRectangulo.setBounds(5, 60, 100, 50);
		jbRectangulo.setBorderPainted(false);
		jbRectangulo.setOpaque(false);
		jbRectangulo.setContentAreaFilled(false);
		jbRectangulo.setToolTipText("Pulsa para que se dibuje un rectangulo");
		jbRectangulo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tipo = Controlador.RECTANGULO;
				controlador.solicitaNueva();
			}
		});
		jbRectangulo.addMouseListener(new BotonMouseListener(jbRectangulo, "rectangulo4"));
		JButton jbCirculo = new JButton(new ImageIcon(getClass().getResource("/gui/imagenes/circulo4n.png")));;
		jbCirculo.setBounds(115, 60, 100, 50);
		jbCirculo.setBorderPainted(false);
		jbCirculo.setOpaque(false);
		jbCirculo.setContentAreaFilled(false);
		jbCirculo.setToolTipText("Pulsa para que se dibuje un circulo");
		jbCirculo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tipo = Controlador.CIRCULO;
				controlador.solicitaNueva();
			}
		});
		jbCirculo.addMouseListener(new BotonMouseListener(jbCirculo, "circulo4"));
		
		JButton jbElipse = new JButton(new ImageIcon(getClass().getResource("/gui/imagenes/elipse4n.png")));
		jbElipse.setBounds(5, 120, 100, 50);
		jbElipse.setBorderPainted(false);
		jbElipse.setOpaque(false);
		jbElipse.setToolTipText("Pulsa para que se dibuje una elipse");
		jbElipse.setContentAreaFilled(false);
		jbElipse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tipo = Controlador.ELIPSE;
				controlador.solicitaNueva();
			}
		});
		jbElipse.addMouseListener(new BotonMouseListener(jbElipse, "elipse4"));
		JButton jbTriangulo = new JButton(new ImageIcon(getClass().getResource("/gui/imagenes/triangulo4n.png")));
		jbTriangulo.setBounds(115, 120, 100, 50);
		jbTriangulo.setBorderPainted(false);
		jbTriangulo.setOpaque(false);
		jbTriangulo.setContentAreaFilled(false);
		jbTriangulo.setToolTipText("Pulsa para que se dibuje un triangulo");
		jbTriangulo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tipo = Controlador.TRIANGULO;
				controlador.solicitaNueva();
			}
		});
		jbTriangulo.addMouseListener(new BotonMouseListener(jbTriangulo,  "triangulo4"));
		
		JButton jbBorrar = new JButton(new ImageIcon(getClass().getResource("/gui/imagenes/borrar4n.png")));
		jbBorrar.setBounds(5, 180 , 100, 50);
		jbBorrar.setBorderPainted(false);
		jbBorrar.setOpaque(false);
		jbBorrar.setContentAreaFilled(false);
		jbBorrar.setToolTipText("Pulsa para borrar la figura seleccionada");
		jbBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					controlador.solicitaBorrar();
			}
		});
		jbBorrar.addMouseListener(new BotonMouseListener(jbBorrar, "borrar4"));
		JLabel logo = new JLabel(new ImageIcon(getClass().getResource("/gui/imagenes/logo.jpg")));
		logo.setBounds(0,0,220,58);
		logo.setOpaque(false);
		contBot1.add(logo);
		contBot1.add(jbBorrar);
		contBot1.add(jbRectangulo);
		contBot1.add(jbCirculo);
		contBot1.add(jbElipse);
		contBot1.add(jbTriangulo);
		return contBot1;
	}
	
	private JPanel contenedorSliders(){
		JPanel contSliders = new JPanel();
		contSliders.setLayout(new BoxLayout(contSliders, BoxLayout.Y_AXIS));
		contSliders.setBackground(Color.getHSBColor(88f, 82f, 209f));
		contSliders.setLayout(new BoxLayout(contSliders, BoxLayout.Y_AXIS));
		JLabel hor = new JLabel("Desplazamiento Horizontal");
		hor.setForeground(Color.WHITE);
		JLabel ver = new JLabel("Desplazamiento Vertical");
		ver.setForeground(Color.WHITE);
		JLabel rot = new JLabel("Rotar");
		rot.setForeground(Color.WHITE);
		JLabel esc = new JLabel("Escalar");
		esc.setForeground(Color.WHITE);
		sliderHorizontal = new JSlider(JSlider.HORIZONTAL, 0, 600, 20);
		sliderHorizontal.setBackground(SystemColor.controlDkShadow);
		sliderHorizontal.setMajorTickSpacing(100);
		sliderHorizontal.setMinorTickSpacing(20);
		sliderHorizontal.setPaintTicks(true);
		sliderHorizontal.setToolTipText("Pulsa y arrastra para desplazar la figura seleccionada");
		sliderHorizontal.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				controlador.solicitaMover(new Punto(sliderHorizontal.getValue(), sliderVertical.getValue()));	
			}
		});
		sliderVertical = new JSlider(JSlider.HORIZONTAL, 0, 500, 20);
		sliderVertical.setBackground(SystemColor.controlDkShadow);
		sliderVertical.setMajorTickSpacing(100);
		sliderVertical.setMinorTickSpacing(20);
		sliderVertical.setPaintTicks(true);
		sliderVertical.setToolTipText("Pulsa y arrastra para desplazar la figura seleccionada");
		sliderVertical.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
					controlador.solicitaMover(new Punto(sliderHorizontal.getValue(), sliderVertical.getValue()));
			}
		});
		sliderEscalar = new JSlider(JSlider.HORIZONTAL, 0, 15, 1);
		sliderEscalar.setBackground(SystemColor.controlDkShadow);
		sliderEscalar.setMajorTickSpacing(5);
		sliderEscalar.setMinorTickSpacing(1);
		sliderEscalar.setPaintTicks(true);
		sliderEscalar.setToolTipText("Pulsa y arrastra para escalar la figura seleccionada");
		sliderEscalar.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				Seleccion seleccionada = modelo.getSeleccion();
				if (seleccionada != null){
					if(seleccionada.getEscalado() < sliderEscalar.getValue())
						controlador.solicitaEscalar(1.2, sliderEscalar.getValue());
					else if (seleccionada.getEscalado() > sliderEscalar.getValue())
						controlador.solicitaEscalar(-1.2, sliderEscalar.getValue());
					else controlador.solicitaEscalar(1, sliderEscalar.getValue());
				}
			}
		});
		sliderRotar = new JSlider(JSlider.HORIZONTAL, 0, 1080, 0);
		sliderRotar.setBackground(SystemColor.controlDkShadow);
		sliderRotar.setMajorTickSpacing(180);
		sliderRotar.setMinorTickSpacing(45);
		sliderRotar.setPaintTicks(true);
		sliderRotar.setToolTipText("Pulsa y arrastra para rotar la figura seleccionada");
		sliderRotar.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				Seleccion seleccionada = modelo.getSeleccion();
				if (seleccionada != null){
					controlador.solicitaRotar(Math.toRadians(sliderRotar.getValue()- seleccionada.getAngulo()), sliderRotar.getValue());
				}
			}
		});
		contSliders.add(hor);
		contSliders.add(sliderHorizontal);
		contSliders.add(ver);
		contSliders.add(sliderVertical);
		contSliders.add(esc);
		contSliders.add(sliderEscalar);
		contSliders.add(rot);
		contSliders.add(sliderRotar);
		return contSliders;
	}
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////
	class DrawPanel extends JPanel implements MouseListener, MouseMotionListener, MouseWheelListener{
		/**
		 * Clase interna para la zona de graficos contiene los escuchadores del mouse
		 */
		private static final long serialVersionUID = 1L;
			
		private boolean pressOut = false;
		private boolean boton1 = false;
		private int ultX, ultY;
		
		public DrawPanel(){
			super();
		}
		
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			for ( Seleccion s : modelo.getVectorFiguras()){
				controlador.solicitaDibujar(s, (Graphics2D) g);
			}
		}

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			if (modelo.getSeleccion() != null){
				controlador.solicitaEscalar((e.getPreciseWheelRotation() < 0) ? 1.2: 1/1.2, (e.getPreciseWheelRotation() > 0) ? sliderEscalar.getValue() - 1: sliderEscalar.getValue() + 1);
			}
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			if (modelo.getSeleccion() != null && boton1){
				if (! pressOut){
					controlador.solicitaActulizarPosicion(new Punto(ultX + e.getX(), ultY + e.getY()));
				}
			}	
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1){
				controlador.solicitarSeleccionar(new Punto(e.getX(), e.getY()));
				boton1 = true;
				if (modelo.getSeleccion() != null){
					ultX = modelo.getSeleccion().getReferenciaX() - e.getX();
					ultY = modelo.getSeleccion().getReferenciaY() - e.getY();
					controlador.solicitaActulizarPosicion(new Punto(ultX + e.getX(), ultY + e.getY()));
					setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
				}else{
					pressOut = true;
				}
			}else boton1 = false;
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (e.getButton() == 1){
				if (modelo.getSeleccion() != null){
					controlador.solicitaActulizarPosicion(new Punto(ultX + e.getX(), ultY + e.getY()));
					if (modelo.getSeleccion().getFigura().seleccionar(new Punto(e.getX(), e.getY()))){
						setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					}else setCursor(Cursor.getDefaultCursor());
				}
				else
					pressOut = false;
			}
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
//			if ( modelo.getSeleccion() != null ){
//				if (modelo.getSeleccion().getFigura().estaEnPerimetro(new Punto(e.getX(), e.getY()))){
//					setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
//				}else
//					if (modelo.getSeleccion().getFigura().estaContenido(new Punto(e.getX(), e.getY()))){
//						setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//					}else
//						setCursor(Cursor.getDefaultCursor());
//			}else{
//				setCursor(Cursor.getDefaultCursor());
//			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
	
	class JFPanel extends JPanel{

		private static final long serialVersionUID = 1L;
		private Image imagen;
		
		public JFPanel(Image imagen){
			super();
			this.imagen = imagen;
		}
		
		@Override
		public void paint(Graphics g) {
			if (imagen != null) {
				g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);
			} else {
				setOpaque(true);
			}
			 
			super.paint(g);
		}
	}
	
	class BotonMouseListener extends MouseAdapter {

		private String ruta;
		private JButton boton;
		
		public BotonMouseListener(JButton boton, String ruta){
			super();
			this.ruta = ruta;
			this.boton = boton;
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			boton.setIcon(new ImageIcon(getClass().getResource("/gui/imagenes/" + ruta + "r.png")));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			boton.setIcon(new ImageIcon(getClass().getResource("/gui/imagenes/" + ruta + "n.png")));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1)
				boton.setIcon(new ImageIcon(getClass().getResource("/gui/imagenes/" + ruta + "p.png")));	
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			boton.setIcon(new ImageIcon(getClass().getResource("/gui/imagenes/" + ruta + "r.png")));
		}	
	}

}