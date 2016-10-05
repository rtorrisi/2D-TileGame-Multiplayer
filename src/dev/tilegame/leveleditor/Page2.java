package dev.tilegame.leveleditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles_and_items.Tile;

public class Page2 extends JPanel implements ActionListener{
	
	final int pageNumber=2;
	final int pageIndex = (pageNumber-1)*72;
	private static final long serialVersionUID = 1L;
	private PreviewPanel pp;
	
	public Page2(PreviewPanel pp) {
		this.pp=pp;
		initButton();
		initListener();
		initLayout();
	}
	
	private void initButton() {
		jButton1 = new JButton(); jButton1.setIcon(new ImageIcon(Assets.b1));
		jButton2 = new JButton(); jButton2.setIcon(new ImageIcon(Assets.b2));
		jButton3 = new JButton(); jButton3.setIcon(new ImageIcon(Assets.b3));
		jButton4 = new JButton(); jButton4.setIcon(new ImageIcon(Assets.b4));
		jButton5 = new JButton(); jButton5.setIcon(new ImageIcon(Assets.b5));
		jButton6 = new JButton(); jButton6.setIcon(new ImageIcon(Assets.b6));
    
		jButton7 = new JButton(); jButton7.setIcon(new ImageIcon(Assets.b7));
		jButton8 = new JButton(); jButton8.setIcon(new ImageIcon(Assets.b8));
		jButton9 = new JButton(); jButton9.setIcon(new ImageIcon(Assets.b9));
		jButton10 = new JButton(); jButton10.setIcon(new ImageIcon(Assets.b10));
		jButton11 = new JButton(); jButton11.setIcon(new ImageIcon(Assets.b11));
		jButton12 = new JButton();jButton12.setIcon(new ImageIcon(Assets.b12));
		
		jButton13 = new JButton(); jButton13.setIcon(new ImageIcon(Assets.b13));
		jButton14 = new JButton(); jButton14.setIcon(new ImageIcon(Assets.b14));
		jButton15 = new JButton(); jButton15.setIcon(new ImageIcon(Assets.b15));
		jButton16 = new JButton(); jButton16.setIcon(new ImageIcon(Assets.b16));
		jButton17 = new JButton(); jButton17.setIcon(new ImageIcon(Assets.b17));
		jButton18 = new JButton(); jButton18.setIcon(new ImageIcon(Assets.b18));
    
		jButton19 = new JButton(); jButton19.setIcon(new ImageIcon(Assets.b19));
		jButton20 = new JButton(); jButton20.setIcon(new ImageIcon(Assets.b20));
		jButton21 = new JButton(); jButton21.setIcon(new ImageIcon(Assets.b21));
		jButton22 = new JButton(); jButton22.setIcon(new ImageIcon(Assets.b22));
		jButton23 = new JButton(); jButton23.setIcon(new ImageIcon(Assets.b23));
		jButton24 = new JButton(); jButton24.setIcon(new ImageIcon(Assets.b24));
	
		jButton25 = new JButton(); jButton25.setIcon(new ImageIcon(Assets.b25));
		jButton26 = new JButton(); jButton26.setIcon(new ImageIcon(Assets.b26));
		jButton27 = new JButton(); jButton27.setIcon(new ImageIcon(Assets.b27));
		jButton28 = new JButton(); jButton28.setIcon(new ImageIcon(Assets.b28));
		jButton29 = new JButton(); jButton29.setIcon(new ImageIcon(Assets.b29));
		jButton30 = new JButton(); jButton30.setIcon(new ImageIcon(Assets.b30));
   
		jButton31 = new JButton(); jButton31.setIcon(new ImageIcon(Assets.b31));
		jButton32 = new JButton(); jButton32.setIcon(new ImageIcon(Assets.b32));
		jButton33 = new JButton(); jButton33.setIcon(new ImageIcon(Assets.b33));
		jButton34 = new JButton(); jButton34.setIcon(new ImageIcon(Assets.b34));
		jButton35 = new JButton(); jButton35.setIcon(new ImageIcon(Assets.b35));
		jButton36 = new JButton(); jButton36.setIcon(new ImageIcon(Assets.b36));
    
		jButton37 = new JButton(); jButton37.setIcon(new ImageIcon(Assets.b37));
		jButton38 = new JButton(); jButton38.setIcon(new ImageIcon(Assets.b38));
		jButton39 = new JButton(); jButton39.setIcon(new ImageIcon(Assets.b39));
		jButton40 = new JButton(); jButton40.setIcon(new ImageIcon(Assets.b40));
		jButton41 = new JButton(); jButton41.setIcon(new ImageIcon(Assets.b41));
		jButton42 = new JButton(); jButton42.setIcon(new ImageIcon(Assets.b42));
   
		jButton43 = new JButton(); jButton43.setIcon(new ImageIcon(Assets.b43));
		jButton44 = new JButton(); jButton44.setIcon(new ImageIcon(Assets.b44));
		jButton45 = new JButton(); jButton45.setIcon(new ImageIcon(Assets.b45));
		jButton46 = new JButton(); jButton46.setIcon(new ImageIcon(Assets.b46));
		jButton47 = new JButton(); jButton47.setIcon(new ImageIcon(Assets.b47));
		jButton48 = new JButton(); jButton48.setIcon(new ImageIcon(Assets.b48));
    
		jButton49 = new JButton(); jButton49.setIcon(new ImageIcon(Assets.b49));
		jButton50 = new JButton(); jButton50.setIcon(new ImageIcon(Assets.b50));
    	jButton51 = new JButton(); jButton51.setIcon(new ImageIcon(Assets.b51));
    	jButton52 = new JButton(); jButton52.setIcon(new ImageIcon(Assets.b52));
    	jButton53 = new JButton(); jButton53.setIcon(new ImageIcon(Assets.b53));
    	jButton54 = new JButton(); jButton54.setIcon(new ImageIcon(Assets.b54));
    	
    	jButton55 = new JButton(); jButton55.setIcon(new ImageIcon(Assets.b55));
    	jButton56 = new JButton(); jButton56.setIcon(new ImageIcon(Assets.b56));
    	jButton57 = new JButton(); jButton57.setIcon(new ImageIcon(Assets.b57));
    	jButton58 = new JButton(); jButton58.setIcon(new ImageIcon(Assets.b58));
    	jButton59 = new JButton(); jButton59.setIcon(new ImageIcon(Assets.b59));
    	jButton60 = new JButton(); jButton60.setIcon(new ImageIcon(Assets.b60));
    
    	jButton61 = new JButton(); jButton61.setIcon(new ImageIcon(Assets.b61));
    	jButton62 = new JButton(); jButton62.setIcon(new ImageIcon(Assets.b62));
    	jButton63 = new JButton(); jButton63.setIcon(new ImageIcon(Assets.b63));
    	jButton64 = new JButton(); jButton64.setIcon(new ImageIcon(Assets.b64));
    	jButton65 = new JButton(); jButton65.setIcon(new ImageIcon(Assets.b65));
    	jButton66 = new JButton(); jButton66.setIcon(new ImageIcon(Assets.b66));
    	
    	jButton67 = new JButton(); jButton67.setIcon(new ImageIcon(Assets.b67));
    	jButton68 = new JButton(); jButton68.setIcon(new ImageIcon(Assets.b68));
    	jButton69 = new JButton(); jButton69.setIcon(new ImageIcon(Assets.b69));
    	jButton70 = new JButton(); jButton70.setIcon(new ImageIcon(Assets.b70));
    	jButton71 = new JButton(); jButton71.setIcon(new ImageIcon(Assets.b71));
    	jButton72 = new JButton(); jButton72.setIcon(new ImageIcon(Assets.b72));
	}
	
