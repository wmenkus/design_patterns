package factory;

import java.util.ArrayList;

public class TinyHomePlan extends HousePlan{
    public TinyHomePlan() {
        super(1, 5, 200);
        materials = new ArrayList<String>();
        setMaterials();
        features = new ArrayList<String>();
        setFeatures();
    }

    protected void setMaterials() {
        materials.add("Lumber");
        materials.add("Insulation");
        materials.add("Metal Roofing");
        materials.add("Hardware");
    }

    protected void setFeatures() {
        features.add("Natural Light");
        features.add("Creative Storage");
        features.add("Multipurpose Areas");
        features.add("Multi-use Applications");
    }

    public String toString() {
        return "Tiny Home\n" + super.toString();
    }

}
