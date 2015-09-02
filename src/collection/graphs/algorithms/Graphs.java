package collection.graphs.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import collection.graphs.Graph;
import collection.graphs.Vertex;

public class Graphs
{
	public static void main(String[] args)
	{
		Graph g = new Graph();
		for(int index = 1 ; index <=13 ; index++)
		{
			Vertex v = new Vertex(String.valueOf(index));
			g.addVertex(v);
		}
		g.setRoot(g.getVertex(1));
		g=g.addEdge(g.getVertex(1),g.getVertex(2));
		g=g.addEdge(g.getVertex(1),g.getVertex(3));
		g=g.addEdge(g.getVertex(1),g.getVertex(4));
		g=g.addEdge(g.getVertex(2),g.getVertex(5));
		g=g.addEdge(g.getVertex(2),g.getVertex(6));
		g=g.addEdge(g.getVertex(3),g.getVertex(7));
		g=g.addEdge(g.getVertex(7),g.getVertex(10));
		g=g.addEdge(g.getVertex(10),g.getVertex(11));
		g=g.addEdge(g.getVertex(10),g.getVertex(12));
		g=g.addEdge(g.getVertex(4),g.getVertex(8));
		g=g.addEdge(g.getVertex(4),g.getVertex(5));
		g=g.addEdge(g.getVertex(1),g.getVertex(13));
		
		Graphs graphs = new Graphs();
		//graphs.doBFS(g);
		 System.out.println("==");
		 graphs.levelPrint(g);

		//graphs.doDFS(g);

	}

	public void doBFS(Graph g)
	{
		Vertex root = g.getRoot();
		Queue<Vertex> visited = new LinkedList<Vertex>();
		visited.add(root);
		System.out.println("Visited: "+root.getName());
		while(!visited.isEmpty())
		{
			Vertex v = visited.poll();
			Set<Vertex> neighbours = g.getNeighbours(v);
			for(Vertex u:neighbours)
			{
				if(!u.isVisited())
				{
					u.setVisited(true);
					System.out.println("Visited: "+u.getName());
					visited.add(u);
				}
			}
		}
		
	}

	public void levelPrint(Graph g)
	{
		List<Set<Vertex>> levels = new ArrayList<Set<Vertex>>();
		Vertex root = g.getRoot();
		Set<Vertex> rootLevel = new HashSet<Vertex>();
		rootLevel.add(root);
		levels.add(rootLevel);
		Set<Vertex> firstLevel = g.getNeighbours(root);
		levels.add(firstLevel);
		Queue<Vertex> visited = new LinkedList<Vertex>();
		visited.add(root);
		while(!visited.isEmpty())
		{
			Vertex v = visited.poll();
			Set<Vertex> level = new HashSet<Vertex>();
			for(Vertex u:g.getNeighbours(v))
			{
				if(!u.isVisited())
				{
					u.setVisited(true);
					level.addAll(g.getNeighbours(u));
					visited.add(u);
				}
			}
			if(level.size() > 0)
				levels.add(level);
		}
		
		for(Set<Vertex> level:levels)
		{
			for(Vertex v:level)
			{
				System.out.print(v.getName()+"->");
			}
			System.out.println();
		}
		
	}

	public void doDFS(Graph g)
	{
		Vertex root = g.getRoot();
		Stack<Vertex> visited = new Stack<Vertex>();
		root.setVisited(true);
		visited.add(root);
		while(!visited.empty())
		{
			Vertex v = visited.pop();
			System.out.println("Visited: "+v.getName());
			Set<Vertex> neighbours = g.getNeighbours(v);
			for(Vertex u:neighbours)
			{
				if(!u.isVisited())
				{
					visited.add(u);
				}
					
			}
		}
	}

}
