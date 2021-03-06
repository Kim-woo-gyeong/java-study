package Chaper4;

public class Rect {
	private int width;
	private int heigh;
	
	public Rect(int width, int heigh)
	{
		this.width = width;
		this.heigh = heigh;
	}

	@Override
	public String toString() {
		return "Rect [width=" + width + ", heigh=" + heigh + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + heigh;
		result = prime * result + width;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rect other = (Rect) obj;
		if (heigh != other.heigh)
			return false;
		if (width != other.width)
			return false;
		return true;
	}
	
}