	public void actionPerformed(ActionEvent e) {
		ToolsPanel.getCurrentButton().setBackground(null);
		ToolsPanel.setCurrentButton((JButton) e.getSource());
		ToolsPanel.getCurrentButton().setBackground(Color.blue);
		pp.paintTile = null;
		pp.paintItem = null;
		pp.multiItem.clear();
		
		if(e.getSource() == jButton1) { pp.paintTile = new Tile(Assets.b1, true); pp.index=pageIndex+1;}
		else if(e.getSource() == jButton2) { pp.paintTile = new Tile(Assets.b2, true);  pp.index=pageIndex+2;}
		else if(e.getSource() == jButton3) { pp.paintTile = new Tile(Assets.b3, true); pp.index=pageIndex+3;}
		else if(e.getSource() == jButton4) { pp.paintTile = new Tile(Assets.b4, true); pp.index=pageIndex+4;}
		else if(e.getSource() == jButton5) { pp.paintTile = new Tile(Assets.b5, true); pp.index=pageIndex+5;}
		else if(e.getSource() == jButton6) { pp.paintTile = new Tile(Assets.b6, true); pp.index=pageIndex+6;}
		
		else if(e.getSource() == jButton7) { pp.paintTile = new Tile(Assets.b7, true); pp.index=pageIndex+7;}
		else if(e.getSource() == jButton8) { pp.paintTile = new Tile(Assets.b8, true); pp.index=pageIndex+8;}
		else if(e.getSource() == jButton9) { pp.paintTile = new Tile(Assets.b9, true); pp.index=pageIndex+9;}
		else if(e.getSource() == jButton10) { pp.paintTile = new Tile(Assets.b10, true); pp.index=pageIndex+10;}
		else if(e.getSource() == jButton11) { pp.paintTile = new Tile(Assets.b11, true); pp.index=pageIndex+11;}
		else if(e.getSource() == jButton12) { pp.paintTile = new Tile(Assets.b12, true); pp.index=pageIndex+12;}
		
		else if(e.getSource() == jButton13) { pp.paintTile = new Tile(Assets.b13, true); pp.index=pageIndex+13;}
		else if(e.getSource() == jButton14) { pp.paintTile = new Tile(Assets.b14, true); pp.index=pageIndex+14;}
		else if(e.getSource() == jButton15) { pp.paintTile = new Tile(Assets.b15, true); pp.index=pageIndex+15;}
		else if(e.getSource() == jButton16) { pp.paintTile = new Tile(Assets.b16, true); pp.index=pageIndex+16;}
		else if(e.getSource() == jButton17) { pp.paintTile = new Tile(Assets.b17, true); pp.index=pageIndex+17;}
		else if(e.getSource() == jButton18) { pp.paintTile = new Tile(Assets.b18, true); pp.index=pageIndex+18;}
		
		else if(e.getSource() == jButton19) { pp.paintTile = new Tile(Assets.b19, true); pp.index=pageIndex+19;}
		else if(e.getSource() == jButton20) { pp.paintTile = new Tile(Assets.b20, true); pp.index=pageIndex+20;}
		else if(e.getSource() == jButton21) { pp.paintTile = new Tile(Assets.b21, true); pp.index=pageIndex+21;}
		else if(e.getSource() == jButton22) { pp.paintTile = new Tile(Assets.b22, true); pp.index=pageIndex+22;}
		else if(e.getSource() == jButton23) { pp.paintTile = new Tile(Assets.b23, true); pp.index=pageIndex+23;}
		else if(e.getSource() == jButton24) { pp.paintTile = new Tile(Assets.b24, true); pp.index=pageIndex+24;}
		
		else if(e.getSource() == jButton25) { pp.paintTile = new Tile(Assets.b25, true); pp.index=pageIndex+25;}
		else if(e.getSource() == jButton26) { pp.paintTile = new Tile(Assets.b26, true); pp.index=pageIndex+26;}
		else if(e.getSource() == jButton27) { pp.paintTile = new Tile(Assets.b27, true); pp.index=pageIndex+27;}
		else if(e.getSource() == jButton28) { pp.paintTile = new Tile(Assets.b28, true); pp.index=pageIndex+28;}
		else if(e.getSource() == jButton29) { pp.paintTile = new Tile(Assets.b29, true); pp.index=pageIndex+29;}
		else if(e.getSource() == jButton30) { pp.paintTile = new Tile(Assets.b30, true); pp.index=pageIndex+30;}
		
		else if(e.getSource() == jButton31) { pp.paintTile = new Tile(Assets.b31, true); pp.index=pageIndex+31; }
		else if(e.getSource() == jButton32) { pp.paintTile = new Tile(Assets.b32, true); pp.index=pageIndex+32;}
		else if(e.getSource() == jButton33) { pp.paintTile = new Tile(Assets.b33, true); pp.index=pageIndex+33;}
		else if(e.getSource() == jButton34) { pp.paintTile = new Tile(Assets.b34, true); pp.index=pageIndex+34;}
		else if(e.getSource() == jButton35) { pp.paintTile = new Tile(Assets.b35, true); pp.index=pageIndex+35;}
		else if(e.getSource() == jButton36) { pp.paintTile = new Tile(Assets.b36, true); pp.index=pageIndex+36;}
		
		else if(e.getSource() == jButton37) { pp.paintTile = new Tile(Assets.b37); pp.index=pageIndex+37;}		
		else if(e.getSource() == jButton38) { pp.paintTile = new Tile(Assets.b38); pp.index=pageIndex+38;}
		else if(e.getSource() == jButton39) { pp.paintTile = new Tile(Assets.b39); pp.index=pageIndex+39;}
		else if(e.getSource() == jButton40) { pp.paintTile = new Tile(Assets.b40); pp.index=pageIndex+40;}
		else if(e.getSource() == jButton41) { pp.paintTile = new Tile(Assets.b41); pp.index=pageIndex+41;}
		else if(e.getSource() == jButton42) { pp.paintTile = new Tile(Assets.b42); pp.index=pageIndex+42;}
		
		else if(e.getSource() == jButton43) { pp.paintTile = new Tile(Assets.b43); pp.index=pageIndex+43;}
		else if(e.getSource() == jButton44) { pp.paintTile = new Tile(Assets.b44); pp.index=pageIndex+44;}
		else if(e.getSource() == jButton45) { pp.paintTile = new Tile(Assets.b45); pp.index=pageIndex+45;}
		else if(e.getSource() == jButton46) { pp.paintTile = new Tile(Assets.b46); pp.index=pageIndex+46;}
		else if(e.getSource() == jButton47) { pp.paintTile = new Tile(Assets.b47); pp.index=pageIndex+47;}
		else if(e.getSource() == jButton48) { pp.paintTile = new Tile(Assets.b48); pp.index=pageIndex+48;}
		
		else if(e.getSource() == jButton49) { pp.paintTile = new Tile(Assets.b49); pp.index=pageIndex+49;}
		else if(e.getSource() == jButton50) { pp.paintTile = new Tile(Assets.b50); pp.index=pageIndex+50;}
		else if(e.getSource() == jButton51) { pp.paintTile = new Tile(Assets.b51); pp.index=pageIndex+51;}
		else if(e.getSource() == jButton52) { pp.paintTile = new Tile(Assets.b52); pp.index=pageIndex+52;}
		else if(e.getSource() == jButton53) { pp.paintTile = new Tile(Assets.b53); pp.index=pageIndex+53;}
		else if(e.getSource() == jButton54) { pp.paintTile = new Tile(Assets.b54); pp.index=pageIndex+54;}
		
		else if(e.getSource() == jButton55) { pp.paintTile = new Tile(Assets.b55, true); pp.index=pageIndex+55;}
		else if(e.getSource() == jButton56) { pp.paintTile = new Tile(Assets.b56, true); pp.index=pageIndex+56;}
		else if(e.getSource() == jButton57) { pp.paintTile = new Tile(Assets.b57, true); pp.index=pageIndex+57;}
		else if(e.getSource() == jButton58) { pp.paintTile = new Tile(Assets.b58, true); pp.index=pageIndex+58;}
		else if(e.getSource() == jButton59) { pp.paintTile = new Tile(Assets.b59, true); pp.index=pageIndex+59; }
		else if(e.getSource() == jButton60) { pp.paintTile = new Tile(Assets.b60, true); pp.index=pageIndex+60;}
		
		else if(e.getSource() == jButton61) { pp.paintTile = new Tile(Assets.b61, true); pp.index=pageIndex+61;}
		else if(e.getSource() == jButton62) { pp.paintTile = new Tile(Assets.b62); pp.index=pageIndex+62;}
		else if(e.getSource() == jButton63) { pp.paintTile = new Tile(Assets.b63, true); pp.index=pageIndex+63;}
		else if(e.getSource() == jButton64) { pp.paintTile = new Tile(Assets.b64, true); pp.index=pageIndex+64;}
		else if(e.getSource() == jButton65) { pp.paintTile = new Tile(Assets.b65, true); pp.index=pageIndex+65;}
		else if(e.getSource() == jButton66) { pp.paintTile = new Tile(Assets.b66, true); pp.index=pageIndex+66;}
		
		else if(e.getSource() == jButton67) { pp.paintTile = new Tile(Assets.b67, true); pp.index=pageIndex+67;}
		else if(e.getSource() == jButton68) { pp.paintTile = new Tile(Assets.b68, true); pp.index=pageIndex+68;}
		else if(e.getSource() == jButton69) { pp.paintTile = new Tile(Assets.b69, true); pp.index=pageIndex+69;}
		else if(e.getSource() == jButton70) { pp.paintTile = new Tile(Assets.b70, true); pp.index=pageIndex+70;}
		else if(e.getSource() == jButton71) { pp.paintTile = new Tile(Assets.b71, true); pp.index=pageIndex+71;}
		else if(e.getSource() == jButton72) { pp.paintTile = new Tile(Assets.b72, true); pp.index=pageIndex+72;}
	}
	
