package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrokenLinksHelper extends HelperBase{
    public BrokenLinksHelper(WebDriver wd) {
        super(wd);
    }

    public void chooseElements() {
        click(By.xpath("//h5[.='Elements']"));
    }

    public void chooseBrokenLinks() {
        click(By.xpath("//*[.='Broken Links - Images']"));
    }

    public void checkBrokenLinks() {
        List<WebElement>links = wd.findElements(By.xpath("//a[@href]"));
        System.out.println("Total links on the page-->"+links.size());
        for(WebElement el:links){
            String url = el.getAttribute("href");
            System.out.println("This url-->"+url);
            assertLinkNotBroken();
        }


    }

    private void assertLinkNotBroken() {

    }
}
