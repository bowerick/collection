package collection.graphs;

public class Edge
{
	private Vertex from;
	
	public Vertex getFrom()
	{
		return this.from;
	}

	public void setFrom(Vertex from)
	{
		this.from = from;
	}

	public Vertex getTo()
	{
		return this.to;
	}

	public void setTo(Vertex to)
	{
		this.to = to;
	}

	private Vertex to;

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.from == null) ? 0 : this.from.hashCode());
		result = prime * result + ((this.to == null) ? 0 : this.to.hashCode());
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
		if (!(obj instanceof Edge))
		{
			return false;
		}
		Edge other = (Edge) obj;
		if (this.from == null)
		{
			if (other.from != null)
			{
				return false;
			}
		}
		else if (!this.from.equals(other.from))
		{
			return false;
		}
		if (this.to == null)
		{
			if (other.to != null)
			{
				return false;
			}
		}
		else if (!this.to.equals(other.to))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "Edge [from=" + this.from + ", to=" + this.to + "]";
	}
	
	public Edge()
	{
		
	}
	
	public Edge(Vertex from,Vertex to)
	{
		this.from = from;
		this.to = to;
	}
}
