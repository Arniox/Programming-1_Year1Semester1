package mvctemplate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 * 
 * @author Mark Lanthier
 * @see <a href=
 *      "http://people.scs.carleton.ca/~lanthier/teaching/COMP1406/Notes/Code/Chapter5/">
 *      FruitListApp</a>
 *
 */
public class FruitListApp extends JFrame {


	private FruitList model;
	private FruitListPanel view;


	private void eventHandleListSelection() 
	{

		//do not call update since that would re-initialise the list...
		//instead, specifically update the view of the remove button
		this.view.getRemoveButton().setEnabled(this.view.getFruitList().getSelectedIndex()!=-1);
		

	}

	private void eventHandleKeyReleased(KeyEvent e)
	{
		
		this.view.getAddButton().setEnabled(!this.view.getNewItemField().getText().isEmpty());
		//this.view.update();

	}


	private void eventHandleRemoveButton()
	{
		int index = this.view.getFruitList().getSelectedIndex();
		if(index!=-1)
		{
			this.model.removeFruitItem(index);				
		}
		this.view.update();
	}


	private void eventHandleWindowOpened()
	{
		System.out.println("Window opened!");	
		this.view.update();
	}

	private void eventHandleAddButton()
	{
		String text = this.view.getNewItemField().getText().trim();
		if((!text.isEmpty())&&(!this.model.hasFruitItem(text)))
		{
			this.model.addFruitItem(text);
			this.view.getNewItemField().setText("");
		}
		this.view.update();
	}

	public FruitListApp(String name) {
		super(name);

		this.model = new FruitList();
		this.model.addFruitItem("Apples");
		this.model.addFruitItem("Oranges");

		this.view = new FruitListPanel(this.model);

		//set event listeners for the view here
		this.view.getNewItemField().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				eventHandleKeyReleased(e);
			}
		});

		this.view.getRemoveButton().addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				eventHandleRemoveButton();		
			}
		});


		this.view.getAddButton().addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				eventHandleAddButton();		
			}
		});

		this.view.getFruitList().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				
					eventHandleListSelection();
				
			}

		});


		// Choose to lay out components manually

		//	getContentPane().setLayout(null);
		this.getContentPane().add(this.view);


		// Set program to stop when window closed
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(290, 230); // manually computed sizes
		setResizable(false);

		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowOpened(WindowEvent e) 
			{
				eventHandleWindowOpened();
			}
		});






		/*addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println(e.paramString());

			}	
		});*/


		/*
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println(e.paramString());

			}	
		});*/



	}

	public static void main(String[] args) 
	{

		JFrame frame = new FruitListApp("My Fruit List");
		frame.setVisible(true);
	}





}