package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Model;

import controller.Controller;

public class ViewImpl implements View {
	private static final int CANVAS_HORIZONTAL_SIZE = 400;
	private static final int CANVAS_VERTICAL_SIZE = 400;
	private Canvas canvas;
	private Controller controller;
	private Model model;
	private JFrame mainWindow;
	
	public ViewImpl() {
		super();
	}
	
	@Override
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public void setModel(Model model) {
		this.model = model;
	}
	
	public final void createGUI() {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				
				@Override
				public void run() {
					mainWindow = new JFrame("Some figures");
					Container container = mainWindow.getContentPane();
					canvas = new Canvas();
					container.add(canvas);
					JPanel components = createComponents();
					container.add(components, BorderLayout.EAST);
					showWindow();
				}
			});
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	private JPanel createComponents() {
		JPanel components = new JPanel();
		components.setLayout(new BoxLayout(components, BoxLayout.PAGE_AXIS));
		components.add(createButtonsPanel());
		components.add(crateSlidersPanel());
		return components;
	}

	private JPanel createButtonsPanel() {
		JButton addNewCircle = new JButton("Circle");
		addNewCircle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		});
		JButton addNewRectangle = new JButton("Rectangle");
		addNewRectangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		});
		JPanel buttons = new JPanel();
		buttons.add(addNewCircle);
		buttons.add(addNewRectangle);
		return buttons;
	}
	
	private JPanel crateSlidersPanel() {
		JSlider horizontalPosition = new JSlider(0, CANVAS_HORIZONTAL_SIZE);
		horizontalPosition.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO
			}
		});
		
		JSlider verticalPosition = new JSlider(0, CANVAS_VERTICAL_SIZE);
		verticalPosition.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO
			}
		});
		JPanel sliders = new JPanel();
		sliders.setLayout(new BoxLayout(sliders, BoxLayout.PAGE_AXIS));
		sliders.add(horizontalPosition);
		sliders.add(verticalPosition);
		return sliders;
	}
	
	private void showWindow() {
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.pack();
		mainWindow.setVisible(true);
	}
	
	public void paintCanvas() {
		canvas.repaint();
	}
	
	@SuppressWarnings("serial")
	private class Canvas extends JPanel {
		private Canvas() {
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO
				}
			});
		}
		
		@Override
		public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D)g;
			g2d.setBackground(Color.WHITE);
			g2d.clearRect(0, 0, getWidth(), getHeight());
		}
		
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(CANVAS_HORIZONTAL_SIZE, CANVAS_VERTICAL_SIZE);
		}
	}
}
