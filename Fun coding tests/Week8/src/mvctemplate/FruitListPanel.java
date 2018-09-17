package mvctemplate;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class FruitListPanel extends JPanel {

	private FruitList model;
	private JList fruitList;
	private JTextField newItemField;
	private JButton addButton;
	private JButton removeButton;
	
	
	public JList getFruitList()
	{
		return this.fruitList;
	}
	
	public JTextField getNewItemField()
	{
		return this.newItemField;
	}
	
	public JButton getRemoveButton()
	{
		return this.removeButton;
	}

	public JButton getAddButton()
	{
		return this.addButton;
	}

	public FruitListPanel(FruitList model)
	{
		this.model = model;//set the model.
		
		setLayout(null);//Choose to lay out components manually

		this.fruitList = new JList(this.model.getFruitList());
		
		this.fruitList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(fruitList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setLocation(10, 45);
		scrollPane.setSize(150, 150);
		
		this.add(scrollPane);

		//add the input text field...
		this.newItemField = new JTextField("Grapes");
		newItemField.setLocation(10, 10);
		newItemField.setSize(150, 25);
		this.add(newItemField);


		// Add the ADD button
		this.addButton = new JButton("Add");
		addButton.setLocation(175, 10);
		addButton.setSize(100, 25);
		this.add(addButton);



		// Add the REMOVE button
		removeButton = new JButton("Remove");
		removeButton.setLocation(175, 45);
		removeButton.setSize(100, 25);
		this.add(removeButton);


		setSize(290, 230); // manually computed sizes

		this.update();

	}

	//updates the view based on the items stored in the model...
	public void update()
	{
		this.fruitList.setListData(this.model.getFruitList());
		this.addButton.setEnabled(!this.newItemField.getText().isEmpty());
		this.removeButton.setEnabled(this.fruitList.getSelectedIndex()!=-1);
	}

}
