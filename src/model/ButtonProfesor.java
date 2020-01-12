package model;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class ButtonProfesor extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, MouseListener {

	private static final long serialVersionUID = 1493557968025874237L;

	private JTable table;
	
	private JButton renderButton;
	private JButton editorButton;
	
	private boolean isEditorActive = false;
	
	public ButtonProfesor(JTable table, int column) {
		this.table = table;
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		this.table.getColumnModel().getColumn(column).setCellEditor(this);
		this.table.addMouseListener(this);
		
		this.renderButton = new JButton("Prikazi");
		this.editorButton = new JButton("Prikazi");
	
		this.editorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
				
			}
		});
		
		this.isEditorActive = false;
	}
	
	
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		return this.editorButton;
	}


	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		return this.renderButton;
	}
	
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		if (table.isEditing() && table.getCellEditor() == this) {
			this.isEditorActive = true;
		}
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		if (isEditorActive && table.isEditing()) {
			table.getCellEditor().stopCellEditing();
		}
		isEditorActive = false;
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	

}


