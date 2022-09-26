package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Interactions extends Base{
    @BeforeClass
    public void preConditions(){
        app.actionH().hideAds();
        app.actionH().hideFooter();
        app.actionH().chooseInteractions();
        app.actionH().hideFooter();
    }
    @Test
    public void sortableList(){
        app.inters().chooseSortable();
        app.inters().sortList("One,Two,Three,Four,Five,Six");
    }
    @Test
    public void selectableGrid(){
        app.inters().chooseSelectable();
        app.inters().selectableGrid("Two,Four,Six,Nine");

    }
}
