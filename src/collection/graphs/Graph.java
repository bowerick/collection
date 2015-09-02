package collection.graphs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Graph
{
	private Set<Edge> edges;
	
	private Set<Vertex> vertices;
	
	private Vertex root;

	public Graph()
	{
		edges = new LinkedHashSet<Edge>();
		vertices = new LinkedHashSet<Vertex>();
	}
	
	public Graph(Vertex root)
	{
		this.edges = new HashSet<Edge>();
		this.vertices = new HashSet<Vertex>();
	}
	
	public Graph addEdge(Vertex from,Vertex to)
	{
		Edge edge = new Edge(from,to);
		edges.add(edge);
		return this;
	}
	
	public Graph removeEdge(Edge e)
	{
		edges.remove(e);
		return this;
	}

	
	public Set<Vertex> getNeighbours(Vertex v)
	{
		Set<Vertex> vertices = new LinkedHashSet<Vertex>();
		for(Edge e:edges)
		{
			if(e.getFrom().equals(v))
				vertices.add(e.getTo());
				
		}
		return vertices;
	}
	
	public Graph addVertex(Vertex v)
	{
		vertices.add(v);
		return this;
	}
	
	public Graph removeVertex(Vertex v)
	{
		Iterator<Edge> it = edges.iterator();
		while(it.hasNext())
		{
			Edge e = it.next();
			if(e.getFrom().equals(v) || e.getTo().equals(v))
				it.remove();
		}
		vertices.remove(v);
		return this;
	}
	
	public Vertex getVertex(int vertexNo)
	{
		for(Vertex v:vertices)
			if(v.getName().equals(String.valueOf(vertexNo)))
				return v;
		return null;
	}

	public Vertex getRoot()
	{
		return this.root;
	}

	public void setRoot(Vertex root)
	{
		this.root = root;
	}
	
}
