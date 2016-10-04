package dev.tilegame.leveleditor;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

import dev.tilegame.Handler;
import dev.tilegame.worlds.World;

public class LevelEditor extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Handler handler;
	private PreviewPanel panel;
	private ToolsPanel tools;
	private Container contentPane;
	private int grid;
	private static boolean gridVisible = true;
	
	//MenuBar
	//MENUBAR
	private JMenuBar menuBar;
	private JButton showGrid, saveWorld, loadWorld;
	private JButton moveUp, moveDown, moveLeft, moveRight;
	
	//PUBLIC:
	public LevelEditor(Handler handler, World world, int grid){
		super("Level Editor");
		this.handler=handler;
		this.grid=grid;
		setResizable(false);
		setLocation(100, 100);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		pack();
		
		panel = new PreviewPanel(handler, world, 801, 609, grid);
			panel.setPreferredSize(new Dimension(801,609));
		tools = new ToolsPanel(panel);
			tools.setPreferredSize(new Dimension(300,609));
		contentPane = this.getContentPane();
			contentPane.setLayout(new FlowLayout());
			contentPane.add(tools, BorderLayout.EAST);
			contentPane.add(panel, BorderLayout.WEST);			
			
		//MenuBar
		menuBar = new JMenuBar();
			showGrid = new JButton("Hide Grid");
				showGrid.addActionListener(this);
				menuBar.add(showGrid);
			moveUp = new JButton("Move Up");
				moveUp.addActionListener(this);
				menuBar.add(moveUp);
			moveDown = new JButton("Move Down");
				moveDown.addActionListener(this);
				menuBar.add(moveDown);
			moveLeft = new JButton("Move Left");
				moveLeft.addActionListener(this);
				menuBar.add(moveLeft);
			moveRight = new JButton("Move Right");
				moveRight.addActionListener(this);
				menuBar.add(moveRight);
			saveWorld = new JButton("Save World");
				saveWorld.addActionListener(this);
				menuBar.add(saveWorld);
			loadWorld = new JButton("Load World");
				loadWorld.addActionListener(this);
				menuBar.add(loadWorld);
		setJMenuBar(menuBar);
		pack();
	}

	
	//PUBLIC METHODS
	public static boolean getGridVisibility() { return gridVisible; }
	
	//ACTION EVENT
	public void actionPerformed(ActionEvent e) {
		int move = grid; //32
		
		if(e.getSource() == showGrid) {
			gridVisible = !gridVisible;
			if(showGrid.getText() == "Hide Grid") showGrid.setText("Show Grid");
			else showGrid.setText("Hide Grid");
		}
		else if(e.getSource() == moveUp) {
			PreviewPanel.editorCamera.move(0, -move);
		}
		else if(e.getSource() == moveDown) {
			PreviewPanel.editorCamera.move(0, move);
		}
		else if(e.getSource() == moveLeft) {
			PreviewPanel.editorCamera.move(-move, 0);
		}
		else if(e.getSource() == moveRight) {
			PreviewPanel.editorCamera.move(move, 0);
		}
		else if(e.getSource() == saveWorld) {
			handler.saveWorld();
		}
		else if(e.getSource() == loadWorld) {
			//handler.loadWorld();
		}
		repaint();
	}
}
