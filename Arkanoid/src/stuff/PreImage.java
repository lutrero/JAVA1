package stuff;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class PreImage {
	
	private Image icon;

	public PreImage() {
		super();
		icon = null;
	}

	public PreImage(Image icon) {
		super();
		this.icon = icon;
	}
	
	public PreImage(String name){
		super();
		icon = new ImageIcon(getClass().getResource("/images/" + name)).getImage();
	}

	public Image getIcon() {
		return icon;
	}

	public void setIcon(Image icon) {
		this.icon = icon;
	}
	
	public void setIcon(String name) {
		this.icon = new ImageIcon(getClass().getResource("/images/" + name)).getImage();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((icon == null) ? 0 : icon.hashCode());
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
		return true;
	}
	
	
	
	

}
