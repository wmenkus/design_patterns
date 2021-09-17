package factory;

import java.util.ArrayList;

public class ContemporaryHome extends HousePlan {
    
    public ContemporaryHome() {
        super(5, 40, 3000);
        materials = new ArrayList<String>();
        setMaterials();
        features = new ArrayList<String>();
        setFeatures();
    }

    protected void setMaterials() {
        materials.add("Ceramics");
        materials.add("High-Strength Alloys");
        materials.add("Composites");
    }
    
    protected void setFeatures() {
        features.add("Oversized Windows");
        features.add("Unconventional Roofs");
        features.add("Minimalism");
        features.add("Open Floor Plan");
    }

    public String toString() {
        return "Contemporary Home\n" + super.toString();
    }
}
