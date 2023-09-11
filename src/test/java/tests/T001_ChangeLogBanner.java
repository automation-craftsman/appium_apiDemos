package tests;

import base.Base;
import org.testng.annotations.Test;
import support.Commons;

public class T001_ChangeLogBanner extends Base {

    Commons commons = new Commons();

    @Test
    public void testClosingChangeLogBanner(){

        commons.closeChangeLogBanner();

    }
}
