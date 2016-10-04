package dev.tilegame.leveleditor;

import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles_and_items.Tile;

public class ToolsPanel extends JPanel{
    
	private static final long serialVersionUID = 1L;
	private PreviewPanel pp; //per settare la tile da inserire
    
	public ToolsPanel(PreviewPanel pp){
    	this.pp=pp;
    	pp.paintTile = new Tile(Assets.a6);
    	initComponents();
    }
                       
    private void initComponents() {
    	jTabbedPane = new JTabbedPane();
        page1 = new Page1(pp);
        page2 = new Page2(pp);
        page3 = new Page3(pp);
        page4 = new Page2(pp);
        
        setPreferredSize(new Dimension(300, 608));

        jTabbedPane.setName(""); // NOI18N
        jTabbedPane.setPreferredSize(new Dimension(295, 608));

        jTabbedPane.addTab("P. 1", page1);
        jTabbedPane.addTab("P. 2", page2);
        jTabbedPane.addTab("P. 3", page3);
        jTabbedPane.addTab("P. 4", page4);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane.getAccessibleContext().setAccessibleName("");
        jTabbedPane.getAccessibleContext().setAccessibleDescription("");
    }
                
    // VARIABLES
    private JTabbedPane jTabbedPane;
	private Page1 page1;
	private Page2 page2;
	private Page3 page3;
	private Page2 page4;
	
	private static JButton currButton;
    public static JButton getCurrentButton() { return currButton; }
    public static void setCurrentButton(JButton button) { currButton = button; }
    
} //END CLASS