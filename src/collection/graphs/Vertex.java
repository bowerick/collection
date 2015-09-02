package collection.graphs;

public class Vertex
{
	private String name;

	private boolean visited;
	
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public boolean isVisited()
	{
		return this.visited;
	}

	public void setVisited(boolean visited)
	{
		this.visited = visited;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (!(obj instanceof Vertex))
		{
			return false;
		}
		Vertex other = (Vertex) obj;
		if (this.name == null)
		{
			if (other.name != null)
			{
				return false;
			}
		}
		else if (!this.name.equals(other.name))
		{
			return false;
		}
		return true;
	}
	
	public Vertex(String name)
	{
		this.name=name;
	}
	
	public Vertex()
	{
		
	}
}