	private void initListener() {	
    
    jButton1.addActionListener(this);
    jButton1.setMaximumSize(new Dimension(40, 40));
    jButton1.setMinimumSize(new Dimension(40, 40));
    jButton1.setPreferredSize(new Dimension(40, 40));

    jButton2.addActionListener(this);
    jButton2.setMaximumSize(new Dimension(40, 40));
    jButton2.setMinimumSize(new Dimension(40, 40));
    jButton2.setPreferredSize(new Dimension(40, 40));

    jButton3.addActionListener(this);
    jButton3.setMaximumSize(new Dimension(40, 40));
    jButton3.setMinimumSize(new Dimension(40, 40));
    jButton3.setPreferredSize(new Dimension(40, 40));

    jButton4.addActionListener(this);
    jButton4.setMaximumSize(new Dimension(40, 40));
    jButton4.setMinimumSize(new Dimension(40, 40));
    jButton4.setPreferredSize(new Dimension(40, 40));

    jButton5.addActionListener(this);
    jButton5.setMaximumSize(new Dimension(40, 40));
    jButton5.setMinimumSize(new Dimension(40, 40));
    jButton5.setPreferredSize(new Dimension(40, 40));

    jButton6.addActionListener(this);
    jButton6.setMaximumSize(new Dimension(40, 40));
    jButton6.setMinimumSize(new Dimension(40, 40));
    jButton6.setPreferredSize(new Dimension(40, 40));

    jButton7.addActionListener(this);
    jButton7.setMaximumSize(new Dimension(40, 40));
    jButton7.setMinimumSize(new Dimension(40, 40));
    jButton7.setPreferredSize(new Dimension(40, 40));

    jButton8.addActionListener(this);
    jButton8.setMaximumSize(new Dimension(40, 40));
    jButton8.setMinimumSize(new Dimension(40, 40));
    jButton8.setPreferredSize(new Dimension(40, 40));

    jButton9.addActionListener(this);
    jButton9.setMaximumSize(new Dimension(40, 40));
    jButton9.setMinimumSize(new Dimension(40, 40));
    jButton9.setPreferredSize(new Dimension(40, 40));

    jButton10.addActionListener(this);
    jButton10.setMaximumSize(new Dimension(40, 40));
    jButton10.setMinimumSize(new Dimension(40, 40));
    jButton10.setPreferredSize(new Dimension(40, 40));

    jButton11.addActionListener(this);
    jButton11.setMaximumSize(new Dimension(40, 40));
    jButton11.setMinimumSize(new Dimension(40, 40));
    jButton11.setPreferredSize(new Dimension(40, 40));
    
    
    jButton12.addActionListener(this);
    jButton12.setMaximumSize(new Dimension(40, 40));
    jButton12.setMinimumSize(new Dimension(40, 40));
    jButton12.setPreferredSize(new Dimension(40, 40));

    jButton13.addActionListener(this);
    jButton13.setMaximumSize(new Dimension(40, 40));
    jButton13.setMinimumSize(new Dimension(40, 40));
    jButton13.setPreferredSize(new Dimension(40, 40));

    jButton14.addActionListener(this);
    jButton14.setMaximumSize(new Dimension(40, 40));
    jButton14.setMinimumSize(new Dimension(40, 40));
    jButton14.setPreferredSize(new Dimension(40, 40));

    jButton15.addActionListener(this);
    jButton15.setMaximumSize(new Dimension(40, 40));
    jButton15.setMinimumSize(new Dimension(40, 40));
    jButton15.setPreferredSize(new Dimension(40, 40));
    
    jButton16.addActionListener(this);
    jButton16.setMaximumSize(new Dimension(40, 40));
    jButton16.setMinimumSize(new Dimension(40, 40));
    jButton16.setPreferredSize(new Dimension(40, 40));

    jButton17.addActionListener(this);
    jButton17.setMaximumSize(new Dimension(40, 40));
    jButton17.setMinimumSize(new Dimension(40, 40));
    jButton17.setPreferredSize(new Dimension(40, 40));

    jButton18.addActionListener(this);
    jButton18.setMaximumSize(new Dimension(40, 40));
    jButton18.setMinimumSize(new Dimension(40, 40));
    jButton18.setPreferredSize(new Dimension(40, 40));

    jButton19.addActionListener(this);
    jButton19.setMaximumSize(new Dimension(40, 40));
    jButton19.setMinimumSize(new Dimension(40, 40));
    jButton19.setPreferredSize(new Dimension(40, 40));

    jButton20.addActionListener(this);
    jButton20.setMaximumSize(new Dimension(40, 40));
    jButton20.setMinimumSize(new Dimension(40, 40));
    jButton20.setPreferredSize(new Dimension(40, 40));

    jButton21.addActionListener(this);
    jButton21.setMaximumSize(new Dimension(40, 40));
    jButton21.setMinimumSize(new Dimension(40, 40));
    jButton21.setPreferredSize(new Dimension(40, 40));

    jButton22.addActionListener(this);
    jButton22.setMaximumSize(new Dimension(40, 40));
    jButton22.setMinimumSize(new Dimension(40, 40));
    jButton22.setPreferredSize(new Dimension(40, 40));

    jButton23.addActionListener(this);
    jButton23.setMaximumSize(new Dimension(40, 40));
    jButton23.setMinimumSize(new Dimension(40, 40));
    jButton23.setPreferredSize(new Dimension(40, 40));

    jButton24.addActionListener(this);
    jButton24.setMaximumSize(new Dimension(40, 40));
    jButton24.setMinimumSize(new Dimension(40, 40));
    jButton24.setPreferredSize(new Dimension(40, 40));

    jButton25.addActionListener(this);
    jButton25.setMaximumSize(new Dimension(40, 40));
    jButton25.setMinimumSize(new Dimension(40, 40));
    jButton25.setPreferredSize(new Dimension(40, 40));

    jButton26.addActionListener(this);
    jButton26.setMaximumSize(new Dimension(40, 40));
    jButton26.setMinimumSize(new Dimension(40, 40));
    jButton26.setPreferredSize(new Dimension(40, 40));

    jButton27.addActionListener(this);
    jButton27.setMaximumSize(new Dimension(40, 40));
    jButton27.setMinimumSize(new Dimension(40, 40));
    jButton27.setPreferredSize(new Dimension(40, 40));

    jButton28.addActionListener(this);
    jButton28.setMaximumSize(new Dimension(40, 40));
    jButton28.setMinimumSize(new Dimension(40, 40));
    jButton28.setPreferredSize(new Dimension(40, 40));

    jButton29.addActionListener(this);
    jButton29.setMaximumSize(new Dimension(40, 40));
    jButton29.setMinimumSize(new Dimension(40, 40));
    jButton29.setPreferredSize(new Dimension(40, 40));

    jButton30.addActionListener(this);
    jButton30.setMaximumSize(new Dimension(40, 40));
    jButton30.setMinimumSize(new Dimension(40, 40));
    jButton30.setPreferredSize(new Dimension(40, 40));

    jButton31.addActionListener(this);
    jButton31.setMaximumSize(new Dimension(40, 40));
    jButton31.setMinimumSize(new Dimension(40, 40));
    jButton31.setPreferredSize(new Dimension(40, 40));

    jButton32.addActionListener(this);
    jButton32.setMaximumSize(new Dimension(40, 40));
    jButton32.setMinimumSize(new Dimension(40, 40));
    jButton32.setPreferredSize(new Dimension(40, 40));

    jButton33.addActionListener(this);
    jButton33.setMaximumSize(new Dimension(40, 40));
    jButton33.setMinimumSize(new Dimension(40, 40));
    jButton33.setPreferredSize(new Dimension(40, 40));

    jButton34.addActionListener(this);
    jButton34.setMaximumSize(new Dimension(40, 40));
    jButton34.setMinimumSize(new Dimension(40, 40));
    jButton34.setPreferredSize(new Dimension(40, 40));

    jButton35.addActionListener(this);
    jButton35.setMaximumSize(new Dimension(40, 40));
    jButton35.setMinimumSize(new Dimension(40, 40));
    jButton35.setPreferredSize(new Dimension(40, 40));
    
    jButton36.addActionListener(this);
    jButton36.setMaximumSize(new Dimension(40, 40));
    jButton36.setMinimumSize(new Dimension(40, 40));
    jButton36.setPreferredSize(new Dimension(40, 40));
    
    jButton37.addActionListener(this);
    jButton37.setMaximumSize(new Dimension(40, 40));
    jButton37.setMinimumSize(new Dimension(40, 40));
    jButton37.setPreferredSize(new Dimension(40, 40));

    jButton38.addActionListener(this);
    jButton38.setMaximumSize(new Dimension(40, 40));
    jButton38.setMinimumSize(new Dimension(40, 40));
    jButton38.setPreferredSize(new Dimension(40, 40));

    jButton39.addActionListener(this);
    jButton39.setMaximumSize(new Dimension(40, 40));
    jButton39.setMinimumSize(new Dimension(40, 40));
    jButton39.setPreferredSize(new Dimension(40, 40));

    jButton40.addActionListener(this);
    jButton40.setMaximumSize(new Dimension(40, 40));
    jButton40.setMinimumSize(new Dimension(40, 40));
    jButton40.setPreferredSize(new Dimension(40, 40));

    jButton41.addActionListener(this);
    jButton41.setMaximumSize(new Dimension(40, 40));
    jButton41.setMinimumSize(new Dimension(40, 40));
    jButton41.setPreferredSize(new Dimension(40, 40));

    jButton42.addActionListener(this);
    jButton42.setMaximumSize(new Dimension(40, 40));
    jButton42.setMinimumSize(new Dimension(40, 40));
    jButton42.setPreferredSize(new Dimension(40, 40));

    jButton43.addActionListener(this);
    jButton43.setMaximumSize(new Dimension(40, 40));
    jButton43.setMinimumSize(new Dimension(40, 40));
    jButton43.setPreferredSize(new Dimension(40, 40));

    jButton44.addActionListener(this);
    jButton44.setMaximumSize(new Dimension(40, 40));
    jButton44.setMinimumSize(new Dimension(40, 40));
    jButton44.setPreferredSize(new Dimension(40, 40));

    jButton45.addActionListener(this);
    jButton45.setMaximumSize(new Dimension(40, 40));
    jButton45.setMinimumSize(new Dimension(40, 40));
    jButton45.setPreferredSize(new Dimension(40, 40));

    jButton46.addActionListener(this);
    jButton46.setMaximumSize(new Dimension(40, 40));
    jButton46.setMinimumSize(new Dimension(40, 40));
    jButton46.setPreferredSize(new Dimension(40, 40));

    jButton47.addActionListener(this);
    jButton47.setMaximumSize(new Dimension(40, 40));
    jButton47.setMinimumSize(new Dimension(40, 40));
    jButton47.setPreferredSize(new Dimension(40, 40));

    jButton48.addActionListener(this);
    jButton48.setMaximumSize(new Dimension(40, 40));
    jButton48.setMinimumSize(new Dimension(40, 40));
    jButton48.setPreferredSize(new Dimension(40, 40));

    jButton49.addActionListener(this);
    jButton49.setMaximumSize(new Dimension(40, 40));
    jButton49.setMinimumSize(new Dimension(40, 40));
    jButton49.setPreferredSize(new Dimension(40, 40));

    jButton50.addActionListener(this);
    jButton50.setMaximumSize(new Dimension(40, 40));
    jButton50.setMinimumSize(new Dimension(40, 40));
    jButton50.setPreferredSize(new Dimension(40, 40));

    jButton51.addActionListener(this);
    jButton51.setMaximumSize(new Dimension(40, 40));
    jButton51.setMinimumSize(new Dimension(40, 40));
    jButton51.setPreferredSize(new Dimension(40, 40));

    jButton52.addActionListener(this);
    jButton52.setMaximumSize(new Dimension(40, 40));
    jButton52.setMinimumSize(new Dimension(40, 40));
    jButton52.setPreferredSize(new Dimension(40, 40));

    jButton53.addActionListener(this);
    jButton53.setMaximumSize(new Dimension(40, 40));
    jButton53.setMinimumSize(new Dimension(40, 40));
    jButton53.setPreferredSize(new Dimension(40, 40));

    jButton54.addActionListener(this);
    jButton54.setMaximumSize(new Dimension(40, 40));
    jButton54.setMinimumSize(new Dimension(40, 40));
    jButton54.setPreferredSize(new Dimension(40, 40));

    jButton55.addActionListener(this);
    jButton55.setMaximumSize(new Dimension(40, 40));
    jButton55.setMinimumSize(new Dimension(40, 40));
    jButton55.setPreferredSize(new Dimension(40, 40));

    jButton56.addActionListener(this);
    jButton56.setMaximumSize(new Dimension(40, 40));
    jButton56.setMinimumSize(new Dimension(40, 40));
    jButton56.setPreferredSize(new Dimension(40, 40));

    jButton57.addActionListener(this);
    jButton57.setMaximumSize(new Dimension(40, 40));
    jButton57.setMinimumSize(new Dimension(40, 40));
    jButton57.setPreferredSize(new Dimension(40, 40));

    jButton58.addActionListener(this);
    jButton58.setMaximumSize(new Dimension(40, 40));
    jButton58.setMinimumSize(new Dimension(40, 40));
    jButton58.setPreferredSize(new Dimension(40, 40));

    jButton59.addActionListener(this);
    jButton59.setMaximumSize(new Dimension(40, 40));
    jButton59.setMinimumSize(new Dimension(40, 40));
    jButton59.setPreferredSize(new Dimension(40, 40));

    jButton60.addActionListener(this);
    jButton60.setMaximumSize(new Dimension(40, 40));
    jButton60.setMinimumSize(new Dimension(40, 40));
    jButton60.setPreferredSize(new Dimension(40, 40));

    jButton61.addActionListener(this);
    jButton61.setMaximumSize(new Dimension(40, 40));
    jButton61.setMinimumSize(new Dimension(40, 40));
    jButton61.setPreferredSize(new Dimension(40, 40));

    jButton62.addActionListener(this);
    jButton62.setMaximumSize(new Dimension(40, 40));
    jButton62.setMinimumSize(new Dimension(40, 40));
    jButton62.setPreferredSize(new Dimension(40, 40));

    jButton63.addActionListener(this);
    jButton63.setMaximumSize(new Dimension(40, 40));
    jButton63.setMinimumSize(new Dimension(40, 40));
    jButton63.setPreferredSize(new Dimension(40, 40));

    jButton64.addActionListener(this);
    jButton64.setMaximumSize(new Dimension(40, 40));
    jButton64.setMinimumSize(new Dimension(40, 40));
    jButton64.setPreferredSize(new Dimension(40, 40));

    jButton65.addActionListener(this);
    jButton65.setMaximumSize(new Dimension(40, 40));
    jButton65.setMinimumSize(new Dimension(40, 40));
    jButton65.setPreferredSize(new Dimension(40, 40));

    jButton66.addActionListener(this);
    jButton66.setMaximumSize(new Dimension(40, 40));
    jButton66.setMinimumSize(new Dimension(40, 40));
    jButton66.setPreferredSize(new Dimension(40, 40));

    jButton67.addActionListener(this);
    jButton67.setMaximumSize(new Dimension(40, 40));
    jButton67.setMinimumSize(new Dimension(40, 40));
    jButton67.setPreferredSize(new Dimension(40, 40));

    jButton68.addActionListener(this);
    jButton68.setMaximumSize(new Dimension(40, 40));
    jButton68.setMinimumSize(new Dimension(40, 40));
    jButton68.setPreferredSize(new Dimension(40, 40));

    jButton69.addActionListener(this);
    jButton69.setMaximumSize(new Dimension(40, 40));
    jButton69.setMinimumSize(new Dimension(40, 40));
    jButton69.setPreferredSize(new Dimension(40, 40));

    jButton70.addActionListener(this);
    jButton70.setMaximumSize(new Dimension(40, 40));
    jButton70.setMinimumSize(new Dimension(40, 40));
    jButton70.setPreferredSize(new Dimension(40, 40));

    jButton71.addActionListener(this);
    jButton71.setMaximumSize(new Dimension(40, 40));
    jButton71.setMinimumSize(new Dimension(40, 40));
    jButton71.setPreferredSize(new Dimension(40, 40));

    jButton72.addActionListener(this);
    jButton72.setMaximumSize(new Dimension(40, 40));
    jButton72.setMinimumSize(new Dimension(40, 40));
    jButton72.setPreferredSize(new Dimension(40, 40));
	}
	
