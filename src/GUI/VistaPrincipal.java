package GUI;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.model.mxICell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.handler.mxVertexHandler;
import com.mxgraph.view.mxGraph;

import Decision.Nodo;

public class VistaPrincipal  extends JFrame{

	
	private static VistaPrincipal instance;
	private mxGraph graph;
	private Nodo arbol;
	
	public static VistaPrincipal getInstance(){
		
		if(instance==null)
			instance= new VistaPrincipal();
	
		return instance;
	}
	
	
	
	public VistaPrincipal(){
		
			super("Algoritmo ID3 por Jose Maria Lopez");
			graph= new mxGraph();
	}
	
	
	
	public void initView(){
		
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		WindowAdapter exitListener = new WindowAdapter() {

		    @Override
		    public void windowClosing(WindowEvent e) {
		        int confirm = JOptionPane.showOptionDialog(
		             null, "¿Quieres salir de la aplicacion?", 
		             "Confirmacion de salida", JOptionPane.YES_NO_OPTION, 
		             JOptionPane.QUESTION_MESSAGE, null, null, null);
		        if (confirm == 0) {
		           System.exit(0);
		        }
		    }
		};
	this.addWindowListener(exitListener);
	

	//PREPARA EL GRAFICO PARA ACTUALIZAR
	graph.getModel().beginUpdate();
	
	try{
		
		
	 recursivoPinta(arbol, graph,null );
	
	}finally{
	   graph.getModel().endUpdate();
	}
	
	graph.setCellsEditable(false);
	
	 mxIGraphLayout layout = new mxHierarchicalLayout(graph);
     layout.execute(graph.getDefaultParent());

      final mxGraphComponent graphComponent = new mxGraphComponent(graph);
      graphComponent.setBackground(Color.WHITE);
	
	getContentPane().add(graphComponent);
	this.setSize(graphComponent.getSize());
	
	}

	private void recursivoPinta(Nodo padre, mxGraph graph, Object verticePadre){
		
		Object v1;
		
		if(verticePadre!=null){
			 v1 = verticePadre;

		}else
		 v1 = graph.insertVertex(graph.getDefaultParent(), null, padre.getNombre(),0, 0, 100,100,  padre.getNombre(), false);
		
		for(Nodo edge: padre.getHijos()){
			
			for(Nodo vertices: edge.getHijos()) {
					
				   Object v2 = graph.insertVertex(graph.getDefaultParent(), null, vertices.getNombre(),0,0,100,100);
				   	graph.insertEdge(graph.getDefaultParent(), null, edge.getNombre(), v1, v2);
				   	if(vertices.getHijos().size()>0)
				   		recursivoPinta(vertices, graph, v2);
				   	
			}
			
		}
		
		
	}


	public void setArbol(Nodo arbol) {
		this.arbol = arbol;
	}
	
	
}
