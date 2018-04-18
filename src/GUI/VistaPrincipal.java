package GUI;

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
	Object parent = graph.getDefaultParent();


	//PREPARA EL GRAFICO PARA ACTUALIZAR
	graph.getModel().beginUpdate();
	
	try{
		
		
	 recursivoPinta(arbol, graph, 50,20 );
	
	}finally{
	   graph.getModel().endUpdate();
	}
	
	  mxIGraphLayout layout = new mxHierarchicalLayout(graph);
      layout.execute(graph.getDefaultParent());

	final mxGraphComponent graphComponent = new mxGraphComponent(graph);
	getContentPane().add(graphComponent);
	
	
	}

	private void recursivoPinta(Nodo padre, mxGraph graph, double x, double y){
		double i=0.5;
		double ubicacionPadre= padre.getHijos().size()*1.5;
		Object v1 = graph.insertVertex(graph.getDefaultParent(), null, padre.getNombre(),0, 0, 100,100,  padre.getNombre(), false);
		
		for(Nodo edge: padre.getHijos()){
			
			for(Nodo vertices: edge.getHijos()) {
					
				   Object v2 = graph.insertVertex(graph.getDefaultParent(), null, vertices.getNombre(),0,0,100,100);
				   	graph.insertEdge(graph.getDefaultParent(), null, edge.getNombre(), v1, v2);
				   	if(vertices.getHijos().size()>0)
				   		recursivoPinta(vertices, graph, x*i, y);
				   	
				   	i+=3.5;
			}
			
		}
		
		
	}


	public void setArbol(Nodo arbol) {
		this.arbol = arbol;
	}
	
	
}