	private void initLayout() {
    GroupLayout externalLayout = new GroupLayout(this);
    this.setLayout(externalLayout);
    externalLayout.setHorizontalGroup(
        externalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(externalLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(externalLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                .addComponent(jButton67, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton61, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton55, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton49, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton43, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton37, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton31, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton25, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGroup(externalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton19, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(externalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton14, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton20, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton26, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton32, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton38, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton44, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton50, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton56, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton62, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton68, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(externalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton15, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton21, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton27, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton33, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton39, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton45, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton51, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton57, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton63, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton69, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(externalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton10, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton16, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton22, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton28, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton34, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton40, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton46, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton52, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton58, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton64, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton70, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(externalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton11, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton17, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton23, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton29, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton35, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton41, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton47, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton53, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton59, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton65, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton71, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(externalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addGroup(externalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(externalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton12, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton18, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton24, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton30, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton36, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton42, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton48, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton54, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addComponent(jButton60, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton66, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton72, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    externalLayout.setVerticalGroup(
        externalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(externalLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(externalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGroup(externalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(externalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(jButton10, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton11, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton12, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(externalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(jButton13, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton14, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton15, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton16, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton17, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton18, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(externalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(jButton19, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton20, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton21, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton22, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton23, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton24, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(externalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(jButton25, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton26, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton27, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton28, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton29, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton30, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(externalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(jButton31, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton32, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton33, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton34, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton35, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton36, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(externalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(jButton37, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton38, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton39, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton40, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton41, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton42, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(externalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(jButton43, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton44, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton45, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton46, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton47, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton48, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(externalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(jButton49, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton50, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton51, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton52, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton53, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton54, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(externalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(jButton55, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton56, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton57, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton58, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton59, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton60, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(externalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(jButton61, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton62, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton63, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton64, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton65, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton66, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(externalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(jButton67, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton68, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton69, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton70, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton71, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton72, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    		);
	}
	
	//VARIABILI
	private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;    
    private JButton jButton5;   
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;   
    private JButton jButton9;
    private JButton jButton10;
    private JButton jButton11;
    private JButton jButton12;
    private JButton jButton13;
    private JButton jButton14;
    private JButton jButton15;
    private JButton jButton16;
    private JButton jButton17;
    private JButton jButton18;
    private JButton jButton19;
    private JButton jButton20;
    private JButton jButton21;
    private JButton jButton22;
    private JButton jButton23;
    private JButton jButton24;
    private JButton jButton25;
    private JButton jButton26;
    private JButton jButton27;
    private JButton jButton28;
    private JButton jButton29;
    private JButton jButton30;
    private JButton jButton31;
    private JButton jButton32;
    private JButton jButton33;
    private JButton jButton34;
    private JButton jButton35;
    private JButton jButton36;
    private JButton jButton37;
    private JButton jButton38;
    private JButton jButton39;
    private JButton jButton40;
    private JButton jButton41;
    private JButton jButton42;
    private JButton jButton43;
    private JButton jButton44;
    private JButton jButton45;
    private JButton jButton46;
    private JButton jButton47;
    private JButton jButton48;
    private JButton jButton49;
    private JButton jButton50;
    private JButton jButton51;
    private JButton jButton52;
    private JButton jButton53;
    private JButton jButton54;
    private JButton jButton55;
    private JButton jButton56;
    private JButton jButton57;
    private JButton jButton58;
    private JButton jButton59;
    private JButton jButton60;
    private JButton jButton61;
    private JButton jButton62;
    private JButton jButton63;
    private JButton jButton64;
    private JButton jButton65;
    private JButton jButton66;
    private JButton jButton67;
    private JButton jButton68;
    private JButton jButton69;
    private JButton jButton70;
    private JButton jButton71;
    private JButton jButton72;
}