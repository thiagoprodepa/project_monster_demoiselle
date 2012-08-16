package br.gov.prodepa.bookmark.ui;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.google.common.collect.Lists;

@ManagedBean(name = "skinBean")
@SessionScoped
public class SkinBean implements Serializable {
    private static final long serialVersionUID = 2744605279708632184L;
    private SelectItem[] skinSetItems = { new SelectItem("prodepa"),new SelectItem("black"), new SelectItem("blueSky"), new SelectItem("classic"), new SelectItem("deepMarine"),
            new SelectItem("DEFAULT"), new SelectItem("emeraldTown"), new SelectItem("japanCherry"), new SelectItem("NULL"),
            new SelectItem("plain"), new SelectItem("ruby"), new SelectItem("wine") };
    
    private String skin = "classic";
    private boolean enableElementsSkinning = true;
    private boolean enableClassesSkinning = false;

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }
    

    /*public List<String> getSkinList() {
      return Lists.newArrayList("Prodepa", "blueSky");//skinSetItems; TODO Obter llista
    }*/
    
    public boolean isEnableElementsSkinning() {
        return enableElementsSkinning;
    }

    public void setSkinSetItems(SelectItem[] skinSetItems) {
		this.skinSetItems = skinSetItems;
	}

	public void setEnableElementsSkinning(boolean enableElementsSkinning) {
        this.enableElementsSkinning = enableElementsSkinning;
    }

    public boolean isEnableClassesSkinning() {
        return enableClassesSkinning;
    }

    public void setEnableClassesSkinning(boolean enableClassesSkinning) {
        this.enableClassesSkinning = enableClassesSkinning;
    }

    public SelectItem[] getSkinSetItems() {
        return skinSetItems;
    }
}
