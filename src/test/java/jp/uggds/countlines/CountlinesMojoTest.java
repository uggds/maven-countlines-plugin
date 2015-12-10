package jp.uggds.countlines;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.junit.Test;

/**
 * @auther uga
 */
public class CountlinesMojoTest {

    @Test
    public void test() throws MojoFailureException, MojoExecutionException {
        CountlinesMojo mojo = new CountlinesMojo();
        mojo.dir = "/Users/uga/Documents/vim-powerline";
        mojo.ext = "rst";
        mojo.execute();
//        File testPom = new File(getBasedir(),"src/test/resources/countlines/pom.xml");
//        CountlinesMojo mojo = null;
//        try {
//            mojo = (CountlinesMojo) lookupMojo("countlines", testPom);
//            String dir = (String) getVariableValueFromObject(mojo, "dir");
//            String ext = (String) getVariableValueFromObject(mojo, "ext");
//            mojo.execute();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

}